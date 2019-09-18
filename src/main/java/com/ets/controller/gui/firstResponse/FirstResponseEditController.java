package com.ets.controller.gui.firstResponse;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 26-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditFirstResponseGUIController Class
 *Description: EditFirstResponse.fxml  Controller class
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
import com.ets.controller.entity.firstResponse.FirstResponseEntityController;
import com.ets.model.FirstResponse;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FirstResponseEditController implements Initializable {

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
		// Cancel centralized Form
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update Exposure Code Details

		FirstResponse firstResponse = new FirstResponse();
		firstResponse.setId(Integer.parseInt(this.idTextField.getText()));
		firstResponse.setCode(this.codeTextField.getText());
		firstResponse.setDescrp(this.descriptionTextField.getText());
		firstResponse.setInactive(this.inactiveCheckBox.isSelected());

		new FirstResponseEntityController().modifyFirstResponse(firstResponse);
		firstResponseViewController.populateFirstResponseTable(new FirstResponseEntityController().viewFirstResponse());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private FirstResponseViewController firstResponseViewController;

	public void setFirstResponseViewController(FirstResponseViewController firstResponseViewController) {
		this.firstResponseViewController = firstResponseViewController;
	}

	private FirstResponse firstResponse; // FirstResponse Entity variable

	public void setFirstResponse(FirstResponse firstResponse) {
		this.firstResponse = firstResponse;

		idTextField.setText(Integer.toString(firstResponse.getId()));
		codeTextField.setText(firstResponse.getCode());
		descriptionTextField.setText(firstResponse.getDescrp());

		if (firstResponse.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (firstResponse.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			// Update Exposure Code Details

			FirstResponse firstResponse = new FirstResponse();

			firstResponse.setId(Integer.parseInt(this.idTextField.getText()));
			firstResponse.setCode(this.codeTextField.getText());
			firstResponse.setDescrp(this.descriptionTextField.getText());
			firstResponse.setInactive(this.inactiveCheckBox.isSelected());

			new FirstResponseEntityController().modifyFirstResponse(firstResponse);
			firstResponseViewController
					.populateFirstResponseTable(new FirstResponseEntityController().viewFirstResponse());
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
