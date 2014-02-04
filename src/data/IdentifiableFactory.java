package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.mapper.MapperEnum;
import entity.Identifiable;

public class IdentifiableFactory {
	public static ArrayList<Identifiable> createIdentifiable(MapperEnum type, ResultSet data)
	{

		try {
			ArrayList<Identifiable> result = new ArrayList<Identifiable>();
			switch(type)
			{
				case MAP:
					while(data.next())
					{
					}
					
				case POI:
					while(data.next())
					{
					}
				break;
			}
			return result;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
