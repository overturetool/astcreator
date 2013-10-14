package org.overture.tools.maven.astcreator;

import org.overture.tools.astcreator.Display;

/**
 * Show Tree
 * 
 * @goal show
 * @requiresDependencyResolution compile
 */
public class ShowTree extends GenerateTree
{
	public ShowTree()
	{
		Display.quiet = false;
		
		if(System.getProperty("show.java")!=null)
		{
			Display.useJavaNames = true;
		}
	}

	@Override
	protected boolean isDryRun()
	{
		return true;
	}

	@Override
	protected boolean isForce()
	{
		return true;
	}

}
