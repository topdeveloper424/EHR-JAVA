package com.ets.dao.workActivity;

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
import com.ets.model.IncidentOrEvent;
import com.ets.model.RootCause;
import com.ets.model.WorkActivity;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkActivityDAOImpl Class
 *Description: WorkActivity Entity DAO class
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
public class WorkActivityDAOImpl implements WorkActivityDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workActivity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addWorkActivity(WorkActivity workActivity) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(workActivity);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkActivity objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkActivity> workActivityList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(WorkActivity.class);
		List<WorkActivity> workActivityList = null;
		try {
			workActivityList = criteria.list();
			 // tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return workActivityList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> list=criteria.list();
		
		List<WorkActivity> wActivity=new ArrayList<WorkActivity>();
		
		for(Object obj[]:list){
			
			WorkActivity activity=new WorkActivity();
			activity.setCode((String) obj[0]);
			activity.setDescrip((String) obj[1]);
			
			wActivity.add(activity);
		}
		
		//tx.commit();
		
		return wActivity;*/
	}

	/** This method update the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workActivity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateWorkActivity(WorkActivity workActivity) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(workActivity);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkActivity objects
	 */
	@Override
	public WorkActivity getByWorkActivityID(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		WorkActivity workActivity = null;
		try {
			workActivity = (WorkActivity) session.get(WorkActivity.class, id);
			//trans.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  return workActivity;
			 }

	/** This method delete the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteWorkActivity(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//WorkActivity workActivity=getByWorkActivityID(id);
		try {
			WorkActivity workActivity = (WorkActivity) session.get(WorkActivity.class, id);
		session.delete(workActivity);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
