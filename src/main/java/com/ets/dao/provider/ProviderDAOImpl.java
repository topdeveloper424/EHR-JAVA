package com.ets.dao.provider;

import java.util.ArrayList;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderDAOImpl Class
 *Description: Provider Entity DAO class
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

import com.ets.model.Division;
import com.ets.model.Provider;

@Repository
public class ProviderDAOImpl implements ProviderDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(Provider provider) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(provider);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public List<Provider> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		List<Provider> providerList = null;
		try {
			providerList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
		return providerList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Provider provide = (Provider) session.get(Provider.class, id);

		try {
			session.delete(provide);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public Provider viewById(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		
		criteria.add(Restrictions.eq("id", id));
		List<Provider> providerList = null;
		try {

			providerList = criteria.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		tx.commit();
		if (providerList.isEmpty()) {
			return null;
		} else {

			return providerList.get(0);
		}

	}

	@Override
	public List<Provider> viewByClinicId(Integer clinicId) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("clinic.id", clinicId));
		List<Provider> providerList = new ArrayList<Provider>();
		try {

			providerList = criteria.list();

		} catch (Exception e) {

			e.printStackTrace();
		}
		tx.commit();
		
			return providerList;
		
	}

	@Override
	public Provider viewByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("code", code));
		List<Provider> providerList = null;

		try{
			providerList=criteria.list();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}tx.commit();
		
		if(providerList.isEmpty()){
			return null;
		}else{
			return providerList.get(0);
		}
		
		
	}

}
