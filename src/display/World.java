package display;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tileengine.MapViewer;

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
		
		mapPanel = new MapViewer();
		mapPanel.setSize(512, 512);
		getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		this.setSize(750, 600);
		this.setResizable(false);
		this.setVisible(true);
		
		this.revalidate();
        this.repaint();
		
		mapPanel.requestFocusInWindow();
	}
	
	public void repaintMap(){
		this.mapPanel.repaint();
	}
}