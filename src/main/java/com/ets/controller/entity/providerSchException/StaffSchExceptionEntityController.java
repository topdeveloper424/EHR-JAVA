package com.ets.controller.entity.providerSchException;

import java.util.Date;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchExceptionEntityController Class
 *Description: ProviderSchException Entity Non-GUI Controller class
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
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;
import com.ets.service.providerSchException.StaffSchExceptionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaffSchExceptionEntityController {

	//private static ClassPathXmlApplicationContext context;
	private StaffSchExceptionServiceImpl staffSchExceptionServiceImpl;
	private ObservableList<ProviderSchException>observableList;
	
	public StaffSchExceptionEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		staffSchExceptionServiceImpl = (StaffSchExceptionServiceImpl) Global.context.getBean("providerSchExceptionService");
		observableList = FXCollections.observableArrayList();
	}

	
	public void saveOrUpdate(List<ProviderSchException> staffSchException) {
		staffSchExceptionServiceImpl.saveOrUpdate(staffSchException);
		//this.closeApplicationContext();

	}
	
	public void saveOrUpdateNoDuplicate(ProviderSchException staffSchException){
		
		staffSchExceptionServiceImpl.saveOrUpdateNoDuplicate(staffSchException);
		//this.closeApplicationContext();
		
	}
	
	public ObservableList<ProviderSchException> viewProviderSchExceptionById(Provider provider,String stDate,String enDate)
	{
		observableList = FXCollections.observableArrayList(staffSchExceptionServiceImpl.viewProviderSchExceptionBetweenDateById(provider, stDate, enDate));
		//this.closeApplicationContext();
		return observableList;
	}
	
	public void delete(Integer id){
		
		staffSchExceptionServiceImpl.delete(id);
		//this.closeApplicationContext();
	}
	
    public void deleteBetweenDates(Date st,Date end,Provider provider){
		
		staffSchExceptionServiceImpl.deleteBetweenDates(st, end,provider);
		//this.closeApplicationContext();
	}
	
}
