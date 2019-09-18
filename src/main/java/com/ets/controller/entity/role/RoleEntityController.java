package com.ets.controller.entity.role;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Role;
import com.ets.service.role.RoleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RoleEntityController Class
 *Description: Role Entity Non-GUI Controller class
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


public class RoleEntityController {

	//private static ClassPathXmlApplicationContext context;
	private RoleServiceImpl roleServiceImpl;
	private ObservableList<Role> observableList;
	private ObservableList<String> observableListString;

	public RoleEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		roleServiceImpl = (RoleServiceImpl) Global.context.getBean("roleService");
		observableList = FXCollections.observableArrayList();
		observableListString = FXCollections.observableArrayList();
	}

	
	/**
	 * This method save Or update the Role objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param role
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	public void addOrUpdate(Role role) {

		roleServiceImpl.addOrUpdate(role);
		//this.closeApplicationContext();

	}

	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */

	public ObservableList<Role> view() {

		observableList = FXCollections.observableArrayList(roleServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;

	}

	/**
	 * This method delete the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	public void delete(Integer id) {

		roleServiceImpl.delete(id);
		//this.closeApplicationContext();

	}
	
	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */
	
	public Role viewByName(String name){
		observableList = FXCollections.observableArrayList(roleServiceImpl.viewByName(name));
		//this.closeApplicationContext();
		return observableList.get(0);
	}

	public ObservableList<String> roleName() {

		observableListString = FXCollections.observableArrayList(roleServiceImpl.roleName());
		//this.closeApplicationContext();
		return observableListString;

	}
	
}
