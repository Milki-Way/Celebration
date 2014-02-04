package tileengine;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MapController implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	public enum MapMoveEvent {
		  RIGHT,
		  LEFT,
		  UP,
		  DOWN;
		}
	
	protected MapViewer map;
	
    public MapController(MapViewer map) {
    	this.map = map;
    	
        map.addMouseListener((MouseListener) this);
        map.addMouseWheelListener((MouseWheelListener) this);
        map.addMouseMotionListener((MouseMotionListener) this);
        map.addKeyListener((KeyListener) this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
	public void mouseMoved(MouseEvent e) {
    }
	
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("MapController : "+e.getKeyChar());
		
		Point p = this.map.getLocation();
		
		switch (e.getKeyCode())
		{
		  case (KeyEvent.VK_RIGHT):
			  	this.map.setLocation(new Point((int)p.getX()+1, (int)p.getY()));
		  		this.map.getTileController().updateCache(MapMoveEvent.RIGHT);
		  		break;
		  case (KeyEvent.VK_LEFT):
			  	this.map.setLocation(new Point((int)p.getX()-1, (int)p.getY()));
		  		this.map.getTileController().updateCache(MapMoveEvent.LEFT);
		  		break;
		  case (KeyEvent.VK_UP):
			  	this.map.setLocation(new Point((int)p.getX(), (int)p.getY()+1));
		  		this.map.getTileController().updateCache(MapMoveEvent.UP);
			    break;
		  case (KeyEvent.VK_DOWN):
			  	this.map.setLocation(new Point((int)p.getX(), (int)p.getY()-1));
		  		this.map.getTileController().updateCache(MapMoveEvent.DOWN);
			    break;
		  default:
		    return;             
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}