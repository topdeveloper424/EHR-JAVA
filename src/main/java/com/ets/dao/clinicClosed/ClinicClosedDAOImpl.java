package com.ets.dao.clinicClosed;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicClosed;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosedDAOImpl Class
 *Description: Implementation class for ClinicClosedDAO Class
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
public class ClinicClosedDAOImpl implements ClinicClosedDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(ClinicClosed clinicClosed) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(clinicClosed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public void delete(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		ClinicClosed clinicClosed = (ClinicClosed) session.get(ClinicClosed.class , id);

		try{
			session.delete(clinicClosed);

			tx.commit();

		}catch(Exception e){
			e.printStackTrace();
		}


	}

	@Override
	public List<ClinicClosed> viewByDate(String str1, String str2, Integer cId) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClinicClosed.class);

		List<ClinicClosed> clinicClosed = null;

	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    Date startDate;
	    Date endDate;

	    try{

	    	startDate = df.parse(str1);
	    	endDate = df.parse(str2);

	    	System.out.println("Start Date  : " +startDate);
	    	System.out.println("End Date  : " +endDate);

	    	criteria.add(Restrictions.ge("scheduledDate", startDate))
	    			.add(Restrictions.le("scheduledDate", endDate));
	    	criteria.add(Restrictions.eq("clinic.id", cId));
	    	clinicClosed = criteria.list();
	    	tx.commit();
	    
	    }catch(Exception e){
	    	
	    	 tx.rollback();
	    	e.printStackTrace();
	    	

	    }

		return clinicClosed;
	}

	// Insert such that there is no duplicate records after the operation
	@Override
	public void saveOrUpdateNoDuplicate(ClinicClosed clinicClosed) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClinicClosed.class);

		String date4UI = new SimpleDateFormat("MM/dd/yyyy").format(clinicClosed.getScheduledDate());
		List<ClinicClosed> clinicClosedList = null;
	    try{
	    	criteria.add(Restrictions.eq("scheduledDate", clinicClosed.getScheduledDate() ));
	    	clinicClosedList = criteria.list();
	    	tx.commit();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    ClinicClosed  clinicClosed4Search = null;
	    if(clinicClosedList.size() != 0 )	{
	    	clinicClosed4Search = clinicClosedList.get(0);
	    	
	    }
	    else	{
	    		clinicClosed4Search = null;
	    	
	    }


		ClinicClosed clinicClosed4Insert = null;
		//Object not exist in DB ?
		if(clinicClosed4Search == null )	{
			clinicClosed4Insert = new ClinicClosed();
			// Convert from String to date
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				clinicClosed4Insert.setScheduledDate(df.parse(date4UI));
				clinicClosed4Insert.setClinic(Global.clinic);
				try {
					// Insert the object into DB
					session = sessionFactory.getCurrentSession();
					 tx = session.beginTransaction();
					session.saveOrUpdate(clinicClosed4Insert);
				} catch (Exception e) {
					e.printStackTrace();
					tx.rollback();
				}
				tx.commit();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	//Get ClinicClosed object for targetDate
	@Override
	public ClinicClosed getByDate( String dateParam ) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClinicClosed.class);

		List<ClinicClosed> clinicClosedList = null;

	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	    Date targetDate = null;
	    try{
	    	targetDate = df.parse(dateParam);
	    	criteria.add(Restrictions.ge("scheduledDate", targetDate));
	    	clinicClosedList = criteria.list();
	    	tx.commit();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    if(clinicClosedList.size() != 0 )
	    	return clinicClosedList.get(0);
	    else
	    	return null ;
	}

	@Override
	public void deleteByDate(Date date) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClinicClosed.class);
     try{
    	  criteria.add(Restrictions.eq("scheduledDate", date));
    	  List<ClinicClosed> clinicClosed = criteria.list();
        	session.delete(clinicClosed.get(0));
    	tx.commit();
     }catch(Exception e){
    	 e.printStackTrace(); 
    	 
     }
		
	}

}
