package org.overture.tools.astcreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.java.definitions.JavaName;

public class Display
{
	public static boolean quiet = true;
	public static boolean useJavaNames = false;
	
	
	public static void showExtendedOverview(Environment env)
	{
		showOverview(env,true);
	}

	public static void showOverview(Environment env)
	{
		showOverview(env,false);
	}
	
	private static void showOverview(Environment env,boolean isExtended)
	{
		if(quiet)
		{
			return;
		}
		
		Map<IClassDefinition, List<IClassDefinition>> hieracy = new HashMap<IClassDefinition, List<IClassDefinition>>();
		for (IClassDefinition d : env.classToType.keySet())
		{
			insert(d, env, hieracy);
		}
		display(hieracy,env,isExtended);
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
					hieracy.put(d, new Vector<IClassDefinition>());
				}
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
				return;
			}
			case Custom:
			case Token:
			case Unknown:
			default:
				//ignore
				break;

		}
	}
	
	private static void display(
			Map<IClassDefinition, List<IClassDefinition>> hieracy,Environment env, boolean isExtended)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("====================================================================\n");
		for (Entry<IClassDefinition, List<IClassDefinition>> en : hieracy.entrySet())
		{
			if(env.classToType.get(en.getKey())==ClassType.Production)
			{
				if(isExtended && en.getKey().isBaseTree())
				{
					boolean skip = true;
					for (IClassDefinition c : en.getValue())
					{
						skip &= c.isBaseTree();
					}
					if(skip)
					{
						continue;
					}
				}
				showSub(hieracy, sb, en.getKey(),en.getValue(),0,isExtended);
				sb.append("\n");
			}
		}
		sb.append("====================================================================\n");
		
		System.out.println(sb);
		
	}
	
	private static String getName(JavaName name)
	{
		if(useJavaNames)
		{
			return name.getName();
		}
		return name.getRawName();
	}

	public static void showSub(
			Map<IClassDefinition, List<IClassDefinition>> hieracy,
			StringBuilder sb, IClassDefinition d, List<IClassDefinition> childs,int indent, boolean isExtended)
	{
		sb.append(indent(indent,getName(d.getName()))+"\n");
		if(!childs.isEmpty())
		{
			List<IClassDefinition> simple = new Vector<IClassDefinition>();
			List<IClassDefinition> subRoots = new Vector<IClassDefinition>();
			for (IClassDefinition c : childs)
			{
				if(hieracy.containsKey(c))
				{
					subRoots.add(c);
				}else
				{
					simple.add(c);
				}
			}
			
			for (IClassDefinition s : simple)
			{
				if(isExtended && s.isBaseTree())
				{
					continue;
				}
				sb.append(indent(indent+1,getName( s.getName()))+"\n");
			}
			
			for (IClassDefinition s : subRoots)
			{
				showSub(hieracy, sb, s,hieracy.get(s), indent+1,isExtended);
			}
		}
	}
	
	private static String indent(int i,String text)
	{
		StringBuilder sb = new StringBuilder();
		while(i>0)
		{
			sb.append("\t");
			i--;
		}
		return sb.toString()+text;
	}

	

}
