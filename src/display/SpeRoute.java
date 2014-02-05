package display;

import java.awt.event.MouseListener;

import entity.Route;

public class SpeRoute extends SidePanelElement{
	private Route route;
	
	public SpeRoute(String libelle, MouseListener mouseEvent, Route r) {
		super(libelle, mouseEvent);
		route = r;
	}
	
}
