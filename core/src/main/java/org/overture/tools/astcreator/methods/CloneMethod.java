package org.overture.tools.astcreator.methods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.overture.tools.astcreator.definitions.ExternalEnumJavaClassDefinition;
import org.overture.tools.astcreator.definitions.ExternalJavaClassDefinition;
import org.overture.tools.astcreator.definitions.Field;
import org.overture.tools.astcreator.definitions.Field.StructureType;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.definitions.JavaTypes;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.utils.NameUtil;

public class CloneMethod extends Method
{
	ClassType classType;

	@Override
	protected void prepare(Environment env)
	{
		IClassDefinition c = classDefinition;
		this.name = "clone";

		this.returnType = getSpecializedTypeName(c, env);

		StringBuilder sbDoc = new StringBuilder();
		sbDoc.append("\t/**\n");
		sbDoc.append("\t * Returns a deep clone of this {@link "
				+ c.getName().getName() + "} node.\n");
		sbDoc.append("\t * @return a deep clone of this {@link "
				+ c.getName().getName() + "} node\n");
		sbDoc.append("\t */");
		StringBuilder sb = new StringBuilder();

		List<Field> fields = new Vector<Field>();

		for (Field field : classDefinition.getInheritedFields())
		{
			if (!classDefinition.refinesField(field.getName(env), env))
			{
				fields.add(field);
			}
		}

		fields.addAll(c.getFields());

		switch (classType)
		{
			case Production:
			case SubProduction:
				this.annotation = "@Override";
				this.isAbstract = true;
				break;
			case Alternative:
			case Custom:

			case Unknown:
				sb.append("\t\treturn new " + c.getName().getName() + "(\n");

				if (!fields.isEmpty())
				{
					String tmp = "";
					for (Field f : fields)
					{
						String name = f.getName(env);

						if (classDefinition.isRefinedField(f, env))
						{
							name = f.getCast(env) + name;
						}

						if (f.structureType == StructureType.Graph)
						{
							tmp += ("\t\t\t" + name + ",\n");
						} else if (f.isList && !f.isDoubleList)
						{
							tmp += ("\t\t\tcloneList"
									+ (f.isTypeExternalNotNode() ? "External"
											: "") + "(" + name + "),\n");
						} else if (f.isDoubleList)
						{
							tmp += ("\t\t\tcloneListList(" + name + "),\n");
						} else
						{
							if (JavaTypes.isPrimitiveType(f.getType(env))
									|| f.type instanceof ExternalEnumJavaClassDefinition|| (f.type instanceof ExternalJavaClassDefinition &&!((ExternalJavaClassDefinition)f.type).extendsNode))
							{
								tmp += ("\t\t\t" + name + ",\n");
							} else
							{
								tmp += ("\t\t\tcloneNode(" + name + "),\n");
							}
						}
					}
					sb.append(tmp.substring(0, tmp.length() - 2) + "\n");
				}

				sb.append("\t\t);");
				break;

			case Token:
				sb.append("\t\treturn new " + c.getName().getName() + "( ");

				if (!fields.isEmpty())
				{
					String tmp = "";
					for (Field f : fields)
					{
						String name = f.getName(env);

						if (classDefinition.isRefinedField(f, env))
						{
							name = f.getCast(env) + name;
						}

						tmp += ("get" + NameUtil.getClassName(name) + "(), ");
					}
					sb.append(tmp.substring(0, tmp.length() - 2));
				}

				sb.append(");");

				break;

		}

		this.javaDoc = sbDoc.toString();
		this.body = sb.toString();
	}

	public CloneMethod(IClassDefinition c, ClassType classType)
	{
		super(c);
		this.classType = classType;
	}

	@Override
	public Set<String> getRequiredImports(Environment env)
	{
		Set<String> imports = new HashSet<String>();
		imports.addAll(super.getRequiredImports(env));
		for (Field f : classDefinition.getInheritedFields())
		{
			if (classDefinition.isRefinedField(f, env))
			{
				imports.addAll(f.getRequiredImports(env));
			}
		}
		return imports;
	}

	@Override
	protected void prepareVdm(Environment env)
	{
		skip = true;
	}
}
