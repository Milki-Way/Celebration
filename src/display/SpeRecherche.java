package display;

import java.awt.event.MouseListener;

import tools.HistoricRow;
import entity.Poi;

public class SpeRecherche extends SidePanelElement{
	private ResultItem searchEntry;
	
	public SpeRecherche(MouseListener mouseEvent, ResultItem searchEntry) {
		this.searchEntry = searchEntry;
	}

	public ResultItem getHistoricRow() {
		return searchEntry;
	}

	public void setHistoricRow(ResultItem searchEntry) {
		this.searchEntry = searchEntry;
	}

	@Override
	public String printOject() {
		return this.searchEntry.getText();
	}
}
