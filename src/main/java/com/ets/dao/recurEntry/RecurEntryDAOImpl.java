package com.ets.dao.recurEntry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.RecurEntry;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RecurEntryDAOImpl Interface
 *Description: RecurEntry Entity DAO Interface
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
public class RecurEntryDAOImpl implements RecurEntryDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(RecurEntry recurEntry) {
		

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(recurEntry);

		} catch (Exception e) {
			e.printStackTrace();

		}
		tx.commit();
	}

}
