package com.ets.controller.entity.patientBillingInvoice;

import java.util.Date;
import java.util.List;

import com.ets.model.PatientBillingInvoice;
import com.ets.service.patientBillingInvoice.PatientBillingInvoiceServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientBillingInvoiceEntityController {

	private PatientBillingInvoiceServiceImpl patientBillingInvoiceServiceImpl;
	private ObservableList<PatientBillingInvoice> observableList;

	public PatientBillingInvoiceEntityController() {

		patientBillingInvoiceServiceImpl = (PatientBillingInvoiceServiceImpl) Global.context
				.getBean("patientBillingInvoiceService");
		observableList = FXCollections.observableArrayList();

	}

	public void saveOrUpdate(PatientBillingInvoice patientBillingInvoice) {

		patientBillingInvoiceServiceImpl.saveOrUpdate(patientBillingInvoice);

	}

	public ObservableList<PatientBillingInvoice> view() {

		observableList = FXCollections
				.observableArrayList(patientBillingInvoiceServiceImpl.viewPatientBillingInvoice());

		return observableList;

	}
	
	public ObservableList<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndOverride(Date fromDate,
			Date toDate, String Override){
		
		observableList = FXCollections
				.observableArrayList(patientBillingInvoiceServiceImpl.viewPatientBillingInvoiceByDateAndOverride(fromDate, toDate, Override));
		
		return observableList;
		
	}
	
	public ObservableList<PatientBillingInvoice> viewPatientBillingInvoiceByDateAndPatient(){
		
		observableList = FXCollections
				.observableArrayList(patientBillingInvoiceServiceImpl.viewPatientBillingInvoiceByDateAndPatient());
		
		return observableList;
		
	}
	
public ObservableList<PatientBillingInvoice> viewPatientBillingInvoiceByDate(Date fromDate, Date toDate){
		
		observableList = FXCollections
				.observableArrayList(patientBillingInvoiceServiceImpl.viewPatientBillingInvoiceByDate(fromDate, toDate));
		
		
		return observableList;
		
	}

}
