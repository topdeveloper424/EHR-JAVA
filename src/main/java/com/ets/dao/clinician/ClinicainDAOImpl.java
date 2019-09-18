package com.ets.dao.clinician;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Clinician;
import com.ets.model.Provider;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicainDAOImpl Class
 *Description: Clinician Entity DAO Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */



@Repository
public class ClinicainDAOImpl implements ClinicianDAO {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		
	}

	@Override
	public void saveOrUpdate(Clinician clinician) {
		
		Session session =sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			session.saveOrUpdate(clinician);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public List<Clinician> view() {
		
    	
		        Session session=sessionFactory.getCurrentSession();
		        Transaction tx=session.beginTransaction();
		        List<Clinician> clList=null;
		        try
		        {
		        	Criteria criteria=session.createCriteria(Clinician.class);
		        	clList=criteria.list();
		        	
		        	
		        }
		      catch(Exception e)
		        {
		    	  e.printStackTrace();
		        }
		
		        tx.commit(); 
		return clList;
		 
	}

	@Override
	public void delete(Integer id) {
		 Session session=sessionFactory.getCurrentSession();
	        Transaction tx=session.beginTransaction();
	        Clinician clinician=new Clinician();
	        clinician=(Clinician) session.get(Clinician.class, id);
	        
	        try
	        {
	        	session.delete(clinician);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		  tx.commit();
		  		  
	}

	@Override
	public Clinician viewById(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Clinician.class);
		criteria.add(Restrictions.eq("id", id));
		List<Clinician> clinicianList = null;
		try{
			clinicianList = criteria.list();
			//tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		tx.commit();
		if(clinicianList.isEmpty()){
			return null;
		}else{
			
			return clinicianList.get(0);
		}
	
	}

	@Override
	public Clinician viewByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Clinician.class);
		criteria.add(Restrictions.eq("code", code));
		List<Clinician> clinicianList = null;

		try{
			clinicianList=criteria.list();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}tx.commit();
		
		if(clinicianList.isEmpty()){
			return null;
		}else{
			return clinicianList.get(0);
		}
		
		
	} 
	
	
  
}
