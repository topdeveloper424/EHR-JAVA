package com.ets.controller.navpanel;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderGUIController Class
 *Description: Providers.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification: 
 *Owner:Sumanta Deyahi
 *Date:10-02-2016
 *Version:
 *Description:Providers.fxml Controller class
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */


public class ProviderGUIController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private Button providerBtn;

	@FXML
	private Button referalProviderBtn;

	@FXML
	private Button billingPhysicians;

	@FXML
	private Button clinicansBtn;

	@FXML
	private Button medicalGroupBtn;

	@FXML
	private Button providerNetworkBtn;

	@FXML
	private Button closeBtn;
	
	 @FXML
	    void enterKeyPressedForClinicianButton(KeyEvent event) {
		 
		 if(event.getCode() == KeyCode.ENTER){
			 
			// Load Clinician Details Entry form .

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);


		 	}

		 
	    }

	    @FXML
	    void enterKeyPressedForCloseButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		try {
					// Clear from view Current Navigation Panel
					basePane.getChildren().clear();
					// Display SetupAdmin Navigation Panel
					String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
					formPath.closeApplicationContext();
					basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

				} catch (Exception ex) {
					ex.printStackTrace();
				}


	    	}

	    }

	    @FXML
	    void enterKeyPressedForProviderButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load Provider Details Entry form .

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	    @FXML
	    void enterKeyPressedForReferalProviderButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load Referal Provider Details Entry form .

				String formName = formPath.context.getMessage("ReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ReferalProvider", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		providerBtn.setOnAction((event) -> {
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

		referalProviderBtn.setOnAction((event) -> {
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

		/*billingPhysicians.setOnAction((event) -> {
			try {
				// Load Billing Physician or Provider Details Entry form .

				String formName = formPath.context.getMessage("BillingPhysicians", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingPhysicians", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		clinicansBtn.setOnAction((event) -> {
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

		/*medicalGroupBtn.setOnAction((event) -> {
			try {
				// Load Medical Group Details Entry form .

				String formName = formPath.context.getMessage("MedicalGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalGroup", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerNetworkBtn.setOnAction((event) -> {
			try {
				// Load Provider Network Details Entry form .

				String formName = formPath.context.getMessage("ProviderNetWork", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ProviderNetWork", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		// Go back to previous nav panel ie Entity Table nav panel
		closeBtn.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				basePane.getChildren().clear();
				// Display SetupAdmin Navigation Panel
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
