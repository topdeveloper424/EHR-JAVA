package com.ets.dao.clinicianSchedule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicianSchedule;
import com.ets.model.ProviderSchedule;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianScheduleDAOImpl Class
 *Description: ClinicianSchedule Entity DAO Class
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
public class ClinicianScheduleDAOImpl implements  ClinicianScheduleDAO {

private SessionFactory sessionFactory;
    


public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

@Override
public void saveOrUpdate(ClinicianSchedule clinicianSchedule) {
	
	
	Session session=sessionFactory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	try{
		session.saveOrUpdate(clinicianSchedule);
	 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}   tx.commit();
	
}

@Override
public List<ClinicianSchedule> viewClinicianScheduleId(Integer id) {
	Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
  Criteria criteria= session.createCriteria(ClinicianSchedule.class );
  
  List<ClinicianSchedule> clinicianSchedules = null;
  
  //criteria.createAlias("provider", "p");
  
    try {
		
		 criteria.add(Restrictions.eq("clinician.id", id));
		 clinicianSchedules = criteria.list();
    	//criteria.add(Restrictions.eq("p.id", id));
    	//criteria.add(Restrictions.eqProperty("", ""));
		 tx.commit();
		 
	} catch (HibernateException e) {
	    e.printStackTrace();
	}
  

	return clinicianSchedules;
}

@Override
public List<ClinicianSchedule> view() {
	
	Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	Criteria criteria = session.createCriteria(ClinicianSchedule.class);
	List<ClinicianSchedule> clinicianSchedulesList = null;
  try{
	  
	  clinicianSchedulesList = criteria.list();
	  
  }catch(Exception e){
	
	  e.printStackTrace();
  }
  
  return clinicianSchedulesList;
}

}
