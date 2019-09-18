package com.ets.dao.clinicBlockSchedule;

import java.util.Date;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ets.model.ClinicBlockSchedule;
import com.ets.utils.Global;

@Repository
public class ClinicBlockScheduleDAOImpl implements ClinicBlockScheduleDAO {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveOrUpdate(List<ClinicBlockSchedule> clinicBlockSchedules) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<clinicBlockSchedules.size();i++){
		try {
			session.saveOrUpdate(clinicBlockSchedules.get(i));
			
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
	public List<ClinicBlockSchedule> viewByDate(List<Date> date) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ClinicBlockSchedule> list=null;
		
		try{
			String hql="SELECT cs from ClinicBlockSchedule cs JOIN cs.clinic c WHERE cs.blockTimeDate IN(:date) AND c.id=:cid ORDER BY cs.blockTimeDate";
			Query query =(Query) session.createQuery(hql);
			query.setParameter("cid", Global.clinic.getId());
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
	public void delete(List<ClinicBlockSchedule> clinicBlockScheduleId) {
		
		Session session =sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
			if(clinicBlockScheduleId!=null){
			
			for(int i=0;i<clinicBlockScheduleId.size();i++){
				try{	
				session.delete(clinicBlockScheduleId.get(i));
				
				
				if(i%10==0){
					session.flush();
					session.clear();
					
				
			}}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
			  }
		
				}tx.commit();
		
		
	

			}
}
}