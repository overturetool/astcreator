package org.overture.tools.astcreator.methods.visitors.adaptor.analysis;

import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;

public class AnalysisAdaptorDefaultNodeMethod extends AnalysisAdaptorDefaultTokenMethod
{
	@Override
	protected IInterfaceDefinition getDefinition(Environment env)
	{
		return env.iNode;
	}
//	public AnalysisAdaptorDefaultNodeMethod()
//	{
//		super(null);
//	}
//
//	@Override
//	public Set<String> getRequiredImports(Environment env)
//	{
//		Set<String> temp = super.getRequiredImports(env);
//		temp.add(classDefinition.getName().getCanonicalName());
//		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
//		return temp;
//	}
//
//	@Override
//	public Set<String> getRequiredImportsSignature(Environment env)
//	{
//		Set<String> temp = super.getRequiredImportsSignature(env);
//		temp.add(classDefinition.getName().getCanonicalName());
//		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
//		return temp;
//	}
//
//	@Override
//	protected void prepare(Environment env)
//	{
//		super.prepare(env);
//		setClassDefinition(env.iNode);
//		IClassDefinition c = classDefinition;
//		StringBuilder sb = new StringBuilder();
//		sb.append("\t/**\n");
//		sb.append("\t* Called by the {@link " + c.getName().getName()
//				+ "} node from {@link " + c.getName().getName() + "#apply("
//				+ env.getTaggedDef(env.TAG_IAnalysis).getName().getName()
//				+ ")}.\n");
//		sb.append("\t* @param node the calling {@link " + c.getName().getName()
//				+ "} node\n");
//		sb.append("\t*/");
//		this.javaDoc = sb.toString();
//		this.name = "default" + defaultPostFix
//				+ NameUtil.getClassName(c.getName().getName());
//		setupArguments(env);
//		// this.annotation="@override";
//
//		this.body = getBody();
//
//	}
//
//	protected String getBody()
//	{
//		if (addReturnToBody)
//		{
//			return "\t\treturn createNewReturnValue("
//					+ getAdditionalBodyCallArguments() + ");\n";
//		} else
//		{
//			return "\t\t" + (addReturnToBody ? "return null;" : "")
//					+ "//nothing to do";
//		}
//	}
}
