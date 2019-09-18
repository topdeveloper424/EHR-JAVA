package com.ets.controller.entity.note;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Note;
import com.ets.service.note.NoteService;
import com.ets.service.note.NoteServiceImpl;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NoteEntityController Class
 *Description: Note Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */
public class NoteEntityController {
	
	//private ClassPathXmlApplicationContext context;
	private NoteServiceImpl noteServiceImpl;
	
	public NoteEntityController()
	{
		//context = new ClassPathXmlApplicationContext("spring.xml");
		noteServiceImpl =  (NoteServiceImpl) Global.context.getBean("noteService"); 
	}
	
	
	
	public void saveOrUpdate(Note note){
		
		noteServiceImpl.addOrUpdate(note);
		//closeApplicationContext();
	
	}

}
