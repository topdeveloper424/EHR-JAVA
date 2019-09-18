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
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ThirdPartyPlayerGUIController Class
 *Description: ThirdPartyPlayer.fxml Controller class
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

public class ThirdPartyPlayerGUIController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private Button carrierBtn;

	@FXML
	private Button mcoTpaBillBtn;

	@FXML
	private Button laboratoryBtn;

	@FXML
	private Button contactTPABtn;

	@FXML
	private Button parentPlayerBtn;

	@FXML
	private Button parentEmployerGroupBtn;

	@FXML
	private Button closeBtn;
	
	@FXML
    void enterKeyPressedForCarrierButton(KeyEvent event) {
		
		 if(event.getCode() == KeyCode.ENTER){
			 
			// Load Carrier Details Entry form .

				String formName = formPath.context.getMessage("Carrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Carrier", null, Locale.US);
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
    void enterKeyPressedForLaboratoryButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Laboratory Details Entry form .

			String formName = formPath.context.getMessage("Laboratory", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Laboratory", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);
			 
		 }

    }

    @FXML
    void enterKeyPressedForMCOorTPAButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Comp, MCO, TPA or Bill Review Details Entry form .

			String formName = formPath.context.getMessage("MCOOrTPA", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.MCOOrTPA", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);
			 
		 }

    }


	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		carrierBtn.setOnAction((event) -> {
			try {
				// Load Carrier Details Entry form .

				String formName = formPath.context.getMessage("Carrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Carrier", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		mcoTpaBillBtn.setOnAction((event) -> {
			try {
				// Load Comp, MCO, TPA or Bill Review Details Entry form .

				String formName = formPath.context.getMessage("MCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MCOOrTPA", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		laboratoryBtn.setOnAction((event) -> {
			try {
				// Load Laboratory Details Entry form .

				String formName = formPath.context.getMessage("Laboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Laboratory", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*contactTPABtn.setOnAction((event) -> {
			try {
				// Load Contract TPA Details Entry form .

				String formName = formPath.context.getMessage("ContactTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ContactTPA", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		parentPlayerBtn.setOnAction((event) -> {
			try {
				// Load Third Party Details Entry form .

				String formName = formPath.context.getMessage("ParentPlayer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ParentPlayer", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		// Go back to previous nav panel ie Entity Table nav panel.
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
