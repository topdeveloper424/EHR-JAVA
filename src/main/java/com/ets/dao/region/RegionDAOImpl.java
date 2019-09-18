package com.ets.dao.region;

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
import com.ets.model.Complex;
import com.ets.model.Region;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RegionDAOImpl Class
 *Description: Region Entity DAO class
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
public class RegionDAOImpl implements RegionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addRegion(Region region) {

		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();

		try {
			session.saveOrUpdate(region);
			tx.commit();
		 } catch (HibernateException e) {
			 	//tx.rollback();
			 	e.printStackTrace();
		 } /*finally {
			   session.close();
		 }*/

	 }

	/** This method gets all the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Region objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Region> regionList() {

		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Region.class);
		List<Region> regionList = null;
		try {
			regionList = criteria.list();
			   //tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
		 } finally {
			   session.close();
		 }

		return regionList;

	}

	/** This method update the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateRegion(Region region) {

		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.update(region);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		}/*finally {
		    session.close();
		}*/

	}

	/** This method gets all the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Region objects
	 */
	@Override
	public Region getByRegionID(Integer id) {

		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Region region = null;
		try {
			region = (Region) session.get(Region.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		    e.printStackTrace();
		  } finally {
		    session.close();
		  }
		 return region;
	}

	/** This method delete the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteRegion(Integer id) {

		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//Region region = getByRegionID(id);
		try {
			Region region = (Region) session.get(Region.class, id);
			session.delete(region);
			tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
		}/* finally {
			   session.close();
		}*/

	}

	@Override
	public Region viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Region.class);
		criteria.add(Restrictions.eq("code", code));
		List<Region> regionList = null;
		
		try{
			
			regionList = criteria.list();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(regionList.isEmpty()){
			
			return null;
			
		}else{
			
			return regionList.get(0);
		}
	
	}

}