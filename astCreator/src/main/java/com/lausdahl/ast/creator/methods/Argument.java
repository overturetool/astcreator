package com.lausdahl.ast.creator.methods;

import com.lausdahl.ast.creator.definitions.IInterfaceDefinition;

public class Argument
{
	public Argument()
	{
	}

	public Argument(String type, String name)
	{
		this.type = type;
		this.name = name;
	}

	public Argument(IInterfaceDefinition type, String name)
	{
		this.typeDef = type;
		this.name = name;
	}

	private String type;
	private IInterfaceDefinition typeDef= null;
	public String name;

	public String getTypeName()
	{
		if (typeDef == null)
		{
			return this.type;
		}
		return typeDef.getName().getName();
	}
	
	public IInterfaceDefinition getTypeDef()
	{
		return typeDef;
	}

	@Override
	public String toString()
	{
		return (type!=null?type:typeDef.getName().getName()) + " " + name;
	}
}
