package com.lausdahl.ast.creator.methods.visitors;

import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.definitions.IInterfaceDefinition;
import com.lausdahl.ast.creator.env.Environment;

public class AnalysisUtil
{

	public static IInterfaceDefinition getClass(Environment env,
			IClassDefinition c)
	{
		if (env.isTreeNode(c))
		{
			switch (env.getClassType(c))
			{
				case Production:
				case SubProduction:
					return env.getInterfaceForCommonTreeNode(c);
				case Token:
//					if (c instanceof ExternalJavaClassDefinition)
//					{
						return env.iToken;
//					} else
//					{
//						return env.getInterfaceForCommonTreeNode(c.getSuperDef());
//					}
			}
		}
		return c;
	}
	
	
	public static IInterfaceDefinition getCaseClass(Environment env,
			IClassDefinition c)
	{
		if (env.isTreeNode(c))
		{
			switch (env.getClassType(c))
			{
				case Production:
				case SubProduction:
					return env.getInterfaceForCommonTreeNode(c);
				
			}
		}
		return c;
	}

}
