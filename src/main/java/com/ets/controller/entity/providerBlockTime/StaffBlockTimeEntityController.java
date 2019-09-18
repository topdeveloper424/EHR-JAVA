package com.ets.controller.entity.providerBlockTime;

import java.util.Date;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffBlockTimeEntityController Class
 *Description: ProviderBlockTime Entity Non-GUI Controller class
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

import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.service.providerBlockTime.StaffBlockTimeServiceImpl;
import com.ets.utils.Global;

public class StaffBlockTimeEntityController {
   private StaffBlockTimeServiceImpl staffBlockTimeServiceImpl;
  //// private ClassPathXmlApplicationContext context;
	
	
	
	public StaffBlockTimeEntityController() {
		
		//context= new ClassPathXmlApplicationContext("spring.xml");
		staffBlockTimeServiceImpl =(StaffBlockTimeServiceImpl) Global.context.getBean("providerBlockTimeService");
	}
    
	
	
	public void saveOrUpdate(List<ProviderBlockTime> staffBlockTime)
	{
		staffBlockTimeServiceImpl.saveOrUpdate(staffBlockTime);
	    // closeApplicationContext();
	}
	
	public List<ProviderBlockTime> viewBydateAndProvider(List<Date> dateList,Provider provider){
		
	return staffBlockTimeServiceImpl.viewByDate(dateList, provider);	
	}
	
	public void delete(List<ProviderBlockTime> staffBlockTime)
	{
		staffBlockTimeServiceImpl.delete(staffBlockTime);
	    // closeApplicationContext();
	}
	public void deleteBlockTimeByDate(Date stD,Date enD,Provider provider)
	{
		staffBlockTimeServiceImpl.deleteBlockTimeByDate(stD, enD, provider);
	    // closeApplicationContext();
	}

}