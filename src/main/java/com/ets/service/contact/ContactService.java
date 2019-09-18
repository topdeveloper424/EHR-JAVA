package com.ets.service.contact;

import java.util.List;

import com.ets.model.Company;
import com.ets.model.Contact;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ContactService Interface
 *Description: Contacts Entity Service Interface
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
public interface ContactService {

	
	public void saveOrUpdate(Contact contact);
	
	   public List<Contact> view();
	   
	   public Contact viewById(Integer id);
	   
	   public void delete(Integer id);
	   public List<Contact> viewByCompId(Integer compId);
	   public Contact viewByCompanyMainContact(String mainContact);

	
    	
	
	
}
