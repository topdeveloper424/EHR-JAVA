package com.ets.dao.incidentOrEvent;

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
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventDAOImpl Class
 *Description: IncidentOrEvent Entity DAO class
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
public class IncidentOrEventDAOImpl implements IncidentOrEventDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIncidentOrEvent(IncidentOrEvent incidentOrEvent) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(incidentOrEvent);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentOrEvent> incidentOrEventLists() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(IncidentOrEvent.class);
		
		List<IncidentOrEvent> incidentOrEventList = null; 
		 try {
			 incidentOrEventList = criteria.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return incidentOrEventList;
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("event_type"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<IncidentOrEvent> orEvents = new ArrayList<IncidentOrEvent>();
		for (Object obj[] : list) {
			IncidentOrEvent incident = new IncidentOrEvent();
			incident.setEvent_type((String) obj[0]);
			incident.setDescrip((String) obj[1]);

			orEvents.add(incident);

		}

		tx.commit();

		return orEvents;*/
	}

	/** This method update the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateIncidentOrEvent(IncidentOrEvent incidentOrEvent) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(incidentOrEvent);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	@Override
	public IncidentOrEvent getByIncidentOrEventID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		IncidentOrEvent incidentOrEvent = null;
		try {
			incidentOrEvent = (IncidentOrEvent) session.get(IncidentOrEvent.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return incidentOrEvent;
		 }

	/** This method delete the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteIncidentOrEvent(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//IncidentOrEvent incidentOrEvent=getByIncidentOrEventID(id);
		try {
			IncidentOrEvent incidentOrEvent = (IncidentOrEvent) session.get(IncidentOrEvent.class, id);
		session.delete(incidentOrEvent);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
