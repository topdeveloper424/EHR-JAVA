package com.ets.controller.entity.clinicianSchException;


import java.util.Date;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchExceptionEntityController Class
 *Description: ClinicianSchException Entity Non-GUI Controller class
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
import com.ets.model.ClinicianSchException;
import com.ets.model.ClinicianSchRecurException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;
import com.ets.service.clinicianSchException.ClinicianSchExceptionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClinicianSchExceptionEntityController {
    
	//private static ClassPathXmlApplicationContext context;
	private ClinicianSchExceptionServiceImpl clinicianSchExceptionServiceImpl;
	private ObservableList<ClinicianSchException>observableList;

	public ClinicianSchExceptionEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicianSchExceptionServiceImpl =  (ClinicianSchExceptionServiceImpl) Global.context.getBean("clinicianSchExceptionService");
		observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(List<ClinicianSchException> clinicianSchExceptions) {
		clinicianSchExceptionServiceImpl.saveOrUpdate(clinicianSchExceptions);
		//this.closeApplicationContext();

	}
	
	public void saveOrUpdateNoDuplicate(ClinicianSchException clinicianSchExceptions){
		
		clinicianSchExceptionServiceImpl.saveOrUpdateNoDuplicate(clinicianSchExceptions);
		//this.closeApplicationContext();
		
	}
	
	public ObservableList<ClinicianSchException> viewClinicianSchExceptionById(Clinician clinician,String stDate,String enDate)
	{
		observableList = FXCollections.observableArrayList(clinicianSchExceptionServiceImpl.viewProviderSchExcByIdAndDate(clinician, stDate, enDate));
		//this.closeApplicationContext();
		return observableList;
	}
	
	public void delete(Integer id){
		
		clinicianSchExceptionServiceImpl.delete(id);
		//this.closeApplicationContext();
	}
	
    public void deleteBetweenDates(Date st,Date end,Clinician clinician){
		
    	clinicianSchExceptionServiceImpl.deleteBetweenDates(st, end,clinician);
		//this.closeApplicationContext();
	}
}