package org.overture.tools.astcreator.tests;

import junit.framework.Assert;

import org.overture.tools.astcreator.AstCreatorException;
import org.overture.tools.astcreator.Display;

public class FieldNameCheckTest extends AbstractAstCreatorTestCase
{

	@Override
	protected void setUp() throws Exception
	{
		Display.quiet = false;
		Display.useJavaNames = false;
	}

	@Override
	protected void tearDown() throws Exception
	{
		Display.quiet = true;
	}

	public void testBase() throws Exception
	{
		try
		{
			singleFileTest("fieldNameCheck/fieldNameCheck.astv2", "fieldNameCheck");
		} catch (AstCreatorException e)
		{
			Assert.assertEquals("Did not recieve the correct error message", "Illegal field name: _class in AAExp TAG=a", e.getMessage());
			return;
		}
		Assert.fail("No Error recieved!");
	}

}
