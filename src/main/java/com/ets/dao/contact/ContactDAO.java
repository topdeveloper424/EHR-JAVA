package com.ets.dao.contact;

import java.util.List;

import com.ets.model.Company;
import com.ets.model.Contact;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ContactDAO Interface
 *Description: Contact Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface ContactDAO {

   public void saveOrUpdate(Contact contact);
   public List<Contact> view();
   
   public Contact viewById(Integer id);
   
   
   public List<Contact> viewByCompId(Integer compId);
   
   public void delete(Integer id);
   
   public Contact viewByCompanyMainContact(String mainContact);

	
}
