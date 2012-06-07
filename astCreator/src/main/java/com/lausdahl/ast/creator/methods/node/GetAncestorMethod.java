package com.lausdahl.ast.creator.methods.node;

import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.methods.Argument;
import com.lausdahl.ast.creator.methods.Method;

public class GetAncestorMethod extends Method
{

	public GetAncestorMethod( Environment env)
	{
		super(null, env);
	}
	
	
	@Override
	protected void prepare()
	{
		super.prepare();
		javaDoc+="\t/**\n"+
		 "\t* Returns the nearest ancestor of this node (including itself)\n"+
		 "\t* which is a subclass of {@code classType}.\n"+
		 "\t* @param classType the superclass used\n"+
		 "\t* @return the nearest ancestor of this node\n"+
		 "\t*/";
		
		this.name = "getAncestor";
		this.returnType = env.iNode.getName().getName();
		this.arguments.add(new Argument("Class<INode>", "classType"));
		this.body +="\t\t"+ env.iNode.getName().getName()+" n = this;\n";
		this.body+="\t\twhile (!classType.isInstance(n)) {\n";
		this.body+="\t\t\tn = n.parent();\n";
		this.body+="\t\t\tif (n == null) return null;\n";
		this.body+="\t\t}\n";
		this.body+="\t\treturn n;";
//		public INodeInterpreter getAncestor(Class<INode> classType) {
//			INodeInterpreter n = this;
//			while (!classType.isInstance(n)) {
//				n = n.parent();
//				if (n == null) return null;
//			}
//			
//			
//			return n;//classType.cast(n);
//		}
	}

}
