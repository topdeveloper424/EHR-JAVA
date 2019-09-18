package com.ets.dao.billingservicetype;

import java.util.List;

import com.ets.model.BillingServiceType;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingServiceTypeDAO Interface
 *Description: BillingServiceType Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface BillingServiceTypeDAO {
	
	public void addBillingServiceType(BillingServiceType billingServiceType);
	
	public List<BillingServiceType> billingServiceTypeLists();
	
	public void updateBillingServiceType(BillingServiceType billingServiceType);
	
	public BillingServiceType getByBillingServiceTypeID(Integer id);
	
	public void deleteBillingServiceType(Integer id);
	
	public BillingServiceType viewById(Integer id);

}
