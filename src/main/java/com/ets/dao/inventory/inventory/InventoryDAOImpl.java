package com.ets.dao.inventory.inventory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.InjuryCode;
import com.ets.model.InventoryDescription;

@Repository
public class InventoryDAOImpl implements InventoryDAO{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	
	@Override
	public void saveOrUpdate(InventoryDescription inventory) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(inventory);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}
	
	

	@Override
	public List<InventoryDescription> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(InventoryDescription.class);
		
		List<InventoryDescription> inventoryList = null;
		try {
			inventoryList = criteria.list();
			
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  }tx.commit();
		  
		  return inventoryList;
		  
		
	}

	@Override
	public InventoryDescription getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		InventoryDescription inventoryDescription=null;
		try {
			inventoryDescription = (InventoryDescription) session.get(InventoryDescription.class,id);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
		return inventoryDescription;
	}

}
