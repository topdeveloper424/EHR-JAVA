package com.ets.dao.providerSchRecurException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchRecurExceptionDAOImpl Class
 *Description: ProviderSchRecurException Entity DAO class
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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.ProviderSchRecurException;

@Repository
public class StaffSchRecurExceptionDAOImpl implements StaffSchRecurExceptionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(ProviderSchRecurException staffSchRecurException) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(staffSchRecurException);

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ProviderSchRecurException staffSchRecurException = new ProviderSchRecurException();

		try {
			staffSchRecurException = (ProviderSchRecurException) session.get(ProviderSchRecurException.class, id);
			session.delete(staffSchRecurException);
            System.out.println("********************* deleted ******************************");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}	tx.commit();

	}

	@Override
	public List<ProviderSchRecurException> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProviderSchRecurException.class);
		List<ProviderSchRecurException> stList = null;
		try {
			stList = criteria.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}tx.commit();

		return stList;
	}

	@Override
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionById(Integer Id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(ProviderSchRecurException.class);
		List<ProviderSchRecurException> providerSchRecurExceptionList = null;

		try {

			criteria.add(Restrictions.eq("id", Id));
			providerSchRecurExceptionList = criteria.list();
			

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		return providerSchRecurExceptionList;
	}

	@Override
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByProviderId(Integer Id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(ProviderSchRecurException.class);
		List<ProviderSchRecurException> providerSchRecurExceptionList = null;

		try {

			criteria.add(Restrictions.eq("provider.id", Id));
			providerSchRecurExceptionList = criteria.list();
			

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		return providerSchRecurExceptionList;
		
	}

	@Override                             
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByClinicianId(Integer Id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(ProviderSchRecurException.class);
		List<ProviderSchRecurException> providerSchRecurExceptionList = null;
        
		try {

			criteria.add(Restrictions.eq("clinician.id", Id));
			providerSchRecurExceptionList = criteria.list();
			System.out.println("from dao "+providerSchRecurExceptionList.size());

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		return providerSchRecurExceptionList;
		
	}


}
