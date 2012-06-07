package com.lausdahl.ast.creator.tests;

import java.io.File;

import com.lausdahl.ast.creator.Main;

public class ExternalJavaTypeTest extends BaseAstCreatorTestCase
{
	public void test()
	{
		File output = getOutput("external");
		Main.test = true;
		try
		{
			Main.create(getInputFile("external.astv2").getAbsolutePath(), output, true);
		} catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
}
