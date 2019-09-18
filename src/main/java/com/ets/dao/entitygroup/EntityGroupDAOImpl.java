package com.ets.dao.entitygroup;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.EntityGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntityGroupDAOImpl Class
 *Description: EntityGroup Entity DAO class
 *Copyright 2016 @Eclipse Techno Consulting Global Pvt. Ltd.

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
public class EntityGroupDAOImpl implements EntityGroupDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This method save Or update the EntityGroup objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param entityGroup
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	
	@Override
	public void addOrUpdate(EntityGroup entityGroup) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			session.saveOrUpdate(entityGroup);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

	/**
	 * This method gets all the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of entityGroup objects
	 */
	
	@Override
	public List<EntityGroup> view() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(EntityGroup.class);

		List<EntityGroup> entityGroupList = null;

		try {

			entityGroupList = criteria.list();
			//tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return entityGroupList;
	}
	
	/**
	 * This method gets the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of entityGroup objects
	 */

	@Override
	public EntityGroup getById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		EntityGroup entityGroup = null;
		try {

			entityGroup = (EntityGroup) session.get(EntityGroup.class, id);
			//tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return entityGroup;
	}

	/**
	 * This method delete the EntityGroup objects currently present in the system .
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

			EntityGroup entityGroup = (EntityGroup) session.get(EntityGroup.class, id);
			session.delete(entityGroup);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
