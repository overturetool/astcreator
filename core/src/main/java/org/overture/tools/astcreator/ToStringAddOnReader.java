package org.overture.tools.astcreator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.overture.tools.astcreator.ToStringAddOn.ToStringPart.ToStringPartType;
import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.definitions.IClassDefinition.ClassType;
import org.overture.tools.astcreator.definitions.IInterfaceDefinition;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.astcreator.parser.AstcToStringLexer;
import org.overture.tools.astcreator.parser.AstcToStringParser;
import org.overture.tools.astcreator.parser.AstcToStringParser.root_return;
import org.overture.tools.astcreator.utils.NameUtil;

public class ToStringAddOnReader
{
	public void readAndAdd(InputStream file, Environment env)
			throws IOException, AstCreatorException
	{

		ANTLRInputStream input = new ANTLRInputStream(file);
		AstcToStringLexer lexer = new AstcToStringLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		AstcToStringParser parser = new AstcToStringParser(tokens);
		root_return result = null;
		try
		{
			result = parser.root();
		} catch (Exception e)
		{
			throw new AstCreatorException("Exception in AST To String parser", e, true);
		}

		if (parser.hasErrors() || parser.hasExceptions())
		{
			throw new AstCreatorException("Errors in AST To String Extension input file", null, true);
		}

		try
		{
			CommonTree t = (CommonTree) result.getTree();

			show(t, 0);
			ToStringAddOn envAddon = new ToStringAddOn();
			env.addToStringAddOn(envAddon);

			for (Object root : t.getChildren())
			{
				if (root instanceof CommonTree)
				{
					CommonTree node = (CommonTree) root;
					if (node != null && node.getText() != null
							&& node.getText().equals("To String Extensions"))
					{
						if (node.getChildren() != null)
						{

							for (Object toke : node.getChildren())
							{
								if (toke instanceof CommonTree)
								{
									CommonTree p = (CommonTree) toke;

									if (p.getText() != null
											&& p.getText().equals("import"))
									{
										ToStringAddOn.ToStringPart part = new ToStringAddOn.ToStringPart();
										part.type = ToStringPartType.Import;
										part.content = p.getChild(0).getText();
										part.setLocation(p.getChild(0));
										envAddon.parts.add(part);
										continue;
									}

									// String classDefName = "P"
									// +
									// BaseClassDefinition.firstLetterUpper(p.getText());
									String classDefName = getNameFromAspectNode((CommonTree) p.getChild(0));
									IClassDefinition c = lookup(env, classDefName);
									if (c == null)
									{
										System.err.println("Failed to lookup tostring addition with "
												+ p + classDefName+ " @ line "+p.getLine()+" "+p.getTokenStartIndex()+":"+p.getTokenStopIndex());
										continue;

									}
									boolean firstName = true;
									if (p.getChildCount() > 0)
									{
										ToStringAddOn addon = new ToStringAddOn();
										for (Object aspectDcl : p.getChildren())
										{
											if (firstName)
											{
												firstName = false;
												continue;
											}

											if (aspectDcl instanceof CommonTree)
											{
												CommonTree aspectDclT = (CommonTree) aspectDcl;
												if (((CommonTree) aspectDcl).getText().equals("="))
												{
													continue;
												}

												ToStringAddOn.ToStringPart part = new ToStringAddOn.ToStringPart();

												if (aspectDclT.getText().startsWith("\""))
												{
													part.type = ToStringPartType.String;
												} else if (aspectDclT.getText().startsWith("$"))
												{
													part.type = ToStringPartType.RawJava;
												} else if (aspectDclT.getText().equals("+"))
												{
													part.type = ToStringPartType.Plus;
												} else
												{
													part.type = ToStringPartType.Field;
												}

												part.content = aspectDclT.getText();
												part.setLocation(aspectDclT);
												addon.parts.add(part);

											}
										}
										c.addToStringAddOn(addon);
									}

									println("To String Extensions: " + p);
								}

							}
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new AstCreatorException("Exception in AST To String parser", e, true);
		}
	}

	private IClassDefinition lookup(Environment env, String classDefName)
	{
		IClassDefinition c = env.lookUp(classDefName);
		if (c == null)
		{
			// now look for a P or S node
			IInterfaceDefinition intf = env.lookUpInterface(classDefName);
			if (intf != null)
			{
				for (IClassDefinition d : env.getClasses())
				{
					// todo multiple classes may implement the interface, but
					// really this should not occur
					if (d.getInterfaces().contains(intf))
					{
						return d;// just return the first
					}
				}
			}
		}
		return c;
	}

	public static void show(CommonTree token, int level)
	{
		String indent = "";
		for (int i = 0; i < level; i++)
		{
			indent += "  ";
		}

		println(indent + token.getText());
		if (token.getChildCount() > 0)
		{
			for (Object chld : token.getChildren())
			{
				if (chld instanceof CommonTree)
				{
					show((CommonTree) chld, level + 1);
				}
			}
		}
		if (level == 2)
			println();
	}

	private static void println(String text)
	{
		if (Main.test)
		{
			System.out.println(text);
		}
	}

	private static void println()
	{
		if (Main.test)
		{
			System.out.println();
		}
	}

	public static String getNameFromAspectNode(CommonTree p)
	{
		String topName = CreateOnParse.unfoldName(p);

		String[] names = topName.split("->");

		List<String> nns = Arrays.asList(names);
		Collections.reverse(nns);

		ClassType type = ClassType.Unknown;
		String name = null;
		for (String s : nns)
		{
			if (name == null)
			{
				if (s.startsWith("#"))
				{
					type = ClassType.SubProduction;
					name = "S";
				} else
				{
					name = "A";
				}
			}
			name += NameUtil.getClassName(s.replace("#", ""));
		}

		switch (type)
		{
			case SubProduction:
				name += "Base";
				break;
			default:
				break;
		}

		return name;
	}

}
