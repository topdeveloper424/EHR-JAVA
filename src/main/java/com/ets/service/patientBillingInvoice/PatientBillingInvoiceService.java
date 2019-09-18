package com.ets.service.patientBillingInvoice;

import java.util.Date;
import java.util.List;

import com.ets.model.PatientBillingInvoice;

public interface PatientBillingInvoiceService {

	public void saveOrUpdate(PatientBillingInvoice patientBillingInvoice);

	public List<PatientBillingInvoice> viewPatientBillingInvoice();
	
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndOverride(Date fromDate,Date toDate,String Override);
	
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndPatient();
	
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDate(Date fromDate,Date toDate); 

}
