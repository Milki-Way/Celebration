package tools;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Coordinate {
	
	
	// ATTRIBUTE
	private Point2D.Double coords = new Point2D.Double();
	
	
	// CONSTRUCTOR
	public Coordinate(double column, double row) {
		this.coords.x = column;
		this.coords.y = row;
	}
	
	public Coordinate(int x, int y) {
		this((double) x, (double)y);
	}
	
	public Coordinate(float x, float y) {
		this((double)x, (double)y);
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
        return (int)coords.y;
    }

    public void setRow(int row) {
    	coords.y = row;
    }

    public int getColumn() {
        return (int)coords.x;
    }

    public void setColumn(int column) {
    	coords.x = column;
    }
    
    public double getRowDouble() {
        return coords.y;
    }

    public void setRowDouble(double row) {
    	coords.y = row;
    }

    public double getColumnDouble() {
        return coords.x;
    }

    public void setColumnDouble(double column) {
    	coords.x = column;
    }
    
    public String toString() {
        return "Coordinate[" + coords.x + ", " + coords.y + "]";
    }
}
