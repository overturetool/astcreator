package org.overture.tools.astcreator.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import junit.framework.TestCase;

import org.overture.tools.astcreator.AstCreatorException;
import org.overture.tools.astcreator.Main;
import org.overture.tools.astcreator.SourceFileWriter;
import org.overture.tools.astcreator.tests.java.JavaCommandLineCompiler;

public abstract class AbstractAstCreatorTestCase extends TestCase
{
	protected File getOutput(String path)
	{
		return new File(FilePathUtil.getPlatformPath("target/testData/" + path));
	}

	protected File getInput(String path)
	{
		return new File(FilePathUtil.getPlatformPath("src/test/resources/"
				+ path));
	}

	protected FileInputStream getInputStream(String path)
			throws FileNotFoundException
	{
		return new FileInputStream(new File(FilePathUtil.getPlatformPath("src/test/resources/"
				+ path)));
	}

	protected void copyJava(String path, String output) throws IOException
	{
		copyJava(path, getOutput(output));
	}

	protected void copyJava(String path, File output) throws IOException
	{
		FileInputStream in = getInputStream(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		PrintWriter out = null;
		String packageName = null;
		StringBuffer sb = new StringBuffer();
		String line = null;
		try
		{
			while ((line = reader.readLine()) != null)
			{
				line = line.trim();
				sb.append(line + "\n");
				if (line.startsWith("package"))
				{
					packageName = line.substring(line.indexOf(' ')).trim();
				}
			}

			FileWriter outFile = new FileWriter(new File(SourceFileWriter.createFolder(output, packageName), getInput(path).getName()));
			out = new PrintWriter(outFile);

			out.write(sb.toString());
		} finally
		{
			reader.close();
			out.close();
		}
	}

	protected void testCompile(File outputFolder)
	{
		assertTrue("Compliation failed", JavaCommandLineCompiler.compile(outputFolder, null));
	}

	protected void testCompileFail(File outputFolder)
	{
		assertFalse("Compliation successed but was expected to fail", JavaCommandLineCompiler.compile(outputFolder, null));
	}

	protected void singleFileTest(String inputPath, String outputPath)
			throws InstantiationException, IllegalAccessException,
			FileNotFoundException, IOException, AstCreatorException
	{
		File output = getOutput(outputPath);
		Main.create(null, getInputStream(inputPath), output, true, false);
		testCompile(output);
	}

	protected void singleFileTestCompileFail(String inputPath, String outputPath)
			throws InstantiationException, IllegalAccessException,
			FileNotFoundException, IOException, AstCreatorException
	{
		File output = getOutput(outputPath);
		Main.create(null, getInputStream(inputPath), output, true, false);
		testCompileFail(output);
	}

	protected void extensionFileTest(String baseInputPath, String inputPath,
			String outputPath, String name) throws Exception
	{
		File output = getOutput(outputPath);
		Main.create(null, null, getInputStream(baseInputPath), getInputStream(inputPath), output, name, false, true);
		testCompile(output);
	}

	protected void extensionFileTestNoCompile(String baseInputPath,
			String inputPath, String outputPath, String name) throws Exception
	{
		File output = getOutput(outputPath);
		Main.create(null, null, getInputStream(baseInputPath), getInputStream(inputPath), output, name, false, true);
		// testCompile(output);
	}
}
