package com.ets.controller.gui.pharmacy;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.model.Address;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyInputController Class
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

public class PharmacyInputController implements Initializable {

	@FXML
	private AnchorPane pane;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField contactTextField;

	@FXML
	private TextField extensionTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField streetTextField;

	@FXML
	private TextArea instructionTextArea;

	@FXML
	private CheckBox open24CheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;

	private PharmacyViewController pharmacyViewController;

	public void setPharmacyViewController(PharmacyViewController pharmacyViewController) {
		this.pharmacyViewController = pharmacyViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {
			// Add Pharmacy Details

			Address address = new Address();
			address.setCity(cityTextField.getText());
			address.setEmail(emailTextField.getText());
			address.setFax(faxTextField.getText());
			address.setPhone(telephoneTextField.getText());
			address.setExt(extensionTextField.getText());
			address.setState(stateTextField.getText());
			address.setStreet(streetTextField.getText());
			address.setZip(zipTextField.getText());

			new AddressEntityController().add(address);

			Pharmacy pharmacy = new Pharmacy();
			pharmacy.setLocalAddress(this.localAddressTextField.getText());
			pharmacy.setCode(this.codeTextField.getText());
			pharmacy.setContact(this.contactTextField.getText());
			pharmacy.setInactive(this.inactiveCheckBox.isSelected());
			pharmacy.setInstruction(this.instructionTextArea.getText());
			pharmacy.setName(this.nameTextField.getText());
			pharmacy.setAddress(address);
			pharmacy.setOpenHour(this.open24CheckBox.isSelected());

			new PharmacyEntityController().savePharmacy(pharmacy);
			pharmacyViewController.populatePharmacyTable(new PharmacyEntityController().viewPharmacy());
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
