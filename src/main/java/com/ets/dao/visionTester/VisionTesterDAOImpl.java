package com.ets.dao.visionTester;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.VisionTester;



@Repository
public class VisionTesterDAOImpl implements VisionTesterDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	  
	@Override
	public void saveOrUpdate(VisionTester visionTester) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();

		try {
			session.saveOrUpdate(visionTester);
			tx.commit();
		 } catch (Exception e) {
			 	
			 	e.printStackTrace();
		 }tx.commit();
	}
			 	
	public List<VisionTester> viewVisionTester() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
     Criteria criteria=session.createCriteria(VisionTester.class);
      List<VisionTester> visionTester=null;
      
		try {
			visionTester=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return visionTester;
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
	VisionTester visionTester=	(VisionTester) session.get(VisionTester.class, id);
		try{
			session.delete(visionTester);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
	}

	

	
}
