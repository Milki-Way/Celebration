package tileengine;

import java.awt.image.BufferedImage;

import entity.IEntity;
import tools.Coordinate;

public class Tile implements IEntity{
	
	public static final int TILE_HEIGHT = 256;
	public static final int TILE_WIDTH = 256;
	
	private Coordinate coord;
	private int zoom;
	private String keyTile;
	private BufferedImage tileContent;
	
	//Constructors
	public Tile(int zoom, Double column, Double row, BufferedImage content)
	{
		this.zoom = zoom;
		this.coord = new Coordinate(row, column);
		this.tileContent = content;
		this.keyTile = "";
	}
	
	//Return Key tile code
	public String KeyCode()
	{
		return String.format("%s/%s/%s", zoom, coord.getRow(), coord.getColumn());
	}
	
	public void buildKeyCode()
	{
		this.keyTile = String.format("%s/%s/%s", this.zoom, this.coord.getColumn(), this.coord.getRow()); 
	}

	/**
	 * @return the coord
	 */
	public Coordinate getCoords() {
		return coord;
	}

	/**
	 * @param coord the coord to set
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	/**
	 * @return the zoom
	 */
	public int getZoom() {
		return zoom;
	}

	/**
	 * @param zoom the zoom to set
	 */
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	/**
	 * @return the keyTile
	 */
	public String getKeyTile() {
		if(keyTile.length() < 1)
			this.buildKeyCode();
		return keyTile;
	}

	/**
	 * @param keyTile the keyTile to set
	 */
	public void setKeyTile(String keyTile) {
		this.keyTile = keyTile;
	}

	/**
	 * @return the tileContent
	 */
	public BufferedImage getTileContent() {
		return tileContent;
	}

	/**
	 * @param tileContent the tileContent to set
	 */
	public void setTileContent(BufferedImage tileContent) {
		this.tileContent = tileContent;
	}

	@Override
	public int getId() {
		return -1;
	}
}
