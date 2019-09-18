package com.ets.controller.entity.occurRange;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.OccurRange;
import com.ets.service.occurRange.OccurRangeServiceImpl;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of OccurRangeEntityController Class
 *Description: OccurRange Entity Non-GUI Controller class
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
public class OccurRangeEntityController {

	//private ClassPathXmlApplicationContext context;
	private OccurRangeServiceImpl occurRangeServiceImpl;
	
	public OccurRangeEntityController()
	{
	 // context=new ClassPathXmlApplicationContext("spring.xml");
	  occurRangeServiceImpl=(OccurRangeServiceImpl) Global.context.getBean("occurRangeService");
	}
	
	
	public void saveOrUpdate(OccurRange occurRange)
	{
		occurRangeServiceImpl.saveOrUpdate(occurRange);
	//	closeApplicationCopntext();
	}
}
