package org.overture.tools.astcreator.methods.visitors;

import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.utils.NameUtil;

public class AnalysisAcceptMethod extends AbstractAcceptMethod
{

	@Override
	protected String getAnalysisTag()
	{
		return environment.TAG_IAnalysis;
	}

	@Override
	protected String getAdditionalJavaDocParameters()
	{
		return "";
	}

	@Override
	protected void retAndArgPrepare(IInterfaceDefinition argDef)
	{
		arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
	}

	@Override
	protected String getThenTemplate(IInterfaceDefinition argDefExt,
			String visitorName)
	{
		return "(("
				+ argDefExt.getName().getName()
				+ ")"
				+ visitorName
				+ ").case"
				+ AnalysisUtil.getCaseClass(environment, classDefinition).getName().getName()
				+ "(this);";
	}

	@Override
	protected String getElseTemplate(String visitorName)
	{
		return visitorName + ".%s%s" + "(this);";
	}
}
