package com.ets.controller.gui.workActivity;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkActivityGUIController Class
 *Description: EnterWorkActivityCode.fxml Controller class
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





import com.ets.controller.entity.workActivity.WorkActivityEntityController;
import com.ets.model.WorkActivity;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class WorkActivityInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField workActivityTextField;

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
		// Insert WorkActivity Details

		WorkActivity activity = new WorkActivity();

		activity.setActivity(this.workActivityTextField.getText());
		activity.setDescrp(this.descriptionTextField.getText());

		activity.setInactive(this.inactiveCheckBox.isSelected());

		new WorkActivityEntityController().saveWorkActivity(activity);
		workActivityViewController.populateWorkActivityTable(new WorkActivityEntityController().viewWorkActivity());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}		

	private WorkActivityViewController workActivityViewController;

	public void setWorkActivityViewController(WorkActivityViewController workActivityViewController) {
		this.workActivityViewController = workActivityViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert WorkActivity Details

			WorkActivity activity = new WorkActivity();

			activity.setActivity(this.workActivityTextField.getText());
			activity.setDescrp(this.descriptionTextField.getText());

			activity.setInactive(this.inactiveCheckBox.isSelected());

			new WorkActivityEntityController().saveWorkActivity(activity);
			workActivityViewController.populateWorkActivityTable(new WorkActivityEntityController().viewWorkActivity());
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
