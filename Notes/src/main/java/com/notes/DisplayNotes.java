package com.notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayNotes {

	
	Connection conn = null;
	String dbName = "notes";
	String url= "jdbc:mysql://127.0.0.1:3306/" + dbName;
	
	String user = "root";
	String pass = "afghan1234";
	
	public HashMap<String, String> display()
	{
		HashMap<String, String> notes = new HashMap<String, String>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pass);
			
			Statement stmt = conn.createStatement();
			stmt.execute("SELECT note_header, note FROM notes");
			
			ResultSet results = stmt.getResultSet();
			
			while(results.next())
			{
				notes.put(results.getString("note_header"), results.getString("note"));
			}
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Could not connect to database: " + e);
		}
		
		return notes;
	}
}
