package com.ets.dao.naicsCode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BodyZone;
import com.ets.model.NAICSCode;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeDAOImpl Class
 *Description: NAICSCode Entity DAO class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */


@Repository
public class NaicsCodeDAOImpl implements NaicsCodeDAO { 
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addNaicsCode(NAICSCode naicsCode) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(naicsCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of NAICSCode objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NAICSCode> naicsCodeLists() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(NAICSCode.class);
		List<NAICSCode> NAICCodeList = null;
		try {
			NAICCodeList = criteria.list();
			  // tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  }tx.commit();
			  
			  return NAICCodeList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		
		criteria.setProjection(projectionList);
		
		criteria.add(Restrictions.eq("inactive", false));
		
		List<Object []> list=criteria.list();
		
		List<NAICSCode> naicsCodeLists=new ArrayList<NAICSCode>();
		
		for(Object obj[]:list){
			
			NAICSCode naicsCode=new NAICSCode();
			
			naicsCode.setCode((String) obj[0]);
			naicsCode.setDescrip((String) obj[1]);
			
			naicsCodeLists.add(naicsCode);
			
		}
		
		//tx.commit();
		
		return naicsCodeLists;*/
	}

	/** This method update the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateNAICSCode(NAICSCode naicsCode) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(naicsCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets  the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of NAICSCode objects
	 */
	@Override
	public NAICSCode getByNAICSCodeID(Integer id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		NAICSCode naicsCode = null;
		try {
			naicsCode = (NAICSCode) session.get(NAICSCode.class, id);
			//trans.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } trans.commit();
			  return naicsCode;
			 }

	/** This method delete the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteNAICSCode(Integer id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//NAICSCode naicsCode = getByNAICSCodeID(id);
		 try {
	    NAICSCode naicsCode = (NAICSCode) session.get(NAICSCode.class, id);
		session.delete(naicsCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	@Override
	public NAICSCode viewByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		Criteria criteria = session.createCriteria(NAICSCode.class);
		criteria.add(Restrictions.eq("code", code));
		List<NAICSCode> naicsCodeList = null;
		
		try{
			naicsCodeList = criteria.list();
			//tx.commit();
		}catch(Exception e){
			
			e.printStackTrace();
			
		}tx.commit();
		if(naicsCodeList.isEmpty()){
			
			return null;
			
		}else{
			
			return naicsCodeList.get(0);
		}
		
	}	

}
