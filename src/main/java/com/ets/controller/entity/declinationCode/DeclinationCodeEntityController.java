package com.ets.controller.entity.declinationCode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DeclinationCode;
import com.ets.service.declinationCode.DeclinationCodeServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeEntityController Class
 *Description: DeclinationCode Entity Non-GUI Controller class
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

public class DeclinationCodeEntityController {
	
//	private static ClassPathXmlApplicationContext context;
	private DeclinationCodeServiceImpl declinationCodeServiceImpl;
	private ObservableList<DeclinationCode> observableList;

	public DeclinationCodeEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		declinationCodeServiceImpl = (DeclinationCodeServiceImpl) Global.context.getBean("declinationCodeService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	public void save(DeclinationCode declinationCode){
		
		declinationCodeServiceImpl.add(declinationCode);
		//this.closeApplicationContext();
	}
	
	public ObservableList<DeclinationCode> view(){
		
		observableList = FXCollections.observableArrayList(declinationCodeServiceImpl.list());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	public void update(DeclinationCode declinationCode){
		
		declinationCodeServiceImpl.update(declinationCode);
		//this.closeApplicationContext();
	}
	
	public void delete(Integer id){
		
		declinationCodeServiceImpl.delete(id);
		//.closeApplicationContext();
		
	}

}
