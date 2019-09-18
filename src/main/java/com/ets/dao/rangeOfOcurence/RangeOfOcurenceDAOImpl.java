package com.ets.dao.rangeOfOcurence;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.ets.model.RangeOfOcurence;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RangeOfOcurenceDAOImpl Class
 *Description: RangeOfOcurence Entity DAO class
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
public class RangeOfOcurenceDAOImpl implements RangeOfOcurenceDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rangeOfOcurence
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(RangeOfOcurence rangeOfOcurence) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(rangeOfOcurence);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RangeOfOcurence objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RangeOfOcurence> list() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(RangeOfOcurence.class);

		List<RangeOfOcurence> rangeOfOcurenceList = null;
		try {
			rangeOfOcurenceList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rangeOfOcurenceList;
	}

	/** This method update the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rangeOfOcurence
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void update(RangeOfOcurence rangeOfOcurence) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(rangeOfOcurence);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RangeOfOcurence objects
	 */
	@Override
	public RangeOfOcurence getByID(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		RangeOfOcurence rangeOfOcurence = null;
		try {
			rangeOfOcurence = (RangeOfOcurence) session.get(RangeOfOcurence.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rangeOfOcurence;
	}

	/** This method delete the RangeOfOcurence objects currently present in the system .
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
			RangeOfOcurence rangeOfOcurence = (RangeOfOcurence) session.get(RangeOfOcurence.class, id);
			session.delete(rangeOfOcurence);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
