package com.ets.dao.inventory.inventoryOutGo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;

@Repository
public class InventoryOutGoDAOImpl implements InventoryOutGoDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	
	
	@Override
	public void saveOrUpdate(InventoryOutGo inventoryOutGo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(inventoryOutGo);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
	
		
	}

	@Override
	public List<InventoryOutGo> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(InventoryOutGo.class);
		
		List<InventoryOutGo> inventoryOutGoList = null;
		try {
			inventoryOutGoList = criteria.list();
			
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  }tx.commit();
		  
		  return inventoryOutGoList;
	}  
		
}
