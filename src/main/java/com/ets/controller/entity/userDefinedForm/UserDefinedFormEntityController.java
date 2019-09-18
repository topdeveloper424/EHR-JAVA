package com.ets.controller.entity.userDefinedForm;

import com.ets.model.SICCode;
import com.ets.model.UserDefinedForm;
import com.ets.service.userDefinedForm.UserDefinedFormServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDefinedFormEntityController {
	
	private UserDefinedFormServiceImpl definedFormServiceImpl;
	private ObservableList<UserDefinedForm> observableList;

	public UserDefinedFormEntityController() {
		
		definedFormServiceImpl = (UserDefinedFormServiceImpl) Global.context.getBean("userDefinedFormService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveUserDefinedForm(UserDefinedForm userDefinedForm){
		
		definedFormServiceImpl.saveForm(userDefinedForm);
		
	}
	
	public ObservableList<UserDefinedForm> viewUserDefinedForm() {

		observableList = FXCollections.observableArrayList(definedFormServiceImpl.viewAllForm());
		
		return observableList;
	}
	public void delete(UserDefinedForm userDefinedForm){
		
		definedFormServiceImpl.delete(userDefinedForm);
		
	}

}
