package com.ets.dao.address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Address;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-12-16
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AddressDAOImpl Class
 *Description: Address Entity DAO class
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

@Repository
public class AddressDAOImpl implements AddressDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Address address) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.saveOrUpdate(address);
			//tx.commit();
		}catch(Exception e){
			
			e.printStackTrace();
			
		}tx.commit();
		
	}

	@Override
	public void update(Address address) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.saveOrUpdate(address);
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}tx.commit();
		
	}
	
	

}
