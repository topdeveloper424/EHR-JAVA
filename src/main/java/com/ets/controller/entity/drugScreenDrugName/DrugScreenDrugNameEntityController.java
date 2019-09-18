package com.ets.controller.entity.drugScreenDrugName;

import com.ets.model.Division;
import com.ets.model.DrugScreenDrugName;
import com.ets.model.DrugScreenResult;
import com.ets.service.drugScreenDrugName.DrugScreenDrugNameServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DrugScreenDrugNameEntityController {
	
	
	private DrugScreenDrugNameServiceImpl drugScreenDrugNameServiceImpl;
	
	private ObservableList<DrugScreenDrugName> observableList;

	public DrugScreenDrugNameEntityController() {
		
		drugScreenDrugNameServiceImpl = (DrugScreenDrugNameServiceImpl) Global.context.getBean("drugScreenDrugNameService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public ObservableList<DrugScreenDrugName> viewDrugScreenResult(String activityCodeName) {

		observableList = FXCollections
				.observableArrayList(drugScreenDrugNameServiceImpl.view(activityCodeName));
		
		return observableList;
	}
	
	
}
