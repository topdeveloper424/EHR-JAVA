package com.ets.controller.entity.medActSurvelRule;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.MedActSurvelRule;
import com.ets.service.medActSurvelRule.MedActSurvelRuleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActSurvelRuleEntityController Class
 *Description: MedActSurvelRule Entity Non-GUI Controller class
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
public class MedActSurvelRuleEntityController {

//	private static ClassPathXmlApplicationContext context;
	private MedActSurvelRuleServiceImpl medActSurvelRuleServiceImpl;
	private ObservableList< MedActSurvelRule> observableList;
	
	public MedActSurvelRuleEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		medActSurvelRuleServiceImpl = (MedActSurvelRuleServiceImpl) Global.context.getBean("medActSurvelRuleService");
		observableList = FXCollections.observableArrayList();
		
	}
	

	public void saveOrUpdate(MedActSurvelRule medActSurvelRule){
		
		medActSurvelRuleServiceImpl.addOrUpdate(medActSurvelRule);
		//this.closeApplicationConrext();
		
	}


}
