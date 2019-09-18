package com.ets.service.flowsheet;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.flowsheet.FlowsheetSpecialOrderDAO;
import com.ets.model.FlowsheetSpecialOrder;

@Service
@Transactional
public class FlowsheetSpecialOrderServiceImpl implements FlowsheetSpecialOrderService {
	
	private FlowsheetSpecialOrderDAO flowsheetSpecialOrderDAO;

	public void setFlowsheetSpecialOrderDAO(FlowsheetSpecialOrderDAO flowsheetSpecialOrderDAO) {
		this.flowsheetSpecialOrderDAO = flowsheetSpecialOrderDAO;
	}

	@Override
	public void saveOrUpdateFlowsheetSpecialOrder(FlowsheetSpecialOrder flowsheetSpecialOrder) {
		
		flowsheetSpecialOrderDAO.saveOrUpdateFlowsheetSpecialOrder(flowsheetSpecialOrder);
		
	}

	@Override
	public List<FlowsheetSpecialOrder> viewFlowsheetSpecialOrder() {
		
		return flowsheetSpecialOrderDAO.viewFlowsheetSpecialOrder();
	}

	@Override
	public List<FlowsheetSpecialOrder> viewByPatientVisitId(Integer patVisitid) {
		
		return flowsheetSpecialOrderDAO.viewByPatientVisitId(patVisitid);
	}

	@Override
	public void delete(FlowsheetSpecialOrder flowsheetSpecialOrder) {
		flowsheetSpecialOrderDAO.delete(flowsheetSpecialOrder);
		
	}

}
