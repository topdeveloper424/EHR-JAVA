package com.ets.dao.tpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Region;
import com.ets.model.Tpa;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of TpaDAOImpl Class
 *Description: Tpa Entity DAO Class
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
public class TpaDAOImpl implements TpaDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(Tpa tpa) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(tpa);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Tpa> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Tpa.class);
		List<Tpa> tpaList = null;
		try {
			tpaList = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return tpaList;
	}

	@Override
	public Tpa viewByCode(String code) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Tpa.class);
		criteria.add(Restrictions.eq("code", code));
		List<Tpa> tpaList = null;

		try {

			tpaList = criteria.list();
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (tpaList.isEmpty()) {

			return null;

		} else {

			return tpaList.get(0);
		}
	}

	@Override
	public void delete(Integer id) {
		

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Tpa tpa = new Tpa();
		tpa = (Tpa) session.get(Tpa.class, id);
		try {
			session.delete(tpa);
		} catch (Exception e) {
			e.printStackTrace();
		}tx.commit();

	}

}
