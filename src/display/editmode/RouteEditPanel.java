package display.editmode;

import java.awt.Component;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.DataEngine;
import entity.DescriptionComplex;
import entity.Poi;
import entity.Route;

public class RouteEditPanel extends JPanel{
	private JTextField txtParcoursSearch;
	private JTextField txtLibelle;
	private JScrollPane scrollPaneImgs;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaImgs;
	private JTextArea txtrLinks;
	private JTextArea textAreaDescription;
	private JList<Route> listRouteResults;
	private JTextField textPoiSearch;
	private JButton btnSearchPoi;
	private JList<Poi> listPoiResults;
	private JList<Poi> listPoiOfRoute;
	private JButton button;
	private JButton button_1;
	private JButton btnAdd;
	private JButton btnMod;
	private JButton btnSupprimer;
	
	private Route curRoute;
	private Poi selectedPoi;
	private Poi selectedPoiOfRoute;
	private ArrayList<Poi> PoiOfRouteList = new ArrayList<Poi>();
	private DefaultListModel listModelPoiOfRouteList = new DefaultListModel();
	private DefaultListModel listModelPoiSearch = new DefaultListModel();
	
	@SuppressWarnings("unchecked")
	public RouteEditPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 196, 0, 67, 0, 0, 106, 69, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtParcoursSearch = new JTextField();
		txtParcoursSearch.setText("Parcours");
		GridBagConstraints gbc_txtParcoursSearch = new GridBagConstraints();
		gbc_txtParcoursSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtParcoursSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtParcoursSearch.gridx = 1;
		gbc_txtParcoursSearch.gridy = 0;
		add(txtParcoursSearch, gbc_txtParcoursSearch);
		txtParcoursSearch.setColumns(10);
		
		JButton btnSearchRoute = new JButton("Chercher");
		btnSearchRoute.addActionListener(new ActionListener() { // chercher le parcours
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel<Route> listModel = new DefaultListModel<Route>();
				
				ArrayList<Route> searchResult = DataEngine.getInstance().searchRoute(txtParcoursSearch.getText()); // TODO
				
				for(int index=0; index<searchResult.size(); index++)
				{
				     listModel.addElement(searchResult.get(index));
				}
								
				listRouteResults.setModel(listModel);
				listRouteResults.repaint();
			}
		});
		GridBagConstraints gbc_btnSearchRoute = new GridBagConstraints();
		gbc_btnSearchRoute.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchRoute.gridx = 2;
		gbc_btnSearchRoute.gridy = 0;
		add(btnSearchRoute, gbc_btnSearchRoute);
		
		txtLibelle = new JTextField();
		txtLibelle.setText("Libelle");
		GridBagConstraints gbc_txtLibelle = new GridBagConstraints();
		gbc_txtLibelle.gridwidth = 4;
		gbc_txtLibelle.insets = new Insets(0, 0, 5, 5);
		gbc_txtLibelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLibelle.gridx = 4;
		gbc_txtLibelle.gridy = 0;
		add(txtLibelle, gbc_txtLibelle);
		txtLibelle.setColumns(10);
		
		listRouteResults = new JList();
		GridBagConstraints gbc_listRouteResults = new GridBagConstraints();
		gbc_listRouteResults.gridwidth = 2;
		gbc_listRouteResults.insets = new Insets(0, 0, 5, 5);
		gbc_listRouteResults.fill = GridBagConstraints.BOTH;
		gbc_listRouteResults.gridx = 1;
		gbc_listRouteResults.gridy = 1;
		add(listRouteResults, gbc_listRouteResults);
		listRouteResults.addListSelectionListener( // sélectionner un parcours
                new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						curRoute = (Route) listRouteResults.getSelectedValue();
						
																					// on pré-rempli les champs
						txtLibelle.setText(curRoute.getLibelle());					//libelle	
						for(String link : curRoute.getDescmplx().getLinkList()){	//link list
							txtrLinks.setText(link+"\n");
						}
						
						textAreaDescription.setText(curRoute.getDescmplx().getDescription());// description
						
						
						ArrayList<Poi> searchResult = curRoute.getPoiList();
						
						for(int index=0; index<searchResult.size(); index++)
						{
							listModelPoiOfRouteList.addElement(searchResult.get(index));
						}
										
						listPoiOfRoute.setModel(listModelPoiOfRouteList);
						listPoiOfRoute.repaint();
					}
                	
                });
		listRouteResults.setCellRenderer(new DefaultListCellRenderer() {// n'afficher que le libelle du parcours
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Route) {
                    ((JLabel) renderer).setText(((Route) value).getLibelle());
                }
                return renderer;
            }
        });
		
		scrollPaneImgs = new JScrollPane();
		GridBagConstraints gbc_scrollPaneImgs = new GridBagConstraints();
		gbc_scrollPaneImgs.gridwidth = 4;
		gbc_scrollPaneImgs.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneImgs.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneImgs.gridx = 4;
		gbc_scrollPaneImgs.gridy = 1;
		add(scrollPaneImgs, gbc_scrollPaneImgs);
		
		textAreaImgs = new JTextArea();
		textAreaImgs.setText("Liens des images");
		scrollPaneImgs.setViewportView(textAreaImgs);
		
		textPoiSearch = new JTextField();
		textPoiSearch.setText("Poi");
		GridBagConstraints gbc_textPoiSearch = new GridBagConstraints();
		gbc_textPoiSearch.insets = new Insets(0, 0, 5, 5);
		gbc_textPoiSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPoiSearch.gridx = 1;
		gbc_textPoiSearch.gridy = 2;
		add(textPoiSearch, gbc_textPoiSearch);
		textPoiSearch.setColumns(10);
		
		btnSearchPoi = new JButton("Chercher");
		btnSearchPoi.addActionListener(new ActionListener() { // chercher les Poi
			public void actionPerformed(ActionEvent e) {
								
				ArrayList<Poi> searchResult = DataEngine.getInstance().searchPoi(textPoiSearch.getText());
				
				for(int index=0; index<searchResult.size(); index++)
				{
					listModelPoiSearch.addElement(searchResult.get(index));
				}
								
				listPoiResults.setModel(listModelPoiSearch);
				listPoiResults.repaint();
			}
		});
		GridBagConstraints gbc_btnSearchPoi = new GridBagConstraints();
		gbc_btnSearchPoi.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchPoi.gridx = 2;
		gbc_btnSearchPoi.gridy = 2;
		add(btnSearchPoi, gbc_btnSearchPoi);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);
		
		txtrLinks = new JTextArea();
		scrollPane_1.setViewportView(txtrLinks);
		txtrLinks.setText("Liens");
		
		listPoiResults = new JList();
		GridBagConstraints gbc_listPoiResults = new GridBagConstraints();
		gbc_listPoiResults.gridheight = 7;
		gbc_listPoiResults.gridwidth = 2;
		gbc_listPoiResults.insets = new Insets(0, 0, 5, 5);
		gbc_listPoiResults.fill = GridBagConstraints.BOTH;
		gbc_listPoiResults.gridx = 1;
		gbc_listPoiResults.gridy = 3;
		add(listPoiResults, gbc_listPoiResults);
		listPoiResults.addListSelectionListener(  // liste des Poi recherchés
                new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						selectedPoi = (Poi) listPoiResults.getSelectedValue();
					}
                	
                });
		listPoiResults.setCellRenderer(new DefaultListCellRenderer() {// n'afficher que le libelle du Poi
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Poi) {
                    ((JLabel) renderer).setText(((Poi) value).getLibelle());
                }
                return renderer;
            }
        });
		
		button = new JButton("->");
		button.addActionListener(new ActionListener() {	// switch poi to poiofroute
			public void actionPerformed(ActionEvent e) {
				
				if(selectedPoi != null){
					listModelPoiOfRouteList.addElement(selectedPoi);
					listModelPoiSearch.removeElement(selectedPoi);
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 5;
		add(button, gbc_button);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setText("Description");
		GridBagConstraints gbc_textAreaDescription = new GridBagConstraints();
		gbc_textAreaDescription.gridwidth = 4;
		gbc_textAreaDescription.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaDescription.fill = GridBagConstraints.BOTH;
		gbc_textAreaDescription.gridx = 4;
		gbc_textAreaDescription.gridy = 5;
		add(textAreaDescription, gbc_textAreaDescription);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setWrapStyleWord(true);
		
		listPoiOfRoute = new JList();									// liste des POI du parcours sélectionné
		GridBagConstraints gbc_listPoiOfRoute = new GridBagConstraints();
		gbc_listPoiOfRoute.gridheight = 4;
		gbc_listPoiOfRoute.gridwidth = 4;
		gbc_listPoiOfRoute.insets = new Insets(0, 0, 5, 5);
		gbc_listPoiOfRoute.fill = GridBagConstraints.BOTH;
		gbc_listPoiOfRoute.gridx = 4;
		gbc_listPoiOfRoute.gridy = 6;
		add(listPoiOfRoute, gbc_listPoiOfRoute);
		listPoiOfRoute.addListSelectionListener(  // liste des Poi recherchés
                new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						selectedPoiOfRoute = (Poi) listPoiOfRoute.getSelectedValue();
					}
                	
                });
		listPoiOfRoute.setCellRenderer(new DefaultListCellRenderer() {// n'afficher que le libelle du Poi
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Poi) {
                    ((JLabel) renderer).setText(((Poi) value).getLibelle());
                }
                return renderer;
            }
        });
		
		button_1 = new JButton("<-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedPoiOfRoute != null){
					listModelPoiOfRouteList.removeElement(selectedPoiOfRoute);
					listModelPoiSearch.addElement(selectedPoiOfRoute);
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 8;
		add(button_1, gbc_button_1);
		
		btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
				ArrayList<String> linksList = new ArrayList<String>();
				
				for (String line : textAreaImgs.getText().split("\\n")){
					try {
						imgList.add(ImageIO.read(new File(line)));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					
				for (String line : txtrLinks.getText().split("\\n")){
					linksList.add(line);
				}				
				
				if(imgList.size() == 0)
					imgList = null;
				if(linksList.size() == 0)
					linksList = null;
				
				curRoute = new Route();
				curRoute.setLibelle(txtLibelle.getText());
				
				ArrayList<Poi> curPoiList = new ArrayList<Poi>();
				for(int i=0; i<listPoiOfRoute.getModel().getSize(); i++){
					curPoiList.add((Poi) listPoiOfRoute.getModel().getElementAt(i));
				}
				curRoute.setPoiList(curPoiList);
				
				DescriptionComplex curDesc = curRoute.getDescmplx();
				curDesc.setDescription(textAreaDescription.getText());
				curDesc.setImage(imgList);
				curDesc.setLink(linksList);
				
				curRoute.setDescmplx(curDesc);
				
				DataEngine.getInstance().persist(curRoute);
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 10;
		add(btnAdd, gbc_btnAdd);
		
		btnMod = new JButton("Modifier");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
				ArrayList<String> linksList = new ArrayList<String>();
				
				for (String line : textAreaImgs.getText().split("\\n")){
					try {
						imgList.add(ImageIO.read(new File(line)));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					
				for (String line : txtrLinks.getText().split("\\n")){
					linksList.add(line);
				}				
				
				if(imgList.size() == 0)
					imgList = null;
				if(linksList.size() == 0)
					linksList = null;
				
				curRoute.setLibelle(txtLibelle.getText());
				
				ArrayList<Poi> curPoiList = new ArrayList<Poi>();
				for(int i=0; i<listPoiOfRoute.getModel().getSize(); i++){
					curPoiList.add((Poi) listPoiOfRoute.getModel().getElementAt(i));
				}
				curRoute.setPoiList(curPoiList);
				
				DescriptionComplex curDesc = curRoute.getDescmplx();
				curDesc.setDescription(textAreaDescription.getText());
				curDesc.setImage(imgList);
				curDesc.setLink(linksList);
				
				curRoute.setDescmplx(curDesc);
				
				DataEngine.getInstance().persist(curRoute);
			}
		});
		GridBagConstraints gbc_btnMod = new GridBagConstraints();
		gbc_btnMod.insets = new Insets(0, 0, 0, 5);
		gbc_btnMod.gridx = 6;
		gbc_btnMod.gridy = 10;
		add(btnMod, gbc_btnMod);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataEngine.getInstance().delete(curRoute);
			}
		});
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.gridx = 7;
		gbc_btnSupprimer.gridy = 10;
		add(btnSupprimer, gbc_btnSupprimer);
	}

}
