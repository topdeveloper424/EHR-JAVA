package com.ets.controller.gui.deviceModel;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceModelGUIController Class
 *Description: EnterShrapsDeviceModel.fxml Controller class
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

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.deviceModel.DeviceModelEntityController;
import com.ets.model.DeviceModel;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DeviceModelInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField descriptionTextBox;	
	
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Centralised Form cancel
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert SharpDeviceModel Details

		DeviceModel deviceModel = new DeviceModel();
		deviceModel.setDescrp(this.descriptionTextBox.getText());
		deviceModel.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceModelEntityController().saveSharpDeviceModel(deviceModel);
		deviceModelViewController.populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private DeviceModelViewController deviceModelViewController;

	public void setDeviceModelViewController(DeviceModelViewController deviceModelViewController) {
		this.deviceModelViewController = deviceModelViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert SharpDeviceModel Details

			DeviceModel deviceModel = new DeviceModel();
			deviceModel.setDescrp(this.descriptionTextBox.getText());
			deviceModel.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceModelEntityController().saveSharpDeviceModel(deviceModel);
			deviceModelViewController
					.populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {
			// Centralised Form cancel

			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
