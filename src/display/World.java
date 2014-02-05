package display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tileengine.MapViewer;
import tools.Coordinate;

@SuppressWarnings("serial")
public class World extends JFrame{
	private MapViewer mapPanel;
	
	//  MAIN
	public static void main(String[] args){
		World w = new World();
		
		while(true)
		{
			w.repaintMap();
			
			try{
				Thread.sleep(1);
			} catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
		}
	}
	//  /MAIN
	
	
	public World(){
		this.setTitle("minisig");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		TopBar topPanel = new TopBar();
		getContentPane().add(topPanel, BorderLayout.NORTH);
		
		SidePanel sidePanel = new SidePanel();
		getContentPane().add(sidePanel, BorderLayout.EAST);
		
		mapPanel = new MapViewer(new Coordinate(63,85));
		mapPanel.setSize(512, 512);
		getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		this.setSize(750, 600);
		this.setVisible(true);
		
		this.revalidate();
        this.repaint();
		
		mapPanel.requestFocusInWindow();
	}
	
	public void repaintMap(){
		this.mapPanel.repaint();
	}
}
