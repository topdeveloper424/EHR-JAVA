package com.ets.controller.gui.deviceManufacturerAndBrand;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditDeviceManufacturerAndBrandGUIController Class
 *Description: EditDeviceManufacturerAndBrand GUI Controller class
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

public class DeviceManufacturerAndBrandEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField manufacturerTextField;

	@FXML
	private TextField brandTextField;

	@FXML
	private TextField idTextField;
	
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
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update SharpDeviceManufacAndBrand Details

		DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = new DeviceManufacturerAndBrand();

		sharpDeviceManufacAndBrand.setId(Integer.parseInt(this.idTextField.getText()));
		sharpDeviceManufacAndBrand.setMfd(this.manufacturerTextField.getText());
		sharpDeviceManufacAndBrand.setBrand(this.brandTextField.getText());
		sharpDeviceManufacAndBrand.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceManufacturerAndBrandEntityontroller().updateSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
		deviceManufacturerAndBrandEditController.populateDeviceManufacturerAndBrandTable(new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private DeviceManufacturerAndBrand sharpDeviceManufacAndBrand;

	public void setSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand) {
		this.sharpDeviceManufacAndBrand = sharpDeviceManufacAndBrand;

		idTextField.setText(Integer.toString(sharpDeviceManufacAndBrand.getId()));
		manufacturerTextField.setText(sharpDeviceManufacAndBrand.getMfd());
		brandTextField.setText(sharpDeviceManufacAndBrand.getBrand());

		if (sharpDeviceManufacAndBrand.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (sharpDeviceManufacAndBrand.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	private DeviceManufacturerAndBrandViewController deviceManufacturerAndBrandEditController;

	public void setDeviceManufacturerAndBrandEditController(
			DeviceManufacturerAndBrandViewController deviceManufacturerAndBrandEditController) {
		this.deviceManufacturerAndBrandEditController = deviceManufacturerAndBrandEditController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update SharpDeviceManufacAndBrand Details

			DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = new DeviceManufacturerAndBrand();

			sharpDeviceManufacAndBrand.setId(Integer.parseInt(this.idTextField.getText()));
			sharpDeviceManufacAndBrand.setMfd(this.manufacturerTextField.getText());
			sharpDeviceManufacAndBrand.setBrand(this.brandTextField.getText());
			sharpDeviceManufacAndBrand.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceManufacturerAndBrandEntityontroller()
					.updateSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
			deviceManufacturerAndBrandEditController.populateDeviceManufacturerAndBrandTable(
					new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

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
