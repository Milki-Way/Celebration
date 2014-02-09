package display.editmode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.DataEngine;
import data.mapper.MapperEnum;
import entity.IEntity;
import entity.Info;

public class InfoEditPanel extends JPanel{
	private JTable table;
	
	public InfoEditPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model); 
		
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); 
        
        for (IEntity z : DataEngine.getInstance().Load(MapperEnum.INFO)) {
        	if(z instanceof Info){
        		Info a = (Info) z;
        		Object[] o = new Object[5];
        		o[0] = z.getId();
        		o[1] = a.getLibelle();
        		o[2] = a;
        		model.addRow(o);
        	}
        }
        
        table.getColumnModel().getColumn(2).setMinWidth(0);
        table.getColumnModel().getColumn(2).setMaxWidth(0);
        
		add(table);
	}
	
	private static class JTableMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
	            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
	            	Info info = (Info) table.getValueAt(row, 3);
	                DataEngine.getInstance().delete(info);
	                ((DefaultTableModel)table.getModel()).removeRow(row);
	            }
            }
        }
    }
}
