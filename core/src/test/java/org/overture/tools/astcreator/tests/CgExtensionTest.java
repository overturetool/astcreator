package org.overture.tools.astcreator.tests;

public class CgExtensionTest extends AbstractAstCreatorTestCase
{

	public void test() throws Exception
	{
		singleFileTest("cgextend/cg.astv2", "cgextend");
		extensionFileTest("cgextend/cg.astv2", "cgextend/isacg.astv2", "cgextend", "New");
	}

}
