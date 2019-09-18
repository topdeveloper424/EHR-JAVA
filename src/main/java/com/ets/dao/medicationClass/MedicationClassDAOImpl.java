package com.ets.dao.medicationClass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import com.ets.model.MedicationClass;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicationClassDAOImpl Class
 *Description: MedicationClass Entity DAO class
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

@Repository
public class MedicationClassDAOImpl implements MedicationClassDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicationClass
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(MedicationClass medicationClass) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(medicationClass);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	/** This method gets all the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicationClass objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MedicationClass> list() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(MedicationClass.class);

		List<MedicationClass> medicationClassList = null;
		try {
			medicationClassList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return medicationClassList;
	}


	/** This method update the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicationClass
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void update(MedicationClass medicationClass) {
	
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(medicationClass);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicationClass objects
	 */
	
	@Override
	public MedicationClass getByID(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		MedicationClass medicationClass = null;
		try {
			medicationClass = (MedicationClass) session.get(MedicationClass.class, id);
			//trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return medicationClass;
	}

	/** This method delete the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void delete(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			MedicationClass medicationClass = (MedicationClass) session.get(MedicationClass.class, id);
			session.delete(medicationClass);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public MedicationClass getByName(String name) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		List<MedicationClass> medicationClass = null;
		try {
			Criteria criteria = session.createCriteria(MedicationClass.class);
				 criteria.add(Restrictions.eq("medicalClass",name));
				 medicationClass = criteria.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return medicationClass.get(0);
	}


}
