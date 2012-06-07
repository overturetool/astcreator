package com.lausdahl.ast.creator.methods.node;

import com.lausdahl.ast.creator.definitions.Field;
import com.lausdahl.ast.creator.definitions.IInterfaceDefinition;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.methods.Method;

public class ParentGetMethod extends Method
{
	Field f;
	IInterfaceDefinition structureClassName;
	public ParentGetMethod(IInterfaceDefinition structureClassName, Field f,Environment env)
	{
		super(null,env);
		this.f = f;
		this.structureClassName = structureClassName;
	}
	
	@Override
	protected void prepare()
	{
		name = "parent";
		returnType = structureClassName.getName().getName();
		body = "\t\treturn " + f.getName() + ";";
	}

}
