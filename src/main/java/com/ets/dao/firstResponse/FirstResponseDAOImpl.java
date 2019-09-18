package com.ets.dao.firstResponse;



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
import com.ets.model.FirstResponse;
import com.ets.model.SeverityCode;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FirstResponseDAOImpl Class
 *Description: FirstResponse Entity DAO class
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
public class FirstResponseDAOImpl implements FirstResponseDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addFirstResponse(FirstResponse firstResponse) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(firstResponse);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }
	

	/** This method gets all the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of FirstResponse objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FirstResponse> firstResponseList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(FirstResponse.class);
		List<FirstResponse> firstResponseList = null;
		try {
			firstResponseList = criteria.list();
			  // tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			   return firstResponseList;
			  	
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<FirstResponse> firstResponse = new ArrayList<FirstResponse>();
		for (Object obj[] : list) {
			FirstResponse first = new FirstResponse();
			first.setCode((String) obj[0]);
			first.setDescrip((String) obj[1]);

			firstResponse.add(first);

		}

		tx.commit();

		return firstResponse;*/
	}

	/** This method update the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void updateFirstResponse(FirstResponse firstResponse) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(firstResponse);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of FirstResponse objects
	 */
	@Override
	public FirstResponse getbyFirstResponseID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		FirstResponse firstResponse = null;
		try {
			firstResponse = (FirstResponse) session.get(FirstResponse.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return firstResponse;
		 }

	/** This method delete the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void dleteFirstResponse(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//FirstResponse firstResponse = getbyFirstResponseID(id);
		 try {
			 FirstResponse firstResponse = (FirstResponse) session.get(FirstResponse.class, id);
		session.delete(firstResponse);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
