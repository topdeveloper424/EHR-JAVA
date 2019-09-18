package com.ets.service.billingAccount;

import java.util.List;

import com.ets.model.BillingAccount;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingAccountService Interface
 *Description: BillingAccount Entity Service Interface
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

public interface BillingAccountService {
	
    public void saveOrUpdate(BillingAccount billingAccount);
    
    public List<BillingAccount> viewBilling();
    
    public BillingAccount viewByCode(String code);
    
    public void delete(Integer id);
    
}
