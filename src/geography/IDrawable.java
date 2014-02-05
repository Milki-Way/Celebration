package geography;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import tools.Coordinate;

public interface IDrawable {
	
	public void paint(Graphics g);
	
	public Coordinate getCoords();
	
	public void setCoords(Coordinate coords);

	public String getLibelle();
}
