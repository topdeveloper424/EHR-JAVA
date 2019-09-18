package com.ets.controller.gui.workLocation;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.controller.entity.workLocation.WorkLocationEntityController;
import com.ets.model.Address;
import com.ets.model.NAICSCode;
import com.ets.model.SICCode;
import com.ets.model.WorkLocation;
import com.ets.utils.FXFormCommonUtilities;
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
 * Creation Date: 26-07-2016 
 * Initial Version: 0.01 
 * Module Name: 
 * Parameter Definition: Type object of WorkLocationEditController Class Description:
 * Edit.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class WorkLocationEditController implements Initializable {

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
	private CheckBox inactiveCheckBox;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField idTextField;

	private WorkLocation workLocation;
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

			SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeIdTextField.getText());
			NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeIdTextField.getText());

			Address address = new Address();

			address.setId(workLocation.getAddress().getId());
			address.setCity(cityTextField.getText());
			address.setState(stateTextField.getText());
			address.setZip(zipTextField.getText());
			address.setlocalAddress(localAddressTextField.getText());
			new AddressEntityController().update(address);

			WorkLocation workLocation = new WorkLocation();
			workLocation.setId(Integer.parseInt(idTextField.getText()));
			workLocation.setCode(codeTextField.getText());
			workLocation.setDescrp(descriptionTextField.getText());
			workLocation.setInactive(inactiveCheckBox.isSelected());
			workLocation.setAddress(address);
			workLocation.setSicCode(sicCode);
			workLocation.setNaicsCode(naicsCode);

			new WorkLocationEntityController().save(workLocation);
			workLocationViewController.viewWorkLocation();

			try {
				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
    }

	public void setWorkLocation(WorkLocation workLocation) {
		this.workLocation = workLocation;

		idTextField.setText(Integer.toString(workLocation.getId()));
		codeTextField.setText(workLocation.getCode());
		descriptionTextField.setText(workLocation.getDescrp());
		localAddressTextField.setText(workLocation.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(workLocation.addressProperty().getValue().getCity());
		stateTextField.setText(workLocation.addressProperty().getValue().getState());
		zipTextField.setText(workLocation.addressProperty().getValue().getZip());
		sicCodeIdTextField.setText(workLocation.sicCodeProperty().getValue().getCode());
		naicsCodeIdTextField.setText(workLocation.naicsCodeProperty().getValue().getCode());

		if (workLocation.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (workLocation.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	private WorkLocationViewController workLocationViewController;

	public void setWorkLocationViewController(WorkLocationViewController workLocationViewController) {
		this.workLocationViewController = workLocationViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update WorkLocation Details

			SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeIdTextField.getText());
			NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeIdTextField.getText());

			Address address = new Address();

			address.setId(workLocation.getAddress().getId());
			address.setCity(cityTextField.getText());
			address.setState(stateTextField.getText());
			address.setZip(zipTextField.getText());
			address.setlocalAddress(localAddressTextField.getText());
			new AddressEntityController().update(address);

			WorkLocation workLocation = new WorkLocation();
			workLocation.setId(Integer.parseInt(idTextField.getText()));
			workLocation.setCode(codeTextField.getText());
			workLocation.setDescrp(descriptionTextField.getText());
			workLocation.setInactive(inactiveCheckBox.isSelected());
			workLocation.setAddress(address);
			workLocation.setSicCode(sicCode);
			workLocation.setNaicsCode(naicsCode);

			new WorkLocationEntityController().save(workLocation);
			workLocationViewController.viewWorkLocation();

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
