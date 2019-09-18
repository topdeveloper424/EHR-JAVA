package com.ets.controller.gui.objectOrSubstance;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditObjectOrSubstanceGUIController Class
 *Description: EditObjectOrSubstance GUI Controller class
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

public class ObjectOrSubstanceEditController implements Initializable {
	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField objOrSubTextField;

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
		// Update ObjectOrSubstance Details

		ObjectOrSubstance objectOrSubstance = new ObjectOrSubstance();

		objectOrSubstance.setId(Integer.parseInt(this.idTextField.getText()));
		objectOrSubstance.setObjOrSub(this.objOrSubTextField.getText());
		objectOrSubstance.setDescrp(this.descriptionTextField.getText());
		objectOrSubstance.setInactive(this.inactiveCheckBox.isSelected());

		new ObjectOrSubstanceEntityController().updateObjectOrSubstance(objectOrSubstance);
		objectOrSubstanceViewController.populateObjectOrSubstanceTable(new ObjectOrSubstanceEntityController().viewObjectOrSubstance());

		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ObjectOrSubstanceViewController objectOrSubstanceViewController;

	public void setObjectOrSubstanceViewController(ObjectOrSubstanceViewController objectOrSubstanceViewController) {
		this.objectOrSubstanceViewController = objectOrSubstanceViewController;
	}

	private ObjectOrSubstance objectOrSubstance; // ObjectOrSubstance Entity
													// variable

	public void setObjectOrSubstance(ObjectOrSubstance objectOrSubstance) {
		this.objectOrSubstance = objectOrSubstance;

		idTextField.setText(Integer.toString(objectOrSubstance.getId()));
		objOrSubTextField.setText(objectOrSubstance.getObjOrSub());
		descriptionTextField.setText(objectOrSubstance.getDescrp());

		if (objectOrSubstance.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (objectOrSubstance.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			// Update ObjectOrSubstance Details

			ObjectOrSubstance objectOrSubstance = new ObjectOrSubstance();

			objectOrSubstance.setId(Integer.parseInt(this.idTextField.getText()));
			objectOrSubstance.setObjOrSub(this.objOrSubTextField.getText());
			objectOrSubstance.setDescrp(this.descriptionTextField.getText());
			objectOrSubstance.setInactive(this.inactiveCheckBox.isSelected());

			new ObjectOrSubstanceEntityController().updateObjectOrSubstance(objectOrSubstance);
			objectOrSubstanceViewController
					.populateObjectOrSubstanceTable(new ObjectOrSubstanceEntityController().viewObjectOrSubstance());

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
