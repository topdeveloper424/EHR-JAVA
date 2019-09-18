package com.ets.dao.patientAppointment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientAppointment;
import com.ets.model.Provider;
import com.ets.utils.Global;

@Repository
public class PatientAppointmentDAOImpl implements PatientAppointmentDAO {
   

    private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(PatientAppointment patientAppointment) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(patientAppointment);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
	}

	@Override
	public List<PatientAppointment> viewByDate(Date date) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientAppointment.class);
		criteria.add(Restrictions.eq("apptDate", date));
		List<PatientAppointment> patientAppointmentList = null;
		try{
		
			patientAppointmentList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientAppointmentList;
	}

	@Override
    public List<PatientAppointment> viewById(Integer patentId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql="SELECT p FROM PatientAppointment p WHERE p.patient=:patentId AND p.visitingStatus=:status";
	    Query query=session.createQuery(hql);
	    query.setInteger("patentId", patentId);
	    query.setBoolean("status", false);
		
		/*Criteria criteria=session.createCriteria(PatientAppointment.class);
		
		 criteria.add(Restrictions.and(Restrictions.eq("patient.id", patentId),
				 Restrictions.or(Restrictions.eq("visitingStatus", null),Restrictions.eq("visitingStatus", false))));

*/		
		
		List<PatientAppointment> patientAppointmentList = null;
		
		try{
			
			patientAppointmentList = query.list();
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientAppointmentList;
	}
		

	public List<PatientAppointment> viewByProiderAndDate(Date date, Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> plist=null;
		try{
			Criteria criteria=session.createCriteria(PatientAppointment.class);
			criteria.add(Restrictions.eq("apptDate" ,date)).add(Restrictions.eq("provider.id", id));
			plist=criteria.list();
			tx.commit();
		}catch(Exception e){
				
		e.printStackTrace();
		
		}
		
		return  plist;

	}

	@Override
	public List<PatientAppointment> viewByNameAndDate(String firstName, String lastName, Date date) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
		criteria.createAlias("patentAppt.provider", "patentProvider");
		criteria.add(Restrictions.eq("patentProvider.firstName" ,firstName)).
		add(Restrictions.eq("patentProvider.lastName", lastName)).
		add(Restrictions.eq("apptDate", date)).
		add(Restrictions.eq("patentProvider.clinic.id", Global.clinic.getId()));
		
		try{
			patientViewList=criteria.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;
	}

	@Override
	public List<PatientAppointment> viewByNameDateProviderId(String firstName, String lastName, Date date,
			String purpose) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
		criteria.createAlias("patentAppt.patient", "patients");
		criteria.createAlias("patients.patientName", "patName");
		criteria.add(Restrictions.eq("patentAppt.purpose" ,purpose)).
		add(Restrictions.eq("patentAppt.apptDate", date)).
		add(Restrictions.eq("patName.firstName", firstName)).
		add(Restrictions.eq("patName.lastName", lastName)).
		add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
		
		try{
			patientViewList=criteria.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;
	}

	@Override
	public List<PatientAppointment> viewByNameDateProviderAndTime(Date date,
			String time, String providerCode) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
		criteria.createAlias("patentAppt.patient", "patients");
		criteria.createAlias("patentAppt.provider", "providerModel");
		criteria.createAlias("patients.patientName", "patName").
		add(Restrictions.eq("patentAppt.apptTime", time)).
		add(Restrictions.eq("patentAppt.apptDate", date)).
		
		add(Restrictions.eq("providerModel.code", providerCode)).
		add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
		
		try{
			patientViewList=criteria.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;
	}

	@Override
	public List<PatientAppointment> viewByNameDateProviderPurpose(String firstName, String lastName, Date date,
			String purpose, String providerFirst,String providerLast, String status) {

		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
	
		criteria.createAlias("patentAppt.patient", "patients");
		criteria.createAlias("patentAppt.provider", "providerModel");
		criteria.createAlias("patients.patientName", "patName").
		
		add(Restrictions.eq("patName.firstName", firstName)).
		add(Restrictions.eq("patName.lastName", lastName)).
		add(Restrictions.eq("patentAppt.apptDate", date)).
		add(Restrictions.eq("patentAppt.purpose" ,purpose)).
		
		add(Restrictions.eq("providerModel.firstName", providerFirst)).
		add(Restrictions.eq("providerModel.lastName", providerLast)).
		add(Restrictions.eq("patentAppt.status", status)).
		
		add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
		
		try{
			patientViewList=criteria.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;

	
	}

	@Override
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		PatientAppointment patientAppointment = (PatientAppointment) session.get(PatientAppointment.class, id);
		try{
			session.delete(patientAppointment);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
		
	}

	@Override
	public List<PatientAppointment> viewByBothProvider(String firstName, String lastName, String firstName1,
			String lastName1, Date date) {

		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		//List<PatientAppointment>	patApp = null;
		try{
			
			
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
		
		// criteria.addOrder(Order.asc("apptTime"));
		/*
		 patApp =criteria.list();
		 
		 for (PatientAppointment patientAppointment : patApp) {
			 SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			 Date date11=format.parse(patApp.get(0).getApptTime());
			
		}
		 */
		
		criteria.createAlias("patentAppt.patient", "patients");
		//criteria.createAlias("patentAppt.apptTime", "aptTime");
		//c.addOrder(Order.asc("motherKind.value"));
		
		criteria.createAlias("patentAppt.provider", "providerModel").
		add(Restrictions.eq("patentAppt.apptDate", date))
		.add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
	//	criteria.addOrder(to_timestamp(appt_time,'HH:MI AM')));
		
	
		
		
	/*	add(Restrictions.eq("patentAppt.apptDate", date)).
		
		
		.add(Restrictions.or(((Restrictions.eq("providerModel.firstName", firstName)).
		and(Restrictions.eq("providerModel.lastName", lastName))),
		add(Restrictions.eq("providerModel.firstName", firstName1)).
		add(Restrictions.eq("providerModel.lastName", lastName1))))
		.
		
		add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
		
		
		*/
		
		
		Criterion firstProvider = 
	    Restrictions.conjunction().add(Restrictions.eq("providerModel.firstName", firstName))
	                              .add(Restrictions.eq("providerModel.lastName", lastName));

		Criterion secondProvider = 
			    Restrictions.conjunction().add(Restrictions.eq("providerModel.firstName", firstName1))
			                              .add(Restrictions.eq("providerModel.lastName", lastName1));

		
		Criterion completeCondition = 
	    Restrictions.disjunction().add(firstProvider)
	                              .add(secondProvider);
		criteria.add(completeCondition);                       
		
		
			patientViewList=criteria.list();
			
			
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;

	
	}

	@Override
	public List<PatientAppointment> viewByProvider(String firstName, String lastname) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<PatientAppointment> patientViewList=null;
		Criteria criteria=session.createCriteria(PatientAppointment.class , "patentAppt");
	
		criteria.createAlias("patentAppt.patient", "patients");
		criteria.createAlias("patentAppt.provider", "providerModel").
		
		add(Restrictions.eq("providerModel.firstName", firstName)).
		add(Restrictions.eq("providerModel.lastName", lastname)).
		
		
		add(Restrictions.eq("patients.clinic.id", Global.clinic.getId()));
		
		try{
			patientViewList=criteria.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return patientViewList;
	}

}
