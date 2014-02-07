package tileengine;

import java.awt.Point;

import tileengine.MapController.MapMoveEvent;
import tools.Coordinate;
import data.DataEngine;

public class TileController {
	
	private MapViewer map;
	private TileCache tileCache;
	private int realZoom;
	
	public TileController(MapViewer map){
		this.map = map;
		this.tileCache = TileCache.getInstance();
	}
	
	public void initCache(int realZoom){
		// remplissage au lancement du programme
		Coordinate p = this.map.getCoords();
		int hMaxTiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getwMaxTiles();
		this.realZoom = realZoom;
		
		for(int i=0; i<=wMaxTiles+1; i++){
			for(int j=0; j<=hMaxTiles+1; j++){
				TileCache.getInstance().addTile(
						DataEngine.getInstance().LoadTile(
								this.map.getZoom()
								+"/"+(p.getColumnDouble()*realZoom-1.0+i)
								+"/"+(p.getRowDouble()*realZoom-1.0+j)), 
						new Point(i,hMaxTiles+1-j));
				System.out.println(TileCache.getInstance().getCacheContent()[i][hMaxTiles+1-j].getKeyTile()+" to ["+i+","+(hMaxTiles+1-j)+"]");
			}
		}
		
		System.out.println("Map "+p.toString());
		TileCache.getInstance().printCacheState();
	}
	
	public void updateCache(MapMoveEvent e){ 						//Méthode appellée par le MapController
		
		/*
		Coordinate p = this.map.getCoords();
		int hMaxTiles = this.map.gethMaxTiles();
		int wMaxTiles = this.map.getwMaxTiles();	
		
		if(e == MapMoveEvent.RIGHT) {
			
			//MOVE ARRAY RIGHT
			System.arraycopy(this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent().length-1);

			//LOAD EMPTY SIDE OF ARRAY
			for(int i=0; i<=hMaxTiles+1; i++){			// on précharge les tiles de la dernière colonne
				System.out.println("Chargement Tiles à droite");
				TileCache.getInstance().addTile(
						DataEngine.getInstance().LoadTile(
							this.map.getZoom()
							+"/"+(p.getRow()*realZoom+hMaxTiles+1)
							+"/"+(p.getColumn()*realZoom+wMaxTiles+i)),
						new Point(wMaxTiles+1,hMaxTiles+1-i));
				
				System.out.println(
						this.map.getZoom()
						+"/"+(p.getRow()*realZoom+hMaxTiles+1)
						+"/"+(p.getColumn()*realZoom+wMaxTiles+i)
						+" to ["+(wMaxTiles+1)+","+(hMaxTiles+1-i)+"]");
			}
			
			
			
		} else if(e == MapMoveEvent.LEFT) {
			
			//MOVE ARRAY LEFT
			System.arraycopy(this.tileCache.getCacheContent(), 0, this.tileCache.getCacheContent(), 1, this.tileCache.getCacheContent().length - 1);
			
			//LOAD EMPTY SIDE OF ARRAY
			for(int i=0; i<=hMaxTiles+1; i++){			// on précharge les tiles de la première colonne
				System.out.println("Chargement Tiles à gauche");
				TileCache.getInstance().addTile(
						DataEngine.getInstance().LoadTile(
							this.map.getZoom()
							+"/"+(p.getRow()*realZoom-1)
							+"/"+(p.getColumn()*realZoom+i)),
						new Point(0,hMaxTiles+1-i));
				
				System.out.println(
						this.map.getZoom()
						+"/"+(p.getRow()*realZoom+1)
						+"/"+(p.getColumn()*realZoom+i)
						+" to ["+0+","+i+"]");
			}
			
		} else if(e == MapMoveEvent.UP) {

			//MOVE ARRAY UP
			for(int i=0; i<=wMaxTiles+1; i++){
				for(int j=1; j<=hMaxTiles+1; j++){
					TileCache.getInstance().getCacheContent()[i][j] = TileCache.getInstance().getCacheContent()[i][j-1];
				}
			}
			
			//LOAD EMPTY SIDE OF ARRAY
			
		} else if(e == MapMoveEvent.DOWN) {
			
			//MOVE ARRAY UP
			for(int i=1; i<=wMaxTiles+1; i++){
				for(int j=0; j<=hMaxTiles; j++){
					TileCache.getInstance().getCacheContent()[i][j] = TileCache.getInstance().getCacheContent()[i][j+1];
				}
			}
			
			//LOAD EMPTY SIDE OF ARRAY
			
		}
		*/
	}
}
