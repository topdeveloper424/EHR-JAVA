package com.ets.dao.rootCause;


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

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseDAOImpl Class
 *Description: RootCause Entity DAO class
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
public class RootCauseDAOImpl implements RootCauseDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addRootCause(RootCause rootCause) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(rootCause);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RootCause objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RootCause> rootCauseLists() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(RootCause.class);
		List<RootCause> rootCauseList = null;
		try {
			rootCauseList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return rootCauseList;
			  


		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<RootCause> rCauses = new ArrayList<RootCause>();

		for (Object obj[] : list) {

			RootCause rootCause = new RootCause();
			rootCause.setCode((String) obj[0]);
			rootCause.setDescrip((String) obj[1]);

			rCauses.add(rootCause);
		}

		//tx.commit();

		return rCauses;*/
	}

	/** This method update the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateRootCause(RootCause rootCause) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(rootCause);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RootCause objects
	 */
	
	@Override
	public RootCause getByRootCauseID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		RootCause rootCause = null;
		try {
			rootCause = (RootCause) session.get(RootCause.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return rootCause;
		 }

	/** This method delete the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteRootCause(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//RootCause rootCause = getByRootCauseID(id);
		try {
			RootCause rootCause = (RootCause) session.get(RootCause.class, id);
		session.delete(rootCause);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
