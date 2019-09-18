package com.ets.controller.gui.rootCause;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditRootCauseGUIController Class
 *Description: RootCause GUI Controller class
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

public class RootCauseEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField rootCauseTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

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
		RootCause rootCause = new RootCause();
		rootCause.setId(Integer.parseInt(this.idTextField.getText()));
		rootCause.setCause(this.rootCauseTextField.getText());
		rootCause.setDescrp(this.descriptionTextField.getText());
		rootCause.setWc10Code(this.wcioTextField.getText());
		rootCause.setInactive(this.inactiveCheckBox.isSelected());

		new RootCauseEntityController().updateRootCause(rootCause);
		rootCauseViewController.populateRootCauseTable(new RootCauseEntityController().viewRootCause());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private RootCauseViewController rootCauseViewController;

	public void setRootCauseViewController(RootCauseViewController rootCauseViewController) {
		this.rootCauseViewController = rootCauseViewController;
	}

	private RootCause rootCause; // RootCause Entity variable

	public void setRootCause(RootCause rootCause) {
		this.rootCause = rootCause;

		idTextField.setText(Integer.toString(rootCause.getId()));
		rootCauseTextField.setText(rootCause.getCause());
		descriptionTextField.setText(rootCause.getDescrp());
		wcioTextField.setText(rootCause.getWc10Code());
		
		if (rootCause.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (rootCause.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update RootCause Details

			RootCause rootCause = new RootCause();
			rootCause.setId(Integer.parseInt(this.idTextField.getText()));
			rootCause.setCause(this.rootCauseTextField.getText());
			rootCause.setDescrp(this.descriptionTextField.getText());
			rootCause.setWc10Code(this.wcioTextField.getText());
			rootCause.setInactive(this.inactiveCheckBox.isSelected());

			new RootCauseEntityController().updateRootCause(rootCause);
			rootCauseViewController.populateRootCauseTable(new RootCauseEntityController().viewRootCause());
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
