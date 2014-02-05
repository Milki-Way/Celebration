package entity;

import javax.swing.JLabel;

public class MapMarker extends JLabel {
	
	private Poi poi;
	
	public MapMarker(Poi poi){
		super(poi.getLibelle());
		this.poi = poi;
	}

	public Poi getPoi() {
		return poi;
	}

	public void setPoi(Poi poi) {
		this.poi = poi;
	}
	
	
}
