package org.overture.tools.astcreator.methods.visitors;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.utils.NameUtil;

public class QuestionAnswerAcceptMethod extends AbstractAcceptMethod
{
	
	@Override
	protected String getAnalysisTag()
	{
		return environment.TAG_IQuestionAnswer;
	}

	@Override
	protected String getAdditionalJavaDocParameters()
	{
		return "\t* @param question the question provided to {@code caller}\n";
	}

	@Override
	protected void retAndArgPrepare(IInterfaceDefinition argDef)
	{
		returnType = "<Q, A> A";
		arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
		arguments.add(new Argument("Q", "question"));
	}

	@Override
	protected String getThenTemplate(IInterfaceDefinition argDefExt, String visitorName)
	{
		return "return (%s)(("
				+ argDefExt.getName().getName()
				+ "<Q,A>)"+visitorName+").case"
				+ AnalysisUtil.getCaseClass(environment, classDefinition).getName().getName()
				+ "(this, question);";
	}

	@Override
	protected String getElseTemplate(String visitorName)
	{
		return "return "+visitorName+".%s%s"+ "(this,question);";
	}
//	public QuestionAnswerAcceptMethod()
//	{
//		super(null);
//	}
//
//	public QuestionAnswerAcceptMethod(IClassDefinition c)
//	{
//		super(c);
//	}
//
//	@Override
//	protected void prepare(Environment env)
//	{
//		IClassDefinition c = classDefinition;
//		StringBuilder sb = new StringBuilder();
//		IInterfaceDefinition argDef = env.getTaggedDef(env.TAG_IQuestionAnswer);
//		
//		if(env instanceof ExtendedEnvironment)
//		{
//			argDef = ((ExtendedEnvironment)env).getTaggedBaseDef(env.TAG_IQuestionAnswer);
//		}
//		
//		sb.append("\t/**\n");
//		sb.append("\t* Calls the {@link "+argDef.getName().getName()+"#case"
//				+ AnalysisUtil.getCaseClass(env, c).getName().getName() + "(" + AnalysisUtil.getCaseClass(env, c).getName().getName()
//				+ ", Object)} of the {@link "+argDef.getName().getName()+"} {@code caller}.\n");
//		sb.append("\t* @param caller the {@link "+argDef.getName().getName()+"} to which this {@link "
//				+ AnalysisUtil.getCaseClass(env, c).getName().getName() + "} node is applied\n");
//		sb.append("\t* @param question the question provided to {@code caller}\n");
//
//		sb.append("\t*/");
//		this.javaDoc = sb.toString();
//		name = "apply";
//		annotation = "@Override";
//		returnType = "<Q, A> A";
//		arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
//		arguments.add(new Argument("Q", "question"));
//		
//		
//		if (!c.isExtTree())
//		{
//			body = "\t\treturn caller.case" + AnalysisUtil.getCaseClass(env, c).getName().getName() + "(this, question);";
//		} else
//		{
//
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IQuestionAnswer);
//			String thenStm = "return (A)(("
//					+ argDefExt.getName().getName()
//					+ "<Q,A>)caller).case"
//					+ AnalysisUtil.getCaseClass(env, c).getName().getName()
//					+ "(this, question);";
//			body = JavaSyntax.createIf(2, "caller instanceof "
//					+ argDefExt.getName().getName(), thenStm, "assert false: \"Invalid use\"; return null;");
//			annotation="@SuppressWarnings(\"unchecked\")\n\t"+annotation;
//		}
//		
//		throwsDefinitions.add(env.analysisException);
//	}
//	
//	@Override
//	public Set<String> getRequiredImports(Environment env)
//	{
//		Set<String> imports = super.getRequiredImports(env);
//
//		if (env instanceof ExtendedEnvironment)
//		{
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IQuestionAnswer);
//			imports.add(argDefExt.getName().getCanonicalName());
//		}
//
//		return imports;
//	}
	
	@Override
	protected void prepareVdm(Environment env)
	{
		optionalVdmArgument=false;
		IClassDefinition c = classDefinition;
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Calls the {@link IQuestionAnswer<Q, A>#case"
				+ c.getName() + "(" + c.getName()
				+ ")} of the {@link IQuestionAnswer<Q, A>} {@code caller}.\n");
		sb.append("\t* @param caller the {@link IQuestionAnswer<Q, A>} to which this {@link "
				+ c.getName() + "} node is applied\n");
		sb.append("\t* @param question the question provided to {@code caller}\n");

		sb.append("\t*/");
		this.javaDoc = sb.toString();
		name = "apply";
		annotation = "/*@Override*/";
		returnType = "?/*<Q, A> A*/";
		arguments.add(new Argument("IQuestionAnswer/*<Q, A>*/", "caller"));
		arguments.add(new Argument("?/*Q*/", "question"));
		body = "\t\treturn caller.case" + c.getName() + "(this, question);";
	}
}
