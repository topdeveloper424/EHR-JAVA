package com.ets.controller.entity.billingAccount;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingAccountEntityController Class
 *Description: BillingAccount Entity Non-GUI Controller class
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BillingAccount;
import com.ets.service.billingAccount.BillingAccountServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BillingAccountEntityController {

	//private static ClassPathXmlApplicationContext context;
	private BillingAccountServiceImpl billingAccountServiceImpl;
	private ObservableList<BillingAccount> observableList;

	public BillingAccountEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		billingAccountServiceImpl = (BillingAccountServiceImpl) Global.context.getBean("billingAccountService");
		observableList = FXCollections.observableArrayList();
		

	}

	public void saveOrUpdate(BillingAccount billinAccount) {
		billingAccountServiceImpl.saveOrUpdate(billinAccount);

		
	}
	
	public ObservableList<BillingAccount> view(){
		
		observableList = FXCollections.observableArrayList(billingAccountServiceImpl.viewBilling());
	
		return observableList;
		
	}
	
	public BillingAccount viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(billingAccountServiceImpl.viewByCode(code));
		
		return observableList.get(0);
	}
	
	public void delete(Integer id){
		
		billingAccountServiceImpl.delete(id);
	
	}

}