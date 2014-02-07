package tileengine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import tools.Historic;
import tools.HistoricRow;
import display.MarkerPanel;
import entity.MapMarker;

public class MapMarkerController implements MouseListener{
	
	private MapMarker mapMarker;
	private MapViewer map;
	
	public MapMarkerController(MapMarker mapMarker, MapViewer map){
		this.mapMarker = mapMarker;
		this.map = map;
		
		mapMarker.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {		
		ArrayList<MarkerPanel> a = new ArrayList<MarkerPanel>();
		a.add(this.mapMarker.getMarkerPanel());
		this.map.setMapPanelList(a);
		Historic.getInstance().getHistoricList().add(new HistoricRow(this.map.getCoords(), this.map.getZoom(), this.map.getMapController().getRealZoom()));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.mapMarker.setDrawLibelle(true);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.mapMarker.setDrawLibelle(false);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	
}
