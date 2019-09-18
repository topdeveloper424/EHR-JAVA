package com.ets.dao.userDefinedForm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.Complex;
import com.ets.model.UserDefinedForm;

@Repository
public class UserDefinedFormDaoImpl implements UserDefinedFormDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveForm(UserDefinedForm userDefinedForm) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(userDefinedForm);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
	}

	@Override
	public List<UserDefinedForm> viewAllForm() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(UserDefinedForm.class);
		List<UserDefinedForm> userDefinedFormList = null;
		try {
			userDefinedFormList = criteria.list();
			   tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
			  
			  return userDefinedFormList;
	}

	@Override
	public void delete(UserDefinedForm userDefinedForm) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(userDefinedForm);
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
