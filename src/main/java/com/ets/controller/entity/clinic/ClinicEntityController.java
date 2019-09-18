 package com.ets.controller.entity.clinic;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Clinic;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.service.clinic.ClinicServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicEntityController Class
 *Description: Clinic Entity Non-GUI Controller class
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
public class ClinicEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private ClinicServiceImpl clinicServiceImpl;
	
	private ObservableList<Clinic> observableList;
	
	private ObservableList<String> observableList2;
	
		
	public ClinicEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		clinicServiceImpl = (ClinicServiceImpl) Global.context.getBean("clinicService");
		
		observableList = FXCollections.observableArrayList();
		observableList2 = FXCollections.observableArrayList();
		
			}
	
	/** This method save the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveClinic(Clinic clinic) {

		clinicServiceImpl.add(clinic);
		//this.closeApplicationConrext();
		
	}
	
	
	/** This method gets all the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Clinic objects
	 */
	
	public ObservableList<Clinic> viewClinic() {

		observableList = FXCollections.observableArrayList(clinicServiceImpl.list());

		//this.closeApplicationConrext();
		return observableList;

	}
	
	
	/** This method update the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void updateClinic(Clinic clinic) {

		clinicServiceImpl.update(clinic);
		//this.closeApplicationConrext();
		
	}
	
	
	
	
	
/*	
public ObservableList<Clinic> searchClinicById(Integer clinicId){
    	
    	observableList = FXCollections
				.observableArrayList(clinicServiceImpl.searchClinicById(clinicId));
    	//context.close();
		return observableList;
		
    }*/
	
	
	
	
	
	/** This method delete  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	
	public void removeClinic(Integer id){
		
		clinicServiceImpl.delete(id);
		//this.closeApplicationConrext();
	}
	
	
/*	public ObservableList<Clinic> searchClinic(String firstName, String lastName, Date dob,Integer clinic) {
		System.out.println("####### date"+dob);
		observableList = FXCollections.observableArrayList(clinicServiceImpl.searchClinicByName(firstName, lastName, dob,clinic));
		//this.closeApplicationContext();
		return observableList;
	}*/
	
	
	
	
	/** This method get  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param 
	 * @since 26-08-2016
	 * @version 1.0
	 * 
	 * @return clinicName
	 */
	
	public Clinic viewByName(String clinicName){
		
		observableList = FXCollections.observableArrayList(clinicServiceImpl.viewByName(clinicName));
		
		//this.closeApplicationConrext();
		return observableList.get(0);
		
	}

}
