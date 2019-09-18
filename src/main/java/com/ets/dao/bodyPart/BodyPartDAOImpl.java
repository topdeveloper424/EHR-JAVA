package com.ets.dao.bodyPart;



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

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyPartDAOImpl Class
 *Description: BodyPart Entity DAO class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 @
 */

@Repository
public class BodyPartDAOImpl implements BodyPartDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*// Save BodyPart Record
	@Override
	public void addBodyPart(BodyPart bodyPart) {
		

		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		session.save(bodyPart);
		tx.commit();

	}

	// Retrive BodyPart Record
	@SuppressWarnings("unchecked")
	@Override
	public List<BodyPart> listBodyPart() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BodyPart.class);
		List<BodyPart> bodyPartList = criteria.list() ; 
		session.close();
		//return criteria.list();
		return bodyPartList;

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<BodyPart> lisParts = new ArrayList<BodyPart>();

		for (Object obj[] : list) {

			BodyPart bodyPart = new BodyPart();
			bodyPart.setCode((String) obj[0]);
			bodyPart.setDescrip((String) obj[1]);

			lisParts.add(bodyPart);

		}
		// session.getTransaction().commit();
		tx.commit();

		return lisParts;
	}

	// Update BodyPart Record
	@Override
	public void updateBodyPart(BodyPart bodyPart) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(bodyPart);
		trans.commit();
		
		
	}

	// Get BodyPart Record by ID
	@Override
	public BodyPart getByBodyPartID(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		//BodyPart bodyPart = (BodyPart) session.get(BodyPart.class, id);
		//session.close();
		return (BodyPart) session.get(BodyPart.class, id);
		//return bodyPart;
	}

	// Delete BodyPart Record
	@Override
	public void deleteBodyPartCode(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		BodyPart bodyPart=getByBodyPartID(id);
		session.delete(bodyPart);
		tx.commit();
		
	}*/
	
	
	
	
	/** This method save the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyPart
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	 @Override
	 public void addBodyPart(BodyPart bodyPart) {
	  Session session = sessionFactory.getCurrentSession();
	  Transaction tx = session.beginTransaction();
	  try {
	   session.save(bodyPart);
	   tx.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  } /*finally {
	   session.close(); 
	  }*/
	 }

	 /** This method gets all the body part objects currently present in the system .
		 * 
		 * @author Sumanta Deyashi
		 * @param Nothing
		 * @since 18-02-2016
		 * @version 1.0
		 * 
		 * @return ObservableList of BodyPart objects
		 */
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<BodyPart> listBodyPart() {
	    
	  Session session = sessionFactory.getCurrentSession();
	  Transaction tx = session.beginTransaction();
	  Criteria criteria = session.createCriteria(BodyPart.class);
	  
	  List<BodyPart> bodyPartList = null;
	  try {
	   bodyPartList = criteria.list();
	   tx.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  } /*finally {
	   session.close(); 
	  }*/
	  
	  return bodyPartList;
	  
	 }

	 /** This method Update all the body part objects currently present in the system .
		 * 
		 * @author Sumanta Deyashi
		 * @param bodyPart
		 * @since 18-02-2016
		 * @version 1.0
		 * 
		 * @return Nothing
		 */
	 @Override
	 public void updateBodyPart(BodyPart bodyPart) {
	  Session session = this.sessionFactory.getCurrentSession();
	  Transaction trans = session.beginTransaction();
	  
	  try {
	   session.update(bodyPart);
	   trans.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  }/*finally {
	   session.close(); 
	  }*/
	 }

	 /** This method gets all the body part objects currently present in the system .
		 * 
		 * @author Sumanta Deyashi
		 * @param id
		 * @since 18-02-2016
		 * @version 1.0
		 * 
		 * @return ObservableList of BodyPart objects
		 */
	 @Override
	 public BodyPart getByBodyPartID(Integer id) {
	  
	  Session session = this.sessionFactory.getCurrentSession();
	  Transaction trans = session.beginTransaction();
	  
	  BodyPart bodyPart = null;
	  try {
	   bodyPart = ( BodyPart )session.get(BodyPart.class, id);
	   //trans.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  } /*finally {
	   session.close(); 
	  }*/
	  return bodyPart;
	 }

	 /** This method Delete the body part objects currently present in the system .
		 * 
		 * @author Sumanta Deyashi
		 * @param Id
		 * @since 18-02-2016
		 * @version 1.0
		 * 
		 * @return Nothing
		 */
	 @Override
	 public void deleteBodyPartCode(Integer id) {
	  Session session = this.sessionFactory.getCurrentSession();
	  Transaction tx = session.beginTransaction();
	  //BodyPart bodyPart=getByBodyPartID(id);
	  try {
	   BodyPart bodyPart = (BodyPart)session.get(BodyPart.class, id); 
	   session.delete(bodyPart);
	   tx.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  }/* finally {
	   session.close(); 
	  }*/
	 }

}
