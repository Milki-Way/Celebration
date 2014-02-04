package data;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tileengine.Tile;
import data.mapper.MapperEnum;
import data.mapper.MpgInfos;
import data.mapper.MpgMap;
import data.mapper.MpgPoi;
import data.mapper.MpgRoute;
import data.mapper.MpgTile;
import entity.Identifiable;


public class DataEngine {
	
	private static DataEngine instance;
	private Cad cadData;
	private Cad cadTiles;
	
	private MpgMap mapMapper;
	private MpgInfos infoMapper;
	private MpgPoi poiMapper;
	private MpgRoute routeMapper;
	private MpgTile tileMapper;
	
	//Private constructor
	private DataEngine()
	{
		mapMapper = new MpgMap();
		infoMapper = new MpgInfos();
		poiMapper = new MpgPoi();
		routeMapper = new MpgRoute();
		tileMapper = new MpgTile();
		cadData = new Cad("jdbc:sqlite:data/db/map.mbtiles");
		cadTiles = new Cad("jdbc:sqlite:data/db/map.mbtiles");
	}
	
	//Get dataengine instance
	public static DataEngine getInstance()
	{
		if(instance == null)
			instance = new DataEngine();
		return instance;
	}
	
	//Add or update an object into the db
	public Boolean persist(Identifiable o)
	{
		Boolean r = false;
		PreparedStatement query;
		System.out.println(o.getId());
		System.out.println(o.getId() > 0);
		if(o.getId() > 0)
		{
			switch(o.getClass().getName())
			{
				case "data.Map":
					query = cadData.getPreparedStatement(mapMapper.upd());
					cadData.executePreparation(QueryPrepared.updateParameters(query, o));;
					break;
					
				case "data.Route":
					query = cadData.getPreparedStatement(routeMapper.upd());
					cadData.executePreparation(QueryPrepared.updateParameters(query, o));
					break;
					
				case "data.New":
					query = cadData.getPreparedStatement(infoMapper.upd());
					cadData.executePreparation(QueryPrepared.updateParameters(query, o));
					break;
					
				case "data.Poi":
					query = cadData.getPreparedStatement(poiMapper.upd());
					cadData.executePreparation(QueryPrepared.updateParameters(query, o));
					break;
					
				default:
					System.out.println(String.format("Unable to persist : class %s is unknown in persist method range.", o.getClass().getName()));
			}	
			r=true;
		}
		else
		{
			System.out.println("appel");
			switch(o.getClass().getName())
			{
				case "data.Map":
					query = cadData.getPreparedStatement(mapMapper.add());
					System.out.println(QueryPrepared.insertParameters(query, o).toString());
					cadData.executePreparation(QueryPrepared.insertParameters(query, o));
					break;
					
				case "data.Route":
					query = cadData.getPreparedStatement(mapMapper.add());
					cadData.executePreparation(QueryPrepared.insertParameters(query, o));
					break;
					
				case "data.New":
					query = cadData.getPreparedStatement(mapMapper.add());
					cadData.executePreparation(QueryPrepared.insertParameters(query, o));
					break;
					
				case "data.Poi":
					query = cadData.getPreparedStatement(mapMapper.add());
					cadData.executePreparation(QueryPrepared.insertParameters(query, o));
					break;
					
				default:
					System.out.println(String.format("Unable to persist : class %s is unknown in persist method range.", o.getClass().getName()));
			}
			r = true;
		}
		return r;
	}

	//delete item from db
	public Boolean delete(Identifiable o)
	{
		try
		{
			PreparedStatement query = cadData.getPreparedStatement(mapMapper.del());
			System.out.println(QueryPrepared.deleteParameters(query, o).toString());
			cadData.executePreparation(QueryPrepared.deleteParameters(query, o));
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("NEARLY FATAL ERROR !!! : " + ex.getMessage());
			return false;
		}
		
		
	}
	
	//delete item from db
		public Boolean select(MapperEnum type, Identifiable o)
		{
			try
			{
				PreparedStatement query;
				switch(o.getClass().getName())
				{
					case "data.Map":
						query = cadData.getPreparedStatement(mapMapper.upd());
						cadData.executePreparation(QueryPrepared.updateParameters(query, o));
						break;
						
					case "data.Route":
						query = cadData.getPreparedStatement(routeMapper.upd());
						cadData.executePreparation(QueryPrepared.updateParameters(query, o));
						break;
						
					case "data.New":
						query = cadData.getPreparedStatement(infoMapper.upd());
						cadData.executePreparation(QueryPrepared.updateParameters(query, o));
						break;
						
					case "data.Poi":
						query = cadData.getPreparedStatement(poiMapper.upd());
						cadData.executePreparation(QueryPrepared.updateParameters(query, o));
						break;
						
					default:
						System.out.println(String.format("Unable to persist : class %s is unknown in persist method range.", o.getClass().getName()));
				}	
				return true;
			}
			catch(Exception ex)
			{
				System.out.println("NEARLY FATAL ERROR !!! : " + ex.getMessage());
				return false;
			}
			
			
		}
	
	//get all instance from db
	public ArrayList<Identifiable> Load(MapperEnum table)
	{
		ResultSet rs;
		switch(table)
		{
			case MAP:
				rs = cadData.getSQL(mapMapper.getAll());
				break;
			case POI:
				rs = cadData.getSQL(poiMapper.getAll());
				break;
			case INFO:
				rs = cadData.getSQL(infoMapper.getAll());
				break;
			case PARCOURS:
				rs = cadData.getSQL(routeMapper.getAll());
				break;
			default:
				rs = null;
				break;
				
		}
		if(rs != null)
			return IdentifiableFactory.createIdentifiable(table, rs);
		else
			return null;
		
	}
	
	public Tile LoadTile(String keyCode)
	{
		ResultSet rs;
		String result[] = keyCode.split("/");
		if(result.length == 3)
		{
			try {
				rs = cadTiles.getSQL(tileMapper.sel(result[0], result[1], result[2]));
				if(rs != null)
				{
					InputStream imgStream = new ByteArrayInputStream(rs.getBytes("tile_data"));
					BufferedImage img = ImageIO.read(imgStream); 
					return new Tile(rs.getInt("zoom_level"), rs.getInt("tile_column"), rs.getInt("tile_row"), img);
				}
				else
				{
					System.out.println("Aucune tuile n'a été trouvé pour ce keyCode...");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			System.out.println("Error in Key code for TileLoad (DataEngine)");
			return null;
		}
		
	}
}
