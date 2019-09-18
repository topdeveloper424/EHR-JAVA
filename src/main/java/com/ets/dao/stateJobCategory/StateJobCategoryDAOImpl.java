package com.ets.dao.stateJobCategory;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BodyZone;
import com.ets.model.SeverityCode;
import com.ets.model.StateJobCategory;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateJobCategoryDAOImpl Class
 *Description: StateJobCategory Entity DAO class
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
public class StateJobCategoryDAOImpl implements StateJobCategoryDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateJobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addStateJobCategory(StateJobCategory stateJobCategory) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(stateJobCategory);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateJobCategory objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StateJobCategory> stateJobCategoryList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(StateJobCategory.class);
		List<StateJobCategory> stateJobCatList = null;
		try {
			stateJobCatList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return stateJobCatList;
			  
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> list=criteria.list();
		
		List<StateJobCategory> job=new ArrayList<StateJobCategory>();
		
		for(Object obj[]:list){
			
			StateJobCategory category=new StateJobCategory();
			category.setCode((String) obj[0]);
			category.setDescrip((String) obj[1]);
			
			job.add(category);
		}
		
		//tx.commit();
		
		return job;*/
	}

	/** This method update the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateJobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateStateJobCategory(StateJobCategory stateJobCategory) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(stateJobCategory);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateJobCategory objects
	 */
	@Override
	public StateJobCategory getByStateJobCategoryID(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		StateJobCategory stateJobCategory = null;
		try {
			stateJobCategory = (StateJobCategory) session.get(StateJobCategory.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return stateJobCategory;
		 }

	/** This method delete the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteStateJobCategory(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//StateJobCategory stateJobCategory = getByStateJobCategoryID(id);
		try {
			StateJobCategory stateJobCategory = (StateJobCategory) session.get(StateJobCategory.class, id);
		session.delete(stateJobCategory);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
