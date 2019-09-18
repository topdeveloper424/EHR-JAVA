package com.ets.controller.gui.severity;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ServerityCodeGUIController Class
 *Description: EnterServerityCodes.fxml Controller class
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

public class ServerityCodeInputController implements Initializable {

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
		// Insert SeverityCode Details

		SeverityCode code = new SeverityCode();
		code.setCode(this.codeTextField.getText());
		code.setDescrp(this.descriptionTextField.getText());
		code.setInactive(this.inactiveCheckBox.isSelected());

		new SeverityEntityController().saveSaverityCode(code);
		serverityCodeViewController.populateSeverityTable(new SeverityEntityController().viewSeverity());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ServerityCodeViewController serverityCodeViewController;

	public void setServerityCodeViewController(ServerityCodeViewController serverityCodeViewController) {
		this.serverityCodeViewController = serverityCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert SeverityCode Details

			SeverityCode code = new SeverityCode();
			code.setCode(this.codeTextField.getText());
			code.setDescrp(this.descriptionTextField.getText());
			code.setInactive(this.inactiveCheckBox.isSelected());

			new SeverityEntityController().saveSaverityCode(code);
			serverityCodeViewController.populateSeverityTable(new SeverityEntityController().viewSeverity());
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
