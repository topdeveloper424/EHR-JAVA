package com.ets.controller.entity.contact;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ContactEntityController Class
 *Description: Contact Entity Non-GUI Controller class
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
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Clinician;
import com.ets.model.Company;
import com.ets.model.Contact;
import com.ets.service.contact.ContactServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactEntityController {

	//private static ClassPathXmlApplicationContext context;
	private ContactServiceImpl contactServiceImpl;
	private ObservableList<Contact> observableList;

	public ContactEntityController() {

	//	context = new ClassPathXmlApplicationContext("spring.xml");
		contactServiceImpl = (ContactServiceImpl) Global.context.getBean("contactService");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(Contact contact) {
		contactServiceImpl.saveOrUpdate(contact);
		//context.close();
	}

	
public ObservableList<Contact> view(){
		
		observableList = FXCollections.observableArrayList(contactServiceImpl.view());
		//context.close();
		return observableList;
	}

public Contact viewById(Integer id){
	
	observableList = FXCollections.observableArrayList(contactServiceImpl.viewById(id));
	//context.close();
	return observableList.get(0);
	
}



public ObservableList<Contact> viewByCompId(Integer  compId){
	
	observableList = FXCollections.observableArrayList(contactServiceImpl.viewByCompId(compId));
	//context.close();
	return observableList;
	
}
public void delete(Integer id){
	
	contactServiceImpl.delete(id);
	//context.close();
	
}
public Contact viewByCompanyMainContact(String mainContact){
	
	observableList = FXCollections.observableArrayList(contactServiceImpl.viewByCompanyMainContact(mainContact));
	//context.close();
	return observableList.get(0);
	
}
	
}
