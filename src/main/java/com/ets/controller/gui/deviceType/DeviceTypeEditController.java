package com.ets.controller.gui.deviceType;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceTypeEditController Class
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

public class DeviceTypeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField typeTextField;

	@FXML
	private TextField descriptionTextField;

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
		// Update SharpDevice Details

		DeviceType sharpDevice = new DeviceType();
		sharpDevice.setId(Integer.parseInt(this.idTextField.getText()));
		sharpDevice.setType(this.typeTextField.getText());
		sharpDevice.setDescrp(this.descriptionTextField.getText());
		sharpDevice.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceTypeEntityController().modifySharpDevice(sharpDevice);
		deviceTypeViewController.populateDeviceTypeTable(new DeviceTypeEntityController().viewSharpDdevice());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private DeviceTypeViewController deviceTypeViewController;

	public void setDeviceTypeViewController(DeviceTypeViewController deviceTypeViewController) {
		this.deviceTypeViewController = deviceTypeViewController;
	}

	private DeviceType sharpDevice; // SharpDevice Entity variable

	public void setSharpDevice(DeviceType sharpDevice) {
		this.sharpDevice = sharpDevice;

		idTextField.setText(Integer.toString(sharpDevice.getId()));
		typeTextField.setText(sharpDevice.getType());
		descriptionTextField.setText(sharpDevice.getDescrp());

		if (sharpDevice.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (sharpDevice.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update SharpDevice Details

			DeviceType sharpDevice = new DeviceType();

			sharpDevice.setId(Integer.parseInt(this.idTextField.getText()));
			sharpDevice.setType(this.typeTextField.getText());
			sharpDevice.setDescrp(this.descriptionTextField.getText());
			sharpDevice.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceTypeEntityController().modifySharpDevice(sharpDevice);
			deviceTypeViewController.populateDeviceTypeTable(new DeviceTypeEntityController().viewSharpDdevice());
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
