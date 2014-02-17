package org.overture.tools.astcreator.tests;

import java.io.IOException;

import org.overture.tools.astcreator.AstCreatorException;

public class RemoveTest extends AbstractAstCreatorTestCase
{

	public void testRoots() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		singleFileTest("remove\\removeObject.ast", "remove/removeObject");
	}

}
