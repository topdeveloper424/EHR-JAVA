package com.ets.dao.loginSchedule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.EntityGroup;
import com.ets.model.LoginSchedule;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginScheduleDAOImpl Class
 *Description: LoginSchedule Entity DAO class
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
public class LoginScheduleDAOImpl implements LoginScheduleDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the LoginSchedule objects currently present in
	 * the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param loginSchedule
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(LoginSchedule loginSchdule) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			session.saveOrUpdate(loginSchdule);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * This method gets all the LoginSchedule objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of loginSchedule objects
	 */

	@Override
	public List<LoginSchedule> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(LoginSchedule.class);

		List<LoginSchedule> loginSchduleList = null;

		try {

			loginSchduleList = criteria.list();
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return loginSchduleList;
	}

	/**
	 * This method gets the LoginSchedule objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of loginSchedule objects
	 */

	@Override
	public LoginSchedule getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		LoginSchedule loginSchdule = null;
		try {

			loginSchdule = (LoginSchedule) session.get(LoginSchedule.class, id);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return loginSchdule;
	}

	/**
	 * This method delete the LoginSchedule objects currently present in the
	 * system .
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

			LoginSchedule loginSchdule = (LoginSchedule) session.get(LoginSchedule.class, id);
			session.delete(loginSchdule);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
