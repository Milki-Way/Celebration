package tileengine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import tools.Coordinate;
import entity.MapMarker;
import entity.Poi;

@SuppressWarnings("serial")
public class MapViewer extends JPanel{
	
	public static final int MAX_ZOOM = 14;
    public static final int MIN_ZOOM = 7;
    
    private int hMaxTiles = 2;
    private int wMaxTiles = 2;
    
    private int oldHMaxTiles = 2;
    private int oldWMaxTiles = 2;
	
	//FSP COUNTER VARs
	private long nextSecond = System.currentTimeMillis() + 1000;
	private int framesInLastSecond = 0;
	private int framesInCurrentSecond = 0;
	
	
	private TileCache tileCache;
	private TileController tileController;
	private MapController mapController;
	private Coordinate coords = new Coordinate(63,85);
	private int zoom = 7;
	
	private ArrayList<MapMarker> mapMarkerList = new ArrayList<MapMarker>();
	private Poi testPoi = new Poi(1, "Imperial Museum", new Coordinate(63.6, 85.6), null);
	private MapMarker test = new MapMarker(testPoi);
	
	public MapViewer(){
		this.setFocusable(true);
    	this.requestFocus();
    	
    	this.tileCache = TileCache.getInstance();
		this.tileController = new TileController(this);
		this.mapController = new MapController(this, this.tileController);
		this.tileController.initCache(this.mapController.getRealZoom());
		this.mapController.updateClickZones();
		
		this.setLayout(null);
		
		mapMarkerList.add(test);
		
		for(int i=0; i<mapMarkerList.size(); i++){
			this.add(mapMarkerList.get(i));
		}
		this.updateMapMarkerBounds();
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
		
		//FPS CALCULATOR
	    long currentTime = System.currentTimeMillis();
	  	if (currentTime > nextSecond) {
	  	    nextSecond += 1000;
	  	    framesInLastSecond = framesInCurrentSecond;
	  	    framesInCurrentSecond = 0;
	  	}
	  	framesInCurrentSecond++;
	  	
	  	updateMaxTiles();
	  	
	  	if((oldHMaxTiles != hMaxTiles) && (oldWMaxTiles != wMaxTiles)){
	  		this.tileController.initCache(this.mapController.getRealZoom());
	  		this.oldHMaxTiles = this.hMaxTiles;
	  		this.oldWMaxTiles = this.wMaxTiles;
	  		this.mapController.updateClickZones();;
	  	}
	  	
	  	//draw tiles
		if(this.tileCache.getCacheContent()[0][0] == null) 				//TiCache null alors on ne dessine rien
			return;
		
		for(int i=0; i<this.wMaxTiles; i++){
			for(int j=0; j<this.hMaxTiles; j++){
				this.drawTile(g2, this.tileCache.getCacheContent()[i+1][j+1], i*Tile.TILE_WIDTH, j*Tile.TILE_HEIGHT);
			}
		}


		//draw gird
		for(int i=1; i<=this.hMaxTiles; i++){
			g2.setColor(Color.gray);
			g2.drawLine(i*Tile.TILE_HEIGHT, 0, i*Tile.TILE_HEIGHT, this.getWidth());
		}
		for(int i=1; i<=this.wMaxTiles; i++){
			g2.setColor(Color.gray);
			g2.drawLine(0, i*Tile.TILE_HEIGHT, this.getHeight(), i*Tile.TILE_HEIGHT);
		}
		g2.setColor(Color.red);
		g2.drawRect((int)test.getBounds().getX(), (int)test.getBounds().getY(), 1, 1);
		
		test.repaint();
		
		g2.setColor(Color.gray);
		g2.drawString("fps:"+framesInLastSecond+" - MaxTiles["+wMaxTiles+"]["+hMaxTiles+"] - Zoom:"+this.zoom, 10, 10);
	}
	
	public void drawTile(Graphics2D g2, Tile tile,int x, int y){
		g2.drawImage(tile.getTileContent(), null, x, y);
		g2.drawString(tile.getCoords().toString(), x+10, y+30);
	}
	
	public void updateMaxTiles(){
		hMaxTiles = this.getHeight() / Tile.TILE_HEIGHT;
		wMaxTiles = this.getWidth() / Tile.TILE_WIDTH;
	}
	
	public void updateMapMarkerBounds(){
		
		for(int i=0; i<mapMarkerList.size(); i++){
			MapMarker cur = mapMarkerList.get(i);
			
			Dimension size = cur.getPreferredSize();
			
			cur.setBounds(
					(int)(
							(cur.getPoi().getCoords().getColumnDouble()-this.coords.getColumnDouble())
							*Tile.TILE_WIDTH
							*this.mapController.getRealZoom()
							), 
			
					(int)((this.gethMaxTiles()-1)*Tile.TILE_HEIGHT+
							(cur.getPoi().getCoords().getRowDouble()-this.coords.getRowDouble())
							*Tile.TILE_HEIGHT
							/this.mapController.getRealZoom()
							),
					
			size.width,
			size.height);
			System.out.println("MapMarker ["+cur.getBounds().getX()+"]["+cur.getBounds().getY()+"]");
		}		
	}

	public Coordinate getCoords() {
		return coords;
	}

	public void setCoords(Coordinate mapPosition) {
		this.coords = mapPosition;
	}

	public TileController getTileController() {
		return tileController;
	}

	public int gethMaxTiles() {
		return hMaxTiles;
	}

	public int getwMaxTiles() {
		return wMaxTiles;
	}

	public int getZoom() {
		return zoom;
	}	
	
	public void setZoom(int zoom){
		this.zoom = zoom;
	}
}
