package com.ets.controller.entity.recurEntry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.RecurEntry;
import com.ets.service.recurEntry.RecurEntryServiceImpl;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RecurEntryEntityController Class
 *Description: RecurEntry Entity Non-GUI Controller class
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
public class RecurEntryEntityController {

	//private ClassPathXmlApplicationContext context;
	private RecurEntryServiceImpl recurEntryServiceImpl;

	public RecurEntryEntityController() {

		//ontext = new ClassPathXmlApplicationContext("spring.xml");
		recurEntryServiceImpl = (RecurEntryServiceImpl) Global.context.getBean("recurEntryService");
	}

	

	public void saveOrUpdate(RecurEntry recurEntry) {
		recurEntryServiceImpl.saveOrUpdate(recurEntry);
		//closeApplicationContext();
	}

}
