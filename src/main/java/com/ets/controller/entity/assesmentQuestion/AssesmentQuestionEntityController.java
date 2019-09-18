package com.ets.controller.entity.assesmentQuestion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.AssesmentQuestion;
import com.ets.service.assesmentQuestion.AssesmentQuestionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *On Behalf of ETS for Client Company
 *@since 27-07-2016
 *@version 1.0
 *@author Sumanta Deyahi
 * *Parameter Definition: Type object of AssesmentQuestionEntityController Class
 *Description: AssesmentQuestion Entity Non-GUI Controller class
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


public class AssesmentQuestionEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private AssesmentQuestionServiceImpl  assesmentQuestionServiceImpl;
	private ObservableList<AssesmentQuestion> observableList;
	
	public AssesmentQuestionEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		assesmentQuestionServiceImpl = (AssesmentQuestionServiceImpl) Global.context.getBean("assesmentQuestionService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void save(AssesmentQuestion assesmentQuestion){
		
		assesmentQuestionServiceImpl.add(assesmentQuestion);
		//this.closeApplicationContext();
	}
	
	public ObservableList<AssesmentQuestion> view(){
		
		observableList = FXCollections.observableArrayList(assesmentQuestionServiceImpl.list());
		//this.closeApplicationContext();
		return observableList;
	}
	
	public void update(AssesmentQuestion assesmentQuestion){
		
		assesmentQuestionServiceImpl.update(assesmentQuestion);
		//this.closeApplicationContext();
	}
	
	public void delete(Integer id){
		assesmentQuestionServiceImpl.delete(id);
		//this.closeApplicationContext();
	}

}
