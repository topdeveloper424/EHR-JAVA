package com.ets.controller.entity.icd10Codes;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Icd10CodesEntityController Class
 *Description: Icd10Codes Entity Non-GUI Controller class
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Division;
import com.ets.model.Icd10Codes;
import com.ets.service.Icd10Codes.Icd10CodesServiceImpl;
import com.ets.utils.Global;

public class Icd10CodesEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private static Icd10CodesServiceImpl icd10CodesServiceImpl;
	private ObservableList<Icd10Codes> observableList;
	
	public Icd10CodesEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		icd10CodesServiceImpl = (Icd10CodesServiceImpl) Global.context
				.getBean("icd10CodesService");
		observableList = FXCollections.observableArrayList();
	}
	
	
	/** This method save the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param icd10Codes
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveOrUpdateIcd10Codes(Icd10Codes icd10Codes) {
		icd10CodesServiceImpl.addIcd10Codes(icd10Codes);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Icd10Codes objects
	 */
	
	public ObservableList<Icd10Codes> viewIcd10Codes() {
		
		observableList= FXCollections.observableArrayList(icd10CodesServiceImpl.icd10CodesList());
		
		//this.closeApplicationContext();
		return observableList;
	}
	
	public Icd10Codes viewICD10CodeId(Integer id) {

		observableList = FXCollections.observableArrayList(icd10CodesServiceImpl.getbyIcd10CodesID(id));
		//this.closeApplicationContext();
		return observableList.get(0);
	}
	
	public Icd10Codes viewICD10CodeByCode(String code) {

		observableList = FXCollections.observableArrayList(icd10CodesServiceImpl.getByICD10Code(code));
		//this.closeApplicationContext();
		return observableList.get(0);
	}

}
