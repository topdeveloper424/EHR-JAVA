package com.ets.controller.entity.drugScreenResult;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.service.drugScreenResult.DrugScreenResultServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DrugScreenResultEntityController {
	//private static ClassPathXmlApplicationContext context;

	private DrugScreenResultServiceImpl drugScreenResultServiceImpl;

	private DrugScreenResult drugScreenResult;
	
	private DrugScreenTestResult drugScreenTestResult ;
	
	
	private ObservableList<DrugScreenResult> observableList;

	public DrugScreenResultEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");

		drugScreenResultServiceImpl = (DrugScreenResultServiceImpl) Global.context.getBean("drugScreenResultService");

		observableList = FXCollections.observableArrayList();

	}

	public void saveOrUpdate(DrugScreenResult drugScreenResult) {
		drugScreenResultServiceImpl.saveOrUpdate(drugScreenResult);
		
	}

	public ObservableList<DrugScreenResult> viewDrugScreenResult() {

		observableList = FXCollections
				.observableArrayList(drugScreenResultServiceImpl.ViewDrugScreenResult());
		
		return observableList;
	}

	public void delete(Integer id) {
		drugScreenResultServiceImpl.delete(id);
		
	}
	
	
	
	
	
	public void deleteMedActCharge(Integer id){
		if(drugScreenTestResult!= null && drugScreenTestResult.getDrugScreenId().getId() == drugScreenTestResult.getId()){
			new DrugScreenTestResultEntityController().deleteDrugScreenResult(drugScreenResult.getId());
			new DrugScreenResultEntityController().delete(drugScreenResult.getId());
		
		} else {
		drugScreenResultServiceImpl.deleteMedActCharge(id);
	}
	}
	
	
	
	
	
	
	public DrugScreenResult viewDrugScreenResult(Integer patVisitId) {

		observableList = FXCollections
				.observableArrayList(drugScreenResultServiceImpl.viewByPatientVisitId(patVisitId));
	
		return observableList.get(0);
	}

	public DrugScreenResult viewByMedicalChargeId(Integer patVisitId,Integer medActChargeId){
		
		return drugScreenResultServiceImpl.viewByMedicalChargeId(patVisitId, medActChargeId);
	}
	
}
