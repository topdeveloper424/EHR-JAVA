package com.ets.controller.entity.parentEmployerGroup;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ets.model.ParentEmployerGroup;
import com.ets.service.parentEmployerGroup.ParentEmployerGroupServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 25-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupEntityController Class
 *Description: ParentEmployerGroup Entity Non-GUI Controller class
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

public class ParentEmployerGroupEntityController {

	//private static ClassPathXmlApplicationContext context;

	private ParentEmployerGroupServiceImpl parentEmployerGroupServiceImpl;

	private ObservableList<ParentEmployerGroup> observableList;

	public ParentEmployerGroupEntityController() {

	//	context = new ClassPathXmlApplicationContext("spring.xml");
		parentEmployerGroupServiceImpl = (ParentEmployerGroupServiceImpl) Global.context.getBean("parentEmployerGroupService");
		observableList = FXCollections.observableArrayList();
	}

	public void add(ParentEmployerGroup parentEmployerGroup) {

		parentEmployerGroupServiceImpl.add(parentEmployerGroup);
		//this.closeApplicationContext();

	}

	public ObservableList<ParentEmployerGroup> viewParentEmployerGroup() {

		observableList = FXCollections.observableArrayList(parentEmployerGroupServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
	}

	public void delete(Integer id) {

		parentEmployerGroupServiceImpl.delete(id);
		//this.closeApplicationContext();

	}

}
