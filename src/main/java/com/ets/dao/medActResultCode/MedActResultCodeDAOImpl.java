package com.ets.dao.medActResultCode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.MedActResultCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 31-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActResultCodeDAOImpl Class
 *Description: MedActResultCode Entity DAO class
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
public class MedActResultCodeDAOImpl implements MedActResultCodeDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method Save the medActResultCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medActResultCode
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addOrUpdate(MedActResultCode medActResultCode) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			session.saveOrUpdate(medActResultCode);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	

}
