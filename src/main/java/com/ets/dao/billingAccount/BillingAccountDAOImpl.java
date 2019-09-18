package com.ets.dao.billingAccount;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BillingAccount;
import com.ets.model.Region;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingAccountDAOImpl Class
 *Description: BillingAccount Entity Non-GUI Controller class
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

public class BillingAccountDAOImpl implements BillingAccountDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(BillingAccount billingAccount) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(billingAccount);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		tx.commit();

	}

	@Override
	public List<BillingAccount> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<BillingAccount> billingAccounts=null;
		try{
			Criteria criteria = session.createCriteria(BillingAccount.class);
			billingAccounts= criteria.list();
			
			
		}catch(Exception e){
			
		}
		tx.commit();
		return billingAccounts;
	}

	@Override
	public BillingAccount viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BillingAccount.class);
		criteria.add(Restrictions.eq("code", code));
		List<BillingAccount> billingAccountList = null;
		
		try{
			
			billingAccountList = criteria.list();
			//tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}tx.commit();
		
		if(billingAccountList.isEmpty()){
			
			return null;
			
		}else{
			
			return billingAccountList.get(0);
		}
	}

	@Override
	public void delete(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		BillingAccount billingAccount = (BillingAccount) session.get(BillingAccount.class, id);
		
		try{
			
			session.delete(billingAccount);
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}tx.commit();
		
	}

}
