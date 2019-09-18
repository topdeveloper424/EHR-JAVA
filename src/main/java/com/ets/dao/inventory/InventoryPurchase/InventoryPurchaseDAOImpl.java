package com.ets.dao.inventory.InventoryPurchase;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.InventoryOutGo;
import com.ets.model.InventoryPurchase;

@Repository
public class InventoryPurchaseDAOImpl implements InventoryPurchaseDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	
	
	

	@Override
	public void saveOrUpdate(InventoryPurchase inventoryPurchase) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(inventoryPurchase);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
	
		

		
	}

	@Override
	public List<InventoryPurchase> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(InventoryPurchase.class);
		
		List<InventoryPurchase> inventoryPurchaseList = null;
		try {
			inventoryPurchaseList = criteria.list();
			
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  }tx.commit();
		  
		  return inventoryPurchaseList;
	
	}


}
