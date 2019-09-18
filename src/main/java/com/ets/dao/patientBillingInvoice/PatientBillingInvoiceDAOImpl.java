package com.ets.dao.patientBillingInvoice;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.PatientAppointment;
import com.ets.model.PatientBillingInvoice;
import com.ets.utils.Global;


@Repository
public class PatientBillingInvoiceDAOImpl implements PatientBillingInvoiceDAO{
	
	 private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

	@Override
	public void saveOrUpdate(PatientBillingInvoice patientBillingInvoice) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(patientBillingInvoice);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
		
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoice() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientBillingInvoice.class);
		
		List<PatientBillingInvoice> patientBillingInvoiceList = null;
		try{
		
			patientBillingInvoiceList = criteria.list();
			tx.commit();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return patientBillingInvoiceList;
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndOverride(Date fromDate,
			Date toDate, String override) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		/*Criteria criteria=session.createCriteria(PatientBillingInvoice.class , "billingInvoice");
		 criteria.createAlias("billingInvoice.patientVisit", "patientBillVisit");
		 
		 criteria.createAlias("billingInvoice.patientVisit.patient", "patientBillInvoiceAlices");
		
		criteria.add(Restrictions.and(Restrictions.eq("patientBillInvoiceAlices.id", patientId),
				
			Restrictions.ge("billingInvoice.invoiceDate",fromDate),
       		 Restrictions.le("billingInvoice.invoiceDate", toDate),
       		 Restrictions.ilike("billingInvoice.invoiceType", override)));
		*/
		String hql = "FROM PatientBillingInvoice PBI WHERE PBI.invoiceType=:override AND PBI.invoiceDate BETWEEN :fromDate AND :toDate";
		
		
		Query query = session.createQuery(hql);
	    query.setString("override", override);
	    
	    query.setDate("fromDate", fromDate);
	    query.setDate("toDate", toDate);
		
		
		List<PatientBillingInvoice> patientBillingInvoiceList = null;
		
		try{
			patientBillingInvoiceList=query.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		return patientBillingInvoiceList;
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndPatient() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		/* Criteria criteria=session.createCriteria(PatientBillingInvoice.class , "billingInvoice");
		
		criteria.add(Restrictions.eq("billingInvoice.invoiceBatches", true));
	*/
		String hql = "FROM PatientBillingInvoice PB WHERE PB.invoiceBatches=:invoiceBatches";
		
		
		Query query = session.createQuery(hql);
	   
	    query.setBoolean("invoiceBatches", true);
	    
	   
		
		List<PatientBillingInvoice> patientBillingInvoiceList = null;
		
		try{
		patientBillingInvoiceList=query.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		return patientBillingInvoiceList;

}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDate(Date fromDate, Date toDate) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(PatientBillingInvoice.class , "billingInvoice");
		 
		 
		 criteria.createAlias("billingInvoice.patientVisit.patient", "patientBillInvoiceAlices");
		
		criteria.add(Restrictions.and(Restrictions.ge("billingInvoice.invoiceDate",fromDate),
       		 Restrictions.le("billingInvoice.invoiceDate", toDate)));
		
		List<PatientBillingInvoice> patientBillingInvoiceList = null;
		
		try{
			patientBillingInvoiceList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		return patientBillingInvoiceList;
	}
	
}
