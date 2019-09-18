package com.ets.controller.entity.patientSmokingStatus;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientSmokingStatusEntityController Class
 *Description: PatientSmokingStatus Entity Non-GUI Controller class
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

import com.ets.model.PatientSmokingStatus;
import com.ets.service.patientSmokingStatus.PatientSmokingStatusServiceImpl;
import com.ets.utils.Global;

public class PatientSmokingStatusEntityController {

	//private static ClassPathXmlApplicationContext context;
	private PatientSmokingStatusServiceImpl patientSmokingStatusServiceImpl;
	
	public PatientSmokingStatusEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		patientSmokingStatusServiceImpl = (PatientSmokingStatusServiceImpl) Global.context.getBean("patientSmokingStatusService");
		
	}
	
	public void saveOrUpdate(PatientSmokingStatus patientSmokingStatus){
		
		patientSmokingStatusServiceImpl.saveOrUpdate(patientSmokingStatus);
		//context.close();
	}

}
