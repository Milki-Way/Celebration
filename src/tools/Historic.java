package tools;

import java.util.ArrayList;

import entity.Poi;

public class Historic {
	
	private ArrayList<Poi> poiList = new ArrayList<Poi>();
	private int index;
	
	
	public void updateIndex (Poi myPoi) {
	boolean trouve = false;
	
		for  (int i = 0; i<poiList.size() ; i ++)
		{
			
			if (myPoi == poiList.get(i))
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
		
		
		this.index = poiList.size() -1;
	}
	
	public Poi previous() 
	{
		
		if (index > 0)
		{
			return this.poiList.get(index);
		}
		
		else 
		{
			return null;
		}
	}
		
		
	
	
	public ArrayList<Poi> List() {
		return poiList;
	}
		
	
	
	public Poi next() {
		
		if (index < 0)
		{
			return this.poiList.get(index);
		}
		
		else 
		{
			return null;
		}
	}
}
