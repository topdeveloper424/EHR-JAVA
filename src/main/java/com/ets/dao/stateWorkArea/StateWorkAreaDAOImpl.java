package com.ets.dao.stateWorkArea;



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
import com.ets.model.StateWorkArea;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaDAOImpl Class
 *Description: StateWorkArea Entity DAO class
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
public class StateWorkAreaDAOImpl implements StateWorkAreaDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addStateWorkArea(StateWorkArea stateWorkArea) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(stateWorkArea);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateWorkArea objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StateWorkArea> stateWorkAreaList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(StateWorkArea.class);
		List<StateWorkArea> stateWorkList = null;
		try {
			stateWorkList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return stateWorkList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> list=criteria.list();
		
		List<StateWorkArea>  workArea=new ArrayList<StateWorkArea>();
		for(Object obj[]:list){
			StateWorkArea area=new StateWorkArea();
			area.setCode((String) obj[0]);
			area.setDescrip((String) obj[1]);
			
			workArea.add(area);
			
		}
		
		//tx.commit();
		
		return workArea;*/
	}

	/** This method update the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateStateWorkArea(StateWorkArea stateWorkArea) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
		session.update(stateWorkArea);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateWorkArea objects
	 */
	@Override
	public StateWorkArea getByStateWorkArea(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		StateWorkArea stateWorkArea = null;
		try {
			stateWorkArea = (StateWorkArea) session.get(StateWorkArea.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return stateWorkArea;
		 }

	/** This method delete the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteStateWorkArea(Integer id) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//StateWorkArea stateWorkArea = getByStateWorkArea(id);
		try {
			StateWorkArea stateWorkArea = (StateWorkArea) session.get(StateWorkArea.class, id);
		session.delete(stateWorkArea);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
