package com.ets.controller.entity.workRestriction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.WorkRestriction;
import com.ets.service.workRestriction.WorkRestrictionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionEntityController Class
 *Description: WorkRestriction Entity Non-GUI Controller class
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

public class WorkRestrictionEntityController {

	//private static ClassPathXmlApplicationContext context;
	private WorkRestrictionServiceImpl workRestrictionServiceImpl;
	private ObservableList<WorkRestriction> observableList;

	public WorkRestrictionEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		workRestrictionServiceImpl = (WorkRestrictionServiceImpl) Global.context.getBean("workRestrictionService");
		observableList = FXCollections.observableArrayList();

	}

	

	public void save(WorkRestriction workRestriction) {

		workRestrictionServiceImpl.add(workRestriction);
		//this.closeApplicationContext();
	}

	public ObservableList<WorkRestriction> view() {

		observableList = FXCollections.observableArrayList(workRestrictionServiceImpl.list());
		//this.closeApplicationContext();
		return observableList;

	}

	public void update(WorkRestriction workRestriction) {

		workRestrictionServiceImpl.update(workRestriction);
		//this.closeApplicationContext();
	}

	public void delete(Integer id) {

		workRestrictionServiceImpl.delete(id);
		//this.closeApplicationContext();
	}

}
