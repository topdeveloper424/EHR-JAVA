package com.ets.dao.drugScreenResult;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import com.ets.model.DrugScreenResult;

@Repository
public class DrugScreenResultDAOImpl implements DrugScreenResultDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(DrugScreenResult drugScreenResult) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(drugScreenResult);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
	}

	@Override
	public List<DrugScreenResult> ViewDrugScreenResult() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenResult.class);
		List<DrugScreenResult> viewList=null;
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
		return viewList;
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		DrugScreenResult	drugScreenResult=(DrugScreenResult) session.get(DrugScreenResult.class, id);
		try{
			session.delete(drugScreenResult);
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();		
		
	}

	@Override
	public DrugScreenResult viewByPatientVisitId(Integer patVisitId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenResult.class);
				 criteria.add(Restrictions.eq("patientVisit.id", patVisitId));
		
		
		List<DrugScreenResult> viewList=new ArrayList<DrugScreenResult> ();
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
		return viewList.get(0);
	}

	@Override
	public DrugScreenResult viewByMedicalChargeId(Integer patVisitId, Integer medActChargeId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql="SELECT D FROM DrugScreenResult D WHERE D.medActCharge =:medActChargeId  AND D.patientVisit =:patVisitId";
		Query query = session.createQuery(hql);
		query.setInteger("patVisitId", patVisitId);
		query.setInteger("medActChargeId", medActChargeId);
		List<DrugScreenResult> viewList=new ArrayList<DrugScreenResult>();
		try{
			viewList= query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		
		tx.rollback();
		}
		tx.commit();
		if(viewList.size()>0){
			return viewList.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteMedActCharge(Integer medActChargeId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			String hql = "DELETE from DrugScreenResult D WHERE D.medActCharge =:medActChargeId ";
			Query query = session.createQuery(hql);
			query.setInteger("medActChargeId", medActChargeId);
			//query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}tx.commit();		
		
	}
	/**
	 * Transaction transaction = session.beginTransaction();
try {
  // your code
  String hql = "delete from Vote where uid= :uid AND pid= :pid";
  Query query = session.createQuery(hql);
  System.out.println(user.getUid() + " and pid: " + pid);
  query.setString("uid", user.getUid());
  query.setInteger("pid", pid);
  System.out.println(query.executeUpdate());
  // your code end

  transaction.commit();
} catch (Throwable t) {
  transaction.rollback();
  throw t;
}
	 * 
	 */

}
