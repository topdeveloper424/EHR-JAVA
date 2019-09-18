package com.ets.controller.gui.deviceManufacturerAndBrand;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceManufacturerAndBrandGUIController Class
 *Description: EnterShrapDeviceManufacturerAndBrand.fxml Controller class
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
import com.ets.controller.entity.deviceManufacturerAndBrand.DeviceManufacturerAndBrandEntityontroller;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DeviceManufacturerAndBrandInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField manufacturerTextField;

	@FXML
	private TextField brandTextField;
	
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

		DeviceManufacturerAndBrand deviceManufacAndBrand = new DeviceManufacturerAndBrand();
		deviceManufacAndBrand.setBrand(this.brandTextField.getText());
		deviceManufacAndBrand.setMfd(this.manufacturerTextField.getText());
		deviceManufacAndBrand.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceManufacturerAndBrandEntityontroller().saveSharpDeviceManufacturerAndBrand(deviceManufacAndBrand);
		deviceManufacturerAndBrandViewController.populateDeviceManufacturerAndBrandTable(new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private DeviceManufacturerAndBrandViewController deviceManufacturerAndBrandViewController;

	public void setDeviceManufacturerAndBrandViewController(
			DeviceManufacturerAndBrandViewController deviceManufacturerAndBrandViewController) {
		this.deviceManufacturerAndBrandViewController = deviceManufacturerAndBrandViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert SharpDevice Details

			DeviceManufacturerAndBrand deviceManufacAndBrand = new DeviceManufacturerAndBrand();
			deviceManufacAndBrand.setBrand(this.brandTextField.getText());
			deviceManufacAndBrand.setMfd(this.manufacturerTextField.getText());
			deviceManufacAndBrand.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceManufacturerAndBrandEntityontroller().saveSharpDeviceManufacturerAndBrand(deviceManufacAndBrand);
			deviceManufacturerAndBrandViewController.populateDeviceManufacturerAndBrandTable(
					new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());
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
