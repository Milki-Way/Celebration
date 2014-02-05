package tileengine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.MapMarker;

public class MapMarkerController implements MouseListener{
	
	private MapMarker mapMarker;
	
	public MapMarkerController(MapMarker mapMarker){
		this.mapMarker = mapMarker;
		
		mapMarker.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("MapMarker "+this.mapMarker.getPoi().getLibelle()+" get clicked !");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	
}
