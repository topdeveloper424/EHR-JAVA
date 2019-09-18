package com.ets.dao.workRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.WorkRestriction;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionDAOImpl Class
 *Description: WorkRestriction Entity DAO class
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
public class WorkRestrictionDAOImpl implements WorkRestrictionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save the WorkRestriction objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workRestriction
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(WorkRestriction workRestriction) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(workRestriction);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method gets all the WorkRestriction objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkRestriction objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkRestriction> list() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(WorkRestriction.class);

		List<WorkRestriction> workRestrictionList = null;
		try {
			workRestrictionList = criteria.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return workRestrictionList;
	}

	/**
	 * This method update the WorkRestriction objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workRestriction
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(WorkRestriction workRestriction) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(workRestriction);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method gets all the WorkRestriction objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkRestriction objects
	 */
	@Override
	public WorkRestriction getByID(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		WorkRestriction workRestriction = null;
		try {
			workRestriction = (WorkRestriction) session.get(WorkRestriction.class, id);
			//trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		
			session.close();
		}
		return workRestriction;
	}

	/**
	 * This method delete the WorkRestriction objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			WorkRestriction workRestriction = (WorkRestriction) session.get(WorkRestriction.class, id);
			session.delete(workRestriction);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
