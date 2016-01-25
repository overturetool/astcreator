package org.overture.tools.astcreator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.overture.tools.astcreator.definitions.EnumDefinition;
import org.overture.tools.astcreator.definitions.Field;
import org.overture.tools.astcreator.definitions.Field.AccessSpecifier;
import org.overture.tools.astcreator.definitions.Field.StructureType;
import org.overture.tools.astcreator.definitions.GenericArgumentedIInterfceDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.definitions.InterfaceDefinition;
import org.overture.tools.astcreator.definitions.PredefinedClassDefinition;
import org.overture.tools.astcreator.env.BaseEnvironment;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.java.definitions.JavaName;
import org.overture.tools.astcreator.methods.ConstructorTreeFieldsOnlyMethod;
import org.overture.tools.astcreator.methods.Method;
import org.overture.tools.astcreator.methods.SetMethod;
import org.overture.tools.astcreator.methods.analysis.depthfirst.AnalysisDepthFirstAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.AnalysisAcceptMethod;
import org.overture.tools.astcreator.methods.visitors.AnswerAcceptMethod;
import org.overture.tools.astcreator.methods.visitors.QuestionAcceptMethod;
import org.overture.tools.astcreator.methods.visitors.QuestionAnswerAcceptMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.AnalysisAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.AnalysisAdaptorDefaultMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.AnalysisAdaptorDefaultNodeMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.AnalysisAdaptorDefaultTokenMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.AnalysisMethodTemplate;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.CreateNewReturnValueMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.analysis.MergeReturnMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.answer.AnswerAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.answer.AnswerAdaptorDefaultMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.answer.AnswerAdaptorDefaultNodeMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.answer.AnswerAdaptorDefaultTokenMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.answer.AnswerDepthFirstAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.question.QuestionAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.question.QuestionAdaptorDefaultMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.question.QuestionAdaptorDefaultNodeMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.question.QuestionAdaptorDefaultTokenMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.question.QuestionDepthFirstAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.questionanswer.QuestionAnswerAdaptorCaseMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.questionanswer.QuestionAnswerAdaptorDefaultMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.questionanswer.QuestionAnswerAdaptorDefaultNodeMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.questionanswer.QuestionAnswerAdaptorDefaultTokenMethod;
import org.overture.tools.astcreator.methods.visitors.adaptor.questionanswer.QuestionAnswerDepthFirstAdaptorCaseMethod;
import org.overture.tools.astcreator.utils.ClassFactory;
import org.overture.tools.astcreator.utils.EnumUtil;

public class Generator
{

	// private boolean isBase = false;

	public Environment generate(InputStream toStringFile,
			InputStream inputFile, String envName,
			boolean doTypeHierarchyCheck, boolean isBase) throws IOException,
			AstCreatorException
	{
		Environment env = null;
		// this.isBase = isBase;
		try
		{
			env = new CreateOnParse().parse(inputFile, envName);
			for (IInterfaceDefinition def : env.getAllDefinitions())
				def.setIsBaseTree(isBase);

			if (doTypeHierarchyCheck)
				for (IClassDefinition def : env.getClasses())
				{
					def.checkFieldTypeHierarchy(env);

				}
		} catch (AstCreatorException e)
		{
			if (e.fatal)
			{
				throw e;
			} else
			{
				System.err.println(e.getMessage());
			}
		}

		if (toStringFile != null)
		{
			System.out.println("Generating toString add on...");
			try
			{
				ToStringAddOnReader reader = new ToStringAddOnReader();
				reader.readAndAdd(toStringFile, env);
			} catch (AstCreatorException e)
			{
				if (e.fatal)
				{
					throw e;
				} else
				{
					System.err.println(e.getMessage());
				}
			}
		}
		// SourceFileWriter.write(outputFolder, env1);
		return env;
	}

	public void runPostGeneration(Environment env, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException, AstCreatorException
	{
		System.out.println("Generating enumerations...");
		createNodeEnum(env);
		createProductionEnums(env, isBaseTree);

		// System.out.println("Generating interfaces for nodes");
		// createInterfacesForNodePoints(env);

		System.out.println("Generating analysis visitors...");
		System.out.print("Analysis...");
		createAnalysis(env, isBaseTree);
		// createAnalysisAdaptor(env,analysisPackageName);
		System.out.print("Answer...");
		createAnswer(env, isBaseTree);
		System.out.print("Question...");
		createQuestion(env, isBaseTree);
		System.out.print("Question-Answer...");
		createQuestionAnswer(env, isBaseTree);
		System.out.print("Depth-First...");
		// createdepthFirstAdaptor(env);
		DepthFirstGeneratorConfig dconfig = new DepthFirstGeneratorConfig();
		dconfig.interfaceTag = env.TAG_IAnalysis;
		dconfig.type = "";
		dconfig.genericArguments = new Vector<String>();
		dconfig.defaultMethod = AnalysisAdaptorDefaultMethod.class;
		dconfig.depthfirstCase = AnalysisDepthFirstAdaptorCaseMethod.class;
		dconfig.caseM = AnalysisAdaptorCaseMethod.class;
		dconfig.defaultNode = AnalysisAdaptorDefaultNodeMethod.class;
		dconfig.defaultToken = AnalysisAdaptorDefaultTokenMethod.class;
		createDepthFirstAdaptor(env, dconfig, isBaseTree);

		dconfig.interfaceTag = env.TAG_IAnswer;
		dconfig.type = "Answer";
		dconfig.genericArguments = Arrays.asList(new String[] { "A" });
		dconfig.defaultMethod = AnswerAdaptorDefaultMethod.class;
		dconfig.depthfirstCase = AnswerDepthFirstAdaptorCaseMethod.class;
		dconfig.caseM = AnswerAdaptorCaseMethod.class;
		dconfig.defaultNode = AnswerAdaptorDefaultNodeMethod.class;
		dconfig.defaultToken = AnswerAdaptorDefaultTokenMethod.class;
		dconfig.returnType = "A";
		createDepthFirstAdaptor(env, dconfig, isBaseTree);

		dconfig.interfaceTag = env.TAG_IQuestion;
		dconfig.type = "Question";
		dconfig.genericArguments = Arrays.asList(new String[] { "Q" });
		dconfig.defaultMethod = QuestionAdaptorDefaultMethod.class;
		dconfig.depthfirstCase = QuestionDepthFirstAdaptorCaseMethod.class;
		dconfig.caseM = QuestionAdaptorCaseMethod.class;
		dconfig.defaultNode = QuestionAdaptorDefaultNodeMethod.class;
		dconfig.defaultToken = QuestionAdaptorDefaultTokenMethod.class;
		dconfig.returnType = null;
		createDepthFirstAdaptor(env, dconfig, isBaseTree);

		dconfig.interfaceTag = env.TAG_IQuestionAnswer;
		dconfig.type = "QuestionAnswer";
		dconfig.genericArguments = Arrays.asList(new String[] { "Q", "A" });
		dconfig.defaultMethod = QuestionAnswerAdaptorDefaultMethod.class;
		dconfig.depthfirstCase = QuestionAnswerDepthFirstAdaptorCaseMethod.class;
		dconfig.caseM = QuestionAnswerAdaptorCaseMethod.class;
		dconfig.defaultNode = QuestionAnswerAdaptorDefaultNodeMethod.class;
		dconfig.defaultToken = QuestionAnswerAdaptorDefaultTokenMethod.class;
		dconfig.returnType = "A";
		createDepthFirstAdaptor(env, dconfig, isBaseTree);

		System.out.println();

		// TODO test
		// createQuestionAnswerDepthFirst(env);
		validateClassMethods(env.getClasses());
		validateClassFields(env.getClasses(),env);
	}

	private void validateClassFields(List<IClassDefinition> classes, Environment env) throws AstCreatorException
	{
		for (IClassDefinition cl : classes)
		{
			for (Field f : cl.getFields())
			{
				if(f.getName(env).equals("_class"))
				{
					throw new AstCreatorException("Illegal field name: "+f.getName(env) + " in "+cl.getName(), null,true);
				}
				
			}
		}
	}

	public void createInterfacesForNodePoints(Environment env)
	{
		Set<IClassDefinition> classes = new HashSet<IClassDefinition>();
		for (IClassDefinition c : env.getClasses())
		{
			createInterfacesForNodePoints(env, classes, c);
		}
	}

	private Set<IClassDefinition> createInterfacesForNodePoints(
			Environment env, Set<IClassDefinition> processedClasses,
			IClassDefinition c)
	{
		if (processedClasses.contains(c))
		{
			return processedClasses;
		}

		processedClasses.add(c);

		if (env.isTreeNode(c))
		{
			// CommonTreeClassDefinition ct = (CommonTreeClassDefinition) c;
			switch (env.classToType.get(c))
			{
				case Alternative:
					break;
				case Custom:
					break;
				case Production:
				case SubProduction:
					processedClasses.addAll(createInterfacesForNodePoints(env, processedClasses, c.getSuperDef()));
					InterfaceDefinition intf = new InterfaceDefinition(c.getName().clone(), env.getAstPackage());
					intf.methods.addAll(c.getMethods());
					c.addInterface(intf);
					intf.getName().setPackageName(c.getName().getPackageName()
							+ ".intf");
					intf.getName().setPrefix("I" + intf.getName().getPrefix());
					intf.filterMethodsIfInherited = true;
					intf.supers.add(env.getInterfaceForCommonTreeNode(c.getSuperDef()));
					env.addCommonTreeInterface(c, intf);
					break;
				case Token:
					break;
				case Unknown:
					break;
			}
		}

		return processedClasses;
	}

	private static void createNodeEnum(Environment env)
	{
		EnumDefinition eDef = new EnumDefinition(new JavaName(env.getTemplateDefaultPackage(), "NodeEnum"), env.getAstPackage());
		env.addClass(eDef);
		eDef.elements.add("TOKEN");
		eDef.elements.add("ExternalDefined");
		for (IClassDefinition d : env.getClasses())
		{
			if (env.isTreeNode(d))
			{
				if (env.classToType.get(d) == ClassType.Production)
				{
					eDef.elements.add(EnumUtil.getEnumElementName(d));
				}
			}

		}
	}

	private static void createProductionEnums(Environment env,
			boolean isBaseTree)
	{
		List<EnumDefinition> enums = new Vector<EnumDefinition>();

		for (IClassDefinition d : env.getClasses())
		{
			if (env.isTreeNode(d))
			{
				// CommonTreeClassDefinition c = (CommonTreeClassDefinition) d;
				switch (env.classToType.get(d))
				{
					case Production:
					case SubProduction:
					{
						EnumDefinition eDef = new EnumDefinition(new JavaName(d.getName().getPackageName(), "", EnumUtil.getEnumTypeNameNoPostfix(d, env), ""), env.getAstPackage());
						if (d.isExtTree())
						{
							eDef.setIsBaseTree(false);
						} else
						{
							d.setIsBaseTree(isBaseTree);
						}

						enums.add(eDef);

						for (IClassDefinition sub : getClasses(env.getSubClasses(d), env))
						{
							eDef.elements.add(EnumUtil.getEnumElementName(sub));
						}
					}
						break;
					default:
						break;
				}

			}
		}

		for (EnumDefinition enumDefinition : enums)
		{
			env.addClass(enumDefinition);
		}
	}

	private static void createAnalysis(Environment env, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException
	{

		extendedVisitor(isBaseTree, "Analysis", new Vector<String>(), AnalysisAcceptMethod.class, AnalysisAdaptorCaseMethod.class, AnalysisAdaptorDefaultMethod.class, AnalysisAdaptorDefaultNodeMethod.class, AnalysisAdaptorDefaultTokenMethod.class, env, env.TAG_IAnalysis,null);
	}

	private static void createAnswer(Environment env, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException
	{
		List<String> genericArguments = new Vector<String>();
		genericArguments.add("A");
		extendedVisitor(isBaseTree, "Answer", genericArguments, AnswerAcceptMethod.class, AnswerAdaptorCaseMethod.class, AnswerAdaptorDefaultMethod.class, AnswerAdaptorDefaultNodeMethod.class, AnswerAdaptorDefaultTokenMethod.class, env, env.TAG_IAnswer,"A");
	}

	private static void createQuestion(Environment env, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException
	{
		List<String> genericArguments = new Vector<String>();
		genericArguments.add("Q");
		extendedVisitor(isBaseTree, "Question", genericArguments, QuestionAcceptMethod.class, QuestionAdaptorCaseMethod.class, QuestionAdaptorDefaultMethod.class, QuestionAdaptorDefaultNodeMethod.class, QuestionAdaptorDefaultTokenMethod.class, env, env.TAG_IQuestion,null);
	}

	private static void createQuestionAnswer(Environment env, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException
	{
		List<String> genericArguments = new Vector<String>();
		genericArguments.add("Q");
		genericArguments.add("A");
		extendedVisitor(isBaseTree, "QuestionAnswer", genericArguments, QuestionAnswerAcceptMethod.class, QuestionAnswerAdaptorCaseMethod.class, QuestionAnswerAdaptorDefaultMethod.class, QuestionAnswerAdaptorDefaultNodeMethod.class, QuestionAnswerAdaptorDefaultTokenMethod.class, env, env.TAG_IQuestionAnswer,"A");
	}

	public static void extendedVisitor(boolean isBaseTree, String intfName,
			List<String> genericArguments, Class<? extends Method> accept,
			Class<? extends Method> caseM, Class<? extends Method> defaultCase,
			Class<? extends Method> defaultNodeMethod,
			Class<? extends Method> defaultTokenMethod, Environment env,
			String tag, String returnType) throws InstantiationException, IllegalAccessException
	{
		InterfaceDefinition answerIntf = new InterfaceDefinition(new JavaName(env.getTemplateAnalysisPackage()
				+ ".intf", "I" + intfName), env.getAstPackage());
		answerIntf.setIsBaseTree(isBaseTree);
		answerIntf.setTag(tag);
		answerIntf.setGenericArguments(genericArguments);
		env.addInterface(answerIntf);
//		answerIntf.supers.add(BaseEnvironment.serializableDef);

		for (IClassDefinition c : getClasses(env.getClasses(), env))
		{
			switch (env.classToType.get(c))
			{
				case Alternative:
				case Token:
				{
					Method m = Method.newMethod(accept, c);
					c.addMethod(m);

					m = Method.newMethod(caseM, c);
					answerIntf.methods.add(m);
					break;
				}
				case Production:
				case SubProduction:
				{
					Method m = Method.newMethod(defaultCase, c);
					answerIntf.addMethod(m);
					break;
				}
				default:
					break;
			}
		}
		{
			Method m = Method.newMethod(defaultNodeMethod, null);
			answerIntf.addMethod(m);
			m = Method.newMethod(defaultTokenMethod, null);
			answerIntf.addMethod(m);
		}

		Field thisField = new Field();
		thisField.name = "THIS";

//		GenericArgumentedIInterfceDefinition relaxedAnswerIntf = new GenericArgumentedIInterfceDefinition(answerIntf, GenericArgumentedIInterfceDefinition.generateWildcardArguments(genericArguments));
		thisField.type = answerIntf;
		thisField.structureType = StructureType.Java;
		thisField.isFinal = true;
		thisField.accessspecifier = AccessSpecifier.Protected;

		IClassDefinition answerClass = ClassFactory.createCustom(new JavaName(env.getTemplateAnalysisPackage(), intfName
				+ "Adaptor"), env, thisField);
		answerClass.setIsBaseTree(isBaseTree);
		answerClass.setGenericArguments(answerIntf.getGenericArguments());
		answerClass.addInterface(answerIntf);
		answerClass.setAnnotation("@SuppressWarnings({\"all\"})");
		answerClass.setAbstract(true);

		for (IClassDefinition c : env.getClasses())
		{
			if (env.isTreeNode(c))
			{
				switch (env.classToType.get(c))
				{
					case Alternative:
					case Token:
					{
						Method m = Method.newMethod(caseM, c);
						answerClass.addMethod(m);
					}
						break;
					case SubProduction:
					case Production:
					{
						Method m = Method.newMethod(defaultCase, c);
						answerClass.addMethod(m);
					}
						break;
					case Custom:
						break;
					case Unknown:
						break;

				}
			}
		}

		Method m = Method.newMethod(defaultNodeMethod, null);
		answerClass.addMethod(m);
		m = Method.newMethod(defaultTokenMethod, null);
		answerClass.addMethod(m);
		
		if (returnType!=null)
		{
			answerClass.addMethod(new CreateNewReturnValueMethod(env.iNode, returnType, genericArguments.size() > 1));
			answerClass.addMethod(new CreateNewReturnValueMethod(new PredefinedClassDefinition("", "Object"), returnType, genericArguments.size() > 1));
			answerClass.setAbstract(true);
		}
	}

	public static List<IClassDefinition> getClasses(
			List<IClassDefinition> classList, Environment env)
	{
		List<IClassDefinition> classes = new Vector<IClassDefinition>();
		for (IClassDefinition c : classList)
		{
			if (env.isTreeNode(c))
			{
				classes.add(c);
			}
		}
		return classes;
	}

	private static class DepthFirstGeneratorConfig
	{
		public String interfaceTag;
		public String type;
		public List<String> genericArguments;
		public Class<? extends Method> defaultMethod;
		public Class<? extends Method> depthfirstCase;
		public Class<? extends Method> caseM;
		public Class<? extends Method> defaultNode;
		public Class<? extends Method> defaultToken;
		public String returnType = null;
	}

	private void createDepthFirstAdaptor(Environment source,
			final DepthFirstGeneratorConfig config, boolean isBaseTree)
			throws InstantiationException, IllegalAccessException
	{
		IClassDefinition adaptor = ClassFactory.createCustom(new JavaName(source.getTemplateAnalysisPackage(), "DepthFirstAnalysisAdaptor"
				+ config.type), source);
		adaptor.setIsBaseTree(isBaseTree);
		// adaptor.addInterface(source.getTaggedDef(source.TAG_IAnalysis));

		IInterfaceDefinition implementingInterface = source.getTaggedDef(config.interfaceTag);

		adaptor.addInterface(implementingInterface);
		adaptor.setGenericArguments(config.genericArguments);
		Field queue = new Field();
		queue.name = "visitedNodes";
		queue.accessspecifier = AccessSpecifier.Protected;
		queue.type = new GenericArgumentedIInterfceDefinition(BaseEnvironment.setDef, source.iNode.getName().getName());
		// TODO queue.setCustomInitializer("new java.util.LinkedList<"+source.iNode.getName().getName()+">()");
		queue.setCustomInitializer("new java.util.HashSet<"
				+ source.iNode.getName().getName() + ">()");
		adaptor.addField(queue);
		((InterfaceDefinition) adaptor).imports.add(queue.type);
		adaptor.addMethod(new SetMethod(adaptor, queue));

		Field thisField = new Field();
//		GenericArgumentedIInterfceDefinition relaxedAnswerIntf = new GenericArgumentedIInterfceDefinition(implementingInterface, GenericArgumentedIInterfceDefinition.generateWildcardArguments(config.genericArguments));
		thisField.name = "THIS";
		thisField.type = implementingInterface;
		thisField.structureType = StructureType.Java;
		thisField.isFinal = true;
		thisField.accessspecifier = AccessSpecifier.Protected;

		adaptor.addField(thisField);

		adaptor.setAnnotation("@SuppressWarnings({\"all\"})");
		adaptor.setAbstract(true);

		for (IClassDefinition c : Generator.getClasses(source.getClasses(), source))
		{
			switch (source.classToType.get(c))
			{

				case Custom:
					break;
				case Production:
				case SubProduction:
				{
					AnalysisMethodTemplate mIn = (AnalysisMethodTemplate) Method.newMethod(config.defaultMethod, c);
					mIn.setDefaultPostfix("In");
					adaptor.addMethod(mIn);
					AnalysisMethodTemplate mOut = (AnalysisMethodTemplate) Method.newMethod(config.defaultMethod, c);
					mOut.setDefaultPostfix("Out");
					adaptor.addMethod(mOut);

					AnalysisMethodTemplate mDefault = (AnalysisMethodTemplate) Method.newMethod(config.defaultMethod, c);
					// mOut.setDefaultPostfix("Out");
					adaptor.addMethod(mDefault);
				}
					break;
				case Alternative:
				case Token:
				{
					AnalysisDepthFirstAdaptorCaseMethod m = (AnalysisDepthFirstAdaptorCaseMethod) Method.newMethod(config.depthfirstCase, c);
					m.setVisitedNodesField(queue);
					adaptor.addMethod(m);
				}
					break;
				case Unknown:
					break;
			}

			AnalysisAdaptorCaseMethod mIn = (AnalysisAdaptorCaseMethod) Method.newMethod(config.caseM, c);
			mIn.setMethodNamePrefix("in");
			mIn.setDefaultPostfix("In");
			adaptor.addMethod(mIn);

			AnalysisAdaptorCaseMethod mOut = (AnalysisAdaptorCaseMethod) Method.newMethod(config.caseM, c);
			mOut.setMethodNamePrefix("out");
			mOut.setDefaultPostfix("Out");
			adaptor.addMethod(mOut);
		}
		{
			AnalysisAdaptorDefaultNodeMethod mOut = (AnalysisAdaptorDefaultNodeMethod) Method.newMethod(config.defaultNode, null);
			mOut.setDefaultPostfix("Out");
			adaptor.addMethod(mOut);

			AnalysisAdaptorDefaultNodeMethod mIn = (AnalysisAdaptorDefaultNodeMethod) Method.newMethod(config.defaultNode, null);
			mIn.setDefaultPostfix("In");
			adaptor.addMethod(mIn);

			AnalysisAdaptorDefaultNodeMethod mDefault = (AnalysisAdaptorDefaultNodeMethod) Method.newMethod(config.defaultNode, null);
			// mIn.setDefaultPostfix("In");
			adaptor.addMethod(mDefault);
		}

		{
			AnalysisAdaptorDefaultTokenMethod mOut = (AnalysisAdaptorDefaultTokenMethod) Method.newMethod(config.defaultToken, null);
			mOut.setDefaultPostfix("Out");
			adaptor.addMethod(mOut);

			AnalysisAdaptorDefaultTokenMethod mIn = (AnalysisAdaptorDefaultTokenMethod) Method.newMethod(config.defaultToken, null);
			mIn.setDefaultPostfix("In");
			adaptor.addMethod(mIn);

			AnalysisAdaptorDefaultTokenMethod mDefault = (AnalysisAdaptorDefaultTokenMethod) Method.newMethod(config.defaultToken, null);
			// mIn.setDefaultPostfix("In");
			adaptor.addMethod(mDefault);
		}

		if (config.returnType != null)
		{
			adaptor.addMethod(new MergeReturnMethod(config.returnType));
			adaptor.addMethod(new CreateNewReturnValueMethod(source.iNode, config.returnType, config.genericArguments.size() > 1));
			adaptor.addMethod(new CreateNewReturnValueMethod(new PredefinedClassDefinition("", "Object"), config.returnType, config.genericArguments.size() > 1));
			adaptor.setAbstract(true);
		}
		// FIXME adaptor.getImports().addAll(source.getAllDefinitions());
	}
	
	
	
	/**
	 * validates that only valid combination of methods is contained within each class
	 * @param classes
	 */
	public void validateClassMethods(List<IClassDefinition> classes)
	{
		for (IClassDefinition cls : classes)
		{
			Method treeFieldOnlyConstructor = null;
			if (!hasTreeFields(cls))
			{
				for (Method m : cls.getMethods())
				{
					if (m.getClass() == ConstructorTreeFieldsOnlyMethod.class)
					{
						treeFieldOnlyConstructor = m;
						break;
					}
				}
				cls.getMethods().remove(treeFieldOnlyConstructor);
			}
		}
	}

	/**
	 * Method to check is a class contains a tree field
	 * @param cls
	 * @return
	 */
	private boolean hasTreeFields(IClassDefinition cls)
	{
		for (Field field : cls.getFields())
		{
			if (field.structureType == StructureType.Tree)
				return true;
		}
		return false;
	}

	public void suppressWarnings(Environment env,boolean suppressWarnings)
	{
		for (IClassDefinition cls : env.getClasses())
		{
			cls.setAnnotation("@SuppressWarnings({\"all\"})");
		}
	}
}
