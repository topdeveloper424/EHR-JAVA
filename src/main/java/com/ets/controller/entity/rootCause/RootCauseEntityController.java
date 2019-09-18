package com.ets.controller.entity.rootCause;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.RootCause;
import com.ets.service.rootCause.RootCauseServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseEntityController Class
 *Description: RootCause Entity Non-GUI Controller class
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

public class RootCauseEntityController {
	
//private static ClassPathXmlApplicationContext context;
	
	private RootCauseServiceImpl rootCauseServiceImpl;
	
	private ObservableList< RootCause> observableList;


	public RootCauseEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		rootCauseServiceImpl=(RootCauseServiceImpl) Global.context.getBean("rootCauseService");
		observableList=FXCollections.observableArrayList();
		
		
			}
	
	
	
	/** This method save the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveRootCause(RootCause rootCause){
		rootCauseServiceImpl.addRootCause(rootCause);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RootCause objects
	 */
	public ObservableList<RootCause> viewRootCause(){
		observableList=FXCollections.observableArrayList(rootCauseServiceImpl.rootCauseLists());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateRootCause(RootCause rootCause){
		
		rootCauseServiceImpl.updateRootCause(rootCause);
		//this.closeApplicationContext();
	}
	
	/** This method delete the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeRootCause(Integer id){
		
		rootCauseServiceImpl.deleteRootCause(id);
		//this.closeApplicationContext();
		
	}
	
}
