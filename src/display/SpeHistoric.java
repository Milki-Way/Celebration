package display;

import java.awt.event.MouseListener;

import entity.Poi;

public class SpeHistoric extends SidePanelElement{
	private Poi poi;
	
	public SpeHistoric(MouseListener mouseEvent, Poi poi) {
		super(mouseEvent);
		this.poi = poi;
	}

	/**
	 * @return the poi
	 */
	public Poi getPoi() {
		return poi;
	}

	/**
	 * @param poi the poi to set
	 */
	public void setPoi(Poi poi) {
		this.poi = poi;
	}
	
}
