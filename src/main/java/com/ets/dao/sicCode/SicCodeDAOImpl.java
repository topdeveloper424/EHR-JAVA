package com.ets.dao.sicCode;


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
import com.ets.model.Division;
import com.ets.model.SICCode;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SicCodeDAOImpl Class
 *Description: SICCode Entity DAO class
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
public class SicCodeDAOImpl implements SicCodeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSICCode(SICCode sicCode) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(sicCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SICCode objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SICCode> sicCodeList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(SICCode.class);
		List<SICCode> SICCodeList = null;
		try {
			SICCodeList = criteria.list();
			   //tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } tx.commit();
			  
			  return SICCodeList;
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));

		criteria.setProjection(projectionList);
		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<SICCode> sicCodeLists = new ArrayList<SICCode>();

		for (Object obj[] : list) {

			SICCode sicCode = new SICCode();
			sicCode.setCode((String) obj[0]);
			sicCode.setDescrip((String) obj[1]);

			sicCodeLists.add(sicCode);

		}

		//tx.commit();

		return sicCodeLists;*/
	}

	/** This method update the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSICCode(SICCode sicCode) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(sicCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SICCode objects
	 */
	@Override
	public SICCode getBySICCodeID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		SICCode sicCode = null;
		try {
			sicCode = (SICCode) session.get(SICCode.class, id);
			trans.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			  return sicCode;
			 }

	/** This method delete the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSICCode(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//SICCode sicCode = getBySICCodeID(id);
		try {
			SICCode sicCode = (SICCode) session.get(SICCode.class, id);
		session.delete(sicCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	@Override
	public SICCode viewByCode(String code) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(SICCode.class);
		criteria.add(Restrictions.eq("code", code));
		List<SICCode> sicList = null;
		try{
			sicList=criteria.list();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}tx.commit();
		
		if(sicList.isEmpty()){
			
			return null;
			
		}else{
			
			return sicList.get(0);
			
		}
		
	}	

}