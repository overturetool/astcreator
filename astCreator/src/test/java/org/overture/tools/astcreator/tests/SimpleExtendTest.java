package org.overture.tools.astcreator.tests;

public class SimpleExtendTest extends AbstractAstCreatorTestCase
{

	public void test() throws Exception
	{
		singleFileTest("extend/t1.astv2", "Interpreter");
		extensionFileTest("extend/t1.astv2", "extend/t2.astv2", "Interpreter", "Interpreter");
	}

}
