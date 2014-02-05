package display;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("serial")
public abstract class SidePanelElement extends JLabel implements ListCellRenderer<Object>{
	
	public abstract String printOject();
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {

			setText(value.toString());
			
			Color background;
			Color foreground;
			
			// v�rifie la droplocation
			JList.DropLocation dropLocation = list.getDropLocation();
			if (dropLocation != null
			&& !dropLocation.isInsert()
			&& dropLocation.getIndex() == index) {
			
			background = Color.GREEN;
			foreground = Color.WHITE;
			
			// v�rifie la s�lection
			} else if (isSelected) {
				background = Color.RED;
				foreground = Color.WHITE;
			
			// Non s�lectionn�
			} else {
				background = Color.WHITE;
				foreground = Color.BLACK;
			};
			
			setBackground(background);
			setForeground(foreground);
			
			return this;
			}

}
