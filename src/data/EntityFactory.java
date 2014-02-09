package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.mapper.MapperEnum;
import entity.DescriptionComplex;
import entity.IEntity;
import entity.Info;
import entity.Poi;
import entity.Route;

public class EntityFactory {
	public static ArrayList<IEntity> createIdentifiable(MapperEnum type, ResultSet data)
	{

		ArrayList<IEntity> result = new ArrayList<IEntity>();
		try {
			if(data != null && data.next())
			{
				switch(type)
				{
					case POI:
						while(data.next())
						{
							DescriptionComplex desc = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
							result.add(new Poi(data.getInt("idpoi"), data.getString("libellepoi"), data.getDouble("xpoi"),data.getDouble("ypoi"), desc));
						}
					break;
					case INFO:
						while(data.next())
						{
							DescriptionComplex descInfo = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
							result.add(new Info(data.getInt("idnews"), data.getString("libellenews"), descInfo));
						}
					break;
					
					case PARCOURS:
						ArrayList<IEntity> enlist = DataEngine.getInstance().loadPoiOfRoute(data.getInt("idparcours"));
						ArrayList<Poi> poiList = new ArrayList<Poi>();
						for(IEntity e : enlist)
							poiList.add((Poi)e);
						DescriptionComplex descRoute = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
						result.add(new Route(data.getInt("idparcours"), data.getString("libelleparcours"), poiList, descRoute));
						break;
					
						default:
							return null;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static IEntity getOneIdentifiable(MapperEnum type, ResultSet data)
	{
			try{
				if(data != null && data.next())
				{
					switch(type)
					{
						case POI:
							DescriptionComplex desc = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
							return new Poi(data.getInt("idpoi"), data.getString("libellepoi"), data.getDouble("xpoi"),data.getDouble("ypoi"), desc);
							
						case DESCRIPTIONCOMPLEX:
							int dId = data.getInt("iddescription");
							return new DescriptionComplex(
									data.getString("description"), 
									DataEngine.getInstance().loadInfoImg(dId),
									DataEngine.getInstance().loadInfoLinks(dId),
									DataEngine.getInstance().loadReference(dId));
						case INFO:
							DescriptionComplex descInfo = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
							return new Info(data.getInt("idnews"), data.getString("libellenews"), descInfo);
							
						case PARCOURS:
							ArrayList<IEntity> enlist = DataEngine.getInstance().loadPoiOfRoute(data.getInt("idparcours"));
							ArrayList<Poi> poiList = new ArrayList<Poi>();
							for(IEntity e : enlist)
								poiList.add((Poi)e);
							DescriptionComplex descRoute = (DescriptionComplex)DataEngine.getInstance().select(MapperEnum.DESCRIPTIONCOMPLEX, data.getInt("idrefdescription"));
							return new Route(data.getInt("idparcours"), data.getString("libelleparcours"), poiList, descRoute);
							
						default:
							return null;
						
					}
				}
			}
			catch(SQLException e)
			{
				System.out.println("EntityFactory error : can't create item because of SQL Exception");
				e.printStackTrace();
			}
		return null;
	}
}
