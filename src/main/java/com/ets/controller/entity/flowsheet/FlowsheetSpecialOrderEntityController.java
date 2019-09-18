package com.ets.controller.entity.flowsheet;

import java.util.List;

import com.ets.model.FlowsheetSpecialOrder;
import com.ets.model.InjuryCode;
import com.ets.service.flowsheet.FlowsheetSpecialOrderServiceImpl;
import com.ets.service.injuryCode.InjuryCodeServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlowsheetSpecialOrderEntityController {
	
	private FlowsheetSpecialOrderServiceImpl flowsheetSpecialOrderServiceImpl;
	
	private ObservableList<FlowsheetSpecialOrder> observableList;

	public FlowsheetSpecialOrderEntityController() {
		
		flowsheetSpecialOrderServiceImpl = (FlowsheetSpecialOrderServiceImpl) Global.context.getBean("flowsheetSpecialOrderService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveFlowsheetSpecialOrder(FlowsheetSpecialOrder flowsheetSpecialOrder){
		
		flowsheetSpecialOrderServiceImpl.saveOrUpdateFlowsheetSpecialOrder(flowsheetSpecialOrder);
		
	}
	
	public ObservableList<FlowsheetSpecialOrder> viewFlowsheetSpecialOrder() {

		observableList = FXCollections.observableArrayList(flowsheetSpecialOrderServiceImpl.viewFlowsheetSpecialOrder());
		
		return observableList;

	}
	
	public ObservableList<FlowsheetSpecialOrder> viewByPatientVisitId(Integer patVisitid){
		
		observableList = FXCollections.observableArrayList(flowsheetSpecialOrderServiceImpl.viewByPatientVisitId(patVisitid));
		
		return observableList;
		
	}

	public void delete(FlowsheetSpecialOrder flowsheetSpecialOrder){
		flowsheetSpecialOrderServiceImpl.delete(flowsheetSpecialOrder);
	}
}
