package com.lausdahl.ast.creator.extend;

import java.util.Map.Entry;

import com.lausdahl.ast.creator.definitions.Field;
import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.definitions.IInterfaceDefinition;
import com.lausdahl.ast.creator.definitions.IClassDefinition.ClassType;
import com.lausdahl.ast.creator.env.Environment;
import com.lausdahl.ast.creator.methods.CloneWithMapMethod;
import com.lausdahl.ast.creator.methods.KindMethod;
import com.lausdahl.ast.creator.methods.KindMethod1;
import com.lausdahl.ast.creator.methods.Method;
import com.lausdahl.ast.creator.methods.node.GetAncestorMethod;
import com.lausdahl.ast.creator.methods.node.ParentGetMethod;
import com.lausdahl.ast.creator.methods.node.ParentSetMethod;
import com.lausdahl.ast.creator.methods.visitors.AnalysisAcceptMethod;
import com.lausdahl.ast.creator.methods.visitors.QuestionAcceptMethod;
import com.lausdahl.ast.creator.methods.visitors.QuestionAnswerAcceptMethod;

public class ExtensionManager
{

	public Environment extend(Environment base, Environment newEnv,
			String extensionName)
	{

		newEnv.iNode.getSuperDefs().add(base.iNode);
		newEnv.iToken.getSuperDefs().add(base.iToken);

		for (Entry<IClassDefinition, ClassType> entry : newEnv.getClassToTypeMap().entrySet())
		{
			switch (entry.getValue())
			{
				case Alternative:
				{
					IClassDefinition def = entry.getKey();

					IClassDefinition superDef = base.lookUp(def.getName().getName());
					IClassDefinition superDefOld = null;
					if (superDef != null)
					{
						IInterfaceDefinition intf = newEnv.getInterfaceForCommonTreeNode(def.getSuperDef());
						def.addInterface(intf);

						superDefOld = def.getSuperDef();
						def.setSuper(superDef);
						for (Method m : def.getMethods())
						{
							if (m instanceof KindMethod)
							{
								m.setEnvironment(base);
								m.setClassDefinition(superDef);
							}

							if (m instanceof CloneWithMapMethod)
							{
								((CloneWithMapMethod) m).argumentType = base.iNode;
							}
						}

						for (Method m : superDef.getMethods())
						{
							if (m instanceof AnalysisAcceptMethod
									|| m instanceof AnalysisAcceptMethod
									|| m instanceof QuestionAcceptMethod
									|| m instanceof QuestionAnswerAcceptMethod)
							{
								def.addMethod(m);
							}
						}

						def.addMethod(new KindMethod1(entry.getKey(), newEnv, superDefOld, newEnv));
						
						Field parentField = new Field(newEnv);
						parentField.name = "parent";
						parentField.type = newEnv.iNode;
						def.addField(parentField);
						
						def.addMethod(new ParentSetMethod(newEnv.iNode, parentField, newEnv));
						def.addMethod(new ParentGetMethod(newEnv.iNode, parentField, newEnv));
						def.addMethod(new GetAncestorMethod( newEnv));
					}
				}
					break;
				case Custom:
					break;
				case Production:
				{
					IInterfaceDefinition intf = newEnv.getInterfaceForCommonTreeNode(entry.getKey());
					IInterfaceDefinition baseIntf = base.lookUpInterface(intf.getName().getName());
					intf.getSuperDefs().add(baseIntf);
				}
					break;
				case SubProduction:
					break;
				case Token:
					break;
				case Unknown:
					break;

			}
		}

		for (IInterfaceDefinition d : newEnv.getAllDefinitions())
		{
			d.getName().setExtendedName(extensionName);
		}

		return newEnv;
	}
}
