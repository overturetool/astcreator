package com.lausdahl.ast.creator.tests;

import java.io.File;
import java.io.IOException;

import com.lausdahl.ast.creator.AstCreatorException;
import com.lausdahl.ast.creator.Main;

public class Nested1TestTypeTest extends BaseAstCreatorTestCase
{
	public void test() throws IOException, InstantiationException, IllegalAccessException, AstCreatorException
	{
		File output = getOutput("nested1");
		Main.create(getInputFile("nested1.astv2").getAbsolutePath(), output, true);
	}
}
