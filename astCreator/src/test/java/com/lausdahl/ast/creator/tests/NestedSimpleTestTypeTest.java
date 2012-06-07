package com.lausdahl.ast.creator.tests;

import java.io.File;
import java.io.IOException;

import com.lausdahl.ast.creator.AstCreatorException;
import com.lausdahl.ast.creator.Main;

public class NestedSimpleTestTypeTest extends BaseAstCreatorTestCase
{
	public void test() throws IOException, InstantiationException, IllegalAccessException, AstCreatorException
	{
		File output = getOutput("nestedSimple");
		Main.create(getInputFile("nestedSimple.astv2").getAbsolutePath(), output, true);
	}
}
