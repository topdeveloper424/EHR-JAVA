package com.ets.dao.deviceModel;

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

import com.ets.model.BodyPart;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.model.DeviceModel;
import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceModelDAOImpl Class
 *Description: SharpDeviceModel Entity DAO class
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
public class SharpDeviceModelDAOImpl implements SharpDeviceModelDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/** This method save the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDeviceModel
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addSharpDeviceModel(DeviceModel sharpDeviceModel) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(sharpDeviceModel);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }


	/** This method gets all the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceModel objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceModel> sharpDeviceModelList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DeviceModel.class);
		
		List<DeviceModel> deviceModelList = null;
		try {
			deviceModelList = criteria.list();
			   //tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return deviceModelList;
			  
		
		/*criteria.setProjection(Projections.property("descrip"));
		
		criteria.add(Restrictions.eq("inactive", false));
		
		//List<Object[]> list=criteria.list();
		
		List<String> list=criteria.list();
		
		List<SharpDeviceModel> sharpDeviceModels=new ArrayList<SharpDeviceModel>();
		
		for(Object obj:list){
			SharpDeviceModel sharpModel=new SharpDeviceModel();
			sharpModel.setDescrip((String) obj);
			
			sharpDeviceModels.add(sharpModel);
		}
		
		tx.commit();
		
		return sharpDeviceModels;*/
		//return criteria.list();
	
		}


	/** This method update the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDeviceModel
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSharpDeviceModel(DeviceModel sharpDeviceModel) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
		session.update(sharpDeviceModel);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
			 }


	/** This method gets all the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceModel objects
	 */
	@Override
	public DeviceModel getBySharpDeviceModelID(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		DeviceModel sharpDeviceModel = null;
		  try {
			  sharpDeviceModel = (DeviceModel) session.get(DeviceModel.class, id);
			   //trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return sharpDeviceModel;
		 }


	/** This method delete the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void deleteSharpDeviceModel(Integer id) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//DeviceModel sharpDeviceModel = getBySharpDeviceModelID(id);
		try {
			DeviceModel sharpDeviceModel = (DeviceModel) session.get(DeviceModel.class, id);
		session.delete(sharpDeviceModel);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

}
