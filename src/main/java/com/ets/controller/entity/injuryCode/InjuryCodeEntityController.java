package com.ets.controller.entity.injuryCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.InjuryCode;
import com.ets.service.injuryCode.InjuryCodeServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeEntityController Class
 *Description: InjuryCode Entity Non-GUI Controller class
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

public class InjuryCodeEntityController {

	//private static ClassPathXmlApplicationContext context;

	private InjuryCodeServiceImpl injuryCodeServiceImpl;

	private ObservableList<InjuryCode> observableList;

	public InjuryCodeEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		injuryCodeServiceImpl = (InjuryCodeServiceImpl) Global.context.getBean("injuryCodeService");
		observableList = FXCollections.observableArrayList();

	}

	
	/** This method save the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveInjuryCode(InjuryCode injuryCode) {

		injuryCodeServiceImpl.addInjuryCode(injuryCode);
		//this.closeApplicationContext();

	}

	/** This method gets all the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of InjuryCode objects
	 */
	public ObservableList<InjuryCode> viewInjuryCode() {

		observableList = FXCollections.observableArrayList(injuryCodeServiceImpl.injuryCodeList());
		//this.closeApplicationContext();
		return observableList;

	}
	
	/** This method update the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateInjuryCode(InjuryCode injuryCode){
		
		injuryCodeServiceImpl.updateInjuryCode(injuryCode);
		//this.closeApplicationContext();
	}
	
	/** This method save the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeInjuryCode(Integer id){
		
		injuryCodeServiceImpl.deleteInjuryCode(id);
		//this.closeApplicationContext();
	}

}
