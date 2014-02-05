package data;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tileengine.Tile;
import data.mapper.MapperEnum;
import data.mapper.MpgDescriptionComplex;
import data.mapper.MpgImageDesc;
import data.mapper.MpgInfos;
import data.mapper.MpgLiensDesc;
import data.mapper.MpgMap;
import data.mapper.MpgPoi;
import data.mapper.MpgRoute;
import data.mapper.MpgTile;
import entity.DescriptionComplex;
import entity.Identifiable;
import entity.Info;
import entity.Poi;
import entity.Route;


public class DataEngine {
	
	private static DataEngine instance;
	private Cad cadData;
	private Cad cadTiles;
	
	private MpgInfos infoMapper;
	private MpgPoi poiMapper;
	private MpgRoute routeMapper;
	private MpgTile tileMapper;
	private MpgDescriptionComplex descMapper;
	private MpgImageDesc imageDescriptionMapper;
	private MpgLiensDesc lienDescriptionMapper;
	
	//Private constructor
	private DataEngine()
	{
		infoMapper = new MpgInfos();
		poiMapper = new MpgPoi();
		routeMapper = new MpgRoute();
		tileMapper = new MpgTile();
		imageDescriptionMapper = new MpgImageDesc();
		descMapper = new MpgDescriptionComplex();
		lienDescriptionMapper = new MpgLiensDesc();
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
	public Boolean persist(Route r)
	{
		Boolean result = false;
		PreparedStatement query;
		
		try {
			if(r.getId() > 0)
			{
				query = cadData.getPreparedStatement(routeMapper.upd());
				cadData.executePreparation(QueryPrepared.updateParameters(query, r));
				this.persist(r.getDescmplx());
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(routeMapper.add());
				cadData.executePreparation(QueryPrepared.insertParameters(query, r));
				this.persist(r.getDescmplx());
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Error on Persist : SQL Exception : " + e.getMessage());
		}
		return result;
	}
	public Boolean persist(Info i)
	{
		Boolean result = false;
		PreparedStatement query;
		
		try {
			if(i.getId() > 0)
			{
				query = cadData.getPreparedStatement(infoMapper.upd());
				cadData.executePreparation(QueryPrepared.updateParameters(query, i));
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(infoMapper.add());
				cadData.executePreparation(QueryPrepared.insertParameters(query, i));
				this.persist(i.getDescplx());
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Error on Persist : SQL Exception : " + e.getMessage());
		}
		return result;
	}
	public Boolean persist(Poi p)
	{
		Boolean result = false;
		PreparedStatement query;
		
		try {
			if(p.getId() > 0)
			{
				query = cadData.getPreparedStatement(poiMapper.upd());
				cadData.executePreparation(QueryPrepared.updateParameters(query, p));
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(poiMapper.upd());
				cadData.executePreparation(QueryPrepared.insertParameters(query, p));
				this.persist(p.getDescription());
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Error on Persist : SQL Exception : " + e.getMessage());
		}
		return result;
	}
	public Boolean persist(DescriptionComplex d)
	{
		Boolean result = false;
		PreparedStatement query;
		
		try {
			if(d.getId() > 0)
			{
				query = cadData.getPreparedStatement(descMapper.upd());
				cadData.executePreparation(QueryPrepared.updateParameters(query, d));
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(descMapper.upd());
				cadData.executePreparation(QueryPrepared.insertParameters(query, d));
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Error on Persist : SQL Exception : " + e.getMessage());
		}
		return result;
	}
	public Boolean persist(Tile t)
	{
		Boolean result = false;
		PreparedStatement query;
		
		try {
				query = cadTiles.getPreparedStatement(tileMapper.add());
				cadData.executePreparation(QueryPrepared.insertParameters(query, t));
		} catch (SQLException e) {
			System.out.println("Error on Persist : SQL Exception : " + e.getMessage());
		}
		return result;
	}
	

	//delete item from db
	public Boolean delete(Route r)
	{
		PreparedStatement query = cadData.getPreparedStatement(routeMapper.del());
		return this.delete(r, query);
	}
	public Boolean delete(Poi p)
	{
		PreparedStatement query = cadData.getPreparedStatement(poiMapper.del());
		return this.delete(p, query);
	}
	public Boolean delete(DescriptionComplex d)
	{
		PreparedStatement query = cadData.getPreparedStatement(descMapper.del());
		return this.delete(d, query);
	}
	public Boolean delete(Info i)
	{
		PreparedStatement query = cadData.getPreparedStatement(infoMapper.del());
		return this.delete(i, query);
	}
	private Boolean delete(Identifiable o, PreparedStatement query)
	{
		try
		{
			cadData.executePreparation(QueryPrepared.deleteParameters(query, o));
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
					int zoom = 0;
					int col = 0;
					int row = 0;
					
					InputStream imgStream = null;
					BufferedImage img = null;
					
					try{
						zoom = rs.getInt("zoom_level");
						col = rs.getInt("tile_column");
						row = rs.getInt("tile_row");
						img = ImageIO.read(new ByteArrayInputStream(rs.getBytes("tile_data")));
						
					} catch (SQLException e) {
						zoom = Integer.parseInt(result[0]);
						col = Integer.parseInt(result[1]);
						row = Integer.parseInt(result[2]);
						img = ImageIO.read(new File("data/imgs/error.jpg"));
					}
					
					return new Tile(zoom, col, row, img);
				}
				else
				{
					System.out.println("Aucune tuile n'a été trouvé pour ce keyCode...");
					return null;
				}
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
	
	//select one instance from db with id
	public Identifiable select(MapperEnum type, int id)
	{
		PreparedStatement query;
		switch(type)
		{
			case POI:
				query = cadData.getPreparedStatement(poiMapper.sel());
				break;
			case PARCOURS:
				query = cadData.getPreparedStatement(routeMapper.sel());
				
				break;
			case DESCRIPTIONCOMPLEX:
				query = cadData.getPreparedStatement(descMapper.sel());
				
				break;
			case INFO:
				query = cadData.getPreparedStatement(infoMapper.sel());
				break;
			default:
				query = null;
				break;
		}
		if(query == null)
			return null;
		
		ResultSet data = cadData.selectPreparation(QueryPrepared.selectParameters(query, id));
		return IdentifiableFactory.getOneIdentifiable(type, data);
	}
}
