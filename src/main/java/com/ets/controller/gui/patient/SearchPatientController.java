package com.ets.controller.gui.patient;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.appointment.PatientAppointmentEditController;
import com.ets.controller.gui.appointment.PatientAppointmentViewController;
import com.ets.controller.gui.appointment.schedule.ScheduleController;
import com.ets.controller.gui.emrCharting.exam.skin.examComprehensive.ExamComprehensiveMultiInputController;
import com.ets.controller.gui.patientVisitByDate.PatientVisitByDateViewController;
import com.ets.controller.gui.visitLog.VisitLogSelectController;
import com.ets.controller.mainWindowGUIController.HomePanelController;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.model.Clinic;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 30-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SearchPatientGUIController Class
 *Description: SearchPatient.fxml Controller class
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

public class SearchPatientController implements Initializable {

	@FXML
	private TextField lastNameText;

	@FXML
	private TextField firstNameText;

	@FXML
	private DatePicker dobDateText;

	@FXML
	private Button searchBtn;

	@FXML
	private Button okBtn;

	@FXML
	private Button cancelButton;
	@FXML
    private TextField padSystemId;

    @FXML
    private TextField socialSecurityNo;
    @FXML
    void onKeyTypeFirstName(KeyEvent event) {
   
      padSystemId.setText("");
      socialSecurityNo.setText("");
    }

    @FXML
    void onKeyTypeLastName(KeyEvent event) {
    
    padSystemId.setText("");
    socialSecurityNo.setText("");
  
    }

	public AppointmentController appointmentController;
	private PatientAppointment pattientAppointment;
	private String menuStr;
	public void setAppointmentController(AppointmentController appointmentController,PatientAppointment pattientAppointment,String menuStr) {
		this.appointmentController = appointmentController;
		this.pattientAppointment=pattientAppointment;
		this.menuStr=menuStr;
		if(menuStr!=null){// changing only one appt .no need to search
			searchBtn.setDisable(true);
		}
		
		if(pattientAppointment!=null){
		
		padSystemId.setText(pattientAppointment.getPatient().getId().toString());
		socialSecurityNo.setText(pattientAppointment.getPatient().getSocialSecurityNo());
		lastNameText.setText(pattientAppointment.getPatient().getPatientName().getLastName());
		firstNameText.setText(pattientAppointment.getPatient().getPatientName().getFirstName());
		
	}
	}
	@FXML
    void enterKeyPressedFoCancelButton(KeyEvent event) {
		
		if(event.getCode() == KeyCode.ENTER){
		try {

			new FXFormCommonUtilities().closeForm(cancelButton);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		}
    }

    @FXML
    void enterKeyPressedFoOkButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		
    	}

    }

    @FXML
    void enterKeyPressedFoSearchListButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {

				String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
				formPath.closeApplicationContext();
				
				Date date1= null;
				LocalDate localDate1 = dobDateText.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
				}
					 patientList = new PatientEntityController().searchPatient(
								 firstNameText.getText(), lastNameText.getText(), date1,Global.clinic.getId());
					
				
						/* new PharmacyEntityController().searchPharmacy(
						pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());*/
				
				
                PatientViewController patientViewController = 
				(PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                patientViewController.setSearchPatientController(this);
                
               
			} catch (Exception ex) {
				ex.printStackTrace();
			}    		
    		
    	}

    }
	
	public static Button button= null;
	
	public static ObservableList<Patient> patientList=FXCollections.observableArrayList();
	
	public ScheduleController scheduleController;
	
	public void setScheduleController(ScheduleController scheduleController) {
		this.scheduleController = scheduleController;
	}
	
	public void setScheduleController(ScheduleController scheduleController , Button button) {
	
		this.scheduleController = scheduleController;
		this.button= button;
	}
	
	private HomePanelController homePanelController;
	

	public void setHomePanelController(HomePanelController homePanelController, Button button) {
		this.homePanelController = homePanelController;
		this.button= button;
	}
	
	public void setHomePanelController(HomePanelController homePanelController) {
		this.homePanelController = homePanelController;
	}
	
	private PatientVisitByDateViewController patientVisitByDateViewController;
	
	public void setPatientVisitByDateViewController(PatientVisitByDateViewController patientVisitByDateViewController) {
		this.patientVisitByDateViewController = patientVisitByDateViewController;
	}
	
	public void setPatientVisitByDateViewController(PatientVisitByDateViewController patientVisitByDateViewController, Button button) {
		this.patientVisitByDateViewController = patientVisitByDateViewController;
		this.button= button;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		searchBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
				formPath.closeApplicationContext();
				//new FXFormCommonUtilities().displayForm(formName, formTitle);
				Date date1= null;
				LocalDate localDate1 = dobDateText.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
				}
			
								
				 patientList = new PatientEntityController().searchPatient(firstNameText.getText(), lastNameText.getText(), date1,Global.clinic.getId());
						/* new PharmacyEntityController().searchPharmacy(
						pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());*/
				 PatientViewController patientViewController =(PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				 patientViewController.setSearchPatientController(this);
			

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		okBtn.setOnAction((event) -> {
			try {
				if(appointmentController!=null){
					if(padSystemId.getText()!=null){
					Patient pat = new PatientEntityController().getById(Integer.parseInt(padSystemId.getText()));
					
					if(menuStr!=null?menuStr.equals("Change Appointment"):false){
						
						String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);
						formPath.closeApplicationContext();
						PatientAppointmentEditController patientAppointmentEditController =
								(PatientAppointmentEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						patientAppointmentEditController.setPatientAppointment(pattientAppointment);
						patientAppointmentEditController.setSearchPatientController(this);
						
					}else{
					String formName = formPath.context.getMessage("VisitType", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.VisitType", null, Locale.US);
					String formTitle2 = pattientAppointment.getPatient().getPatientName().getFirstName();
					String formTitle = formTitle1+"/"+formTitle2;
					formPath.closeApplicationContext();
					
					VisitLogSelectController visitLogInputController  = (VisitLogSelectController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					visitLogInputController.setSearchPatientController(this,pattientAppointment);
					}
					}else{
						
						String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
						formPath.closeApplicationContext();
						
						Date date1= null;
						LocalDate localDate1 = dobDateText.getValue();
						if(localDate1 != null){
							 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
												
						}
					
						patientList = new PatientEntityController().searchPatient(
								 firstNameText.getText(), lastNameText.getText(), date1,Global.clinic.getId());
								/* new PharmacyEntityController().searchPharmacy(
								pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());*/
						PatientViewController patientViewController =
						(PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						patientViewController.setSearchPatientController(this);
						
						
						/*
						PatientVisit patientVisit = new PatientVisit();
						patientVisit.setD
						*/
						
						
						
					
					}
					
				}
				/*if(button.getId().equals("scheduleNewAppointmentBtn")){
					
					String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
					formPath.closeApplicationContext();
					
					Date date1= null;
					LocalDate localDate1 = dobDateText.getValue();
					if(localDate1 != null){
						 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
											
					}
									
					 patientList = new PatientEntityController().searchPatient(
							 firstNameText.getText(), lastNameText.getText(), date1);
							 new PharmacyEntityController().searchPharmacy(
							pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());
					
					new FXFormCommonUtilities().displayForm(formName, formTitle);
					
				}else if (button.getId().equals("changeAppointment")) {
					
					String formName = formPath.context.getMessage("ViewPatientAppointment", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ViewPatientAppointment", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);
					
				}*/				

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
