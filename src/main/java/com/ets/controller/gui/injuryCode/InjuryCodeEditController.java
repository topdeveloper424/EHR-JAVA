package com.ets.controller.gui.injuryCode;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditInjuryCodeGUIController Class
 *Description: InjiryCode GUI Controller class
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
import com.ets.controller.entity.injuryCode.InjuryCodeEntityController;
import com.ets.model.InjuryCode;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class InjuryCodeEditController implements Initializable {

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
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update IllnessCode Details
		InjuryCode injuryCode = new InjuryCode();
		injuryCode.setId(Integer.parseInt(this.idTextField.getText()));
		injuryCode.setCode(this.codeTextField.getText());
		injuryCode.setDescrp(this.descriptionTextField.getText());
		injuryCode.setWc10Code(this.wcioTextField.getText());
		injuryCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
		injuryCode.setInactive(this.inactiveCheckBox.isSelected());

		new InjuryCodeEntityController().updateInjuryCode(injuryCode);
		injuryCodeViewController.populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Centralised Form cancel
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private InjuryCodeViewController injuryCodeViewController;

	public void setInjuryCodeViewController(InjuryCodeViewController injuryCodeViewController) {
		this.injuryCodeViewController = injuryCodeViewController;
	}

	private InjuryCode injuryCode; // InjuryCode Entity variable

	public void setInjuryCode(InjuryCode injuryCode) {
		this.injuryCode = injuryCode;

		idTextField.setText(Integer.toString(injuryCode.getId()));
		codeTextField.setText(injuryCode.getCode());
		descriptionTextField.setText(injuryCode.getDescrp());
		wcioTextField.setText(injuryCode.getWc10Code());

		if (injuryCode.getAlwaysOshaRecordable() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (injuryCode.getAlwaysOshaRecordable() == true) {
			inactiveCheckBox.setSelected(false);
		}

		if (injuryCode.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (injuryCode.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update IllnessCode Details

			InjuryCode injuryCode = new InjuryCode();

			injuryCode.setId(Integer.parseInt(this.idTextField.getText()));
			injuryCode.setCode(this.codeTextField.getText());
			injuryCode.setDescrp(this.descriptionTextField.getText());
			injuryCode.setWc10Code(this.wcioTextField.getText());
			injuryCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			injuryCode.setInactive(this.inactiveCheckBox.isSelected());

			new InjuryCodeEntityController().updateInjuryCode(injuryCode);
			injuryCodeViewController.populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());
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
