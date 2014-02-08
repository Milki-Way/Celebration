package tools;

import java.util.ArrayList;

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
	
	public HistoricRow previous(){
		
		if (index > 0)
		{
			this.index--;
			System.out.println("historic index:"+index);
			return this.historicList.get(index);
		} else {
			return null;
		}
	}
	
	public ArrayList<HistoricRow> getHistoricList() {
		return historicList;
	}
	
	public void addHistoricRow(HistoricRow h){
		this.historicList.add(h);
		this.index++;
	}
	
	public HistoricRow next() {
		
		if (index+1 != this.historicList.size())
		{
			this.index++;
			System.out.println("historic index:"+index+"<"+this.historicList.size());
			return this.historicList.get(index);
		} else {
			return null;
		}
	}
}
