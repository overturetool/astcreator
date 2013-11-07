package org.overture.tools.astcreator;

import java.util.List;
import java.util.Vector;

import org.antlr.runtime.tree.Tree;

public class ToStringAddOn
{
	public static class ToStringPart
	{
		public enum ToStringPartType
		{
			String, Field, RawJava, Plus, Unknown, Import
		};

		public ToStringPartType type = ToStringPartType.String;
		public String content = "";
		public int line=0;
		public int startIndex=0;
		public int stopIndex=0;

		@Override
		public String toString()
		{
			if (type == ToStringPartType.Field)
			{
				return "[" + content + "]";
			} else
			{
				return content;
			}
		}

		@Override
		public boolean equals(Object obj)
		{
			if (obj instanceof ToStringPart)
			{
				return this.type.equals(((ToStringPart) obj).type)
						&& this.content.equals(((ToStringPart) obj).content);
			}
			return super.equals(obj);
		}

		public String getLocation()
		{
			return "line "+line+" "+startIndex+":"+stopIndex;
		}

		public void setLocation(Tree c)
		{
			line = c.getLine();
			startIndex = c.getTokenStartIndex();
			stopIndex = c.getTokenStopIndex();
		}
	}

	public List<ToStringPart> parts = new Vector<ToStringPart>();

	@Override
	public String toString()
	{
		String tmp = new String();
		for (ToStringPart p : parts)
		{
			tmp += p + " ";
		}
		return tmp;
	}
}
