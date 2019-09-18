package com.ets.dao.vitalReader;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.VitalReader;

@Repository
public class VitalReaderDAOImpl implements VitalReaderDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(VitalReader vitalReader) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(vitalReader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public List<VitalReader> viewVitalReader() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(VitalReader.class);
		List<VitalReader> vitalReaderList = null;
		try {
			vitalReaderList = criteria.list();
		

		} catch (Exception e) {

			e.printStackTrace();
		}tx.commit();
		
		return vitalReaderList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		VitalReader vitalReader = (VitalReader) session.get(VitalReader.class, id);
		try {
			session.delete(vitalReader);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public void updateVitalReader(VitalReader vitalReader) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(vitalReader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}
}