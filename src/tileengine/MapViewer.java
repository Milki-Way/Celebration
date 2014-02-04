package tileengine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import tools.Coordinate;

@SuppressWarnings("serial")
public class MapViewer extends JPanel{
	
	public static final int MAX_ZOOM = 14;
    public static final int MIN_ZOOM = 8;
    
    private int hMaxTiles = 2;
    private int wMaxTiles = 2;
	
	//FSP COUNTER VARs
	private long nextSecond = System.currentTimeMillis() + 1000;
	private int framesInLastSecond = 0;
	private int framesInCurrentSecond = 0;
	
	
	private TileCache tileCache;
	private TileController tileController;
	private Coordinate mapPosition = new Coordinate(new Point(85,63));
	private int zoom = 8;
	
	public MapViewer(){		
		this.setFocusable(true);
    	this.requestFocus();
		
		new MapController(this);
		this.tileCache = TileCache.getInstance();
		this.tileController = new TileController(this);
		this.tileController.initCache();
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
	  	
		if(this.tileCache.getCacheContent()[0][0] == null) 				//TiCache null alors on ne dessine rien
			return;
		
		for(int i=0; i<this.hMaxTiles; i++){
			for(int j=0; j<this.wMaxTiles; j++){
				this.drawTile(g2, this.tileCache.getCacheContent()[i+1][j+1], i*Tile.TILE_WIDTH, j*Tile.TILE_HEIGHT);
			}
		}
		
		g2.drawString("fps:"+framesInLastSecond+" - MaxTiles["+wMaxTiles+"]["+hMaxTiles+"]", 10, 10);
	}
	
	public void drawTile(Graphics2D g2, Tile tile,int x, int y){
		g2.drawImage(tile.getTileContent(), null, x, y);
	}
	
	public void updateMaxTiles(){
		hMaxTiles = this.getHeight() / Tile.TILE_HEIGHT;
		wMaxTiles = this.getWidth() / Tile.TILE_WIDTH;
	}

	public Coordinate getMapPosition() {
		return mapPosition;
	}

	public void setMapPosition(Coordinate mapPosition) {
		this.mapPosition = mapPosition;
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
	
	
}
