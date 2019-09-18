package com.ets.controller.gui.stateWorkArea;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditStateWorkAreaGUIController Class
 *Description: EditStateWorkArea GUI Controller class
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

import com.ets.controller.entity.stateWorkArea.StateWorkAreaEntityController;
import com.ets.model.StateWorkArea;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class StateWorkAreaEditController implements Initializable {

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

	private StateWorkAreaViewController stateWorkAreaViewController;

	public void setStateWorkAreaViewController(StateWorkAreaViewController stateWorkAreaViewController) {
		this.stateWorkAreaViewController = stateWorkAreaViewController;
	}

	private StateWorkArea stateWorkArea; // StateWorkArea Entity variable

	public void setStateWorkArea(StateWorkArea stateWorkArea) {
		this.stateWorkArea = stateWorkArea;

		idTextField.setText(Integer.toString(stateWorkArea.getId()));
		codeTextField.setText(stateWorkArea.getCode());
		descriptionTextField.setText(stateWorkArea.getDescrp());

		if (stateWorkArea.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (stateWorkArea.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update StateWorkArea Details

			StateWorkArea stateWorkArea = new StateWorkArea();
			stateWorkArea.setId(Integer.parseInt(this.idTextField.getText()));
			stateWorkArea.setCode(this.codeTextField.getText());
			stateWorkArea.setDescrp(this.descriptionTextField.getText());
			stateWorkArea.setInactive(this.inactiveCheckBox.isSelected());

			new StateWorkAreaEntityController().updateStateWorkArea(stateWorkArea);
			stateWorkAreaViewController
					.populateStateWorkAreaTable(new StateWorkAreaEntityController().viewStateWorkArea());
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
