package org.overture.tools.astcreator.env;

import java.util.HashSet;
import java.util.Set;

import org.overture.tools.astcreator.definitions.IInterfaceDefinition;

public class ExtendedEnvironment extends Environment
{

	public final String extensionName;
	/**
	 * The environment this extends, if any
	 */
	public final Environment baseEnv;

	// /**
	// * Sets The environment this extends
	// * @param extended
	// */
	// public void setExtendedEnvironment(Environment extended)
	// {
	// this.extendedEnv = extended;
	// }
	//
	// /**
	// * Gets The environment this extends, or null
	// * @return
	// */
	// public Environment getExtendedEnvironment()
	// {
	// return this.extendedEnv;
	// }
	protected ExtendedEnvironment(String name, Environment baseEnvironment,
			String extensionName)
	{
		super(name);
		this.baseEnv = baseEnvironment;
		this.extensionName = extensionName;
	}
	
	private Set<IInterfaceDefinition> getTaggedDefs(String tag)
	{
		Set<IInterfaceDefinition> res = new HashSet<IInterfaceDefinition>();
		for (IInterfaceDefinition def : interfaces)
		{
			if (def.getTag().equals(tag))

			{
				res.add(def);
			}
		}
		return res;
	}
	

	public IInterfaceDefinition getTaggedDef(String tag)
	{
		Set<IInterfaceDefinition> res = getTaggedDefs(tag);

		if (!res.isEmpty())
		{
			if (res.size() > 1)
			{
				for (IInterfaceDefinition r : res)
				{
					if (r.isExtTree())
					{
						return r;
					}
				}

				for (IInterfaceDefinition r : res)
				{
					if (!r.isExtTree())
					{
						return r;
					}
				}
			}
			return res.iterator().next();
		}
		return null;
	}
	
	public IInterfaceDefinition getTaggedBaseDef(String tag)
	{
		Set<IInterfaceDefinition> res = getTaggedDefs(tag);

		if (!res.isEmpty())
		{
			if (res.size() > 1)
			{
				for (IInterfaceDefinition r : res)
				{
					if (!r.isExtTree())
					{
						return r;
					}
				}

				for (IInterfaceDefinition r : res)
				{
					if (r.isExtTree())
					{
						return r;
					}
				}
			}
			return res.iterator().next();
		}
		return null;
	}
}
