package com.lausdahl.ast.creator.tests.extend;

import java.io.File;

import com.lausdahl.ast.creator.Main;
import com.lausdahl.ast.creator.tests.BaseAstCreatorTestCase;

public class SimpleExtendedTest extends BaseAstCreatorTestCase
{
	

	public void testBase() throws Exception
	{
		File output = getOutput("Base");
		deleteDir(output);
		Main.create(getInputFile("extend/simple/t1.astv2").getAbsolutePath(), output, true);
	}
	
	public void testExtended() throws Exception
	{
		File output = getOutput("Extended");
		deleteDir(output);
		Main.create(getInputFile("extend/simple/t1.astv2"),getInputFile("extend/simple/t2.astv2"), output, "Interpreter");
	}
}
