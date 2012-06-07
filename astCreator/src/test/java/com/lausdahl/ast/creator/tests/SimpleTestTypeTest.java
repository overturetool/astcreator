package com.lausdahl.ast.creator.tests;

import java.io.File;
import java.io.IOException;

import com.lausdahl.ast.creator.AstCreatorException;
import com.lausdahl.ast.creator.Main;

public class SimpleTestTypeTest extends BaseAstCreatorTestCase
{

	public void test() throws IOException, InstantiationException, IllegalAccessException, AstCreatorException
	{
		File output = getOutput("external");
		deleteDir(output);
		Main.create(getInputFile("extend/t1.astv2").getAbsolutePath(), output, true);
	}
}
