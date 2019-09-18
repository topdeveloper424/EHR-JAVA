package com.ets.dao.patientStatistic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientStatistic;

@Repository
public class PatientStatisticDAOImpl implements PatientStatisticDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PatientStatistic patientStatistic) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patientStatistic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

}
