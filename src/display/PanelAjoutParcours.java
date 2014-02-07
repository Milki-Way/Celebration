package display;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;


public class PanelAjoutParcours extends JFrame
{
	private JTextField textFieldLibelle;
	private JTable tableListePoiDispo;
	private JTable tableListePoiAjoutes;
	public PanelAjoutParcours() {
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
		gblPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gblPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gblPanel);
		
		JLabel labelAjoutParcours = new JLabel("Ajout d'un parcours");
		GridBagConstraints gbcLabelAjoutParcours = new GridBagConstraints();
		gbcLabelAjoutParcours.insets = new Insets(0, 0, 5, 5);
		gbcLabelAjoutParcours.gridx = 16;
		gbcLabelAjoutParcours.gridy = 1;
		panel.add(labelAjoutParcours, gbcLabelAjoutParcours);
		
		JLabel labelLibelle = new JLabel("Libellé");
		GridBagConstraints gbc_lblLibell = new GridBagConstraints();
		gbc_lblLibell.gridwidth = 6;
		gbc_lblLibell.insets = new Insets(0, 0, 5, 5);
		gbc_lblLibell.gridx = 8;
		gbc_lblLibell.gridy = 3;
		panel.add(labelLibelle, gbc_lblLibell);
		
		textFieldLibelle = new JTextField();
		GridBagConstraints gbcTextFieldLibelle = new GridBagConstraints();
		gbcTextFieldLibelle.gridwidth = 3;
		gbcTextFieldLibelle.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldLibelle.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldLibelle.gridx = 16;
		gbcTextFieldLibelle.gridy = 3;
		panel.add(textFieldLibelle, gbcTextFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		JLabel labelLiens = new JLabel("Liens");
		GridBagConstraints gbcLabelLiens = new GridBagConstraints();
		gbcLabelLiens.gridwidth = 6;
		gbcLabelLiens.insets = new Insets(0, 0, 5, 5);
		gbcLabelLiens.gridx = 8;
		gbcLabelLiens.gridy = 4;
		panel.add(labelLiens, gbcLabelLiens);
		
		JTextArea textAreaLiens = new JTextArea();
		GridBagConstraints gbcTextAreaLiens = new GridBagConstraints();
		gbcTextAreaLiens.gridwidth = 3;
		gbcTextAreaLiens.insets = new Insets(0, 0, 5, 5);
		gbcTextAreaLiens.fill = GridBagConstraints.BOTH;
		gbcTextAreaLiens.gridx = 16;
		gbcTextAreaLiens.gridy = 4;
		panel.add(textAreaLiens, gbcTextAreaLiens);
		
		JLabel labelImages = new JLabel("Images");
		GridBagConstraints gbcLabelImages = new GridBagConstraints();
		gbcLabelImages.gridwidth = 6;
		gbcLabelImages.insets = new Insets(0, 0, 5, 5);
		gbcLabelImages.gridx = 8;
		gbcLabelImages.gridy = 5;
		panel.add(labelImages, gbcLabelImages);
		
		JTextArea textAreaImages = new JTextArea();
		GridBagConstraints gbcTextAreaImages = new GridBagConstraints();
		gbcTextAreaImages.gridwidth = 3;
		gbcTextAreaImages.insets = new Insets(0, 0, 5, 5);
		gbcTextAreaImages.fill = GridBagConstraints.BOTH;
		gbcTextAreaImages.gridx = 16;
		gbcTextAreaImages.gridy = 5;
		panel.add(textAreaImages, gbcTextAreaImages);
		
		JLabel labelListeDesPoi = new JLabel("Liste des POI ajout\u00E9s");
		GridBagConstraints gbcLabelListeDesPoi = new GridBagConstraints();
		gbcLabelListeDesPoi.insets = new Insets(0, 0, 5, 5);
		gbcLabelListeDesPoi.gridx = 8;
		gbcLabelListeDesPoi.gridy = 6;
		panel.add(labelListeDesPoi, gbcLabelListeDesPoi);
		
		JLabel labelListeDesPoiDispo = new JLabel("Liste des POI disponibles");
		GridBagConstraints gbcLabelListeDesPoiDispo = new GridBagConstraints();
		gbcLabelListeDesPoiDispo.insets = new Insets(0, 0, 5, 5);
		gbcLabelListeDesPoiDispo.gridx = 18;
		gbcLabelListeDesPoiDispo.gridy = 6;
		panel.add(labelListeDesPoiDispo, gbcLabelListeDesPoiDispo);
		
		tableListePoiAjoutes = new JTable();
		GridBagConstraints gbcTableListePoiAjoutes = new GridBagConstraints();
		gbcTableListePoiAjoutes.gridwidth = 9;
		gbcTableListePoiAjoutes.gridheight = 4;
		gbcTableListePoiAjoutes.insets = new Insets(0, 0, 5, 5);
		gbcTableListePoiAjoutes.fill = GridBagConstraints.BOTH;
		gbcTableListePoiAjoutes.gridx = 8;
		gbcTableListePoiAjoutes.gridy = 8;
		panel.add(tableListePoiAjoutes, gbcTableListePoiAjoutes);
		
		tableListePoiDispo = new JTable();
		GridBagConstraints gbcTableListePoiDispo = new GridBagConstraints();
		gbcTableListePoiDispo.gridheight = 4;
		gbcTableListePoiDispo.insets = new Insets(0, 0, 5, 5);
		gbcTableListePoiDispo.fill = GridBagConstraints.BOTH;
		gbcTableListePoiDispo.gridx = 18;
		gbcTableListePoiDispo.gridy = 8;
		panel.add(tableListePoiDispo, gbcTableListePoiDispo);
		
		JButton btnAjouterAuParcours = new JButton("Ajouter au parcours");
		GridBagConstraints gbcBtnAjouterAuParcours = new GridBagConstraints();
		gbcBtnAjouterAuParcours.insets = new Insets(0, 0, 5, 5);
		gbcBtnAjouterAuParcours.gridx = 18;
		gbcBtnAjouterAuParcours.gridy = 12;
		panel.add(btnAjouterAuParcours, gbcBtnAjouterAuParcours);
		
		JButton btnValider = new JButton("Valider");
		GridBagConstraints gbcBtnValider = new GridBagConstraints();
		gbcBtnValider.insets = new Insets(0, 0, 0, 5);
		gbcBtnValider.gridx = 16;
		gbcBtnValider.gridy = 13;
		panel.add(btnValider, gbcBtnValider);
	}
	
}
