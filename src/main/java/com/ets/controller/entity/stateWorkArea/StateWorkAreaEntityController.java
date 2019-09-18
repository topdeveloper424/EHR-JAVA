package com.ets.controller.entity.stateWorkArea;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.StateWorkArea;
import com.ets.service.stateWorkArea.StateWorkAreaServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaEntityController Class
 *Description: StateWorkArea Entity Non-GUI Controller class
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

public class StateWorkAreaEntityController {

	//private static ClassPathXmlApplicationContext context;
	private static StateWorkAreaServiceImpl stateWorkAreaServiceImpl;
	private ObservableList<StateWorkArea> observableList;

	public StateWorkAreaEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		stateWorkAreaServiceImpl = (StateWorkAreaServiceImpl) Global.context
				.getBean("stateWorkAreaService");
		observableList = FXCollections.observableArrayList();

	}

	
	/** This method save the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveStateWorkArea(StateWorkArea stateWorkArea) {
		stateWorkAreaServiceImpl.addStateWorkArea(stateWorkArea);
		//this.closeApplicationContext();
	}

	/** This method gets all the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateWorkArea objects
	 */
	
	public ObservableList<StateWorkArea> viewStateWorkArea() {

		observableList = FXCollections
				.observableArrayList(stateWorkAreaServiceImpl
						.stateWorkAreaList());
		//this.closeApplicationContext();
		return observableList;

	}
	
	/** This method update the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateStateWorkArea(StateWorkArea stateWorkArea){
		
		stateWorkAreaServiceImpl.updateStateWorkArea(stateWorkArea);
		//this.closeApplicationContext();
	}
	
	/** This method delete the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeStateWorkArea(Integer id){
		
		stateWorkAreaServiceImpl.deleteStateWorkArea(id);
		//this.closeApplicationContext();
	}

}
