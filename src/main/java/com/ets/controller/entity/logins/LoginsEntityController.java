package com.ets.controller.entity.logins;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.LoginHistory;
import com.ets.service.logins.LoginsServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginsEntityController Class
 *Description: Logins Entity Non-GUI Controller class
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


public class LoginsEntityController {

	private static ClassPathXmlApplicationContext context;
	private LoginsServiceImpl loginsServiceImpl;
	private ObservableList<LoginHistory> observableList;

	public LoginsEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		loginsServiceImpl = (LoginsServiceImpl) Global.context.getBean("loginsService");
		observableList = FXCollections.observableArrayList();

	}

	
	/**
	 * This method save Or update the Logins objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param logins
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	public void addOrUpdate(LoginHistory logins) {

		loginsServiceImpl.addOrUpdate(logins);
		//this.closeApplicationContext();

	}

	/**
	 * This method gets all the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of logins objects
	 */

	public ObservableList<LoginHistory> view() {

		observableList = FXCollections.observableArrayList(loginsServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;

	}

	/**
	 * This method delete the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	public void delete(Integer id) {

		loginsServiceImpl.delete(id);
		//this.closeApplicationContext();

	}

}
