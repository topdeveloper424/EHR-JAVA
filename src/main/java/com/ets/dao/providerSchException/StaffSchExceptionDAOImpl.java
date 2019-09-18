package com.ets.dao.providerSchException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchExceptionDAOImpl Class
 *Description: ProviderSchException Entity DAO class
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.model.ClinicBlockSchedule;
import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;
import com.ets.utils.Global;

@Repository
public class StaffSchExceptionDAOImpl implements StaffSchExceptionDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<ProviderSchException> staffSchException) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(ProviderSchException.class);
        criteria.add(Restrictions.eq("provider.id", staffSchException.get(0).getId())).add(Restrictions.between("excepDate", staffSchException.get(0).getExcepDate(), staffSchException.get(6).getExcepDate()));
		List<ProviderSchException> list = new ArrayList<ProviderSchException>();
		list = criteria.list();
		tx.commit();
        try {
        	if(list.size()==0){
        		
        		 session = sessionFactory.getCurrentSession();
         		  tx = session.beginTransaction();
        		for(int i=0;i<staffSchException.size();i++){
        			session.saveOrUpdate(staffSchException.get(i));		
        			}
        		tx.commit();
        	}else{
        		
        	  for(int i=0;i<list.size();i++){
        		
        		  for(int j=0;j<staffSchException.size();j++){
        			  Date date4UI =staffSchException.get(j).getExcepDate();
        			 
              		if(list.get(i).getExcepDate().equals(date4UI)){
              			
              			staffSchException.remove(j);
              			
              		}
            		  
            	  }  
        	  }
        	  session = sessionFactory.getCurrentSession();
      		  tx = session.beginTransaction();
        	  for(int i=0;i<staffSchException.size();i++){
      			session.saveOrUpdate(staffSchException.get(i));	
      			
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
		ProviderSchException providerSchException=(ProviderSchException) session.get(ProviderSchException.class, id);
		try{
			session.delete(providerSchException);
			tx.commit();
		}catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public List<ProviderSchException> viewProviderSchExcByIdAndDate(Provider provider, String stDate, String enDate) {

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
		List<ProviderSchException> proSchExp = new ArrayList<ProviderSchException>();
		Criteria criteria=session.createCriteria(ProviderSchException.class);
		
		try{
			criteria.add(Restrictions.eq("provider", provider))
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
	public void saveOrUpdateNoDuplicate(ProviderSchException staffSchException) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProviderSchException.class);

		String date4UI = new SimpleDateFormat("MM/dd/yyyy").format(staffSchException.getExcepDate());
		List<ProviderSchException> clinicianSchExceptionList = null;
	    try{
	    	criteria.add(Restrictions.eq("excepDate", staffSchException.getExcepDate()));
	    	clinicianSchExceptionList = criteria.list();
	    	tx.commit();
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    ProviderSchException  staffSchException4Search = null;
	    if(clinicianSchExceptionList.size() != 0 )	{
	    	staffSchException4Search = clinicianSchExceptionList.get(0);
	    	
	    }
	    else	{
	    	staffSchException4Search = null;
	    	
	    }


	    ProviderSchException staffSchException4Insert = null;
		//Object not exist in DB ?
		if(staffSchException4Search == null )	{
			staffSchException4Insert = new ProviderSchException();
			// Convert from String to date
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				staffSchException4Insert.setExcepDate(df.parse(date4UI));
				staffSchException4Insert.setProvider(staffSchException.getProvider());
				try {
					// Insert the object into DB
					 session = sessionFactory.getCurrentSession();
					 tx = session.beginTransaction();
					session.saveOrUpdate(staffSchException4Insert);
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
	public void deleteBetweenDates(Date stD, Date endD,Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		try{
			String hql="DELETE from ProviderSchException cs WHERE cs.excepDate>=:stD AND cs.excepDate<=:endD AND cs.provider=:provider";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("provider", provider.getId());
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
