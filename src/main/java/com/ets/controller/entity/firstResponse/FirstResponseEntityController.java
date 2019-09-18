package com.ets.controller.entity.firstResponse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.FirstResponse;
import com.ets.service.firstResponse.FirstResponseServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FirstResponseEntityController Class
 *Description: FirstResponse Entity Non-GUI Controller class
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

public class FirstResponseEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private FirstResponseServiceImpl firstResponseServiceImpl;
	
	private ObservableList<FirstResponse> observableList;

	public FirstResponseEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		firstResponseServiceImpl=(FirstResponseServiceImpl) Global.context.getBean("firstResponseService");
		observableList = FXCollections.observableArrayList();
	}
	
	
	
	/** This method save the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveFirstResponse(FirstResponse firstResponse){
		
		firstResponseServiceImpl.addFirstResponse(firstResponse);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of FirstResponse objects
	 */
	
	public ObservableList<FirstResponse> viewFirstResponse(){
		
		observableList=FXCollections.observableArrayList(firstResponseServiceImpl.firstResponseList());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void modifyFirstResponse(FirstResponse firstResponse){
		
		firstResponseServiceImpl.updateFirstResponse(firstResponse);
		//this.closeApplicationContext();
		
	}
	
	/** This method delete the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void removeFirstResponse(Integer id){
		
		firstResponseServiceImpl.dleteFirstResponse(id);
		//this.closeApplicationContext();
		
	}
	
	
	
	

}
