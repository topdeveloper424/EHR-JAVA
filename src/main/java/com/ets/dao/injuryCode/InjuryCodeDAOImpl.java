package com.ets.dao.injuryCode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;





import com.ets.model.BodyZone;
import com.ets.model.Company;
import com.ets.model.InjuryCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeDAOImpl Class
 *Description: InjuryCode Entity DAO class
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
public class InjuryCodeDAOImpl implements InjuryCodeDAO {
	private static final Logger logger = LoggerFactory.getLogger(InjuryCodeDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method Save the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addInjuryCode(InjuryCode injuryCode) {
		
		System.out.println("Print addInjuryCode");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(injuryCode);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
		}
	
	/** This method gets all the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of InjuryCode objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<InjuryCode> injuryCodeList() {
		
		System.out.println("Print injuryCodeList");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(InjuryCode.class);
		
		List<InjuryCode> injuryList = null;
		try {
			injuryList = criteria.list();
			 //tx.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  
		  return injuryList;
		  
			 
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		projectionList.add(Projections.property("type"));

		criteria.setProjection(projectionList);

		List<Object[]> list = criteria.list();

		List<InjuryCode> injuryCodeLists = new ArrayList<InjuryCode>();

		for (Object obj[] : list) {

			InjuryCode injury = new InjuryCode();

			injury.setCode((String) obj[0]);
			injury.setDescrip((String) obj[1]);
			injury.setType((String) obj[2]);

			injuryCodeLists.add(injury);
		}

		//tx.commit();

		return injuryCodeLists;*/
	}

	/** This method Update the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void updateInjuryCode(InjuryCode injuryCode) {
		
		System.out.println("Print updateInjuryCode");
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		try {
		session.update(injuryCode);
		trans.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of InjuryCode objects
	 */
	@Override
	public InjuryCode getbyInjuryID(Integer id) {
		
		System.out.println("Print getbyInjuryID");
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		InjuryCode injuryCode = null;
		try {
			injuryCode = (InjuryCode) session.get(InjuryCode.class, id);
			//trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return injuryCode;
		 }

	/** This method Delete the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteInjuryCode(Integer id) {
				
		Session session = this.sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		//InjuryCode injuryCode=getbyInjuryID(id);
		try {
			InjuryCode injuryCode = (InjuryCode)session.get(InjuryCode.class, id); 
		session.delete(injuryCode);
		tx.commit();
			  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

}
