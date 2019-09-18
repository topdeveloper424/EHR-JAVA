package com.ets.dao.companyStandardProtocolActivity;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyStandardProtocolActivity;

@Repository
public class CompanyStandardProtocolActivityDAOImpl implements CompanyStandardProtocolActivityDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCompanyStandardProtocolActivity(CompanyStandardProtocolActivity companyStandardProtocolActivity) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(companyStandardProtocolActivity);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
	}

	@Override
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivity() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyStandardProtocolActivity.class);
		List<CompanyStandardProtocolActivity> companyStandardProtocolActivityList = null;
		  try {
			  companyStandardProtocolActivityList = criteria.list();
			  tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		return companyStandardProtocolActivityList;
	}

	@Override
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivityByProtocolId(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyStandardProtocolActivity.class);
		List<CompanyStandardProtocolActivity> companyStandardProtocolActivityList = null;
		  try {
			  criteria.add(Restrictions.eq("companyProtocol.id", id));
			  companyStandardProtocolActivityList = criteria.list();
			  tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		return companyStandardProtocolActivityList;
	}

	@Override
	public void delete(Integer companyStandardProtocolActivityId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		 try {
			  CompanyStandardProtocolActivity companyStandardProtocolActivity =  (CompanyStandardProtocolActivity) session.get(CompanyStandardProtocolActivity.class, companyStandardProtocolActivityId);
			  session.delete(companyStandardProtocolActivity);
			 
			  tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  } 
		  
	}

	@Override
	public void deleteByProtocolId(Integer protocolId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
        String hql = "DELETE FROM CompanyStandardProtocolActivity csp WHERE companyProtocol=:id";
		try{
		  Query query = session.createQuery(hql);
		  query.setInteger("id", protocolId);
		  query.executeUpdate();
		  tx.commit();
		  System.out.println("***********Deleted by proto id*****");
		}catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  } 
	}

	
}
