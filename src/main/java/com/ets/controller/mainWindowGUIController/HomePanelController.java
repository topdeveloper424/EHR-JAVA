package com.ets.controller.mainWindowGUIController;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 21-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HomePanelController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification: Neha Sahadev
 *Owner:  
 *Date: 30/11/2016
 *Version: 0.02
 *Description: Set clinic name and company name throughout the Pannel Title.
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.gui.demographicsSearch.PatientDemographicsSearchController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.model.Company;
import com.ets.model.PatientVisit;
import com.ets.model.UserAccount;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePanelController implements Initializable {

	 @FXML
	    private AnchorPane homeNavPanel;

	    @FXML
	    private Button clinicBtn;

	    @FXML
	    private Button companyBtn;

	    @FXML
	    private Button clinicWhiteBoardBtn;

	    @FXML
	    private Button appointmentsBtn;

	    @FXML
	    private Button checkInBtn;

	    @FXML
	    private Button visitByDateBtn;

	    @FXML
	    private Button visitByPatientBtn;

	    @FXML
	    private Button chartByDateBtn;

	    @FXML
	    private Button chartByPatientBtn;

	    @FXML
	    private Button medicalCodesBtn;

	    @FXML
	    private Button medicalClassBtn;

	    @FXML
	    private Button demographicsBtn;

	    @FXML
	    private Button representativesBtn;

	    @FXML
	    private Button billingPannel;

	    @FXML
	    private Button setupOrAdminBtn;

	   /* @FXML
	    private Button payOnChartBtn;*/

	    

	   /* @FXML
	    private Button phoneCallBtn;*/

	    

	    /*@FXML
	    private Button ordersBtn;*/

	    /*@FXML
	    private Button reportingBtn;*/

	   

	   /* @FXML
	    private Button utilitiesBtn;*/

		
	List<UserAccount> userList = UserLoginGUIController.getUserlist();
	
	public void accessControl(){
		
		if(userList.get(0).getRoleName().equals("Lab")){
			
			clinicBtn.setVisible(false);
			companyBtn.setVisible(false);
			appointmentsBtn.setVisible(false);
			chartByDateBtn.setVisible(false);
			
			chartByPatientBtn.setVisible(false);
			checkInBtn.setVisible(false);
			
			visitByDateBtn.setVisible(false);
			visitByPatientBtn.setVisible(false);
			//payOnChartBtn.setVisible(false);
			//phoneCallBtn.setVisible(false);
			demographicsBtn.setVisible(false);
			representativesBtn.setVisible(false);
			
			//ordersBtn.setVisible(false);
						
		}else if (userList.get(0).getRoleName().equals("Billing")) {
			
			clinicBtn.setVisible(false);
			companyBtn.setVisible(false);
			appointmentsBtn.setVisible(false);
			chartByDateBtn.setVisible(false);
			
			chartByPatientBtn.setVisible(false);
			checkInBtn.setVisible(false);
		
			visitByDateBtn.setVisible(false);
			visitByPatientBtn.setVisible(false);
			//payOnChartBtn.setVisible(false);
			//phoneCallBtn.setVisible(false);
			demographicsBtn.setVisible(false);
			representativesBtn.setVisible(false);
			
			//ordersBtn.setVisible(false);
			
		}else if (userList.get(0).getRoleName().equals("MSP")) {
			
			clinicBtn.setVisible(false);
			companyBtn.setVisible(false);
			appointmentsBtn.setVisible(false);
			chartByDateBtn.setVisible(false);
			
			chartByPatientBtn.setVisible(false);
			checkInBtn.setVisible(false);
			
			visitByDateBtn.setVisible(false);
			visitByPatientBtn.setVisible(false);
			//payOnChartBtn.setVisible(false);
			//phoneCallBtn.setVisible(false);
			demographicsBtn.setVisible(false);
			representativesBtn.setVisible(false);
			
			//ordersBtn.setVisible(false);
			setupOrAdminBtn.setVisible(false);
			
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		accessControl();

		
		clinicBtn.setOnAction((event) -> {
			try {
				// Load Clinic Details .

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Button Click event handling through lambda expression , comes
		// recommended ,
		// newly added to java 8

		/*************************************
		 * Start of companyBtn.setOnAction(..)
		 *****************************************************/

		/*companyBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Company", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<Company>> task =

					new Task<ObservableList<Company>>() {

						@Override
						protected ObservableList<Company> call() throws Exception {

							final ObservableList<Company> companyList = new CompanyEntityController().getCompanyList();
							if (isCancelled()) {
								return null;
							}
							return companyList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.companyDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});*/
		/*************************************
		 * End of companyBtn.setOnAction(..)
		 *************************************************************/
		
		companyBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicWhiteBoardBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ClinicWhiteboard", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ClinicWhiteboard", null, Locale.US);
				//String formTitle2= Global.clinic.getName();
				String formTitle2 = null;
				if(Global.clinic == null){
					 formTitle2 = "";
				}else{
					 formTitle2 = Global.clinic.getName();
				}
				String formTitle = formTitle1+"/"+formTitle2;
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		appointmentsBtn.setOnAction((event) -> {
			try {
				// Load Appointments Details .
			
				String formName = formPath.context.getMessage("Appointment", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.Appointment", null, Locale.US);
				
				//String formTitle2= Global.clinic.getName();
				String formTitle2 = null;
				if(Global.clinic == null){
					 formTitle2 = "";
				}else{
					 formTitle2 = Global.clinic.getName();
				}
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		checkInBtn.setOnAction((event) -> {
			try {
				Global.patientVisitObj = new PatientVisit();
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				
				String formTitle2 = null;
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				
				SearchPatientController searchPatientController =
						(SearchPatientController) new FXFormCommonUtilities().displayForm( formName , formTitle);
						searchPatientController.setHomePanelController(this, checkInBtn);
						

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		visitByDateBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("VisitByDate", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.VisitByDate", null, Locale.US);
				
				String formTitle2 = null;
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				
				 new FXFormCommonUtilities().displayForm( formName , formTitle);
						

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		visitByPatientBtn.setOnAction((event) -> {
			try {
				Global.patientVisitObj = new PatientVisit();
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				String formTitle2 = null;
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
								
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				
				SearchPatientController searchPatientController =
						(SearchPatientController) new FXFormCommonUtilities().displayForm( formName , formTitle);
						searchPatientController.setHomePanelController(this, visitByPatientBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*payOnChartBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewPaymentAccount", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPaymentAccount", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		chartByDateBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("VisitByDate", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.VisitByDate", null, Locale.US);
								
				String formTitle2 = null;
				if(Global.clinic == null){
					 formTitle2 = "";
				}else{
					 formTitle2 = Global.clinic.getName();
				}
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		chartByPatientBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				
				String formTitle2 = null;
				
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
								
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				

				SearchPatientController searchPatientController =
						(SearchPatientController) new FXFormCommonUtilities().displayForm( formName , formTitle);
						searchPatientController.setHomePanelController(this, chartByPatientBtn);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		billingPannel.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				homeNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("BillingPanel", null, Locale.US);
				formPath.closeApplicationContext();
				homeNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*phoneCallBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				String formTitle2= Global.company.getName();
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		demographicsBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient2", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				PatientDemographicsSearchController patientDemographicsSearchController = 
						(PatientDemographicsSearchController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		representativesBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("PatientRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PatientRepresentative", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*ordersBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewOrder", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewOrder", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*viewChartBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				String formTitle2= Global.company.getName();
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		// Replace Current Home navigation panel to Reporting panel .
				/*reportingBtn.setOnAction((event) -> {
					try {
						// Navigation panel for home screen
						homeNavPanel.getChildren().clear();
						// Using Absolute path for fxml file path
						String formName = formPath.context.getMessage("Reporting", null, Locale.US);

						formPath.closeApplicationContext();
						homeNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});*/
				
				
				
				
				
				/*utilitiesBtn.setOnAction((event) -> {
					try {

						String formName = formPath.context.getMessage("ViewEquipmentModel", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.ViewEquipmentModel", null, Locale.US);
						formPath.closeApplicationContext();
						new FXFormCommonUtilities().displayForm(formName, formTitle);

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});*/
				
				
				
				
				

		// Replace Current Home navigation panel to SetupAdmin panel .
		setupOrAdminBtn.setOnAction((event) -> {
			try {
				// Navigation panel for home screen
				homeNavPanel.getChildren().clear();
				// Using Absolute path for fxml file path
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);

				formPath.closeApplicationContext();
				homeNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		medicalCodesBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		medicalClassBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewMedicationClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewMedicationClass", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
