package com.ets.dao.buildNote;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BuildNote;
import com.ets.model.Carrier;
@Repository
public class BuildNoteDAOImpl implements BuildNoteDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(BuildNote buildNote) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(buildNote);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<BuildNote> viewByPatientVisit(Integer patVisitId){

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BuildNote.class);
         criteria.add(Restrictions.eq("patientVisit.id", patVisitId));
		List<BuildNote> buildNoteList = null;
		try {
			buildNoteList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return buildNoteList;
	}

	@Override
	public List<BuildNote> viewByPatient(Integer patid) {
		
	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BuildNote.class);
         criteria.add(Restrictions.eq("patient.id", patid));
		List<BuildNote> buildNoteList = null;
		try {
			buildNoteList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return buildNoteList;
	}
}
