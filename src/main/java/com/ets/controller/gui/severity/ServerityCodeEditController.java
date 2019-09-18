package com.ets.controller.gui.severity;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ServerityCodeEditController Class
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

import com.ets.controller.entity.severity.SeverityEntityController;
import com.ets.model.SeverityCode;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ServerityCodeEditController implements Initializable {

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
		// Update RootCause Details

		SeverityCode severityCode = new SeverityCode();
		severityCode.setId(Integer.parseInt(this.idTextField.getText()));
		severityCode.setCode(this.codeTextField.getText());
		severityCode.setDescrp(this.descriptionTextField.getText());
		severityCode.setInactive(this.inactiveCheckBox.isSelected());

		new SeverityEntityController().updateSeverityCode(severityCode);
		serverityCodeViewController.populateSeverityTable(new SeverityEntityController().viewSeverity());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ServerityCodeViewController serverityCodeViewController;

	public void setServerityCodeViewController(ServerityCodeViewController serverityCodeViewController) {
		this.serverityCodeViewController = serverityCodeViewController;
	}

	private SeverityCode severityCode; // SeverityCode Entity variable

	public void setSeverityCode(SeverityCode severityCode) {
		this.severityCode = severityCode;

		idTextField.setText(Integer.toString(severityCode.getId()));
		codeTextField.setText(severityCode.getCode());
		descriptionTextField.setText(severityCode.getDescrp());

		if (severityCode.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (severityCode.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update RootCause Details

			SeverityCode severityCode = new SeverityCode();

			severityCode.setId(Integer.parseInt(this.idTextField.getText()));
			severityCode.setCode(this.codeTextField.getText());
			severityCode.setDescrp(this.descriptionTextField.getText());
			severityCode.setInactive(this.inactiveCheckBox.isSelected());

			new SeverityEntityController().updateSeverityCode(severityCode);
			serverityCodeViewController.populateSeverityTable(new SeverityEntityController().viewSeverity());
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
