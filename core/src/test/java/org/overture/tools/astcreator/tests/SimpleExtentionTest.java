package org.overture.tools.astcreator.tests;

public class SimpleExtentionTest extends AbstractAstCreatorTestCase
{

	public void testBase() throws Exception
	{
		singleFileTest("simple-extention/t1.astv2", "simple-extention-base");
	}

	public void testExtension() throws Exception
	{
		singleFileTest("simple-extention/t1.astv2", "simple-extention-ext");
		extensionFileTest("simple-extention/t1.astv2", "simple-extention/t2.astv2", "simple-extention-ext", "Ext");
	}

	public void testSmallExtension() throws Exception
	{
		singleFileTest("simple-extention/t1.astv2", "simple-extention-ext-small");
		extensionFileTest("simple-extention/t1.astv2", "simple-extention/t3.astv2", "simple-extention-ext-small", "Ext");
	}

}
