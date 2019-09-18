package com.ets.controller.entity.providerSchedule;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffScheduleEntityController Class
 *Description: ProviderSchedule Entity Non-GUI Controller class
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

import com.ets.model.ProviderSchedule;
import com.ets.service.providerSchedule.StaffScheduleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaffScheduleEntityController {
	
 // private static ClassPathXmlApplicationContext context;
  private StaffScheduleServiceImpl staffScheduleServiceImpl;
  private ObservableList<ProviderSchedule> observableList;
  
	public StaffScheduleEntityController() {
		//context= new ClassPathXmlApplicationContext("spring.xml");
	    staffScheduleServiceImpl =(StaffScheduleServiceImpl) Global.context.getBean("providerScheduleService");
	    observableList = FXCollections.observableArrayList();
	}

	
   public void saveOrUpdate(ProviderSchedule staffSchedule)
   {
	   staffScheduleServiceImpl.saveOrUpdate(staffSchedule);
	  // CloseApplicationContext();
   }
   
   public ObservableList<ProviderSchedule> viewProviderScheduleById(Integer id){
	 
	   observableList = FXCollections.observableArrayList(staffScheduleServiceImpl.viewProviderScheduleById(id));
	//	this.CloseApplicationContext();
		return observableList;
	}
   
   public ObservableList<ProviderSchedule> view(){
	   
	   observableList = FXCollections.observableArrayList(staffScheduleServiceImpl.view());
		//this.CloseApplicationContext();
		return observableList;
	   
   }
	   
   }
   


