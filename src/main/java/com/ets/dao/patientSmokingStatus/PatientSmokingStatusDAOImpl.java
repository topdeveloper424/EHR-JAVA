package com.ets.dao.patientSmokingStatus;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientSmokingStatusDAOImpl Class
 *Description: PatientSmokingStatus Entity DAO class
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ets.model.PatientSmokingStatus;

public class PatientSmokingStatusDAOImpl implements PatientSmokingStatusDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PatientSmokingStatus patientSmokingStatus) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{			
			session.saveOrUpdate(patientSmokingStatus);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
	}
	

}
