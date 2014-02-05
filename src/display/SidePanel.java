package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import entity.Info;
import entity.Poi;
import entity.Route;

@SuppressWarnings("serial")
public class SidePanel extends JPanel{
	
	private JLabel newsLabel;
	private JLabel routeLabel;
	private JLabel historicLabel;
	private JList<SpeHistoric> historicList;
	private JList<SpeRoute> routeList;
	private JList<SpeInfo> newsList;
	
	public SidePanel(){
		//properties
		this.setMinimumSize(new Dimension(0, 1000));
		this.setPreferredSize(new Dimension(200, 1000));
		this.setMaximumSize(new Dimension(200, 1000));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Labels
		newsLabel = new JLabel("Vos derniers ajouts");
		routeLabel = new JLabel("Vos parcours");
		historicLabel = new JLabel("Historique");
		
		//Lists
		historicList = new JList<SpeHistoric>( new DefaultListModel<SpeHistoric>());
		newsList = new JList<SpeInfo>(new DefaultListModel<SpeInfo>());
		routeList = new JList<SpeRoute>(new DefaultListModel<SpeRoute>());
		historicList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		newsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		routeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		historicList.setLayoutOrientation(JList.VERTICAL);
		newsList.setLayoutOrientation(JList.VERTICAL);
		routeList.setLayoutOrientation(JList.VERTICAL);
		
		this.add(newsLabel);
		this.add(historicList);
		
		this.add(routeLabel);
		this.add(routeList);
		
		this.add(historicLabel);
		this.add(newsList);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
	}
	
	
}
