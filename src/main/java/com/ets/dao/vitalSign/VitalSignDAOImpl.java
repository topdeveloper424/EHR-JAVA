package com.ets.dao.vitalSign;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientVisit;
import com.ets.model.VitalReader;
import com.ets.model.VitalSign;

@Repository
public class VitalSignDAOImpl implements VitalSignDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(VitalSign vitalSign) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(vitalSign);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}
	@Override
	public List<VitalSign> viewVitalSign(PatientVisit patientVisit) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(VitalSign.class);
		criteria.add(Restrictions.eq("patientVisit", patientVisit));
		List<VitalSign> viewVitalSignList = null;
		try {
			viewVitalSignList = criteria.list();
		

		} catch (Exception e) {

			e.printStackTrace();
		}tx.commit();
		
		return viewVitalSignList;
	}

}
