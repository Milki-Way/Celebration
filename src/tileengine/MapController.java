package tileengine;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tools.Coordinate;

public class MapController implements MouseListener, KeyListener {
	
	public enum MapMoveEvent {
		  RIGHT,
		  LEFT,
		  UP,
		  DOWN;
		}
	
	private MapViewer map;
	private TileController tileController;
	private int realZoom = 1;
	private Rectangle[][] zoneList;
	
    public MapController(MapViewer map, TileController tileController) {
    	this.map = map;
    	this.tileController = tileController;
    	this.zoneList = new Rectangle[100][100];

        map.addMouseListener((MouseListener) this);
        map.addKeyListener((KeyListener) this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	map.requestFocusInWindow();
    	map.requestFocus();
    	
    	if(this.map.getMapPanelList().size() > 0)
    		this.map.remove(this.map.getMapPanelList().get(0));
    	
    	if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
    		if(this.map.getZoom() < MapViewer.MAX_ZOOM){
    			
    			if((this.map.gethMaxTiles() != this.zoneList.length) && (this.map.getwMaxTiles() != this.zoneList[0].length))
        			this.updateClickZones();
    			
    			int h = this.map.gethMaxTiles();
    			int w = this.map.getwMaxTiles();
    			
    			for(int i=0; i<w; i++){
    				for(int j=0; j<h; j++){
    					if(this.zoneList[i][j].contains(e.getPoint())){
    						System.out.println("Zone["+i+"]["+j+"] clicked");
    						this.map.setCoords(
    								new Coordinate(
    										this.map.getCoords().getColumnDouble()+1.0*i/realZoom,
    										this.map.getCoords().getRowDouble()+1.0*j/realZoom));
    						
    						this.map.setZoom(this.map.getZoom()+1);
    		        		this.realZoom*=2;
    		    			this.tileController.initCache(this.realZoom);
    					}
    				}
    			}
    			this.map.updateMapMarkerBounds();
    		}
    	}
    	if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
    		if(this.map.getZoom() > MapViewer.MIN_ZOOM){
    			
    			if((this.map.gethMaxTiles() != this.zoneList.length) && (this.map.getwMaxTiles() != this.zoneList[0].length))
        			this.updateClickZones();
    			
    			this.map.setCoords(
    					new Coordinate(
    							this.map.getInitialCoords().getColumnDouble(),
    							this.map.getInitialCoords().getRowDouble()));
    						
    			this.map.setZoom(this.map.getInitialZoom());
    		    this.realZoom=1;
    		    this.tileController.initCache(this.realZoom);

    			this.map.updateMapMarkerBounds();
    		}
    	}
    	
    	this.map.repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
	
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

	@Override
	public void keyPressed(KeyEvent e) {
		
		Coordinate p = this.map.getCoords();
		
		switch (e.getKeyCode())
		{
		  case (KeyEvent.VK_RIGHT):
			  	this.map.setCoords(new Coordinate(p.getColumnDouble()+(1.0/realZoom), p.getRowDouble()));
		  		this.map.getTileController().updateCache(MapMoveEvent.RIGHT);
		  		break;
		  case (KeyEvent.VK_LEFT):
			  	this.map.setCoords(new Coordinate(p.getColumnDouble()-(1.0/realZoom), p.getRowDouble()));
		  		this.map.getTileController().updateCache(MapMoveEvent.LEFT);
		  		break;
		  case (KeyEvent.VK_UP):
			  	this.map.setCoords(new Coordinate(p.getColumnDouble(), p.getRowDouble()+(1.0/realZoom)));
		  		this.map.getTileController().updateCache(MapMoveEvent.UP);
			    break;
		  case (KeyEvent.VK_DOWN):
			  	this.map.setCoords(new Coordinate(p.getColumnDouble(), p.getRowDouble()-(1.0/realZoom)));
		  		this.map.getTileController().updateCache(MapMoveEvent.DOWN);
			    break;
		  default:
			  return;
		}
		this.tileController.initCache(realZoom);
		this.map.updateMapMarkerBounds();
		this.map.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public int getRealZoom() {
		return realZoom;
	}
	
	public void updateClickZones(){
		this.zoneList = new Rectangle[100][100];
		
		this.map.updateMaxTiles();
		int h = this.map.gethMaxTiles();
		int w = this.map.getwMaxTiles();
		
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
				this.zoneList[i][j] = new Rectangle(i*Tile.TILE_HEIGHT,(w-j-1)*Tile.TILE_WIDTH, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
				System.out.println(this.zoneList[i][j].toString());
			}
		}
	}
}