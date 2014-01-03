package org.overture.tools.astcreator.tests;

import java.io.IOException;

import org.overture.tools.astcreator.AstCreatorException;

public class BaseAstGenerationTests extends AbstractAstCreatorTestCase
{

	public void testAspectForNested() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("aspectForNested.astv2", "aspectForNested");
	}

	public void testAspectInline() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		singleFileTest("aspectInline.astv2", "aspectInline");
	}

	public void testDestecsTestType() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("scriptdestecs/script.astv2", "scriptdestecs");
	}

//	public void testExternalJavaType() throws IOException,
//			InstantiationException, IllegalAccessException, AstCreatorException
//	{
//		singleFileTest("external.astv2", "external");
//	}

	public void testNested1TestType() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("nested1.astv2", "nested1");
	}

	public void testNestedSimpleTestType() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("nestedSimple.astv2", "nestedSimple");
	}

	public void testSimple() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		singleFileTest("extonly1.ast", "simple");
	}

	public void testSimpleTestType() throws IOException,
			InstantiationException, IllegalAccessException, AstCreatorException
	{
		singleFileTest("extend/t1.astv2", "external1");
	}

	public void testTokens() throws IOException, InstantiationException,
			IllegalAccessException, AstCreatorException
	{
		copyJava("tokens/ILexToken.java", "tokens");
		copyJava("tokens/Pass.java", "tokens");
		singleFileTest("tokens/t1.astv2", "tokens");
	}

}