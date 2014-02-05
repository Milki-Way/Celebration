package display;

import java.awt.event.MouseListener;

import javax.swing.JComponent;

public abstract class SidePanelElement extends JComponent{
	
	//constructor
	public SidePanelElement(MouseListener mouseEvent)
	{
		this.addMouseListener(mouseEvent);
	}
}
