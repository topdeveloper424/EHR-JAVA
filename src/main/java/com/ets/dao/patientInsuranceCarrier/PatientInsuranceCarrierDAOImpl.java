package com.ets.dao.patientInsuranceCarrier;
import java.util.List;

import org.hibernate.Criteria;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierDAOImpl Class
 *Description: PatientInsuranceCarrier Entity DAO class
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientInsuranceCarrier;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierDAOImpl Class
 *Description: PatientInsuranceCarrier Entity DAO class
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
public class PatientInsuranceCarrierDAOImpl implements PatientInsuranceCarrierDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void saveOrUpdate(PatientInsuranceCarrier patientInsuranceCarrier) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			
			session.saveOrUpdate(patientInsuranceCarrier);
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}


	@Override
	public List<PatientInsuranceCarrier> view() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientInsuranceCarrier.class);
		List<PatientInsuranceCarrier> insurenceList=null;
		try{
			insurenceList=criteria.list();
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return insurenceList;
	}


	@Override
	public PatientInsuranceCarrier viewById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientInsuranceCarrier.class);
		List<PatientInsuranceCarrier> plist=null;
		try{
			criteria.add(Restrictions.eq("id", id));
			plist=criteria.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(plist.isEmpty()){
			
			return null;
			
		}else{
			
		return plist.get(0);
		
		}
	}


	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		PatientInsuranceCarrier patientInsuranceCarrier=(PatientInsuranceCarrier) session.get(PatientInsuranceCarrier.class, id);
		try{
			session.delete(patientInsuranceCarrier);
		}catch(Exception e)
		{
			e.printStackTrace();
		}tx.commit();
	}

}
