package com.lausdahl.ast.creator.utils;

import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.definitions.IClassDefinition.ClassType;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.java.definitions.JavaName;

public class EnumUtil
{
	public static String getEnumElementName(IClassDefinition c)
	{
		return NameUtil.getClassName(c.getName().getRawName().startsWith("#") ? c.getName().getRawName().substring(1)
				: c.getName().getRawName()).toUpperCase();
	}

	public static JavaName getEnumTypeName(IClassDefinition c, Environment env)
	{
		JavaName name = env.getInterfaceForCommonTreeNode(c).getName();
		String enumName;
		if (c == env.node)
		{
			enumName = "NodeEnum" ;
		} else if (env.getClassType(c) == ClassType.Production)
		{

			enumName = "E" + NameUtil.getClassName(name.getRawName());
		} else
		{
			enumName = "E"
					+ NameUtil.getClassName(name.getRawName())
					+ NameUtil.getClassName(env.getInterfaceForCommonTreeNode(c.getSuperDef()).getName().getRawName());
		}

		return new JavaName(c.getName().getPackageName(), "", enumName, "", c.getName().getExtendedName());
	}

	@Deprecated
	public static String getEnumTypeNameNoPostfix(IClassDefinition c,
			Environment env)
	{
		return getEnumTypeName(c, env).getName();
	}
}
