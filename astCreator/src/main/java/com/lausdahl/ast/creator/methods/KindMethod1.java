package com.lausdahl.ast.creator.methods;

import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.utils.EnumUtil;

public class KindMethod1 extends Method
{
	IClassDefinition superClass;
	Environment superEnv;
	private boolean isAbstractKind;

	public KindMethod1(IClassDefinition c, Environment env,
			IClassDefinition superClass, Environment superEnv)
	{
		super(c, env);
		this.superClass = superClass;
		this.superEnv = superEnv;
		this.isAbstractKind = false;
	}

	public KindMethod1(IClassDefinition c, Environment env)
	{
		super(c, env);
		this.isAbstractKind = true;
	}

	@Override
	protected void prepare()
	{
		if (isAbstractKind)// (c.getType() == ClassType.Production)
		{
			this.isAbstract = true;
			this.name = "kind"
					+ env.getInterfaceForCommonTreeNode(classDefinition).getName().getName();
			this.returnType = EnumUtil.getEnumTypeName(classDefinition, env).getName();
		} else
		{
			if (superEnv.isTreeNode(superClass))
			{
				String enumerationName = EnumUtil.getEnumTypeName(superClass, superEnv).getName();
				this.name = "kind"
						+ superEnv.getInterfaceForCommonTreeNode(superClass).getName().getName();
				this.returnType = enumerationName;
				this.annotation = "@Override";
				this.body = "\t\treturn " + enumerationName + "."
						+ EnumUtil.getEnumElementName(classDefinition) + ";";
			}
		}

		javaDoc = "\t/**\n";
		javaDoc += "\t * Returns the {@link " + this.returnType
				+ "} corresponding to the\n";
		javaDoc += "\t * type of this {@link " + this.returnType + "} node.\n";
		javaDoc += "\t * @return the {@link " + this.returnType
				+ "} for this node\n";
		javaDoc += "\t */";
	}

	@Override
	protected void prepareVdm()
	{
		skip = true;
	}
}
