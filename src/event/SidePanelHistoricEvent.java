package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.SpeHistoric;

public class SidePanelHistoricEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("An info in SidePanel has been clicked");
		SpeHistoric spe = (SpeHistoric)arg0.getComponent();
		//On peut réaliser ici une action avec spe.getPoi().
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//On peut réaliser ici ajouter un effet visuel.
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//On peut réaliser ici ajouter un effet visuel.
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//On peut réaliser ici ajouter un effet visuel.
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//On peut réaliser ici ajouter un effet visuel.
	}

}
