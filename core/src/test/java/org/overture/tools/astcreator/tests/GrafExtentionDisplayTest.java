package org.overture.tools.astcreator.tests;

import org.overture.tools.astcreator.Display;

public class GrafExtentionDisplayTest extends AbstractAstCreatorTestCase
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
		singleFileTest("grafext/t1.astv2", "grafext-display-base");
	}

	public void testExtension() throws Exception
	{
		singleFileTest("grafext/t1.astv2", "grafext-display-ext");
		extensionFileTest("grafext/t1.astv2", "grafext/t2.astv2", "grafext-display-ext", "graf");
	}

}
