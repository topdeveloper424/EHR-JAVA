package com.ets.controller.gui.visitLog;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 29-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitLogSelectController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 *
 *Modification:  
 *Owner:   
 *Date:
 *Version: 0.02
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.


*/

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VisitLogSelectController implements Initializable {
	
	 	@FXML
	    private Button walkInButton;

	    @FXML
	    private Button searchScheduleButton;

	    @FXML
	    private Button cancelButton;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    public AppointmentController appointmentController;
        private ObservableList<PatientAppointment> appointmentList=FXCollections.observableArrayList();

		public void setAppointmentController(AppointmentController appointmentController,ObservableList<PatientAppointment> appointmentList) {
			this.appointmentController = appointmentController;
			this.appointmentList = appointmentList;
		}
		
		private PatientViewController patientViewController;


	   public void setPatientViewController(PatientViewController patientViewController) {
			this.patientViewController = patientViewController;
		}
      private SearchPatientController searchPatientController;

	  public void setSearchPatientController(SearchPatientController searchPatientController,PatientAppointment patientAppointment) {
		this.searchPatientController = searchPatientController;
		if(patientAppointment!=null){
		this.appointmentList.add(patientAppointment);
		Global.patient=patientAppointment.getPatient();
		Global.company=patientAppointment.getPatient().getCompany();
		
	     }
	  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		walkInButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);
				

				VisitLogInputController visitLogInputController= (VisitLogInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle1);
				
				 
				 String formTitle2  = null;
				 String formTitle4= null;
				 
				 if(patientViewController != null){
					 visitLogInputController.setVisitLogSelectController(this);
					
				 }else{
					 visitLogInputController.setVisitLogSelectController(this,appointmentList.get(0));
					 if(appointmentList.size()==0){
						 formTitle2 = Global.patient.getPatientName().getFirstName();
						if(Global.patient.getCompany().getName()!=null){
						 formTitle4 = Global.patient.getCompany().getName();
						}else{
							formTitle4 ="";
						}
						
					}else
					   {
						 formTitle2 = appointmentList.get(0).getPatient().getPatientName().getFirstName();
						 
						 if(appointmentList.get(0).getPatient().getCompany().getName()==null){
						
							 formTitle4 = "";
							
						 }else{
							 formTitle4 = appointmentList.get(0).getPatient().getCompany().getName();
						 }
						
					}
				 }
				
				String formTitle3= Global.clinic.getName();
				
				
				
				//String formTitle4= Global.patient.getCompany().getName();
			     
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3+"/"+formTitle4;
				
				
				
				formPath.closeApplicationContext();
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		searchScheduleButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewPatientAppointment", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewPatientAppointment", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle3= Global.clinic.getName();
				
				String formTitle4= null;
				if(Global.patient.getCompany() == null){
					formTitle4 = "";
				}else{
					formTitle4 = Global.patient.getCompany().getName();
				}
				//String formTitle4= Global.patient.getCompany().getName();
			     
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3+"/"+formTitle4;
				
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelButton.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
