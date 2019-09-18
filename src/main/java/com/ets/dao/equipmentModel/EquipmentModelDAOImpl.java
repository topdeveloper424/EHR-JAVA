package com.ets.dao.equipmentModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.EquipmentModel;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EquipmentModelDAOImpl Class
 *Description: EquipmentModel Entity DAO class
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
public class EquipmentModelDAOImpl implements EquipmentModelDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param equipmentModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(EquipmentModel equipmentModel) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(equipmentModel);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the EquipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of EquipmentModel objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentModel> list() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(EquipmentModel.class);

		List<EquipmentModel> equipmentModelList = null;
		try {
			equipmentModelList = criteria.list();
			 //tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return equipmentModelList;
	}

	/** This method update the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param equipmentModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(EquipmentModel equipmentModel) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(equipmentModel);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the EquipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of EquipmentModel objects
	 */
	@Override
	public EquipmentModel getByID(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		EquipmentModel equipmentModel = null;
		try {
			equipmentModel = (EquipmentModel) session.get(EquipmentModel.class, id);
			//trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return equipmentModel;
	}

	/** This method delete the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of equipmentModel objects
	 */
	
	@Override
	public void delete(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			EquipmentModel equipmentModel = (EquipmentModel) session.get(EquipmentModel.class, id);
			session.delete(equipmentModel);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
