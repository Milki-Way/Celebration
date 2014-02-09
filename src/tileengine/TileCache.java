package tileengine;

import java.awt.Point;

public class TileCache{

	private static volatile TileCache instance;
	
	private Tile[][] cacheContent;
	
	private TileCache(){
		cacheContent = new Tile[100][100];
	}
	
	public final static TileCache getInstance(){
		if (TileCache.instance == null) {
			synchronized(TileCache.class) {
				if (TileCache.instance == null) {
					TileCache.instance = new TileCache();
				}
			}
		}
		return TileCache.instance;
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
	
	public void printCacheState(){
		System.out.println("\tTileCache STATE");
		System.out.println("----------------------------------");
		for(int i=0; i<=2+1; i++){
			for(int j=0; j<=2+1; j++){
				System.out.print("|"+this.getCacheContent()[i][2+1-j].getKeyTile()+"|");
			}
			System.out.println("\n----------------------------------");
		}
	}
}
