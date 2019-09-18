package com.ets.controller.entity.userAccount;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.UserAccount;
import com.ets.model.UserLogin;
import com.ets.service.userAccount.UserAccountServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAccountEntityController Class
 *Description: UserAccount Entity Non-GUI Controller class
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

public class UserAccountEntityController {

	//private static ClassPathXmlApplicationContext context;
	private UserAccountServiceImpl userAccountServiceImpl;
	private ObservableList<UserAccount> observableList;
	
	public UserAccountEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		userAccountServiceImpl = (UserAccountServiceImpl) Global.context.getBean("userAccountService");
		observableList = FXCollections.observableArrayList();
	}
	
	/*public void closeApplicationContext(){
		
		this.context.close();
	}*/
	
	/**
	 * This method save Or update the UserAccount objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userAccount
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	
	public void addOrUpdate(UserAccount userAccount){
		
		userAccountServiceImpl.addOrUpdate(userAccount);
		//this.closeApplicationContext();
	}
	
	/**
	 * This method gets the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	public ObservableList<UserAccount> view(){
		
		observableList = FXCollections.observableArrayList(userAccountServiceImpl.userAccounts());
		//this.closeApplicationContext();
		return observableList;
	}
	
	
	/**
	 * This method delete the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void delete(Integer id){
		
		userAccountServiceImpl.delete(id);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName , password
	 * @since 22-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
		
	public ObservableList<UserAccount> loginUserValidate(String userName,String password) {
		
		observableList = FXCollections.observableArrayList(userAccountServiceImpl.login(userName, password));
		//this.closeApplicationContext();
		return observableList;
		
	}
	
public ObservableList<UserAccount> loginUserValidate2(String userName,String password , Boolean loginStatus) {
		
		observableList = FXCollections.observableArrayList(userAccountServiceImpl.login2(userName, password, loginStatus));
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	
	/** This method gets all the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName
	 * @since 22-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	public UserAccount viewByName(String userName) {
		
		observableList = FXCollections.observableArrayList(userAccountServiceImpl.viewByName(userName));
		//this.closeApplicationContext();
		return observableList.get(0);
		
	}
	
	public UserAccount getById(Integer id){
		observableList = FXCollections.observableArrayList(userAccountServiceImpl.getById(id));
		return observableList.get(0);
	}

}
