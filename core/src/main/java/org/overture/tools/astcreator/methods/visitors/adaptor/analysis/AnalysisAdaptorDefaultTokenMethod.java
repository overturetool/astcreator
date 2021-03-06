package org.overture.tools.astcreator.methods.visitors.adaptor.analysis;

import java.util.Set;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.utils.NameUtil;

public class AnalysisAdaptorDefaultTokenMethod extends AnalysisMethodTemplate
{
	public AnalysisAdaptorDefaultTokenMethod()
	{
		super(null);
	}
	
	protected IInterfaceDefinition getDefinition(Environment env)
	{
		return env.iToken;
	}

	@Override
	public Set<String> getRequiredImports(Environment env)
	{
		Set<String> temp = super.getRequiredImports(env);
		temp.add(getDefinition(env).getName().getCanonicalName());
		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
		return temp;
	}

	@Override
	public Set<String> getRequiredImportsSignature(Environment env)
	{
		Set<String> temp = super.getRequiredImportsSignature(env);
		temp.add(getDefinition(env).getName().getCanonicalName());
		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
		return temp;
	}

	@Override
	protected void prepare(Environment env)
	{
		super.prepare(env);
		intf = getDefinition(env);
		if(intf instanceof IClassDefinition)
		{
			setClassDefinition((IClassDefinition) intf);
		}
		IInterfaceDefinition c = intf;
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Called by the {@link " + c.getName().getName()
				+ "} node from {@link " + c.getName().getName() + "#apply("
				+ env.getTaggedDef(env.TAG_IAnalysis).getName().getName()
				+ ")}.\n");
		sb.append("\t* @param node the calling {@link " + c.getName().getName()
				+ "} node\n");
		sb.append("\t*/");
		this.javaDoc = sb.toString();
		this.name = "default" + defaultPostFix
				+ NameUtil.getClassName(c.getName().getName());
		setupArguments(env);

		this.body = getBody();

	}

	protected String getBody()
	{
		if (addReturnToBody)
		{
			return "\t\treturn createNewReturnValue("
					+ getAdditionalBodyCallArguments() + ");";
		} else
		{
			return "\t\t" + (addReturnToBody ? "return null;" : "")
					+ "//nothing to do";
		}
	}
}
