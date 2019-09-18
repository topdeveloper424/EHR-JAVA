package com.ets.controller.entity.clinicianSchedule;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianScheduleEntityController Class
 *Description: ClinicianSchedule Entity Non-GUI Controller class
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

import com.ets.model.ClinicianSchedule;
import com.ets.model.ProviderSchedule;
import com.ets.service.clinicianSchedule.ClinicianScheduleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClinicianScheduleEntityController {


	//private static ClassPathXmlApplicationContext context;
	private ClinicianScheduleServiceImpl clinicianScheduleServiceImpl;
	private ObservableList<ClinicianSchedule> observableList;

	public ClinicianScheduleEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		clinicianScheduleServiceImpl = (ClinicianScheduleServiceImpl) Global.context.getBean("clinicianScheduleService");
		observableList = FXCollections.observableArrayList();
	}



	
	   public void saveOrUpdate(ClinicianSchedule clinicianSchedule)
	   {
		   clinicianScheduleServiceImpl.saveOrUpdate(clinicianSchedule);
		  // CloseApplicationContext();
	   }
	   
	   public ObservableList<ClinicianSchedule> viewClinicianScheduleById(Integer id){
		 
		   observableList = FXCollections.observableArrayList(clinicianScheduleServiceImpl.viewClinicianScheduleId(id));
		//	this.CloseApplicationContext();
			return observableList;
		}
	   
	   public ObservableList<ClinicianSchedule> view(){
		   
		   observableList = FXCollections.observableArrayList(clinicianScheduleServiceImpl.view());
			//this.CloseApplicationContext();
			return observableList;
		   
	   }

}
