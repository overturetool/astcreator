package com.lausdahl.ast.creator.tests;

import java.io.File;
import java.io.IOException;

import com.lausdahl.ast.creator.AstCreatorException;
import com.lausdahl.ast.creator.Main;

public class AspectForNestedTest extends BaseAstCreatorTestCase
{
	public void test() throws IOException, InstantiationException, IllegalAccessException, AstCreatorException
	{
		File output = getOutput("aspectForNested");
		Main.create(getInputFile("aspectForNested.astv2").getAbsolutePath(), output, true);
	}
}
