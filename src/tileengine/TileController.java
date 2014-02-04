package tileengine;

import java.awt.Point;

import tileengine.MapController.MapMoveEvent;
import tools.Coordinate;
import data.DataEngine;

public class TileController {
	
	private MapViewer map;
	private TileCache tileCache;
	
	public TileController(MapViewer map){
		this.map = map;
		this.tileCache = TileCache.getInstance();
	}
	
	public void initCache(){
		// remplissage au lancement du programme
		Coordinate p = this.map.getMapPosition();
		int hMaxTiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getwMaxTiles();
		int zoom = this.map.getZoom();
		
		for(int i=0; i<=wMaxTiles+1; i++){
			for(int j=0; j<=hMaxTiles+1; j++){
				this.tileCache.addTile(
						DataEngine.getInstance().LoadTile(
								zoom+6
								+"/"+(p.getColumn()*zoom-1+i)
								+"/"+(p.getRow()*zoom-1+j)), 
						new Point(i,j));
				System.out.println(this.tileCache.getCacheContent()[i][j].getKeyTile());
			}
		}
	}
	
	public void updateCache(MapMoveEvent e){ 						//Méthode appellée par le MapController
		Coordinate p = this.map.getMapPosition();
		int hMaxtiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getWidth();
		Tile[][] tmpCacheContent = this.tileCache.getCacheContent();
		
		
		if(e == MapMoveEvent.RIGHT) {
			
			System.arraycopy(this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent().length - 1);

			for(int i=0; i<tmpCacheContent[i].length; i++){			// on précharge les tiles de la dernière colonne
				tmpCacheContent[tmpCacheContent.length][i] = 
						DataEngine.getInstance().LoadTile(
								this.map.getZoom()					//
								+"/"+(p.getRow()+wMaxTiles)			// Key de la tile a charger
								+"/"+(p.getColumn()+hMaxtiles+i)	//
								);
			}
			
		} else if(e == MapMoveEvent.LEFT) {
			
			System.arraycopy(this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent().length-1);

			
		} else if(e == MapMoveEvent.UP) {

			
			
		} else if(e == MapMoveEvent.DOWN) {
			
			
		}
		
		this.tileCache.setCacheContent(tmpCacheContent);
	}

}
