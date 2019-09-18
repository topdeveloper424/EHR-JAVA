package com.ets.controller.entity.objectOrSubstance;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.ObjectOrSubstance;
import com.ets.service.objectOrSubstance.ObjectOrSubstanceServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ObjectOrSubstanceEntityController Class
 *Description: ObjectOrSubstance Entity Non-GUI Controller class
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

public class ObjectOrSubstanceEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private ObjectOrSubstanceServiceImpl objectOrSubstanceServiceImpl;
	private ObservableList<ObjectOrSubstance> observableList;
	

	public ObjectOrSubstanceEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		objectOrSubstanceServiceImpl=(ObjectOrSubstanceServiceImpl) Global.context.getBean("objectOrSubstanceService");
		observableList=FXCollections.observableArrayList();
		
	}
	

	/** This method save the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveObjectOrSubstance(ObjectOrSubstance objectOrSubstance){
		objectOrSubstanceServiceImpl.addObjectorSubstance(objectOrSubstance);
	//	this.closeApplicationContext();
	}
	
	/** This method gets all the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ObjectOrSubstance objects
	 */
	public ObservableList<ObjectOrSubstance> viewObjectOrSubstance(){
		
		observableList=FXCollections.observableArrayList(objectOrSubstanceServiceImpl.objectOrSubstanceLists());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateObjectOrSubstance(ObjectOrSubstance objectOrSubstance){
		
		objectOrSubstanceServiceImpl.updateObjectOrSubstance(objectOrSubstance);
		//this.closeApplicationContext();
	}
	
	/** This method delete the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeObjectOrSubstance(Integer id){
		
		objectOrSubstanceServiceImpl.deleteObjectOrSubstance(id);
		//this.closeApplicationContext();
		
	}
	

}
