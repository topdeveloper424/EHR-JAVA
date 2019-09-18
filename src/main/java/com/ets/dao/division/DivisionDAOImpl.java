package com.ets.dao.division;

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

import com.ets.dao.division.DivisionDAO;
import com.ets.model.BodyZone;
import com.ets.model.District;
import com.ets.model.Division;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DivisionDAOImpl Class
 *Description: Division Entity DAO class
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
public class DivisionDAOImpl implements DivisionDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addDivision(Division division) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(division);
		
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit(); /*finally {tx.commit();
			   session.close(); 
			  }*/
			 }

	/** This method gets all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Division> divisionList() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Division.class);
		List<Division> divisionList = null;
		  try {
			  divisionList = criteria.list();
			  // tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  } tx.commit();
			  return divisionList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		
		criteria.setProjection(projectionList);
		
		List<Object []> list=criteria.list();
		
		List<Division> divisionLists=new ArrayList<Division>();
		
		for(Object obj[]:list){
			
			Division division=new Division();
			
			division.setCode((String) obj[0]);
			division.setDescrip((String) obj[1]);
			
			
			divisionLists.add(division);
		}
		
		//tx.commit();
		
		return divisionLists;*/
	}


	/** This method update the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void updateDivision(Division division) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(division);
		
		  } catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  }tx.commit();/*finally {
			   session.close(); 
			  }*/
		}

	/** This method get all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	@Override
	public Division getByDivisionID(Integer id) {
	
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Division division = null;
		try {
			division = (Division) session.get(Division.class, id);
		 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		   trans.rollback();
		  } trans.commit();
		  return division;
		 }

	/** This method delete the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteDivision(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Division division = getByDivisionID(id);
		 try {
			 Division division = (Division) session.get(Division.class, id);
		session.delete(division);
		
		  } catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  }tx.commit();/* finally {
			   session.close(); 
			  }*/
			 }	

	/** This method gets all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	
	@Override
	public List<Division> viewDivisionById(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Division.class);
		List<Division> divisions = null;
		try{
		criteria.add(Restrictions.eq("id", id));
		divisions = criteria.list();
		//tx.commit();
		
		}catch(Exception e){
			tx.rollback();
			
			e.printStackTrace();
		}tx.commit();
		//session.close();
		return divisions;
				
	}

	@Override
	public Division viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Division.class);
		criteria.add(Restrictions.eq("code", code));
		List<Division> divisionList = null;
		
		try{
			
			divisionList = criteria.list();
			//tx.commit();
						
			
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}tx.commit();
		
		if(divisionList.isEmpty()){
			
			return null;
			
		}else{
			
			return divisionList.get(0);
		}
		
	}
	
}
