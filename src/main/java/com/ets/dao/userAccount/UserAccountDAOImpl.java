package com.ets.dao.userAccount;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.UserAccount;
import com.ets.model.UserLogin;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAccountDAOImpl Class
 *Description: UserAccount Entity DAO class
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
public class UserAccountDAOImpl implements UserAccountDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the UserAccount objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userAccount
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	
	@Override
	public void addOrUpdate(UserAccount userAccount) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			session.saveOrUpdate(userAccount);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}

	/**
	 * This method gets all the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	@Override
	public List<UserAccount> userAccounts() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserAccount.class);
		List<UserAccount> userAccountList  = null;
		
		try{
			
			userAccountList = criteria.list();
			tx.commit();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return userAccountList;
	}

	/**
	 * This method gets the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	@Override
	public UserAccount getById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UserAccount userAccount = null;
		try{
			 userAccount = (UserAccount) session.get(UserAccount.class, id);
			 tx.commit();
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return userAccount;
	}

	/**
	 * This method delete the UserAccount objects currently present in the system .
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
		
		try{
			
			UserAccount userAccount = (UserAccount) session.get(UserAccount.class, id);
			session.delete(userAccount);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * This method Login the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName , password
	 * @since 22-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount object
	 */

	@Override
	public List<UserAccount> login(String userName, String password) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = (Criteria) session.createCriteria(UserAccount.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<UserAccount> userLoginList = null;
		try {
			userLoginList = criteria.list();
			tx.commit();
			  
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
		return userLoginList;
	}
	
	@Override
	public List<UserAccount> login2(String userName, String password, Boolean loginStatus) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = (Criteria) session.createCriteria(UserAccount.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("loginStatus", loginStatus));
		List<UserAccount> userLoginList = null;
		try {
			userLoginList = criteria.list();
			tx.commit();
			   
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
		return userLoginList;
	}

	/**
	 * This method gets the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName
	 * @since 22-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount object
	 */
	
	@Override
	public UserAccount viewByName(String userName) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = (Criteria) session.createCriteria(UserAccount.class);
		criteria.add(Restrictions.eq("userName", userName));
		
		List<UserAccount> userLoginList = null;
		try {
			userLoginList = criteria.list();
			tx.commit();
			  
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
		if(userLoginList.isEmpty()){
			
			return null;
		}else{
			
			return userLoginList.get(0);
			
		}
		
		
	}

	

	
	

}
