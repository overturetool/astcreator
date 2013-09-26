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
		arguments.add(new Argument(NameUtil.getGenericName(argDef), "analysis"));
	}

	@Override
	protected String getThenTemplate(IInterfaceDefinition argDefExt, String visitorName)
	{
		return "(("
				+ argDefExt.getName().getName()
				+ ")"+visitorName+").case"
				+ AnalysisUtil.getCaseClass(environment, classDefinition).getName()
						.getName() + "(this);";
	}

	@Override
	protected String getElseTemplate(String visitorName)
	{
		return visitorName+".%s%s"+ "(this);";
	}
//	public AnalysisAcceptMethod()
//	{
//		super(null);
//	}
//
//	public AnalysisAcceptMethod(IClassDefinition c,Environment env)
//	{
//		super(c);
//	}
//
//	@Override
//	protected void prepare(Environment env)
//	{
//		IClassDefinition c = classDefinition;
//		IInterfaceDefinition argDef = env.getTaggedDef(env.TAG_IAnalysis);
//		
//		if(env instanceof ExtendedEnvironment)
//		{
//			argDef = ((ExtendedEnvironment)env).getTaggedBaseDef(env.TAG_IAnalysis);
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("\t/**\n");
//		sb.append("\t* Calls the {@link "+argDef.getName().getName()+"#case" + AnalysisUtil.getCaseClass(env, c).getName().getName() + "("
//				+ c.getName().getName()
//				+ ")} of the {@link "+argDef.getName().getName()+"} {@code analysis}.\n");
//		sb.append("\t* @param analysis the {@link "+argDef.getName().getName()+"} to which this {@link "
//				+ c.getName().getName() + "} node is applied\n");
//		sb.append("\t*/");
//		this.javaDoc = sb.toString();
//		name = "apply";
//		annotation = "@Override";
//		arguments.add(new Argument(NameUtil.getGenericName(argDef), "analysis"));
//		
//		if(!c.isExtTree())
//		{
//			body =  "\t\tanalysis.case" + AnalysisUtil.getCaseClass(env, c).getName().getName() + "(this);";
//		}else
//		{
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IAnalysis);
//			String thenStm = "(("
//					+ argDefExt.getName().getName()
//					+ ")analysis).case"
//					+ AnalysisUtil.getCaseClass(env, c).getName()
//							.getName() + "(this);";
//			body = JavaSyntax.createIf(2, "analysis instanceof "+argDefExt.getName().getName(), thenStm, "assert false: \"Invalid use\";");
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
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IAnalysis);
//			imports.add(argDefExt.getName().getCanonicalName());
//		}
//
//		return imports;
//	}
//	
//	
//	@Override
//	protected void prepareVdm(Environment env)
//	{
//		super.prepareVdm(env);
//		optionalVdmArgument = false;
//	}
}
