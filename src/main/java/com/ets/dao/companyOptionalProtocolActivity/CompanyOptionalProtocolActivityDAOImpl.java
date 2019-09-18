package com.ets.dao.companyOptionalProtocolActivity;

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
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Laboratory;

@Repository
public class CompanyOptionalProtocolActivityDAOImpl implements CompanyOptionalProtocolActivityDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity companyOptionalProtocolActivity) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(companyOptionalProtocolActivity);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }
		
	}

	@Override
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivity() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyOptionalProtocolActivity.class);
		List<CompanyOptionalProtocolActivity> companyOptionalProtocolActivityList = null;
		  try {
			  companyOptionalProtocolActivityList = criteria.list();
			  tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		return companyOptionalProtocolActivityList;
	}

	@Override
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivityByProtocolId(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyOptionalProtocolActivity.class);
		List<CompanyOptionalProtocolActivity> companyOptionalProtocolActivityList = null;
		try{
			criteria.add(Restrictions.eq("companyProtocol.id", id));
			companyOptionalProtocolActivityList = criteria.list();
			tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		return companyOptionalProtocolActivityList;
	}

	@Override
	public void delete(Integer companyOptionalProtocolActivityId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		 try {
			  CompanyOptionalProtocolActivity companyOptionalProtocolActivity =  (CompanyOptionalProtocolActivity) session.get(CompanyOptionalProtocolActivity.class, companyOptionalProtocolActivityId);
			  session.delete(companyOptionalProtocolActivity);
			 
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
        String hql = "DELETE FROM CompanyOptionalProtocolActivity csp  WHERE companyProtocol=:id";
		try{
		  Query query = session.createQuery(hql);
		  query.setInteger("id", protocolId);
		  query.executeUpdate();
		  tx.commit();
		  System.out.println("***********Deleted*****");
		}catch (HibernateException e) {
			   e.printStackTrace();
			   tx.rollback();
			  } 
	}
	

}
