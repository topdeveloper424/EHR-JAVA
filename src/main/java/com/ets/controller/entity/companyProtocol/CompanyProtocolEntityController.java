package com.ets.controller.entity.companyProtocol;

import com.ets.model.CompanyProtocol;
import com.ets.model.Complex;
import com.ets.service.companyProtocol.CompanyProtocolServiceImpl;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompanyProtocolEntityController {
	
	private CompanyProtocolServiceImpl companyProtocolServiceImpl;
	private ObservableList<CompanyProtocol> observableList;

	public CompanyProtocolEntityController() {
		
		companyProtocolServiceImpl = (CompanyProtocolServiceImpl) Global.context
				.getBean("companyProtocolService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveCompanyProtocol(CompanyProtocol companyProtocol){
		
		companyProtocolServiceImpl.saveCompanyProtocol(companyProtocol);
		
	}
	
	public ObservableList<CompanyProtocol> viewCompanyProtocol() {

		observableList = FXCollections.observableArrayList(companyProtocolServiceImpl.viewCompanyProtocol());

		return observableList;

	}
	
	public ObservableList<CompanyProtocol> viewCompanyProtocolByCompanyId(Integer comId) {

		observableList = FXCollections.observableArrayList(companyProtocolServiceImpl.viewCompanyProtocolByCompanyId(comId));

		return observableList;

	}
	
	public CompanyProtocol viewByCompanyIdAndDescription(Integer compId , String description) {

		observableList = FXCollections.observableArrayList(companyProtocolServiceImpl.viewByDescripAndId(compId, description));

		return observableList.get(0);

	}
	
	public CompanyProtocol viewByCompanyIdAndVisitCategoryId(Integer compId , Integer vCatId) {

		observableList = FXCollections.observableArrayList(companyProtocolServiceImpl.viewByVCatIdAndCompId(compId, vCatId));

		return observableList.get(0);

	}
	public void delete(Integer id){
		companyProtocolServiceImpl.delete(id);
		
	}

}
