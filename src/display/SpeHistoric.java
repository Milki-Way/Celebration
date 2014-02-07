package display;

import java.awt.event.MouseListener;

import tools.HistoricRow;
import entity.Poi;

public class SpeHistoric extends SidePanelElement{
	private HistoricRow historyEntry;
	
	public SpeHistoric(MouseListener mouseEvent, HistoricRow historyEntry) {
		this.historyEntry = historyEntry;
	}

	/**
	 * @return the poi
	 */
	public HistoricRow getHistoricRow() {
		return historyEntry;
	}

	/**
	 * @param poi the poi to set
	 */
	public void setHistoricRow(HistoricRow historyEntry) {
		this.historyEntry = historyEntry;
	}

	@Override
	public String printOject() {
		return this.historyEntry.getPoiLibelle();
	}
}
