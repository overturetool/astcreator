package com.lausdahl.ast.creator.tests;

import java.io.File;

import junit.framework.TestCase;

public abstract class BaseAstCreatorTestCase extends TestCase
{
	private static final String TESTDATA_BASE = "src/test/resources/";

	/**
	 * @param relativePath
	 *            relative path to target/testData/
	 * @return
	 */
	public File getOutput(String relativePath)
	{
		File output = new File(FilePathUtil.getPlatformPath("target/testData/"+this.getClass().getSimpleName()+"/"
				+ relativePath));
		return output;
	}

	/**
	 * @param relativePath
	 *            relative path to src/test/resources/
	 * @return
	 */
	public File getInputFile(String relativePath)
	{
		String inputFile = TESTDATA_BASE + relativePath;
		return new File(new File(".").getParentFile(), FilePathUtil.getPlatformPath(inputFile));
	}

	public static boolean deleteDir(File dir)
	{
		if (dir.isDirectory())
		{
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++)
			{
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success)
				{
					return false;
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	}
}
