package com.ets.dao.allergyCategory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.AllergyCategory;
import com.ets.model.Carrier;

@Repository
public class AllergyCategoryDAOImpl implements AllergyCategoryDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveOrUpdate(AllergyCategory allergyCategory) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(allergyCategory);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AllergyCategory> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AllergyCategory.class);
		List<AllergyCategory> allergyCategoryList = null;
		try {
			allergyCategoryList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return allergyCategoryList;
	}
	@Override
	public AllergyCategory searchByDescrip(String descrip) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AllergyCategory.class);
		List<AllergyCategory> allergyCategoryList = null;
		try {
			
	        criteria.add(Restrictions.ilike("description", descrip+"%"));
	        allergyCategoryList = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return allergyCategoryList.get(0);
	}


}
