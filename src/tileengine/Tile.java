package tileengine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tools.Coordinate;

public class Tile {
	private Coordinate coord;
	private int zoom;
	private String keyTile;
	private BufferedImage tileContent;
	
	//Constructors
	public Tile(int zoom, int column, int row, BufferedImage content)
	{
		this.zoom = zoom;
		this.coord = new Coordinate(row, column);
		this.tileContent = content;
		this.keyTile = "";
	}
	
	//load image from file with attributes
	private void loadImg()
	{
			loadImg(coord.getRow(), coord.getColumn(), zoom);
	}
	
	//load image from file with parameters
	public void loadImg(double lat, double lon, int zoom)
	{
		String filename = String.format("data/tiles/%s/%s_%s", zoom, lat, lon);
		try {
			System.out.println(filename);
			this.tileContent = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//load image from file with parameters
		public void loadImg(String keyCode)
		{
			String result[] = keyCode.split("/");
			if(result.length < 3)
				System.out.println("Error in Keycode : Number of values doesn't match (3 expected)");
			else
			{
				zoom = Integer.parseInt(result[0]);
				coord = new Coordinate(Double.parseDouble(result[1]), Double.parseDouble(result[2]));
				loadImg();
			}
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
	public Coordinate getCoord() {
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
}
