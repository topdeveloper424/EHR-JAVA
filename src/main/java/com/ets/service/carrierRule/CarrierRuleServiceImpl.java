package com.ets.service.carrierRule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierRuleServiceImpl Class
 *Description: CarrierRule Entity Service Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.carrierRule.CarrierRuleDAO;
import com.ets.model.CarrierRule;

@Transactional
@Service
public class CarrierRuleServiceImpl implements CarrierRuleService {
	
	private CarrierRuleDAO carrierRuleDAO;

	public void setCarrierRuleDAO(CarrierRuleDAO carrierRuleDAO) {
		this.carrierRuleDAO = carrierRuleDAO;
	}

	@Override
	public void addOrUpdate(CarrierRule carrierRule) {
		
		carrierRuleDAO.addOrUpdate(carrierRule);
		
	}

	@Override
	public List<CarrierRule> view() {
		
		return carrierRuleDAO.view();
		
	}
	
}
