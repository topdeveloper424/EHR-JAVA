package com.ets.controller.entity.referalProvider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.ReferalProvider;
import com.ets.service.referalProvider.ReferalProviderServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReferalProviderEntityController Class
 *Description: ReferalProvider Entity Non-GUI Controller class
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
public class ReferalProviderEntityController {

	////private static ClassPathXmlApplicationContext context;
	private ReferalProviderServiceImpl referalProviderServiceImpl;
	private ObservableList<ReferalProvider> observableList;
	
	public ReferalProviderEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		referalProviderServiceImpl = (ReferalProviderServiceImpl) Global.context.getBean("referalProviderService");
		observableList = FXCollections.observableArrayList();
	}
	
	
	public void saveOrUpdate(ReferalProvider referalProvider){
		
		referalProviderServiceImpl.addOrUpdate(referalProvider);
		//this.closeApplicationContext();
	}
	
	public ObservableList<ReferalProvider> view(){
		
		observableList = FXCollections.observableArrayList(referalProviderServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	public void delete(Integer id)
	{
		referalProviderServiceImpl.delete(id);
	}
	
	public ReferalProvider viewById(Integer id){
		
		observableList = FXCollections.observableArrayList(referalProviderServiceImpl.viewById(id));
		return observableList.get(0);
		
	}
}
