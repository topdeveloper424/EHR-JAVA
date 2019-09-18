package com.ets.controller.gui.exposurecode;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditExposureCodeGUIController Class
 *Description: ExposureCode GUI Controller class
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

import com.ets.controller.entity.exposureCode.ExposureCodeEntityController;
import com.ets.model.ExposureCode;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class ExposureCodeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

	@FXML
	private CheckBox oshaCheckBox;

	@FXML
	private TextField idTextField;

	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Cancel centralized Form
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update Exposure Code Details

		ExposureCode exposureCode = new ExposureCode();
		exposureCode.setId(Integer.parseInt(this.idTextField.getText()));
		exposureCode.setCode(this.codeTextField.getText());
		exposureCode.setDescrp(this.descriptionTextField.getText());
		exposureCode.setWc10Code(this.wcioTextField.getText());
		exposureCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
		exposureCode.setInactive(this.inactiveCheckBox.isSelected());

		new ExposureCodeEntityController().modifyExposureCode(exposureCode);
		exposureCodeViewController.populateExposureTable(new ExposureCodeEntityController().viewExposureCode());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private ExposureCodeViewController exposureCodeViewController;

	public void setExposureCodeViewController(ExposureCodeViewController exposureCodeViewController) {
		this.exposureCodeViewController = exposureCodeViewController;
	}

	private ExposureCode exposureCode; // Exposure Code Entity variable

	public void setExposureCode(ExposureCode exposureCode) {
		this.exposureCode = exposureCode;

		idTextField.setText(Integer.toString(exposureCode.getId()));
		codeTextField.setText(exposureCode.getCode());
		descriptionTextField.setText(exposureCode.getDescrp());
		wcioTextField.setText(exposureCode.getWc10Code());

		if (exposureCode.getInactive() == true) {
			oshaCheckBox.setSelected(true);
		} else if (exposureCode.getInactive() == true) {
			oshaCheckBox.setSelected(false);
		}

		if (exposureCode.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (exposureCode.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			// Update Exposure Code Details

			ExposureCode exposureCode = new ExposureCode();

			exposureCode.setId(Integer.parseInt(this.idTextField.getText()));
			exposureCode.setCode(this.codeTextField.getText());
			exposureCode.setDescrp(this.descriptionTextField.getText());
			exposureCode.setWc10Code(this.wcioTextField.getText());
			exposureCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			exposureCode.setInactive(this.inactiveCheckBox.isSelected());

			new ExposureCodeEntityController().modifyExposureCode(exposureCode);
			exposureCodeViewController.populateExposureTable(new ExposureCodeEntityController().viewExposureCode());
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
