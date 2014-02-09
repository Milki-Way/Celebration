package display.editmode;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tools.Coordinate;
import data.DataEngine;
import entity.DescriptionComplex;
import entity.IEntity;
import entity.Poi;

public class PoiEditPanel extends JPanel{
	
	private JPanel panelPoi = new JPanel();
	private JTextField txtSearch = new JTextField();
	private JList listResult = new JList();
	private JButton btnSearch = new JButton("Rechercher");
	private JTextField txtLibelle = new JTextField();
	private JTextField txtY = new JTextField();
	private JTextField txtX = new JTextField();
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private final JScrollPane scrollPaneLinks = new JScrollPane();
	private final JScrollPane scrollPaneImgs = new JScrollPane();
	private final JTextArea textAreaLinks = new JTextArea();
	private final JTextArea textAreaImgs = new JTextArea();
	private final JTextArea txtrDescription = new JTextArea();
	
	private  Poi currentPoi;
	
	@SuppressWarnings("unchecked")
	public PoiEditPanel() {
		this.setSize(new Dimension(425, 379));
		
		System.out.println("create a "+this.getClass().getName());
		
		txtLibelle.setText("Libelle");
		txtLibelle.setColumns(10);
		
		GridBagLayout gbl_panelPoi = new GridBagLayout();
		gbl_panelPoi.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelPoi.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelPoi.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPoi.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gbl_panelPoi);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 1;
		gbc_txtSearch.gridy = 0;
		this.add(txtSearch, gbc_txtSearch);
		
		GridBagConstraints gbc_txtLibelle = new GridBagConstraints();
		gbc_txtLibelle.gridwidth = 2;
		gbc_txtLibelle.insets = new Insets(0, 0, 5, 5);
		gbc_txtLibelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLibelle.gridx = 3;
		gbc_txtLibelle.gridy = 0;
		this.add(txtLibelle, gbc_txtLibelle);
		
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 1;
		btnSearch.addActionListener(new ActionListener() { 	// SEARCH POI
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel<Poi> listModel = new DefaultListModel<Poi>();
				
				ArrayList<Poi> searchResult = DataEngine.getInstance().searchPoi(txtSearch.getText()); // TODO
				
				System.out.println("result size: "+searchResult.size());
				
				for(int index=0; index<searchResult.size(); index++)
				{
				     listModel.addElement(searchResult.get(index));
				     System.out.println(searchResult.get(index).toString());
				}
								
				listResult = new JList<Poi>(listModel);
				listResult.repaint();
			}
		});
		this.add(btnSearch, gbc_btnSearch);
		txtX.setText("X");
		txtX.setColumns(10);
		
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 3;
		gbc_txtX.gridy = 1;
		this.add(txtX, gbc_txtX);
		txtY.setText("Y");
		txtY.setColumns(10);
		
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 4;
		gbc_txtY.gridy = 1;
		this.add(txtY, gbc_txtY);
		
		GridBagConstraints gbc_listResult = new GridBagConstraints();
		gbc_listResult.insets = new Insets(0, 0, 5, 5);
		gbc_listResult.gridwidth = 2;
		gbc_listResult.fill = GridBagConstraints.BOTH;
		gbc_listResult.gridx = 1;
		gbc_listResult.gridy = 2;
		this.add(listResult, gbc_listResult);
		
		listResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResult.setLayoutOrientation(JList.VERTICAL);
		listResult.addListSelectionListener(
                new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						currentPoi = (Poi) listResult.getSelectedValue();
					}
                	
                });
		listResult.setCellRenderer(new DefaultListCellRenderer() {// n'afficher que le libelle du Poi
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Poi) {
                    ((JLabel) renderer).setText(((Poi) value).getLibelle());
                }
                return renderer;
            }
        });
		
		GridBagConstraints gbc_txtrDescription = new GridBagConstraints();
		gbc_txtrDescription.gridwidth = 3;
		gbc_txtrDescription.insets = new Insets(0, 0, 5, 5);
		gbc_txtrDescription.fill = GridBagConstraints.BOTH;
		gbc_txtrDescription.gridx = 3;
		gbc_txtrDescription.gridy = 2;
		txtrDescription.setText("Description");
		add(txtrDescription, gbc_txtrDescription);
		
		GridBagConstraints gbc_scrollPaneLinks = new GridBagConstraints();
		gbc_scrollPaneLinks.gridwidth = 3;
		gbc_scrollPaneLinks.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneLinks.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLinks.gridx = 1;
		gbc_scrollPaneLinks.gridy = 3;
		add(scrollPaneLinks, gbc_scrollPaneLinks);
		textAreaLinks.setText("Liens");
		
		scrollPaneLinks.setViewportView(textAreaLinks);
		
		GridBagConstraints gbc_scrollPaneImgs = new GridBagConstraints();
		gbc_scrollPaneImgs.gridwidth = 2;
		gbc_scrollPaneImgs.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneImgs.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneImgs.gridx = 4;
		gbc_scrollPaneImgs.gridy = 3;
		add(scrollPaneImgs, gbc_scrollPaneImgs);
		textAreaImgs.setText("Images");
		
		scrollPaneImgs.setViewportView(textAreaImgs);
		
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 3;
		gbc_btnAjouter.gridy = 4;
		btnAjouter.addActionListener(new ActionListener() { // ADD POI
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
				ArrayList<String> linksList = new ArrayList<String>();
				ArrayList<IEntity> refList = new ArrayList<IEntity>();
				
				for (String line : textAreaImgs.getText().split("\\n")){
					try {
						if(!line.equals("") && !line.equals(null))	
							imgList.add(ImageIO.read(new File(line)));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					
				for (String line : textAreaLinks.getText().split("\\n")){
					linksList.add(line);
				}				
				
				if(imgList.size() == 0)
					imgList = null;
				if(linksList.size() == 0)
					linksList = null;
				
				DataEngine.getInstance().persist(
						new Poi(
								txtLibelle.getText(), 
								new Coordinate(Double.parseDouble(txtX.getText()), Double.parseDouble(txtY.getText())), 
								new DescriptionComplex(txtrDescription.getText(), imgList, linksList, refList)));
				System.out.println("Poi "+txtLibelle.getText()+" ajouté !");
			}
		});
		this.add(btnAjouter, gbc_btnAjouter);
		
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifier.gridx = 4;
		gbc_btnModifier.gridy = 4;
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // MOD POI
				
				ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
				ArrayList<String> linksList = new ArrayList<String>();
				ArrayList<IEntity> refList = new ArrayList<IEntity>();
				
				for (String line : textAreaImgs.getText().split("\\n")){
					try {
						imgList.add(ImageIO.read(new File(line)));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					
				for (String line : textAreaLinks.getText().split("\\n")){
					linksList.add(line);
				}				
				
				if(imgList.size() == 0)
					imgList = null;
				if(linksList.size() == 0)
					linksList = null;
				
				currentPoi.setLibelle(txtLibelle.getText());
				currentPoi.setCoords(new Coordinate(Double.parseDouble(txtX.getText()), Double.parseDouble(txtY.getText())));

				DescriptionComplex curDesc = currentPoi.getDescription();
				curDesc.setDescription(txtrDescription.getText());
				curDesc.setImage(imgList);
				curDesc.setLink(linksList);
				
				currentPoi.setDescription(curDesc);
				
				DataEngine.getInstance().persist(currentPoi);
			}
		});
		this.add(btnModifier, gbc_btnModifier);
		
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 5;
		gbc_btnSupprimer.gridy = 4;
		btnSupprimer.addActionListener(new ActionListener() { // DEL POI
			public void actionPerformed(ActionEvent e) {
				DataEngine.getInstance().delete(currentPoi);
			}
		});
		this.add(btnSupprimer, gbc_btnSupprimer);

	}
}
