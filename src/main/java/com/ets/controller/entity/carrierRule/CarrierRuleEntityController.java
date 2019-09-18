package com.ets.controller.entity.carrierRule;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.CarrierRule;
import com.ets.service.carrierRule.CarrierRuleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierRuleEntityController Class
 *Description: CarrierRule Entity Non-GUI Controller class
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
public class CarrierRuleEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private CarrierRuleServiceImpl carrierRuleServiceImpl;
	private ObservableList<CarrierRule> observableList;
	
	public CarrierRuleEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		carrierRuleServiceImpl = (CarrierRuleServiceImpl) Global.context.getBean("carrierRuleService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	
	public void addOrUpdate(CarrierRule carrierRule){
		
		carrierRuleServiceImpl.addOrUpdate(carrierRule);
		//this.closeApplicationConrext();
	}
	
	public ObservableList<CarrierRule> view(){
		
		observableList = FXCollections.observableArrayList(carrierRuleServiceImpl.view());
		//this.closeApplicationConrext();
		return observableList;
	}
	
	

}
