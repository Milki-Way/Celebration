import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;


public class PanelAjoutPoi extends JFrame
{
	private final JPanel panelAjoutPoi = new JPanel();
	private final JLabel labelColonne = new JLabel("Colonne");
	private final JLabel labelLigne = new JLabel("Ligne");
	private final JLabel labelLibelle = new JLabel("Libellé");
	private final JLabel labelLiens = new JLabel("Liens");
	private final JLabel labelImages = new JLabel("Images");
	private final JLabel labelAjoutPoint = new JLabel("Ajout d'un point d'interêt");
	private final JTextField textFieldColone = new JTextField();
	private final JTextField textFieldLigne = new JTextField();
	private final JTextField textFieldLibelle = new JTextField();
	private final JTextArea textAreaLiens = new JTextArea();
	private final JTextArea textAreaImages = new JTextArea();
	private final JButton boutonAjouter = new JButton("Ajouter");
	
	public PanelAjoutPoi()
	{
		textFieldLibelle.setColumns(10);
		textFieldLigne.setColumns(10);
		textFieldColone.setColumns(10);
		
			JPanel edition = new JPanel();
			getContentPane().add(edition);
			GridBagLayout gblEdition = new GridBagLayout();
			gblEdition.columnWidths = new int[]{0, 0};
			gblEdition.rowHeights = new int[]{0, 0};
			gblEdition.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gblEdition.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			edition.setLayout(gblEdition);
			
			GridBagConstraints gbcPanel = new GridBagConstraints();
			gbcPanel.fill = GridBagConstraints.BOTH;
			gbcPanel.gridx = 0;
			gbcPanel.gridy = 0;
			edition.add(panelAjoutPoi, gbcPanel);
			GridBagLayout gblPanel = new GridBagLayout();
			gblPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gblPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gblPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gblPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelAjoutPoi.setLayout(gblPanel);
			
			GridBagConstraints gbcLabelAjoutDunPoint = new GridBagConstraints();
			gbcLabelAjoutDunPoint.insets = new Insets(0, 0, 5, 0);
			gbcLabelAjoutDunPoint.gridx = 11;
			gbcLabelAjoutDunPoint.gridy = 1;
			panelAjoutPoi.add(labelAjoutPoint, gbcLabelAjoutDunPoint);
			
			GridBagConstraints gbcLabelColonne = new GridBagConstraints();
			gbcLabelColonne.insets = new Insets(0, 0, 5, 5);
			gbcLabelColonne.gridx = 4;
			gbcLabelColonne.gridy = 3;
			panelAjoutPoi.add(labelColonne, gbcLabelColonne);
			
			GridBagConstraints gbcTextFieldColone = new GridBagConstraints();
			gbcTextFieldColone.anchor = GridBagConstraints.WEST;
			gbcTextFieldColone.insets = new Insets(0, 0, 5, 0);
			gbcTextFieldColone.gridx = 11;
			gbcTextFieldColone.gridy = 3;
			panelAjoutPoi.add(textFieldColone, gbcTextFieldColone);
			
			GridBagConstraints gbcLabelLigne = new GridBagConstraints();
			gbcLabelLigne.insets = new Insets(0, 0, 5, 5);
			gbcLabelLigne.gridx = 4;
			gbcLabelLigne.gridy = 5;
			panelAjoutPoi.add(labelLigne, gbcLabelLigne);
			
			GridBagConstraints gbcTextFieldLigne = new GridBagConstraints();
			gbcTextFieldLigne.anchor = GridBagConstraints.WEST;
			gbcTextFieldLigne.insets = new Insets(0, 0, 5, 0);
			gbcTextFieldLigne.gridx = 11;
			gbcTextFieldLigne.gridy = 5;
			panelAjoutPoi.add(textFieldLigne, gbcTextFieldLigne);
			
			GridBagConstraints gbcLabelLibelle = new GridBagConstraints();
			gbcLabelLibelle.insets = new Insets(0, 0, 5, 5);
			gbcLabelLibelle.gridx = 4;
			gbcLabelLibelle.gridy = 7;
			panelAjoutPoi.add(labelLibelle, gbcLabelLibelle);
			
			GridBagConstraints gbcTextFieldLibelle = new GridBagConstraints();
			gbcTextFieldLibelle.anchor = GridBagConstraints.WEST;
			gbcTextFieldLibelle.insets = new Insets(0, 0, 5, 0);
			gbcTextFieldLibelle.gridx = 11;
			gbcTextFieldLibelle.gridy = 7;
			panelAjoutPoi.add(textFieldLibelle, gbcTextFieldLibelle);
			
			GridBagConstraints gbcTextAreaLiens = new GridBagConstraints();
			gbcTextAreaLiens.gridheight = 3;
			gbcTextAreaLiens.insets = new Insets(0, 0, 5, 0);
			gbcTextAreaLiens.fill = GridBagConstraints.BOTH;
			gbcTextAreaLiens.gridx = 11;
			gbcTextAreaLiens.gridy = 9;
			panelAjoutPoi.add(textAreaLiens, gbcTextAreaLiens);
			
			GridBagConstraints gbcLabelLiens = new GridBagConstraints();
			gbcLabelLiens.insets = new Insets(0, 0, 5, 5);
			gbcLabelLiens.gridx = 4;
			gbcLabelLiens.gridy = 10;
			panelAjoutPoi.add(labelLiens, gbcLabelLiens);
			
			GridBagConstraints gbcLabelImages = new GridBagConstraints();
			gbcLabelImages.insets = new Insets(0, 0, 5, 5);
			gbcLabelImages.gridx = 4;
			gbcLabelImages.gridy = 13;
			panelAjoutPoi.add(labelImages, gbcLabelImages);
			
			GridBagConstraints gbcTextAreaImages = new GridBagConstraints();
			gbcTextAreaImages.insets = new Insets(0, 0, 5, 0);
			gbcTextAreaImages.gridheight = 2;
			gbcTextAreaImages.fill = GridBagConstraints.BOTH;
			gbcTextAreaImages.gridx = 11;
			gbcTextAreaImages.gridy = 13;
			panelAjoutPoi.add(textAreaImages, gbcTextAreaImages);
			
			GridBagConstraints gbcBoutonAjouter = new GridBagConstraints();
			gbcBoutonAjouter.anchor = GridBagConstraints.EAST;
			gbcBoutonAjouter.gridx = 11;
			gbcBoutonAjouter.gridy = 16;
			panelAjoutPoi.add(boutonAjouter, gbcBoutonAjouter);
			
			getContentPane().add(panelAjoutPoi);
	}

	
}
