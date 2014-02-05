package display;

import java.awt.event.MouseListener;

import entity.Poi;

public class SpeHistoric extends SidePanelElement{
	private Poi poi;
	
	public SpeHistoric(String libelle, MouseListener mouseEvent, Poi poi) {
		super(libelle, mouseEvent);
		this.poi = poi;
	}
	
}
