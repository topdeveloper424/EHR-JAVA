package com.ets.service.flowsheet;

import java.util.List;

import com.ets.model.FlowsheetSpecialOrder;

public interface FlowsheetSpecialOrderService {
	
	public void saveOrUpdateFlowsheetSpecialOrder(FlowsheetSpecialOrder flowsheetSpecialOrder);
	public List<FlowsheetSpecialOrder> viewFlowsheetSpecialOrder();
	public List<FlowsheetSpecialOrder> viewByPatientVisitId(Integer patVisitid);
	public void delete(FlowsheetSpecialOrder flowsheetSpecialOrder);
}
