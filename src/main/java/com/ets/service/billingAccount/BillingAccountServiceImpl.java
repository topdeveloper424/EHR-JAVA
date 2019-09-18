package com.ets.service.billingAccount;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.billingAccount.BillingAccountDAO;
import com.ets.model.BillingAccount;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingAccountServiceImpl Class
 *Description: BillingAccount Entity Service Class
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

@Service
@Transactional
public class BillingAccountServiceImpl implements BillingAccountService {

	private BillingAccountDAO billingAccountDAO;

	public void setBillingAccountDAO(BillingAccountDAO billingAccountDAO) {
		this.billingAccountDAO = billingAccountDAO;
	}

	@Override
	public void saveOrUpdate(BillingAccount billingAccount) {
		
		billingAccountDAO.saveOrUpdate(billingAccount);

	}

	@Override
	public List<BillingAccount> viewBilling() {
		
		return billingAccountDAO.view();
		
	}

	@Override
	public BillingAccount viewByCode(String code) {
		
		return billingAccountDAO.viewByCode(code);
	}

	@Override
	public void delete(Integer id) {
		
		billingAccountDAO.delete(id);
		
	}

}
