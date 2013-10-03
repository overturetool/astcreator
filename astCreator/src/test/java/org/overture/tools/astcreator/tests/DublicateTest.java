package org.overture.tools.astcreator.tests;

import java.io.IOException;

import org.overture.tools.astcreator.AstCreatorException;

public class DublicateTest extends AbstractAstCreatorTestCase
{

	public void testRoots() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		singleFileTestCompileFail("dublicates\\dublicateRoots.astv2", "dublicates/roots");
	}

	public void testSubRoots() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		singleFileTestCompileFail("dublicates\\dublicateSubRoots.astv2", "dublicates/subs");
	}

	public void testSubRootNoParent() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("dublicates\\unconnectedSub.astv2", "dublicates/noparent");
	}
}
