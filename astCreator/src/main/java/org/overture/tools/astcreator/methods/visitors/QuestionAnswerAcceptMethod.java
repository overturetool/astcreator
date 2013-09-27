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
