package org.overture.tools.astcreator.tests;

public class SingleAlternativeExtendTest extends AbstractAstCreatorTestCase
{

	public void test() throws Exception
	{
		singleFileTest("extendSingleAlternative/t1.astv2", "extendSingleAlternative");
		extensionFileTest("extendSingleAlternative/t1.astv2", "extendSingleAlternative/t2.astv2", "extendSingleAlternative", "New");
	}

}
