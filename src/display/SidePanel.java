package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import tileengine.MapViewer;
import tools.Historic;
import tools.HistoricRow;
import tools.Observer;
import entity.Info;
import entity.Route;
import event.SidePanelHistoricEvent;
import event.SidePanelInfoEvent;
import event.SidePanelRouteEvent;

@SuppressWarnings("serial")
public class SidePanel extends JPanel implements Observer{
	
	private JLabel newsLabel;
	private JLabel routeLabel;
	private JLabel historicLabel;
	private JList<SpeHistoric> historicList;
	private JList<SpeRoute> routeList;
	private JList<SpeInfo> newsList;
	
	private MapViewer map;
	
	public SidePanel(MapViewer map){
		//properties
		this.setMinimumSize(new Dimension(0, 1000));
		this.setPreferredSize(new Dimension(200, 1000));
		this.setMaximumSize(new Dimension(200, 1000));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.map = map;
		Historic.getInstance().addObservateur(this);
		
		//Labels
		newsLabel = new JLabel("Vos derniers ajouts");
		routeLabel = new JLabel("Vos parcours");
		historicLabel = new JLabel("Historique");
		
		//Lists
		historicList = new SpeList<SpeHistoric>( new DefaultListModel<SpeHistoric>());
		newsList = new SpeList<SpeInfo>(new DefaultListModel<SpeInfo>());
		routeList = new SpeList<SpeRoute>(new DefaultListModel<SpeRoute>());

		historicList.addMouseListener(new SidePanelHistoricEvent());
		newsList.addMouseListener(new SidePanelInfoEvent());
		routeList.addMouseListener(new SidePanelRouteEvent());
		
		//Addition to panel
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
	
	//Add info in InfoList
	public void addInfo(Info i)
	{
		((DefaultListModel<SpeInfo>)newsList.getModel()).addElement(new SpeInfo(new SidePanelInfoEvent(), i));
		this.repaint();
	}
	
	//Add info in InfoList
	public void addRoute(Route r)
	{
		((DefaultListModel<SpeRoute>)routeList.getModel()).addElement(new SpeRoute(new SidePanelRouteEvent(), r));
		this.repaint();
	}
		
	//Add info in InfoList
	public void addHistoricRow(HistoricRow p)
	{
		((DefaultListModel<SpeHistoric>)historicList.getModel()).addElement(new SpeHistoric(new SidePanelHistoricEvent(), p));
		this.repaint();
	}

	@Override
	public void update() {
		((DefaultListModel<SpeHistoric>)historicList.getModel()).clear();
		for(HistoricRow h : Historic.getInstance().getHistoricList()){
			this.addHistoricRow(h);
		}
	}
	
	
}
