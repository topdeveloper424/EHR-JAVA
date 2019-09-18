package com.ets.controller.entity.illnessCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.IllnessCode;
import com.ets.service.illnessCode.IllnessCodeServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IllnessCodeEntityController Class
 *Description: IllnessCode Entity Non-GUI Controller class
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

public class IllnessCodeEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private IllnessCodeServiceImpl illnessCodeServiceImpl;
	
	private ObservableList<IllnessCode> observableList;

	public IllnessCodeEntityController() {
		
		// = new ClassPathXmlApplicationContext("spring.xml");
		illnessCodeServiceImpl=(IllnessCodeServiceImpl) Global.context.getBean("illnessCodeService");
		observableList = FXCollections.observableArrayList();
	}
	
	
	
	/** This method save the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveIllnessCode(IllnessCode illnessCode){
		
		illnessCodeServiceImpl.addIllnessCode(illnessCode);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IllnessCode objects
	 */
	
	public ObservableList<IllnessCode> viewIllnessCode(){
		
		observableList = FXCollections.observableArrayList(illnessCodeServiceImpl.illnessCodeList());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	/** This method update the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void modifyIllnessCode(IllnessCode illnessCode){
		
		illnessCodeServiceImpl.updateIllnessCode(illnessCode);
		//this.closeApplicationContext();
	}
	
	/** This method delete the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeIllnessCode(Integer id){
		
		illnessCodeServiceImpl.deleteIllnessCode(id);
		//this.closeApplicationContext();
	}
	
	

}
