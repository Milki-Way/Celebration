package data.mapper;

import java.util.ArrayList;

public class MpgRoute implements Mappable {

	@Override
	public String add() {
			return "INSERT INTO parcours VALUES(NULL, ?, ?)";
	}

	@Override
	public String del() {
	
		return "DELETE FROM parcours WHERE idparcours = ?";
	}

	@Override
	public String sel() {
		
		return "SELECT * FROM parcours where idparcours = ?";
	}

	@Override
	public String upd() {
		
		return "UPDATE parcours SET libelleparcours = ? WHERE parcours.idparcours = ?";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM parcours";
	}
	
	public String search()
	{
		return "SELECT * FROM parcours WHERE libelleparcours LIKE ?";
	}
	
	public String getRouteByDescription(ArrayList<Integer> intList)
	{
		int c = 0;
		String query = "SELECT * FROM parcours WHERE idrefdescription IN (";
		for(int i : intList)
		{
			c++;
			if(c == intList.size())
				query+= i + ")";
			else
				query += i + ",";
		}
		System.out.println(query);
		return query;
	}

}
