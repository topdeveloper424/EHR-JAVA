package com.ets.dao.icd10Codes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.InjuryCode;
import com.ets.utils.FilterDuplicatesObjectProperty;
import com.ets.model.BillingServiceType;
import com.ets.model.Clinic;
import com.ets.model.Icd10Codes;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Icd10CodesDAOImpl Class
 *Description: Icd10Codes Entity DAO class
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

public class Icd10CodesDAOImpl implements Icd10CodesDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** This method save the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param icd10Codes
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIcd10Codes(Icd10Codes icd10Codes) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(icd10Codes);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
			 }
	
	/** This method gets all the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Icd10Codes objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Icd10Codes> icd10CodesList() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Icd10Codes.class);
		
		List<Icd10Codes> icd10CodesList = null;
		List<Icd10Codes> uniqueIcd10 = null;
			  try {
				  icd10CodesList = criteria.list();
				 // tx.commit();
				  } catch (HibernateException e) {
				   e.printStackTrace();
				   tx.rollback();
				  } tx.commit();
				  uniqueIcd10=icd10CodesList.stream().filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId())).collect(Collectors.toList());
				  return uniqueIcd10;
				  
	}
	
	/** This method gets all the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Icd10Codes objects
	 */
	@Override
	public Icd10Codes getbyIcd10CodesID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		Icd10Codes icd10Codes = null;
		try {
			icd10Codes = (Icd10Codes) session.get(Icd10Codes.class, id);
			//trans.commit();
			
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } trans.commit();
		  
		  
		  return icd10Codes;
		 }

	@Override
	public Icd10Codes getByICD10Code(String code) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Icd10Codes.class);
		criteria.add(Restrictions.eq("code", code));
		
		List<Icd10Codes> icd10Codes = null;
		try {

			icd10Codes = criteria.list();
			

		} catch (Exception e) {

			e.printStackTrace();

		}tx.commit();
		
		if(icd10Codes.isEmpty()){
			
			return null;
			
		}else{
			
			return icd10Codes.get(0);
			
		}
	}

	@Override
	public void delete(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Icd10Codes icd10Codes = getbyIcd10CodesID(id);
		session.delete(icd10Codes);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
			 }
}
