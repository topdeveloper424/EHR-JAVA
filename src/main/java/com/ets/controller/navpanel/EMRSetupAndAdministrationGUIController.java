package com.ets.controller.navpanel;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 04-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EMRSetupAndAdministrationGUIController Class
 *Description: EMRSetupAndAdministration.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EMRSetupAndAdministrationGUIController implements Initializable {
	
	@FXML
    private AnchorPane basePane;

    @FXML
    private Button parameterButton;

    @FXML
    private Button chartingWizardsButton;

    @FXML
    private Button chartingMerlins;

    @FXML
    private Button chartingTemplates;

    @FXML
    private Button icd10Button;

    @FXML
    private Button medicationCodesButton;

    @FXML
    private Button medicationClassButton;

    @FXML
    private Button prescriptionTemplatesButton;

    @FXML
    private Button clinicalPracticeGuidelineButton;

    @FXML
    private Button immunizationTrackingProfileButton;

    @FXML
    private Button vitalSignNormalRangeButton;

    @FXML
    private Button ProviderButton;

    @FXML
    private Button BillingPhysiciansButton;

    @FXML
    private Button ReferalProviderButton;

    @FXML
    private Button ClinicianButton;

    @FXML
    private Button PharmacyButton;

    @FXML
    private Button closeButton;
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		icd10Button.setOnAction((event) -> {
			try {
				// Load and Display - ICD-10_Codes(ReadOnly).fxml
				// Form
				String formName = formPath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		medicationCodesButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		medicationClassButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("ViewMedicationClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewMedicationClass", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		vitalSignNormalRangeButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("ViewVitalSignRange", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewVitalSignRange", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		immunizationTrackingProfileButton.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display 
				String formName = formPath.context.getMessage("ImmunizationTracking", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ImmunizationTracking", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		ProviderButton.setOnAction((event) -> {
			try {
				// Load Provider Details Entry form .

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		ReferalProviderButton.setOnAction((event) -> {
			try {
				// Load Referal Provider Details Entry form .

				String formName = formPath.context.getMessage("ReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ReferalProvider", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		BillingPhysiciansButton.setOnAction((event) -> {
			try {
				// Load Billing Physician or Provider Details Entry form .

				String formName = formPath.context.getMessage("BillingPhysicians", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingPhysicians", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		ClinicianButton.setOnAction((event) -> {
			try {
				// Load Clinician Details Entry form .

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	
		
		/*************************************    Start of  pharmacyBtn.setOnAction(..)     *****************************************************/

		PharmacyButton.setOnAction((event) -> {
			

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			
			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Pharmacy", null, Locale.US);
			formPath.closeApplicationContext();
			
			// Need the ProgressBar controller to access the progress bar in this method
			ProgressBarGUIController progressBarGUIController = ( ProgressBarGUIController )new FXFormCommonUtilities()
																	.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************   Start of Task definition    *****************************************************************/
			Task<ObservableList<Pharmacy>> task =

					new Task<ObservableList<Pharmacy>>() {

							@Override
							protected ObservableList<Pharmacy> call() throws Exception {
									final ObservableList<Pharmacy> pharmacyList = new PharmacyEntityController().viewPharmacy();
									
									if (isCancelled()) {
									    return null;
									}
									return pharmacyList;

							}
    				};
			/*************************   End of Task definition    *****************************************************************/

			task.setOnSucceeded(event1 -> {

				 System.out.println("With in success.");
				 // Close Progress Bar Form
				 Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				 stage.close();
				 
				 String formName = formPath.context.getMessage("Pharmacy", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.Pharmacy", null, Locale.US);
					formPath.closeApplicationContext();

				 FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				 try {
					formDisplayer.pharmacyDisplayForm( formName , formTitle , task.getValue() );
				 } catch (Exception e) {
					e.printStackTrace();	 }

			});

			progressBar.progressProperty().bind(task.progressProperty());
			
			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************    End of  pharmacyBtn.setOnAction(..)     *************************************************************/



		
		// Go back to previous nav panel ie SetupAndAdmin nav panel
		closeButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				basePane.getChildren().clear();
				
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
