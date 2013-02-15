package com.lausdahl.ast.creator.methods.visitors.adaptor.questionanswer;

import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.methods.analysis.depthfirst.AnalysisDepthFirstAdaptorCaseMethod;

public class QuestionAnswerDepthFirstAdaptorCaseMethod extends
		AnalysisDepthFirstAdaptorCaseMethod
{
	public QuestionAnswerDepthFirstAdaptorCaseMethod()
	{
		super(null, null);
	}

	public QuestionAnswerDepthFirstAdaptorCaseMethod(IClassDefinition c)
	{
		super(c);

	}

	@Override
	protected void prepare(Environment env)
	{
		addReturnToBody = true;
		super.prepare(env);
		this.returnType = "A";
	}

	@Override
	protected void setupArguments(Environment env)
	{
		super.setupArguments(env);
		this.arguments.add(new Argument("Q", "question"));
	}
}
