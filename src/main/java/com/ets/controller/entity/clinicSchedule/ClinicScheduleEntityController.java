package com.ets.controller.entity.clinicSchedule;


import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicScheduleEntityController Class
 *Description: ClinicSchedule Entity Non-GUI Controller class
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

import com.ets.model.ClinicSchedule;
import com.ets.service.clinicSchedule.ClinicScheduleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClinicScheduleEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private ClinicScheduleServiceImpl clinicScheduleServiceImpl;
	
	private ObservableList<ClinicSchedule>  observableList;

	public ClinicScheduleEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicScheduleServiceImpl = (ClinicScheduleServiceImpl) Global.context.getBean("clinicScheduleService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public ObservableList<ClinicSchedule> view(){
		
		observableList = FXCollections.observableArrayList(clinicScheduleServiceImpl.view());
		//context.close();
		return observableList;
	}
	
	public void saveOrUpdate(ClinicSchedule clinicSchedule)
	{
		clinicScheduleServiceImpl.saveOrUpdate(clinicSchedule);
		//context.close();
	}
	
	public ObservableList<ClinicSchedule> viewClinicScheduleByClinicId(Integer cId){
		
		observableList = FXCollections.observableArrayList(clinicScheduleServiceImpl.viewClinicScheduleByClinicId(cId));
	//	context.close();
		return observableList;
		
	}

}
