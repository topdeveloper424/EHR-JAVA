package com.ets.controller.entity.visitCategory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.UserAccount;
import com.ets.model.VisitCategory;
import com.ets.service.userAccount.UserAccountServiceImpl;
import com.ets.service.visitCategory.VisitCategoryServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 05-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryEntityController Class
 *Description: VisitCategory Entity Non-GUI Controller class
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

public class VisitCategoryEntityController {

	//private static ClassPathXmlApplicationContext context;
	private VisitCategoryServiceImpl visitCategoryServiceImpl;
	private ObservableList<VisitCategory> observableList;

	public VisitCategoryEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		visitCategoryServiceImpl = (VisitCategoryServiceImpl) Global.context.getBean("visitCategoryService");
		observableList = FXCollections.observableArrayList();

	}

	

	public void saveOrUpdate(VisitCategory visitCategory) {

		visitCategoryServiceImpl.addOrUpdate(visitCategory);
		//this.closeApplicationContext();

	}

	public ObservableList<VisitCategory> view() {

		observableList = FXCollections.observableArrayList(visitCategoryServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
	}
	
	public VisitCategory viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(visitCategoryServiceImpl.viewByCode(code));
		//this.closeApplicationContext();
		return observableList.get(0);
		
	}
	
	public void delete(Integer id){
		
		visitCategoryServiceImpl.delete(id);
		//context.close();
	}

	
	
}
