package com.ets.controller.gui.parentEmployerGroup;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.entity.parentEmployerGroup.ParentEmployerGroupEntityController;
import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.model.Address;
import com.ets.model.NAICSCode;
import com.ets.model.ParentEmployerGroup;
import com.ets.model.SICCode;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 25-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupEditController Class
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

public class ParentEmployerGroupEditController implements Initializable {

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
	private TextField feinTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private ChoiceBox<?> countryComboBox;

	@FXML
	private TextField sourceFaxTextField;

	@FXML
	private TextField sicCodeTextField;

	@FXML
	private TextField naicsCodeTextField;

	@FXML
	private Button sicCodeButton;

	@FXML
	private Button naicsCodeButton;

	@FXML
	private TextField idTextField;

	@FXML
	private TextField regionTextField;

	@FXML
	private TextField districtTextField;

	@FXML
	private TextField complexTextField;

	@FXML
	private Button regionButton;

	@FXML
	private Button districtButton;

	@FXML
	private Button complexButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;

	private ParentEmployerGroup parentEmployerGroup;

	public void setParentEmployerGroup(ParentEmployerGroup parentEmployerGroup) {
		this.parentEmployerGroup = parentEmployerGroup;

		idTextField.setText(Integer.toString(parentEmployerGroup.getId()));
		codeTextField.setText(parentEmployerGroup.getCode());
		nameTextField.setText(parentEmployerGroup.getName());
		localAddressTextField.setText(parentEmployerGroup.getLocalAddress());
		cityTextField.setText(parentEmployerGroup.addressProperty().getValue().getCity());
		stateTextField.setText(parentEmployerGroup.addressProperty().getValue().getState());
		zipTextField.setText(parentEmployerGroup.addressProperty().getValue().getZip());
		telephoneTextField.setText(parentEmployerGroup.addressProperty().getValue().getPhone());
		extensionTextField.setText(parentEmployerGroup.addressProperty().getValue().getExt());
		faxTextField.setText(parentEmployerGroup.addressProperty().getValue().getFax());
		emailTextField.setText(parentEmployerGroup.addressProperty().getValue().getEmail());
		sourceFaxTextField.setText(parentEmployerGroup.addressProperty().getValue().getSecureFax());
		contactTextField.setText(parentEmployerGroup.getContact());
		feinTextField.setText(parentEmployerGroup.getFein());
		sicCodeTextField.setText(parentEmployerGroup.sicCodeProperty().getValue().getCode());
		naicsCodeTextField.setText(parentEmployerGroup.naicsCodeProperty().getValue().getCode());

		if (parentEmployerGroup.getInactive() == true) {
			inactiveCheckBox.setSelected(true);

		} else {

			inactiveCheckBox.setSelected(false);

		}
	}

	private ParentEmployerGroupViewController parentEmployerGroupViewController;

	public void setParentEmployerGroupViewController(
			ParentEmployerGroupViewController parentEmployerGroupViewController) {
		this.parentEmployerGroupViewController = parentEmployerGroupViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			try {
				// Save Parent Employer Group Data.
				Address address = new Address();
				address.setId(parentEmployerGroup.getAddress().getId());
				address.setCity(cityTextField.getText());
				address.setDistrict(districtTextField.getText());
				address.setEmail(emailTextField.getText());
				address.setExt(extensionTextField.getText());
				address.setFax(faxTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setSecureFax(sourceFaxTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());

				new AddressEntityController().update(address);

				SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeTextField.getText());
				NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeTextField.getText());

				ParentEmployerGroup parentEmployerGroup = new ParentEmployerGroup();
				parentEmployerGroup.setId(Integer.parseInt(idTextField.getText()));
				parentEmployerGroup.setCode(codeTextField.getText());
				parentEmployerGroup.setName(nameTextField.getText());
				parentEmployerGroup.setlocalAddress(localAddressTextField.getText());
				parentEmployerGroup.setContact(contactTextField.getText());
				parentEmployerGroup.setFein(feinTextField.getText());
				parentEmployerGroup.setInactive(inactiveCheckBox.isSelected());

				parentEmployerGroup.setAddress(address);
				parentEmployerGroup.setNaicsCode(naicsCode);
				parentEmployerGroup.setSicCode(sicCode);

				new ParentEmployerGroupEntityController().add(parentEmployerGroup);
				parentEmployerGroupViewController.viewParentEmployerGroup();

				try {
					new FXFormCommonUtilities().closeForm(updateButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

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
