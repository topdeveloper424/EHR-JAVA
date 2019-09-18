package com.ets.dao.severityCode;



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
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SeverityDAOImpl Class
 *Description: SeverityCode Entity DAO class
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
public class SeverityDAOImpl implements SeverityDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This methodsave the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSeverity(SeverityCode severityCode) {
		
		
		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
		session.save(severityCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SeverityCode objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SeverityCode> severityCodeLists() {
		
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(SeverityCode.class);
		List<SeverityCode> serverityList = null;
		try {
			serverityList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return serverityList;
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<SeverityCode> codes = new ArrayList<SeverityCode>();

		for (Object obj[] : list) {
			SeverityCode severityCode = new SeverityCode();
			severityCode.setCode((String) obj[0]);
			severityCode.setDescrip((String) obj[1]);

			codes.add(severityCode);
		}

		tx.commit();

		return codes;*/
	}

	/** This method update the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSeverityCode(SeverityCode severityCode) {
	
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(severityCode);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SeverityCode objects
	 */
	
	@Override
	public SeverityCode getBySeverityCodeID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		SeverityCode severityCode = null;
		try {
			severityCode = (SeverityCode) session.get(SeverityCode.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return severityCode;
		 }

	/** This method delete the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSeverityCode(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//SeverityCode severityCode=getBySeverityCodeID(id);
		try {
			SeverityCode severityCode = (SeverityCode) session.get(SeverityCode.class, id);
		session.delete(severityCode);
		   tx.commit();
			  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

}
