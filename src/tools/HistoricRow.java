package tools;

public class HistoricRow {

	private Coordinate mapPosition;
	private int zoom;
	private int realZoom;
	
	public HistoricRow(Coordinate mapPosition, int zoom, int realZoom){
		this.mapPosition = mapPosition;
		this.zoom = zoom;
		this.realZoom = realZoom;
	}

	public Coordinate getMapPosition() {
		return mapPosition;
	}

	public void setMapPosition(Coordinate mapPosition) {
		this.mapPosition = mapPosition;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public int getRealZoom() {
		return realZoom;
	}

	public void setRealZoom(int realZoom) {
		this.realZoom = realZoom;
	}
	
	public String toString(){
		return "HistoricRow["+this.getMapPosition().toString()+"], Zoom["+this.getZoom()+"], RealZoom["+this.getRealZoom()+"]";
	}
}
