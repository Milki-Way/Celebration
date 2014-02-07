package tools;

import java.util.ArrayList;

import entity.Poi;

public class Historic {
	
	private static Historic instance;
	private ArrayList<HistoricRow> historicList;
	private int index;
	
	private Historic(){
		this.historicList = new ArrayList<HistoricRow>();
	}
	
	public static Historic getInstance()
	{
		if(instance == null)
			instance = new Historic();
		return instance;
	}
	
	public void updateIndex (HistoricRow historicEntry) {
		boolean trouve = false;
	
		for  (int i = 0; i<historicList.size() ; i ++)
		{
			if (historicEntry == historicList.get(i))
			{
				trouve = true;
				this.index = i;				
			}
		}
		
		if (!trouve) {
			this.resetIndex();
		}	
	}
	
	public void resetIndex () {
		
		
		this.index = historicList.size() -1;
	}
	
	public HistoricRow previous() 
	{
		
		if (index > 0)
		{
			return this.historicList.get(index);
		}
		
		else 
		{
			return null;
		}
	}
	
	public ArrayList<HistoricRow> getHistoricList() {
		return historicList;
	}
	
	public HistoricRow next() {
		
		if (index < 0)
		{
			return this.historicList.get(index);
		}
		
		else 
		{
			return null;
		}
	}
}
