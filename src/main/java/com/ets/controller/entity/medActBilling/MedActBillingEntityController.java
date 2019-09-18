package com.ets.controller.entity.medActBilling;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.MedActBilling;
import com.ets.service.medActBilling.MedActBillingServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 31-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActBillingEntityController Class
 *Description: MedActBilling Entity Non-GUI Controller class
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

public class MedActBillingEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private MedActBillingServiceImpl medActBillingServiceImpl;
	private ObservableList< MedActBilling> observableList;
	
	public MedActBillingEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		medActBillingServiceImpl = (MedActBillingServiceImpl) Global.context.getBean("medActBillingService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the medActBilling objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medActBilling
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void saveOrUpdate(MedActBilling medActBilling){
		
		medActBillingServiceImpl.addOrUpdate(medActBilling);
		//this.closeApplicationConrext();
	}
	

}
