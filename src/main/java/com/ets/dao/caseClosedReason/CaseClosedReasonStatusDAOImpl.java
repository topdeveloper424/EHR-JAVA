package com.ets.dao.caseClosedReason;



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
import com.ets.model.CaseClosedReason;
import com.ets.model.StateWorkArea;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonStatusDAOImpl Class
 *Description: CaseClosedReason Entity DAO class
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
public class CaseClosedReasonStatusDAOImpl implements CaseClosedReasonStatusDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method Save the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void addCaseClosedReason(CaseClosedReason caseClosedReason) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(caseClosedReason);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CaseClosedReason objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseClosedReason> caseClosedReasonList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CaseClosedReason.class);
		List<CaseClosedReason> caseClosedList = null;
		try {
			caseClosedList = criteria.list();
			  //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }			  
			  return caseClosedList;

		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<CaseClosedReason> closeReason = new ArrayList<CaseClosedReason>();
		for (Object obj[] : list) {
			CaseClosedReason caseReason = new CaseClosedReason();
			caseReason.setCode((String) obj[0]);
			caseReason.setDescrip((String) obj[1]);

			closeReason.add(caseReason);

		}

		tx.commit();
		
		return closeReason;*/
	}

	/** This method Update the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void updateCaseClosedReason(CaseClosedReason caseClosedReason) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(caseClosedReason);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CaseClosedReason objects
	 */
	@Override
	public CaseClosedReason getByCaseClosedReasonID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		CaseClosedReason caseClosedReason = null;
		try {
			caseClosedReason = (CaseClosedReason) session.get(CaseClosedReason.class, id);
		//trans.commit();
	  } catch (HibernateException e) {
	   e.printStackTrace();
	  } finally {
	   session.close(); 
	  }
	  return caseClosedReason;
	 }

	/** This method Delete the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void deleteCaseClosedReason(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//CaseClosedReason caseClosedReason = getByCaseClosedReasonID(id);
		try {
			CaseClosedReason caseClosedReason = (CaseClosedReason) session.get(CaseClosedReason.class, id);
		session.delete(caseClosedReason);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
