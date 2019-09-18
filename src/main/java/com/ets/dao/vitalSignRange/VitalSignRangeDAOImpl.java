package com.ets.dao.vitalSignRange;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.ets.model.VitalSignRange;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VitalSignRangeDAOImpl Class
 *Description: VitalSignRange Entity DAO class
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
public class VitalSignRangeDAOImpl implements VitalSignRangeDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param vitalSignRange
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(VitalSignRange vitalSignRange) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(vitalSignRange);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VitalSignRange objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VitalSignRange> list() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(VitalSignRange.class);

		List<VitalSignRange> vitalSignRangeList = null;
		try {
			vitalSignRangeList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return vitalSignRangeList;
	}
	/** This method update the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param vitalSignRange
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(VitalSignRange vitalSignRange) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(vitalSignRange);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	/** This method gets  the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VitalSignRange objects
	 */
	@Override
	public VitalSignRange getByID(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		VitalSignRange vitalSignRange = null;
		try {
			vitalSignRange = (VitalSignRange) session.get(VitalSignRange.class, id);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return vitalSignRange;
	}

	/** This method delete the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			VitalSignRange vitalSignRange = (VitalSignRange) session.get(VitalSignRange.class, id);
			session.delete(vitalSignRange);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
