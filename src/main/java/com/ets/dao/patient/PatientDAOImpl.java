package com.ets.dao.patient;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientDAOImpl Class
 *Description: Patient Entity DAO class
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
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import com.ets.model.Patient;
import com.ets.utils.Global;


@Repository
public class PatientDAOImpl implements PatientDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public List<Patient> searchPatientByName(String firstName, String lastName,Date dob,Integer clinic) {
		
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

	
	
	

	@Override
	public List<Patient> search(Date date1, Date date2) {
		
		Session session=sessionFactory.getCurrentSession();
		 Transaction tx=session.beginTransaction();
		 Criteria criteria=session.createCriteria(Patient.class , "patent");
		 criteria.createAlias("patent.patientStatistic", "patStatic");
		 List<Patient> patients = null;
		try{
			if(date1 != null){
				criteria.add(Restrictions.eq("patStatic.date", date1));
			}
			if(date1 != null){
				criteria.add(Restrictions.eq("patStatic.date", date2));
			}
			patients = criteria.list();
			tx.commit();
			
		    }catch(Exception e){
			e.printStackTrace();
			}
	
		return patients;
	}

	
	
	
	
	@Override
	public Patient getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Patient patient=null;
		try {
			 patient= (Patient) session.get(Patient.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		return patient;
	}

	@Override
	public List<Patient> view(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Patient> patientList=null;
		Criteria criteria=session.createCriteria(Patient.class);
		try {
			criteria.add(Restrictions.eq("clinic.id", id));
			patientList=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		return patientList;
	}
	
	public Patient viewByPatientId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Patient> patientList1=null;
		Criteria criteria=session.createCriteria(Patient.class);
		try {
			criteria.add(Restrictions.eq("id", id));
			patientList1=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		return patientList1.get(0);
	}

	@Override
	public List<Patient> viewSortedPatients(String c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Patient> patientList2=null;
		String c1=c.toLowerCase();
		try{
			String hql = "Select p From Patient p JOIN p.patientName pn WHERE pn.firstName like :c OR pn.firstName like :c1";
			Query query =session.createQuery(hql);
			
			query.setParameter("c", c+"%");
			query.setParameter("c1", c1+"%");
			patientList2 =query.list();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		
		return  patientList2;
		
		
	}

	
	

}
