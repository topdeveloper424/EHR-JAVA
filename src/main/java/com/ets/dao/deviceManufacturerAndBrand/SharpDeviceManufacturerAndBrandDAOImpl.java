package com.ets.dao.deviceManufacturerAndBrand;



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
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.model.DeviceType;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceManufacturerAndBrandDAOImpl Class
 *Description: SharpDeviceManufacAndBrand Entity DAO class
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
public class SharpDeviceManufacturerAndBrandDAOImpl implements SharpDeviceManufacturerAndBrandDAO {
	
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/** This method save the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param brand
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void addSharpDeviceManufacturerAndBrand(DeviceManufacturerAndBrand manufacAndBrand) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(manufacAndBrand);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }


	/** This method gets all the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceManufacturerAndBrand objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceManufacturerAndBrand> sharpDeviceManufacAndBrandLists() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DeviceManufacturerAndBrand.class);
		List<DeviceManufacturerAndBrand> deviceManufacturerAndBrand = null;
		try {
			deviceManufacturerAndBrand = criteria.list();
			  // tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return deviceManufacturerAndBrand;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("mfd"));
		projectionList.add(Projections.property("brand"));
		
		criteria.add(Restrictions.eq("inactive", false));
		
		criteria.setProjection(projectionList);
		
		List<Object[]> list=criteria.list();
		
		List<SharpDeviceManufacAndBrand> manufacAndBrands=new ArrayList<SharpDeviceManufacAndBrand>();
		
		for(Object obj[]:list){
			
			SharpDeviceManufacAndBrand andBrand=new SharpDeviceManufacAndBrand();
			
			andBrand.setBrand((String) obj[0]);
			andBrand.setMfd((String) obj[1]);
			
			manufacAndBrands.add(andBrand);
						
		}
		
		//tx.commit();
		
		return manufacAndBrands;*/
	}


	/** This method update the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param brand
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void updateSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand) {
		
		Session session= this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(sharpDeviceManufacAndBrand);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}


	/** This method gets all the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceManufacturerAndBrand objects
	 */
	
	@Override
	public DeviceManufacturerAndBrand getBySharpDeviceManufacAndBrandID(Integer id) {
		
		Session session= this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = null;
		try {
			sharpDeviceManufacAndBrand = (DeviceManufacturerAndBrand) session.get(DeviceManufacturerAndBrand.class, id);
			// trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return sharpDeviceManufacAndBrand;
		 }


	/** This method remove the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void deleteSharpDeviceManufacAndBrand(Integer id) {
		
		Session session= this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = getBySharpDeviceManufacAndBrandID(id);
		try {
			DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = (DeviceManufacturerAndBrand) session.get(DeviceManufacturerAndBrand.class, id);
		session.delete(sharpDeviceManufacAndBrand);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	
	
}
