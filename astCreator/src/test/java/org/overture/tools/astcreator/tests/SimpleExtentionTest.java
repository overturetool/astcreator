package org.overture.tools.astcreator.tests;

import java.io.File;
import java.io.InputStream;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.overture.tools.astcreator.Main;

public class SimpleExtentionTest extends TestCase {

	public void testBase() throws Exception {
		InputStream base = getClass().getResourceAsStream(
				"/simple-extention/t1.astv2");
		File outputFolder = new File(
				FilePathUtil.getPlatformPath("target/testData/simple-extention"));
//		File outputFolder = new File("../../testdata/generatedCode");


		Main.create( null, base,  outputFolder, true, false);
	}
	
	public void testExtension() throws Exception {
		InputStream extension = getClass().getResourceAsStream(
				"/simple-extention/t2.astv2");
		InputStream base = getClass().getResourceAsStream(
				"/simple-extention/t1.astv2");
		File outputFolder = new File(
				FilePathUtil.getPlatformPath("target/testData/simple-extention"));
//		File outputFolder = new File("../../testdata/generatedCode");

		Assert.assertNotNull("Unable to load CML Source Ast file", extension);
		Assert.assertNotNull("Unable to load Overture Souce Ast file",
				base);

		Main.create(null, null, base, extension, outputFolder, "Ext",
				false, true);
	}
	
	public void testSmallExtension() throws Exception {
		InputStream extension = getClass().getResourceAsStream(
				"/simple-extention/t3.astv2");
		InputStream base = getClass().getResourceAsStream(
				"/simple-extention/t1.astv2");
		File outputFolder = new File(
				FilePathUtil.getPlatformPath("target/testData/simple-extention"));
//		File outputFolder = new File("../../testdata/generatedCode");

		Assert.assertNotNull("Unable to load CML Source Ast file", extension);
		Assert.assertNotNull("Unable to load Overture Souce Ast file",
				base);

		Main.create(null, null, base, extension, outputFolder, "Ext",
				false, true);
	}

}
