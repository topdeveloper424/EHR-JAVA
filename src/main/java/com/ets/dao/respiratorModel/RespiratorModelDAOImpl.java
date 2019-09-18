package com.ets.dao.respiratorModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.RespiratorModel;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelDAOImpl Class
 *Description: RespiratorModel Entity DAO class
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
public class RespiratorModelDAOImpl implements RespiratorModelDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the RespiratorModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param respiratorModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addRespiratorModel(RespiratorModel respiratorModel) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(respiratorModel);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the RespiratorModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RespiratorModel objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RespiratorModel> viewAllRespiratorModel() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(RespiratorModel.class);
		List<RespiratorModel> respiratorModelList = null;
		try {
			respiratorModelList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return respiratorModelList;
	}

	@Override
	public void delete(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			
			RespiratorModel respiratorModel = (RespiratorModel) session.get(RespiratorModel.class, id);
			session.delete(respiratorModel);
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

}
