package com.ets.controller.gui.rootCause;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseGUIController Class
 *Description: EnterRootCause.fxml Controller class
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

import com.ets.controller.entity.rootCause.RootCauseEntityController;
import com.ets.model.RootCause;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class RootCauseInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField rootCauseTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;	
	
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
		// Insert RootCause Details

		RootCause rootCause = new RootCause();
		rootCause.setCause(this.rootCauseTextField.getText());
		rootCause.setDescrp(this.descriptionTextField.getText());
		rootCause.setWc10Code(this.wcioTextField.getText());
		rootCause.setInactive(this.inactiveCheckBox.isSelected());

		new RootCauseEntityController().saveRootCause(rootCause);
		rootCauseViewController.populateRootCauseTable(new RootCauseEntityController().viewRootCause());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private RootCauseViewController rootCauseViewController;

	public void setRootCauseViewController(RootCauseViewController rootCauseViewController) {
		this.rootCauseViewController = rootCauseViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Insert RootCause Details

			RootCause rootCause = new RootCause();

			rootCause.setCause(this.rootCauseTextField.getText());
			rootCause.setDescrp(this.descriptionTextField.getText());
			rootCause.setWc10Code(this.wcioTextField.getText());
			rootCause.setInactive(this.inactiveCheckBox.isSelected());

			new RootCauseEntityController().saveRootCause(rootCause);
			rootCauseViewController.populateRootCauseTable(new RootCauseEntityController().viewRootCause());
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
