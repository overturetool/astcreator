package org.overture.tools.astcreator.methods;

import org.overture.tools.astcreator.definitions.Field;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.env.Environment;

public class DefaultConstructorMethod extends Method
{
	public DefaultConstructorMethod(IClassDefinition c)
	{
		super(c);
		isConstructor = true;
	}

	@Override
	protected void prepare(Environment env)
	{
		IClassDefinition c = classDefinition;
		this.name = c.getName().getName();
		this.returnType = "";

		javaDoc = "\t/**\n";
		javaDoc += "\t * Creates a new {@link " + c.getName().getName()
				+ "} node with no children.\n";
		javaDoc += "\t */";

		StringBuilder sb = new StringBuilder();

//		sb.append("\t\tsuper(");
//
//		for (Iterator<Field> iterator = classDefinition.getInheritedFields().iterator(); iterator.hasNext();)
//		{
//			Field f = (Field) iterator.next();
//			if (f.isFinal)
//			{
//				sb.append("null");
//				if (iterator.hasNext())
//				{
//					sb.append(",");
//				}
//			}
//		}
//		sb.append(");\n");

		for (Field f : classDefinition.getFields())
		{
			if (f.isFinal)
			{
				sb.append("\t\tthis." + f.getName(env) + "=this;\n");
			}
		}
		this.body = sb.toString();
	}
}
