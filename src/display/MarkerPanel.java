package display;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import tileengine.MapMarker;
import tileengine.MapViewer;

public class MarkerPanel extends RoundedPanel{
	
	private JLabel libelleLabel = new JLabel();
	private JTextPane descriptionTextPane = new JTextPane();
	private JList<String> linkJList = new JList<String>();
	private ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	private JList refJList = new JList();
	private final JLabel image1Label = new JLabel();
	
	@SuppressWarnings("unchecked")
	public MarkerPanel(MapMarker mm, MapViewer mv) {
		
		this.setSize(420,500);
		this.setBounds((int)mv.getWidth()/2-(this.getWidth()/2), (int)mv.getHeight()/2-(this.getHeight()/2), 420, 500);
		JLabel image4Label = new JLabel();
		imageList.add(image4Label);
		this.descriptionTextPane.setText(mm.getPoi().getDescription().getDescription());
		
		//Chargement des images
		if(mm.getPoi().getDescription().getImageList().size() > 0){
			for(int i=0; i<mm.getPoi().getDescription().getImageList().size();i++){
				if(i==5)
					break;
				BufferedImage img =mm.getPoi().getDescription().getImageList().get(i);
				Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				this.imageList.get(i).setIcon(imageIcon);
				System.out.println(i+" image(s)");
			}
		}
		else{
			image1Label.setText("Pas d'image");
		}
		
		
		//Chargement des liens
		if(mm.getPoi().getDescription().getLinkList().size() >0) {
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			for(String l : mm.getPoi().getDescription().getLinkList()){
				listModel.addElement(l);
				System.out.println(l);
			}
			this.linkJList.setModel(listModel);
			this.linkJList.repaint();
		} else {
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			listModel.addElement("Pas de liens");
			this.linkJList.setModel(listModel);
			this.linkJList.repaint();
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		this.libelleLabel.setText(mm.getPoi().getLibelle());
		
		GridBagConstraints gbc_libelleLabel = new GridBagConstraints();
		gbc_libelleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_libelleLabel.gridx = 4;
		gbc_libelleLabel.gridy = 1;
		add(libelleLabel, gbc_libelleLabel);
		
		GridBagConstraints gbc_descriptionTextPane = new GridBagConstraints();
		gbc_descriptionTextPane.gridheight = 7;
		gbc_descriptionTextPane.gridwidth = 6;
		gbc_descriptionTextPane.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionTextPane.fill = GridBagConstraints.BOTH;
		gbc_descriptionTextPane.gridx = 2;
		gbc_descriptionTextPane.gridy = 2;
		add(descriptionTextPane, gbc_descriptionTextPane);
		
		this.linkJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.linkJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		linkJList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            int index = list.locationToIndex(evt.getPoint());
		            String url = (String) list.getModel().getElementAt(index);
		            try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException | URISyntaxException e) {
						System.out.println("Lien incorrect");
					}
		        } else if (evt.getClickCount() == 3) {   // Triple-click
		            int index = list.locationToIndex(evt.getPoint());

		        }
		    }
		});
		
		GridBagConstraints gbc_linkJList = new GridBagConstraints();
		gbc_linkJList.insets = new Insets(0, 0, 5, 5);
		gbc_linkJList.gridheight = 4;
		gbc_linkJList.fill = GridBagConstraints.BOTH;
		gbc_linkJList.gridx = 8;
		gbc_linkJList.gridy = 2;
		add(linkJList, gbc_linkJList);
		
		GridBagConstraints gbc_refJList = new GridBagConstraints();
		gbc_refJList.gridheight = 3;
		gbc_refJList.insets = new Insets(0, 0, 5, 5);
		gbc_refJList.fill = GridBagConstraints.BOTH;
		gbc_refJList.gridx = 8;
		gbc_refJList.gridy = 6;
		add(refJList, gbc_refJList);
		
		GridBagConstraints gbc_image1Label = new GridBagConstraints();
		gbc_image1Label.insets = new Insets(0, 0, 0, 5);
		gbc_image1Label.gridx = 2;
		gbc_image1Label.gridy = 9;
		add(image1Label, gbc_image1Label);
		JLabel image2Label = new JLabel();
		imageList.add(image2Label);
		
		GridBagConstraints gbc_image2Label = new GridBagConstraints();
		gbc_image2Label.insets = new Insets(0, 0, 0, 5);
		gbc_image2Label.gridx = 4;
		gbc_image2Label.gridy = 9;
		add(image2Label, gbc_image2Label);
		JLabel image3Label = new JLabel();
		imageList.add(image3Label);
		
		GridBagConstraints gbc_image3Label = new GridBagConstraints();
		gbc_image3Label.insets = new Insets(0, 0, 0, 5);
		gbc_image3Label.gridx = 7;
		gbc_image3Label.gridy = 9;
		add(image3Label, gbc_image3Label);
		
		GridBagConstraints gbc_image4Label = new GridBagConstraints();
		gbc_image4Label.insets = new Insets(0, 0, 0, 5);
		gbc_image4Label.gridx = 8;
		gbc_image4Label.gridy = 9;
		add(image4Label, gbc_image4Label);
	}
}