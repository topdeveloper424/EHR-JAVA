package com.ets.dao.visionTestParam;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.VisionTestParam;

@Repository
public class VisionTestParamDAOImpl implements VisionTestParamDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(VisionTestParam visionTestParam) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(visionTestParam);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public List<VisionTestParam> viewVisionTestParam() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(VisionTestParam.class);
		List<VisionTestParam> visionTestParamList = null;
		try {
			visionTestParamList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visionTestParamList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		VisionTestParam visionTestParam = (VisionTestParam) session.get(VisionTestParam.class, id);
		try {
			session.delete(visionTestParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

}
