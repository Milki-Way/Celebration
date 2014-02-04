package tools;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Coordinate {
	
	
	// ATTRIBUTE
	private Point coords = new Point();
	
	
	// CONSTRUCTOR
	public Coordinate(int row, int column) {
		this.coords.x = row;
		this.coords.y = column;
	}
	
	public Coordinate(double x, double y) {
		this((int)x, (int)y);
	}
	
	public Coordinate(float x, float y) {
		this((int)x, (int)y);
	}
	
	public Coordinate(Point p) {
		this(p.getX(), p.getY());
	}
	
	public Coordinate(Point2D.Double p) {
		this(p.getX(), p.getY());
	}
	
	public Coordinate(Point2D.Float p) {
		this(p.getX(), p.getY());
	}
	
	
	// SETTER - GETTER
	public int getRow() {
        return coords.y;
    }

    public void setRow(int row) {
    	coords.y = row;
    }

    public int getColumn() {
        return coords.x;
    }

    public void setColumn(int column) {
    	coords.x = column;
    }
    
    public String toString() {
        return "Coordinate[" + coords.y + ", " + coords.x + "]";
    }
}
