package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				case "data.Info":
					Info i = (Info)o;
					query.setString(1, i.getLibelle());					
					break;
					
				case "data.DescriptionComplex":
					DescriptionComplex d = (DescriptionComplex)o;
					query.setString(1, d.getDescription());					
					break;
					
				case "data.Poi":
					Poi p = (Poi)o;
					query.setString(1, p.getLibelle());
					query.setInt(2, p.getX());
					query.setInt(3, p.getY());					
					break;
					
				case "data.Route":
					Route r = (Route)o;
					query.setString(1, r.getLibelle());										
					break;
					
				case "data.Tile":
					Tile t = (Tile)o;
					query.setInt(1, t.getZoom());
					query.setInt(2, t.getCoord().getColumn());
					query.setInt(3, t.getCoord().getRow());
					
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
				case "data.Info":
					Info i = (Info)o;
					query.setString(1, i.getLibelle());	
					query.setInt(2, i.getId());
					break;
					
				case "data.DescriptionComplex":
					DescriptionComplex d = (DescriptionComplex)o;
					query.setString(1, d.getDescription());		
					query.setInt(2, d.getId());
					break;
					
				case "data.Poi":
					Poi p = (Poi)o;
					query.setString(1, p.getLibelle());
					query.setInt(2, p.getX());
					query.setInt(3, p.getY());
					query.setInt(4, p.getId());
					break;
					
				case "data.Route":
					Route r = (Route)o;
					query.setString(1, r.getLibelle());		
					query.setInt(2, r.getId());
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
