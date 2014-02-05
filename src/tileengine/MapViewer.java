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
	private Coordinate coords;
	private int zoom = 7;
	
	private ArrayList<MapMarker> mapMarkerList = new ArrayList<MapMarker>();
	private Poi testPoi = new Poi(1, "Imperial Museum", new Coordinate(63.6, 85.6), null);
	private MapMarker test = new MapMarker(testPoi);
	
	public MapViewer(Coordinate coords){
		this.setFocusable(true);
    	this.requestFocus();
    	
    	this.coords = coords;
    	
    	this.tileCache = TileCache.getInstance();
		this.tileController = new TileController(this);
		this.mapController = new MapController(this, this.tileController);
		this.tileController.initCache(this.mapController.getRealZoom());
		this.mapController.updateClickZones();
		
		this.setLayout(null);
		
		mapMarkerList.add(test);	// a remplacer par la recuperation des marqueurs par le DataEngine
		
		for(int i=0; i<mapMarkerList.size(); i++){	// On ajoute les marqueurs � la map
			this.add(mapMarkerList.get(i));
			new MapMarkerController(mapMarkerList.get(i));
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
	  	
	  	this.updateMaxTiles();
	  	
	  	if((oldHMaxTiles != hMaxTiles) && (oldWMaxTiles != wMaxTiles)){
	  		this.tileController.initCache(this.mapController.getRealZoom());
	  		this.oldHMaxTiles = this.hMaxTiles;
	  		this.oldWMaxTiles = this.wMaxTiles;
	  		this.mapController.updateClickZones();;
	  	}
	  	
	  	//draw tiles
		if(this.tileCache.getCacheContent()[0][0] == null){	//TileCache null alors on ne dessine rien
			
			System.out.println("Error: TileCache vide.");
			
		}else{
			for(int i=0; i<this.wMaxTiles; i++){			//Si le TileCache est rempli, on dessine toute les tuiles qu'il contient					
				for(int j=0; j<this.hMaxTiles; j++){
					this.drawTile(g2, this.tileCache.getCacheContent()[i+1][j+1], i*Tile.TILE_WIDTH, j*Tile.TILE_HEIGHT);
				}
			}
		}

		for(int i=1; i<=this.hMaxTiles; i++){				// On dessine la grille
			g2.setColor(Color.gray);
			g2.drawLine(i*Tile.TILE_WIDTH, 0, i*Tile.TILE_WIDTH, this.getWidth());
		}
		for(int i=1; i<=this.wMaxTiles; i++){
			g2.setColor(Color.gray);
			g2.drawLine(0, i*Tile.TILE_HEIGHT, this.getHeight(), i*Tile.TILE_HEIGHT);
		}
		g2.setColor(Color.red);
		g2.drawRect((int)test.getBounds().getX(), (int)test.getBounds().getY(), 1, 1);
		
		for(int i=0; i<mapMarkerList.size(); i++){	// On dessine les marqueurs
			mapMarkerList.get(i).repaint();;
		}
		
		g2.setColor(Color.gray);
		g2.drawString("fps:"+framesInLastSecond+" - MaxTiles["+wMaxTiles+"]["+hMaxTiles+"] - Zoom:"+this.zoom, 10, 10);
	}
	
	public void drawTile(Graphics2D g2, Tile tile,int x, int y){
		g2.drawImage(tile.getTileContent(), null, x, y);
		g2.drawString(tile.getCoords().toString(), x+10, y+30);
	}
	
	public void updateMaxTiles(){
		hMaxTiles = this.getHeight() / Tile.TILE_HEIGHT; // mettre a jour le nombre de tuile maximum affichable � l'�cran
		wMaxTiles = this.getWidth() / Tile.TILE_WIDTH;
	}
	
	public void updateMapMarkerBounds(){
		
		for(int i=0; i<mapMarkerList.size(); i++){
			MapMarker cur = mapMarkerList.get(i);
			
			Dimension size = cur.getPreferredSize();
			
			cur.setBounds(
						(int)(	    	//   X
								(cur.getPoi().getCoords().getColumnDouble()-this.coords.getColumnDouble())
								*Tile.TILE_WIDTH
								*this.mapController.getRealZoom()
							 ), 
				
						(int)(	   		//   Y
								(this.gethMaxTiles()-1)*Tile.TILE_HEIGHT+ // on d�place l'axe des ordonn�es en haut a gauche de la tile la plus basse
								(cur.getPoi().getCoords().getRowDouble()-this.coords.getRowDouble())// diff�rence coordonn�e marker - map
								*Tile.TILE_HEIGHT													//on converti cette diff�rence en pixel
								*this.mapController.getRealZoom()									//on adapte le tout au zoom actuel
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
