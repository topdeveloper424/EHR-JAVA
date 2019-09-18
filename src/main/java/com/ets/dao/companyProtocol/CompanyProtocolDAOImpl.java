package com.ets.dao.companyProtocol;

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
public class CompanyProtocolDAOImpl implements CompanyProtocolDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCompanyProtocol(CompanyProtocol companyProtocol) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.saveOrUpdate(companyProtocol);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }
	
		
	}

	@Override
	public List<CompanyProtocol> viewCompanyProtocol() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyProtocol.class);
		List<CompanyProtocol> companyProtocolList = null;
		  try {
			  companyProtocolList = criteria.list();
			 tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		return companyProtocolList;
	}

	@Override
	public List<CompanyProtocol> viewCompanyProtocolByCompanyId(Integer comId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyProtocol.class);
		List<CompanyProtocol> companyProtocolList = null;
		  try {
			  criteria.add(Restrictions.eq("company.id", comId));
			  companyProtocolList = criteria.list();
			 tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		return companyProtocolList;
	}

	@Override
	public CompanyProtocol viewByDescripAndId(Integer compId, String description) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyProtocol.class);
		List<CompanyProtocol> companyProtocolList = null;
		  try {
			  criteria.add(Restrictions.eq("company.id", compId))
			  			.add(Restrictions.eq("description", description));
			  companyProtocolList = criteria.list();
			 tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		  if(companyProtocolList.size() > 0){
			  return companyProtocolList.get(0);
		  }else{
			  return null;
		  }
		  
		
	}

	@Override
	public CompanyProtocol viewByVCatIdAndCompId(Integer compId, Integer vCatId) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(CompanyProtocol.class);
		List<CompanyProtocol> companyProtocolList = null;
		  try {
			  criteria.add(Restrictions.eq("company.id", compId))
			  			.add(Restrictions.eq("visitCategory.id", vCatId));
			  companyProtocolList = criteria.list();
			 tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		  
		  if(companyProtocolList.size() > 0){
			  return companyProtocolList.get(0);
		  }else{
			  return null;
		  }
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		  try {
			  String hql = "DELETE FROM CompanyProtocol cp WHERE cp.id=:id";
			  Query query = session.createQuery(hql);
			  query.setInteger("id", id);
			  query.executeUpdate();
			  System.out.println("***********Deleted*****");
			 
			/* CompanyProtocol companyProtocol= (CompanyProtocol) session.get(CompanyProtocol.class, id);
			
			 System.out.println(companyProtocol.getStandardProtocolActivity().size());
		     System.out.println(companyProtocol.getOptionalProtocolActivity().size());
			 List<CompanyStandardProtocolActivity> companyStandardProtocolActivity= companyProtocol.getStandardProtocolActivity();
			 int count=0;
		     for (CompanyStandardProtocolActivity companyStandardProtocolActivity2 : companyStandardProtocolActivity) {
				session.delete(companyStandardProtocolActivity2);
				
		    	}
		     List<CompanyOptionalProtocolActivity> companyOptionalProtocolActivities = companyProtocol.getOptionalProtocolActivity();
		     for (CompanyOptionalProtocolActivity companyOptionalProtocolActivity : companyOptionalProtocolActivities) {
				session.delete(companyOptionalProtocolActivity);
				
			}
		     companyProtocol.getStandardProtocolActivity().removeAll(companyProtocol.getStandardProtocolActivity());
		     companyProtocol.getOptionalProtocolActivity().removeAll(companyProtocol.getOptionalProtocolActivity());
		     companyProtocol.setCompany(null);
		     System.out.println(companyProtocol.getStandardProtocolActivity().size());
		     System.out.println(companyProtocol.getOptionalProtocolActivity().size());
		     companyProtocol.setStandardProtocolActivity(null);
		     companyProtocol.setOptionalProtocolActivity(null);
		     companyProtocol.setVisitCategory(null);
		     companyProtocol.setJobClass(null);
		     companyProtocol.setDepartmentUnit(null);
		     
			 session.delete(companyProtocol); */
			 
			 tx.commit();
		   } catch (HibernateException e){
			   e.printStackTrace();
			   tx.rollback();
			  } 
		  
		
	}

}
