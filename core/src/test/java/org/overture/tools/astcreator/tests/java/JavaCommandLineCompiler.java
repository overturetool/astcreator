package org.overture.tools.astcreator.tests.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

public class JavaCommandLineCompiler
{

	public static Boolean isWindows()
	{
		String osName = System.getProperty("os.name");

		return osName.toUpperCase().indexOf("Windows".toUpperCase()) > -1;
	}

	public static boolean compile(File dir, File cpJar)
	{
		String javaHome = System.getenv("JAVA_HOME");
		File javac = javaHome == null ? new File("javac")
				: new File(new File(javaHome, "bin"), "javac");
		return compile(javac, dir, cpJar);
	}

	public static boolean compile(File javac, File dir, File cpJar)
	{
		if (cpJar != null)
		{
			Assert.assertNotNull("Classpath jar not found: " + cpJar, cpJar);
		}
		boolean compileOk = true;

		List<File> files = getFiles(dir);

		// printCompileMessage(files, cpJar);

		StringBuilder out = new StringBuilder();
		Process p = null;
		try
		{
			String line;
			ProcessBuilder pb = null;
			pb = new ProcessBuilder(javac.getPath());

			if (cpJar != null)
			{
				pb.command().add("-cp");
				pb.command().add(cpJar.getAbsolutePath());
			} else
			{
				pb.command().add("-cp");
				pb.command().add(".");
			}

			for (File file : files)
			{
				if (isWindows())
				{
					pb.command().add("\"" + file.getAbsolutePath() + "\" ");
				} else
				{
					pb.command().add(file.getAbsolutePath());
				}
			}

			pb.directory(dir);
			pb.redirectErrorStream(true);
			p = pb.start();

			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String secondLastLine = "";
			while ((line = input.readLine()) != null)
			{
				out.append("\n" + line);

				secondLastLine = line;
			}

			compileOk = !secondLastLine.toLowerCase().contains("error");
			input.close();
		} catch (Exception err)
		{
			System.err.println(out.toString());
			err.printStackTrace();

		} finally
		{
			if (p != null)
			{
				p.destroy();
			}
		}

		if (compileOk)
		{
			System.out.println("Compliation OK");
		} else
		{
			System.err.println("Compliation Failed");
			System.err.println(out.toString());
		}
		return compileOk;

	}

	public static void printCompileMessage(List<File> files, File cpJar)
	{
		PrintStream out = System.out;

		out.println("Compiling (JAVA):");
		if (cpJar != null)
		{
			out.println("Class path:  " + cpJar.getName());
		}
		// out.println("Java files:  ");

		for (File file : files)
		{
			out.println("             " + file.getName());
		}

	}

	private static List<File> getFiles(File file)
	{
		List<File> files = new Vector<File>();
		for (File f : file.listFiles())
		{
			if (f.isDirectory())
			{
				files.addAll(getFiles(f));
			} else if (f.getName().toLowerCase().endsWith(".java"))
			{
				files.add(f);
			}
		}
		return files;
	}
}
