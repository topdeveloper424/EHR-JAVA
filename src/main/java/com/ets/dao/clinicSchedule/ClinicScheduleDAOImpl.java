package com.ets.dao.clinicSchedule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicSchedule;
import com.ets.model.ProviderSchedule;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicScheduleDAOImpl Class
 *Description: Implementation class for ClinicScheduleDAO Class
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
public class ClinicScheduleDAOImpl implements ClinicScheduleDAO {

	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<ClinicSchedule> view() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicSchedule> clinicSchedules = null;

		try{

			Criteria criteria = session.createCriteria(ClinicSchedule.class);
			clinicSchedules = criteria.list();
			tx.commit();

		}catch(Exception e){
			e.printStackTrace();
		}
		return clinicSchedules;
	}


	@Override
	public void saveOrUpdate(ClinicSchedule clinicSchedule) {
		Session session=sessionFactory.getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(clinicSchedule);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		tx.commit();
	}


	@Override
	public List<ClinicSchedule> viewClinicScheduleByClinicId(Integer cId) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
      Criteria criteria= session.createCriteria(ClinicSchedule.class );

      List<ClinicSchedule> clinicScheduleList = null;

      //criteria.createAlias("provider", "p");

        try {

			 criteria.add(Restrictions.eq("clinic.id", cId));
			 clinicScheduleList = criteria.list();
        	//criteria.add(Restrictions.eq("p.id", id));
        	//criteria.add(Restrictions.eqProperty("", ""));
			 tx.commit();

		} catch (HibernateException e) {
		    e.printStackTrace();
		    tx.rollback();
		}


		return clinicScheduleList;
	}




}
