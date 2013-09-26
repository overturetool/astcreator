package org.overture.tools.astcreator.methods.visitors;

import java.util.Set;

import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.env.ExtendedEnvironment;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.methods.Method;
import org.overture.tools.astcreator.methods.Method.Argument;
import org.overture.tools.astcreator.utils.JavaSyntax;
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
	protected String getThenTemplate(IInterfaceDefinition argDefExt, String visitorName)
	{
		return "return (%s)((" + argDefExt.getName().getName()
				+ "<A>)"+visitorName+").%s%s"
				+ "(this);";
	}

	@Override
	protected String getElseTemplate(String visitorName)
	{
		return "return "+visitorName+".%s%s"+ "(this);";
	}
//
//	public AnswerAcceptMethod()
//	{
//		super(null);
//	}
//
//	public AnswerAcceptMethod(IClassDefinition c)
//	{
//		super(c);
//	}
//
//	@Override
//	protected void prepare(Environment env)
//	{
//		IClassDefinition c = classDefinition;
//		StringBuilder sb = new StringBuilder();
//		IInterfaceDefinition argDef = env.getTaggedDef(env.TAG_IAnswer);
//		
//		if(env instanceof ExtendedEnvironment)
//		{
//			argDef = ((ExtendedEnvironment)env).getTaggedBaseDef(env.TAG_IAnswer);
//		}
//		
//		sb.append("\t/**\n");
//		sb.append("\t* Calls the {@link "+argDef.getName().getName()+"#case" + AnalysisUtil.getCaseClass(env, c).getName().getName() + "("
//				+ AnalysisUtil.getCaseClass(env, c).getName().getName() + ")} of the {@link "+argDef.getName().getName()+"} {@code caller}.\n");
//		sb.append("\t* @param caller the {@link "+argDef.getName().getName()+"} to which this {@link "
//				+ AnalysisUtil.getCaseClass(env, c).getName().getName() + "} node is applied\n");
//		sb.append("\t*/");
//		this.javaDoc = sb.toString();
//		name = "apply";
//		annotation = "@Override";
//		returnType = "<A> A";
//		arguments.add(new Argument(NameUtil.getGenericName(argDef), "caller"));
//		
//		if (!c.isExtTree())
//		{
//			body = "\t\treturn caller.case"
//					+ AnalysisUtil.getCaseClass(env, c).getName().getName()
//					+ "(this);";
//		} else
//		{
//
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IAnswer);
//			
//			final String TEMPLATE = "return (A)((" + argDefExt.getName().getName()
//					+ "<A>)caller).%s%s"
//					+ "(this);";
//			
//			final String TEMPLATE_ELSE = "return caller.%s%s"
//					+ "(this);";
//			
//			String thenStm = String.format(TEMPLATE, "case",
//					 AnalysisUtil.getCaseClass(env, c).getName().getName());
//			
//			IClassDefinition superDef = c.getSuperDef();
//			while(superDef!=null && superDef.isExtTree())
//			{
//				superDef = superDef.getSuperDef();
//			}
//			
//			String elseStm = String.format(TEMPLATE_ELSE, "default",
//					 AnalysisUtil.getCaseClass(env, superDef).getName().getName());
//			
//			body = JavaSyntax.createIf(2, "caller instanceof "
//					+ argDefExt.getName().getName(), thenStm, elseStm/*"assert false: \"Invalid use\"; return null;"*/);
//			annotation="@SuppressWarnings(\"unchecked\")\n\t"+annotation;
//		}
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
//			IInterfaceDefinition argDefExt = env.getTaggedDef(env.TAG_IAnswer);
//			imports.add(argDefExt.getName().getCanonicalName());
//		}
//
//		return imports;
//	}
	
	@Override
	protected void prepareVdm(Environment env)
	{
		optionalVdmArgument = false;
		IClassDefinition c = classDefinition;
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Calls the {@link IAnswer<A>#case" + c.getName().getName() + "("
				+ c.getName().getName() + ")} of the {@link IAnswer<A>} {@code caller}.\n");
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
