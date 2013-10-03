package org.overture.tools.astcreator.tests;

public class SimpleExtentionTest extends AbstractAstCreatorTestCase
{

	public void testBase() throws Exception
	{
		singleFileTest("simple-extention/t1.astv2", "simple-extention");
	}

	public void testExtension() throws Exception
	{
		extensionFileTest("simple-extention/t1.astv2", "simple-extention/t2.astv2", "simple-extention", "Ext");
	}

	public void testSmallExtension() throws Exception
	{
		extensionFileTest("simple-extention/t1.astv2", "simple-extention/t3.astv2", "simple-extention", "Ext");
	}

}
