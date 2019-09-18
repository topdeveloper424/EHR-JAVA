package com.ets.controller.entity.companyStandardProtocolActivity;

import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.service.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityServiceImpl;
import com.ets.service.companyStandardProtocolActivity.CompanyStandardProtocolActivityServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompanyStandardProtocolActivityEntityController {
	
	private CompanyStandardProtocolActivityServiceImpl companyStandardProtocolActivityServiceImpl;
	private ObservableList<CompanyStandardProtocolActivity> observableList;


	public CompanyStandardProtocolActivityEntityController() {
		
		companyStandardProtocolActivityServiceImpl = (CompanyStandardProtocolActivityServiceImpl) Global.context
				.getBean("companyStandardProtocolActivityService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveCompanyStandardProtocolActivity(CompanyStandardProtocolActivity companyStandardProtocolActivity){
		
		companyStandardProtocolActivityServiceImpl.saveCompanyStandardProtocolActivity(companyStandardProtocolActivity);
	}
	
	public ObservableList<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivity(){
		
		observableList = FXCollections.observableArrayList(companyStandardProtocolActivityServiceImpl.viewCompanyStandardProtocolActivity());

		return observableList;
		
	}
	
	public ObservableList<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivityByProtocolId(Integer protocolId){
		
		observableList = FXCollections.observableArrayList(companyStandardProtocolActivityServiceImpl.viewCompanyStandardProtocolActivityByProtocolId(protocolId));

		return observableList;
		
	}
    public void delete(Integer companyStandardProtocolActivityId){
		
		companyStandardProtocolActivityServiceImpl.delete(companyStandardProtocolActivityId);
	}
     public void deleteByProtocolId(Integer companyProtocolId){
		
    	 companyStandardProtocolActivityServiceImpl.deleteByProtocolId(companyProtocolId);
	}
}
