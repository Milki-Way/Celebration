package display;

import java.awt.event.MouseListener;

import tools.HistoricRow;
import entity.Poi;

public class SpeHistoric extends SidePanelElement{
	private HistoricRow historyEntry;
	
	public SpeHistoric(MouseListener mouseEvent, HistoricRow historyEntry) {
		this.historyEntry = historyEntry;
	}

	public HistoricRow getHistoricRow() {
		return historyEntry;
	}

	public void setHistoricRow(HistoricRow historyEntry) {
		this.historyEntry = historyEntry;
	}

	@Override
	public String printOject() {
		return this.historyEntry.getPoiLibelle();
	}
}
