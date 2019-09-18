package com.ets.controller.entity.caseClosedReason;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BodyZone;
import com.ets.model.CaseClosedReason;
import com.ets.service.caseClosedReason.CaseClosedReasonStatusServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonStatusEntityController Class
 *Description: CaseClosedReason Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.


 */

public class CaseClosedReasonStatusEntityController {

	//private static ClassPathXmlApplicationContext context;

	private CaseClosedReasonStatusServiceImpl statusServiceImpl;

	private ObservableList<CaseClosedReason> observableList;

	public CaseClosedReasonStatusEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");

		statusServiceImpl = (CaseClosedReasonStatusServiceImpl) Global.context
				.getBean("caseClosedReasonStatusService");

		observableList = FXCollections.observableArrayList();

	}

	

	/** This method Save the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveCaseClosedReason(CaseClosedReason caseClosedReason) {

		statusServiceImpl.addCaseClosedReason(caseClosedReason);
		//this.closeApplicationContext();
	}

	
	/** This method gets all the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CaseClosedReason objects
	 */
	
	public ObservableList<CaseClosedReason> viewCaseClosedReason() {

		observableList = FXCollections.observableArrayList(statusServiceImpl
				.caseClosedReasonList());

		//this.closeApplicationContext();
		return observableList;
	}
	
	
	/** This method Update the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void modifyCaseClosedReason(CaseClosedReason caseClosedReason){
		
		statusServiceImpl.updateCaseClosedReason(caseClosedReason);
		//this.closeApplicationContext();
		
	}
	
	/** This method Delete the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeCaseClosedReason(Integer id){
		
		statusServiceImpl.deleteCaseClosedReason(id);
		//this.closeApplicationContext();
		
	}

}
