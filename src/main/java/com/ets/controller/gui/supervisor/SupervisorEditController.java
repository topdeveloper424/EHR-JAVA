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
 *Parameter Definition: Type object of SupervisorEditController Class
 *Description: Edit.fxml Controller class
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

public class SupervisorEditController implements Initializable {

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField middleNameTextField;

	@FXML
	private TextField lastnameTextField;

	@FXML
	private TextField suffixTextField;

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
	private TextField idTextField;
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
	    void enterKeyPressedForUpdateButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		String type = null;
			if (supervoisorRadioButton.isSelected()) {
				type = "Supervisor";
			} else if (managerRadioButton.isSelected()) {
				type = "Manager";
			}

			Address address = new Address();

			address.setId(supervisor.getAddress().getId());
			address.setEmail(this.emailTextField.getText());
			address.setPhone(this.telephoneTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			new AddressEntityController().update(address);
			Supervisor supervisor = new Supervisor();

			supervisor.setId(Integer.parseInt(idTextField.getText()));
			supervisor.setCode(this.codeTextField.getText());
			supervisor.setFisrtName(this.firstNameTextField.getText());
			supervisor.setLastName(this.lastnameTextField.getText());
			supervisor.setListingName(this.listingNameTextField.getText());
			supervisor.setMiddleName(this.middleNameTextField.getText());
			supervisor.setSuffix(suffixTextField.getText());
			supervisor.setType(type);
			supervisor.setInactive(this.inactiveCheckBox.isSelected());
			supervisor.setAddress(address);

			new SupervisorEntityController().saveSupervisor(supervisor);
			supervisorViewController.populateSupervisorTable(new SupervisorEntityController().viewSupervisor());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 }
	    }


	private SupervisorViewController supervisorViewController;

	public void setSupervisorViewController(SupervisorViewController supervisorViewController) {
		this.supervisorViewController = supervisorViewController;
	}

	private Supervisor supervisor; // Supervisor Entity variable

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;

		idTextField.setText(Integer.toString(supervisor.getId()));
		codeTextField.setText(supervisor.getCode());
		emailTextField.setText(supervisor.addressProperty().getValue().getEmail());
		extensionTextField.setText(supervisor.addressProperty().getValue().getExt());
		faxTextField.setText(supervisor.addressProperty().getValue().getFax());
		telephoneTextField.setText(supervisor.addressProperty().getValue().getPhone());
		firstNameTextField.setText(supervisor.getFisrtName());
		listingNameTextField.setText(supervisor.getListingName());
		lastnameTextField.setText(supervisor.getLastName());
		middleNameTextField.setText(supervisor.getMiddleName());
		suffixTextField.setText(supervisor.getSuffix());

		if ("Supervisor".equals(supervisor.getType())) {
			supervoisorRadioButton.setSelected(true);
		} else if ("Manager".equals(supervisor.getType())) {
			managerRadioButton.setSelected(true);
		}

		if (supervisor.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (supervisor.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update Supervisor Details

			String type = null;
			if (supervoisorRadioButton.isSelected()) {
				type = "Supervisor";
			} else if (managerRadioButton.isSelected()) {
				type = "Manager";
			}

			Address address = new Address();

			address.setId(supervisor.getAddress().getId());
			address.setEmail(this.emailTextField.getText());
			address.setPhone(this.telephoneTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			new AddressEntityController().update(address);
			Supervisor supervisor = new Supervisor();

			supervisor.setId(Integer.parseInt(idTextField.getText()));
			supervisor.setCode(this.codeTextField.getText());
			supervisor.setFisrtName(this.firstNameTextField.getText());
			supervisor.setLastName(this.lastnameTextField.getText());
			supervisor.setListingName(this.listingNameTextField.getText());
			supervisor.setMiddleName(this.middleNameTextField.getText());
			supervisor.setSuffix(suffixTextField.getText());
			supervisor.setType(type);
			supervisor.setInactive(this.inactiveCheckBox.isSelected());
			supervisor.setAddress(address);

			new SupervisorEntityController().saveSupervisor(supervisor);
			supervisorViewController.populateSupervisorTable(new SupervisorEntityController().viewSupervisor());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

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
