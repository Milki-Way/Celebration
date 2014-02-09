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
import javax.management.Query;

import tileengine.Tile;
import data.mapper.MapperEnum;
import data.mapper.MpgDescriptionComplex;
import data.mapper.MpgImageDesc;
import data.mapper.MpgInfos;
import data.mapper.MpgInterParcPoi;
import data.mapper.MpgLiensDesc;
import data.mapper.MpgMap;
import data.mapper.MpgPoi;
import data.mapper.MpgReference;
import data.mapper.MpgRoute;
import data.mapper.MpgTile;
import entity.DescriptionComplex;
import entity.IEntity;
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
	private MpgInterParcPoi interParcPoiMapper;
	private MpgReference refMapper;
	
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
		interParcPoiMapper = new MpgInterParcPoi();
		refMapper = new MpgReference();
		cadData = new Cad("jdbc:sqlite:data/db/minisigdb.sqlite");
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
				if(i.getDescplx() != null)
					this.persist(i.getDescplx());
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(infoMapper.add());
				cadData.executePreparation(QueryPrepared.insertParameters(query, i));
				if(i.getDescplx() != null)
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
				if(p.getDescription() != null)
					this.persist(p.getDescription());
				result = true;
			}
			else
			{
				query = cadData.getPreparedStatement(poiMapper.add());
				cadData.executePreparation(QueryPrepared.insertParameters(query, p));
				if(p.getDescription() != null)
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
		if( d != null)
		{
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
		if(r != null)
		{
			PreparedStatement query = cadData.getPreparedStatement(routeMapper.del());
			this.delete(r.getDescmplx());
			return this.delete(r, query);
		}
		else
			return false;
	}
	public Boolean delete(Poi p)
	{
		if(p != null)
		{
			PreparedStatement query = cadData.getPreparedStatement(poiMapper.del());
			this.delete(p.getDescription());
			return this.delete(p, query);
		}
		else
			return false;
	}
	public Boolean delete(DescriptionComplex d)
	{
		if(d != null)
		{
			PreparedStatement query = cadData.getPreparedStatement(descMapper.del());
			return this.delete(d, query);
		}
		else
			return false;
	}
	public Boolean delete(Info i)
	{
		if(i != null)
		{
			PreparedStatement query = cadData.getPreparedStatement(infoMapper.del());
			this.delete(i.getDescplx());
			return this.delete(i, query);
		}
		else
			return false;
	}
	private Boolean delete(IEntity o, PreparedStatement query)
	{
		try
		{
			cadData.executePreparation(QueryPrepared.deleteParameters(query, o));
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("NEARLY FATAL ERROR !!! : ");
			ex.printStackTrace();
			return false;
		}
	}
		
	//get all instance from db
	public ArrayList<IEntity> Load(MapperEnum table)
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
			return EntityFactory.createIdentifiable(table, rs);
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
					double col = 0;
					double row = 0;
					
					InputStream imgStream = null;
					BufferedImage img = null;
					
					try{
						zoom = rs.getInt("zoom_level");
						col = rs.getInt("tile_column");
						row = rs.getInt("tile_row");
						img = ImageIO.read(new ByteArrayInputStream(rs.getBytes("tile_data")));
						
					} catch (SQLException e) {
						zoom = Integer.parseInt(result[0]);
						col = Double.parseDouble(result[1]);
						row = Double.parseDouble(result[2]);
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
	public IEntity select(MapperEnum type, int id)
	{
		PreparedStatement query = null;
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
		return EntityFactory.getOneIdentifiable(type, data);
	}
	public ArrayList<IEntity> loadPoiOfRoute(int idRoute)
	{
		PreparedStatement query = cadData.getPreparedStatement(interParcPoiMapper.sel());
		ResultSet data = cadData.selectPreparation(QueryPrepared.selectParameters(query, idRoute));
		return EntityFactory.createIdentifiable(MapperEnum.POI, data);
	}
	public ArrayList<BufferedImage> loadInfoImg(int idInfo)
	{
		ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
		PreparedStatement query = cadData.getPreparedStatement(imageDescriptionMapper.sel());
		ResultSet data = cadData.selectPreparation(QueryPrepared.selectParameters(query, idInfo));
		try {
			if(data != null)
			{
				while(data.next())
					imgList.add(ImageIO.read(new ByteArrayInputStream(data.getBytes("contenudescription"))));
			}
		} catch (IOException e) {
			System.out.println("Erreur de lecture : DataEngine //" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erreur SQL : DataEngine LoadInfoImg" + e.getMessage());
			e.printStackTrace();
		}
		
		return imgList;
	}
	public ArrayList<IEntity> loadReference(int idDescription)
	{
		ArrayList<IEntity> refList = new ArrayList<IEntity>();
		PreparedStatement query = cadData.getPreparedStatement(refMapper.sel());
		ResultSet data = cadData.selectPreparation(QueryPrepared.selectParameters(query, idDescription));
		try {
			if(data != null)
			{
				while(data.next())
				{
					int id = data.getInt("idrefpoi");
					if(id > 0)
						refList.add(DataEngine.getInstance().select(MapperEnum.POI, id));
					id = data.getInt("idrefmap");
					if(id > 0)
						refList.add(DataEngine.getInstance().select(MapperEnum.MAP, id));
					id = data.getInt("idrefparcours");
					if(id > 0)
						refList.add(DataEngine.getInstance().select(MapperEnum.PARCOURS, id));
				}
			}
		} catch (SQLException e) {
			System.out.println("Erreur SQL : DataEngine LoadInfoImg" + e.getMessage());
			e.printStackTrace();
		}
		
		return refList;
	}
	public ArrayList<String> loadInfoLinks(int idInfo)
	{
		ArrayList<String> links = new ArrayList<String>();
		PreparedStatement query = cadData.getPreparedStatement(lienDescriptionMapper.sel());
		ResultSet data = cadData.selectPreparation(QueryPrepared.selectParameters(query, idInfo));
		
		try
		{
			if(data != null)
			{
				while(data.next())
					links.add(data.getString("libellelien"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException in DataEngine loadInfoLinks :" +e.getMessage());
		}
		
		return links;
	}
	
	public ArrayList<Poi> searchPoi(String text)
	{
		ArrayList<Poi> result = new ArrayList<Poi>();
		ArrayList<IEntity> enlist;
		PreparedStatement query = cadData.getPreparedStatement(poiMapper.search());
		ResultSet data = cadData.selectPreparation(QueryPrepared.searchParameters(query, text));
		enlist = EntityFactory.createIdentifiable(MapperEnum.POI, data);
		for(IEntity e :enlist)
			result.add((Poi)e);
		data = cadData.getSQL(poiMapper.getAll());
		enlist = EntityFactory.createIdentifiable(MapperEnum.POI, data);
		query = cadData.getPreparedStatement(descMapper.searchPoi(enlist));
		data = cadData.selectPreparation(QueryPrepared.searchDescCParameters(query, text));
		ArrayList<Integer> idDescription = new ArrayList<Integer>();
		try {
			while(data.next())
			{
				idDescription.add(data.getInt("iddescription"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		data = cadData.getSQL(poiMapper.getPoiByDescription(idDescription));
		enlist = EntityFactory.createIdentifiable(MapperEnum.POI, data);
		for(IEntity e :enlist)
			result.add((Poi)e);
		return result;
	}
	public ArrayList<Route> searchRoute(String text)
	{
		ArrayList<Route> result = new ArrayList<Route>();
		ArrayList<IEntity> enlist;
		PreparedStatement query = cadData.getPreparedStatement(routeMapper.search());
		ResultSet data = cadData.selectPreparation(QueryPrepared.searchParameters(query, text));
		enlist = EntityFactory.createIdentifiable(MapperEnum.PARCOURS, data);
		for(IEntity e :enlist)
			result.add((Route)e);
		data = cadData.getSQL(routeMapper.getAll());
		enlist = EntityFactory.createIdentifiable(MapperEnum.PARCOURS, data);
		query = cadData.getPreparedStatement(descMapper.searchRoute(enlist));
		data = cadData.selectPreparation(QueryPrepared.searchDescCParameters(query, text));
		ArrayList<Integer> idDescription = new ArrayList<Integer>();
		try {
			while(data.next())
			{
				idDescription.add(data.getInt("iddescription"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		data = cadData.getSQL(routeMapper.getRouteByDescription(idDescription));
		enlist = EntityFactory.createIdentifiable(MapperEnum.PARCOURS, data);
		for(IEntity e :enlist)
			result.add((Route)e);
		return result;
	}
	
	
}
