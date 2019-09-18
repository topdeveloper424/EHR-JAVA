package com.ets.dao.illnessCode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.ets.model.BodyZone;
import com.ets.model.IllnessCode;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IllnessCodeDAOImpl Class
 *Description: IllnessCode Entity DAO class
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
public class IllnessCodeDAOImpl implements IllnessCodeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIllnessCode(IllnessCode illnessCode) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(illnessCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IllnessCode objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IllnessCode> illnessCodeList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(IllnessCode.class);
		List<IllnessCode> illnessList = null;
		try {
			illnessList = criteria.list();
			//tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return illnessList;
			  
	
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		projectionList.add(Projections.property("type"));

		criteria.setProjection(projectionList);

		List<Object[]> list = criteria.list();

		List<IllnessCode> IllnessCodeLists = new ArrayList<IllnessCode>();

		for (Object obj[] : list) {

			IllnessCode illness = new IllnessCode();

			illness.setCode((String) obj[0]);
			illness.setDescrip((String) obj[1]);
			illness.setType((String) obj[2]);

			IllnessCodeLists.add(illness);
		}

		tx.commit();

		return IllnessCodeLists;*/
	}

	/** This method update the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateIllnessCode(IllnessCode illnessCode) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(illnessCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IllnessCode objects
	 */
	@Override
	public IllnessCode getByIllnessCodeID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		IllnessCode illnessCode = null;
		try {
		//session.close();
			illnessCode = (IllnessCode) session.get(IllnessCode.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return illnessCode;
		 }

	/** This method delete the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteIllnessCode(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//IllnessCode illnessCode=getByIllnessCodeID(id);
		try {
			IllnessCode illnessCode = (IllnessCode) session.get(IllnessCode.class, id);
		session.delete(illnessCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

}
