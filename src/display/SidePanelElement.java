package display;

import java.awt.event.MouseListener;

import javax.swing.JComponent;

public abstract class SidePanelElement extends JComponent{
	private String libelle;
	
	//constructor
	public SidePanelElement(String libelle, MouseListener mouseEvent)
	{
		this.libelle = libelle;
		this.addMouseListener(mouseEvent);
	}
}
