package com.ets.controller.entity.clinicianBlockTime;


import java.util.Date;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianBlockTimeEntityController Class
 *Description: ClinicianBlockTime Entity Non-GUI Controller class
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

import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockTime;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.service.clinicianBlockTime.ClinicianBlockTimeServiceImpl;
import com.ets.utils.Global;

public class ClinicianBlockTimeEntityController {

	private ClinicianBlockTimeServiceImpl clinicianBlockTimeServiceImpl;
	//private ClassPathXmlApplicationContext context;

	public ClinicianBlockTimeEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicianBlockTimeServiceImpl = (ClinicianBlockTimeServiceImpl) Global.context.getBean("clinicianBlockTimeService");
	}

	

	public void saveOrUpdate(List<ClinicianBlockTime> clinicianBlockTimes)
	{
		clinicianBlockTimeServiceImpl.saveOrUpdate(clinicianBlockTimes);
	    // closeApplicationContext();
	}
	
	public List<ClinicianBlockTime> viewBydateAndClinician(List<Date> dateList,Clinician clinician){
		
	return clinicianBlockTimeServiceImpl.viewByDate(dateList, clinician);	
	}
	
	public void delete(List<ClinicianBlockTime> clinicianBlockTimes)
	{
		clinicianBlockTimeServiceImpl.delete(clinicianBlockTimes);
	    // closeApplicationContext();
	}
	public void deleteBlockTimeByDate(Date stD,Date enD,Clinician clinician)
	{
		clinicianBlockTimeServiceImpl.deleteBlockTimeByDate(stD, enD, clinician);
	    // closeApplicationContext();
	}

}