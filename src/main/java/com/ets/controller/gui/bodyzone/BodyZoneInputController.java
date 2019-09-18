package com.ets.controller.gui.bodyzone;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneGUIController Class
 *Description: EnterBodyZoneCodes.fxml Controller class
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

public class BodyZoneInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField bodyZoneTextField;

	@FXML
	private TextField descriptionTextField;
	
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert Data into Table

		BodyZone zone = new BodyZone();
		zone.setZone(this.bodyZoneTextField.getText());
		zone.setDescrp(this.descriptionTextField.getText());
		zone.setInactive(this.inactiveCheckBox.isSelected());

		new BodyZoneEntityController().saveBodyZone(zone);
		bodyZoneViewController.populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());

		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private BodyZoneViewController bodyZoneViewController;

	public void setBodyZoneViewController(BodyZoneViewController bodyZoneViewController) {
		this.bodyZoneViewController = bodyZoneViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert Data into Table

			BodyZone zone = new BodyZone();
			zone.setZone(this.bodyZoneTextField.getText());
			zone.setDescrp(this.descriptionTextField.getText());
			zone.setInactive(this.inactiveCheckBox.isSelected());

			new BodyZoneEntityController().saveBodyZone(zone);
			bodyZoneViewController.populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Cancel centralized Form

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
