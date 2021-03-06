package org.overture.tools.astcreator.methods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.overture.tools.astcreator.definitions.Field;
import org.overture.tools.astcreator.definitions.Field.StructureType;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.utils.NameUtil;

public class ConstructorMethod extends Method
{
	private boolean deprecated;

	public ConstructorMethod(IClassDefinition c, boolean deprecated)
	{
		super(c);
		isConstructor = true;
		this.deprecated = deprecated;
	}

	@Override
	protected void prepare(Environment env)
	{
		skip = classDefinition.getFields().isEmpty();
		this.name = classDefinition.getName().getName();

		this.returnType = "";

		StringBuilder sbDoc = new StringBuilder();
		sbDoc.append("\t");
		sbDoc.append("/**\n");
		sbDoc.append("\t");
		sbDoc.append("* Creates a new complete constructor {@code "
				+ classDefinition.getName().getName()
				+ "} node with the given nodes as children.\n");
		if (deprecated)
		{
			sbDoc.append("\t");
			sbDoc.append("* @deprecated This method should not be used, use AstFactory instead.\n");
		}
		sbDoc.append("\t");
		sbDoc.append("* The basic child nodes are removed from their previous parents.\n");

		StringBuilder sb = new StringBuilder();

		sb.append("\t\tsuper(");
		List<Field> fields = new Vector<Field>();
		fields.addAll(classDefinition.getInheritedFields());
		skip = skip && fields.isEmpty();
		for (Field f : fields)
		{
			if (classDefinition.refinesField(f.getName(env), env))
			{
				// This field is refined in the sub class, so skip it and null the super class field.
				sb.append("null,");
			} else
			{
				String name = f.getName(env).replaceAll("_", "") + "_";
				this.arguments.add(new Argument(f.getMethodArgumentType(env), name));
				sb.append(name + ",");
			}
		}
		if (!fields.isEmpty())
		{
			sb.delete(sb.length() - 1, sb.length());
		}
		sb.append(");\n");

		for (Field f : classDefinition.getFields())
		{
			String name = f.getName(env).replaceAll("_", "");
			this.arguments.add(new Argument(f.getMethodArgumentType(env), name
					+ "_"));

			sb.append("\t\t");

			if (f.structureType == StructureType.Java)
			{
				sb.append("this." + f.getName(env) + " = ");
				sb.append(name + "_");
				sb.append(";\n");
			} else
			{

				sb.append("this.set");
				sb.append(NameUtil.javaClassName(f.getName(env)));
				sb.append("(");
				sb.append(name + "_");
				sb.append(");\n");
			}

			if (f.structureType == StructureType.Tree)
			{
				sbDoc.append("\t* @param " + name + "_ the {@link "
						+ NameUtil.stripGenerics(f.getType(env))
						+ "} node for the {@code " + name
						+ "} child of this {@link "
						+ classDefinition.getName().getName() + "} node\n");
			} else
			{
				sbDoc.append("\t* @param "
						+ name
						+ "_ the {@link "
						+ NameUtil.stripGenerics(f.getType(env))
						+ "} <b>graph</a> node for the {@code "
						+ name
						+ "} child of this {@link "
						+ classDefinition.getName().getName()
						+ "} node.\n\t*  <i>The parent of this {@code "
						+ name
						+ " } will not be changed by adding it to this node.</i>\n");

			}
		}

		sbDoc.append("\t*/");
		this.javaDoc = sbDoc.toString();
		this.body = sb.toString();
	}

	@Override
	public String toString()
	{
		if (classDefinition.getFields().isEmpty())
		{
			return "";
		}
		return super.toString();
	}

	@Override
	public Set<String> getRequiredImports(Environment env)
	{
		Set<String> list = new HashSet<String>();
		list.addAll(super.getRequiredImports(env));
		if (env.isTreeNode(classDefinition))
		{

			List<Field> fields = new Vector<Field>();

			fields.addAll(classDefinition.getInheritedFields());
			for (Field field : fields)
			{

				if (classDefinition.refinesField(field.getName(env), env))
				{
					continue;
				}

				list.addAll(field.getRequiredImports(env));
				if (field.isList && !field.isDoubleList)
				{
					list.add(Environment.listDef.getName().getCanonicalName());
				}
				if (field.isDoubleList)
				{
					list.add(Environment.collectionDef.getName().getCanonicalName());
					list.add(Environment.listDef.getName().getCanonicalName());
				}
			}

			List<String> removeImportsFromSuper = new Vector<String>();
			removeImportsFromSuper.add(env.graphNodeList.getName().getCanonicalName());
			removeImportsFromSuper.add(env.graphNodeListList.getName().getCanonicalName());
			removeImportsFromSuper.add(env.nodeList.getName().getCanonicalName());
			removeImportsFromSuper.add(env.nodeListList.getName().getCanonicalName());

			list.removeAll(removeImportsFromSuper);

			for (Field field : classDefinition.getFields())
			{
				list.addAll(field.getRequiredImports(env));
				if (field.isList && !field.isDoubleList)
				{
					list.add(Environment.listDef.getName().getCanonicalName());
				}
				if (field.isDoubleList)
				{
					list.add(Environment.collectionDef.getName().getCanonicalName());
					list.add(Environment.listDef.getName().getCanonicalName());
				}
			}
		}

		String nodelistpackage = env.nodeList.getName().getCanonicalName();
		list.remove(nodelistpackage);

		return list;
	}

}
