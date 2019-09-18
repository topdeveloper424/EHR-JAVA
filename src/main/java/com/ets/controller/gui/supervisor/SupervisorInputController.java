package com.ets.controller.gui.supervisor;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.supervisor.SupervisorEntityController;
import com.ets.model.Address;
import com.ets.model.Supervisor;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorInputController Class
 *Description: Enter.fxml Controller class
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

public class SupervisorInputController implements Initializable {

	@FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox inactiveCheckBox;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField middleNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField suffixtextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField listingNameTextField;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField faxTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private RadioButton supervoisorRadioButton;

    @FXML
    private ToggleGroup type;

    @FXML
    private RadioButton managerRadioButton;

    @FXML
    private TextField extensionTextField;
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

 			String type = null;
			if (supervoisorRadioButton.isSelected()) {
				type = "Supervisor";
			} else if (managerRadioButton.isSelected()) {
				type = "Manager";
			}

			Address address = new Address();
			address.setEmail(this.emailTextField.getText());
			address.setPhone(this.telephoneTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			new AddressEntityController().add(address);
			Supervisor supervisor = new Supervisor();

			supervisor.setCode(this.codeTextField.getText());
			supervisor.setFisrtName(this.firstNameTextField.getText());
			supervisor.setLastName(this.lastNameTextField.getText());
			supervisor.setSuffix(suffixtextField.getText());
			supervisor.setListingName(this.listingNameTextField.getText());
			supervisor.setMiddleName(this.middleNameTextField.getText());
			supervisor.setType(type);
			supervisor.setInactive(this.inactiveCheckBox.isSelected());
			supervisor.setAddress(address);

			new SupervisorEntityController().saveSupervisor(supervisor);

			supervisorViewController.populateSupervisorTable(new SupervisorEntityController().viewSupervisor());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		 }
    }


	private SupervisorViewController supervisorViewController;

	public void setSupervisorViewController(SupervisorViewController supervisorViewController) {
		this.supervisorViewController = supervisorViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Add Supervisor Details

			String type = null;
			if (supervoisorRadioButton.isSelected()) {
				type = "Supervisor";
			} else if (managerRadioButton.isSelected()) {
				type = "Manager";
			}

			Address address = new Address();
			address.setEmail(this.emailTextField.getText());
			address.setPhone(this.telephoneTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			new AddressEntityController().add(address);
			Supervisor supervisor = new Supervisor();

			supervisor.setCode(this.codeTextField.getText());
			supervisor.setFisrtName(this.firstNameTextField.getText());
			supervisor.setLastName(this.lastNameTextField.getText());
			supervisor.setSuffix(suffixtextField.getText());
			supervisor.setListingName(this.listingNameTextField.getText());
			supervisor.setMiddleName(this.middleNameTextField.getText());
			supervisor.setType(type);
			supervisor.setInactive(this.inactiveCheckBox.isSelected());
			supervisor.setAddress(address);

			new SupervisorEntityController().saveSupervisor(supervisor);

			supervisorViewController.populateSupervisorTable(new SupervisorEntityController().viewSupervisor());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

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
