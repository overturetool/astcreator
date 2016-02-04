package org.overture.tools.astcreator.tests;

public class LeafExtensionTest extends AbstractAstCreatorTestCase
{

	public void test_AltLeaf() throws Exception
	{
		singleFileTest("leafextend/altleaf/base.astv2", "leafextend/altleaf");
		extensionFileTest("leafextend/altleaf/base.astv2", "leafextend/altleaf/extension.astv2", "leafextend/altleaf", "New");
	}

	public void test_NewLeaf() throws Exception
	{
		singleFileTest("leafextend/newleaf/base.astv2", "leafextend/newleaf");
		extensionFileTest("leafextend/newleaf/base.astv2", "leafextend/newleaf/extension.astv2", "leafextend/newleaf", "New");
    }

    public void test_LeafInSubProductions() throws Exception
    {
        singleFileTest("leafextend/subprod/base.astv2", "leafextend/subprod");
        extensionFileTest("leafextend/subprod/base.astv2", "leafextend/subprod/extension.astv2", "leafextend/subprod", "New");
    }
}
