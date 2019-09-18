package com.ets.dao.boyZone;



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

import com.ets.model.BillingServiceType;
import com.ets.model.BodyPart;
import com.ets.model.BodyZone;
import com.ets.model.InjuryCode;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneDAOImpl Class
 *Description: BodyZone Entity DAO class
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
public class BodyZoneDAOImpl implements BodyZoneDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void addBodyZone(BodyZone bodyZone) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(bodyZone);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }
	

	/** This method gets all the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyZone objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BodyZone> bodyZoneList() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BodyZone.class);
		
		List<BodyZone> bodyZoneList = null;
			  try {
				  bodyZoneList = criteria.list();
				   tx.commit();
				  } catch (HibernateException e) {
				   e.printStackTrace();
				  } /*finally {
				   session.close(); 
				  }*/
				  
				  return bodyZoneList;
				  
	}		 		
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<BodyZone> bodyZones = new ArrayList<BodyZone>();
		for (Object obj[] : list) {
			BodyZone zone = new BodyZone();
			zone.setCode((String) obj[0]);
			zone.setDescrip((String) obj[1]);

			bodyZones.add(zone);

		}

		tx.commit();

		return bodyZones;*/
	

	/** This method update the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateBodyZone(BodyZone bodyZone) {
				
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		try {
		session.update(bodyZone);
		trans.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}
	
	/** This method gets all the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyZone objects
	 */
	@Override
	public BodyZone getbyBodyZoneID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		BodyZone bodyZone = null;
		try {
			bodyZone = (BodyZone) session.get(BodyZone.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } /*finally {
		   session.close(); 
		  }*/
		  return bodyZone;
		 }


	/** This method Delete the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void deleteBodyZoneCode(Integer id) {
			
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//BodyZone bodyZone=getbyBodyZoneID(id);
		 try {
		   BodyZone bodyZone = (BodyZone)session.get(BodyZone.class, id); 
		   session.delete(bodyZone);
		   tx.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  }/* finally {
		   session.close(); 
		  }*/
		 }	

}
