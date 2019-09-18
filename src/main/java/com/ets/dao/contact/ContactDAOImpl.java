package com.ets.dao.contact;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Company;
import com.ets.model.Contact;
import com.ets.model.SICCode;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ContactDAOImpl Interface
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


@Repository
public class ContactDAOImpl implements ContactDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override

	public void saveOrUpdate(Contact contact) {
		

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	
		try {
			session.saveOrUpdate(contact);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		
	    tx.commit();
	   
	}

	@Override
	public List<Contact> view() {
		Session session=sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        List<Contact> contactlist=null;
        try{
        	
        Criteria criteria=session.createCriteria(Contact.class);
          contactlist=criteria.list();
        
        }
        
        catch(Exception e)
        {
          e.printStackTrace();	
        }
         tx.commit();
        	return contactlist;
        }

	@Override
	public Contact viewById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.eq("id", id));
		List<Contact> contactList = null;
		try{
			contactList=criteria.list();
			//tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}tx.commit();

		return contactList.get(0);
		
	}

	@Override
	public void delete(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Contact contact = (Contact) session.get(Contact.class, id);
		
		try{
			session.delete(contact);
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}tx.commit();
		
	}

	@Override
	public List<Contact> viewByCompId(Integer compId) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.eq("company.id", compId));
		
		List<Contact> contactList = null;
		try{
			contactList=criteria.list();
			//tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}tx.commit();

		return contactList;
		
	}

	@Override
	public Contact viewByCompanyMainContact(String mainContact) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.and(Restrictions.eq("fullName", mainContact),
				Restrictions.eq("company", Global.patient.getCompany())));
		
		
		List<Contact> contactList = new ArrayList<Contact>();
		try{
			contactList=criteria.list();
			//tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}tx.commit();
        if(contactList.size()>0){
        	return contactList.get(0);
        }else{
        	return null;
        }
		
	}
	}


