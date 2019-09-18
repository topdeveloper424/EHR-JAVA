package com.ets.dao.access;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Access;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AccessDAOImpl Class
 *Description: Access Entity DAO class
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
public class AccessDAOImpl implements AccessDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the Access objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param access
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(Access access) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			session.saveOrUpdate(access);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * This method gets all the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of access objects
	 */

	@Override
	public List<Access> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Access.class);

		List<Access> accessList = null;

		try {

			accessList = criteria.list();
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return accessList;
	}

	/**
	 * This method gets the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of access objects
	 */

	@Override
	public Access getById(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Access access = null;

		try {

			access = (Access) session.get(Access.class, id);
			//tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return access;
	}

	/**
	 * This method delete the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void delete(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			Access access = (Access) session.get(Access.class, id);
			session.delete(access);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
