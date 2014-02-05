package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class MapMarker extends JLabel {
	
	private Poi poi;
	private boolean drawLibelle = false;
	
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
	
	public void drawPoint(Graphics2D g2){
		g2.setColor(Color.red);
		g2.fillRect((int)this.getBounds().getX(), (int)this.getBounds().getY(), 4, 4);
	}

	public boolean isDrawLibelle() {
		return drawLibelle;
	}

	public void setDrawLibelle(boolean drawLibelle) {
		this.drawLibelle = drawLibelle;
	}
	
	
}
