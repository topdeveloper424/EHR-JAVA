package com.ets.dao.inventory.inventoryCurrentStock;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.InventoryDescription;
import com.ets.model.InventoryCurrentStock;

@Repository
public class InventoryCurrentStockDAOImpl implements InventoryCurrentStockDAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	
	@Override
	public void saveOrUpdate(InventoryCurrentStock inventoryCurrentStock) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(inventoryCurrentStock);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}
	

	@Override
	public List<InventoryCurrentStock> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(InventoryCurrentStock.class);
		
		List<InventoryCurrentStock> inventoryCurrentStockList = null;
		try {
			inventoryCurrentStockList = criteria.list();
			
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  }tx.commit();
		  
		  return inventoryCurrentStockList;
		  
		
	
	}

	
}
