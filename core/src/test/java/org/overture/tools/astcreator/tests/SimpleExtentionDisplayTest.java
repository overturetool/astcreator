package org.overture.tools.astcreator.tests;

import org.overture.tools.astcreator.Display;

public class SimpleExtentionDisplayTest extends AbstractAstCreatorTestCase
{

	@Override
	protected void setUp() throws Exception
	{
		Display.quiet = false;
		Display.useJavaNames = false;
	}

	@Override
	protected void tearDown() throws Exception
	{
		Display.quiet = true;
	}

	public void testBase() throws Exception
	{
		singleFileTest("simple-extention/show/t1.astv2", "simple-extention-display");
	}

	public void testExtension() throws Exception
	{
		extensionFileTestNoCompile("simple-extention/show/t1.astv2", "simple-extention/show/t2.astv2", "simple-extention-display", "Ext");
	}

}
