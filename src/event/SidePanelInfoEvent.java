package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.SidePanelElement;
import display.SpeInfo;
import entity.Info;

public class SidePanelInfoEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("An info in SidePanel has been clicked");
		SpeInfo spe = (SpeInfo)arg0.getComponent();
		//On peut r�aliser ici une action avec spe.getInfo().
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//On peut r�aliser ici ajouter un effet visuel.
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//On peut r�aliser ici ajouter un effet visuel.
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//On peut r�aliser ici ajouter un effet visuel.
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//On peut r�aliser ici ajouter un effet visuel.
	}

}
