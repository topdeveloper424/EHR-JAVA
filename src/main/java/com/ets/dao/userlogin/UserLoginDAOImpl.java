package com.ets.dao.userlogin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ets.model.SeverityCode;
import com.ets.model.UserLogin;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserLoginDAOImpl Class
 *Description: UserLogin Entity DAO class
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


public class UserLoginDAOImpl implements UserLoginDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	/** This method gets all the UserLogin objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name , password
	 * @since 07-03-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserLogin objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserLogin> login(String name, String password) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = (Criteria) session.createCriteria(UserLogin.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));
		List<UserLogin> userLoginList = null;
		try {
			userLoginList = criteria.list();
			tx.commit();
			
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
		return userLoginList;
	}


}
