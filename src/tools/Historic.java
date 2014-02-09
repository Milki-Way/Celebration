package tools;

import java.util.ArrayList;
import java.util.Observer;

public class Historic implements Observable{
	
	private static volatile Historic instance;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	private ArrayList<HistoricRow> historicList;
	private int index = 0;
	
	private Historic(){
		this.historicList = new ArrayList<HistoricRow>();
	}
	
	public final static Historic getInstance()
	{
		if (Historic.instance == null) {
			synchronized(Historic.class) {
				if (Historic.instance == null) {
					Historic.instance = new Historic();
				}
			}
		}
		return Historic.instance;
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
			if(this.historicList.size() == 0)
				return null;
			
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
		this.updateObservateur();
	}
	
	public HistoricRow next() {
		
		if (index+1 != this.historicList.size())
		{
			if(this.historicList.size() == 0)
				return null;
			
			this.index++;
			System.out.println("historic index:"+index+"<"+this.historicList.size());
			return this.historicList.get(index);
		} else {
			return null;
		}
	}

	@Override
	public void addObservateur(Observer obs) {
		this.listObserver.add(obs);
	}

	@Override
	public void updateObservateur() {
		for(Observer obs : this.listObserver )
		      obs.update();
	}

	@Override
	public void delObservateur() {
		this.listObserver = new ArrayList<Observer>();
	}
}
