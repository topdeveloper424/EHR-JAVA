package com.ets.controller.entity.access;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Access;
import com.ets.service.access.AccessServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AccessEntityController Class
 *Description: Access Entity Non-GUI Controller class
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


public class AccessEntityController {

	//private static ClassPathXmlApplicationContext context;
	private AccessServiceImpl accessServiceImpl;
	private ObservableList<Access> observableList;
	
	public AccessEntityController() {
		
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		accessServiceImpl = (AccessServiceImpl) Global.context.getBean("accessService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	/**
	 * This method save Or update the Access objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param access
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void addOrUpdate(Access access){
		
		accessServiceImpl.addOrUpdate(access);
				
	}
	
	
	/**
	 * This method gets all the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of access objects
	 */
	
	public ObservableList<Access> view(){
		
		observableList = FXCollections.observableArrayList(accessServiceImpl.view());
		
		return observableList;
		
	}
	
	/**
	 * This method delete the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void delete(Integer id){
		
		accessServiceImpl.delete(id);
	
		
	}
	
}
