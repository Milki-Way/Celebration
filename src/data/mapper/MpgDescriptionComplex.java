package data.mapper;

import java.util.ArrayList;

import entity.IEntity;
import entity.Poi;
import entity.Route;

public class MpgDescriptionComplex implements Mappable {

	@Override
	public String add() {
		return "INSERT INTO descriptioncomplexe VALUES(NULL, ?, ?)";
	}

	@Override
	public String del() {
		return "DELETE FROM descriptioncomplexe WHERE iddescription = ?";
	}

	@Override
	public String sel() {
		return "SELECT * FROM descriptioncomplexe WHERE iddescription = ?";
	}

	@Override
	public String upd() {
		return "UPDATE descriptioncomplexe SET description = ? WHERE descriptioncomplexe.iddescription = ?";
	}

	@Override
	public String getAll() {
		return "SELECT * FROM descriptioncomplexe";
	}
	
	public String searchPoi(ArrayList<IEntity> list)
	{
		int i = 0;
		String query = "SELECT * FROM descriptioncomplexe WHERE description LIKE ? AND iddescription IN (";
		for(IEntity e : list)
		{
			i++;
			if(i<list.size())
				query += ((Poi)e).getDescription().getId() + ",";
			else
				query += ((Poi)e).getDescription().getId() + ")";
		}
		System.out.println(query);
		return query;
	}
	public String searchRoute(ArrayList<IEntity> list)
	{
		int i = 0;
		String query = "SELECT * FROM descriptioncomplexe WHERE description LIKE ? AND iddescription IN (";
		for(IEntity e : list)
		{
			i++;
			if(i<list.size())
				query += ((Route)e).getDescmplx().getId() + ",";
			else
				query += ((Route)e).getDescmplx().getId() + ")";
		}
		System.out.println(query);
		return query;
	}

}
