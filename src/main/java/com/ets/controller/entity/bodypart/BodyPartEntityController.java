package com.ets.controller.entity.bodypart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BodyPart;
import com.ets.service.bodyPart.BodyPartServiceImpl;
import com.ets.utils.Global;

/**
 *On Behalf of ETS for Client Company
 *@since 18-02-2016
 *@version 1.0
 *@author Sumanta Deyahi
 * *Parameter Definition: Type object of BodyPartEntityController Class
 *Description: BodyPart Entity Non-GUI Controller class
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


public class BodyPartEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private BodyPartServiceImpl bodyPartServiceImpl;
	private ObservableList<BodyPart> observableList;

	public BodyPartEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		bodyPartServiceImpl=(BodyPartServiceImpl) Global.context.getBean("bodyPartService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	/*public void closeApplicationContext(){
		this.context.close();
	}*/
	
	

	
	/** This method save the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyPart
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveBodyPart(BodyPart bodyPart){
		bodyPartServiceImpl.addBodyPart(bodyPart);
		//this.closeApplicationContext();
	}
	
	
	/** This method gets all the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyPart objects
	 */
	
	public ObservableList<BodyPart> viewBodyParts(){
		
		observableList=FXCollections.observableArrayList(bodyPartServiceImpl.listBodyPart());
		
		//this.closeApplicationContext();
		return observableList;
				
	}
	
	
	/** This method Update all the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyPart
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void modifyBodyPart(BodyPart bodyPart){
		
		bodyPartServiceImpl.updateBodyPart(bodyPart);
		//this.closeApplicationContext();
		
	}
	
	
	/** This method Delete the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeBodyPart(Integer id){
		
		bodyPartServiceImpl.deleteBodyPartCode(id);
		//this.closeApplicationContext();
		
	}
	

}
