package org.overture.tools.astcreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.definitions.PredefinedClassDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.java.definitions.JavaName;

public class Display
{
	public static boolean quiet = true;
	public static boolean useJavaNames = false;
	public static boolean flatten = false;

	public static void showExtendedOverview(Environment env)
	{
		showOverview(env, true);
	}

	public static void showOverview(Environment env)
	{
		showOverview(env, false);
	}

	private static void showOverview(Environment env, boolean isExtended)
	{
		if (quiet)
		{
			return;
		}

		Map<IClassDefinition, List<IClassDefinition>> hieracy = new HashMap<IClassDefinition, List<IClassDefinition>>();
		for (IClassDefinition d : env.classToType.keySet())
		{
			insert(d, env, hieracy);
		}
		display(hieracy, env, isExtended);
	}

	private static void insert(IClassDefinition d, Environment env,
			Map<IClassDefinition, List<IClassDefinition>> hieracy)
	{
		switch (env.classToType.get(d))
		{
			case Alternative:
			{
				insert(d.getSuperDef(), env, hieracy);
				hieracy.get(d.getSuperDef()).add(d);
				return;
			}

			case Production:
			{
				if (!hieracy.containsKey(d))
				{
					if (!(d.getSuperDef() instanceof PredefinedClassDefinition))
					{
						insert(d.getSuperDef(), env, hieracy);
						hieracy.get(d.getSuperDef()).add(d);
					}
					hieracy.put(d, new Vector<IClassDefinition>());
				}
				// else
				// {
				// System.out.println(d);
				// }
				return;
			}
			case SubProduction:
			{
				if (!hieracy.containsKey(d))
				{
					insert(d.getSuperDef(), env, hieracy);
					hieracy.get(d.getSuperDef()).add(d);

					hieracy.put(d, new Vector<IClassDefinition>());
				}
				// else
				// {
				// insert(d.getSuperDef(), env, hieracy);
				// hieracy.get(d.getSuperDef()).add(d);
				// }
				return;
			}
			case Custom:
			case Token:
			case Unknown:
			default:
				// ignore
				break;

		}
	}

	private static void display(
			Map<IClassDefinition, List<IClassDefinition>> hieracy,
			Environment env, boolean isExtended)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("====================================================================\n");
		for (Entry<IClassDefinition, List<IClassDefinition>> en : hieracy.entrySet())
		{
			if (env.classToType.get(en.getKey()) == ClassType.Production)
			{
				// if (isPureBaseTree(hieracy, en.getKey())
				// || !(en.getKey().getSuperDef() instanceof PredefinedClassDefinition))
				if (isFiltered(en.getKey(), hieracy))
				{
					continue;
				}

				showSub(hieracy, sb, en.getKey(), en.getValue(), 0, isExtended);
				sb.append("\n");
			}
		}
		sb.append("====================================================================\n");

		System.out.println(sb);

	}

	static boolean isFiltered(IClassDefinition d,
			Map<IClassDefinition, List<IClassDefinition>> hieracy)
	{
		return (isPureBaseTree(hieracy, d) || !(d.getSuperDef() instanceof PredefinedClassDefinition));
	}

	static boolean isPureBaseTree(
			Map<IClassDefinition, List<IClassDefinition>> hieracy,
			IClassDefinition c)
	{
		boolean skip = true;
		if (hieracy.containsKey(c))
		{
			for (IClassDefinition child : hieracy.get(c))
			{
				skip &= isPureBaseTree(hieracy, child);
			}
		}

		return c.isBaseTree() && skip;
	}

	private static String getName(IClassDefinition d, boolean isExtended)
	{
		JavaName name = d.getName();
		String text = "";
		if (useJavaNames)
		{
			text = name.getName();
		} else
		{
			text = name.getRawName();
		}

		if (isExtended && d.isBaseTree())
		{
			text = "[" + text + "]";
		}

		return text;
	}

	public static void showSub(
			Map<IClassDefinition, List<IClassDefinition>> hieracy,
			StringBuilder sb, IClassDefinition d,
			List<IClassDefinition> childs, int indent, boolean isExtended)
	{
		if(flatten && d.isExtTree() && !(d.getSuperDef() instanceof PredefinedClassDefinition) && d.getSuperDef().isBaseTree())
		{
			indent--;
		}else
		{
			sb.append(indent(indent, getName(d, isExtended)) + "\n");
		}
		
		if (!childs.isEmpty())
		{
			List<IClassDefinition> simple = new Vector<IClassDefinition>();
			List<IClassDefinition> subRoots = new Vector<IClassDefinition>();
			for (IClassDefinition c : childs)
			{
				if (hieracy.containsKey(c))
				{
					subRoots.add(c);
				} else
				{
					simple.add(c);
				}
			}

			for (IClassDefinition s : simple)
			{
				 if (isExtended && s.isBaseTree())
//				if (isFiltered(s, hieracy))
				{
					continue;
				}
				sb.append(indent(indent + 1, getName(s, isExtended)) + "\n");
			}

			for (IClassDefinition s : subRoots)
			{
				if(isExtended && isPureBaseTree(hieracy, s)){
					continue;
				}
				showSub(hieracy, sb, s, hieracy.get(s), indent + 1, isExtended);
			}
		}
	}

	private static String indent(int i, String text)
	{
		StringBuilder sb = new StringBuilder();
		while (i > 0)
		{
			sb.append("\t");
			i--;
		}
		return sb.toString() + text;
	}

}
