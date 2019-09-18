package com.ets.controller.gui.deviceType;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceControllerGUIController Class
 *Description: EnterDeviceType.fxml Controller class
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

import com.ets.controller.entity.deviceType.DeviceTypeEntityController;
import com.ets.model.DeviceType;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DeviceTypeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField typeTextField;

	@FXML
	private TextField descriptionTextField;	
	
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
		// Insert SharpDevice Details

		DeviceType device = new DeviceType();
		device.setType(this.typeTextField.getText());
		device.setDescrp(this.descriptionTextField.getText());
		device.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceTypeEntityController().saveSharpDevice(device);
		deviceTypeViewController.populateDeviceTypeTable(new DeviceTypeEntityController().viewSharpDdevice());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private DeviceTypeViewController deviceTypeViewController;

	public void setDeviceTypeViewController(DeviceTypeViewController deviceTypeViewController) {
		this.deviceTypeViewController = deviceTypeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert SharpDevice Details

			DeviceType device = new DeviceType();
			device.setType(this.typeTextField.getText());
			device.setDescrp(this.descriptionTextField.getText());
			device.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceTypeEntityController().saveSharpDevice(device);
			deviceTypeViewController.populateDeviceTypeTable(new DeviceTypeEntityController().viewSharpDdevice());
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
