package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.SidePanelElement;
import entity.Info;

public class SidePanelInfoEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("An info in SidePanel has been clicked");
		SidePanelElement spe = (SidePanelElement)arg0.getComponent();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
