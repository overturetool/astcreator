package org.overture.tools.astcreator.tests;

import java.io.File;
import java.io.InputStream;

import junit.framework.TestCase;

import org.overture.tools.astcreator.Main;

public class TokensTest extends TestCase {

	public void testBase() throws Exception {
		InputStream base = getClass().getResourceAsStream(
				"/tokens/t1.astv2");
		File outputFolder = new File(
				FilePathUtil.getPlatformPath("target/testData/tokens"));

		Main.create( null, base,  outputFolder, true, false);
	}
	

}
