package com.ets.dao.medication;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.AllergyCategory;
import com.ets.model.Medication;
import com.ets.model.MedicationClass;

@Repository
public class MedicationDaoImpl implements MedicationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Medication medication) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(medication);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
		
	

	@Override
	public List<Medication> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Medication.class);

		List<Medication> medicationList = null;
		try {
			medicationList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return medicationList;
	}

	@Override
	public Medication searchByDescrip(String descrip) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Medication.class);
		List<Medication> medications = null;
		try {
			
	        criteria.add(Restrictions.ilike("medicationName", descrip+"%"));
	        medications = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return medications.get(0);
	}

	
	
	
	
}
