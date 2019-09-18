package com.ets.dao.departmentUnit;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;

/**
 * Original Author: Sumanta Deyahi on Behalf of ETS for Client Company File
 * Creation Date: 25-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnitDAOImpl Class Description:
 * DepartmentUnit Entity DAO class Copyright 2016 @Eclipse Technoconsulting
 * Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

@Repository
public class DepartmentUnitDAOImpl implements DepartmentUnitDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save the departmentUnit objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param departmentUnit
	 * @since 25-07-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */

	@Override
	public void add(DepartmentUnit departmentUnit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(departmentUnit);
		tx.commit();

	}

	/**
	 * This method gets all the DepartmentUnit objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 25-07-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DepartmentUnit objects
	 */
	@Override
	public List<DepartmentUnit> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DepartmentUnit.class);
		List<DepartmentUnit > departmentUnits = null;
		
		try{
			
			departmentUnits = criteria.list();
			//tx.commit();
			
		}catch(Exception e){
			
		}tx.commit();

		return departmentUnits;
	}

	/**
	 * This method gets all the DepartmentUnit objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 25-07-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DepartmentUnit objects
	 */
	@Override
	public DepartmentUnit getById(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		

		return (DepartmentUnit) session.get(DepartmentUnit.class, id);
		
	}

	/**
	 * This method update the departmentUnit objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param departmentUnit
	 * @since 25-07-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */

	@Override
	public void update(DepartmentUnit departmentUnit) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(departmentUnit);
		tx.commit();

	}

	/**
	 * This method Remove the departmentUnit objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 25-07-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		DepartmentUnit departmentUnit = getById(id);
		session.delete(departmentUnit);
		tx.commit();
	}

	@Override
	public DepartmentUnit viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DepartmentUnit.class);
		criteria.add(Restrictions.eq("code", code));
		List<DepartmentUnit> departmentUnitList = null;
		
		try{
			
			departmentUnitList = criteria.list();
			tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(departmentUnitList.isEmpty()){
			
			return null;
			
		}else{
			
			return departmentUnitList.get(0);
		}
	}

}
