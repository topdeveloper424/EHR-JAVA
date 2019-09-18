package com.ets.dao.clinicianDaysBlockTime;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Clinician;
import com.ets.model.ClinicianDaysBlockTime;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;
@Repository
public class ClinicianDaysBlockTimeDaoImpl implements ClinicianDaysBlockTimeDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianDaysBlockTime> list=null;
		
		
             	for(int i=0;i<clinicianDaysBlockTimes.size();i++){
				try{	
					session.saveOrUpdate(clinicianDaysBlockTimes.get(i));
			   
				    if(i%10==0){
					session.flush();
					session.clear();
					
			    }
			
			
			/*String hql="SELECT pbs from ProviderDaysBlockTime pbs JOIN pbs.provider p WHERE p.id =:pid AND pbs.weekday=:weekday AND ";
			
			Query query =(Query) session.createQuery(hql);
			query.setInteger("pid",providerDaysBlockTimes.get(0).getId());
			query.setString("weekday", providerDaysBlockTimes.get(0).getWeekday());
			
			list=query.list();*/
			
		  }catch(Exception ex)
		    {
			ex.printStackTrace();
			tx.rollback();
		    }
		
			}tx.commit();
		
		}

	@Override
	public List<ClinicianDaysBlockTime> getClinicianDaysBlockTime(Clinician clinician, String weekDay) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianDaysBlockTime> list=null;
		Criteria criteria = session.createCriteria(ClinicianDaysBlockTime.class);
		try{
			criteria.add(Restrictions.eq("clinician", clinician)).add(Restrictions.eq("weekday", weekDay));
			list=criteria.list();
			tx.commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	
	}

	@Override
	public void DeleteBlocks(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianDaysBlockTime> list=null;
			
			try{
				for(int i=0;i<clinicianDaysBlockTimes.size();i++){
				session.delete(clinicianDaysBlockTimes.get(i));
		   
			    if(i%10==0){
				session.flush();
				session.clear();
				
		        }
				}tx.commit();
	     	}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		
         	}
	}

	@Override
	public List<ClinicianDaysBlockTime> viewProviderById(Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianDaysBlockTime> list=null;
		Criteria criteria = session.createCriteria(ClinicianDaysBlockTime.class);
		criteria.add(Restrictions.eq("clinician", clinician));
		try{
			list = criteria.list();
			System.out.println("@@@@@@@@@@@@@@@@@##### "+list.size());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}
}