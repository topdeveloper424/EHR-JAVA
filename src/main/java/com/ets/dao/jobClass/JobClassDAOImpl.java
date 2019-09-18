package com.ets.dao.jobClass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Complex;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.JobClass;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 01-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of JobClassDAOImpl Class
 *Description: JobClass Entity DAO class
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
public class JobClassDAOImpl implements JobClassDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addorUpdate(JobClass jobClass) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(jobClass);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
			 }

	@Override
	public List<JobClass> view() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(JobClass.class);
		List<JobClass> jobClassList = null;
		try {
			
			jobClassList = criteria.list();
			//tx.commit();
			   
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return jobClassList;
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
		JobClass jobClass=(JobClass) session.get(JobClass.class, id);
		session.delete(jobClass);
		}
		catch(Exception e){
			e.printStackTrace();
		}tx.commit();
	}

	@Override
	public JobClass viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(JobClass.class);
		criteria.add(Restrictions.eq("classOfJob", code));
		List<JobClass> jobClassList = null;
		
		try{
			
			jobClassList = criteria.list();
			tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(jobClassList.isEmpty()){
			
			return null;
			
		}else{
			
			return jobClassList.get(0);
		}
	}
	

}
