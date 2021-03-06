package display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import entity.IEntity;

public class ResultItem extends JLabel implements MouseListener{
	IEntity item;
	public ResultItem(String text, IEntity item)
	{
		super(text);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Result item has been clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return the item
	 */
	public IEntity getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(IEntity item) {
		this.item = item;
	}

}
