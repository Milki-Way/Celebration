package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import tileengine.MapViewer;
import tools.Historic;
import tools.HistoricRow;
import tools.Observer;
import data.DataEngine;
import data.mapper.MapperEnum;
import entity.IEntity;
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
	private JLabel searchLabel;
	private JList<SpeHistoric> historicList;
	private JList<SpeRoute> routeList;
	private JList<SpeInfo> newsList;
	private JList<SpeRecherche> searchList;
	
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
		searchLabel = new JLabel("Résultat de vos recherche");
		
		//Lists
		historicList = new SpeList<SpeHistoric>( new DefaultListModel<SpeHistoric>());
		newsList = new SpeList<SpeInfo>(new DefaultListModel<SpeInfo>());
		routeList = new SpeList<SpeRoute>(new DefaultListModel<SpeRoute>());
		searchList = new SpeList<SpeRecherche>(new DefaultListModel<SpeRecherche>());

		historicList.addMouseListener(new SidePanelHistoricEvent());
		newsList.addMouseListener(new SidePanelInfoEvent());
		routeList.addMouseListener(new SidePanelRouteEvent());
		searchList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Result event");
				
			}
		});
		
		//Addition to panel
		this.add(newsLabel);
		this.add(newsList);
		this.add(routeLabel);
		this.add(searchLabel);
		this.add(routeList);
		this.add(historicLabel);
		this.add(historicList);
		this.add(searchList);
		
		for(IEntity i : DataEngine.getInstance().Load(MapperEnum.INFO)){
			if(i instanceof Info){
				this.addInfo((Info)i);
			}
		}
		for(IEntity r : DataEngine.getInstance().Load(MapperEnum.PARCOURS)){
			if(r instanceof Route){
				this.addRoute((Route)r);
			}
		}
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
	
	//add info in SearchList
	public void addSearchResult(ResultItem s)
	{
		((DefaultListModel<SpeRecherche>)searchList.getModel()).addElement(new SpeRecherche(new SidePanelHistoricEvent(), s));
	}

	@Override
	public void update() {
		((DefaultListModel<SpeHistoric>)historicList.getModel()).clear();
		for(HistoricRow h : Historic.getInstance().getHistoricList()){
			this.addHistoricRow(h);
		}
	}
	
	
}
