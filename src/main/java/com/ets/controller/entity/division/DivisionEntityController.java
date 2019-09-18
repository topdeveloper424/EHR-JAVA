package com.ets.controller.entity.division;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Division;
import com.ets.service.division.DivisionServiceImpl;
import com.ets.utils.Global;

/**
 * Original Author: Sumanta Deyahi on Behalf of ETS for Client Company File
 * Creation Date: 22-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DivisionEntityController Class Description:
 * Division Entity Non-GUI Controller class Copyright 2016 @Eclipse
 * Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

public class DivisionEntityController {

	//private static ClassPathXmlApplicationContext context;

	private DivisionServiceImpl divisionServiceImpl;

	private ObservableList<Division> observableList;

	public DivisionEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");

		divisionServiceImpl = (DivisionServiceImpl) Global.context.getBean("divisionService");

		observableList = FXCollections.observableArrayList();

	}

	/**
	 * This method save the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void saveDivision(Division division) {

		divisionServiceImpl.addDivision(division);
	//	this.closeApplicationContext();

	}

	/**
	 * This method gets all the Division objects currently present in the system
	 * .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	public ObservableList<Division> viewDivision() {

		observableList = FXCollections.observableArrayList(divisionServiceImpl.divisionList());
		//this.closeApplicationContext();
		return observableList;
	}

	/**
	 * This method update the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void updateDivision(Division division) {

		divisionServiceImpl.updateDivision(division);
		//this.closeApplicationContext();
	}

	/**
	 * This method delete the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void removeDivision(Integer id) {

		divisionServiceImpl.deleteDivision(id);
		//this.closeApplicationContext();
	}

	/**
	 * This method gets all the Division objects currently present in the system
	 * .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	public ObservableList<Division> viewDivisionByDivisionId(Integer id) {

		observableList = FXCollections.observableArrayList(divisionServiceImpl.viewDivisionById(id));
		//this.closeApplicationContext();
		return observableList;
	}

	/**
	 * This method gets the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	public Division viewByCode(String code) {

		observableList = FXCollections.observableArrayList(divisionServiceImpl.viewByCode(code));
		//this.closeApplicationContext();
		return observableList.get(0);
	}

}
