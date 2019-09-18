package com.ets.controller.entity.patientAuthRep;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepEntityController Class
 *Description: PatientAuthRep Entity Non-GUI Controller class
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
import com.ets.model.Provider;
import com.ets.service.patientAuthRep.PatientAuthRepServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepEntityController Class
 *Description: PatientAuthRep Entity Non-GUI Controller class
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
public class PatientAuthRepEntityController {

	//private static ClassPathXmlApplicationContext context;
	private PatientAuthRepServiceImpl patientAuthRepServiceImpl;
	private ObservableList<PatientAuthRep> observableList;
	
	public PatientAuthRepEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		patientAuthRepServiceImpl = (PatientAuthRepServiceImpl) Global.context.getBean("patientAuthRepService");
		observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(PatientAuthRep patientAuthRep){
		
		patientAuthRepServiceImpl.saveOrUpdate(patientAuthRep);
		//context.close();
	}
	
	public ObservableList<PatientAuthRep> view(){
	 
		observableList = FXCollections.observableArrayList(patientAuthRepServiceImpl.view());
		//context.close();
	  
	return observableList;
	
	}
	public PatientAuthRep viewById(Integer id){
	
		observableList= FXCollections.observableArrayList(patientAuthRepServiceImpl.viewById(id));
		//context.close();
	return observableList.get(0);
	}
	public void delete(Integer id){
		patientAuthRepServiceImpl.delete(id);
		//context.close();
	}
	
	
	}
	



