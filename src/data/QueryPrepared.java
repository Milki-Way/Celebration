package data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import tileengine.Tile;
import entity.DescriptionComplex;
import entity.Identifiable;
import entity.Info;
import entity.Poi;
import entity.Route;

public class QueryPrepared {
	public static PreparedStatement insertParameters(PreparedStatement query, Object o)
	{
		try
		{
			switch(o.getClass().getName())
			{				
				case "entity.Info":
					Info i = (Info)o;
					query.setString(1, i.getLibelle());					
					break;
					
				case "entity.DescriptionComplex":
					DescriptionComplex d = (DescriptionComplex)o;
					query.setString(1, d.getDescription());					
					break;
					
				case "entity.Poi":
					Poi p = (Poi)o;
					query.setString(1, p.getLibelle());
					query.setInt(2, p.getCoords().getRow());
					query.setInt(3, p.getCoords().getColumn());					
					break;
					
				case "entity.Route":
					Route r = (Route)o;
					query.setString(1, r.getLibelle());										
					break;
					
				case "entity.Tile":
					Tile t = (Tile)o;
					query.setInt(1, t.getZoom());
					query.setInt(2, t.getCoords().getColumn());
					query.setInt(3, t.getCoords().getRow());
					
					break;
			}
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public static PreparedStatement updateParameters(PreparedStatement query, Object o)
	{
		try
		{
			switch(o.getClass().getName())
			{				
				case "entity.Info":
					Info i = (Info)o;
					query.setString(1, i.getLibelle());	
					query.setInt(2, i.getId());
					break;
					
				case "entity.DescriptionComplex":
					DescriptionComplex d = (DescriptionComplex)o;
					query.setString(1, d.getDescription());		
					query.setInt(2, d.getId());
					break;
					
				case "entity.Poi":
					Poi p = (Poi)o;
					query.setString(1, p.getLibelle());
					query.setInt(2, p.getCoords().getRow());
					query.setInt(3, p.getCoords().getColumn());
					query.setInt(4, p.getId());
					break;
					
				case "entity.Route":
					Route r = (Route)o;
					query.setString(1, r.getLibelle());		
					query.setInt(2, r.getId());
					break;
					
				case "tileengine.Tile":
					Tile t = (Tile)o;
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
					
					
					break;
			}
			return query;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static PreparedStatement deleteParameters(PreparedStatement query, Identifiable o)
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
	
	public static PreparedStatement selectParameters(PreparedStatement query, Identifiable o)
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
}
