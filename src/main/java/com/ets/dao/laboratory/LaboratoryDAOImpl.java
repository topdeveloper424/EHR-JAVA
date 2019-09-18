package com.ets.dao.laboratory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.CptCode4Hcpcs;
import com.ets.model.Laboratory;
import com.ets.model.Tpa;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LaboratoryDAOImpl Class
 *Description: Laboratory Entity DAO Class
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
public class LaboratoryDAOImpl implements LaboratoryDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(Laboratory laboratory) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(laboratory);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
	}

	@Override
	public List<Laboratory> view() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Laboratory.class);
		List<Laboratory> laboratoryList = null;
		  try {
			  laboratoryList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
		  
		return laboratoryList;
	}

	@Override
	public void delete(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Laboratory laboratory = (Laboratory) session.get(Laboratory.class, id);
		try{
			
			session.delete(laboratory);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public Laboratory viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Laboratory.class);
		criteria.add(Restrictions.eq("code", code));
		List<Laboratory> laboratoryList = null;
		
		try{
			
			laboratoryList = criteria.list();
			tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(laboratoryList.isEmpty()){
			
			return null;
			
		}else{
			
			return laboratoryList.get(0);
		}
	}
	

}
