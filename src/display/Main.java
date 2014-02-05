package display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Main extends JFrame implements MouseListener{
	// Ajout des différents items de la barre de menu
	
	private JMenuBar menuprincipal = new JMenuBar();
	private JMenu menupoi = new JMenu("POI");
	private JMenu menunews = new JMenu("News");
	private JMenu menuparcours = new JMenu("Parcours");
	private JMenu menuswitchmode = new JMenu("SwitchMode");
	
	private JMenuItem itemajout = new JMenuItem("Ajout");
	private JMenuItem itemmodif = new JMenuItem("Modification/Suppression");
	
	private JMenuItem itemmodif2 = new JMenuItem("Suppression");
	
	private JMenuItem itemajout3 = new JMenuItem("Ajout");
	private JMenuItem itemmodif3 = new JMenuItem("Modification/Suppression");
	
	public Main(){
		
			this.setTitle("Mode Edition");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(new Dimension(800, 600));
 
			
			
			// Ajout de la barre menu dans la JPANEL

			this.menuprincipal.add(menupoi);
			this.menuprincipal.add(menunews);
			this.menuprincipal.add(menuparcours);
			this.menuprincipal.add(menuswitchmode);
			
			itemajout.addActionListener(new menuActionListener());
			itemmodif.addActionListener(new menuActionListener());
			this.menupoi.add(itemajout);
			this.menupoi.add(itemmodif);
			
			
			itemmodif2.addActionListener(new menuActionListener());
			this.menunews.add(itemmodif2);
			
			itemajout3.addActionListener(new menuActionListener());
			itemmodif3.addActionListener(new menuActionListener());
			this.menuparcours.add(itemajout3);
			this.menuparcours.add(itemmodif3);
			
			this.setJMenuBar(menuprincipal);
			

	}
	
	
			

	public static void main(String[] args){
 
		Main m = new Main(); 
		m.setVisible(true);
 
	}


	
	public class menuActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == itemajout){
				PanelAjoutPoi pap = new PanelAjoutPoi();
				pap.setVisible(true);
				
			}else if(e.getSource() == itemmodif){
				PanelModifPoi pap = new PanelModifPoi();
				pap.setVisible(true);
			}else if(e.getSource() == itemmodif2){
				PanelSupprimerNews pap = new PanelSupprimerNews();
				pap.setVisible(true);
			}else if(e.getSource() == itemajout3){
				PanelAjoutParcours pap = new PanelAjoutParcours();
				pap.setVisible(true);
			}else if(e.getSource() == itemmodif3){
				PanelModifParcours pap = new PanelModifParcours();
				pap.setVisible(true);
			} //else if(e.getSource() == menuswitchmode){}
			
		}

		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}


	

}