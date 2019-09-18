package com.ets.service.patientBillingInvoice;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientBillingInvoice.PatientBillingInvoiceDAO;
import com.ets.model.PatientBillingInvoice;

import javafx.fxml.Initializable;

@Service
@Transactional
public class PatientBillingInvoiceServiceImpl implements PatientBillingInvoiceService{
	
	private PatientBillingInvoiceDAO patientBillingInvoiceDAO;

	public void setPatientBillingInvoiceDAO(PatientBillingInvoiceDAO patientBillingInvoiceDAO) {
		this.patientBillingInvoiceDAO = patientBillingInvoiceDAO;
	}

	@Override
	public void saveOrUpdate(PatientBillingInvoice patientBillingInvoice) {
		
		patientBillingInvoiceDAO.saveOrUpdate(patientBillingInvoice);
		
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoice() {
		
		return patientBillingInvoiceDAO.viewPatientBillingInvoice();
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndOverride(Date fromDate,
			Date toDate, String Override) {
		
		return patientBillingInvoiceDAO.viewPatientBillingInvoiceByDateAndOverride(fromDate, toDate, Override);
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndPatient() {
		
		return patientBillingInvoiceDAO.viewPatientBillingInvoiceByDateAndPatient();
	}

	@Override
	public List<PatientBillingInvoice> viewPatientBillingInvoiceByDate(Date fromDate, Date toDate) {
		
		return patientBillingInvoiceDAO.viewPatientBillingInvoiceByDate(fromDate, toDate);
	}

	

}
