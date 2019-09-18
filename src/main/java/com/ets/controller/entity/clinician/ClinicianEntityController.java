package com.ets.controller.entity.clinician;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianEntityController Class
 *Description: Clinician Entity Non-GUI Controller class
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

import com.ets.model.Clinician;
import com.ets.model.Provider;
import com.ets.service.clinician.ClinicianServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClinicianEntityController {

	//private static ClassPathXmlApplicationContext context;
	private ClinicianServiceImpl clinicianServiceImpl;
	private ObservableList<Clinician> observableList;
	
	public ClinicianEntityController() {
    // context =new ClassPathXmlApplicationContext("spring.xml");
     clinicianServiceImpl = (ClinicianServiceImpl) Global.context.getBean("clinicianService");
     observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(Clinician clinician)
	{
		clinicianServiceImpl.saveOrUpdate(clinician);
		//context.close();
	}
	
	
	public ObservableList<Clinician> view(){
		
		observableList = FXCollections.observableArrayList(clinicianServiceImpl.view());
		//context.close();
		return observableList;
	}

       public void delete(Integer id)
       {
    	   clinicianServiceImpl.delete(id);
    	   //context.close();
       }
	
       public Clinician viewById(Integer id){
    	   
    	observableList = FXCollections.observableArrayList(clinicianServiceImpl.viewById(id));
   		//context.close();
   		return observableList.get(0);
    	   
       }
       public Clinician viewByCode(String code){
   		
   		observableList = FXCollections.observableArrayList(clinicianServiceImpl.viewByCode(code));
   		//context.close();
   		return observableList.get(0);
   		
   	}
}
