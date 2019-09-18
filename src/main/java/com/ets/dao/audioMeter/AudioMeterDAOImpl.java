package com.ets.dao.audioMeter;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Audiometer;

@Repository
public class AudioMeterDAOImpl implements AudioMeterDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Audiometer audiometer) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(audiometer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public List<Audiometer> viewAudioMeter() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Audiometer.class);
		List<Audiometer> audiometersList = null;
		try { 
			audiometersList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();
		return audiometersList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Audiometer audiometer = (Audiometer) session.get(Audiometer.class, id);
		try {
			session.delete(audiometer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

}
