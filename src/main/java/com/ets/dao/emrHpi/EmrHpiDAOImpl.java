package com.ets.dao.emrHpi;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.Statement;
import org.springframework.stereotype.Repository;

import com.ets.model.EmrHpi;

import net.sf.ehcache.hibernate.HibernateUtil;

@Repository
public class EmrHpiDAOImpl implements EmrHpiDAO{

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<EmrHpi> emrHpi) {
		
		 Session session=sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
		  try {
			  			  
			  for(EmrHpi hpi :emrHpi){
				  
				  hpi.getCharacteristics();
				  hpi.getDate();
				  hpi.getDescrip();
				  hpi.getPatient();
				  hpi.getSummary();
				  
				  session.saveOrUpdate(hpi);
				  
			  }
			  tx.commit();

			} catch (Exception e) {
					tx.rollback();
				e.printStackTrace();
			}
		
	}


	@Override
	public int delete(String emrHpi) {
		
		  Session session=sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		   //String hql = String.format("delete from %s",emrHpi);
		  String str = "delete from EmrHpi";
		  Query query = session.createQuery(str);
		  int it  = query.executeUpdate();
			

			 
			  tx.commit();

	

	
		  return it;
		
	}


	
		
	


	/*@Override
	public List<EmrHpi> view() {
		
		  Session session=sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  List<EmrHpi> emrHpis=null;
		  try {

			  Criteria criteria=session.createCriteria(EmrHpi.class);
				
				emrHpis=criteria.list();
				
			}
				

			catch (Exception e) {
					tx.rollback();
				e.printStackTrace();
			}tx.commit();

		   return emrHpis;

}*/}
