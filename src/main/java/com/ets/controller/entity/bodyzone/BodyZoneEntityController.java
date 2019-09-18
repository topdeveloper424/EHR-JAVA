package com.ets.controller.entity.bodyzone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ets.model.BodyZone;
import com.ets.service.bodyZone.BodyZoneServiceImpl;
import com.ets.utils.Global;

/**
 *Parameter Definition: Type object of BodyZoneEntityController Class
 *Description: BodyZone Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *@version 1.0
 *@since 18-02-2016
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

public class BodyZoneEntityController {

	//private static ClassPathXmlApplicationContext context;
	private static BodyZoneServiceImpl bodyZoneServiceImpl;
	private ObservableList<BodyZone> observableList;

	public BodyZoneEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		bodyZoneServiceImpl = (BodyZoneServiceImpl) Global.context
				.getBean("bodyZoneService");
		observableList = FXCollections.observableArrayList();

	}

	/*public void closeApplicationContext() {
		this.context.close();
	}*/
	
	public void closeApplicationContext(){
		Global.context.close();
	}
	
	/** This method save the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveBodyZone(BodyZone bodyZone) {
		bodyZoneServiceImpl.addBodyZone(bodyZone);
		//this.closeApplicationContext();
	}

		
	/** This method gets all the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyZone objects
	 */
	
	public ObservableList<BodyZone> viewBodyZone() {
		
		observableList= FXCollections.observableArrayList(bodyZoneServiceImpl.bodyZoneList());
		
		//this.closeApplicationContext();
		return observableList;
	}
	
	
	/** This method update the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void modifyBodyZone(BodyZone bodyZone){
		
		bodyZoneServiceImpl.updateBodyZone(bodyZone);
		//this.closeApplicationContext();
	}
	
	
	/** This method Delete the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeBodyZone(Integer id){
		
		bodyZoneServiceImpl.deleteBodyZoneCode(id);
		//this.closeApplicationContext();
	}

}
