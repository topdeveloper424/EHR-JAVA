package com.ets.controller.entity.medicationClass;

import com.ets.model.Medication;
import com.ets.model.MedicationClass;
import com.ets.service.medicationClass.MedicationClassService;
import com.ets.service.medicationClass.MedicationClassServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicationClassEntityController {

	
	private MedicationClassServiceImpl medicationClassServiceImpl;

	public void setMedicationClassServiceImpl(MedicationClassServiceImpl medicationClassServiceImpl) {
		this.medicationClassServiceImpl = medicationClassServiceImpl;
	}
	private ObservableList<MedicationClass> observableList;

	public MedicationClassEntityController() {

		
		medicationClassServiceImpl = (MedicationClassServiceImpl) Global.context.getBean("medicationClassService");
		observableList = FXCollections.observableArrayList();

	}public void addOrUpdate(MedicationClass medicationClass) {

		medicationClassServiceImpl.add(medicationClass);;
		

	}
	public ObservableList<MedicationClass> view() {

		observableList = FXCollections.observableArrayList(medicationClassServiceImpl.list());
		
		return observableList;

	}
	public  MedicationClass getByName(String name) {

		observableList = FXCollections.observableArrayList(medicationClassServiceImpl.getByName(name));
		
		return observableList.get(0);
	}
	
	
}
