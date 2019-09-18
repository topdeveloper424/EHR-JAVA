package com.ets.dao.audiometryTestParamClassify;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.AudiometryTestParamClassify;

@Repository
public class AudiometryTestParamClassifyDAOImpl implements AudiometryTestParamClassifyDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(AudiometryTestParamClassify audiometryTestParamClassify) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(audiometryTestParamClassify);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	@Override
	public List<AudiometryTestParamClassify> viewAudiometryTestParamClassify() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AudiometryTestParamClassify.class);
		List<AudiometryTestParamClassify> viewList = null;
		try {
			viewList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();
		return viewList;
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		AudiometryTestParamClassify audiometryTestParamClassify = (AudiometryTestParamClassify) session
				.get(AudiometryTestParamClassify.class, id);
		try {
			session.delete(audiometryTestParamClassify);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		

	}

}
