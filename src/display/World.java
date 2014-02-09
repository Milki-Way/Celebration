package display;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tileengine.MapViewer;
import tools.Coordinate;
import display.editmode.EditPanel;

@SuppressWarnings("serial")
public class World extends JFrame{
	
	private static World instance;
	
	private MODE displayMode;
	private JPanel viewModePanel = new JPanel();
	private EditPanel editModePanel = new EditPanel();
	private MapViewer mapPanel;
	private SidePanel sidePanel;
	
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
		
		mapPanel = MapViewer.getInstance();
		viewModePanel.add(mapPanel, BorderLayout.CENTER);
		
		TopBar topPanel = new TopBar(mapPanel);
		viewModePanel.add(topPanel, BorderLayout.NORTH);
		
		sidePanel = new SidePanel(mapPanel);
		viewModePanel.add(sidePanel, BorderLayout.EAST);
		
		this.setContentPane(viewModePanel);
		this.displayMode = MODE.VIEWMODE;
		
		this.setVisible(true);
		this.revalidate();
        this.repaint();
	}
	
	public static World getInstance()
	{
		if (World.instance == null) {
			synchronized(World.class) {
				if (World.instance == null) {
					World.instance = new World();
				}
			}
		}
		return World.instance;
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


	/**
	 * @return the viewModePanel
	 */
	public JPanel getViewModePanel() {
		return viewModePanel;
	}


	/**
	 * @param viewModePanel the viewModePanel to set
	 */
	public void setViewModePanel(JPanel viewModePanel) {
		this.viewModePanel = viewModePanel;
	}


	/**
	 * @return the editModePanel
	 */
	public EditPanel getEditModePanel() {
		return editModePanel;
	}


	/**
	 * @param editModePanel the editModePanel to set
	 */
	public void setEditModePanel(EditPanel editModePanel) {
		this.editModePanel = editModePanel;
	}


	/**
	 * @return the mapPanel
	 */
	public MapViewer getMapPanel() {
		return mapPanel;
	}


	/**
	 * @param mapPanel the mapPanel to set
	 */
	public void setMapPanel(MapViewer mapPanel) {
		this.mapPanel = mapPanel;
	}


	/**
	 * @return the sidePanel
	 */
	public SidePanel getSidePanel() {
		return sidePanel;
	}


	/**
	 * @param sidePanel the sidePanel to set
	 */
	public void setSidePanel(SidePanel sidePanel) {
		this.sidePanel = sidePanel;
	}
}
