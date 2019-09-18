package com.ets.dao.logins;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.LoginHistory;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginsDAOImpl Class
 *Description: Logins Entity DAO class
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
public class LoginsDAOImpl implements LoginsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the Logins objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param logins
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(LoginHistory logins) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			session.saveOrUpdate(logins);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * This method gets all the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of logins objects
	 */

	@Override
	public List<LoginHistory> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(LoginHistory.class);

		List<LoginHistory> loginsList = null;

		try {

			loginsList = criteria.list();
			tx.commit();
			
			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return loginsList;
	}

	/**
	 * This method gets the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of logins objects
	 */

	@Override
	public LoginHistory getById(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		LoginHistory logins = null;
		try {

			logins = (LoginHistory) session.get(LoginHistory.class, id);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return logins;
	}

	/**
	 * This method delete the Logins objects currently present in the system .
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

			LoginHistory logins = (LoginHistory) session.get(LoginHistory.class, id);
			session.delete(logins);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
