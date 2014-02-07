package display;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.DataEngine;
import display.editmode.EditPanel;
import tileengine.MapViewer;
import tools.Coordinate;

@SuppressWarnings("serial")
public class World extends JFrame{
	
	private static World instance;
	
	private MODE displayMode;
	private JPanel viewModePanel = new JPanel();
	private EditPanel editModePanel = new EditPanel();
	private MapViewer mapPanel;
	
	public enum MODE {
		  VIEWMODE,
		  EDITMODE;
		}
	
	public static void main(String[] args){
		World.getInstance();
	}
	
	
	private World(){
		this.setTitle("minisig");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 600);
		
		viewModePanel.setLayout(new BorderLayout(0, 0));
		
		TopBar topPanel = new TopBar();
		viewModePanel.add(topPanel, BorderLayout.NORTH);
		
		SidePanel sidePanel = new SidePanel();
		viewModePanel.add(sidePanel, BorderLayout.EAST);
		
		mapPanel = new MapViewer(new Coordinate(63,85));
		viewModePanel.add(mapPanel, BorderLayout.CENTER);
		
		this.setContentPane(viewModePanel);
		this.displayMode = MODE.VIEWMODE;
		
		
		this.setVisible(true);
		
		this.revalidate();
        this.repaint();
	}
	
	public static World getInstance()
	{
		if(instance == null)
			instance = new World();
		return instance;
	}
	
	public void switchMode(){
		if(this.displayMode == MODE.VIEWMODE){
			this.setContentPane(this.editModePanel);
			this.editModePanel.setVisible(true);
			this.viewModePanel.setVisible(false);
			this.displayMode = MODE.EDITMODE;
		} else if (this.displayMode == MODE.EDITMODE) {
			this.setContentPane(this.viewModePanel);
			this.editModePanel.setVisible(false);
			this.viewModePanel.setVisible(true);
			this.displayMode = MODE.VIEWMODE;
		}
	}
	
	public void repaintMap(){
		this.mapPanel.repaint();
	}
	
	public MODE getDisplayMode(){
		return this.displayMode;
	}
}
