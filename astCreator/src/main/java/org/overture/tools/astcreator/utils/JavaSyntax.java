package org.overture.tools.astcreator.utils;

public class JavaSyntax
{

	public static String createIf(int indent,String condition, String thenStm, String elseStm)
	{
		String ifStm =  indent(indent)+"if("+ condition+")\n";
		ifStm+=indent(indent)+"{\n"+indent(indent+1)+thenStm+"\n"+indent(indent)+"}";
		if(elseStm!=null)
		{
			ifStm+="else\n"+indent(indent)+"{\n"+indent(indent+1)+elseStm+"\n"+indent(indent)+"}";
		}
		return ifStm;
	}
	
	public static String indent(int indent)
	{
		String tmp ="";
		while(indent-->0)
		{
			tmp+="\t";
		}
		return tmp;
	}

}
