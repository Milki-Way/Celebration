package tileengine;

import java.awt.Point;

public class TileCache {

	private static TileCache instance;
	
	private Tile[][] cacheContent;
	
	private TileCache(){
		cacheContent = new Tile[50][50];
	}
	
	public static TileCache getInstance(){
		if(instance != null){
			return instance;
		} else {
			instance = new TileCache();
			return instance;
		}
	}
	
	public void addTile(Tile tile, Point cachePosition){
		this.cacheContent[(int)cachePosition.getX()][(int)cachePosition.getY()] = tile;
	}
	
	public void removeTile(Tile tile){
		for(int i=0; i<cacheContent.length;i++){
			for(int j=0; i<cacheContent[i].length;j++){
				if(this.cacheContent[i][j].equals(tile)){
					this.cacheContent[i][j] = null;
				}
			}
		}
	}
	
	public void removeTile(String key){
		for(int i=0; i<cacheContent.length;i++){
			for(int j=0; i<cacheContent[i].length;j++){
				if(this.cacheContent[i][j].getKeyTile() == key){
					this.cacheContent[i][j] = null;
				}
			}
		}
	}
	
	public void removeTile(Point cachePosition){
		this.cacheContent[(int)cachePosition.getX()][(int)cachePosition.getY()] = null;
	}

	public Tile[][] getCacheContent() {
		return cacheContent;
	}

	public void setCacheContent(Tile[][] cacheContent) {
		this.cacheContent = cacheContent;
	}
}
