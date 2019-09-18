package com.ets.dao.patientAnalysis;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ets.model.PatientAnalysis;

public class PatientAnalysisDAOImpl implements PatientAnalysisDAO  {
	
	
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(PatientAnalysis patientAnalysis) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(patientAnalysis);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}

	@Override
	public void saveOrUpdate(PatientAnalysis patientAnalysis) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(patientAnalysis);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}
		


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			PatientAnalysis relation = (PatientAnalysis) session.get(PatientAnalysis.class, id);
			session.delete(relation);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}


	@Override
	public List<PatientAnalysis> viewPatientId(Integer companyId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Criteria criteria=session.createCriteria(PatientAnalysis.class);
		String hql = "SELECT P FROM PatientAnalysis P WHERE P.company =:companyId";
		Query query = session.createQuery(hql);
		query.setInteger("com", companyId);
		List<PatientAnalysis> viewpatientAnalysisList = null;
		try {
			viewpatientAnalysisList = query.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
		 } finally {
			   session.close();
		 }

		return viewpatientAnalysisList;
	}

}
