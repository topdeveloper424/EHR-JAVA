package com.ets.dao.drugScreenDrugTestResult;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;

@Repository
public class DrugScreenTestResultDAOImpl implements DrugScreenTestResultDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(DrugScreenTestResult drugScreenTestResult) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(drugScreenTestResult);
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		//session.flush();
	}


	
	
	@Override
	public void deleteDrugScreenResult(Integer drugScreen) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			String hql = "DELETE from DrugScreenTestResult D WHERE D.drugScreenId =: drugScreen";
			Query query = session.createQuery(hql);
			query.setInteger("drugScreen", drugScreen);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();		
		
	}

	
	
	@Override
	public List<DrugScreenTestResult> view() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenTestResult.class);
		List<DrugScreenTestResult> viewList=null;
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		
		return viewList;
	}
	
	
	

	@Override
	public List<DrugScreenTestResult> viewByPatient(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenTestResult.class);
		List<DrugScreenTestResult> viewList=null;
		
		try{
			criteria.add(Restrictions.eq("patient.id", id));
			viewList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		return viewList;
	}

	
	
	
	@Override
	public DrugScreenTestResult viewByPatientId(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenTestResult.class);
		List<DrugScreenTestResult> viewList=null;
		
		try{
			criteria.add(Restrictions.eq("patient.id", id));
			viewList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		if(viewList.isEmpty()){
			
			return null;
			
		}else{
			
			return viewList.get(0);
		}
		
	}

	
	
	
	@Override
	public List<DrugScreenTestResult> viewByPatientVisit(Integer patVisitid) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenTestResult.class);
		List<DrugScreenTestResult> viewList=null;
		
		try{
			criteria.add(Restrictions.eq("patientVisit.id", patVisitid));
			viewList = criteria.list();
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		return  viewList;
	}

	
	
	@Override
	public List<DrugScreenTestResult> viewByPatientVisitAndMedActivity(Integer pVisitid, String medCode, Integer drugScreenId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenTestResult.class);
		List<DrugScreenTestResult> viewList=null;
		
		try{
			/*criteria.add(Restrictions.eq("patientVisit.id", pVisitid))
					.add(Restrictions.eq("medicalActivityCode", medCode))
			.add(Restrictions.setProjection(Projections.max("revision"));*/
			String hql = "Select D FROM DrugScreenTestResult D JOIN D.patientVisit pv JOIN D.drugScreenId ds WHERE pv.id =:pVisitid AND ds.id =:drugScreenId AND D.medicalActivityCode like :medCode";
			Query query =session.createQuery(hql);
			query.setInteger("pVisitid", pVisitid);
			query.setParameter("medCode", medCode);
			query.setInteger("drugScreenId", drugScreenId);
			viewList = query.list();
			
			System.out.println("<<<<<<<<<<<<<<<<<####################"+viewList.size());
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();
		
		return  viewList;
	}

	
	
	@Override
	public List<DrugScreenTestResult> viewByDrugScreenDrugName(Integer pVisitid, String medCode, Integer drugScreenId,
			String drugName) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<DrugScreenTestResult> viewList=null;
		try{
			//String hql = "Select D FROM DrugScreenTestResult D LEFT JOIN D.patientVisit pv WHERE D.patientVisit =:pVisitid AND D.medicalActivityCode ilike medCode AND LEFT JOIN D.drugScreenId ds AND D.drugScreenId =:drugScreenId AND D.testName ilike drugName";
			String hql = "Select D FROM DrugScreenTestResult D JOIN D.patientVisit pv JOIN D.drugScreenId ds  WHERE pv.id =:pVisitid AND ds.id=:drugScreenId AND D.drugTestName like :drugName AND D.medicalActivityCode like :medCode";
			Query query =session.createQuery(hql);
			query.setInteger("pVisitid", pVisitid);
			query.setInteger("drugScreenId", drugScreenId);
			query.setParameter("drugName", drugName);
			query.setParameter("medCode", medCode);
		/*	query.setInteger("drugScreenId", drugScreenId);
			query.setParameter("drugName", drugName);*/
			viewList = query.list();
			System.out.println("*******************"+pVisitid+"****"+medCode+"****"+drugScreenId+"***"+drugName+"*** "+viewList.size());
			
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			
		}tx.commit();
		return  viewList;
		//return null;
	}

	
	
}
