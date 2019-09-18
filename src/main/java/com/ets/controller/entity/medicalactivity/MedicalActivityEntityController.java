package com.ets.controller.entity.medicalactivity;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.MedicalActivity;
import com.ets.service.medicalactivity.MedicalActivityServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 09-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityEntityController Class
 *Description: Medical Activity Entity Non-GUI Controller class
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


public class MedicalActivityEntityController {
	
	//private static ClassPathXmlApplicationContext context;

	private MedicalActivityServiceImpl medicalActivityServiceImpl;

	private ObservableList<MedicalActivity> observableList;

	public MedicalActivityEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");

		medicalActivityServiceImpl = (MedicalActivityServiceImpl) Global.context
				.getBean("medicalActivityService");

		observableList = FXCollections.observableArrayList();

	}

	
	/** This method save the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveMedicalActivity(MedicalActivity medicalActivity) {

		medicalActivityServiceImpl.addMedicalActivity(medicalActivity);
		//this.closeApplicationContext();

	}

	/** This method gets all the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param Nothing
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	public ObservableList<MedicalActivity> viewMedicalActivity() {

		observableList = FXCollections.observableArrayList(medicalActivityServiceImpl.medicalActivityList());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateDivision(MedicalActivity medicalActivity){
		
		medicalActivityServiceImpl.updateMedicalActivity(medicalActivity);
		//this.closeApplicationContext();
	}
	
	/** This method delete the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeMedicalActivity(Integer id){
		
		medicalActivityServiceImpl.deleteMedicalActivity(id);
		//this.closeApplicationContext();
	}
	
	/** This method gets  the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	
	public ObservableList<MedicalActivity> viewDivisionByDivisionId(Integer id) {

		observableList = FXCollections.observableArrayList(medicalActivityServiceImpl.viewMedicalActivityById(id));
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method gets  the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param code
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	public MedicalActivity viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(medicalActivityServiceImpl.viewByCode(code));
		//this.closeApplicationContext();
		return observableList.get(0);
		
	}
    public MedicalActivity searchByDescp(String descp){
		
		observableList = FXCollections.observableArrayList(medicalActivityServiceImpl.searchByDescription(descp));
		//this.closeApplicationContext();
		return observableList.get(0);
		
	}
}
