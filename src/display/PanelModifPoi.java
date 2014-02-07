package display;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTable;

public class PanelModifPoi extends JFrame
{
	private JTextField textFieldSearch;
	private JTextField textFieldColonne;
	private JTextField textFieldLigne;
	private JTextField textFieldLibelle;
	private JTextField textFieldLiens;
	private JTextField textFieldImages;
	private JTable table;
	
	public PanelModifPoi() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.fill = GridBagConstraints.BOTH;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		getContentPane().add(panel, gbcPanel);
		GridBagLayout gblPanel = new GridBagLayout();
		gblPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gblPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gblPanel);
		
		JLabel labelModifOuSupp = new JLabel("Modification ou Suppression d'un point d'inter\u00EAt");
		GridBagConstraints gbcLabelModificationOuSuppression = new GridBagConstraints();
		gbcLabelModificationOuSuppression.insets = new Insets(0, 0, 5, 5);
		gbcLabelModificationOuSuppression.gridx = 4;
		gbcLabelModificationOuSuppression.gridy = 1;
		panel.add(labelModifOuSupp, gbcLabelModificationOuSuppression);
		
		textFieldSearch = new JTextField();
		GridBagConstraints gbcTextFieldRecherche = new GridBagConstraints();
		gbcTextFieldRecherche.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldRecherche.gridx = 4;
		gbcTextFieldRecherche.gridy = 3;
		panel.add(textFieldSearch, gbcTextFieldRecherche);
		textFieldSearch.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		GridBagConstraints gbcBtnRechercher = new GridBagConstraints();
		gbcBtnRechercher.anchor = GridBagConstraints.WEST;
		gbcBtnRechercher.insets = new Insets(0, 0, 5, 5);
		gbcBtnRechercher.gridx = 5;
		gbcBtnRechercher.gridy = 3;
		panel.add(btnRechercher, gbcBtnRechercher);
		
		table = new JTable();
		GridBagConstraints gbcTable = new GridBagConstraints();
		gbcTable.insets = new Insets(0, 0, 5, 5);
		gbcTable.fill = GridBagConstraints.BOTH;
		gbcTable.gridx = 4;
		gbcTable.gridy = 5;
		panel.add(table, gbcTable);
		
		JButton btnModifier = new JButton("Modifier");
		GridBagConstraints gbcBtnModifier = new GridBagConstraints();
		gbcBtnModifier.anchor = GridBagConstraints.EAST;
		gbcBtnModifier.insets = new Insets(0, 0, 5, 5);
		gbcBtnModifier.gridx = 4;
		gbcBtnModifier.gridy = 8;
		panel.add(btnModifier, gbcBtnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbcBtnSupprimer = new GridBagConstraints();
		gbcBtnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbcBtnSupprimer.gridx = 5;
		gbcBtnSupprimer.gridy = 8;
		panel.add(btnSupprimer, gbcBtnSupprimer);
		
		JLabel labelColonne = new JLabel("Colonne");
		GridBagConstraints gbcLabelColonne = new GridBagConstraints();
		gbcLabelColonne.anchor = GridBagConstraints.NORTH;
		gbcLabelColonne.insets = new Insets(0, 0, 5, 5);
		gbcLabelColonne.gridx = 2;
		gbcLabelColonne.gridy = 10;
		panel.add(labelColonne, gbcLabelColonne);
		
		textFieldColonne = new JTextField();
		GridBagConstraints gbcTextFieldColonne = new GridBagConstraints();
		gbcTextFieldColonne.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldColonne.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldColonne.gridx = 4;
		gbcTextFieldColonne.gridy = 10;
		panel.add(textFieldColonne, gbcTextFieldColonne);
		textFieldColonne.setColumns(10);
		
		JLabel labelLigne = new JLabel("Ligne");
		GridBagConstraints gbc_lblLigne = new GridBagConstraints();
		gbc_lblLigne.insets = new Insets(0, 0, 5, 5);
		gbc_lblLigne.gridx = 2;
		gbc_lblLigne.gridy = 11;
		panel.add(labelLigne, gbc_lblLigne);
		
		textFieldLigne = new JTextField();
		GridBagConstraints gbcTextFieldLigne = new GridBagConstraints();
		gbcTextFieldLigne.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldLigne.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldLigne.gridx = 4;
		gbcTextFieldLigne.gridy = 11;
		panel.add(textFieldLigne, gbcTextFieldLigne);
		textFieldLigne.setColumns(10);
		
		JLabel labelLibell = new JLabel("Libell\u00E9");
		GridBagConstraints gbcLabelLibelle = new GridBagConstraints();
		gbcLabelLibelle.insets = new Insets(0, 0, 5, 5);
		gbcLabelLibelle.gridx = 2;
		gbcLabelLibelle.gridy = 12;
		panel.add(labelLibell, gbcLabelLibelle);
		
		textFieldLibelle = new JTextField();
		GridBagConstraints gbcTextFieldLibelle = new GridBagConstraints();
		gbcTextFieldLibelle.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldLibelle.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldLibelle.gridx = 4;
		gbcTextFieldLibelle.gridy = 12;
		panel.add(textFieldLibelle, gbcTextFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		JLabel labelLiens = new JLabel("Liens");
		GridBagConstraints gbcLabelLiens = new GridBagConstraints();
		gbcLabelLiens.insets = new Insets(0, 0, 5, 5);
		gbcLabelLiens.gridx = 2;
		gbcLabelLiens.gridy = 13;
		panel.add(labelLiens, gbcLabelLiens);
		
		textFieldLiens = new JTextField();
		GridBagConstraints gbcTextFieldLiens = new GridBagConstraints();
		gbcTextFieldLiens.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldLiens.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldLiens.gridx = 4;
		gbcTextFieldLiens.gridy = 13;
		panel.add(textFieldLiens, gbcTextFieldLiens);
		textFieldLiens.setColumns(10);
		
		JLabel labelImages = new JLabel("Images");
		GridBagConstraints gbcLabelImages = new GridBagConstraints();
		gbcLabelImages.insets = new Insets(0, 0, 5, 5);
		gbcLabelImages.gridx = 2;
		gbcLabelImages.gridy = 14;
		panel.add(labelImages, gbcLabelImages);
		
		textFieldImages = new JTextField();
		GridBagConstraints gbcTextFieldImages = new GridBagConstraints();
		gbcTextFieldImages.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldImages.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldImages.gridx = 4;
		gbcTextFieldImages.gridy = 14;
		panel.add(textFieldImages, gbcTextFieldImages);
		textFieldImages.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		GridBagConstraints gbcBtnValider = new GridBagConstraints();
		gbcBtnValider.anchor = GridBagConstraints.EAST;
		gbcBtnValider.insets = new Insets(0, 0, 0, 5);
		gbcBtnValider.gridx = 4;
		gbcBtnValider.gridy = 15;
		panel.add(btnValider, gbcBtnValider);
	}

}
