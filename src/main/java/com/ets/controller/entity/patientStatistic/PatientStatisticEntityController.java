package com.ets.controller.entity.patientStatistic;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientStatisticEntityController Class
 *Description: PatientStatistic Entity Non-GUI Controller class
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

import com.ets.model.PatientStatistic;
import com.ets.service.patientStatistic.PatientStatisticServiceImpl;
import com.ets.utils.Global;

public class PatientStatisticEntityController {

	private PatientStatisticServiceImpl patientStatisticServiceImpl;
	//private ClassPathXmlApplicationContext context;

	public PatientStatisticEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		patientStatisticServiceImpl = (PatientStatisticServiceImpl) Global.context.getBean("patientStatisticService");
	}

	
	public void saveOrUpdate(PatientStatistic patientStatistic) {
		patientStatisticServiceImpl.saveOrUpdate(patientStatistic);
		//closeApplicationContext();
	}

}
