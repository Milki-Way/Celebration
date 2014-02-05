package display;

import geography.Map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener; 
@SuppressWarnings("serial")
public class SidePanel extends JPanel implements MouseListener{
	 
	private JLabel infoLabel; 
	private JLabel routeLabel;
	private JLabel historicLabel;
	private JList<String> infoList; 
	private JList<String> routeList;
	private JList<String> historicList;
	DefaultListModel<String> model;
	private JButton removeBtn; 
	private Icon arrUp; 
    private Icon arrDown;
	
	public SidePanel(){
		
		this.setMinimumSize(new Dimension(0, 1000));
		this.setPreferredSize(new Dimension(200, 1000));
		this.setMaximumSize(new Dimension(200, 1000));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		arrUp = new ImageIcon("images/arrowUp.png"); 
		arrDown = new ImageIcon("images/arrowDown.png");
		
		model = new DefaultListModel<>();
		infoLabel = new JLabel("Info", SwingConstants.CENTER); // => glue ?? : Box.createVerticalGlue()
		infoLabel.setIcon(arrDown);
		//infoLabel.setBounds(190, 90, 190, 26);
		this.add(infoLabel);
		model.addElement("Jane Doe1");
		model.addElement("John Smith1");
		infoList = new JList<String>(model);
		this.add(infoList);
		infoList.setLayoutOrientation(JList.VERTICAL);
		
		model = new DefaultListModel<>();
		routeLabel = new JLabel("Parcours", SwingConstants.CENTER);
		routeLabel.setIcon(arrDown);
		this.add(routeLabel);
		model.addElement("Jane Doe2");
		model.addElement("John Smith2");
		routeList = new JList<String>(model);
		this.add(routeList);
		routeList.setLayoutOrientation(JList.VERTICAL);
		
		model = new DefaultListModel<>();
		historicLabel = new JLabel("Historique", SwingConstants.CENTER);
		historicLabel.setIcon(arrDown);
		this.add(historicLabel);
		model.addElement("Jane Doe3");
		model.addElement("John Smith3");
		historicList = new JList<String>(model);
		this.add(historicList);
		historicList.setLayoutOrientation(JList.VERTICAL);
		
		/*infoList.addListSelectionListener(this); 
		routeList.addListSelectionListener(this); 
		historicList.addListSelectionListener(this); */
		
		/*JScrollPane scrollPane = new JScrollPane(infoList);
		scrollPane = new JScrollPane(routeList);
		scrollPane = new JScrollPane(historicList);*/
	
		infoList.setVisible(true); 
		routeList.setVisible(true); 
		historicList.setVisible(true);
		
		infoLabel.addMouseListener(this);
		routeLabel.addMouseListener(this);
		historicLabel.addMouseListener(this);
		
		removeBtn = new JButton("Supprimer"); 
		this.add(removeBtn);
		
		/** Dérouler les listes */
		
		infoLabel.addMouseListener(new MouseAdapter()  //MouseListener
		{
		
			public void mouseClicked(MouseEvent e) {
				if(infoList.isVisible()){
					infoList.setVisible(false);
					infoLabel.setIcon(arrUp);
				}//infoList.setSize(new Dimension(200, 0)); //setPreferredSize
				else if(!infoList.isVisible()){
					infoList.setVisible(true);
					infoLabel.setIcon(arrDown);
				}
			}
	
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		routeLabel.addMouseListener(new MouseAdapter() 
    	{
	  
			public void mouseClicked(MouseEvent e) {
				if(routeList.isVisible()){
					routeList.setVisible(false);
					routeLabel.setIcon(arrUp);
					}
				else if(!routeList.isVisible()){
					routeList.setVisible(true);
					routeLabel.setIcon(arrDown);}
				}
		
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
    	});
		
	  	
		historicLabel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) {
				if(historicList.isVisible()){
					historicList.setVisible(false);
					historicLabel.setIcon(arrUp);
					}
	        	else if(!historicList.isVisible()){
	        		historicList.setVisible(true);
	        		historicLabel.setIcon(arrDown);
	        		}
	        }
	        		
	        public void mouseEntered(MouseEvent e) {}
	        public void mouseExited(MouseEvent e) {}
	        public void mousePressed(MouseEvent e) {}
	        public void mouseReleased(MouseEvent e) {}
		});
		
		/** Supprimer des éléments d'une liste */
		
		removeBtn.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) {
				SidePanel p = new SidePanel();
				if(e.getSource() == infoList)
				{
					p.removeInfo(); // méthode suppression
									//méthode pour recharger à nouveau donnés dans la table 
				}else if(e.getSource() == routeList){
					p.removeRoute(); 
				}
				else if(e.getSource() == historicList){
					p.removeHistoric(); 
				}
				
	        }
	        		
	        public void mouseEntered(MouseEvent e) {}
	        public void mouseExited(MouseEvent e) {}
	        public void mousePressed(MouseEvent e) {}
	        public void mouseReleased(MouseEvent e) {}
		});
	}
	
	//méthodes suppression 
	public void removeInfo(){
		/** Remplacer par un clear.all ?? */
				//infoList.getModel().getElementAt(infoList.getSelectedIndex());
				int i = infoList.getSelectedIndex();  // récupérer élément séléctionné 
				model.removeElement(i); // le supprimer
				infoList.setModel(model); //DefaultListModel<String>
		
		// + effectuer appel requete supp' ici !!!!!!!!!!!!!
		// + recharger bdd (select) pour mettre à jour JList
	} 
	//TEMP
	public void removeRoute(){
		int i = routeList.getSelectedIndex(); 
		model.removeElement(i); 
	}
	//TEMP
	public void removeHistoric(){
		int i = historicList.getSelectedIndex();
		model.removeElement(i); 
	}
	
	/*public void valueChanged(ListSelectionEvent e){ 
		for (int i = 0; i < infoList.getSelectedValues().length; i++) {
			  System.out.println(infoList.getSelectedValues()[i]);
			}*/
	

  


	@Override
	public void paintComponent(Graphics g){
		final Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
		
		//g2 = (Graphics2D) g2.create();
		int h = getHeight();
	    int w = getWidth();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	  
	    // Haut 
	    GeneralPath path = new GeneralPath();
	    path.moveTo(70, 0);
	    path.lineTo(8, 0);
	    path.quadTo(0, 0, 0, 7);
	    path.lineTo(0, 55);
	    path.lineTo(getWidth() - 1, 55);
	    path.lineTo(getWidth() - 1, 7);
	    path.quadTo(getWidth() - 1, 0, getWidth() - 8, 0);
	    path.lineTo(30, 0);

	    Rectangle bounds1 = path.getBounds();
	    GradientPaint painter = new GradientPaint(0, path.getBounds().y,
	                true ? new Color(240, 240, 240) : new Color(240, 240, 240), 0,
	                bounds1.y + bounds1.height - 1, true ? new Color(240, 240, 240) : new Color(240, 240, 240));
	    g2.setPaint(painter);
	    g2.fill(path);

	    Rectangle rectangle = new Rectangle(0, 40, getWidth(), 20);
	    g2.fill(rectangle);
	    g2.setColor(new Color(128, 128, 128));
	    g2.draw(path);
	      
	    //Milieu  
	    g2.setColor(new Color(128, 128, 128));
	    g2.drawLine(12, 0, getWidth() - 10, 0);
	    g2.drawRect(0, 30, getWidth() - 1, h - 40);
	    g2.setPaint(new Color(240, 240, 240));
	    g2.fillRect(1, 29, getWidth() - 2, h - 80);
	      
	    // Bas
	    h = h - 30;
	    path = new GeneralPath();
	    path.moveTo(0, h);
	    path.lineTo(0, h + 22);
	    path.quadTo(0, h + 29, 8, h + 29);
	    path.lineTo(getWidth() - 8, h + 29);
	    path.quadTo(getWidth() - 1, h + 29, getWidth() - 1, h + 22);
	    path.lineTo(getWidth() - 1, h);
	    g2.fill(path);
	    g2.setColor(new Color(128, 128, 128));
	    g2.draw(path);
	    // g2.setColor(new Color(128, 128, 128));
	     
	  }

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
