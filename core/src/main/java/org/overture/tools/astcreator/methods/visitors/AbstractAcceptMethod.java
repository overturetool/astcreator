package org.overture.tools.astcreator.methods.visitors;

import java.util.Iterator;
import java.util.Set;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.env.ExtendedEnvironment;
import org.overture.tools.astcreator.methods.Method;
import org.overture.tools.astcreator.utils.JavaSyntax;

public abstract class AbstractAcceptMethod extends Method
{
	Environment environment;

	public AbstractAcceptMethod()
	{
		super(null);
	}

	public AbstractAcceptMethod(IClassDefinition c, Environment env)
	{
		super(c);
	}

	protected abstract String getAnalysisTag();

	protected abstract String getAdditionalJavaDocParameters();

	protected abstract void retAndArgPrepare(IInterfaceDefinition argDef);

	protected abstract String getThenTemplate(IInterfaceDefinition argDefExt,
			String visitorName);

	protected abstract String getElseTemplate(String visitorName);
	
	protected String getJavaDoc(String argName, String caseClassName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Calls the {@link " + argName
				+ "#case"
				+ caseClassName + "("
				+ caseClassName
				+ ")} of the {@link " + argName
				+ "} {@code caller}.\n");
		sb.append("\t* @param caller the {@link " + argName
				+ "} to which this {@link "
				+ caseClassName
				+ "} node is applied\n");
		sb.append(getAdditionalJavaDocParameters());
		sb.append("\t*/");
		return sb.toString();
	}
	
	protected String getJavaDocQuestion(String argName, String caseClassName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Calls the {@link " + argName
				+ "#case"
				+ caseClassName + "("
				+ caseClassName
				+ ", Object)} of the {@link " + argName
				+ "} {@code caller}.\n");
		sb.append("\t* @param caller the {@link " + argName
				+ "} to which this {@link "
				+ caseClassName
				+ "} node is applied\n");
		sb.append(getAdditionalJavaDocParameters());
		sb.append("\t*/");
		return sb.toString();
	}

	@Override
	protected void prepare(Environment env)
	{
		environment = env;
		IClassDefinition c = classDefinition;
		
		IInterfaceDefinition argDef = env.getTaggedDef(getAnalysisTag());

		if (env instanceof ExtendedEnvironment)
		{
			argDef = ((ExtendedEnvironment) env).getTaggedBaseDef(getAnalysisTag());
		}

		
		this.javaDoc = getJavaDoc(argDef.getName().getName(),AnalysisUtil.getCaseClass(env, c).getName().getName());
		name = "apply";
		annotation = "@Override";
		// returnType = "<A> A";
		// arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
		retAndArgPrepare(argDef);

		String visitorName = arguments.get(0).name;
		boolean isVoid = returnType.endsWith("void");

		if (!c.isExtTree())
		{
			String parameters = "this";

			Iterator<Argument> iterator = arguments.iterator();
			iterator.next();
			for (; iterator.hasNext();)
			{
				String name = iterator.next().name;
				parameters += "," + name;
			}

			body = "\t\t" + (!isVoid ? "return " : "") + visitorName + ".case"
					+ AnalysisUtil.getCaseClass(env, c).getName().getName()
					+ "(" + parameters + ");";
		} else
		{

			IInterfaceDefinition argDefExt = env.getTaggedDef(getAnalysisTag());

			IClassDefinition superDef = c.getSuperDef();
			while (superDef != null && superDef.isExtTree())
			{
				superDef = superDef.getSuperDef();
			}

			String thenStm = null;
			String elseStm = null;

			final String TEMPLATE = getThenTemplate(argDefExt, visitorName);// "return (A)((" +
																			// argDefExt.getName().getName() +
																			// "<A>)"+visitorName+").%s%s(this);";

			final String TEMPLATE_ELSE = getElseTemplate(visitorName);// "return "+visitorName+".%s%s"+ "(this);";

			if (isVoid)
			{
				thenStm = String.format(TEMPLATE, "case", AnalysisUtil.getCaseClass(env, c).getName().getName());
			} else
			{
				String strippedRetType = returnType.substring(returnType.lastIndexOf(' ')).trim();
				thenStm = String.format(TEMPLATE, strippedRetType, "case", AnalysisUtil.getCaseClass(env, c).getName().getName());
			}

			elseStm = String.format(TEMPLATE_ELSE, "default", AnalysisUtil.getCaseClass(env, superDef).getName().getName());

			body = JavaSyntax.createIf(2, visitorName + " instanceof "
					+ argDefExt.getName().getName(), thenStm, elseStm/* "assert false: \"Invalid use\"; return null;" */);

			if (returnType.contains("<"))
			{
				annotation = "@SuppressWarnings(\"unchecked\")\n\t"
						+ annotation;
			}
		}
		throwsDefinitions.add(env.analysisException);
	}

	@Override
	public Set<String> getRequiredImports(Environment env)
	{
		Set<String> imports = super.getRequiredImports(env);

		if (env instanceof ExtendedEnvironment)
		{
			IInterfaceDefinition argDefExt = env.getTaggedDef(getAnalysisTag());
			imports.add(argDefExt.getName().getCanonicalName());
		}

		return imports;
	}

	@Override
	protected void prepareVdm(Environment env)
	{
		super.prepareVdm(env);
		optionalVdmArgument = false;
	}
}
