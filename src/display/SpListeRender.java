package display;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;

@SuppressWarnings("serial")
public class SpListeRender extends DefaultListCellRenderer{

	private void setRenderText(String text)
	{
		this.setText(text);
	}
	
	@Override
    public Component getListCellRendererComponent(JList list, Object
        value, int index, boolean isSelected, boolean cellHasFocus) {
        JComponent jc =  (JComponent) super.getListCellRendererComponent(
            list, value, index, isSelected, cellHasFocus);
    	setRenderText(((SidePanelElement) value).printOject());
        return jc;
    }
}
