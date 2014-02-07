package display.editmode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import display.World;

public class EditPanel extends JPanel {
	
	public enum ObjPanel {
		  POI,
		  NEWS,
		  PARCOURS;
		}

	private JMenuBar menuprincipal = new JMenuBar();
	private JMenu menuPoi = new JMenu("POI");
	private JMenu menuNews = new JMenu("News");
	private JMenu menuParcours = new JMenu("Parcours");
	private JPanel curPane;

	public EditPanel() {
		this.setSize(new Dimension(735, 554));
		this.setLayout(new BorderLayout());

		this.menuprincipal.add(menuPoi);// JMenu
		this.menuprincipal.add(menuNews);
		this.menuprincipal.add(menuParcours);
		
		JButton btnSwitchmode = new JButton("Switch Mode");
		btnSwitchmode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				World.getInstance().switchMode();
				System.out.println("Switching to "
						+ World.getInstance().getDisplayMode());
			}
		});
		this.menuprincipal.add(btnSwitchmode);

		this.add(menuprincipal, BorderLayout.NORTH);
		
		menuPoi.addMouseListener(new changePanelMouse(this, ObjPanel.POI));
		menuNews.addMouseListener(new changePanelMouse(this, ObjPanel.NEWS));
		menuParcours.addMouseListener(new changePanelMouse(this, ObjPanel.PARCOURS));
	}
	
	public class changePanelMouse implements MouseListener{
		
		private EditPanel editPane;
		private ObjPanel type;
		
		public changePanelMouse(EditPanel editPane, ObjPanel type){
			this.editPane = editPane;
			this.type = type;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(type == ObjPanel.POI){
				curPane = new PoiEditPanel();
			} else if(type == ObjPanel.NEWS){
				curPane = new InfoEditPanel();
			} else if(type == ObjPanel.PARCOURS){
				curPane = new PoiEditPanel();
			}
			editPane.removeAll();
			editPane.add(menuprincipal, BorderLayout.NORTH);
			editPane.add(curPane, BorderLayout.CENTER);
			editPane.repaint();
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
}
