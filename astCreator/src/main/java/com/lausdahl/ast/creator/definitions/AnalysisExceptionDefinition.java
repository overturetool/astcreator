package com.lausdahl.ast.creator.definitions;

import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.java.definitions.JavaName;
import com.lausdahl.ast.creator.methods.Method.Argument;
import com.lausdahl.ast.creator.methods.SuperConstructorMethod;

public class AnalysisExceptionDefinition extends BaseClassDefinition {

	public AnalysisExceptionDefinition(JavaName name, Environment env) {
		super(name, env.getAstPackage());
		superDef = new PredefinedClassDefinition("java.lang", "Exception");
		addMethod(new SuperConstructorMethod(this, new Argument[] {}));
		addMethod(new SuperConstructorMethod(this, new Argument("String",
				"message")));
		addMethod(new SuperConstructorMethod(this, new Argument("String",
				"message"), new Argument("Throwable", "cause")));
		addMethod(new SuperConstructorMethod(this, new Argument("Throwable",
				"cause")));
	}

	public AnalysisExceptionDefinition(String packageName, String name,
			Environment env) {
		this(new JavaName(packageName, name), env);
	}

	public String toString() {
		return "I should die";
	}

}
