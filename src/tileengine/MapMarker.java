package tileengine;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import display.MarkerPanel;
import entity.Poi;

public class MapMarker extends JLabel {
	
	private Poi poi;
	private boolean drawLibelle = false;
	private boolean highLighted = false;
	private MarkerPanel descriptionPanel;
	
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
		if(highLighted == true){
			g2.setColor(Color.red);
			g2.fillOval((int)this.getBounds().getX(), (int)this.getBounds().getY(), 5, 5);
		}
		g2.setColor(Color.red);
		g2.fillRect((int)this.getBounds().getX(), (int)this.getBounds().getY(), 3, 3);
	}

	public boolean isDrawLibelle() {
		return drawLibelle;
	}

	public void setDrawLibelle(boolean drawLibelle) {
		this.drawLibelle = drawLibelle;
	}
	
	public MarkerPanel getMarkerPanel(){
		return this.descriptionPanel;
	}
	
	public void setMarkerPanel(MarkerPanel mp){
		this.descriptionPanel = mp;
	}

	public boolean isHighLighted() {
		return highLighted;
	}

	public void setHighLighted(boolean highLighted) {
		this.highLighted = highLighted;
	}
}
