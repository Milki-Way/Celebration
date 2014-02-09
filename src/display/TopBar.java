package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tileengine.MapViewer;
import tools.Historic;
import tools.HistoricRow;

@SuppressWarnings("serial")
public class TopBar extends JPanel{
	
	private JTextField searchTextField;
	private RoundButton btnPrec;
	private JButton btnSuiv;
	private JButton btnSearch;
	private JButton btnSwithmode;

	private MapViewer map;
	
	public TopBar(final MapViewer map){
		
		this.map = map;
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_topPanel.rowHeights = new int[]{0, 0};
		gbl_topPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_topPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_topPanel);
		
		Image prec;
		ImageIcon iPrec;
		try {
			prec = (ImageIO.read(new File("data/imgs/prec.png")));
			iPrec = new ImageIcon(prec);
		} catch (IOException e1) {
			prec = null;
			iPrec = null;
			e1.printStackTrace();
		}
		if(iPrec != null){
			btnPrec = new RoundButton(iPrec);
		} else {
			btnPrec = new RoundButton("Prec.");
		}	
		GridBagConstraints gbc_btnPrec = new GridBagConstraints();
		gbc_btnPrec.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrec.gridx = 0;
		gbc_btnPrec.gridy = 0;
		this.add(btnPrec, gbc_btnPrec);
		btnPrec.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				HistoricRow prev = Historic.getInstance().previous();
				if(prev == null)
					return;
				map.move(prev.getMapPosition(), prev.getZoom(), prev.getRealZoom());
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		Image suiv;
		ImageIcon iSuiv;
		try {
			suiv = ImageIO.read(new File("data/imgs/suiv.png"));
			iSuiv = new ImageIcon(suiv);
		} catch (IOException e1) {
			suiv = null;
			iSuiv = null;
			e1.printStackTrace();
		}
		if(iSuiv != null){
			btnSuiv = new RoundButton(iSuiv);
		} else {
			btnSuiv = new RoundButton("Suiv.");
		}	
		GridBagConstraints gbc_btnSuiv = new GridBagConstraints();
		gbc_btnSuiv.insets = new Insets(0, 0, 0, 5);
		gbc_btnSuiv.gridx = 1;
		gbc_btnSuiv.gridy = 0;
		this.add(btnSuiv, gbc_btnSuiv);
		btnSuiv.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				HistoricRow suiv = Historic.getInstance().next();
				if(suiv == null)
					return;
				map.move(suiv.getMapPosition(), suiv.getZoom(), suiv.getRealZoom());
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		searchTextField = new JTextField();
		GridBagConstraints gbc_searchTextField = new GridBagConstraints();
		gbc_searchTextField.gridwidth = 10;
		gbc_searchTextField.insets = new Insets(0, 0, 0, 5);
		gbc_searchTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchTextField.gridx = 6;
		gbc_searchTextField.gridy = 0;
		this.add(searchTextField, gbc_searchTextField);
		searchTextField.setColumns(10);
		
		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 16;
		gbc_btnSearch.gridy = 0;
		this.add(btnSearch, gbc_btnSearch);
		btnSearch.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				//afficher les resultats de la recherche
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		btnSwithmode = new JButton("SwitchMode");
		GridBagConstraints gbc_btnSwithmode = new GridBagConstraints();
		gbc_btnSwithmode.gridwidth = 3;
		gbc_btnSwithmode.gridx = 21;
		gbc_btnSwithmode.gridy = 0;
		this.add(btnSwithmode, gbc_btnSwithmode);
		btnSwithmode.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				World.getInstance().switchMode();
				System.out.println("Switching to "+World.getInstance().getDisplayMode());
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
		
		//faites ce que vous voulez.
	}
}
