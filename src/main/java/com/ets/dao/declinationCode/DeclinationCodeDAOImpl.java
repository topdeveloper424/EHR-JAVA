package com.ets.dao.declinationCode;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.ets.model.DeclinationCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeDAOImpl Class
 *Description: DeclinationCode Entity DAO class
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
public class DeclinationCodeDAOImpl implements DeclinationCodeDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** This method save the declinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param declinationCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	
	@Override
	public void add(DeclinationCode declinationCode) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(declinationCode);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/** This method gets all the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeclinationCode objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeclinationCode> list() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DeclinationCode.class);

		List<DeclinationCode> declinationCodeList = null;
		try {
			declinationCodeList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return declinationCodeList;
	}


	/** This method update the declinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param declinationCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	
	@Override
	public void update(DeclinationCode declinationCode) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(declinationCode);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeclinationCode objects
	 */
	@Override
	public DeclinationCode getByID(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		DeclinationCode declinationCode = null;
		try {
			declinationCode = (DeclinationCode) session.get(DeclinationCode.class, id);
			//trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return declinationCode;
	}

	/** This method Remove the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void delete(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			DeclinationCode declinationCode = (DeclinationCode) session.get(DeclinationCode.class, id);
			session.delete(declinationCode);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		
	}

}
