package com.ets.controller.entity.laboratory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Laboratory;
import com.ets.service.laboratory.LaboratoryServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LaboratoryEntityController Class
 *Description: Laboratory Entity Non-GUI Controller class
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
public class LaboratoryEntityController {

	//private static ClassPathXmlApplicationContext context;
	private LaboratoryServiceImpl laboratoryServiceImpl;
	private ObservableList<Laboratory> observableList;
	
	public LaboratoryEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		laboratoryServiceImpl = (LaboratoryServiceImpl) Global.context.getBean("laboratoryService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	public void saveOrUpdate(Laboratory laboratory){
		
		laboratoryServiceImpl.addOrUpdate(laboratory);
		///this.closeApplicationConrext();
		
	}
	
	public ObservableList<Laboratory> view(){
		
		observableList = FXCollections.observableArrayList(laboratoryServiceImpl.view());
		//this.closeApplicationConrext();
		return observableList;
	}
	
	public void delete(Integer id){
		
		laboratoryServiceImpl.delete(id);
		//context.close();
	}
	
	public Laboratory viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(laboratoryServiceImpl.viewByCode(code));
		return observableList.get(0); 
		
	}

}
