package com.ets.controller.entity.billingServiceType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ets.model.BillingServiceType;
import com.ets.service.billingservicetype.BillingTypeServiceImpl;
import com.ets.utils.Global;

/**
 * On Behalf of ETS for Client Company
 * 
 * Parameter Definition: Type object of BillingServiceTypeEntityController Class
 * Description: BillingServiceType Entity Non-GUI Controller class Copyright
 * 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 *
 * @author Sumanta Deyahi
 * @since 23-02-2016
 * @version 1.0
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

public class BillingServiceTypeEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private BillingTypeServiceImpl billingTypeServiceImpl;
	
	private ObservableList< BillingServiceType> observableList;  

	public BillingServiceTypeEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		billingTypeServiceImpl=(BillingTypeServiceImpl) Global.context.getBean("billingTypeServiceIm");
observableList=FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveBillingService(BillingServiceType billingServiceType){
		
		billingTypeServiceImpl.addBillingServiceType(billingServiceType);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	
	public ObservableList<BillingServiceType> viewBillingService(){
		
		observableList=FXCollections.observableArrayList(billingTypeServiceImpl.billingServiceTypeLists());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	/** This method update the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void updateBillingServiceType(BillingServiceType billingServiceType){
		
		billingTypeServiceImpl.updateBillingServiceType(billingServiceType);
		//this.closeApplicationContext();
	}
	
	
	/** This method remove the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeBillingServiceType(Integer id){
		
		billingTypeServiceImpl.deleteBillingServiceType(id);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	
	public BillingServiceType viewById(Integer id){
		
		observableList=FXCollections.observableArrayList(billingTypeServiceImpl.viewById(id));
		//this.closeApplicationContext();
		return observableList.get(0);
		
	}
	
}
