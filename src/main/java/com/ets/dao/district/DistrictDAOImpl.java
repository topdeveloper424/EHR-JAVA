package com.ets.dao.district;


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
import com.ets.model.District;
import com.ets.model.SeverityCode;
import com.ets.model.UserLogin;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DistrictDAOImpl Class
 *Description: District Entity DAO class
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
public class DistrictDAOImpl implements DistrictDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param district
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	
	@Override
	public void addDistrict(District district) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(district);
		tx.commit();
		 } catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<District> districtList() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(District.class);
		List<District> districtList = null;
		try {
			districtList = criteria.list();
			  // tx.commit();
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
			  
			  return districtList;
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("code"));
		projectionList.add(Projections.property("name"));
		
		criteria.setProjection(projectionList);
		
		List<Object []> list=criteria.list();
		
		List<District> districtLists=new ArrayList<District>();
		
		for(Object obj[]:list){
			
			District district=new District();
			
			district.setCode((String) obj[0]);
			district.setName((String) obj[1]);
			
			districtLists.add(district);
		}
		
		//tx.commit();
		
		return districtLists;*/
	}

	/** This method update the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param district
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateDistrict(District district) {
		
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
		session.update(district);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	
	@Override
	public District getByDistrictID(Integer id) {
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		District district = null;
		try {
			district = (District) session.get(District.class, id);
			// trans.commit();
		  } catch (HibernateException e) {
		   e.printStackTrace();
		  } finally {
		   session.close(); 
		  }
		  return district;
		 }

	/** This method delete the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteDistrict(Integer id) {
	
		
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		//District district = getByDistrictID(id);
		try {
			District district = (District) session.get(District.class, id);
		session.delete(district);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/* finally {
			   session.close(); 
			  }*/
			 }

	
	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public District getDistrictByName(String name) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria criteria = (Criteria) session.createCriteria(District.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<District> districtList = new ArrayList<District>();
		
		try {
			
			districtList =  criteria.list();
			//tx.commit();
			   
		  } catch (HibernateException e) {
			   e.printStackTrace();
		  } finally {
			   session.close(); 
		  }
		
		return districtList.get(0);
		
	}

	@Override
	public District viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(District.class);
		criteria.add(Restrictions.eq("code", code));
		List<District> districtList = null;
		
		try{
			
			districtList = criteria.list();
			//tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(districtList.isEmpty()){
			
			return null;
			
		}else{
			
			return districtList.get(0);
		}
	
	}
	

}
