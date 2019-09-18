package com.ets.dao.supervisor;


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
import com.ets.model.Region;
import com.ets.model.SeverityCode;
import com.ets.model.Supervisor;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorDAOImpl Class
 *Description: Supervisor Entity DAO class
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
public class SupervisorDAOImpl implements SupervisorDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSupervisor(Supervisor supervisor) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(supervisor);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Supervisor> supervisorList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Supervisor.class);
		List<Supervisor> supervisorList = null;
		try {
			supervisorList = criteria.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return supervisorList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("fisrtName"));
		projectionList.add(Projections.property("type"));
		projectionList.add(Projections.property("inactive"));
		
		criteria.setProjection(projectionList);
		//criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> list= criteria.list();
		
		List<Supervisor> supervisorLists=new ArrayList<Supervisor>();
		
		for(Object obj[]:list){

			Supervisor supervisor=new Supervisor();
			
			supervisor.setFisrtName((String) obj[0]);
			supervisor.setType((String) obj[1]);
			supervisor.setInactive((boolean) obj[2]);
			//identifier
			//supervisor.setType(type);
			//supervisor.setInactive(obj[2]);
			supervisorLists.add(supervisor);
			
		}
		//tx.commit();
		
		return supervisorLists;*/
	}

	/** This method update the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSupervisor(Supervisor supervisor) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(supervisor);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public Supervisor getBySupervisorID(Integer id) {
				
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Supervisor supervisor = null;
		try {
			supervisor = (Supervisor) session.get(Supervisor.class, id);
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  return supervisor;
			 }

	/** This method delete the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisorName
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSupervisor(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Supervisor supervisor = getBySupervisorID(id);
		try {
		Supervisor supervisor = (Supervisor) session.get(Supervisor.class, id);
		session.delete(supervisor);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisorName
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */
	
	@Override
	public List<Supervisor> searchSupervisor(String supervisorName) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = session.createCriteria(Supervisor.class);
				 criteria.add(Restrictions.ilike("fisrtName", supervisorName + "%" ));
					
					return criteria.list();
		
	}	
	
}
