package org.overture.tools.maven.astcreator;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Says "Hi" to the user.
 * 
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */
public abstract class AstCreatorBaseMojo extends AbstractMojo
{

	protected final String PLUGIN_GROUPID = "org.overture.maven.tools";
	protected final String PLUGIN_ARTIFACTID = "ast-creator-plugin";

	/**
	 * The prefix of the generated classes.
	 * 
	 * @parameter
	 * @optional
	 */
	protected boolean extendedTreeOnly = false;

	/**
	 * The prefix of the generated classes.
	 * 
	 * @parameter
	 * @required
	 */
	protected String ast;

	/**
	 * The prefix of the generated classes.
	 * 
	 * @parameter
	 */
	protected String extendedAst;

	/**
	 * The extended tree dependency groupid.
	 * 
	 * @parameter
	 */
	protected String extendedAstGroupId;

	/**
	 * The extended tree dependency artifactid.
	 * 
	 * @parameter
	 */
	protected String extendedAstArtifactId;

	/**
	 * The prefix of the extended generated classes.
	 * 
	 * @parameter
	 */
	protected String extendedName;


	/**
	 * The use src folder instead of generate-sources for the generated classes.
	 * 
	 * @parameter
	 */
	protected Boolean useSrcOutput;

	/**
	 * Name of the directory into which the astCreatorPlugin should dump the ast files.
	 * 
	 * @parameter property="outputDirectory" default-value="${project.build.directory}/generated-sources/astCreator"
	 */
	protected File outputDirectory;

	/**
	 * Enables generation of vDM source code corresponding to the Java generated tree.
	 * 
	 * @parameter
	 */
	protected Boolean generateVdm = false;

	/**
	 * The package of the generated classes.
	 * 
	 * @parameter
	 */
	protected List<String> deletePackageOnGenerate;

	/**
	 * Suppress warnings
	 * 
	 * @parameter
	 */
	protected boolean suppressWarnings = false;

	/**
	 * @parameter default-value="${project}"
	 * @required
	 * @readonly
	 */
	protected org.apache.maven.project.MavenProject project;

	/**
	 * default-value="${project.reporting.outputDirectory}"
	 * 
	 * @parameter
	 */
	private File projectOutputDirectory;

	protected File getProjectOutputDirectory()
	{
		if (projectOutputDirectory == null
				|| projectOutputDirectory.length() == 0)
		{
			File output = new File(project.getFile().getParentFile(), "target");
			if (!output.exists())
				output.mkdirs();

			return output;

		} else
			return projectOutputDirectory;
	}

	protected File getProjectJavaSrcDirectory()
	{
		File output = new File(project.getFile().getParentFile(), "src/main/java".replace('/', File.separatorChar));
		return output;
	}

	protected File getProjectVdmSrcDirectory()
	{
		File output = new File(project.getFile().getParentFile(), "src/main/vpp".replace('/', File.separatorChar));
		return output;
	}

	protected File getResourcesDir()
	{
		File resources = new File(project.getFile().getParentFile(), "src/main/resources".replace('/', File.separatorChar));
		return resources;
	}

	public abstract void execute() throws MojoExecutionException,
			MojoFailureException;

}
