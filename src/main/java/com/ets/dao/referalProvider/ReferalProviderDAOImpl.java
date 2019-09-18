package com.ets.dao.referalProvider;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Provider;
import com.ets.model.ReferalProvider;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReferalProviderDAOImpl Class
 *Description: ReferalProvider Entity DAO Class
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
public class ReferalProviderDAOImpl implements ReferalProviderDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(ReferalProvider referalProvider) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(referalProvider);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ReferalProvider> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ReferalProvider.class);
		List<ReferalProvider> referalProviderList = null;
		try {
			referalProviderList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return referalProviderList;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ReferalProvider referalProvider = (ReferalProvider) session.get(ReferalProvider.class, id);
		try {
			session.delete(referalProvider);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public ReferalProvider viewById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ReferalProvider.class);
		criteria.add(Restrictions.eq("id", id));
		List<ReferalProvider> referalProviderList = null;
		try {

			referalProviderList = criteria.list();
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		tx.commit();
		if (referalProviderList.isEmpty()) {
			return null;
		} else {

			return referalProviderList.get(0);
		}
	}

}
