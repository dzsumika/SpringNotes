package com.notes;



import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;

@Controller
public class AddController
{

	Connection conn = null;
	String dbName = "notes";
	String url= "jdbc:mysql://127.0.0.1:3306/" + dbName;
	
	String user = "root";
	String pass = "afghan1234";
	
	@RequestMapping("/deleteNote")
	public ModelAndView deleteNote(@RequestParam("delete_record") String record)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pass);
			
			Statement stmt = conn.createStatement();
			stmt.execute("DELETE FROM notes WHERE note_header = '" + record + "'");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Could not connect to database: " + e);
		}
		
		ModelAndView mav = returnNotes();
		return mav;
	}
	
	public ModelAndView returnNotes()
	{
		DisplayNotes displayNotes = new DisplayNotes();
		HashMap<String, String> notes = displayNotes.display();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("displayNotes.jsp");
		mav.addObject("notes", notes);
		
		return mav;
	}
	
	@RequestMapping("/showNotes")
	public ModelAndView showNotes()
	{
		ModelAndView mav = returnNotes();
		return mav;
	}
	
	@RequestMapping(value="/addNote", method=RequestMethod.POST)
	public ModelAndView addNote(@RequestParam("note_header") String note_header, 
								@RequestParam("note") String note)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pass);
			
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO " + dbName + "(note_header, note) VALUES('" + note_header + "', '" + note + "')");
			
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Could not connect to database: " + e);
		}
		
		ModelAndView mav = returnNotes();
		return mav;
	}
}
