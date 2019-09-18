package com.ets.controller.entity.entityGroup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.EntityGroup;
import com.ets.service.entityGroup.EntityGroupServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntityGroupEntityController Class
 *Description: EntityGroup Entity Non-GUI Controller class
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

public class EntityGroupEntityController {

	//private static ClassPathXmlApplicationContext context;
	private EntityGroupServiceImpl entityGroupServiceImpl;
	private ObservableList<EntityGroup> observableList;

	public EntityGroupEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		entityGroupServiceImpl = (EntityGroupServiceImpl) Global.context.getBean("entityGroupService");
		observableList = FXCollections.observableArrayList();

	}

	
	/**
	 * This method save Or update the EntityGroup objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param entityGroup
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void addOrUpdate(EntityGroup entityGroup) {

		entityGroupServiceImpl.addOrUpdate(entityGroup);
		//this.closeApplicationContext();

	}

	/**
	 * This method gets all the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of entityGroup objects
	 */
	
	public ObservableList<EntityGroup> view() {

		observableList = FXCollections.observableArrayList(entityGroupServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;

	}

	/**
	 * This method delete the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	
	public void delete(Integer id) {

		entityGroupServiceImpl.delete(id);
		//this.closeApplicationContext();

	}

}
