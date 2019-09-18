package com.ets.dao.billingservicetype;


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

import com.ets.model.BillingServiceType;
import com.ets.model.BodyZone;
import com.ets.model.Division;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingServiceTypeDAOImpl Class
 *Description: BillingServiceType Entity DAO class
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
public class BillingServiceTypeDAOImpl implements BillingServiceTypeDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void addBillingServiceType(BillingServiceType billingServiceType) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(billingServiceType);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BillingServiceType> billingServiceTypeLists() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(BillingServiceType.class);
		List<BillingServiceType> billingServiceTypeList = new ArrayList<BillingServiceType>(); 
		billingServiceTypeList = null;
		try {
			billingServiceTypeList = criteria.list();
			   tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			  
			  return billingServiceTypeList;
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("billing_type"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object[]> list=criteria.list();
		
		List<BillingServiceType> serviceTypes=new ArrayList<BillingServiceType>();
		
		for(Object obj[]:list){
			
			BillingServiceType billingService=new BillingServiceType();
			
			billingService.setDescrip((String) obj[0]);
			
			billingService.setBilling_type((String) obj[1]);
			
			serviceTypes.add(billingService);
		}
		
		return serviceTypes;*/
	}

	/** This method update the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateBillingServiceType(BillingServiceType billingServiceType) {

		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(billingServiceType);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	@Override
	public BillingServiceType getByBillingServiceTypeID(Integer id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		BillingServiceType billingServiceType = null;
		try {
			billingServiceType = (BillingServiceType) session.get(BillingServiceType.class, id);
			// trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } trans.commit();/*finally {
		   session.close(); 
		  }*/
		  return billingServiceType;
		 }

	/** This method remove the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void deleteBillingServiceType(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//BillingServiceType billingServiceType = getByBillingServiceTypeID(id);
		try {
			BillingServiceType billingServiceType = (BillingServiceType) session.get(BillingServiceType.class, id);
		session.delete(billingServiceType);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	
	/** This method gets  the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	
	@Override
	public BillingServiceType viewById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BillingServiceType.class);
		criteria.add(Restrictions.eq("id", id));
		
		List<BillingServiceType> billingServiceTypeList = null;
		
		try{
			
			billingServiceTypeList = criteria.list();
			tx.commit();		
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(billingServiceTypeList.isEmpty()){
			
			return null;
			
		}else{
			
			return billingServiceTypeList.get(0);
		}
	}	

}
