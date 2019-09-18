package com.ets.controller.entity.clinicianSchRecurException;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchRecurExceptionEntityController Class
 *Description: ClinicianSchRecurException Entity Non-GUI Controller class
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

import com.ets.model.ClinicianSchRecurException;
import com.ets.service.clinicianSchRecurException.ClinicianSchRecurExceptionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClinicianSchRecurExceptionEntityController {
	//private static ClassPathXmlApplicationContext context;
	private ObservableList<ClinicianSchRecurException> observableList;
    private ClinicianSchRecurExceptionServiceImpl clinicianSchRecurExceptionServiceImpl;
	
	public ClinicianSchRecurExceptionEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicianSchRecurExceptionServiceImpl = (ClinicianSchRecurExceptionServiceImpl) Global.context
				.getBean("clinicianSchRecurExceptionService");
		observableList = FXCollections.observableArrayList();
	}

	
	public void saveOrUpdate(ClinicianSchRecurException clinicianSchRecurException) {
		clinicianSchRecurExceptionServiceImpl.saveOrUpdate(clinicianSchRecurException);
		//closeApplicationContext();
	}

	public ObservableList<ClinicianSchRecurException> viewClinicianSchRecurException() {
		observableList = FXCollections.observableArrayList(clinicianSchRecurExceptionServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;

	}

	public ObservableList<ClinicianSchRecurException> viewClinicianSchRecurExceptionById(Integer id) {
		observableList = FXCollections
				.observableArrayList(clinicianSchRecurExceptionServiceImpl.viewClinicianSchRecurExceptionById(id));
		//this.closeApplicationContext();
		return observableList;
	}


}
