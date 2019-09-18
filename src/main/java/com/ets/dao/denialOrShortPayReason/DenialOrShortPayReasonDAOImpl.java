package com.ets.dao.denialOrShortPayReason;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.DenialOrShortPayReason;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DenialOrShortPayReasonDAOImpl Class
 *Description: DenialOrShortPayReason Entity DAO class
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
public class DenialOrShortPayReasonDAOImpl implements DenialOrShortPayReasonDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param denialOrShortPayReason
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void add(DenialOrShortPayReason denialOrShortPayReason) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(denialOrShortPayReason);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DenialOrShortPayReason objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DenialOrShortPayReason> list() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DenialOrShortPayReason.class);

		List<DenialOrShortPayReason> denialOrShortPayReasonList = null;
		try {
			denialOrShortPayReasonList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return denialOrShortPayReasonList;
	}

	/** This method update the denialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param denialOrShortPayReason
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void update(DenialOrShortPayReason denialOrShortPayReason) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(denialOrShortPayReason);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DenialOrShortPayReason objects
	 */
	
	@Override
	public DenialOrShortPayReason getByID(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		DenialOrShortPayReason denialOrShortPayReason = null;
		try {
			denialOrShortPayReason = (DenialOrShortPayReason) session.get(DenialOrShortPayReason.class, id);
			//trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return denialOrShortPayReason;
	}

	/** This method Remove the DenialOrShortPayReason objects currently present in the system .
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
			DenialOrShortPayReason denialOrShortPayReason = (DenialOrShortPayReason) session.get(DenialOrShortPayReason.class, id);
			session.delete(denialOrShortPayReason);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
