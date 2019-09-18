package com.ets.dao.patientName;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientNameDAOImpl Class
 *Description: PatientName Entity DAO class
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
import org.springframework.stereotype.Repository;

import com.ets.model.PatientName;

@Repository
public class PatientNameDAOImpl implements PatientNameDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PatientName patientName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patientName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

}
