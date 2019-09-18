package com.ets.controller.entity.patientVisit;

import java.util.Date;
import java.util.List;

import com.ets.controller.gui.patient.PatientViewController;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;
import com.ets.service.patientVisit.PatientVisitServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;



public class PatientVisitEntityController {
	
	private PatientVisitServiceImpl patientVisitServiceImpl;
	private ObservableList<PatientVisit> observableList;

	public PatientVisitEntityController() {
		
		patientVisitServiceImpl = (PatientVisitServiceImpl) Global.context.getBean("patientVisitService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	
	
	
	public ObservableList<PatientVisit> searchPatient(Date fromDate, Date toDate, Integer Id) {
			observableList = FXCollections.observableArrayList(patientVisitServiceImpl.searchPatient(fromDate,toDate,Id ));
			return observableList;
	}
	
	
	
	
	public void saveOrUpdate(PatientVisit patientVisit){
		
		patientVisitServiceImpl.saveOrUpdate(patientVisit);
		
	}
	public ObservableList<PatientVisit> viewPatientList() {
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl
				.view());
		
	return	observableList;
		
	}
	
	
	public ObservableList<PatientVisit> viewByDate(Date fromDate, Date toDate) {
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByDate(fromDate, toDate));

		return observableList;

	}

	public ObservableList<PatientVisit> viewByDateOne(Date fromDate) {
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByDateOne(fromDate));

		return observableList;

	}

	public ObservableList<PatientVisit> viewByPat(Integer patId) {
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByPat(patId));

		return observableList;

	}
	
	public ObservableList<PatientVisit> viewByDate(Date date){
		
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByDate(date));

		return observableList;
		
	}
	
	public PatientVisit ViewByNameAndDate(String firstName , String latName , String inTime){
		
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.ViewByNameAndDate(firstName, latName, inTime));

		return observableList.get(0);
		
	}	
	
	public void delete(Integer id){
		
		patientVisitServiceImpl.delete(id);
		
	}
	
	public PatientVisit viewByPatientVisitId(Integer id){
		
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByPatientVisitId(id));

		return observableList.get(0);
		
	}
	
	
	
	

	public ObservableList<PatientVisit> viewBypatIdAndVDate(Integer patId, Date visitDate){
		
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewBypatIdAndVDate(patId, visitDate));

		return observableList;
		
	}
    public void delete(PatientVisit patientVisit){
		
		patientVisitServiceImpl.delete(patientVisit.getId());
		
	}
  public ObservableList<PatientVisit> viewByProtocolId(Integer protocolId){
		
		observableList = FXCollections.observableArrayList(patientVisitServiceImpl.viewByProtocolId(protocolId));

		return observableList;
		
	}
  public void setProtocolId(Integer protocolId){
		
		patientVisitServiceImpl.setProtocol(protocolId);
		
	}
}