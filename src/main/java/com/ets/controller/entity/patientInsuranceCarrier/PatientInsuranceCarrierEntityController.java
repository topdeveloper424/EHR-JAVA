package com.ets.controller.entity.patientInsuranceCarrier;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierEntityController Class
 *Description: PatientInsuranceCarrier Entity Non-GUI Controller class
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.PatientAuthRep;
import com.ets.model.PatientInsuranceCarrier;
import com.ets.service.patientInsuranceCarrier.PatientInsuranceCarrierServieImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientInsuranceCarrierEntityController {

	//private static ClassPathXmlApplicationContext context;
	private PatientInsuranceCarrierServieImpl  patientInsuranceCarrierServieImpl;
	private ObservableList<PatientInsuranceCarrier> observableList;
	
	public PatientInsuranceCarrierEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		patientInsuranceCarrierServieImpl = (PatientInsuranceCarrierServieImpl) Global.context.getBean("patientInsuranceCarrierServie");
		observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(PatientInsuranceCarrier patientInsuranceCarrier){
		
		patientInsuranceCarrierServieImpl.saveOrUpdate(patientInsuranceCarrier);
		//context.close();
	}
	
	public ObservableList<PatientInsuranceCarrier> view()
	{
		observableList = FXCollections.observableArrayList(patientInsuranceCarrierServieImpl.view());
		//context.close();
	  return observableList;
	}
    
	public PatientInsuranceCarrier viewById(Integer id)
	{
		observableList = FXCollections.observableArrayList(patientInsuranceCarrierServieImpl.viewById(id));
		//context.close();
	  return observableList.get(0);
	
	}
	public void delete(Integer id){
		patientInsuranceCarrierServieImpl.delete(id);
		//context.close();
	}
	
}
