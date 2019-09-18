package com.ets.dao.billingAccount;

import java.util.List;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingAccountDAO Interface
 *Description: BillingAccount Entity Non-GUI Controller Interface
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

import com.ets.model.BillingAccount;

public interface BillingAccountDAO {
	
   public void saveOrUpdate(BillingAccount billingAccount);
   
   public List<BillingAccount> view();
   
   public BillingAccount viewByCode(String code);
   
   public void delete(Integer id);
   
}
