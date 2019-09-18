package com.ets.dao.visitRecord;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.VisitRecord;

@Repository
public class VisitRecordDAOImpl implements VisitRecordDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(VisitRecord visitRecord) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(visitRecord);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
