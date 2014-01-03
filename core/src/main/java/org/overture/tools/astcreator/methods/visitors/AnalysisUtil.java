package org.overture.tools.astcreator.methods.visitors;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.definitions.PredefinedClassDefinition;
import org.overture.tools.astcreator.env.Environment;

public class AnalysisUtil
{

	public static IInterfaceDefinition getClass(Environment env,
			IClassDefinition c)
	{
		if (env.isTreeNode(c))
		{
			switch (env.classToType.get(c))
			{
				case Production:
				case SubProduction:
					return env.getInterfaceForCommonTreeNode(c);
				case Token:
					return env.iToken;
				default:
					break;
			}
		}
		return c;
	}

	public static IInterfaceDefinition getCaseClass(Environment env,
			IClassDefinition c)
	{
		if (env.isTreeNode(c))
		{
			switch (env.classToType.get(c))
			{
				case Production:
				case SubProduction:
					return env.getInterfaceForCommonTreeNode(c);
				default:
					break;
			}
		}

		if (c instanceof PredefinedClassDefinition
				&& !c.getInterfaces().isEmpty())
		{
			// this will be node and token
			return c.getInterfaces().iterator().next();
		}

		return c;
	}

}
