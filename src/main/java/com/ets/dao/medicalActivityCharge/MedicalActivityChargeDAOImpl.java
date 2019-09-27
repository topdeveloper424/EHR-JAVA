package com.ets.dao.medicalActivityCharge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientAnalysis;
import com.ets.model.PatientVisit;
import com.ets.utils.DateConvert;
import com.ets.utils.FilterDuplicatesObjectProperty;
import com.ets.utils.Global;

@Repository
public class MedicalActivityChargeDAOImpl implements  MedicalActivityChargeDAO{
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(MedicalActivityCharge medicalActivityCharge) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(medicalActivityCharge);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
	}

	/*@Override
	public List<MedicalActivityCharge> viewMedicalActivityCharge() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
		List<MedicalActivityCharge> viewList=null;
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		return viewList;
	}*/
	@Override
	public List<MedicalActivityCharge> viewMedicalActivityCharge(Integer id,Boolean checkBillingStatus) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
         /*criteria.add(Restrictions.and((Restrictions.eq("patient.id", id)),
        		 (Restrictions.eq("checkBillingStatus", checkBillingStatus)));*/
		//criteria.add(Restrictions.eq("patient.id", id))
		criteria.add(Restrictions.eq("patientVisit.id", id))
				.add(Restrictions.eq("checkBillingStatus",checkBillingStatus));
		List<MedicalActivityCharge> viewList=null;
		List<MedicalActivityCharge> medActivityUnique=null;
		try{
			viewList=criteria.list();
			System.out.println("######### viewlist "+viewList.size());
			medActivityUnique=viewList.stream().filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId())).collect(Collectors.toList());
			System.out.println("######### without dupli "+medActivityUnique.size());
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		return medActivityUnique;
		
		
	}
	
	
	
	
/*	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
	MedicalActivityCharge medicalActivityCharge=(MedicalActivityCharge) session.get(MedicalActivityCharge.class, id);
		try{
			DrugScreenResult drugScreenResult=(DrugScreenResult) session.get(DrugScreenResult.class, medicalActivityCharge.getDrugScreenResult().getId());
		
				session.delete(drugScreenResult);	
				System.out.println("*******************************");
				medicalActivityCharge.setDrugScreenResult(null);
			session.delete(medicalActivityCharge);
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
	}*/

	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			MedicalActivityCharge medicalActivityCharge = (MedicalActivityCharge) session.get(MedicalActivityCharge.class, id);
			session.delete(medicalActivityCharge);
		
		    } catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		  tx.commit();
		  }
	
	
	
	

	@Override
	public List<MedicalActivityCharge> viewByMedicalActivityId(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
         criteria.add(Restrictions.eq("medicalActivity.id", id));
		List<MedicalActivityCharge> viewList=null;
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		return viewList;
		
	}

	@Override
	public List<MedicalActivityCharge> searchByDateAndOverride(Date fromDate, Date toDate, String Override) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<MedicalActivityCharge> viewSearchList=null;
		if(Override.isEmpty()==false){
		//Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
		
       /*  criteria.add(Restrictions.and(Restrictions.eq("patientVisit.id", patientVisitId),
        		 Restrictions.ge("activityDate",fromDate),
        		 Restrictions.le("activityDate", toDate),
        		 Restrictions.ilike("overridePayer", Override)));*/
			String hql = "FROM MedicalActivityCharge M WHERE M.overridePayer like :override AND M.checkBillingStatus =:billstatus AND M.activityDate BETWEEN :fromDate AND :toDate";
			
			
			Query query = session.createQuery(hql);
			
			query.setString("override", Override);
		    query.setBoolean("billstatus", false);
		    query.setDate("fromDate", fromDate);
		    query.setDate("toDate", toDate);
		   
		     
		
		/*criteria.add(Restrictions.and(Restrictions.eq("checkBillingStatus", false),
       		 Restrictions.ge("activityDate",fromDate),
       		 Restrictions.le("activityDate", toDate),
       		 Restrictions.ilike("overridePayer", Override)));
		*/
		
		 
		try{
			viewSearchList = query.list();
			System.out.println(" viewSearchList "+viewSearchList.size());
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		}
		return viewSearchList;
	}

	@Override
	public MedicalActivityCharge searchForDrugScreen(Date date, String medicalActivityCode, PatientVisit patientVisit) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class , "medActiCrg");
		criteria.createAlias("medActiCrg.medicalActivity", "medCode");
		
         criteria.add(Restrictions.and(Restrictions.eq("activityDate", date),
        		Restrictions.ilike("medCode.code",medicalActivityCode),
        		 Restrictions.eq("patientVisit", patientVisit),
        		 Restrictions.eq("activityDate", date))
        		 );
        		 List<MedicalActivityCharge> viewSearchList=null;
 		try{
 			viewSearchList=criteria.list();
 		}catch(Exception e){
 			e.printStackTrace();
 			tx.rollback();
 		}tx.commit();
 		return viewSearchList.get(0);

}

	@Override
	public List<MedicalActivityCharge> searchByDatePatientBillingStatus(Date date) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
		
		 criteria.add(Restrictions.and(Restrictions.eq("activityDate", date),
	        		
	        		 Restrictions.eq("checkBillingStatus", false),
	        		// Restrictions.eq("patient", Global.patient))  for now commented
				     Restrictions.eq("patientVisit", Global.patientVisitObj))
	        		 );
	        		 List<MedicalActivityCharge> viewSearchList=null;
	 		try{
	 			viewSearchList=criteria.list();
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}tx.commit();
	 		return viewSearchList;
	 		
	}

	@Override
	public List<MedicalActivityCharge> searchByPatientVisit(Integer patientVisit) {
		List<MedicalActivityCharge> medicalChargesUnique =null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
		
		 criteria.add(Restrictions.and(Restrictions.eq("patientVisit.id", patientVisit)));
	        		 List<MedicalActivityCharge> viewSearchList=null;
	 		try{
	 			viewSearchList=criteria.list();
	 			medicalChargesUnique=viewSearchList.stream().filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId())).collect(Collectors.toList());
	 			
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}tx.commit();
	 		return medicalChargesUnique;
	 		
	}
	
	@Override
	public List<MedicalActivityCharge> searchByPatient(Integer patientId) {
		List<MedicalActivityCharge> medicalChargesUnique =null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(MedicalActivityCharge.class);
		
		 criteria.add(Restrictions.and(Restrictions.eq("patient.id", patientId)));
	        		 List<MedicalActivityCharge> viewSearchList=null;
	 		try{
	 			viewSearchList=criteria.list();
	 			medicalChargesUnique=viewSearchList.stream().filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId())).collect(Collectors.toList());
	 			
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}tx.commit();
	 		return medicalChargesUnique;
	}

	@Override
	public Double getTotalChargeForPatVisit(Integer patVisitId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Query query=null;
		Double total=0.0;
		try{
		 String hql = "Select SUM(CAST(M.overrideFee As float)* CAST(M.billingQty As float)) FROM MedicalActivityCharge M JOIN M.patientVisit pv WHERE pv.id=:patVisitId";
		 query = session.createQuery(hql);
		
	    query.setInteger("patVisitId", patVisitId);
	    total=(Double) query.list().get(0);
		}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		}tx.commit();
		
		 return total;
		 
		 
	}

	@Override
	public List<MedicalActivityCharge> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Override
	public void delete(MedicalActivityCharge medicalActivityCharge) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(medicalActivityCharge);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
	}*/
}