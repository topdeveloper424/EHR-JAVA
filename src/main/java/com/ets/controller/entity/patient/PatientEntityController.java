package com.ets.controller.entity.patient;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientEntityController Class
 *Description: Patient Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Patient;
import com.ets.service.patient.PatientServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientEntityController {

	//private ClassPathXmlApplicationContext context;
	private PatientServiceImpl patientServiceImpl;
	private ObservableList< Patient> observableList;

	public PatientEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		patientServiceImpl = (PatientServiceImpl) Global.context.getBean("patientService");
		observableList =FXCollections.observableArrayList();	
	}

	
	public void saveOrUpdate(Patient patient) {
		patientServiceImpl.saveOrupdate(patient);
		//closeApplicationContext();
	}

	public ObservableList<Patient> searchPatient(String firstName, String lastName, Date dob,Integer clinic) {
		System.out.println("####### date"+dob);
		observableList = FXCollections
				.observableArrayList(patientServiceImpl.searchPatientByName(firstName, lastName, dob,clinic));
		//this.closeApplicationContext();
		return observableList;
	}
	
	
	
	
	public ObservableList<Patient> search(Date date1, Date date2) {
		observableList = FXCollections.observableArrayList(patientServiceImpl.search(date1, date2));
		return observableList;
	}
	
	
	
	
	public ObservableList<Patient> view(Integer id){
		observableList = FXCollections
				.observableArrayList(patientServiceImpl.view(id));
		return observableList;
	}
	
	public Patient getById(Integer id){
		return patientServiceImpl.getById(id);
	}
	public Patient viewByPatientId(Integer id){
		
		observableList = FXCollections
				.observableArrayList(patientServiceImpl.viewByPatientId(id));
		return observableList.get(0);
	}
	
	public ObservableList<Patient> viewSortedPatients(String c)
	{
		observableList = FXCollections
				.observableArrayList(patientServiceImpl.viewSortedPatients(c));
		return observableList;
		
	}

	

}
