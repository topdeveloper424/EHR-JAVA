package com.ets.dao.assessment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Assesment;
import com.ets.model.BodyPart;
import com.ets.model.InventoryDescription;
import com.ets.model.Patient;
@Repository
public class AssessmentDAOImpl implements AssessmentDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	
	@Override
	public void saveOrUpdate(Assesment assesment) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(assesment);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
		
	}

	@Override
	public List<Assesment> search(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria=session.createCriteria(Assesment.class);
		criteria.add(Restrictions.eq("patient.id",id));
		criteria.add(Restrictions.isNotNull("icd10.id"));
		List<Assesment> assesmentsList  = null;
		try {
			assesmentsList=criteria.list();
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
			return assesmentsList;
		
	}

	@Override
	public List<Assesment> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria=session.createCriteria(Assesment.class);
		
		List<Assesment> assesmentsList  = null;
		try {
			assesmentsList=criteria.list();
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
			return assesmentsList;
	}

	@Override
	public void delete(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  try{
			  
			  Assesment assesment = (Assesment)session.get(Assesment.class, id); 
			   session.delete(assesment);
			   tx.commit();
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  tx.rollback();
		  }
		
	}
	
	}
