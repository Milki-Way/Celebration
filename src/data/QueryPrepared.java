package data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import tileengine.Tile;
import entity.DescriptionComplex;
import entity.IEntity;
import entity.Info;
import entity.Poi;
import entity.Route;

public class QueryPrepared {
	private static final int UNIQUEMAPID = 1;
	
	/** INSERT PREPARATION **/
	public static PreparedStatement insertParameters(PreparedStatement query, DescriptionComplex d) throws SQLException
	{
		if(query == null)
			System.out.println(d.getDescription());
		query.setString(1, d.getDescription());		
		return query;
	}
	public static PreparedStatement insertParameters(PreparedStatement query, Poi p) throws SQLException
	{
		query.setString(1, p.getLibelle());
		query.setInt(2, p.getCoords().getRow());
		query.setInt(3, p.getCoords().getColumn());
		query.setInt(4, UNIQUEMAPID);
		query.setInt(5, UNIQUEMAPID);
		if(p.getDescription() != null)
			query.setInt(6, p.getDescription().getId());
		else
			query.setInt(6, 1);
		return query;
	}
	public static PreparedStatement insertParameters(PreparedStatement query, Info i) throws SQLException
	{
		query.setString(1, i.getLibelle());
		return query;
	}
	public static PreparedStatement insertParameters(PreparedStatement query, Route r) throws SQLException
	{
		query.setString(1, r.getLibelle());		
		return query;
	}
	public static PreparedStatement insertParameters(PreparedStatement query, Tile t) throws SQLException
	{
		query.setInt(1,t.getZoom());
		query.setInt(2,t.getCoords().getColumn());
		query.setInt(3,t.getCoords().getRow());

		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		try {
			ImageIO.write(t.getTileContent(), "bitmap", bs);
			query.setBytes(4, bs.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	
	/** UPDATE PREPARATION **/
	public static PreparedStatement updateParameters(PreparedStatement query, Info i) throws SQLException
	{
		query.setString(1, i.getLibelle());	
		query.setInt(2, i.getId());
		return query;
	}
	public static PreparedStatement updateParameters(PreparedStatement query, DescriptionComplex d) throws SQLException
	{
		query.setString(1, d.getDescription());		
		query.setInt(2, d.getId());
		return query;
	}
	public static PreparedStatement updateParameters(PreparedStatement query, Poi p) throws SQLException
	{
		query.setString(1, p.getLibelle());
		query.setInt(2, p.getCoords().getRow());
		query.setInt(3, p.getCoords().getColumn());
		query.setInt(4, p.getId());
		return query;
	}
	public static PreparedStatement updateParameters(PreparedStatement query, Route r) throws SQLException
	{
		query.setString(1, r.getLibelle());		
		query.setInt(2, r.getId());
		return query;
	}
	
	//DELETE PREPARATION
	public static PreparedStatement deleteParameters(PreparedStatement query, IEntity o)
	{
		try
		{
			query.setInt(1, o.getId());
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	//SELECT PREPARATION
	public static PreparedStatement selectParameters(PreparedStatement query, int itemId)
	{
		try
		{
			if(query == null)
				return null;
			query.setInt(1, itemId);
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static PreparedStatement searchParameters(PreparedStatement query, String text)
	{
		try
		{
			if(query == null)
				return null;
			query.setString(1, text);
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static PreparedStatement searchDescCParameters(PreparedStatement query, String text)
	{
		try
		{
			if(query == null)
				return null;
			query.setString(1, text);
			query.setString(2, text);
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}
