package com.ets.controller.gui.appointment.schedule;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 30-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AppointmentSchedulingGUIController Class
 *Description: AppointmentScheduling.fxml Controller class
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


import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ScheduleController implements Initializable {


	   @FXML
	    private Button scheduleNewAppointmentBtn;

	    @FXML
	    private Button changeAppointment;

	    @FXML
	    private Button cancelButton;
	    
	    
   public static  AppointmentController appointmentController;
   
    
	public void setAppointmentController(AppointmentController appointmentController) {
			this.appointmentController = appointmentController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		scheduleNewAppointmentBtn.setOnAction((event) -> {
			try {
				
				String formName = "/view/code/appointmentSetup/patient/Search.fxml";
				String formTitle1 = "Search  Patient" ;
				//String formTitle2 = Global.company.getName();
				String formTitle2 = null;
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
				String formTitle=formTitle1+"/"+formTitle2;
				SearchPatientController searchPatientController =
				(SearchPatientController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				searchPatientController.setScheduleController(this, scheduleNewAppointmentBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeAppointment.setOnAction((event) -> {
			try {
				
				String formName = "/view/code/appointmentSetup/patient/Search.fxml";
				String formTitle = "Search  Patient" ;
				
				SearchPatientController searchPatientController =
				(SearchPatientController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				searchPatientController.setScheduleController(this, changeAppointment);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelButton.setOnAction((event) -> {
			// Cancel centralized Form
			
			try {
				
				new FXFormCommonUtilities().closeForm(cancelButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
