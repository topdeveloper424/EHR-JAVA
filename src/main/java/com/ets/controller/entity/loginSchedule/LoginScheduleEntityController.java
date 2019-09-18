package com.ets.controller.entity.loginSchedule;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.LoginSchedule;
import com.ets.model.UserAccount;
import com.ets.service.loginSchdule.LoginSchduleServiceImpl;
import com.ets.service.userAccount.UserAccountServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginScheduleEntityController Class
 *Description: EntityGroup Entity Non-GUI Controller class
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

public class LoginScheduleEntityController {

	//private static ClassPathXmlApplicationContext context;
	private LoginSchduleServiceImpl loginSchduleServiceImpl;
	private ObservableList<LoginSchedule> observableList;

	public LoginScheduleEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		loginSchduleServiceImpl = (LoginSchduleServiceImpl) Global.context.getBean("loginScheduleService");
		observableList = FXCollections.observableArrayList();
	}

	
	/**
	 * This method save Or update the LoginSchedule objects currently present in
	 * the system .
	 *
	 * @author Sumanta Deyashi
	 * @param loginSchedule
	 * @since 10-08-2016
	 * @version 1.0
	 *
	 * @return nothing
	 */

	public void addOrUpdate(LoginSchedule loginSchdule) {
		loginSchduleServiceImpl.addOrUpdate(loginSchdule);
		//this.closeApplicationContext();
	}


	/**
	 * This method gets all the LoginSchedule objects currently present in the
	 * system .
	 *
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 *
	 * @return ObservableList of loginSchedule objects
	 */

	public ObservableList<LoginSchedule> view() {
		observableList = FXCollections.observableArrayList(loginSchduleServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
	}

	/**
	 * This method delete the LoginSchedule objects currently present in the
	 * system .
	 *
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 *
	 * @return nothing
	 */

	public void delete(Integer id) {
		loginSchduleServiceImpl.delete(id);
		//this.closeApplicationContext();
	}
}