package com.ets.dao.clinic;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Clinic;
import com.ets.model.Complex;
import com.ets.model.Patient;
import com.ets.model.Role;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicDAOImpl Class
 *Description: Clinic Entity DAO class
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
public class ClinicDAOImpl implements ClinicDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(Clinic clinic) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(clinic);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}

	/** This method gets all the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Clinic objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> list() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Clinic.class);
		List<Clinic> clinicList = null;
		try {
			clinicList = criteria.list();
			 // tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit(); 
		
			  
			  return clinicList;
	}

	/** This method update the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	
	
	
/*	
	@Override
	public List<Patient> searchClinicByName(String firstName, String lastName,Date dob,Integer clinic) {
		
		Session session=sessionFactory.getCurrentSession();
		 Transaction tx=session.beginTransaction();
		 Criteria criteria=session.createCriteria(Patient.class , "patent");
		 criteria.createAlias("patent.patientName", "patName");
		 criteria.createAlias("patent.patientStatistic", "patStatic");
		 criteria.createAlias("patent.clinic","cli");
		 List<Patient> patients = null;
		try{
				
			if(firstName.length() > 0){
				
				criteria.add(Restrictions.ilike("patName.firstName",firstName+"%"));
			}
			if(lastName.length() > 0){
				
								
				criteria.add(Restrictions.ilike("patName.lastName", lastName+"%"));
				
			}
			if(dob != null){
												
				criteria.add(Restrictions.eq("patStatic.dob", dob));
			}
			
			criteria.add(Restrictions.eq("cli.id", Global.clinic.getId()));

			patients = criteria.list();
			
				tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
		
		//tx.commit();
		return patients;
	}
	*/
	
	
	@Override
	public void update(Clinic clinic) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(clinic);
		
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}

	/** This method gets  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Clinic objects
	 */
	@Override
	public Clinic getByID(Integer id) {
		
		return null;
	}

	/** This method delete  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void delete(Integer id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Complex complex = getByComplexID(id);
		try {
			Clinic clinic = (Clinic) session.get(Clinic.class, id);
		session.delete(clinic);
		
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}

	/** This method get  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinicName
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public List<Clinic> search(String clinicName) {
		
		return null;
	}
	
	public ClinicDAOImpl() {
		
	}
	
	/** This method get  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param 
	 * @since 26-08-2016
	 * @version 1.0
	 * 
	 * @return clinicName
	 */
	
	@Override
	public Clinic viewByName(String clinicName) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Clinic.class);
		criteria.add(Restrictions.eq("name", clinicName));
		List<Clinic> clinicList = null;
		try {

			clinicList = criteria.list();
			//tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}tx.commit();
		if(clinicList.isEmpty()){
			
			return null;
			
		}else{
			
			return clinicList.get(0);
			
		}
		
		
	}

}
