package display;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tileengine.MapViewer;
import entity.DescriptionComplex;
import entity.Info;
import entity.Poi;
import entity.Route;

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
		Poi test1 = new Poi("Poi test", 0, 0, new DescriptionComplex());
		Poi test2 = new Poi("Poi test", 0, 0, new DescriptionComplex());
		Poi test3 = new Poi("Poi test", 0, 0, new DescriptionComplex());
		
		Route r = new Route("Mon parcours", test1,test2, test3);

		sidePanel.addHistoricPoi(test1);
		sidePanel.addHistoricPoi(test2);
		sidePanel.addHistoricPoi(test3);
		

		sidePanel.addRoute(r);
		sidePanel.addInfo(new Info("Une news!", -1));
		
		
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
