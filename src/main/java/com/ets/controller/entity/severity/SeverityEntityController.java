package com.ets.controller.entity.severity;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.SeverityCode;
import com.ets.service.severityCode.SeverityServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SeverityEntityController Class
 *Description: SeverityCode Entity Non-GUI Controller class
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

public class SeverityEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private static SeverityServiceImpl severityServiceImpl;
	private ObservableList<SeverityCode> observableList;

	public SeverityEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		severityServiceImpl=(SeverityServiceImpl) Global.context.getBean("severityService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	
	/** This method save the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveSaverityCode(SeverityCode severityCode){
		
		severityServiceImpl.addSeverity(severityCode);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SeverityCode objects
	 */
	public ObservableList<SeverityCode> viewSeverity(){
		
		observableList=FXCollections.observableArrayList(severityServiceImpl.severityCodeLists());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateSeverityCode(SeverityCode severityCode){
		
		severityServiceImpl.updateSeverityCode(severityCode);
		//this.closeApplicationContext();
		
	}
	
	/** This method delete the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeSeverityCode(Integer id){
		
		severityServiceImpl.deleteSeverityCode(id);
		//this.closeApplicationContext();
		
	}
	
	

}
