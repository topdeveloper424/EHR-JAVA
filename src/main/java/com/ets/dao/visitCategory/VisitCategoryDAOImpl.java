package com.ets.dao.visitCategory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Division;
import com.ets.model.Provider;
import com.ets.model.VisitCategory;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryDAOImpl Class
 *Description: VisitCategory Entity DAO class
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
public class VisitCategoryDAOImpl implements VisitCategoryDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrUpdate(VisitCategory visitCategory) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(visitCategory);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}

	@Override
	public List<VisitCategory> view() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(VisitCategory.class);
		List<VisitCategory> visitCategoryList = null;
		  try {
			  visitCategoryList = criteria.list();
			
			 
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  tx.commit(); 
		  /*finally {
			   session.close(); 
			  }
		 */
		return visitCategoryList;
	}

	@Override
	public void delete(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		VisitCategory visitCategory = (VisitCategory) session.get(VisitCategory.class, id);
		try{
			
			session.delete(visitCategory);
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}tx.commit();
	}

	@Override
	public VisitCategory viewByCode(String code) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(VisitCategory.class);
		
		criteria.add(Restrictions.eq("code", code));
		List<VisitCategory> visitCategoryList = null;
		try{
		
			visitCategoryList = criteria.list();
			
		
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}tx.commit();
		if(visitCategoryList.isEmpty()){
			
			return null;
		}else{
			
			return visitCategoryList.get(0);
		}
		
		
	}

}
