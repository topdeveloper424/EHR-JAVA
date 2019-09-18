package com.ets.service.contact;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.contact.ContactDAO;
import com.ets.model.Company;
import com.ets.model.Contact;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ContactServiceImpl Class
 *Description: Contact Entity Service Class
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
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	private ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	public void saveOrUpdate(Contact contact) {

		contactDAO.saveOrUpdate(contact);

	}

	@Override
	public List<Contact> view() {
		
		return contactDAO.view();
	}

	@Override
	public Contact viewById(Integer id) {
		
		return contactDAO.viewById(id);
	}

	@Override
	public void delete(Integer id) {
		
		contactDAO.delete(id);
		
	}

	@Override
	public List<Contact> viewByCompId(Integer compId) {
		// TODO Auto-generated method stub
		return contactDAO.viewByCompId(compId);
	}

	@Override
	public Contact viewByCompanyMainContact(String mainContact) {
		// TODO Auto-generated method stub
		return contactDAO.viewByCompanyMainContact(mainContact);
	}

}
