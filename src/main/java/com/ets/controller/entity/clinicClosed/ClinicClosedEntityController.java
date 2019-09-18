package com.ets.controller.entity.clinicClosed;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Clinic;
import com.ets.model.ClinicClosed;
import com.ets.service.clinicClosed.ClinicClosedServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosedEntityController Class
 *Description: ClinicClosed Entity Non-GUI Controller class
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
public class ClinicClosedEntityController {

	//private ClassPathXmlApplicationContext context;
	private ClinicClosedServiceImpl clinicClosedServiceImpl;
	private ObservableList<ClinicClosed> observableList;

	public ClinicClosedEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicClosedServiceImpl = (ClinicClosedServiceImpl) Global.context.getBean("clinicClosedService");
		observableList = FXCollections.observableArrayList();
	}

	
	public void saveOrUpdate(ClinicClosed clinicClosed) {
		clinicClosedServiceImpl.saveOrUpdate(clinicClosed);
		//closeApplicationContext();

	}

	public void saveOrUpdateNoDuplicate(ClinicClosed clinicClosed) {
		clinicClosedServiceImpl.saveOrUpdateNoDuplicate(clinicClosed);
		//closeApplicationContext();
	}

	public void delete(Integer id) {

		clinicClosedServiceImpl.delete(id);
		//context.close();

	}

	public ObservableList<ClinicClosed> viewByDate(String str1 , String str2 , Integer cId){

		observableList = FXCollections.observableArrayList(clinicClosedServiceImpl.viewByDate(str1, str2, cId));

		//context.close();
		return observableList;

	}
	public void deleteByDate(Date date) {

		clinicClosedServiceImpl.deleteByDate(date);
		//context.close();

	}
}