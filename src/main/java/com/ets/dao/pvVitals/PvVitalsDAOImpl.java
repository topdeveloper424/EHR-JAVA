package com.ets.dao.pvVitals;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ets.model.PvVitals;

public class PvVitalsDAOImpl implements PvVitalsDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PvVitals pvVitals) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();

		try {
			session.saveOrUpdate(pvVitals);
			tx.commit();
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } 
		
		
	}

}
