package event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import tileengine.MapViewer;
import display.SpeRoute;
import entity.Poi;

public class SidePanelRouteEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("A Route in SidePanel has been clicked");
		@SuppressWarnings("unchecked")
		JList<SpeRoute> list= (JList<SpeRoute>)arg0.getComponent();
		SpeRoute spe = list.getSelectedValue();

		MapViewer.getInstance().highLightMapMarker(spe.getRoute().getPoiList());
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
