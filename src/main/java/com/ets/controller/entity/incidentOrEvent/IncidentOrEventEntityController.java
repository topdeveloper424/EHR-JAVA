package com.ets.controller.entity.incidentOrEvent;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.IncidentOrEvent;
import com.ets.service.incidentOrEvent.IncidentOrEventServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventEntityController Class
 *Description: IncidentOrEvent Entity Non-GUI Controller class
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

public class IncidentOrEventEntityController {

	//private static ClassPathXmlApplicationContext context;
	private static IncidentOrEventServiceImpl serviceImpl;
	private ObservableList<IncidentOrEvent> observableList;

	public IncidentOrEventEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		serviceImpl = (IncidentOrEventServiceImpl) Global.context
				.getBean("incidentOrEventService");
		observableList = FXCollections.observableArrayList();

	}

	

	/** This method save the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	
	public void saveIncidentorEvent(IncidentOrEvent incidentOrEvent) {
		serviceImpl.addIncidentOrEvent(incidentOrEvent);
		//this.closeApplicationContext();
	}

	/** This method gets all the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	
	public ObservableList<IncidentOrEvent> viewIncidentOrEvent() {
		observableList = FXCollections.observableArrayList(serviceImpl
				.incidentOrEventLists());
		//this.closeApplicationContext();
		return observableList;
	}

	/** This method update the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	
	public void modifyIncidentOrEvent(IncidentOrEvent incidentOrEvent) {

		serviceImpl.updateIncidentOrEvent(incidentOrEvent);
		//this.closeApplicationContext();
	}
	
	/** This method delete the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	public void removeIncidentOrEvent(Integer id){
		
		serviceImpl.deleteIncidentOrEvent(id);
		//this.closeApplicationContext();
		
	}

}
