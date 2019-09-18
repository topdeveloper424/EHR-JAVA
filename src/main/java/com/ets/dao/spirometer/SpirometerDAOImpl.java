package com.ets.dao.spirometer;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.DepartmentUnit;
import com.ets.model.RootCause;
import com.ets.model.SICCode;
import com.ets.model.Spirometer;

/**
 * Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company File
 * Creation Date: 22-11-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of SpirometerDAOImpl Class Description: SpirometerDAO
 * Interface Class Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */
@Repository
public class SpirometerDAOImpl implements SpirometerDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveSpirometer(Spirometer spirometer) {

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(spirometer);
			transaction.commit();
		} catch (HibernateException e) {
			// tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<Spirometer> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Spirometer.class);
		List<Spirometer> SpirometerList = null;
		try {
			SpirometerList = criteria.list();
			   //tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return SpirometerList;
	}

	
	/*@Override
	public void update(Spirometer spirometer) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(spirometer);
		transaction.commit();

	}*/

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Spirometer spirometer = (Spirometer) session.get(Spirometer.class, id);
		session.delete(spirometer);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			 }	
}
