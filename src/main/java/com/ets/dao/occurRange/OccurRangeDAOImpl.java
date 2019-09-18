package com.ets.dao.occurRange;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.OccurRange;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of OccurRangeDAOImpl Class
 *Description: OccurRange Entity DAO Class
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
public class OccurRangeDAOImpl implements OccurRangeDAO{

	private SessionFactory sessionFactory;
	
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void saveOrUpdate(OccurRange occurRange) {
		
	  Session session=sessionFactory.getCurrentSession();
	  Transaction tx=session.beginTransaction();
	  
	 try
	 {
	  session.saveOrUpdate(occurRange);
	 
		
	}catch(Exception e)
	 {
		e.printStackTrace();
	 }
	 tx.commit();
	
	
	
}}
