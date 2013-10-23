package org.overture.tools.astcreator.tests;

import org.overture.tools.astcreator.Display;

public class CmlExtentionDisplayTest extends AbstractAstCreatorTestCase
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
		singleFileTest("cml/new-display/overtureII.astv2", "cml-extention-display");
	}

	public void testExtension() throws Exception
	{
		extensionFileTestNoCompile("cml/new-display/overtureII.astv2", "cml/new-display/cml.ast", "cml-extention-display", "CML");
	}

}
