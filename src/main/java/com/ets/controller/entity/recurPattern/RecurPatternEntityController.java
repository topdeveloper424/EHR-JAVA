package com.ets.controller.entity.recurPattern;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.RecurPattern;
import com.ets.service.recurPattern.RecurPatternServiceImpl;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RecurPatternEntityController Class
 *Description: RecurPattern Entity Non-GUI Controller class
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
public class RecurPatternEntityController {

	private RecurPatternServiceImpl recurPatternServiceImpl;
	//private ClassPathXmlApplicationContext context;
	public RecurPatternEntityController() {
	
		//context=new ClassPathXmlApplicationContext("spring.xml");
		recurPatternServiceImpl=(RecurPatternServiceImpl) Global.context.getBean("recurPatternService");
	}
 
   public void saveOrUpdate(RecurPattern recurPattern)
   {
	   recurPatternServiceImpl.saveOrUpdate(recurPattern);
      // closeApplicationContext();   
   }
	
}
