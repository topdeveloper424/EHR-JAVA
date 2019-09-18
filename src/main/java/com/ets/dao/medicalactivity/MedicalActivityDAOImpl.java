package com.ets.dao.medicalactivity;

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

import com.ets.dao.medicalactivity.MedicalActivityDAO;
import com.ets.model.MedicalActivity;
import com.ets.model.NAICSCode;

/**
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 09-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityDAOImpl Class
 *Description: Medical Activity Entity DAO class
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
public class MedicalActivityDAOImpl  implements MedicalActivityDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addMedicalActivity(MedicalActivity medicalActivity) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(medicalActivity);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }
	
	/** This method gets all the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param Nothing
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalActivity> medicalActivityList() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(MedicalActivity.class);
		List<MedicalActivity> medicalActivityList = null;
		  try {
			  medicalActivityList = criteria.list();
			  tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			  
			  return medicalActivityList;
	}
	

	/** This method update the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateMedicalActivity(MedicalActivity medicalActivity) {
				
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(medicalActivity);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}
	
	/** This method gets all the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	@Override
	public MedicalActivity getByMedicalActivityID(Integer id) {
			
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		MedicalActivity medicalActivity = null;
		try {
			medicalActivity = (MedicalActivity) session.get(MedicalActivity.class, id);
		 trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } /*finally {
		   session.close(); 
		  }*/
		  return medicalActivity;
		 }
	
	/** This method delete the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteMedicalActivity(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		 try {
			 MedicalActivity medicalActivity = (MedicalActivity) session.get(MedicalActivity.class, id);
		session.delete(medicalActivity);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	
	
	@Override
	public List<MedicalActivity> viewMedicalActivityById(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(MedicalActivity.class);
		List<MedicalActivity> medicalActivities = null;
		
		criteria.add(Restrictions.eq("id", id));
		medicalActivities = criteria.list();
		tx.commit();
		//session.close();
		return medicalActivities;
		
		
	}

	/** This method get the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param code
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return MedicalActivity object
	 */
	@Override
	public MedicalActivity viewByCode(String code) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		Criteria criteria = session.createCriteria(MedicalActivity.class);
		criteria.add(Restrictions.eq("code", code));
		List<MedicalActivity> medicalActivityList = null;
		
		try{
			medicalActivityList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		if(medicalActivityList.isEmpty()){
			
			return null;
			
		}else{
			
			return medicalActivityList.get(0);
		}
	}

	@Override
	public MedicalActivity searchByDescription(String descp) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		Criteria criteria = session.createCriteria(MedicalActivity.class);
		criteria.add(Restrictions.eq("descrip", descp));
		List<MedicalActivity> medicalActivityList = null;
		
		try{
			medicalActivityList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			tx.rollback();
			
		}
		return medicalActivityList.get(0);
	}

}
