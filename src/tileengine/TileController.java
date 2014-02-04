package tileengine;

import data.DataEngine;
import tileengine.MapController.MapMoveEvent;
import tools.Coordinate;

public class TileController {
	
	private MapViewer map;
	private TileCache tileCache;
	
	public TileController(MapViewer map){
		this.map = map;
		this.tileCache = TileCache.getInstance();
	}
	
	public void initCache(){ 										// remplissage au lancement du programme
		Coordinate p = this.map.getMapPosition();
		int hMaxTiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getwMaxTiles();
		Tile[][] tmpCacheContent = this.tileCache.getCacheContent();
		
		for(int i=0; i<=hMaxTiles+1; i++){
			for(int j=0; j<=wMaxTiles+1; j++){
				tmpCacheContent[i][j] = DataEngine.getInstance().LoadTile(
						this.map.getZoom()
						+"/"+(p.getRow()+i)
						+"/"+(p.getColumn()+j)
						);
			}
		}
		
		this.tileCache.setCacheContent(tmpCacheContent);
	}
	
	public void updateCache(MapMoveEvent e){ 						//Méthode appellée par le MapController
		Coordinate p = this.map.getMapPosition();
		int hMaxtiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getWidth();
		Tile[][] tmpCacheContent = this.tileCache.getCacheContent();
		
		
		if(e == MapMoveEvent.RIGHT) {
			
			for(int i=0; i<tmpCacheContent.length-1; i++){			// on décale toutes les tiles vers la gauche
				for(int j=0; i<tmpCacheContent[i].length; j++){
					
					tmpCacheContent[i][j] = tmpCacheContent[i+1][j];
				}
			}
			
			for(int i=0; i<tmpCacheContent[i].length; i++){			// on précharge les tiles de la dernière colonne
				tmpCacheContent[tmpCacheContent.length][i] = 
						DataEngine.getInstance().LoadTile(
								this.map.getZoom()					//
								+"/"+(p.getRow()+wMaxTiles)			// Key de la tile a charger
								+"/"+(p.getColumn()+hMaxtiles+i)	//
								);
			}
			
		} else if(e == MapMoveEvent.LEFT) {
			
			
			
		} else if(e == MapMoveEvent.UP) {

			
			
		} else if(e == MapMoveEvent.DOWN) {
			
			
		}
		
		this.tileCache.setCacheContent(tmpCacheContent);
	}

}
