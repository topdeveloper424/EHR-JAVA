package com.ets.controller.entity.medActResultCode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.MedActResultCode;
import com.ets.service.medActResultCode.MedActResultCodeServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActResultCodeEntityController Class
 *Description: MedActResultCode Entity Non-GUI Controller class
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
public class MedActResultCodeEntityController {

	//private static ClassPathXmlApplicationContext context;
	private MedActResultCodeServiceImpl medActResultCodeServiceImpl;
	private ObservableList< MedActResultCode> observableList;
	
	public MedActResultCodeEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		medActResultCodeServiceImpl = (MedActResultCodeServiceImpl) Global.context.getBean("medActResultCodeService");
		observableList = FXCollections.observableArrayList();
		
	}
	

	public void saveOrUpdate(MedActResultCode medActResultCode){
		
		medActResultCodeServiceImpl.addOrUpdate(medActResultCode);
		//this.closeApplicationConrext();
		
	}

}
