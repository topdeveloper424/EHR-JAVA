package com.ets.controller.entity.providerSchRecurException;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchRecurExceptionEntityController Class
 *Description: ProviderSchRecurException Entity Non-GUI Controller class
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

import com.ets.model.ProviderSchRecurException;
import com.ets.service.providerSchRecurException.StaffSchRecurExceptionServiceImpl;
import com.ets.utils.Global;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaffSchRecurExceptionEntityController {

	private StaffSchRecurExceptionServiceImpl staffSchRecurExceptionServiceImpl;
	//private ClassPathXmlApplicationContext context;
	private ObservableList<ProviderSchRecurException> observableList;

	public StaffSchRecurExceptionEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		staffSchRecurExceptionServiceImpl = (StaffSchRecurExceptionServiceImpl) Global.context
				.getBean("providerSchRecurExceptionService");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(ProviderSchRecurException staffSchRecurException) {
		staffSchRecurExceptionServiceImpl.saveOrUpdate(staffSchRecurException);
		//closeApplicationContext();
	
	}

	public ObservableList<ProviderSchRecurException> viewStaffSchRecurException() {
		observableList = FXCollections.observableArrayList(staffSchRecurExceptionServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;

	}

	public ObservableList<ProviderSchRecurException> viewStaffSchRecurExcById(Integer Id) {
		observableList = FXCollections
				.observableArrayList(staffSchRecurExceptionServiceImpl.viewStaffSchRecurExceptionById(Id));
		//this.closeApplicationContext();
		return observableList;
	}
	public ObservableList<ProviderSchRecurException> viewStaffSchRecurExcByProviderId(Integer Id) {
		observableList = FXCollections
				.observableArrayList(staffSchRecurExceptionServiceImpl.viewStaffSchRecurExceptionByProviderId(Id));
		//this.closeApplicationContext();
		return observableList;
	}
	public ObservableList<ProviderSchRecurException> viewStaffSchRecurExcByClinicianId(Integer Id) {
	
		observableList = FXCollections
				.observableArrayList(staffSchRecurExceptionServiceImpl.viewStaffSchRecurExceptionByClinicianId(Id));
		//this.closeApplicationContext();
		return observableList;
	}
	
	public void delete(Integer id) {
		staffSchRecurExceptionServiceImpl.delete(id);
		//closeApplicationContext();
	
	}

}
