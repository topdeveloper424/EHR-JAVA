package com.ets.dao.role;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Role;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RoleDAOImpl Class
 *Description: Role Entity DAO class
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
public class RoleDAOImpl implements RoleDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the Role objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param role
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(Role role) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.saveOrUpdate(role);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */

	@Override
	public List<Role> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Role.class);
		
		List<Role> roleList = null;
		try {

			roleList = criteria.list();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return roleList;
		
	}

	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */

	@Override
	public Role getById(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Role role = null;
		try {

			role = (Role) session.get(Role.class, id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return role;
	}

	/**
	 * This method delete the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void delete(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

			Role role = (Role) session.get(Role.class, id);
			session.delete(role);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	/**
	 * This method gets  the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */


	@Override
	public Role viewByName(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<Role> roleList = null;
		try{
			
			roleList = criteria.list();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		if(roleList.isEmpty()){
			
			return null;
			
		}else{
			
			return (Role) roleList.get(0);
			
		}
		
	}

	@Override
	public List<String> roleName() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.setProjection(Projections.property("name"));
		List<String> roleList = null;
		try {

			roleList = criteria.list();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return roleList;
		
	}

}
