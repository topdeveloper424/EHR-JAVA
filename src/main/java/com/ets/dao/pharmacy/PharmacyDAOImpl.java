package com.ets.dao.pharmacy;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.BodyZone;
import com.ets.model.Pharmacy;
import com.ets.model.SICCode;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyDAOImpl Class
 *Description: Pharmacy Entity DAO class
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
public class PharmacyDAOImpl implements PharmacyDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addPharmacy(Pharmacy pharmacy) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(pharmacy);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pharmacy> pharmacyList() {
		
	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Pharmacy.class);
		List<Pharmacy> pharmacyLists = null;
		try {
			pharmacyLists = criteria.list();
			   //tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return pharmacyLists;
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("name"));
		projectionList.add(Projections.property("city"));
		projectionList.add(Projections.property("state"));
		projectionList.add(Projections.property("telephone"));
		projectionList.add(Projections.property("fax"));

		criteria.setProjection(projectionList);
		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<Pharmacy> pharmacyLists = new ArrayList<Pharmacy>();

		for (Object obj[] : list) {

			Pharmacy pharmacy = new Pharmacy();
			pharmacy.setCode((String) obj[0]);
			pharmacy.setName((String) obj[1]);
			pharmacy.setCity((String) obj[2]);
			pharmacy.setTelephone((String) obj[3]);
			pharmacy.setState((String) obj[4]);
			pharmacy.setFax((String) obj[5]);

			pharmacyLists.add(pharmacy);

		}

		//tx.commit();

		return pharmacyLists;*/
	}
	
	@Override
	public List<Pharmacy> searchPharmacy(String phamacyName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Pharmacy.class)
							
							.add(Restrictions.ilike("name", phamacyName , MatchMode.END ));
							
		List<Pharmacy> pharmacyList = null;
		
		try {
			
			pharmacyList = criteria.list();
			
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
 }


		return pharmacyList;
	}

	/** This method update the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updatePharmacy(Pharmacy pharmacy) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.update(pharmacy);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public Pharmacy getByPharmacyID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Pharmacy pharmacy = null;
		try {
			pharmacy = (Pharmacy) session.get(Pharmacy.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return pharmacy;
		 }

	/** This method delete the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public void deletePharmacy(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//Pharmacy pharmacy = getByPharmacyID(id);
		try {
			Pharmacy pharmacy = (Pharmacy) session.get(Pharmacy.class, id);
		session.delete(pharmacy);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name , city , state
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public List<Pharmacy> searchPharmacy(String phamacyName , String city , String state) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Pharmacy.class)
							
							.add(Restrictions.ilike("name", phamacyName , MatchMode.END ))
							.add(Restrictions.ilike("city", city , MatchMode.END))
							.add(Restrictions.ilike("state", state , MatchMode.END));
		List<Pharmacy> pharmacyList = null;
		
		try {
			
			pharmacyList = criteria.list();
			
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
 }


		return pharmacyList;
	}

	@Override
	public List<Pharmacy> searchPharmacyUsingTabKey(String phamacyName) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Pharmacy.class)
							
							.add(Restrictions.ilike("name", phamacyName +"%" ));
							//.add(Restrictions.not(Restrictions.ilike("name", phamacyName +"%")));
		List<Pharmacy> pharmacyList = null;
		
		try {
			
			pharmacyList = criteria.list();
			
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

			
		return pharmacyList;
	}
}
