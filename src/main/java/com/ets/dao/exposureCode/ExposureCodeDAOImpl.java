package com.ets.dao.exposureCode;

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

import com.ets.model.BodyPart;
import com.ets.model.ExposureCode;
import com.ets.model.IllnessCode;
import com.ets.model.InjuryCode;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExposureCodeDAOImpl Class
 *Description: ExposureCode Entity DAO class
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
public class ExposureCodeDAOImpl implements ExposureCodeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addExposureCode(ExposureCode exposureCode) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(exposureCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
		}
	

	/** This method gets all the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ExposureCode objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExposureCode> exposureCodeList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ExposureCode.class);
		List<ExposureCode> exposureList = null; 
		try {
			exposureList = criteria.list();
			  // tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return exposureList;
			  
			 }
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		projectionList.add(Projections.property("type"));

		criteria.setProjection(projectionList);

		List<Object[]> list = criteria.list();

		List<ExposureCode> exposureCodeLists = new ArrayList<ExposureCode>();

		for (Object obj[] : list) {

			ExposureCode exposure = new ExposureCode();

			exposure.setCode((String) obj[0]);
			exposure.setDescrip((String) obj[1]);
			exposure.setType((String) obj[2]);

			exposureCodeLists.add(exposure);
		}

		tx.commit();

		return exposureCodeLists;*/
	

	/** This method update the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void updateExposureCode(ExposureCode exposureCode) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(exposureCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ExposureCode objects
	 */
	
	@Override
	public ExposureCode getByExposureCodeID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		ExposureCode exposureCode = null;
		try {
			exposureCode = (ExposureCode) session.get(ExposureCode.class, id);
			  // trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return exposureCode;
		 }

	/** This method delete the exposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void deleteExposureCode(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ExposureCode exposureCode=getByExposureCodeID(id);
		try {
			ExposureCode exposureCode = (ExposureCode) session.get(ExposureCode.class, id);		
		session.delete(exposureCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

}
