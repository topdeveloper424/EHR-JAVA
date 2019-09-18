package com.ets.controller.entity.workActivity;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.WorkActivity;
import com.ets.service.workActivity.WorkActivityServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkActivityEntityController Class
 *Description: WorkActivity Entity Non-GUI Controller class
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

public class WorkActivityEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private WorkActivityServiceImpl activityServiceImpl;
	private ObservableList< WorkActivity> observableList;
	
	public WorkActivityEntityController() {
		//context=new ClassPathXmlApplicationContext("spring.xml");
		activityServiceImpl=(WorkActivityServiceImpl) Global.context.getBean("workActivityService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param activity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveWorkActivity(WorkActivity activity){
		activityServiceImpl.addWorkActivity(activity);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkActivity objects
	 */
	
	public ObservableList<WorkActivity> viewWorkActivity(){
		observableList=FXCollections.observableArrayList(activityServiceImpl.workActivityList());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workActivity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateWorkActivity(WorkActivity workActivity){
		
		activityServiceImpl.updateWorkActivity(workActivity);
		//this.closeApplicationContext();
		
	}
	
	/** This method delete the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeWorkActivity(Integer id){
		
		activityServiceImpl.deleteWorkActivity(id);
		//this.closeApplicationContext();
	}
	
	
	

}
