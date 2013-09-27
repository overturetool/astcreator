package org.overture.tools.astcreator.methods.visitors;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.utils.NameUtil;

public class AnswerAcceptMethod extends AbstractAcceptMethod
{

	@Override
	protected String getAnalysisTag()
	{
		return environment.TAG_IAnswer;
	}

	@Override
	protected String getAdditionalJavaDocParameters()
	{
		return "";
	}

	@Override
	protected void retAndArgPrepare(IInterfaceDefinition argDef)
	{
		returnType = "<A> A";
		arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
	}

	@Override
	protected String getThenTemplate(IInterfaceDefinition argDefExt,
			String visitorName)
	{
		return "return (%s)((" + argDefExt.getName().getName() + "<A>)"
				+ visitorName + ").%s%s" + "(this);";
	}

	@Override
	protected String getElseTemplate(String visitorName)
	{
		return "return " + visitorName + ".%s%s" + "(this);";
	}

	@Override
	protected void prepareVdm(Environment env)
	{
		optionalVdmArgument = false;
		IClassDefinition c = classDefinition;
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Calls the {@link IAnswer<A>#case"
				+ c.getName().getName() + "(" + c.getName().getName()
				+ ")} of the {@link IAnswer<A>} {@code caller}.\n");
		sb.append("\t* @param caller the {@link IAnswer<A>} to which this {@link "
				+ c.getName() + "} node is applied\n");
		sb.append("\t*/");
		this.javaDoc = sb.toString();
		name = "apply";
		annotation = "/*@Override*/";
		returnType = "?/*<A> A*/";
		arguments.add(new Argument("IAnswer/*<A>*/", "caller"));
		body = "\t\treturn caller.case" + c.getName().getName() + "(this);";
	}
}
