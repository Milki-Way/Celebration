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

@SuppressWarnings("serial")
public class SidePanel extends JPanel{
	
	private JLabel newsLabel;
	private JLabel routeLabel;
	private JLabel historicLabel;
	private JList<String> historicList;
	private JList<String> routeList;
	private JList<String> newsList;
	
	public SidePanel(){
		this.setMinimumSize(new Dimension(0, 1000));
		this.setPreferredSize(new Dimension(200, 1000));
		this.setMaximumSize(new Dimension(200, 1000));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		newsLabel = new JLabel("News");
		
		routeLabel = new JLabel("Parcours");
		
		historicLabel = new JLabel("Historique");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Jane Doe");
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");
		
		historicList = new JList<String>(listModel);
		historicList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		historicList.setLayoutOrientation(JList.VERTICAL);
		
		routeList = new JList<String>(listModel);
		routeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		routeList.setLayoutOrientation(JList.VERTICAL);
		
		newsList = new JList<String>(listModel);
		routeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
		
		//faites ce que vous voulez.
	}
}
