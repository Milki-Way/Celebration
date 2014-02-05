package display;

import java.awt.event.MouseListener;

import entity.Info;

public class SpeInfo extends SidePanelElement{
	private Info info;
	
	public SpeInfo(MouseListener mouseEvent, Info i) {
		super(mouseEvent);
		this.info = i;
	}

	/**
	 * @return the info
	 */
	public Info getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String printOject() {
		return this.info.getLibelle();
	}

}
