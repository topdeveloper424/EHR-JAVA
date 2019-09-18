package com.ets.controller.gui.firstResponse;



import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.firstResponse.FirstResponseEntityController;
import com.ets.model.FirstResponse;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FirstResponseGUIController Class
 *Description: EnterFirstResponse.fxml Controller class
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

public class FirstResponseInputController implements Initializable {

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
		// Cancel centralized Form

		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert Data into Table

		FirstResponse firstResponse = new FirstResponse();
		firstResponse.setCode(this.codeTextField.getText());
		firstResponse.setDescrp(this.descriptionTextField.getText());
		firstResponse.setInactive(this.inactiveCheckBox.isSelected());

		new FirstResponseEntityController().saveFirstResponse(firstResponse);
		firstResponseViewController.populateFirstResponseTable(new FirstResponseEntityController().viewFirstResponse());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private FirstResponseViewController firstResponseViewController;

	public void setFirstResponseViewController(FirstResponseViewController firstResponseViewController) {
		this.firstResponseViewController = firstResponseViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Insert Data into Table

			FirstResponse firstResponse = new FirstResponse();

			firstResponse.setCode(this.codeTextField.getText());
			firstResponse.setDescrp(this.descriptionTextField.getText());
			firstResponse.setInactive(this.inactiveCheckBox.isSelected());

			new FirstResponseEntityController().saveFirstResponse(firstResponse);
			firstResponseViewController
					.populateFirstResponseTable(new FirstResponseEntityController().viewFirstResponse());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

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
