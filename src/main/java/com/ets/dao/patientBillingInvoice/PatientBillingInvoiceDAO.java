package com.ets.dao.patientBillingInvoice;

import java.util.Date;
import java.util.List;

import com.ets.model.PatientBillingInvoice;

public interface PatientBillingInvoiceDAO {
	
	public void saveOrUpdate(PatientBillingInvoice patientBillingInvoice);
	
	public List<PatientBillingInvoice> viewPatientBillingInvoice();
	
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndOverride(Date fromDate,Date toDate,String Override);
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndPatient();
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDate(Date fromDate,Date toDate);

}
