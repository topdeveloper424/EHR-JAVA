package com.ets.controller.entity.patientAddlContactInfo;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAddlContactInfoEntityController Class
 *Description: PatientAddlContactInfo Entity Non-GUI Controller class
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

import com.ets.model.PatientAddlContactInfo;
import com.ets.service.patientAddlContactInfo.PatientAddlContactInfoServiceImpl;
import com.ets.utils.Global;

public class PatientAddlContactInfoEntityController {

	//private static ClassPathXmlApplicationContext context;
	private PatientAddlContactInfoServiceImpl addlContactInfoServiceImpl;
	
	public PatientAddlContactInfoEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		addlContactInfoServiceImpl = (PatientAddlContactInfoServiceImpl) Global.context.getBean("patientAddlContactInfoService");
	}
	
	public void saveOrUpdate(PatientAddlContactInfo patientAddlContactInfo){
		
		addlContactInfoServiceImpl.saveOrUpdate(patientAddlContactInfo);
		//context.close();
	}
   
}
