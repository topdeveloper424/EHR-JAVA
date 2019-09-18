package com.ets.controller.entity.reasonOrCause;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.ReasonOrCause;
import com.ets.service.reasonOrCause.ReasonOrCauseServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReasonOrCauseEntityController Class
 *Description: ReasonOrCause Entity Non-GUI Controller class
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

public class ReasonOrCauseEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private ReasonOrCauseServiceImpl reasonOrCauseServiceImpl;
	
	private ObservableList< ReasonOrCause> observableList;

	public ReasonOrCauseEntityController() {
	//	context=new ClassPathXmlApplicationContext("spring.xml");
		reasonOrCauseServiceImpl=(ReasonOrCauseServiceImpl) Global.context.getBean("reasonOrCauseService");
		observableList=FXCollections.observableArrayList();
	}
	
	
	/** This method save the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveReasonOrCause(ReasonOrCause cause){
		reasonOrCauseServiceImpl.addReasonOrCause(cause);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ReasonOrCause objects
	 */
	public ObservableList<ReasonOrCause> viewReasonOrCause(){
		observableList=FXCollections.observableArrayList(reasonOrCauseServiceImpl.reasonCauseLists());
	//	this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateReasonOrCause(ReasonOrCause reasonOrCause){
		
		reasonOrCauseServiceImpl.updateReasonOrCause(reasonOrCause);
		//this.closeApplicationContext();
	}
	
	/** This method delete the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeReasonOrCause(Integer id){
		
		reasonOrCauseServiceImpl.deleteReasonOrCause(id);
		//this.closeApplicationContext();
		
	}

}
