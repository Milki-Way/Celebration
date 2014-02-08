package event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import display.SpeHistoric;
import display.SpeInfo;
import display.SpeRoute;

public class SidePanelHistoricEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("An HistoricPoi in SidePanel has been clicked");
		JList<SpeHistoric> list= (JList<SpeHistoric>)arg0.getComponent();
		SpeHistoric spe = list.getSelectedValue();
		//On peut réaliser ici une action avec spe.getPoi().
		System.out.println(spe.getHistoricRow().toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		@SuppressWarnings("unchecked")
		JList<SpeRoute> list= (JList<SpeRoute>)arg0.getComponent();
		list.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//On peut réaliser ici ajouter un effet visuel.
		@SuppressWarnings("unchecked")
		JList<SpeRoute> list= (JList<SpeRoute>)arg0.getComponent();
		list.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
