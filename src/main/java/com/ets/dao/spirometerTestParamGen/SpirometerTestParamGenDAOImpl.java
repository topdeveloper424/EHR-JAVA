package com.ets.dao.spirometerTestParamGen;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.SpirometerTestParamGen;
/**
 *Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company
 *File Creation Date: 22-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of spirometerTestParamGen Class
 *Description: spirometerTestParamGen Interface Class
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

public class SpirometerTestParamGenDAOImpl implements SpirometerTestParamGenDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveSpirometerTestParamGen(SpirometerTestParamGen spirometerTestParamGen) {

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(spirometerTestParamGen);
			transaction.commit();
		} catch (HibernateException e) {
			// tx.rollback();
			e.printStackTrace();
		}

	}

}
