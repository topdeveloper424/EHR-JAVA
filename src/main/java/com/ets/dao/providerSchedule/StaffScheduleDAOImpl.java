package com.ets.dao.providerSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffScheduleDAOImpl Class
 *Description: ProviderSchedule Entity DAO class
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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Provider;
import com.ets.model.ProviderSchedule;


@Repository
public class StaffScheduleDAOImpl implements StaffScheduleDAO {
   
	private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(ProviderSchedule staffSchedule) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(staffSchedule);
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}   tx.commit();
		
	}

	@Override
	public List<ProviderSchedule> viewProviderScheduleById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
      Criteria criteria= session.createCriteria(ProviderSchedule.class );
      
      List<ProviderSchedule> providerScheduleList = null;
      
      //criteria.createAlias("provider", "p");
      
        try {
			
			 criteria.add(Restrictions.eq("provider.id", id));
			 providerScheduleList = criteria.list();
        	//criteria.add(Restrictions.eq("p.id", id));
        	//criteria.add(Restrictions.eqProperty("", ""));
			 tx.commit();
			 
		} catch (HibernateException e) {
		    e.printStackTrace();
		}
      

		return providerScheduleList;
	}

	@Override
	public List<ProviderSchedule> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProviderSchedule.class);
		List<ProviderSchedule> proSchList = null;
      try{
    	  
    	  proSchList = criteria.list();
    	  
      }catch(Exception e){
		
    	  e.printStackTrace();
      }
      
      return proSchList;
	}

}
