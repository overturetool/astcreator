package org.overture.tools.astcreator.methods.visitors.adaptor.analysis;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.methods.visitors.AnalysisUtil;

public class AnAdCaseMethLeafExtension extends AnalysisAdaptorCaseMethod
{

	public AnAdCaseMethLeafExtension(IClassDefinition c)
	{
		super(c);
	}

	@Override
	protected String getSuperClassForDefault(Environment env, IClassDefinition c)
	{
		return AnalysisUtil.getClass(env, c.getSuperDef().getSuperDef()).getName().getName();
	}

	@Override
	protected String getAlternativeBodyCallPrefix()
	{
		return "default";
	}
}
