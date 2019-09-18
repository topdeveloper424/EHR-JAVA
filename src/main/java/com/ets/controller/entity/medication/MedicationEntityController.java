package com.ets.controller.entity.medication;

import com.ets.model.AllergyCategory;
import com.ets.model.MedicalCondition;
import com.ets.model.Medication;
import com.ets.service.medicalcondition.MedicalConditionServiceImpl;
import com.ets.service.medication.MedicationServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 07-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicationEntityController Class
 *Description: Medication Entity Non-GUI Controller class
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public class MedicationEntityController {
	
	private static MedicationServiceImpl medicationServiceImpl;
	private ObservableList<Medication> medicationList;

	public MedicationEntityController() {
		
		medicationServiceImpl = (MedicationServiceImpl) Global.context.getBean("medicationService");
		medicationList = FXCollections.observableArrayList();
		
	}
	
	public void addOrUpdate(Medication medication){
		

		medicationServiceImpl.saveOrUpdate(medication);


		
	}
	
	
	public ObservableList< Medication> view(){
		

	medicationList = FXCollections.observableArrayList(medicationServiceImpl.view());


		
		return medicationList;
	}
	public  Medication searchByName(String medName) {

		medicationList = FXCollections.observableArrayList(medicationServiceImpl.searchByName(medName));

		return medicationList.get(0);
	}
	
	
	

}
