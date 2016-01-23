package org.overture.tools.maven.astcreator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.overture.tools.astcreator.Main;
import org.overture.tools.astcreator.env.Environment;
import org.overture.tools.maven.astcreator.util.Util;

/**
 * Generate Tree
 * 
 * @goal generate
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */
public class GenerateTree extends AstCreatorBaseMojo
{


	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
		getLog().info("Preparing for tree generation...");
		// Let's make sure that maven knows to look in the output directory
		project.addCompileSourceRoot(outputDirectory.getPath());

		// Base tree
		File baseAstFile = new File(getResourcesDir(), ast);
		File baseAsttoStringFile = new File(baseAstFile.getAbsolutePath()
				+ Main.TO_STRING_FILE_NAME_EXT);

		// Extended tree
		File extendedAstFile = (extendedAst == null ? null
				: new File(getResourcesDir(), extendedAst));
		File extendedAstToStringFile = (extendedAstFile == null ? null
				: new File(extendedAstFile.getAbsolutePath()
						+ Main.TO_STRING_FILE_NAME_EXT));

		if (extendedAstFile != null)
		{
			getLog().info("Configuring extension");
			if (this.extendedAstGroupId == null
					|| this.extendedAstArtifactId == null)
			{
				getLog().error("\tExtension base dependency not configures with groupId and artifactId");
			}

			getLog().info("\tExtension base dependency is: \""
					+ this.extendedAstGroupId + ":"
					+ this.extendedAstArtifactId + "\"");
			getLog().info("\tSearching for base dependency artifact");
			if (extendedAstFile != null)
			{
				DefaultArtifact baseArtifact = null;
				for (Object a : this.project.getDependencyArtifacts())
				{
					if (a instanceof DefaultArtifact)
					{
						DefaultArtifact artifact = (DefaultArtifact) a;
						if (artifact.getGroupId().equals(this.extendedAstGroupId)
								&& artifact.getArtifactId().equals(this.extendedAstArtifactId))
						{
							baseArtifact = artifact;
							break;
						}
					}
				}
				getLog().info("\tExtension base artifact found - exstracting base tree definition files");
				File baseJar = baseArtifact.getFile();
				preparebase(baseJar, ast);

				getLog().info("\tSetting base definition files to:");

				baseAstFile = new File(getProjectOutputDirectory(), ast);
				baseAsttoStringFile = new File(baseAstFile.getAbsolutePath()
						+ Main.TO_STRING_FILE_NAME_EXT);
				getLog().info("\t\tbase: " + baseAstFile);
				getLog().info("\t\tbase tostring: " + baseAsttoStringFile);

				getLog().info("\tExtension base artifact configured.");
			}
		}

		getLog().info("Checking if generation required.");
		if (!isForce() && isCrcEqual(baseAstFile) && isCrcEqual(baseAsttoStringFile)
				&& isVersionEqual(getDeclaredPluginVersion()))
		{

			if (extendedAst != null && !extendedAst.isEmpty())
			{
				if (!isForce() && isCrcEqual(new File(getResourcesDir(), extendedAst))
						&& isCrcEqual(new File(getResourcesDir(), extendedAst))
						&& isVersionEqual(getDeclaredPluginVersion()))
				{
					getLog().info("Extended AST unchanged");
					getLog().info("Nothing to generate, source already up-to-date");
					return;
				}
				getLog().info("Extended AST generation needed");
			} else
			{
				getLog().info("All up to date");
				return;
			}
		} else
		{
			getLog().info("Full AST generation needed");
		}
		getLog().info("Generating...");

		if (deletePackageOnGenerate != null)
		{
			for (String relativePath : deletePackageOnGenerate)
			{
				relativePath = relativePath.replace('.', File.separatorChar);
				getLog().info("Deleting folder: " + relativePath);
				File f = new File(getGeneratedFolder(), relativePath.replace('/', File.separatorChar));
				if (f.exists())
				{
					deleteDir(f);
				} else
				{
					getLog().warn("Folder not found and delete skipped: "
							+ relativePath);
				}
			}

		}

		if (baseAstFile.exists())
		{
			File generated = getGeneratedFolder();

			getLog().info("Generator starting with input: " + baseAstFile);
			Environment env1 = null;
			if (extendedName == null && extendedAst != null)
			{
				getLog().error("Missing extendedName for AST extension of: "
						+ extendedAst);
			} else if (extendedAst == null)
			{
				generateSingleAst(baseAstFile, baseAsttoStringFile, generated, env1);
			} else
			{
				generateExtendedAst(baseAstFile, extendedAstFile, baseAsttoStringFile, extendedAstToStringFile, generated);
			}
		} else
		{
			getLog().error("Cannot find input file: "
					+ baseAstFile.getAbsolutePath());
		}
	}

	protected boolean isForce()
	{
		return false;
	}

	private void preparebase(File baseJar, String ast)
			throws MojoExecutionException, MojoFailureException
	{

		if (baseJar.isFile())
		{
			preparebaseJar(baseJar, ast);
		} else
		{
			preparebaseDirectory(baseJar, ast);
		}
	}

	private void preparebaseDirectory(File baseJar, String ast)
			throws MojoExecutionException
	{
		File astDefinition = new File(baseJar, ast);
		File astDefinitionToString = new File(baseJar, ast
				+ Main.TO_STRING_FILE_NAME_EXT);

		try
		{
			Util.copyFile(astDefinition, new File(getProjectOutputDirectory(), astDefinition.getName()));
		} catch (IOException e)
		{
			throw new MojoExecutionException("Failed to copy AST defintion file from source: "
					+ astDefinition);
		}

		try
		{
			Util.copyFile(astDefinitionToString, new File(getProjectOutputDirectory(), astDefinitionToString.getName()));
		} catch (IOException e)
		{
		}

	}

	private void preparebaseJar(File baseJar, String ast)
			throws MojoExecutionException, MojoFailureException
	{
		// assuming you already have an InputStream to the jar file..
		JarInputStream jis = null;
		boolean astDefinitionPrepared = false;
		try
		{
			jis = new JarInputStream(new FileInputStream(baseJar));

			// get the first entry
			ZipEntry entry = jis.getNextEntry();
			// we will loop through all the entries in the jar file
			while (entry != null)
			{
				// test the entry.getName() against whatever you are looking for, etc
				if (entry.getName().equalsIgnoreCase(ast)
						|| entry.getName().equalsIgnoreCase(ast
								+ Main.TO_STRING_FILE_NAME_EXT))
				{
					// read from the JarInputStream until the read method returns -1
					// ...
					// do what ever you want with the read output
					// ...
					// if you only care about one file, break here
					OutputStream resStreamOut = null;
					int readBytes;
					byte[] buffer = new byte[4096];
					boolean copyContentSuccess = false;
					try
					{
						resStreamOut = new FileOutputStream(new File(getProjectOutputDirectory(), entry.getName()));
						while ((readBytes = jis.read(buffer)) > 0)
						{
							resStreamOut.write(buffer, 0, readBytes);
							copyContentSuccess = true;
						}
					} catch (IOException e1)
					{
						copyContentSuccess = false;
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally
					{
						resStreamOut.close();
					}

					if (entry.getName().equalsIgnoreCase(ast)
							&& copyContentSuccess)
					{
						astDefinitionPrepared = true;
					}

				}
				// get the next entry
				entry = jis.getNextEntry();
			}
			jis.close();

		} catch (FileNotFoundException e)
		{
			getLog().error("Failed to find file for base artifact: " + baseJar);
			throw new MojoExecutionException("Unable to find base artifact jar: "
					+ baseJar, e);

		} catch (IOException e)
		{
			getLog().error("Failed to while reading from base artifact: "
					+ baseJar);
			throw new MojoExecutionException("Unable to read from base artifact jar: "
					+ baseJar, e);
		} finally
		{
			try
			{
				if (jis != null)
				{
					jis.close();
				}
			} catch (IOException e)
			{
			}
		}

		if (!astDefinitionPrepared)
		{
			throw new MojoFailureException("Failed to prepare base AST definition, from source: "
					+ baseJar);
		}
	}

	public boolean generateVdm()
	{
		return generateVdm != null && generateVdm;
	}

	public File getGeneratedFolder()
	{
		return outputDirectory;
	}

	private String getDeclaredPluginVersion()
	{
		for (Object o : project.getModel().getBuild().getPlugins())
		{
			if (o instanceof Plugin)
			{
				Plugin p = (Plugin) o;
				if (p.getGroupId().equals(PLUGIN_GROUPID)
						&& p.getArtifactId().equals(PLUGIN_ARTIFACTID))
				{
					return p.getVersion();
				}
			}
		}

		return "";
	}

	public void generateSingleAst(File treeName, File toStringAstFile,
			File generated, Environment env1)
	{
		try
		{
			FileInputStream toStringFileStream = new FileInputStream(toStringAstFile);
			Main.suppressWarnings = suppressWarnings;
			env1 = Main.create(toStringFileStream, new FileInputStream(treeName.getAbsolutePath()), generated, !isDryRun(), generateVdm());
			setCrc(treeName);
			setCrc(toStringAstFile);
			setVersion(getDeclaredPluginVersion());
		} catch (Exception e)
		{
			getLog().error(e);
		}
		if (env1 != null)
		{
			getLog().info("Generator completed with "
					+ env1.getAllDefinitions().size() + " generated files.\n\n");
		}
	}

	public void generateExtendedAst(File baseAstFile, File extendedAstFile,
			File baseAstToStringAstFile, File extendedAstToStringFile,
			File generated)
	{
		getLog().info("Generator starting with extension input: "
				+ extendedAstFile);

		if (!extendedAstFile.exists())
		{
			getLog().equals("Extended AST file does not exist: "
					+ extendedAstFile.getAbsolutePath());
			return;
		}
		FileInputStream toStringAstFileStream = null;
		FileInputStream toStringExtendedFileInputStream = null;
		try
		{
			if (baseAstToStringAstFile.canRead())
				toStringAstFileStream = new FileInputStream(baseAstToStringAstFile);

			if (extendedAstToStringFile.canRead())
				toStringExtendedFileInputStream = new FileInputStream(extendedAstToStringFile);
		} catch (FileNotFoundException e)
		{
		}

		try
		{
			Main.suppressWarnings = suppressWarnings;
			Main.create(toStringAstFileStream, toStringExtendedFileInputStream, new FileInputStream(baseAstFile), new FileInputStream(extendedAstFile), generated, extendedName, generateVdm(), extendedTreeOnly,!isDryRun());
			setCrc(baseAstFile);
			setCrc(baseAstToStringAstFile);
			setCrc(extendedAstFile);
			setCrc(extendedAstToStringFile);
			setVersion(getDeclaredPluginVersion());
		} catch (Exception e)
		{
			getLog().error(e);
		}
	}

	protected boolean isDryRun()
	{
		return false;
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

	public boolean isCrcEqual(File file)
	{
		if (file == null)
		{
			return false;
		}
		String name = file.getName();
		long sourceCrc = Util.getCheckSum(file.getAbsolutePath());

		File crcFile = new File(getProjectOutputDirectory(), name + ".crc");
		if (!crcFile.exists())
		{
			return false;
		}

		String crcString;
		try
		{
			crcString = Util.readFile(crcFile);
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}

		long destinationCrc = Long.valueOf(crcString);

		return destinationCrc == sourceCrc;
	}

	public void setCrc(File astFile) throws IOException
	{
		String name = astFile.getName();
		Long sourceCrc = Util.getCheckSum(astFile.getAbsolutePath());

		File crcFile = new File(getProjectOutputDirectory(), name + ".crc");
		Util.writeFile(crcFile, sourceCrc.toString());
	}

	public boolean isVersionEqual(String version)
	{

		File crcFile = new File(getProjectOutputDirectory(), "version.crc");
		if (!crcFile.exists())
		{
			return false;
		}

		String crcString;
		try
		{
			crcString = Util.readFile(crcFile);
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}

		return version.equals(crcString);
	}

	public void setVersion(String version) throws IOException
	{

		File crcFile = new File(getProjectOutputDirectory(), "version.crc");
		Util.writeFile(crcFile, version);
	}

}
