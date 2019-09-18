package com.ets.controller.entity.spirometer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DepartmentUnit;
import com.ets.model.Spirometer;
import com.ets.service.spirometer.SpirometerServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company
 *File Creation Date: 22-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of spirometerEntity Class
 *Description: spirometerEntity Interface Class
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

public class SpirometerEntityController {

	//private static ClassPathXmlApplicationContext context;
	private SpirometerServiceImpl spirometerServiceImpl;
	
	private ObservableList<Spirometer> observableList;

	public SpirometerEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		spirometerServiceImpl = (SpirometerServiceImpl) Global.context.getBean("spirometerService");
		observableList = FXCollections.observableArrayList();
	}

	

	public void saveSpirometer(Spirometer spirometer) {
		spirometerServiceImpl.saveSpirometer(spirometer);
		//this.closeApplicationContext();
	}
	
	public ObservableList<Spirometer> viewSpirometer() {

		observableList = FXCollections.observableArrayList(spirometerServiceImpl.view());

		//this.closeApplicationContext();
		return observableList;

	}

	/*public void updateSpirometer(Spirometer spirometer) {

		spirometerServiceImpl.update(spirometer);
		this.closeApplicationContext();

	}*/
	public void deleteSpirometer(Integer id) {

		spirometerServiceImpl.delete(id);
		//this.closeApplicationContext();
	}

}
