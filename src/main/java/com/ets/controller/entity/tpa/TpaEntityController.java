package com.ets.controller.entity.tpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Tpa;
import com.ets.service.tpa.TpaServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of TpaEntityController Class
 *Description: Tpa Entity Non-GUI Controller class
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
public class TpaEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private TpaServiceImpl tpaServiceImpl;
	private ObservableList<Tpa> observableList;

	public TpaEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		tpaServiceImpl = (TpaServiceImpl) Global.context.getBean("tpaService");
		observableList = FXCollections.observableArrayList();
	}
	
	
	public void saveOrUpdate(Tpa tpa){
		
		tpaServiceImpl.addOrUpdate(tpa);
		//this.closeApplicationContext();
		
	}
	
	public ObservableList<Tpa> view(){
		
		observableList = FXCollections.observableArrayList(tpaServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	public Tpa viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(tpaServiceImpl.viewByCode(code));
		//this.closeApplicationContext();
		return observableList.get(0);
	}
	
	public void delete(Integer id)
	{
		tpaServiceImpl.delete(id);
		//context.close();
	}
}
