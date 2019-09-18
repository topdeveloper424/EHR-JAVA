package com.ets.controller.gui.objectOrSubstance;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ObjectOrSubstanceGUIController Class
 *Description: EnterObjectOrSubstances.fxml Controller class
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

import com.ets.controller.entity.objectOrSubstance.ObjectOrSubstanceEntityController;
import com.ets.model.ObjectOrSubstance;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ObjectOrSubstanceInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField objOrSubTextField;

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
		// Insert InjuryCode Code

		ObjectOrSubstance orSubstance = new ObjectOrSubstance();
		orSubstance.setObjOrSub(this.objOrSubTextField.getText());
		orSubstance.setDescrp(this.descriptionTextField.getText());
		orSubstance.setInactive(this.inactiveCheckBox.isSelected());

		new ObjectOrSubstanceEntityController().saveObjectOrSubstance(orSubstance);
		ObjectOrSubstanceViewController.populateObjectOrSubstanceTable(new ObjectOrSubstanceEntityController().viewObjectOrSubstance());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ObjectOrSubstanceViewController ObjectOrSubstanceViewController;

	public void setObjectOrSubstanceViewController(ObjectOrSubstanceViewController objectOrSubstanceViewController) {
		ObjectOrSubstanceViewController = objectOrSubstanceViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert InjuryCode Code

			ObjectOrSubstance orSubstance = new ObjectOrSubstance();
			orSubstance.setObjOrSub(this.objOrSubTextField.getText());
			orSubstance.setDescrp(this.descriptionTextField.getText());
			orSubstance.setInactive(this.inactiveCheckBox.isSelected());

			new ObjectOrSubstanceEntityController().saveObjectOrSubstance(orSubstance);
			ObjectOrSubstanceViewController
					.populateObjectOrSubstanceTable(new ObjectOrSubstanceEntityController().viewObjectOrSubstance());
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
