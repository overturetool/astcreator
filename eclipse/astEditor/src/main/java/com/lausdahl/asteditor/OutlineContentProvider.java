package com.lausdahl.asteditor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.overture.tools.astcreator.parser.AstParserWrapper;
import org.overture.tools.astcreator.parser.AstcParser.root_return;

public class OutlineContentProvider implements ITreeContentProvider
{
	private CommonTree root = null;
	private IDocumentProvider documentProvider;

	public OutlineContentProvider(IDocumentProvider provider)
	{
		super();
		this.documentProvider = provider;
	}

	public void dispose()
	{
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		if (oldInput != null)
		{
			IDocument document = documentProvider.getDocument(oldInput);
			if (document != null)
			{

			}
		}
		if (newInput != null)
		{
			IDocument document = documentProvider.getDocument(newInput);
			if (document != null)
			{
				CommonTree rootElement = parseRootElement(document);

				if (rootElement != null)
				{
					root = rootElement;
				}
			}
		}
	}

	protected CommonTree parseRootElement(IDocument document)
	{
		AstParserWrapper parser = new AstParserWrapper();

		if (document != null && document instanceof AstcDocument)
		{
			AstcDocument currentDocument = (AstcDocument) document;
			try
			{
				root_return tmp = parser.parse(currentDocument.getFile().getLocation().toFile(), currentDocument.get());
				if (tmp != null)
					return (CommonTree) tmp.getTree();

			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public Object[] getElements(Object inputElement)
	{
		if (root == null)

			return new Object[0];

		if (root instanceof CommonTree)
		{
			return removeNulls(((CommonTree) root).getChildren()).toArray();
		}
		return new Object[0];
	}

	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object parentElement)
	{
		if (parentElement instanceof CommonTree)
		{
			CommonTree parent = (CommonTree) parentElement;

			if (parent.getText() != null)
			{
				if (parent.getText().equals("P")
						|| parent.getText().equals("%"))
				{
					return sort(filter(parent.getChildren().subList(1, parent.getChildren().size()))).toArray();
				} else if (parent.getText().equals("Packages"))
				{
					return sort(filterPackages(parent.getChildren())).toArray();
				}
			}
			return sort(filter(parent.getChildren())).toArray();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<CommonTree> filterPackages(
			@SuppressWarnings("rawtypes") List children)
	{
		List<CommonTree> tree = new Vector<CommonTree>();

		for (Object object : children)
		{
			if (object instanceof CommonTree)
			{
				CommonTree n = (CommonTree) object;
				if (n.getText().equals("base")
						|| n.getText().equals("analysis"))
				{
					tree.add(n);
				}
			}
		}
		return filter(tree);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List filter(List list)
	{
		List newList = new Vector();
		for (Object o : list)
		{
			if (o instanceof CommonTree)
			{
				if (!((CommonTree) o).getText().equals("->"))
				{
					newList.add(o);
				}
			}
		}
		return newList;
	}

	public Object getParent(Object element)
	{
		return null;
	}

	public boolean hasChildren(Object element)
	{
		if (element instanceof CommonTree)
		{
			CommonTree top = (CommonTree) element;
			if (top.getParent() != null
					&& top.getParent().getText() != null
					&& (top.getParent().getText().equals("Tokens") || top.getParent().getText().equals("To String Extensions")))
			{
				return false;
			}
			if (top.getParent() != null
					&& top.getParent().getText() != null
					&& (top.getParent().getText().equals("P") || top.getParent().getText().equals("%")))
			{
				return false;
			}
			return ((CommonTree) element).getChildCount() > 0;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	protected List removeNulls(List list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null
					|| (list.get(i) instanceof CommonTree && ((CommonTree) list.get(i)).getText() == null))
			{
				list.remove(i);
			}
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	protected List sort(List<CommonTree> list)
	{

		final OutlineLabelProvider pl = new OutlineLabelProvider();
		Collections.sort(list, new Comparator<CommonTree>()
		{

			public int compare(CommonTree o1, CommonTree o2)
			{
				String s1 = pl.getText(o1);
				String s2 = pl.getText(o2);
				return s1.compareTo(s2);
			}
		});
		return list;
	}
}
