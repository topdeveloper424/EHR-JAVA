package com.ets.dao.deviceType;

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
import com.ets.model.DeviceType;
import com.ets.model.SeverityCode;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceDAOImpl Class
 *Description: SharpDevice Entity DAO class
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
public class SharpDeviceDAOImpl implements SharpDeviceDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the sharpDevice objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addSharpDevice(DeviceType sharpDevice) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(sharpDevice);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceType objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> sharpDeviceList() {
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DeviceType.class);
		
		List<DeviceType> devieTypeList = null;
		try {
			devieTypeList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }			  
			  return devieTypeList;
			  
		
		/*ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("descrip"));
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("inactive", false));

		List<Object[]> list = criteria.list();

		List<SharpDevice> sharp = new ArrayList<SharpDevice>();

		for (Object obj[] : list) {

			SharpDevice device = new SharpDevice();
			device.setCode((String) obj[0]);
			device.setDescrip((String) obj[1]);

			sharp.add(device);
		}

		tx.commit();

		return sharp;*/

	}

	/** This method update the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSharpDevice(DeviceType sharpDevice) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
		session.update(sharpDevice);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceType objects
	 */
	@Override
	public DeviceType getBySharpDeviceID(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		DeviceType sharpDevice = null;
		try {
			sharpDevice = (DeviceType) session.get(DeviceType.class, id);
			 //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return sharpDevice;
		 }

	/** This method delete the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void deleteSharpDevice(Integer id) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//DeviceType sharpDevice = getBySharpDeviceID(id);
		try {
			DeviceType sharpDevice = (DeviceType) session.get(DeviceType.class, id);
		    session.delete(sharpDevice);
		    tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }	

}
