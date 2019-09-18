package com.ets.controller.entity.assesment;

import com.ets.model.Assesment;
import com.ets.service.assesment.AssesmentServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AssessmentEntityController {

	private  AssesmentServiceImpl assesmentServiceImpl;
	private ObservableList<Assesment> observableList;
	
	public AssessmentEntityController() {
		assesmentServiceImpl = (AssesmentServiceImpl) Global.context.getBean("assesmentService");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(Assesment assesment) {
		assesmentServiceImpl.saveOrUpdate(assesment);

		
	}
	
	public ObservableList<Assesment> view(Integer id){
		
		observableList = FXCollections.observableArrayList(assesmentServiceImpl.search(id));
	
		return observableList;
		
	}
	
	public ObservableList<Assesment> view(){
		
		observableList = FXCollections.observableArrayList(assesmentServiceImpl.view());
	
		return observableList;
		
	}
	
	public void delete(Integer id){
		
		assesmentServiceImpl.delete(id);
		
	}
	
	
	
}
