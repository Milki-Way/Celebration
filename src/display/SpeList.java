package display;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class SpeList<E> extends JList<E>{
	public SpeList(DefaultListModel<E> model)
	{
		super(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.setLayoutOrientation(JList.VERTICAL);
		this.setCellRenderer(new SpListeRender());
	}
}
