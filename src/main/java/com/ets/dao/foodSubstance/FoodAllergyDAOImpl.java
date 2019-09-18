package com.ets.dao.foodSubstance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.AllergyCategory;
import com.ets.model.FoodAllergy;

@Repository
public class FoodAllergyDAOImpl implements FoodAllergyDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(FoodAllergy foodAllergy) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(foodAllergy);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<FoodAllergy> view() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(FoodAllergy.class);
		List<FoodAllergy> foodAllergyList = null;
		try {
			foodAllergyList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return foodAllergyList;
	}

	@Override
	public FoodAllergy searchByDescrip(String substanceName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(FoodAllergy.class);
		List<FoodAllergy>  foodAllergyList = null;
		try {
			
	        criteria.add(Restrictions.ilike("description", substanceName+"%"));
	        foodAllergyList = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return foodAllergyList.get(0);
	}
}
