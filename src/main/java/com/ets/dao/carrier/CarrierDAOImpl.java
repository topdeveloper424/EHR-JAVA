package com.ets.dao.carrier;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Carrier;
import com.ets.model.Region;



/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierDAOImpl Class
 *Description: Carrier Entity DAO Class
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
public class CarrierDAOImpl implements CarrierDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Carrier carrier) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(carrier);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Carrier> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Carrier.class);

		List<Carrier> carrierList = null;
		try {
			carrierList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return carrierList;
	}

	@Override
	public Carrier viewByCode(String code) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Carrier.class);
		criteria.add(Restrictions.eq("code", code));
		List<Carrier> carrierList = null;

		try {

			carrierList = criteria.list();
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}

		if (carrierList.isEmpty()) {

			return null;

		} else {

			return carrierList.get(0);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Carrier carrier = (Carrier) session.get(Carrier.class, id);
		try {
			session.delete(carrier);

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		tx.commit();

	}

}
