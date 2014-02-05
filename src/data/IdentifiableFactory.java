package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.mapper.MapperEnum;
import entity.DescriptionComplex;
import entity.Identifiable;
import entity.Info;
import entity.Poi;
import entity.Route;
import geography.IReferenceable;

public class IdentifiableFactory {
	public static ArrayList<Identifiable> createIdentifiable(MapperEnum type, ResultSet data)
	{

		try {
			ArrayList<Identifiable> result = new ArrayList<Identifiable>();
			switch(type)
			{
				case POI:
					while(data.next())
					{
						DescriptionComplex desc = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
						result.add(new Poi(data.getInt("idpoi"), data.getString("libellepoi"), data.getInt("xpoi"),data.getInt("ypoi"), desc));
					}
				break;
				case INFO:
					while(data.next())
					{
						IReferenceable ref = new Poi(); // TODO !!!
						DescriptionComplex descInfo = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
						result.add(new Info(data.getInt("idnews"), data.getString("libellenews"), descInfo, ref));
					}
				break;
				
				case PARCOURS:
					ArrayList<Poi> poiList = new ArrayList<Poi>(); // TODO !!!
					DescriptionComplex descRoute = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
					result.add(new Route(data.getInt("idparcours"), data.getString("libelleparcours"), poiList, descRoute));
					break;
				
					default:
						return null;
			}
			return result;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Identifiable getOneIdentifiable(MapperEnum type, ResultSet data)
	{
		try{
			switch(type)
			{
				case POI:
					DescriptionComplex desc = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
					return new Poi(data.getInt("idpoi"), data.getString("libellepoi"), data.getInt("xpoi"),data.getInt("ypoi"), desc);
					
				case DESCRIPTIONCOMPLEX:
					//TODO !!!
					break;
				case INFO:
					IReferenceable ref = new Poi(); // TODO !!!
					DescriptionComplex descInfo = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
					return new Info(data.getInt("idnews"), data.getString("libellenews"), descInfo, ref);
					
				case PARCOURS:
					ArrayList<Poi> poiList = new ArrayList<Poi>(); // TODO !!!
					DescriptionComplex descRoute = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
					return new Route(data.getInt("idparcours"), data.getString("libelleparcours"), poiList, descRoute);
					
				default:
					return null;
				
			}
		}
		catch(SQLException e)
		{
			System.out.println("IdentifiableFactory error : can't create item because of SQL Exception");
		}
		return null;
	}
}
