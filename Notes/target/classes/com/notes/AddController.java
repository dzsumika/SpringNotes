package com.notes;

import org.springframework.stereotype.Controller;

@Controller
public class AddController
{

	@RequestMapping("/addNote")
	public void addNote()
	{
		System.out.println("Note Added!");
	}
}
