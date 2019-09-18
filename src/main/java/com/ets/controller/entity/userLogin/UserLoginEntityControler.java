package com.ets.controller.entity.userLogin;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.UserLogin;
import com.ets.service.userlogin.UserLoginServiceImpl;
import com.ets.utils.Global;

import antlr.collections.List;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DistrictEntityController Class
 *Description: UserLogin Entity Non-GUI Controller class
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

public class UserLoginEntityControler {

	//private static ClassPathXmlApplicationContext context;
	private UserLoginServiceImpl userLoginServiceImpl;
	private ObservableList<UserLogin> observableList;

	public UserLoginEntityControler() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		userLoginServiceImpl = (UserLoginServiceImpl) Global.context.getBean("userLoginService");
		observableList = FXCollections.observableArrayList();

	}

	/*public void closeApplicationContext() {
		this.context.close();
	}*/
	
	/** This method gets all the UserLogin objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 07-03-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserLogin objects
	 */
		
	public ObservableList<UserLogin> loginUserValidate(String name,String password) {

		observableList = FXCollections.observableArrayList(userLoginServiceImpl.login(name, password));
		//this.closeApplicationContext();
		return observableList;
	}

}
