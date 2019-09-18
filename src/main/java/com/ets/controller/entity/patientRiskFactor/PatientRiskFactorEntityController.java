package com.ets.controller.entity.patientRiskFactor;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientRiskFactorEntityController Class
 *Description: PatientRiskFactor Entity Non-GUI Controller class
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

import com.ets.model.PatientRiskFactor;
import com.ets.service.patientRiskFactor.PatientRiskFactorServiceImpl;
import com.ets.utils.Global;

public class PatientRiskFactorEntityController {

	//private static ClassPathXmlApplicationContext context;
	private PatientRiskFactorServiceImpl patientRiskFactorServiceImpl;
	
	public PatientRiskFactorEntityController() {
		
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		patientRiskFactorServiceImpl = (PatientRiskFactorServiceImpl) Global.context.getBean("patientRiskFactorService");
	}
	
	public void saveOrupdate(PatientRiskFactor patientRiskFactor){
		
		patientRiskFactorServiceImpl.saveOrUpdate(patientRiskFactor);
		//context.close();
	}

}
