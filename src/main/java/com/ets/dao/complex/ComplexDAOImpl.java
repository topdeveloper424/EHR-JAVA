package com.ets.dao.complex;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BodyZone;
import com.ets.model.Complex;
import com.ets.model.Division;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ComplexDAOImpl Class
 *Description: Complex Entity DAO class
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
public class ComplexDAOImpl implements ComplexDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void addComplex(Complex complex) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(complex);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of complex objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Complex> complexList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Complex.class);
		List<Complex> complexList = null;
		try {
			complexList = criteria.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return complexList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("name"));
		
		criteria.setProjection(projectionList);
		
		List<Object []> list=criteria.list();
		
		List<Complex> complexLists=new ArrayList<Complex>();
		
		for(Object obj[]:list){
			
			Complex complex=new Complex();
			
			complex.setCode((String) obj[0]);
			complex.setName((String) obj[1]);
			
			complexLists.add(complex);
		}
		
		//tx.commit();
		
		return complexLists;*/
	}

	/** This method update the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void updateComplex(Complex complex) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(complex);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of complex objects
	 */
	@Override
	public Complex getByComplexID(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Complex complex = null;
		try {
			complex = (Complex) session.get(Complex.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return complex;
		 }

	/** This method Remove the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteComplex(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Complex complex = getByComplexID(id);
		try {
			Complex complex = (Complex) session.get(Complex.class, id);
		session.delete(complex);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	@Override
	public Complex viewByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Complex.class);
		criteria.add(Restrictions.eq("code", code));
		List<Complex> complexList = null;
		
		try{
			
			complexList = criteria.list();
			//tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(complexList.isEmpty()){
			
			return null;
			
		}else{
			
			return complexList.get(0);
		}
	
		
	}	
	
	

}
