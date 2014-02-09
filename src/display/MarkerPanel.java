package display;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JList linkJList;
	private ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	private JList refJList = new JList();
	
	@SuppressWarnings("unchecked")
	public MarkerPanel(MapMarker mm, MapViewer mv) {
		
		this.setSize(414,415);
		this.setBounds((int)mv.getWidth()/2-(this.getWidth()/2), (int)mv.getHeight()/2-(this.getHeight()/2), 350, 350);

		
		JLabel image1Label = new JLabel();
		JLabel image2Label = new JLabel();
		JLabel image3Label = new JLabel();
		JLabel image4Label = new JLabel();
		imageList.add(image1Label);
		imageList.add(image2Label);
		imageList.add(image3Label);
		imageList.add(image4Label);
		this.descriptionTextPane.setText(mm.getPoi().getDescription().getDescription());
		
		//Chargement des images
		if(mm.getPoi().getDescription().getImageList().size() > 0){
			for(int i=1; i<mm.getPoi().getDescription().getImageList().size();i++){
				this.imageList.get(i).setIcon(new ImageIcon(mm.getPoi().getDescription().getImageList().get(i)));
			}
		}
		else{
			image1Label.setText("Pas d'image");
		}
		
		
		//Chargement des liens
		if(mm.getPoi().getDescription().getLinkList().size() >0){
			this.linkJList = new JList<Object>(mm.getPoi().getDescription().getLinkList().toArray());
		}else{
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("Pas de liens");
			this.linkJList = new JList<String>(listModel);
		}
		
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
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		this.libelleLabel.setText(mm.getPoi().getLibelle());
		
		GridBagConstraints gbc_libelleLabel = new GridBagConstraints();
		gbc_libelleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_libelleLabel.gridx = 5;
		gbc_libelleLabel.gridy = 1;
		add(libelleLabel, gbc_libelleLabel);
		
		GridBagConstraints gbc_descriptionTextPane = new GridBagConstraints();
		gbc_descriptionTextPane.gridheight = 7;
		gbc_descriptionTextPane.gridwidth = 5;
		gbc_descriptionTextPane.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionTextPane.fill = GridBagConstraints.BOTH;
		gbc_descriptionTextPane.gridx = 3;
		gbc_descriptionTextPane.gridy = 2;
		add(descriptionTextPane, gbc_descriptionTextPane);
		
		GridBagConstraints gbc_linkJList = new GridBagConstraints();
		gbc_linkJList.gridwidth = 2;
		gbc_linkJList.insets = new Insets(0, 0, 5, 5);
		gbc_linkJList.gridheight = 4;
		gbc_linkJList.fill = GridBagConstraints.BOTH;
		gbc_linkJList.gridx = 6;
		gbc_linkJList.gridy = 2;
		add(linkJList, gbc_linkJList);
		
		GridBagConstraints gbc_refJList = new GridBagConstraints();
		gbc_refJList.gridwidth = 2;
		gbc_refJList.gridheight = 3;
		gbc_refJList.insets = new Insets(0, 0, 5, 5);
		gbc_refJList.fill = GridBagConstraints.BOTH;
		gbc_refJList.gridx = 8;
		gbc_refJList.gridy = 6;
		add(refJList, gbc_refJList);
		
		GridBagConstraints gbc_image1Label = new GridBagConstraints();
		gbc_image1Label.insets = new Insets(0, 0, 0, 5);
		gbc_image1Label.gridx = 1;
		gbc_image1Label.gridy = 9;
		add(image1Label, gbc_image1Label);
		
		GridBagConstraints gbc_image2Label = new GridBagConstraints();
		gbc_image2Label.insets = new Insets(0, 0, 0, 5);
		gbc_image2Label.gridx = 3;
		gbc_image2Label.gridy = 9;
		add(image2Label, gbc_image2Label);
		
		GridBagConstraints gbc_image3Label = new GridBagConstraints();
		gbc_image3Label.insets = new Insets(0, 0, 0, 5);
		gbc_image3Label.gridx = 5;
		gbc_image3Label.gridy = 9;
		add(image3Label, gbc_image3Label);
		
		GridBagConstraints gbc_image4Label = new GridBagConstraints();
		gbc_image4Label.insets = new Insets(0, 0, 0, 5);
		gbc_image4Label.gridx = 9;
		gbc_image4Label.gridy = 9;
		add(image4Label, gbc_image4Label);
	}
}