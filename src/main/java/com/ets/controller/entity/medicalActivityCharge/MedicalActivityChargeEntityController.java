package com.ets.controller.entity.medicalActivityCharge;

import java.util.Date;

import com.ets.model.Clinic;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.Patient;
import com.ets.model.PatientVisit;
import com.ets.service.medicalActivityCharge.MedicalActivityChargeServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicalActivityChargeEntityController {
	// private static ClassPathXmlApplicationContext context;

	private MedicalActivityChargeServiceImpl medicalActivityChargeServiceImpl;

	private ObservableList<MedicalActivityCharge> observableList;

	public MedicalActivityChargeEntityController() {

		// context = new ClassPathXmlApplicationContext("spring.xml");

		medicalActivityChargeServiceImpl = (MedicalActivityChargeServiceImpl) Global.context
				.getBean("medicalActivityChargeService");

		observableList = FXCollections.observableArrayList();

	}

	public ObservableList<MedicalActivityCharge> viewMedical() {

		observableList = FXCollections.observableArrayList(medicalActivityChargeServiceImpl.list());

		// this.closeApplicationConrext();
		return observableList;

	}

	/*
	 * public void removeMedical(Integer id){
	 * 
	 * medicalActivityChargeServiceImpl.delete(id);
	 * //this.closeApplicationConrext(); }
	 */

	public void saveOrUpdate(MedicalActivityCharge medicalActivityCharge) {
		medicalActivityChargeServiceImpl.saveOrUpdate(medicalActivityCharge);
		// this.closeApplicationContext();
	}

	/*
	 * public ObservableList<MedicalActivityCharge> viewMedicalActivityCharge() {
	 * 
	 * observableList = FXCollections
	 * .observableArrayList(medicalActivityChargeServiceImpl.
	 * viewMedicalActivityCharge()); //this.closeApplicationContext(); return
	 * observableList; }
	 */

	public ObservableList<MedicalActivityCharge> viewMedicalActivityCharge(Integer id, Boolean checkBillingStatus) {

		observableList = FXCollections.observableArrayList(
				medicalActivityChargeServiceImpl.viewMedicalActivityCharge(id, checkBillingStatus));
		// this.closeApplicationContext();
		return observableList;
	}

	public void delete(Integer id) {
		medicalActivityChargeServiceImpl.delete(id);
		// this.closeApplicationContext();
	}

	/*
	 * public void delete(MedicalActivityCharge medicalActivityCharge) {
	 * medicalActivityChargeServiceImpl.delete(medicalActivityCharge);
	 * //this.closeApplicationContext(); }
	 */

	public ObservableList<MedicalActivityCharge> viewByMedicalActivityId(Integer id) {

		observableList = FXCollections
				.observableArrayList(medicalActivityChargeServiceImpl.viewByMedicalActivityId(id));
		// this.closeApplicationContext();
		return observableList;
	}

	public ObservableList<MedicalActivityCharge> searchByDateAndOverride(Date fromDate, Date toDate, String Override) {

		observableList = FXCollections.observableArrayList(
				medicalActivityChargeServiceImpl.searchByDateAndOverride(fromDate, toDate, Override));
		return observableList;
	}

	public MedicalActivityCharge searchForDrugScreen(Date date, String medicalActivityCode, PatientVisit patientVisit) {

		observableList = FXCollections.observableArrayList(
				medicalActivityChargeServiceImpl.searchForDrugScreen(date, medicalActivityCode, patientVisit));
		return observableList.get(0);
	}

	public ObservableList<MedicalActivityCharge> searchByDatePatientBillingStatus(Date date) {

		observableList = FXCollections
				.observableArrayList(medicalActivityChargeServiceImpl.searchByDatePatientBillingStatus(date));
		return observableList;
	}

	public ObservableList<MedicalActivityCharge> searchByPatientVisit(Integer patientVisit) {

		observableList = FXCollections
				.observableArrayList(medicalActivityChargeServiceImpl.searchByPatientVisit(patientVisit));
		return observableList;
	}

	public ObservableList<MedicalActivityCharge> searchByPatient(Integer patient) {

		observableList = FXCollections
				.observableArrayList(medicalActivityChargeServiceImpl.searchByPatient(patient));
		return observableList;
	}

	
	public Double getTotalChargeForPatVisit(Integer patVisitId) {
		return medicalActivityChargeServiceImpl.getTotalChargeForPatVisit(patVisitId);
		// this.closeApplicationContext();
	}
}
