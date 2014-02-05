import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class PanelModifParcours extends JFrame
{
	private JTextField textFieldSearch;
	private JTable tableSuppParcours;
	private JTable tableModifParcours;
	private JTextField textFieldLibelle;
	
	public PanelModifParcours() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelModifParcours = new JPanel();
		GridBagConstraints gbcPanelModifParcours = new GridBagConstraints();
		gbcPanelModifParcours.fill = GridBagConstraints.BOTH;
		gbcPanelModifParcours.gridx = 0;
		gbcPanelModifParcours.gridy = 0;
		getContentPane().add(panelModifParcours, gbcPanelModifParcours);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelModifParcours.setLayout(gbl_panel);
		
		textFieldSearch = new JTextField();
		GridBagConstraints gbcTextFieldSearch = new GridBagConstraints();
		gbcTextFieldSearch.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldSearch.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldSearch.gridx = 4;
		gbcTextFieldSearch.gridy = 1;
		panelModifParcours.add(textFieldSearch, gbcTextFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton boutonRechercher = new JButton("Rechercher");
		GridBagConstraints gbcBoutonRechercherRechercher = new GridBagConstraints();
		gbcBoutonRechercherRechercher.insets = new Insets(0, 0, 5, 5);
		gbcBoutonRechercherRechercher.gridx = 5;
		gbcBoutonRechercherRechercher.gridy = 1;
		panelModifParcours.add(boutonRechercher, gbcBoutonRechercherRechercher);
		
		tableSuppParcours = new JTable();
		GridBagConstraints gbcTableSuppParcours = new GridBagConstraints();
		gbcTableSuppParcours.gridheight = 5;
		gbcTableSuppParcours.gridwidth = 4;
		gbcTableSuppParcours.insets = new Insets(0, 0, 5, 5);
		gbcTableSuppParcours.fill = GridBagConstraints.BOTH;
		gbcTableSuppParcours.gridx = 1;
		gbcTableSuppParcours.gridy = 3;
		panelModifParcours.add(tableSuppParcours, gbcTableSuppParcours);
		
		JLabel labelLibelle = new JLabel("Libellé");
		GridBagConstraints gbcLabelLibelle = new GridBagConstraints();
		gbcLabelLibelle.insets = new Insets(0, 0, 5, 5);
		gbcLabelLibelle.gridx = 6;
		gbcLabelLibelle.gridy = 3;
		panelModifParcours.add(labelLibelle, gbcLabelLibelle);
		
		textFieldLibelle = new JTextField();
		GridBagConstraints gbTextFieldLibelle = new GridBagConstraints();
		gbTextFieldLibelle.gridwidth = 3;
		gbTextFieldLibelle.insets = new Insets(0, 0, 5, 5);
		gbTextFieldLibelle.fill = GridBagConstraints.HORIZONTAL;
		gbTextFieldLibelle.gridx = 8;
		gbTextFieldLibelle.gridy = 3;
		panelModifParcours.add(textFieldLibelle, gbTextFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		JLabel labelLiens = new JLabel("Liens");
		GridBagConstraints gbcLabelLiens = new GridBagConstraints();
		gbcLabelLiens.insets = new Insets(0, 0, 5, 5);
		gbcLabelLiens.gridx = 6;
		gbcLabelLiens.gridy = 4;
		panelModifParcours.add(labelLiens, gbcLabelLiens);
		
		JTextArea textAreaLiens = new JTextArea();
		GridBagConstraints gbcTextAreaLiens = new GridBagConstraints();
		gbcTextAreaLiens.gridwidth = 3;
		gbcTextAreaLiens.insets = new Insets(0, 0, 5, 5);
		gbcTextAreaLiens.fill = GridBagConstraints.BOTH;
		gbcTextAreaLiens.gridx = 8;
		gbcTextAreaLiens.gridy = 4;
		panelModifParcours.add(textAreaLiens, gbcTextAreaLiens);
		
		JLabel labelImage = new JLabel("Image");
		GridBagConstraints gbcLabelImage = new GridBagConstraints();
		gbcLabelImage.insets = new Insets(0, 0, 5, 5);
		gbcLabelImage.gridx = 6;
		gbcLabelImage.gridy = 5;
		panelModifParcours.add(labelImage, gbcLabelImage);
		
		JTextArea textAreaImages = new JTextArea();
		GridBagConstraints gbcTextAreaImages = new GridBagConstraints();
		gbcTextAreaImages.gridwidth = 3;
		gbcTextAreaImages.insets = new Insets(0, 0, 5, 5);
		gbcTextAreaImages.fill = GridBagConstraints.BOTH;
		gbcTextAreaImages.gridx = 8;
		gbcTextAreaImages.gridy = 5;
		panelModifParcours.add(textAreaImages, gbcTextAreaImages);
		
		tableModifParcours = new JTable();
		GridBagConstraints gbcTableModifParcours = new GridBagConstraints();
		gbcTableModifParcours.gridheight = 4;
		gbcTableModifParcours.gridwidth = 5;
		gbcTableModifParcours.insets = new Insets(0, 0, 5, 0);
		gbcTableModifParcours.fill = GridBagConstraints.BOTH;
		gbcTableModifParcours.gridx = 8;
		gbcTableModifParcours.gridy = 6;
		panelModifParcours.add(tableModifParcours, gbcTableModifParcours);
		
		JButton boutonModifParcours = new JButton("Modifier");
		GridBagConstraints gbcBoutonModifParcours = new GridBagConstraints();
		gbcBoutonModifParcours.insets = new Insets(0, 0, 5, 5);
		gbcBoutonModifParcours.gridx = 1;
		gbcBoutonModifParcours.gridy = 8;
		panelModifParcours.add(boutonModifParcours, gbcBoutonModifParcours);
		
		JButton boutonSupprimerParcours = new JButton("Supprimer");
		GridBagConstraints gbcBoutonSupprimerParcours = new GridBagConstraints();
		gbcBoutonSupprimerParcours.insets = new Insets(0, 0, 5, 5);
		gbcBoutonSupprimerParcours.gridx = 4;
		gbcBoutonSupprimerParcours.gridy = 8;
		panelModifParcours.add(boutonSupprimerParcours, gbcBoutonSupprimerParcours);
		
		JButton boutonValider = new JButton("Valider");
		GridBagConstraints gbBoutonValider = new GridBagConstraints();
		gbBoutonValider.insets = new Insets(0, 0, 5, 0);
		gbBoutonValider.gridx = 12;
		gbBoutonValider.gridy = 10;
		panelModifParcours.add(boutonValider, gbBoutonValider);
	}
	

}
