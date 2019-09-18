package com.ets.controller.gui.deviceModel;

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

public class DeviceModelEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField descriptionTextBox;

	@FXML
	private TextField idTextBox;
	
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
		// Update SharpDeviceModel Details

		DeviceModel sharpDeviceModel = new DeviceModel();
		sharpDeviceModel.setId(Integer.parseInt(this.idTextBox.getText()));
		sharpDeviceModel.setDescrp(this.descriptionTextBox.getText());
		sharpDeviceModel.setInactive(this.inactiveCheckBox.isSelected());

		new DeviceModelEntityController().modifySharpDeviceModel(sharpDeviceModel);
		deviceModelEditController.populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());

		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}		

	private DeviceModelViewController deviceModelEditController;

	public void setDeviceModelEditController(DeviceModelViewController deviceModelEditController) {
		this.deviceModelEditController = deviceModelEditController;
	}

	private DeviceModel sharpDeviceModel; // SharpDeviceModel Entity variable

	public void setSharpDeviceModel(DeviceModel sharpDeviceModel) {
		this.sharpDeviceModel = sharpDeviceModel;

		idTextBox.setText(Integer.toString(sharpDeviceModel.getId()));
		descriptionTextBox.setText(sharpDeviceModel.getDescrp());

		if (sharpDeviceModel.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (sharpDeviceModel.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update SharpDeviceModel Details

			DeviceModel sharpDeviceModel = new DeviceModel();

			sharpDeviceModel.setId(Integer.parseInt(this.idTextBox.getText()));
			sharpDeviceModel.setDescrp(this.descriptionTextBox.getText());
			sharpDeviceModel.setInactive(this.inactiveCheckBox.isSelected());

			new DeviceModelEntityController().modifySharpDeviceModel(sharpDeviceModel);
			deviceModelEditController
					.populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());

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
