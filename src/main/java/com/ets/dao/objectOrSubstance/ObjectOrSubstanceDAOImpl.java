package com.ets.dao.objectOrSubstance;

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
import com.ets.model.ObjectOrSubstance;
import com.ets.model.RootCause;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ObjectOrSubstanceDAOImpl Class
 *Description: ObjectOrSubstance Entity DAO class
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
public class ObjectOrSubstanceDAOImpl implements ObjectOrSubstanceDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addObjectorSubstance(ObjectOrSubstance objectOrSubstance) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(objectOrSubstance);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ObjectOrSubstance objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ObjectOrSubstance> objectOrSubstanceLists() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ObjectOrSubstance.class);
		List<ObjectOrSubstance> objectOrSubstanceList = null;
		
		  try {
			  objectOrSubstanceList = criteria.list();
			  //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return objectOrSubstanceList;
			  	

		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<ObjectOrSubstance> substances = new ArrayList<ObjectOrSubstance>();
		for (Object obj[] : list) {
			ObjectOrSubstance orSubstance = new ObjectOrSubstance();
			orSubstance.setCode((String) obj[0]);
			orSubstance.setDescrip((String) obj[1]);

			substances.add(orSubstance);
		}

		//tx.commit();

		return substances;*/
	}

	/** This method update the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateObjectOrSubstance(ObjectOrSubstance objectOrSubstance) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(objectOrSubstance);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ObjectOrSubstance objects
	 */
	@Override
	public ObjectOrSubstance getByObjectOrSubstanceID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		ObjectOrSubstance objectOrSubstance = null;
		try {
			objectOrSubstance = (ObjectOrSubstance) session.get(ObjectOrSubstance.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return objectOrSubstance;
		 }

	/** This method delete the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteObjectOrSubstance(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ObjectOrSubstance objectOrSubstance=getByObjectOrSubstanceID(id);
		 try {
			 ObjectOrSubstance objectOrSubstance = (ObjectOrSubstance) session.get(ObjectOrSubstance.class, id);
		session.delete(objectOrSubstance);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
