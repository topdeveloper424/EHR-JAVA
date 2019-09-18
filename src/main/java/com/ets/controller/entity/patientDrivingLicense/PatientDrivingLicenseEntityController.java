package com.ets.controller.entity.patientDrivingLicense;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientDrivingLicenseEntityController Class
 *Description: PatientDrivingLicense Entity Non-GUI Controller class
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

import com.ets.model.PatientDrivingLicense;
import com.ets.service.patientDrivingLicense.PatientDrivingLicenseServiceImpl;
import com.ets.utils.Global;

public class PatientDrivingLicenseEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private PatientDrivingLicenseServiceImpl  patientDrivingLicenseServiceImpl;
	
	public PatientDrivingLicenseEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		patientDrivingLicenseServiceImpl = (PatientDrivingLicenseServiceImpl) Global.context.getBean("patientDrivingLicenseService");
		
	}
	
	public void saveOrUpdate(PatientDrivingLicense patientDrivingLicense){
		
		patientDrivingLicenseServiceImpl.saveOrUpdate(patientDrivingLicense);
		//context.close();
	}

}
