package org.overture.tools.astcreator.methods.visitors.adaptor.analysis;

import java.util.Set;

import org.overture.tools.astcreator.definitions.ExternalJavaClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.methods.visitors.AnalysisUtil;
import org.overture.tools.astcreator.utils.NameUtil;

public class AnalysisAdaptorCaseMethod extends AnalysisMethodTemplate
{
	private String methodNamePrefix = "case";

	public AnalysisAdaptorCaseMethod()
	{
		super(null);
	}

	public AnalysisAdaptorCaseMethod(IClassDefinition c)
	{
		super(c);

	}

	@Override
	public Set<String> getRequiredImports(Environment env)
	{
		Set<String> temp = super.getRequiredImports(env);
		temp.add(AnalysisUtil.getClass(env, classDefinition).getName().getCanonicalName());
		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
		return temp;
	}

	@Override
	public Set<String> getRequiredImportsSignature(Environment env)
	{
		Set<String> temp = super.getRequiredImportsSignature(env);
		temp.add(AnalysisUtil.getClass(env, classDefinition).getName().getCanonicalName());
		temp.add(env.getTaggedDef(env.TAG_IAnalysis).getName().getCanonicalName());
		return temp;
	}

	@Override
	protected void prepare(Environment env)
	{
		super.prepare(env);
		IClassDefinition c = classDefinition;
		// CommonTreeClassDefinition cd = (CommonTreeClassDefinition) c;
		StringBuilder sb = new StringBuilder();
		sb.append("\t/**\n");
		sb.append("\t* Called by the {@link "
				+ AnalysisUtil.getClass(env, c).getName().getName()
				+ "} node from {@link "
				+ AnalysisUtil.getClass(env, c).getName().getName() + "#apply("
				+ env.getTaggedDef(env.TAG_IAnalysis).getName().getName()
				+ ")}.\n");
		sb.append("\t* @param node the calling {@link "
				+ AnalysisUtil.getClass(env, c).getName().getName()
				+ "} node\n");
		sb.append("\t*/");
		this.javaDoc = sb.toString();
		this.name = methodNamePrefix
				+ NameUtil.getClassName(AnalysisUtil.getCaseClass(env, c).getName().getName());
		setupArguments(env);
		// this.annotation="@override";
		if (c.getSuperDef() != null
				&& !(c instanceof ExternalJavaClassDefinition))
		{

			String elseCaseMethodName = "default";
		
			String methodCall="";
			
			switch (env.classToType.get(c))
			{
				case Production:
				case SubProduction:
					methodCall += defaultPostFix
							+ AnalysisUtil.getClass(env, c).getSuperDefs().iterator().next().getName().getName();
					break;
				case Token:
					methodCall += defaultPostFix
							+ AnalysisUtil.getClass(env, c).getName().getName();
					break;
				case Alternative:
				{
					
					if(env.classToType.get(c.getSuperDef()) == ClassType.Alternative)
					{
						elseCaseMethodName = getAlternativeBodyCallPrefix();	
					}
					
					methodCall += defaultPostFix
							+ getSuperClassForDefault(env, c);
					break;
				}
				default:
					methodCall += c.getSuperDef().getName().getName();
					break;
			}
			this.body = "\t\t" + (addReturnToBody ? "return " : "") +elseCaseMethodName+methodCall;
			// + NameUtil.getClassName(c.getSuperDef().getName().getName()

			this.body += "(" + getAdditionalBodyCallArguments() + ");";
		} else if (c instanceof ExternalJavaClassDefinition
				&& ((ExternalJavaClassDefinition) c).extendsNode)
		{
			this.body = "\t\t" + (addReturnToBody ? "return " : "") + "default"
					+ defaultPostFix + env.iNode.getName().getName();
			this.body += "(" + getAdditionalBodyCallArguments() + ");";
		} else
		{
			this.body = "" + (addReturnToBody ? "\t\treturn null;" : "");
		}
	}

	protected String getAlternativeBodyCallPrefix()
	{
		return "case";
	}

	protected String getSuperClassForDefault(Environment env, IClassDefinition c)
	{
		return AnalysisUtil.getClass(env, c.getSuperDef()).getName().getName();
	}

	public void setMethodNamePrefix(String nm)
	{
		this.methodNamePrefix = nm;
	}

}
