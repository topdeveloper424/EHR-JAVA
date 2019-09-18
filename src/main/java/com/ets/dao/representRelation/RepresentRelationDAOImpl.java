package com.ets.dao.representRelation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ets.model.RepresentRelation;

public class RepresentRelationDAOImpl implements RepresentRelationDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(RepresentRelation representRelation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(representRelation);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}

	@Override
	public void saveOrUpdate(RepresentRelation representRelation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(representRelation);
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
			RepresentRelation relation = (RepresentRelation) session.get(RepresentRelation.class, id);
			session.delete(relation);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		tx.commit();
		}


	/*@Override
	public void view(RepresentRelation representRelation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			((RepresentRelationDAOImpl) session).view(representRelation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tx.commit();
		}*/

	@Override
	public List<RepresentRelation> viewrelationList(Integer patId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Criteria criteria=session.createCriteria(RepresentRelation.class);
		String hql = "SELECT R FROM RepresentRelation R WHERE R.patient =:patId";
		Query query = session.createQuery(hql);
		query.setInteger("patId", patId);
		List<RepresentRelation> viewrelationList = null;
		try {
			viewrelationList = query.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
		 } finally {
			   session.close();
		 }

		return viewrelationList;
	}

	/*@Override
	public RepresentRelation getByRelationId(Integer id) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		RepresentRelation relation = null;
		try {
			relation = (RepresentRelation) session.get(RepresentRelation.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		    e.printStackTrace();
		  } finally {
		    session.close();
		  }
		 return relation;

	}*/
		
	}
		
	



