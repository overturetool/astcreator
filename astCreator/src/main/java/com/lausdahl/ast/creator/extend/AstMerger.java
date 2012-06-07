package com.lausdahl.ast.creator.extend;

import java.util.List;
import java.util.Vector;
import java.util.Map.Entry;

import com.lausdahl.ast.creator.CreateOnParse;
import com.lausdahl.ast.creator.definitions.Field;
import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.definitions.IClassDefinition.ClassType;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.utils.ClassFactory;

public class AstMerger
{
	public Environment merge(Environment source, Environment extension)
	{

		for (Entry<IClassDefinition, ClassType> entry : extension.getClassToTypeMap().entrySet())
		{
			switch (entry.getValue())
			{
				case Alternative:
				case Token:
					merge(source, extension, entry.getKey(), entry.getValue());
					break;

			}
		}

		return source;
	}

	private IClassDefinition merge(Environment source, Environment extension,
			IClassDefinition newDef, ClassType classType)
	{
		IClassDefinition def = source.lookUp(newDef.getName().getName());
		IClassDefinition mergedDef = null;
		if (def != null)
		{
			System.out.println("Found");
			mergedDef = merge(source, extension, def, newDef, classType);
		} else
		{
			System.out.println("Not found");
			mergedDef = addMissing(source, extension, newDef, classType);
		}
		return mergedDef;
	}

	private IClassDefinition addMissing(Environment source,
			Environment extension, IClassDefinition key, ClassType classType)
	{
		IClassDefinition newDef = ClassFactory.create(key.getName(), merge(source, extension, key.getSuperDef(), extension.getClassType(key.getSuperDef())), classType, source);

		for (Field field : key.getFields())
		{
			newDef.addField(field);
			CreateOnParse.addGetSetMethods(source, classType, newDef, field);
		}

		return newDef;
	}

	private IClassDefinition merge(Environment source, Environment extension,
			IClassDefinition def, IClassDefinition newDef, ClassType classType)
	{
		List<Field> newFields = new Vector<Field>();
		for (Field extendedField : newDef.getFields())
		{
			boolean found = false;
			for (Field field : newDef.getFields())
			{
				if (field.getName().equals(extendedField.getName()))// TODO we also need to check the type to see if it
																	// is refined
				{
					found = true;
				}
			}

			if (!found)
			{
				newFields.add(extendedField);
			}
		}

		for (Field field : newFields)
		{
			def.addField(field);
			CreateOnParse.addGetSetMethods(source, classType, def, field);
		}

		return def;
	}
}
