package display;

import java.awt.event.MouseListener;

import entity.Info;

public class SpeInfo extends SidePanelElement{
	private Info info;
	
	public SpeInfo(String libelle, MouseListener mouseEvent, Info i) {
		super(libelle, mouseEvent);
		this.info = i;
	}

}
