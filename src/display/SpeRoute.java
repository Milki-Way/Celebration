package display;

import java.awt.event.MouseListener;

import entity.Route;

public class SpeRoute extends SidePanelElement{
	private Route route;
	
	public SpeRoute(MouseListener mouseEvent, Route r) {
		route = r;
	}

	/**
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String printOject() {
		return this.route.getLibelle();
	}
	
}
