package com.ets.dao.clinicianSchException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.controller.gui.clinicianSchedule.ClinicianScheduleViewController;
import com.ets.model.ClinicClosed;
import com.ets.model.Clinician;
import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;
import com.ets.utils.Global;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchExceptionDAOImpl Class
 *Description: ClinicianSchException Entity DAO Class
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
public class ClinicianSchExceptionDAOImpl implements ClinicianSchExceptionDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void saveOrUpdate(List<ClinicianSchException> clinicianSchExceptions) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(ProviderSchException.class);
        criteria.add(Restrictions.eq("clinician.id", clinicianSchExceptions.get(0).getId())).add(Restrictions.between("excepDate", clinicianSchExceptions.get(0).getExcepDate(), clinicianSchExceptions.get(6).getExcepDate()));
		List<ClinicianSchException> list = new ArrayList<ClinicianSchException>();
		list = criteria.list();
		tx.commit();
        try {
        	if(list.size()==0){
        		
        		 session = sessionFactory.getCurrentSession();
         		  tx = session.beginTransaction();
        		for(int i=0;i<clinicianSchExceptions.size();i++){
        			session.saveOrUpdate(clinicianSchExceptions.get(i));		
        			}
        		tx.commit();
        	}else{
        		
        	  for(int i=0;i<list.size();i++){
        		
        		  for(int j=0;j<clinicianSchExceptions.size();j++){
        			  Date date4UI =clinicianSchExceptions.get(j).getExcepDate();
        			 
              		if(list.get(i).getExcepDate().equals(date4UI)){
              			
              			clinicianSchExceptions.remove(j);
              			
              		}
            		  
            	  }  
        	  }
        	  session = sessionFactory.getCurrentSession();
      		  tx = session.beginTransaction();
        	  for(int i=0;i<clinicianSchExceptions.size();i++){
      			session.saveOrUpdate(clinicianSchExceptions.get(i));	
      			
      		}tx.commit();
        	}
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ClinicianSchException clinicianSchException=(ClinicianSchException) session.get(ClinicianSchException.class, id);
		try{
			session.delete(clinicianSchException);
			tx.commit();
		}catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public List<ClinicianSchException> viewProviderSchExcByIdAndDate(Clinician clinician, String stDate, String enDate) {

		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Date startDate=null;
		Date endDate=null;
		
		try {
			startDate = new SimpleDateFormat("MM/dd/yyyy").parse(stDate);
			endDate = new SimpleDateFormat("MM/dd/yyyy").parse(enDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<ClinicianSchException> proSchExp = new ArrayList<ClinicianSchException>();
		Criteria criteria=session.createCriteria(ClinicianSchException.class);
		
		try{
			criteria.add(Restrictions.eq("clinician", clinician))
		   .add(Restrictions.between("excepDate", startDate, endDate));
			proSchExp = criteria.list();
			
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		return proSchExp;
	}

	@Override
	public void saveOrUpdateNoDuplicate(ClinicianSchException clinicianSchException) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClinicianSchException.class);

		String date4UI = new SimpleDateFormat("MM/dd/yyyy").format(clinicianSchException.getExcepDate());
		List<ClinicianSchException> clinicianSchExceptionList = null;
	    try{
	    	criteria.add(Restrictions.eq("excepDate", clinicianSchException.getExcepDate()));
	    	clinicianSchExceptionList = criteria.list();
	    	tx.commit();
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    ClinicianSchException  clinicianSchException4Search = null;
	    if(clinicianSchExceptionList.size() != 0 )	{
	    	clinicianSchException4Search = clinicianSchExceptionList.get(0);
	    	
	    }
	    else	{
	    	clinicianSchException4Search = null;
	    	
	    }


	    ClinicianSchException clinicianSchExc4Insert = null;
		//Object not exist in DB ?
		if(clinicianSchException4Search == null )	{
			clinicianSchExc4Insert = new ClinicianSchException();
			// Convert from String to date
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				clinicianSchExc4Insert.setExcepDate(df.parse(date4UI));
				clinicianSchExc4Insert.setClinician(clinicianSchException.getClinician());
				try {
					// Insert the object into DB
					 session = sessionFactory.getCurrentSession();
					 tx = session.beginTransaction();
					session.saveOrUpdate(clinicianSchExc4Insert);
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

	@Override
	public void deleteBetweenDates(Date stD, Date endD,Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		try{
			String hql="DELETE from ClinicianSchException cs WHERE cs.excepDate>=:stD AND cs.excepDate<=:endD AND cs.clinician=:clinician";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("clinician", clinician.getId());
			query.setDate("stD", stD);
			query.setDate("endD", endD);
		    query.executeUpdate();
			
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		
	}

}
