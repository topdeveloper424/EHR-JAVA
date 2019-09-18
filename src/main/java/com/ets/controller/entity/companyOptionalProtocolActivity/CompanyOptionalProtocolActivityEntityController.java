package com.ets.controller.entity.companyOptionalProtocolActivity;

import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.service.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityServiceImpl;
import com.ets.service.companyProtocol.CompanyProtocolServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompanyOptionalProtocolActivityEntityController {
	
	private CompanyOptionalProtocolActivityServiceImpl optionalProtocolActivityServiceImpl;
	private ObservableList<CompanyOptionalProtocolActivity> observableList;

	public CompanyOptionalProtocolActivityEntityController() {
		
		optionalProtocolActivityServiceImpl = (CompanyOptionalProtocolActivityServiceImpl) Global.context
				.getBean("companyOptionalProtocolActivityService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity companyOptionalProtocolActivity){
		
		optionalProtocolActivityServiceImpl.saveCompanyOptionalProtocolActivity(companyOptionalProtocolActivity);
	}
	
	public ObservableList<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivity(){
		
		observableList = FXCollections.observableArrayList(optionalProtocolActivityServiceImpl.viewCompanyOptionalProtocolActivity());

		return observableList;
		
	}
	
	public ObservableList<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivityByProtocolId(Integer protocolId){
		
		observableList = FXCollections.observableArrayList(optionalProtocolActivityServiceImpl.viewCompanyOptionalProtocolActivityByProtocolId(protocolId));

		return observableList;
		
	} public void delete(Integer companyOptionalProtocolActivityId){
		
		optionalProtocolActivityServiceImpl.delete(companyOptionalProtocolActivityId);
	} public void deleteByProtocolId(Integer companyProtocolId){
		
		optionalProtocolActivityServiceImpl.deleteByProtocolId(companyProtocolId);
	}
}
