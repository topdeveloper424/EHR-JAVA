package com.ets.controller.navpanel;


/*
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProtocolAndProfilesGUIController Class
 *Description: ProtocolAndProfiles.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ProtocolAndProfilesGUIController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private Button closeBtn;
	
	
    @FXML
    private Button usp;

    @FXML
    private Button csp;

    @FXML
    private Button jlsp;

    @FXML
    private Button gvp;

    @FXML
    private Button futp;

    @FXML
    private Button lmtp;

    @FXML
    private Button mt;

    @FXML
    private Button udpf;

    @FXML
    private Button wsd;

    @FXML
    private Button itp;

    @FXML
    private Button at;

    @FXML
    private Button aes;


	@Override
	// Go back to previous nav panel ie SetupAndAdmin nav panel
	public void initialize(URL location, ResourceBundle resources) {
		
		FXMLFormPath formPath = new FXMLFormPath();

		closeBtn.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				basePane.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(
						FXMLLoader.load(getClass().getResource(formName)));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		usp.setOnAction((event) -> {
			try {
								
				String formName = formPath.context.getMessage("UniversalSurveillanceProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.UniversalSurveillanceProfile", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		csp.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("CompanySurveillanceProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CompanySurveillanceProfile", null, Locale.US);
				formPath.closeApplicationContext();
				//String formTitle = "Company Survallance Profile" ;
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		jlsp.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("JobLocationSurveilProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobLocationSurveilProfile", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		gvp.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("GenericVisitProtocals", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.GenericVisitProtocals", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		futp.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("FolloupTreatmentProtocals", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.FolloupTreatmentProtocals", null, Locale.US);
				formPath.closeApplicationContext();
			
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		lmtp.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("LabMatrixTrackingProfile", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.LabMatrixTrackingProfile", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		mt.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("MacroText", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MacroText", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		udpf.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("UserDefinedPDFForms", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.UserDefinedPDFForms", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		wsd.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("WellnessSummeryDefi", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WellnessSummeryDefi", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		itp.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("ImmunizationTracking", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ImmunizationTracking", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		at.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("AuthorizationTemplate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AuthorizationTemplate", null, Locale.US);
				formPath.closeApplicationContext();
			
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		aes.setOnAction((event) -> {
			try {
				// Centralised Form Load and Display - New Addition
				String formName = formPath.context.getMessage("AuthorizationExtSource", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AuthorizationExtSource", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
			}
}