package com.ets.dao.reasonOrCause;

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
import com.ets.model.IncidentOrEvent;
import com.ets.model.ReasonOrCause;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReasonOrCauseDAOImpl Class
 *Description: ReasonOrCause Entity DAO class
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
public class ReasonOrCauseDAOImpl implements ReasonOrCauseDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param ReasonOrCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addReasonOrCause(ReasonOrCause reasonOrCause) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(reasonOrCause);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ReasonOrCause objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReasonOrCause> reasonCauseLists() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ReasonOrCause.class);
		
		List<ReasonOrCause> reasonOrCauseList = null;
		try {
			reasonOrCauseList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return reasonOrCauseList;
			  


		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<ReasonOrCause> orCauses = new ArrayList<ReasonOrCause>();

		for (Object obj[] : list) {

			ReasonOrCause cause = new ReasonOrCause();
			cause.setCode((String) obj[0]);
			cause.setDescrip((String) obj[1]);

			orCauses.add(cause);
		}

		tx.commit();

		return orCauses;*/
	}


	/** This method update the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param reasonOrCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateReasonOrCause(ReasonOrCause reasonOrCause) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(reasonOrCause);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ReasonOrCause objects
	 */
	@Override
	public ReasonOrCause getByReasonOrCauseID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		ReasonOrCause reasonOrCause = null;
		try {
			reasonOrCause = (ReasonOrCause) session.get(ReasonOrCause.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return reasonOrCause;
		 }

	/** This method delete the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteReasonOrCause(Integer id) {
	
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ReasonOrCause reasonOrCause = getByReasonOrCauseID(id);
		try {
			ReasonOrCause reasonOrCause = (ReasonOrCause) session.get(ReasonOrCause.class, id);
		session.delete(reasonOrCause);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
