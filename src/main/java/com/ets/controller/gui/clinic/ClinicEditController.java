package com.ets.controller.gui.clinic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.model.Address;
import com.ets.model.Clinic;
import com.ets.model.Contact;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 22-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of ClinicEditController Class Description: Edit.fxml
 * Controller class Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class ClinicEditController implements Initializable {

	@FXML
	private TextField idTextField;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField countyTextField;

	@FXML
	private TextField district1TextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField contractTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField extTextField;

	@FXML
	private ComboBox<String> serviceTypeComboBox;

	@FXML
	private TextField federalIdTextField;

	@FXML
	private TextField medicinIdTextField;

	@FXML
	private TextField npiIdTextField;

	@FXML
	private TextField cliaIdTextField;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button contactButton;

	@FXML
	private Button updateButton;

	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {

				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@FXML
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {

				Address address = new Address();
				address.setId(clinic.getAddress().getId());
				address.setCity(cityTextField.getText());
				address.setCounty(countyTextField.getText());
				address.setState(stateTextField.getText());
				address.setDistrict(district1TextField.getText());
				address.setEmail(emailTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setZip(zipTextField.getText());
				address.setlocalAddress(localAddressTextField.getText());
				new AddressEntityController().update(address);

				Clinic clinic = new Clinic();
				clinic.setId(Integer.parseInt(idTextField.getText()));
				clinic.setCode(codeTextField.getText());
				clinic.setName(this.nameTextField.getText());
				clinic.setPrimaryServiceType(serviceTypeComboBox.getSelectionModel().getSelectedItem());

				clinic.setAddress(address); // store Address Id into Clinic
											// table
				/*
				 * try{
				 * 
				 * Integer integer =
				 * Integer.parseInt(contractTextField.getText());
				 * 
				 * if(integer.SIZE > 0){
				 * 
				 * Contact contact = new
				 * ContactEntityController().viewById(Integer
				 * .parseInt(contractTextField.getText()));
				 * clinic.setContact(contact);
				 * 
				 * }
				 * 
				 * }catch(NumberFormatException e){
				 * 
				 * System.out.println("not a number");
				 * 
				 * }
				 */

				if (contractTextField.getText().isEmpty()) {

					System.out.println("Contact is Empty");

				} else {

					Contact contact = new ContactEntityController()
							.viewById(Integer.parseInt(contractTextField.getText()));
					clinic.setContact(contact);
				}

				clinic.setCliaNo(cliaIdTextField.getText());
				clinic.setFederalTaxIdNo(federalIdTextField.getText());
				clinic.setMedicareIdNo(medicinIdTextField.getText());
				clinic.setNpiNo(npiIdTextField.getText());
				clinic.setInactive(inactiveCheckBox.isSelected());

				new ClinicEntityController().updateClinic(clinic);

				clinicViewController.clinicView();

				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;

		idTextField.setText(Integer.toString(clinic.getId()));
		codeTextField.setText(clinic.getCode());
		nameTextField.setText(clinic.getName());
		cityTextField.setText(clinic.addressProperty().getValue().getCity());
		countyTextField.setText(clinic.addressProperty().getValue().getCounty());
		stateTextField.setText(clinic.addressProperty().getValue().getState());
		district1TextField.setText(clinic.addressProperty().getValue().getDistrict());
		emailTextField.setText(clinic.addressProperty().getValue().getEmail());
		telephoneTextField.setText(clinic.addressProperty().getValue().getPhone());
		extTextField.setText(clinic.addressProperty().getValue().getExt());
		faxTextField.setText(clinic.addressProperty().getValue().getFax());
		zipTextField.setText(clinic.addressProperty().getValue().getZip());
		localAddressTextField.setText(clinic.addressProperty().getValue().getLocalAddress());
		codeTextField.setText(clinic.getCode());
		nameTextField.setText(clinic.getName());

		if (clinic.getContact() != null) {

			contractTextField.setText(Integer.toString(clinic.contactProperty().getValue().getId()));
		}
		serviceTypeComboBox.setValue(clinic.getPrimaryServiceType());
		federalIdTextField.setText(clinic.getFederalTaxIdNo());
		cliaIdTextField.setText(clinic.getCliaNo());
		npiIdTextField.setText(clinic.getNpiNo());
		medicinIdTextField.setText(clinic.getMedicareIdNo());
		if (clinic.getInactive() == true) {

			inactiveCheckBox.setSelected(true);
		} else {
			inactiveCheckBox.setSelected(false);
		}
	}

	private ClinicViewController clinicViewController;

	public void setClinicViewController(ClinicViewController clinicViewController) {
		this.clinicViewController = clinicViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			try {
				Address address = new Address();
				address.setId(clinic.getAddress().getId());
				address.setCity(cityTextField.getText());
				address.setCounty(countyTextField.getText());
				address.setState(stateTextField.getText());
				address.setDistrict(district1TextField.getText());
				address.setEmail(emailTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setZip(zipTextField.getText());
				address.setlocalAddress(localAddressTextField.getText());
				new AddressEntityController().update(address);

				Clinic clinic = new Clinic();
				clinic.setId(Integer.parseInt(idTextField.getText()));
				clinic.setCode(codeTextField.getText());
				clinic.setName(this.nameTextField.getText());
				clinic.setPrimaryServiceType(serviceTypeComboBox.getSelectionModel().getSelectedItem());

				clinic.setAddress(address); // store Address Id into Clinic
											// table
				/*
				 * try{
				 * 
				 * Integer integer =
				 * Integer.parseInt(contractTextField.getText());
				 * 
				 * if(integer.SIZE > 0){
				 * 
				 * Contact contact = new
				 * ContactEntityController().viewById(Integer
				 * .parseInt(contractTextField.getText()));
				 * clinic.setContact(contact);
				 * 
				 * }
				 * 
				 * }catch(NumberFormatException e){
				 * 
				 * System.out.println("not a number");
				 * 
				 * }
				 */

				if (contractTextField.getText().isEmpty()) {

					System.out.println("Contact is Empty");

				} else {

					Contact contact = new ContactEntityController()
							.viewById(Integer.parseInt(contractTextField.getText()));
					clinic.setContact(contact);
				}

				clinic.setCliaNo(cliaIdTextField.getText());
				clinic.setFederalTaxIdNo(federalIdTextField.getText());
				clinic.setMedicareIdNo(medicinIdTextField.getText());
				clinic.setNpiNo(npiIdTextField.getText());
				clinic.setInactive(inactiveCheckBox.isSelected());

				new ClinicEntityController().updateClinic(clinic);

				clinicViewController.clinicView();

				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
