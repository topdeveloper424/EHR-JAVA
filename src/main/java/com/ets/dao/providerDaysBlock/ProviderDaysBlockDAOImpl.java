package com.ets.dao.providerDaysBlock;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;
@Repository
public class ProviderDaysBlockDAOImpl implements ProviderDaysBlockDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<ProviderDaysBlockTime> providerDaysBlockTimes) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderBlockTime> list=null;
		
		
             	for(int i=0;i<providerDaysBlockTimes.size();i++){
				try{	
					session.saveOrUpdate(providerDaysBlockTimes.get(i));
			   
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
	public List<ProviderDaysBlockTime> getProviderDaysBlockTimes(Provider providerId, String weekDay) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderDaysBlockTime> list=null;
		Criteria criteria = session.createCriteria(ProviderDaysBlockTime.class);
		try{
			criteria.add(Restrictions.eq("provider", providerId)).add(Restrictions.eq("weekday", weekDay));
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
	public void DeleteBlocks(List<ProviderDaysBlockTime> providerDaysBlockTimes) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderDaysBlockTime> list=null;
			
			try{
				for(int i=0;i<providerDaysBlockTimes.size();i++){
				session.delete(providerDaysBlockTimes.get(i));
		   
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
	public List<ProviderDaysBlockTime> viewProviderById(Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderDaysBlockTime> list=null;
		Criteria criteria = session.createCriteria(ProviderDaysBlockTime.class);
		try{
			list = criteria.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}
}