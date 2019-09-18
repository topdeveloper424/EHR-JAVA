package com.ets.controller.gui.exposurecode;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExposureCodeGUIController Class
 *Description: EnterExposureCode.fxml Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ExposureCodeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

	@FXML
	private CheckBox oshaCheckBox;

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
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert Data into Table

		ExposureCode exposureCode = new ExposureCode();
		exposureCode.setCode(this.codeTextField.getText());
		exposureCode.setDescrp(this.descriptionTextField.getText());
		exposureCode.setWc10Code(this.wcioTextField.getText());
		exposureCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
		exposureCode.setInactive(this.inactiveCheckBox.isSelected());

		new ExposureCodeEntityController().saveExposureCode(exposureCode);
		exposureCodeViewController.populateExposureTable(new ExposureCodeEntityController().viewExposureCode());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private ExposureCodeViewController exposureCodeViewController;

	public void setExposureCodeViewController(ExposureCodeViewController exposureCodeViewController) {
		this.exposureCodeViewController = exposureCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Insert Data into Table

			ExposureCode exposureCode = new ExposureCode();

			exposureCode.setCode(this.codeTextField.getText());
			exposureCode.setDescrp(this.descriptionTextField.getText());
			exposureCode.setWc10Code(this.wcioTextField.getText());
			exposureCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			exposureCode.setInactive(this.inactiveCheckBox.isSelected());

			new ExposureCodeEntityController().saveExposureCode(exposureCode);
			exposureCodeViewController.populateExposureTable(new ExposureCodeEntityController().viewExposureCode());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

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
