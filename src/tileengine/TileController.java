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
				TileCache.getInstance().addTile(
						DataEngine.getInstance().LoadTile(
								zoom+6
								+"/"+(p.getColumn()*zoom-1+i)
								+"/"+(p.getRow()*zoom-1+j)), 
						new Point(i,j));
				System.out.println(TileCache.getInstance().getCacheContent()[i][j].getKeyTile());
			}
		}
	}
	
	public void updateCache(MapMoveEvent e){ 						//Méthode appellée par le MapController
		Coordinate p = this.map.getMapPosition();
		int hMaxTiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getWidth();		
		int zoom = this.map.getZoom();
		
		if(e == MapMoveEvent.RIGHT) {
			
			//MOVE ARRAY RIGHT
			System.arraycopy(this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent().length-1);

			//LOAD EMPTY SIDE OF ARRAY
			for(int i=0; i<TileCache.getInstance().getCacheContent()[i].length; i++){			// on précharge les tiles de la dernière colonne
				TileCache.getInstance().getCacheContent()[i][wMaxTiles+1] = 
						DataEngine.getInstance().LoadTile(
								this.map.getZoom()					//
								+"/"+(p.getRow()+wMaxTiles)			// Key de la tile a charger
								+"/"+(p.getColumn()+hMaxTiles+i)	//
								);
			}
			
		} else if(e == MapMoveEvent.LEFT) {
			
			//MOVE ARRAY LEFT
			System.arraycopy(this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent().length - 1);
			
			//LOAD EMPTY SIDE OF ARRAY
			
			
		} else if(e == MapMoveEvent.UP) {

			//MOVE ARRAY UP
			for(int i=0; i<=wMaxTiles+1; i++){
				for(int j=0; j<=hMaxTiles; j++){
					TileCache.getInstance().getCacheContent()[i][j] = TileCache.getInstance().getCacheContent()[i][j+1];
				}
			}
			
			//LOAD EMPTY SIDE OF ARRAY
			
		} else if(e == MapMoveEvent.DOWN) {
			
			//MOVE ARRAY UP
			for(int i=0; i<=wMaxTiles+1; i++){
				for(int j=1; j<=hMaxTiles+1; j++){
					TileCache.getInstance().getCacheContent()[i][j] = TileCache.getInstance().getCacheContent()[i][j-1];
				}
			}
			
			//LOAD EMPTY SIDE OF ARRAY
			
		}
	}

}
