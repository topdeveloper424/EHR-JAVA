package com.ets.controller.entity.spirometerTestParamGen;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.SpirometerTestParamGen;
import com.ets.service.spirometerTestParamGen.SpirometerTestParamGenServiceImpl;
import com.ets.utils.Global;
/**
 *Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company
 *File Creation Date: 22-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of spirometerTestParamGenEntity Class
 *Description: spirometerTestParamGenEntity Class
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

public class SpirometerTestParamGenEntityController {
	//private static ClassPathXmlApplicationContext context;
    private SpirometerTestParamGenServiceImpl spirometerTestParamGenServiceImpl;
    
    public SpirometerTestParamGenEntityController(){
    	//context=new ClassPathXmlApplicationContext("spring.xml");
    	spirometerTestParamGenServiceImpl=(SpirometerTestParamGenServiceImpl) Global.context.getBean("spirometerTestParamGenService");
    }
	
	public void saveSpirometerTestParamGen(SpirometerTestParamGen spirometerTestParamGen){
		spirometerTestParamGenServiceImpl.saveSpirometerTestParamGen(spirometerTestParamGen);
		//this.closeApplicationContext();
	}
	
}

