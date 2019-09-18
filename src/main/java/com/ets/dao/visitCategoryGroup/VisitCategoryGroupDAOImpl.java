package com.ets.dao.visitCategoryGroup;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Complex;
import com.ets.model.VisitCategoryGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryGroupDAOImpl Class
 *Description: VisitCategoryGroup Entity DAO class
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
public class VisitCategoryGroupDAOImpl implements VisitCategoryGroupDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** This method gets all the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param visitCategoryGroup
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addVisitCategoryGroup(VisitCategoryGroup visitCategoryGroup) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(visitCategoryGroup);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	
	/** This method gets all the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VisitCategoryGroup objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VisitCategoryGroup> viewVisitCategoryGroup() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(VisitCategoryGroup.class);
		List<VisitCategoryGroup> visitCategoryGroupList = null;
		try {
			visitCategoryGroupList = criteria.list();
			
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return visitCategoryGroupList;
			  
}
}
