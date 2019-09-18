package com.ets.controller.gui.bodyzone;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 25-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditBodyZoneGUIController Class
 *Description: EditBodyZoneCode.fxml Controller class
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

import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.model.BodyZone;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BodyZoneEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField bodyZoneTextField;

	@FXML
	private TextField descriptionTextField;

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
		BodyZone bodyZone = new BodyZone();
		bodyZone.setId(Integer.parseInt(this.idTextField.getText()));
		bodyZone.setZone(this.bodyZoneTextField.getText());
		bodyZone.setDescrp(this.descriptionTextField.getText());
		bodyZone.setInactive(this.inactiveCheckBox.isSelected());

		new BodyZoneEntityController().modifyBodyZone(bodyZone);

		bodyZoneViewController.populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());

		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private BodyZoneViewController bodyZoneViewController;

	public void setBodyZoneViewController(BodyZoneViewController bodyZoneViewController) {
		this.bodyZoneViewController = bodyZoneViewController;
	}

	private BodyZone bodyZone;

	public void setBodyZone(BodyZone bodyZone) {
		this.bodyZone = bodyZone;

		idTextField.setText(Integer.toString(bodyZone.getId()));
		bodyZoneTextField.setText(bodyZone.getZone());
		descriptionTextField.setText(bodyZone.getDescrp());

		if (bodyZone.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (bodyZone.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Update Body Part Details

		updateButton.setOnAction((event) -> {

			BodyZone bodyZone = new BodyZone();

			bodyZone.setId(Integer.parseInt(this.idTextField.getText()));
			bodyZone.setZone(this.bodyZoneTextField.getText());
			bodyZone.setDescrp(this.descriptionTextField.getText());
			bodyZone.setInactive(this.inactiveCheckBox.isSelected());

			new BodyZoneEntityController().modifyBodyZone(bodyZone);

			bodyZoneViewController.populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());

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
