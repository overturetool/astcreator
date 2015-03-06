package org.overture.tools.astcreator.methods;

import org.overture.tools.astcreator.definitions.IClassDefinition;
import org.overture.tools.astcreator.env.Environment;

public class HashCodeMethod extends Method
{

	public HashCodeMethod(IClassDefinition c)
	{
		super(c);
	}

	@Override
	protected void prepare(Environment env)
	{
		this.name = "hashCode";
		this.javaDoc = "\t/**\n\t* Forwarding hashCode call to {@link Object#hashCode()}.\n\t**/";
		this.annotation = "@Override";
		this.returnType = "int";
		StringBuffer sb = new StringBuffer();
		sb.append("\t\treturn super.hashCode();");
		this.body = sb.toString();

	}

}
