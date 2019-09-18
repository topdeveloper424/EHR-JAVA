package com.ets.dao.patientAuthRep;

import java.util.List;

import org.hibernate.Criteria;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepDAOImpl Class
 *Description: PatientAuthRep Entity DAO class
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ets.model.PatientAuthRep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientDrivingLicense;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepDAOImpl Class
 *Description: PatientAuthRep Entity DAO class
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

public class PatientAuthRepDAOImpl implements PatientAuthRepDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PatientAuthRep patientAuthRep) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			session.saveOrUpdate(patientAuthRep);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PatientAuthRep> view() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientAuthRep.class);
		List<PatientAuthRep> plist=null;
		
		try{
			plist=criteria.list();
			tx.commit();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return plist;
	}

	

	@Override
	public PatientAuthRep viewById(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientAuthRep.class);
		List<PatientAuthRep> plist=null;
		try{
			criteria.add(Restrictions.eq("id", id));
		plist=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		if(plist.isEmpty()){
			
			return null ;
			
		}else{
			
			return plist.get(0);
		}
		
	}

	@Override
	public void delete(Integer id) {
	
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
	    PatientAuthRep patientAuthRep=(PatientAuthRep) session.get(PatientAuthRep.class , id);
		try{
			session.delete(patientAuthRep);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
	}
	

}
