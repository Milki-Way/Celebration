package data.mapper;

import java.util.ArrayList;

public class MpgPoi implements Mappable{

	@Override
	public String add() {
		
		return "INSERT INTO poi('xpoi', 'ypoi', 'libellepoi', 'idrefcarte', 'idtypepoi', 'idrefdescription') VALUES(?, ?, ?, ?, ?, ?)";
	}

	@Override
	public String del() {
		
		return "DELETE FROM poi WHERE idpoi = ?";
	}

	@Override
	public String sel() {
		
		return "SELECT * FROM poi WHERE idpoi = ?";
	}

	@Override
	public String upd() {
		 return "UPDATE poi SET libellepoi = ?, xpoi = ?, ypoi = ? WHERE poi.idpoi = ?";		
	}

	@Override
	public String getAll() {
		
		return "SELECT * FROM poi";
	}
	
	public String search()
	{
		return "SELECT * FROM poi WHERE libellepoi LIKE ?";
	}
	
	public String getPoiByDescription(ArrayList<Integer> intList)
	{
		String query;
		if(intList.size() > 0)
		{
			int c = 0;
			query = "SELECT * FROM poi WHERE idrefdescription IN (";
			for(int i : intList)
			{
				c++;
				if(c == intList.size())
					query+= i + ")";
				else
					query += i + ",";
			}
		}
		else
			query="SELECT * FROM poi WHERE idrefdescription = -1";
		return query;
	}

}
