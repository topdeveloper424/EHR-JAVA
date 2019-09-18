package com.ets.dao.providerBlockTime;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffBlockTimeDAOImpl Class
 *Description: ProviderBlockTime Entity DAO class
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.utils.Global;

@Repository
public class StaffBlockTimeDAOImpl implements StaffBlockTimeDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<ProviderBlockTime> staffBlockTime) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		for(int i=0;i<staffBlockTime.size();i++){
		try {
			session.saveOrUpdate(staffBlockTime.get(i));
			
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
	public List<ProviderBlockTime> viewByDate(List<Date> date,Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderBlockTime> list=null;
		
		try{
			String hql="SELECT ps from ProviderBlockTime ps JOIN ps.provider p WHERE ps.blockTimeDate IN(:date) AND p.id=:pid ORDER BY ps.blockTimeDate";
			Query query =(Query) session.createQuery(hql);
			query.setParameter("pid",provider.getId());
			query.setParameterList("date", date);
			
			list=query.list();
			tx.commit();
		  }catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		return list;
	}

	@Override
	public void delete(List<ProviderBlockTime> proBlockScheduleId) {
		
		Session session =sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
			if(proBlockScheduleId!=null){
			
			for(int i=0;i<proBlockScheduleId.size();i++){
				try{	
				session.delete(proBlockScheduleId.get(i));
			   
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
	public void deleteBlockTimeByDate(Date stD, Date enD, Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicBlockSchedule> list=null;
		
		try{
			String hql="DELETE from ProviderBlockTime cs WHERE cs.blockTimeDate>=:stD AND cs.blockTimeDate<=:endD AND cs.provider=:provider";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("provider", provider.getId());
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
