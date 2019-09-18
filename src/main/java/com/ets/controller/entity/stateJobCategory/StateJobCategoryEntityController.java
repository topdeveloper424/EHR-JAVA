package com.ets.controller.entity.stateJobCategory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.StateJobCategory;
import com.ets.service.stateJobCategory.StateJobCategoryServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateJobCategoryEntityController Class
 *Description: StateJobCategory Entity Non-GUI Controller class
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

public class StateJobCategoryEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private StateJobCategoryServiceImpl jobCategoryServiceImpl;
	
	private ObservableList<StateJobCategory> observableList;

	public StateJobCategoryEntityController() {
		
		//=new ClassPathXmlApplicationContext("spring.xml");
		jobCategoryServiceImpl=(StateJobCategoryServiceImpl) Global.context.getBean("stateJobCategoryService");
		
		observableList=FXCollections.observableArrayList();
	}
	


	/** This method save the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param jobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveSatejobCategory(StateJobCategory jobCategory){
		jobCategoryServiceImpl.addStateJobCategory(jobCategory);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateJobCategory objects
	 */
	public ObservableList<StateJobCategory> viewStateJobCategory(){
		
		observableList=FXCollections.observableArrayList(jobCategoryServiceImpl.stateJobCategoryList());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param jobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateStateJobCategory(StateJobCategory stateJobCategory){
		
		jobCategoryServiceImpl.updateStateJobCategory(stateJobCategory);
		//this.closeApplicationContext();
	}
	
	/** This method delete the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeStateJobCategory(Integer id){
		
		jobCategoryServiceImpl.deleteStateJobCategory(id);
		//this.closeApplicationContext();
		
	}
	
	
	

}
