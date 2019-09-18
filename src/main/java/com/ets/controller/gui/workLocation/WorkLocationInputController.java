package com.ets.controller.gui.workLocation;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.controller.entity.workLocation.WorkLocationEntityController;
import com.ets.controller.gui.naicsCode.NaicsCodeViewController;
import com.ets.controller.gui.sicCode.SicCodeViewController;
import com.ets.model.Address;
import com.ets.model.NAICSCode;
import com.ets.model.SICCode;
import com.ets.model.WorkLocation;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 26-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of WorkLocationInputController Class Description:
 * Enter.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class WorkLocationInputController implements Initializable {

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField sicCodeIdTextField;

	@FXML
	private TextField naicsCodeIdTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private Button sicCodeButton;

	@FXML
	private Button naicsButton;

    @FXML
    void enterKeyPressedForCancleButton(KeyEvent event) {
    	 if(event.getCode() == KeyCode.ENTER){
    		 try {
 				new FXFormCommonUtilities().closeForm(cancelButton);
 			} catch (Exception ex) {
 				ex.printStackTrace();
 			} 
    	 }
    }

    @FXML
    void enterKeyPressedForOkButton(KeyEvent event) {
    	 if(event.getCode() == KeyCode.ENTER){
    		 try {
 				// Save WorkLocation Details .
 				SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeIdTextField.getText());
 				NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeIdTextField.getText());
 				Address address = new Address();
 				address.setCity(cityTextField.getText());
 				address.setState(stateTextField.getText());
 				address.setZip(zipTextField.getText());
 				address.setlocalAddress(localAddressTextField.getText());
 				new AddressEntityController().add(address);

 				WorkLocation workLocation = new WorkLocation();
 				workLocation.setCode(codeTextField.getText());
 				workLocation.setDescrp(descriptionTextField.getText());
 				workLocation.setInactive(inactiveCheckBox.isSelected());
 				workLocation.setAddress(address);
 				workLocation.setSicCode(sicCode);
 				workLocation.setNaicsCode(naicsCode);

 				new WorkLocationEntityController().save(workLocation);
 				workLocationViewController.viewWorkLocation();
 				try {
 					new FXFormCommonUtilities().closeForm(okButton);

 				} catch (Exception ex) {
 					ex.printStackTrace();
 				}

 			} catch (Exception ex) {
 				ex.printStackTrace();
 			} 
    	 }
    }


	public void setSicCode(String sicCode) {
		this.sicCodeIdTextField.setText(sicCode);

	}

	public void setNaicsCode(String naicsCode) {
		this.naicsCodeIdTextField.setText(naicsCode);
	}

	private WorkLocationViewController workLocationViewController;

	public void setWorkLocationViewController(WorkLocationViewController workLocationViewController) {
		this.workLocationViewController = workLocationViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		sicCodeButton.setOnAction((event) -> {
			try {
				// Load SIC Code Details Form .

				String formName = formPath.context.getMessage("SICCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SICCode", null, Locale.US);
				formPath.closeApplicationContext();
				SicCodeViewController sicCodeViewController = (SicCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				sicCodeViewController.setWorkLocationInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		naicsButton.setOnAction((event) -> {
			try {
				// Load NAICS Code Details form .

				String formName = formPath.context.getMessage("NAICSCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NAICSCode", null, Locale.US);
				formPath.closeApplicationContext();
				NaicsCodeViewController naicsCodeViewController = (NaicsCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				naicsCodeViewController.setWorkLocationInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		okButton.setOnAction((event) -> {
			try {
				// Save WorkLocation Details .
				SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeIdTextField.getText());
				NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeIdTextField.getText());
				Address address = new Address();
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setlocalAddress(localAddressTextField.getText());
				new AddressEntityController().add(address);

				WorkLocation workLocation = new WorkLocation();
				workLocation.setCode(codeTextField.getText());
				workLocation.setDescrp(descriptionTextField.getText());
				workLocation.setInactive(inactiveCheckBox.isSelected());
				workLocation.setAddress(address);
				workLocation.setSicCode(sicCode);
				workLocation.setNaicsCode(naicsCode);

				new WorkLocationEntityController().save(workLocation);
				workLocationViewController.viewWorkLocation();
				try {
					new FXFormCommonUtilities().closeForm(okButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
