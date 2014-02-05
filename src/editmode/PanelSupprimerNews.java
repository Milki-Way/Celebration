import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;



public class PanelSupprimerNews extends JFrame
{
	private JTable tableNews;
	
	public PanelSupprimerNews() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelSuppNews = new JPanel();
		GridBagConstraints gbcPanelSuppNews = new GridBagConstraints();
		gbcPanelSuppNews.fill = GridBagConstraints.BOTH;
		gbcPanelSuppNews.gridx = 0;
		gbcPanelSuppNews.gridy = 0;
		getContentPane().add(panelSuppNews, gbcPanelSuppNews);
		GridBagLayout gblPanelSuppNews = new GridBagLayout();
		gblPanelSuppNews.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gblPanelSuppNews.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanelSuppNews.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gblPanelSuppNews.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSuppNews.setLayout(gblPanelSuppNews);
		
		JLabel labelSuppressionNews = new JLabel("Suppression des News");
		GridBagConstraints gbcLabelSuppressionNews = new GridBagConstraints();
		gbcLabelSuppressionNews.insets = new Insets(0, 0, 5, 0);
		gbcLabelSuppressionNews.gridx = 5;
		gbcLabelSuppressionNews.gridy = 1;
		panelSuppNews.add(labelSuppressionNews, gbcLabelSuppressionNews);
		
		tableNews = new JTable();
		GridBagConstraints gbcTableNews = new GridBagConstraints();
		gbcTableNews.insets = new Insets(0, 0, 5, 0);
		gbcTableNews.fill = GridBagConstraints.BOTH;
		gbcTableNews.gridx = 5;
		gbcTableNews.gridy = 5;
		panelSuppNews.add(tableNews, gbcTableNews);
		
		JButton boutonSupprimer = new JButton("Supprimer");
		GridBagConstraints gbcBoutonSupprimer = new GridBagConstraints();
		gbcBoutonSupprimer.gridx = 5;
		gbcBoutonSupprimer.gridy = 8;
		panelSuppNews.add(boutonSupprimer, gbcBoutonSupprimer);
		
	}
	
}
