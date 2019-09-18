package com.ets.dao.workLocation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.WorkLocation;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkLocationDAOImpl Class
 *Description: WorkLocation Entity DAO class
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
public class WorkLocationDAOImpl implements WorkLocationDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(WorkLocation workLocation) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(workLocation);
			
		} catch (Exception e) {
			e.printStackTrace();
		}tx.commit();

	}

	@Override
	public List<WorkLocation> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(WorkLocation.class);
		List<WorkLocation> workLocationList = null;
		try {
			workLocationList = criteria.list();
			//tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}tx.commit();
		return workLocationList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			WorkLocation workLocation = (WorkLocation) session.get(WorkLocation.class, id);
			session.delete(workLocation);
			
		} catch (Exception e) {

			e.printStackTrace();
		}tx.commit();

	}

}
