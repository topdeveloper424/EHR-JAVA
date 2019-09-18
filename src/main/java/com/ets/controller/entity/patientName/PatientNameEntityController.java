package com.ets.controller.entity.patientName;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientNameEntityController Class
 *Description: PatientName Entity Non-GUI Controller class
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

import com.ets.model.PatientName;
import com.ets.service.patientName.PatientNameServiceImpl;
import com.ets.utils.Global;

public class PatientNameEntityController {
	private PatientNameServiceImpl patientNameServiceImpl;
	//private ClassPathXmlApplicationContext context;

	public PatientNameEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		patientNameServiceImpl = (PatientNameServiceImpl) Global.context.getBean("patientNameService");
	}

	public void closeApplicationContext() {
		//context.close();
	}

	public void saveOrUpdate(PatientName patientName) {
		patientNameServiceImpl.saveOrUpdate(patientName);
		//closeApplicationContext();
	}

}
