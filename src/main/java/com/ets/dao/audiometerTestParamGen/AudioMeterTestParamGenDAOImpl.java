package com.ets.dao.audiometerTestParamGen;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.AudioMeterTestParamGen;
import com.ets.model.PatientAnalysis;

@Repository
public class AudioMeterTestParamGenDAOImpl implements AudioMeterTestParamGenDAO{
	
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(AudioMeterTestParamGen audioMeterTestParamGen) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(audioMeterTestParamGen);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
	}

	@Override
	public void add(AudioMeterTestParamGen audioMeterTestParamGen) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(audioMeterTestParamGen);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}
	
	
	
	
	@Override
	public AudioMeterTestParamGen view() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Criteria criteria=session.cre
		
		return null;
	}

	
}
