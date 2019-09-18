package com.ets.dao.flowsheet;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.FlowsheetSpecialOrder;

@Repository
public class FlowsheetSpecialOrderDAOImpl implements FlowsheetSpecialOrderDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdateFlowsheetSpecialOrder(FlowsheetSpecialOrder flowsheetSpecialOrder) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(flowsheetSpecialOrder);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<FlowsheetSpecialOrder> viewFlowsheetSpecialOrder() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(FlowsheetSpecialOrder.class);

		List<FlowsheetSpecialOrder> flowsheetSpecialOrderList = null;
		try {
			flowsheetSpecialOrderList = criteria.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		tx.commit();

		return flowsheetSpecialOrderList;
	}

	@Override
	public List<FlowsheetSpecialOrder> viewByPatientVisitId(Integer patVisitid) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//Criteria criteria = session.createCriteria(FlowsheetSpecialOrder.class);
        String hql = "SELECT f FROM FlowsheetSpecialOrder f JOIN f.patientVisit pv WHERE pv.id=:patVisitid";
		List<FlowsheetSpecialOrder> flowsheetSpecialOrderList = null;
		try {
			Query query = session.createQuery(hql);
			query.setInteger("patVisitid", patVisitid);
			//criteria.add(Restrictions.eq("patientVisit.id", patVisitid));
			flowsheetSpecialOrderList = query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		tx.commit();

		return flowsheetSpecialOrderList;
	}

	@Override
	public void delete(FlowsheetSpecialOrder flowsheetSpecialOrder) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.delete(flowsheetSpecialOrder);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		tx.commit();
		
	}

}
