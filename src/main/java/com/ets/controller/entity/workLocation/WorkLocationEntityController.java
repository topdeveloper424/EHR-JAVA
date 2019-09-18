package com.ets.controller.entity.workLocation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.WorkLocation;
import com.ets.service.workLocation.WorkLocationServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 26-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkLocationEntityController Class
 *Description: WorkLocation Entity Non-GUI Controller class
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

public class WorkLocationEntityController {

	//private static ClassPathXmlApplicationContext context;
	private WorkLocationServiceImpl workLocationServiceImpl;
	private ObservableList<WorkLocation> observableList;
	public WorkLocationEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		workLocationServiceImpl = (WorkLocationServiceImpl) Global.context.getBean("workLocationService");
		observableList = FXCollections.observableArrayList();
	}

	
	public void save(WorkLocation workLocation){
		workLocationServiceImpl.add(workLocation);
		//this.closeApplicationContext();
	}
	
	public ObservableList<WorkLocation> view(){
		
		observableList = FXCollections.observableArrayList(workLocationServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
				
	}
	
	public void delete(Integer id){
		
		workLocationServiceImpl.delete(id);
		//this.closeApplicationContext();
		
	}
}
