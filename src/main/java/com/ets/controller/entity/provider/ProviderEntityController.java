package com.ets.controller.entity.provider;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderEntityController Class
 *Description: Provider Entity Non-GUI Controller class
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

import com.ets.model.Provider;
import com.ets.service.provider.ProviderServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProviderEntityController {

	//private static ClassPathXmlApplicationContext context;
	private ProviderServiceImpl providerServiceImpl;
	private ObservableList<Provider> observableList;
	private ObservableList<String> observableListString;
	
	public ProviderEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		providerServiceImpl = (ProviderServiceImpl) Global.context.getBean("providerService");
		observableList = FXCollections.observableArrayList();
		observableListString = FXCollections.observableArrayList();
	}
	
	

	public void saveOrUpdate(Provider provider){
		
		providerServiceImpl.addOrUpdate(provider);
		//this.closeApplicationContext();
	}
	
	public ObservableList<Provider> view(){
		
		observableList = FXCollections.observableArrayList(providerServiceImpl.view());
		////this.closeApplicationContext();
		return observableList;
	}
	
	public ObservableList<Provider> viewByClinicId(Integer clinicId){
		
		observableList = FXCollections.observableArrayList(providerServiceImpl.viewByClinicId(clinicId));
		//this.closeApplicationContext();
		return observableList;
	}

	public void delete(Integer id)
	{
		providerServiceImpl.delete(id);
		//context.close();
	}

	public Provider viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(providerServiceImpl.viewByCode(code));
		//context.close();
		return observableList.get(0);
		
	}

    public Provider viewById(Integer id){
		
		observableList = FXCollections.observableArrayList(providerServiceImpl.viewById(id));
		//context.close();
		return observableList.get(0);
		
	}

}
