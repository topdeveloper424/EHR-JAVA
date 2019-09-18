package com.ets.controller.entity.medicalCondition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.MedicalCondition;
import com.ets.service.medicalcondition.MedicalConditionServiceImpl;
import com.ets.utils.Global;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalConditionCodeEntityController Class
 *Description: MedicalCondition Entity Non-GUI Controller class
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
public class MedicalConditionCodeEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private static MedicalConditionServiceImpl medicalConditionServiceImpl;
	private ObservableList<MedicalCondition> medicalConditionsList;

	public MedicalConditionCodeEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		medicalConditionServiceImpl = (MedicalConditionServiceImpl) Global.context.getBean("medicalConditionService");
		medicalConditionsList = FXCollections.observableArrayList();
		
	}
	
	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	public ObservableList< MedicalCondition> getMedicalList(){
		
		medicalConditionsList = FXCollections.observableArrayList(medicalConditionServiceImpl.listMedicalConditions());
		//this.closeApplicationContext();
		return medicalConditionsList;
	}
	
	/** This method save the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void addOrUpdateMedicalCondition(MedicalCondition medicalCondition){
		
		medicalConditionServiceImpl.addMedicalCondition(medicalCondition);
		//this.closeApplicationContext();
		
		
	}
	
	/** This method update the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateMedicalCondition(MedicalCondition medicalCondition){
		
		medicalConditionServiceImpl.updateMedicalCondition(medicalCondition);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	
	public MedicalCondition viewByCode(String code){
		
		medicalConditionsList = FXCollections.observableArrayList(medicalConditionServiceImpl.viewByCode(code));
		//this.closeApplicationContext();
		return medicalConditionsList.get(0) ;
		
	}
	
	public void delete(Integer id){
		medicalConditionServiceImpl.delete(id);
	}

}
