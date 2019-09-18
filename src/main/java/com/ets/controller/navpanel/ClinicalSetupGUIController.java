package com.ets.controller.navpanel;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.model.UserAccount;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 02-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicalSetupGUIController Class
 *Description: ClinicalSetup.fxml Controller class
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

public class ClinicalSetupGUIController implements Initializable {

	@FXML
    private AnchorPane anchor;

    @FXML
    private Button clinicButton;

    @FXML
    private Button clinicscheduleButton;

    @FXML
    private Button providerScheduleButton;

    @FXML
    private Button clinicianScheduleButton;

    @FXML
    private Button clinicsystemparametersButton;

    @FXML
    private Button audioMetrictestingButton;

    @FXML
    private Button pulmonaryFunctionTestingButton;

    @FXML
    private Button visionTestingButton;

    @FXML
    private Button VitalsReaderButton;

    @FXML
    private Button closeButton;
    
    @FXML
    void enterKeyPressedForClinicSchedule(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("ClinicSchedule", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ClinicSchedule", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}



    }

    @FXML
    void enterKeyPressedForClinicianSchedule(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("ClinicianSelect", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ClinicianSelect", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);

    	}

    }

    @FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {

    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				
				anchor.getChildren().clear();
				
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				anchor.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}


    	
    }

    @FXML
    void enterKeyPressedForCompany(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load and Display - selectmedicalcondition_code.fxml Form
			String formName = formPath.context.getMessage("Company", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);

    	}

    }

    @FXML
    void enterKeyPressedForFirstClinic(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);

    	}

    }

    @FXML
    void enterKeyPressedForProviderSchedule(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("ProviderSchedule", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ProviderSchedule", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);

    	}


    }

    @FXML
    void enterKeyPressedForSecondClinic(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		
			String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);

    	}

    }
	
	List<UserAccount> userList = UserLoginGUIController.getUserlist();
	
	public void accessControl(){
		
		if(userList.get(0).getRoleName().equals("Lab")){
			
			clinicButton.setVisible(false);
			//clinic2Button.setVisible(false);
			clinicscheduleButton.setVisible(false);
			providerScheduleButton.setVisible(false);
			//clinicMapButton.setVisible(false);
			//universalSurvillanceButton.setVisible(false);
			//companySurveillanceButton.setVisible(false);
			//JobLocationSurvillanceButton.setVisible(false);
			//genericVisitProtocolButton.setVisible(false);
			//followUpTreatementProtocolButton.setVisible(false);
			//labMatrixTrackingProfileButton.setVisible(false);
			//macroTextButton.setVisible(false);
			//userdefinedPDFButton.setVisible(false);
			//companyButton.setVisible(false);
						
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		accessControl();

		closeButton.setOnAction((event) -> {
			try {
				
				anchor.getChildren().clear();
				
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				anchor.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicscheduleButton.setOnAction((event) -> {
			
				
				if(Global.clinic.getId() != null){
					try {
						
					String formName = formPath.context.getMessage("ClinicSchedule", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ClinicSchedule", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}	
				}
				else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Clinic is not selected to proceed scheduling !");

					alert.showAndWait();	
				}
				
		});

		providerScheduleButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ProviderSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ProviderSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		clinicianScheduleButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ClinicianSelect", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicianSelect", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*clinicMapButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ClinicMap", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicMap", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		clinicsystemparametersButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ClinicSystemParameter", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicSystemParameter", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		audioMetrictestingButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("AudiomatricTesting", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AudiomatricTesting", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pulmonaryFunctionTestingButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("PulmonaryFunTesting", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PulmonaryFunTesting", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		visionTestingButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("VisionTesting", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisionTesting", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		VitalsReaderButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("VitalsReaders", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VitalsReaders", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*DocumentImageTypeButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("DocumentImageTypes", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DocumentImageTypes", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*universalSurvillanceButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("UniversalSurveillanceProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.UniversalSurveillanceProfile", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*companySurveillanceButton.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("CompanySurveillanceProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CompanySurveillanceProfile", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*JobLocationSurvillanceButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("JobLocationSurveilProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobLocationSurveilProfile", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*genericVisitProtocolButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("GenericVisitProtocals", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.GenericVisitProtocals", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*followUpTreatementProtocolButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("FolloupTreatmentProtocals", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.FolloupTreatmentProtocals", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*labMatrixTrackingProfileButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("LabMatrixTrackingProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.LabMatrixTrackingProfile", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*macroTextButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("MacroText", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MacroText", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*userdefinedPDFButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("UserDefinedPDFForms", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.UserDefinedPDFForms", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*clinic2Button.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*companyButton.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form
				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
	}

}




