package com.lausdahl.asteditor;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.jface.viewers.ILabelProvider;

public class ToStringLabelProvider extends OutlineLabelProvider implements
		ILabelProvider
{
	@Override
	public String getText(Object element)
	{
		if (element instanceof CommonTree)
		{
			CommonTree t = (CommonTree) element;
			if (t.getText().equals("%") && t.getChildCount() > 0)
			{
				String name = "";

				CommonTree n = (CommonTree) t.getChild(0);
				name = n.getText();
				for (Object o : n.getChildren())
				{
					name += "" + o;
				}
				return name;
			}
		}
		return super.getText(element);
	}
}
