package com.ets.dao.patientVisit;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.BatchFailedException;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Icd10Codes;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;
import com.ets.utils.FilterDuplicatesObjectProperty;
import com.ets.utils.Global;

@Repository
public class PatientVisitDAOImpl implements PatientVisitDAO{
	
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(PatientVisit patientVisit) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();

		try {
			
		
			
			/*for (PatientVisit patientVisit2 : patientVisit) {
				
				patientVisit2.getIcd10Codes();
				patientVisit2.getAlertNotes();
				patientVisit2.getArrivalTime();
				patientVisit2.getBillingAccount();
				patientVisit2.getBillingPsysician();
				patientVisit2.getCheckOut();
				patientVisit2.getClinician();
				patientVisit2.getCompletionTime();
				patientVisit2.getCompletionTime();
				patientVisit2.getExamRoom1();
				patientVisit2.getExamRoom2();
				patientVisit2.getExamRoom7();
				patientVisit2.getEyeRoom();
				patientVisit2.getIcd10Codes();
				i++;
				session.saveOrUpdate(patientVisit2);
			}
		if( i % 13 == 0 ) { // Same as the JDBC batch size
		        //flush a batch of inserts and release memory:
				System.out.println("Session is Clear Now");
		       
		        session.clear();
			
			
		 } */
			
		
				session.saveOrUpdate(patientVisit);
	       }catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
			 	
		  } tx.commit();
		
	}

	@Override
	public List<PatientVisit> view() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> patientVisitList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class);
		try {
			patientVisitList=criteria.list();
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		return patientVisitList;
	}
/*
	@Override
	public List<PatientVisit> viewByDate(Date fromDate, Date toDate) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class);
      
     
       criteria.add(Restrictions.and(Restrictions.ge("visitDate", fromDate),
    		                      Restrictions.le("visitDate", toDate)));
      	                      
	
       criteria.add(Restrictions.or(Restrictions.between("visitDate", fromDate, toDate),
    		   Restrictions.eq("visitDate", fromDate)));
       
       String hql = "SELECT P FROM PatientVisit P WHERE P.visitDate <=:toDate AND P.visitDate >=:fromDate";
       Query query = session.createQuery(hql);
       try {
			//viewByDateList= criteria.list();
    	   query.setDate("toDate", toDate);
    	   query.setDate("fromDate", fromDate);
    	   viewByDateList = query.list();
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		return viewByDateList;
	}*/

	@Override
	public List<PatientVisit> viewByDateOne(Date fromDate) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class);
       criteria.add(Restrictions.ge("visitDate", fromDate));
       
       try {
			viewByDateList= criteria.list();
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		return viewByDateList;
	}
	
	
	
	
	@Override
	public List<PatientVisit> viewByDate(Date fromDate, Date toDate) {
	
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql ="SELECT pv FROM PatientVisit pv WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
		//String hql ="SELECT pv FROM PatientVisit pv JOIN pv.patient.clinic c =:Id WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
	    Query query=session.createQuery(hql);
	
	  //  query.setInteger("clinic", clinic);
	    query.setDate("frmDate", fromDate);
	    query.setDate("toDate", toDate);
		List<PatientVisit> patientVisitList = null;
		try{
			patientVisitList = query.list();
			tx.commit();
					}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientVisitList;
	}
	
	
	
	
	
	
	
/*	@Override
    public List<PatientVisit> viewById(Integer Id, Date frmDate, Date toDate) {
		System.out.println("sdasdsdfdvvnn");
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql ="SELECT pv FROM PatientVisit pv JOIN pv.clinic c WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
		//String hql ="SELECT pv FROM PatientVisit pv JOIN pv.patient.clinic c =:Id WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
	    Query query=session.createQuery(hql);
	  //  Query query=session.createQuery(hql);
	    query.setInteger("Id", Id);
	    query.setDate("frmDate", frmDate);
	    query.setDate("toDate", toDate);
		List<PatientVisit> patientVisitList = null;
		Criteria criteria1=session.createCriteria(PatientVisit.class, "pat");
		Criteria criteria2=session.createCriteria(clinic.class, "cli");
	    criteria1.createAlias("pat.patient", "patObj");
	    criteria1.createAlias("pat.Date", "patDate");
	    criteria1.add(Restrictions.eq("patObj.id", Id));
	    criteria.add(Restrictions.eq("patDate.visitDate", fromDate));
	    criteria.add(Restrictions.eq("patDate.visitDate", toDate));
		   criteria.add(Restrictions.eq("clinic.id", Id))
		   			.add(Restrictions.eq("visitDate", fromDate));
		           // .add(Restrictions.eq("visitDate", toDate));
		           
		
		try{
			patientVisitList = query.list();
			//patientVisitList = criteria.list();
			tx.commit();
					}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientVisitList;
	}*/
	
	
	
	
	
	
	@Override
	public List<PatientVisit> searchPatient(Date frmDate, Date toDate, Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql ="SELECT pv FROM PatientVisit pv JOIN pv.clinic c WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
		//String hql ="SELECT pv FROM PatientVisit pv JOIN pv.patient.clinic c =:Id WHERE pv.visitDate >=:frmDate AND pv.visitDate <=:toDate";
	    Query query=session.createQuery(hql);
	
	  //  query.setInteger("clinic", clinic);
	    query.setDate("frmDate", frmDate);
	    query.setDate("toDate", toDate);
		List<PatientVisit> patientVisitList = null;
		try{
			patientVisitList = query.list();
			tx.commit();
					}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientVisitList;
	}
	
	
	@Override
	public List<PatientVisit> viewByPat(Integer patId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       /* List<PatientVisit> patientByIdVisitList=null;
		System.out.println("@@pat id "+patId);
		try{
			String hql="SELECT distinct pv.id FROM PatientVisit pv JOIN pv.billingAccount bl JOIN pv.clinician cli JOIN pv.patient pat JOIN pv.referredBy ref JOIN pv.companyProtocol cp WHERE pv.patient.id =:patId";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("patId", patId);
			patientByIdVisitList=query.list();
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}*/
       List<PatientVisit> patientByIdVisitList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class , "pat");
       criteria.createAlias("pat.patient", "patObj");
       criteria.add(Restrictions.eq("patObj.id", patId));
       List<PatientVisit> distinctElements =null;
		try {
			patientByIdVisitList=criteria.list();
			distinctElements = patientByIdVisitList.stream().filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId())).collect(Collectors.toList());
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		 
		for (int i=0;i<distinctElements.size();i++) {
		
			System.out.println("@@@@@@@@@@@@ dupli "+distinctElements.get(i).getId() +distinctElements.get(i).getIcd10Codes().size());
		}
		
		return distinctElements;
	}

	@Override
	public List<PatientVisit> viewByDate(Date date) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=null;
      /* Criteria criteria=session.createCriteria(PatientVisit.class);
     
       criteria.add(Restrictions.eq("waitingRoom", true));
       criteria.add(Restrictions.eq("visitDate", date));*/
       
       try {
    	   String hql = "Select pv FROM PatientVisit pv INNER JOIN pv.patient p WHERE pv.visitDate =:date";
   	       Query query = session.createQuery(hql);
   	       query.setDate("date", date);
   	      
		   viewByDateList= query.list();
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		return viewByDateList;
	}

	
	
/*	
	Session session=sessionFactory.getCurrentSession();
	Transaction tx=session.beginTransaction();
   List<PatientVisit> viewByDateList=null;
   Criteria criteria=session.createCriteria(PatientVisit.class);
   
 
   criteria.add(Restrictions.eq("patient.id", patId))
   			.add(Restrictions.eq("visitDate", visitDate));
   
   try {
		viewByDateList= criteria.list();
		
	 }*/
	
	
	
	
	@Override
	public PatientVisit ViewByNameAndDate(String firstName, String latName, String inTime) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=new ArrayList<PatientVisit>();
       Criteria criteria=session.createCriteria(PatientVisit.class , "patVst");
       criteria.createAlias("patVst.patient", "pat");
       criteria.createAlias("pat.patientName", "patName");
       criteria.add(Restrictions.eq("patName.firstName", firstName));
       criteria.add(Restrictions.eq("patName.lastName", latName));
       criteria.add(Restrictions.eq("patVst.arrivalTime", inTime));
       
       try {
			viewByDateList= criteria.list();
			
			System.out.println("Patient Visit Size is : " +viewByDateList.size()
			+firstName+" "+latName+" "+inTime);
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		return viewByDateList.get(0);
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
     PatientVisit patientVisit =   (PatientVisit) session.get(PatientVisit.class, id);
       
		try{
		session.delete(patientVisit);
		}catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
	}

	@Override
	public PatientVisit viewByPatientVisitId(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class);
       
     
       criteria.add(Restrictions.eq("id", id));
       
       try {
			viewByDateList= criteria.list();
			
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		if(viewByDateList.size()>0){
			return viewByDateList.get(0);	
			
		}else{
			
			return null;
		}
		
	}

	@Override
	public List<PatientVisit> viewBypatIdAndVDate(Integer patId, Date visitDate) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
       List<PatientVisit> viewByDateList=null;
       Criteria criteria=session.createCriteria(PatientVisit.class);
       
     
       criteria.add(Restrictions.eq("patient.id", patId))
       			.add(Restrictions.eq("visitDate", visitDate));
       
       try {
			viewByDateList= criteria.list();
			
		 } catch (HibernateException e) {
			 	tx.rollback();
			 	e.printStackTrace();
		 } tx.commit();
		
		 if(viewByDateList.size() > 0){
			 return viewByDateList;
		 }else{
			 return null;
		 }
		
	}

	@Override
	public void deleteIcd(PatientVisit patvisitId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicBlockSchedule> list=null;
		
		try{
			String hql="DELETE ic from PatientVisit pIcd JOIN pIcd.icdCodes ic WHERE pIcd.id:=patvisitId";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("patvisitId", patvisitId.getId());
			list=query.list();
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		
	}

	@Override
	public List<PatientVisit> viewByProtocolId(Integer protocolId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<PatientVisit> list=null;
		try{
			String hql="SELECT pv FROM PatientVisit pv WHERE  pv.companyProtocol=:id";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("id", protocolId);
			list=query.list();
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		return list;
		
		
		
	}

	@Override
	public void setProtocol(Integer protocolId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			String hql="UPDATE PatientVisit pv SET pv.companyProtocol =:param WHERE pv.companyProtocol=:id";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("id", protocolId);
			query.setParameter("param", null);
			query.executeUpdate();
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		
	}


}