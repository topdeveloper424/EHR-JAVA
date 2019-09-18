package com.ets.dao.parentEmployerGroup;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Clinic;
import com.ets.model.DepartmentUnit;
import com.ets.model.ParentEmployerGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupDAOImpl Class
 *Description: ParentEmployerGroup Entity DAO class
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
public class ParentEmployerGroupDAOImpl implements ParentEmployerGroupDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(ParentEmployerGroup parentEmployerGroup) {
	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		try{
			
			session.saveOrUpdate(parentEmployerGroup);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public List<ParentEmployerGroup> view() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(ParentEmployerGroup.class);
		List<ParentEmployerGroup> parentEmployerGroupList = null;
		try {
			parentEmployerGroupList = criteria.list();
			   //tx.commit();
			//tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
			  
			  return parentEmployerGroupList;
	}
		

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			
			ParentEmployerGroup parentEmployerGroup = (ParentEmployerGroup) session.get(ParentEmployerGroup.class, id);
			session.delete(parentEmployerGroup);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
}
