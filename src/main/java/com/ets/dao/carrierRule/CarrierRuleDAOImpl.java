package com.ets.dao.carrierRule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Carrier;
import com.ets.model.CarrierRule;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierRuleDAOImpl Class
 *Description: CarrierRule Entity DAO Class
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
public class CarrierRuleDAOImpl implements CarrierRuleDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(CarrierRule carrierRule) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(carrierRule);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CarrierRule> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CarrierRule.class);

		List<CarrierRule> carrierRuleList = null;
		
		try {
			carrierRuleList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return carrierRuleList;
	}
	

}
