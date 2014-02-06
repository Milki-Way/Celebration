package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/// CAD is a singleton
public class Cad {
	private Connection connexion;
	private Statement state;
	private String url;
	
	//local constructor
	public Cad(String url)
	{
		this.url = url;
		connect();
	}

	
	//return a Prepared statement
	public PreparedStatement getPreparedStatement(String baseQuery)
	{
		try {
			return (PreparedStatement) connexion.prepareStatement(baseQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//connectivity manager
	private void connect()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connexion = (Connection)DriverManager.getConnection(url);
			state = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC : connection error!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//SQL action request
	public Boolean doSQL(String query)
	{
		try {
			state.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	//prepared
	public Boolean doSQL(String query, String... params)
	{
		try {
			
			PreparedStatement rqPrep = (PreparedStatement) connexion.prepareStatement(query);
			int maxParams = countParam(query);
			if(params.length > maxParams)
				System.out.println("WARNING : You have extra args for this query : \n" + query +"\n");
			for(int i = 0 ; i < maxParams; i++)
			{
				rqPrep.setString(i+1, params[i]);
			}
			rqPrep.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//SQL selection request
	public ResultSet getSQL(String query)
	{
		try {
			return state.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	//prepared
	public ResultSet getSQL(String query, String... params)
	{
		try {
			PreparedStatement rqPrep = (PreparedStatement) connexion.prepareStatement(query);
			int maxParams = countParam(query);
			if(params.length > maxParams)
				System.out.println("WARNING : You have extra args for this query : \n" + query +"\n");
			for(int i = 0 ; i < maxParams; i++)
			{
				rqPrep.setString(i+1, params[i]);
			}
			return (ResultSet) rqPrep.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//Execute a preparedStatement
	public void executePreparation(PreparedStatement q)
	{
		try{
			if(q != null)
				q.executeUpdate();
			else
				System.out.println("Data Warning : Request can not be executed cause request is NULL !");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Select using a preparedStatement
	public ResultSet selectPreparation(PreparedStatement q)
	{
		if(q == null)
			return null;
		try{
			return (ResultSet)q.executeQuery();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	//Disconnection
	public void disconnect(){
		try {
			state.close();
			connexion.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** Queries validation **/
	private int countParam(String query)
	{
		int index = 0;
		int count = 0;
		
		while(index > -1)
		{
			index = query.indexOf("?", index+1);
			if(index > -1)
				count++;
		}
		return count;
	}
}