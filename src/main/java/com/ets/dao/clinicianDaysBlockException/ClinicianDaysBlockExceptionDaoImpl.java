package com.ets.dao.clinicianDaysBlockException;

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

import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockDayException;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;

@Repository
public class ClinicianDaysBlockExceptionDaoImpl  implements ClinicianDaysBlockExceptionDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(List<String> dateList,Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianBlockDayException> list=new ArrayList<ClinicianBlockDayException>();
		
		try {
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(0));
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(6));
			Criteria criteria = session.createCriteria(ClinicianBlockDayException.class);
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
                Date excDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateList.get(i));
             	System.out.println(excDate);
             	ClinicianBlockDayException clinicianBlockDayException = new ClinicianBlockDayException();
             	clinicianBlockDayException.setExcepDate(excDate);
             	clinicianBlockDayException.setClinician(clinician);
        		session.saveOrUpdate(clinicianBlockDayException);
			   
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
	public List<ClinicianBlockDayException> viewClinicianById(String excDateStartSt,String excDateendSt ,Clinician clinician) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicianBlockDayException> list=new ArrayList<ClinicianBlockDayException>();
		
		try {
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(excDateStartSt);
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(excDateStartSt);
			Criteria criteria = session.createCriteria(ClinicianBlockDayException.class);
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
	public void delete(String startDate, String endDate, Clinician clinician) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		try{
			Date excDateStart = new SimpleDateFormat("MM/dd/yyyy").parse(startDate);
			Date excDateend = new SimpleDateFormat("MM/dd/yyyy").parse(endDate);
			String hql="DELETE from ClinicianBlockDayException cs WHERE cs.excepDate>=:stD AND cs.excepDate<=:endD AND cs.clinician=:clinician";
			Query query =(Query) session.createQuery(hql);
			query.setInteger("clinician", clinician.getId());
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
