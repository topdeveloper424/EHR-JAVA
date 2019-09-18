package com.ets.dao.clinicianSchRecurException;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicianSchRecurException;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchRecurExceptionDAOImpl Class
 *Description: ClinicianSchRecurException Entity DAO Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

@Repository
public class ClinicianSchRecurExceptionDAOImpl  implements ClinicianSchRecurExceptionDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		@Override
	public void saveOrUpdate(ClinicianSchRecurException clinicianSchRecurException) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			try {
				session.saveOrUpdate(clinicianSchRecurException);

			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
	
	}
		@Override
		public void delete(Integer id) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			ClinicianSchRecurException clinicianSchRecurException = new ClinicianSchRecurException();

			try {
				clinicianSchRecurException = (ClinicianSchRecurException) session.get(ClinicianSchRecurException.class, id);
				session.delete(clinicianSchRecurException);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			
		}
		@Override
		public List<ClinicianSchRecurException> view() {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ClinicianSchRecurException.class);
			List<ClinicianSchRecurException> stList = null;
			try {
				stList = criteria.list();
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}return stList;
		}
		@Override
		public List<ClinicianSchRecurException> viewClinicianSchRecurExceptionById(Integer Id) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(ClinicianSchRecurException.class);

			try {

				criteria.add(Restrictions.eq("id", Id));
				tx.commit();

			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return criteria.list();
		}


}
