package com.ets.dao.clinicianBlockTime;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockTime;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianBlockTimeDAOImpl Class
 *Description: ClinicianBlockTime Entity DAO Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

@Repository
public class ClinicianBlockTimeDAOImpl implements ClinicianBlockTimeDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveOrUpdate(List<ClinicianBlockTime> clinicianBlockTimes) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		for(int i=0;i<clinicianBlockTimes.size();i++){
		try {
			session.saveOrUpdate(clinicianBlockTimes.get(i));
			
			if(i%10==0){
				session.flush();
				session.clear();
				
			}
			
		}
			 catch (HibernateException e) {
				   e.printStackTrace();
				   tx.rollback();
				  }
		}tx.commit();

}
	@Override
	public List<ClinicianBlockTime> viewByDate(List<Date> date,Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianBlockTime> list=null;
		
		try{
			String hql="SELECT ps from ClinicianBlockTime ps JOIN ps.clinician p WHERE ps.blockTimeDate IN(:date) AND p.id=:pid ORDER BY ps.blockTimeDate";
			Query query =(Query) session.createQuery(hql);
			query.setParameter("pid",clinician.getId());
			query.setParameterList("date", date);
			
			list=query.list();
			System.out.println("#!!!!!!!!!!!!!!!!!!!## "+list.size());
			tx.commit();
		  }catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		return list;
	}

	@Override
	public void delete(List<ClinicianBlockTime> clinicianBlockTimes) {
		
		Session session =sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
			if(clinicianBlockTimes!=null){
			
			for(int i=0;i<clinicianBlockTimes.size();i++){
				try{	
				session.delete(clinicianBlockTimes.get(i));
			   
				if(i%10==0){
					session.flush();
					session.clear();
				
			    }
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
			  }
		
			}tx.commit();
		
		
	

			}
}

	@Override
	public void deleteBlockTimeByDate(Date stD, Date enD, Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianBlockTime> list=null;
		
		try{
			String hql="DELETE from ClinicianBlockTime cs WHERE cs.blockTimeDate>=:stD AND cs.blockTimeDate<=:endD AND cs.clinician=:clinician";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("clinician", clinician.getId());
			query.setDate("stD", stD);
			query.setDate("endD", enD);
		    query.executeUpdate();
			
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		
	
		
	}
}
