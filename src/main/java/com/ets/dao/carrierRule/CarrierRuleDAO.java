package com.ets.dao.carrierRule;

import java.util.List;

import com.ets.model.CarrierRule;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierRuleDAO Interface
 *Description: CarrierRule Entity DAO Interface
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

public interface CarrierRuleDAO {
	
	public void addOrUpdate(CarrierRule carrierRule);
	
	public List<CarrierRule> view();

}
