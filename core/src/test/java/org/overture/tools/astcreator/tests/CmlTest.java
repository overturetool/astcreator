package org.overture.tools.astcreator.tests;


public class CmlTest extends AbstractAstCreatorTestCase
{

	public void testCmlExtension() throws Exception
	{
		extensionFileTestNoCompile("overtureII.astv2", "cml/cml.ast", "cml", "CML");
	}

	public void testCmlExtendsOverture() throws Exception
	{
		extensionFileTestNoCompile("cmlextendsovertureII/ovt/overtureII.astv2", "cmlextendsovertureII/cml/cml.ast", "rwlGeneratedCode", "CML");
	}

}
