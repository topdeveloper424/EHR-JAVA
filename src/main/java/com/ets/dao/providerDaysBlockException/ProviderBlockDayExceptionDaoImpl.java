package com.ets.dao.providerDaysBlockException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;

@Repository
public class ProviderBlockDayExceptionDaoImpl implements ProviderBlockDayExceptionDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<String> dateList,Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderBlockDayException> list=new ArrayList<ProviderBlockDayException>();
		
		try {
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(0));
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(6));
			Criteria criteria = session.createCriteria(ProviderBlockDayException.class);
			criteria.add(Restrictions.between("excepDate", excDateStart, excDateend));
			list = criteria.list();
			
			tx.commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          if(list.size()==0){
	        	  session = sessionFactory.getCurrentSession();
	              tx = session.beginTransaction();
             	for(int i=0;i<dateList.size();i++){
             	try{
             	
             	System.out.println(dateList.get(i));
             	Date excDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(i));
             	System.out.println(excDate);
             	ProviderBlockDayException blockDayException = new ProviderBlockDayException();
             	blockDayException.setExcepDate(excDate);
             	blockDayException.setProvider(provider);
        		session.saveOrUpdate(blockDayException);
			   
				    if(i%10==0){
					session.flush();
					session.clear();
					
			    }
			
			
		  }catch(Exception ex)
		    {
			ex.printStackTrace();
			tx.rollback();
		    }
		
			}tx.commit();
		
	     }
	}

	@Override
	public List<ProviderBlockDayException> viewProviderById(String excDateStartSt,String excDateendSt ,Provider provider) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ProviderBlockDayException> list=new ArrayList<ProviderBlockDayException>();
		
		try {
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(excDateStartSt);
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(excDateStartSt);
			Criteria criteria = session.createCriteria(ProviderBlockDayException.class);
			criteria.add(Restrictions.between("excepDate", excDateStart, excDateend));
			list = criteria.list();
		
	 }catch(Exception ex)
	    {
		ex.printStackTrace();
		tx.rollback();
	    }tx.commit();
	

	    return list;

}

	@Override
	public void delete(String startDate, String endDate, Provider provider) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		try{
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(startDate);
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(endDate);
			String hql="DELETE from ProviderBlockDayException cs WHERE cs.excepDate>=:stD AND cs.excepDate<=:endD AND cs.provider=:provider";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("provider", provider.getId());
			query.setDate("stD", excDateStart);
			query.setDate("endD", excDateend);
		    query.executeUpdate();
			
			tx.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
		}
	}
}
