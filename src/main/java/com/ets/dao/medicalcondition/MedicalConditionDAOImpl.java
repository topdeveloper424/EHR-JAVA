package com.ets.dao.medicalcondition;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ets.model.Complex;
import com.ets.model.MedicalCondition;
import com.ets.model.NAICSCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalConditionDAOImpl Class
 *Description: MedicalCondition Entity DAO class
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
public class MedicalConditionDAOImpl implements MedicalConditionDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicalConditionDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addMedicalCondition(MedicalCondition medicalCondition) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			
		session.merge(medicalCondition);
		
		transaction.commit();	
		
		logger.info("Medical Condition Data saved successfully, Medical Condition Details=" + medicalCondition);
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalCondition> listMedicalConditions() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria =   session.createCriteria(MedicalCondition.class);
		List<MedicalCondition> medicalConditionList = null;
		try {
			medicalConditionList = criteria.list();
			  // transaction.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  }transaction.commit();
			  return medicalConditionList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		projectionList.add(Projections.property("type"));
		//projectionList.add(Projections.property("inactive"));
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> medicalConditionObjectLists = criteria.list();
		
		List<MedicalCondition> medicalConditions=new ArrayList<MedicalCondition>();
		
		for(Object medical[] : medicalConditionObjectLists ){
			MedicalCondition medicalCondition = new MedicalCondition();
			
			medicalCondition.setCode((String) medical[0]);
			medicalCondition.setDescrip((String) medical[1]);
			medicalCondition.setType((String) medical[2]);
			//medicalCondition.setInactive((boolean) medical[3]);
			
			medicalConditions.add(medicalCondition);
					
		}
		
		//transaction.commit();
		
		return medicalConditions;*/
	}

	/** This method update the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateMedicalCondition(MedicalCondition medicalCondition) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
		session.update(medicalCondition);
		transaction.commit();	
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	
	
	
	
	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	@Override
	public MedicalCondition viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		Criteria criteria = session.createCriteria(MedicalCondition.class);
		criteria.add(Restrictions.eq("code", code));
		List<MedicalCondition> medicalConditionList = null;
		
		try{
			medicalConditionList = criteria.list();
			//tx.commit();
		}catch(Exception e){
			
			e.printStackTrace();
			
		}tx.commit();
		if(medicalConditionList.isEmpty()){
			
			return null;
			
		}else{
			
			return medicalConditionList.get(0);
		}
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		MedicalCondition medicalCondition= (MedicalCondition) session.get(MedicalCondition.class, id);
		try{
			session.delete(medicalCondition);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}tx.commit();
		
	}
	
}
