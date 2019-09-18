package com.ets.controller.entity.jobClass;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.JobClass;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.jobClass.JobClassServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 01-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of JobClassEntityController Class
 *Description: JobClass Entity Non-GUI Controller class
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

public class JobClassEntityController {

	//private static ClassPathXmlApplicationContext context;
	private JobClassServiceImpl jobClassServiceImpl;
	private ObservableList<JobClass> observableList;
	
	public JobClassEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");

		jobClassServiceImpl =  (JobClassServiceImpl) Global.context.getBean("jobClassService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	
	public void saveOrUpdate(JobClass jobClass){
		
		jobClassServiceImpl.addorUpdate(jobClass);
		//this.closeApplicationConrext();
	}
	
	public ObservableList<JobClass> view(){
		
		observableList = FXCollections.observableArrayList(jobClassServiceImpl.view());
		//this.closeApplicationConrext();
		return observableList;
	}
	
	public void delete(Integer id){
		jobClassServiceImpl.delete(id);
	}
	
	public JobClass viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(jobClassServiceImpl.viewByCode(code));
		return observableList.get(0); 
		
	}

}
