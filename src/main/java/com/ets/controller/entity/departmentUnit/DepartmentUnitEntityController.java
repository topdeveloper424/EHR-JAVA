package com.ets.controller.entity.departmentUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DepartmentUnit;
import com.ets.service.departmentUnit.DepartmentUnitServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Original Author: Sumanta Deyahi on Behalf of ETS for Client Company File
 * Creation Date: 22-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnitEntityController Class Description:
 * DepartmentUnit Entity Non-GUI Controller class Copyright 2016 @Eclipse
 * Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

public class DepartmentUnitEntityController {

	//private static ClassPathXmlApplicationContext context;

	private DepartmentUnitServiceImpl departmentUnitServiceImpl;

	private ObservableList<DepartmentUnit> observableList;

	public DepartmentUnitEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		departmentUnitServiceImpl = (DepartmentUnitServiceImpl) Global.context.getBean("departmentUnitService");
		observableList = FXCollections.observableArrayList();
	}

	

	public void saveDepartmentUnit(DepartmentUnit departmentUnit) {
		departmentUnitServiceImpl.add(departmentUnit);
		//this.closeApplicationConrext();

	}

	public ObservableList<DepartmentUnit> viewDepartmentUnit() {

		observableList = FXCollections.observableArrayList(departmentUnitServiceImpl.view());

		//this.closeApplicationConrext();
		return observableList;

	}

	public void updateDepartmentUnit(DepartmentUnit departmentUnit) {

		departmentUnitServiceImpl.update(departmentUnit);
		//this.closeApplicationConrext();

	}

	public void deleteDepartmentUnit(Integer id) {

		departmentUnitServiceImpl.delete(id);
		//this.closeApplicationConrext();
	}
	
	public DepartmentUnit viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(departmentUnitServiceImpl.viewByCode(code));

		//this.closeApplicationConrext();
		return observableList.get(0);
				
	}

}
