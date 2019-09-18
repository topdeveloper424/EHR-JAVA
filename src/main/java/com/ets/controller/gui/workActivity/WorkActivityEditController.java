package com.ets.controller.gui.workActivity;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditWorkActivityGUIController Class
 *Description: WorkActivity GUI Controller class
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

public class WorkActivityEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField workActivityTextField;

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
		// Update WorkActivity Details
		WorkActivity workActivity = new WorkActivity();
		workActivity.setId(Integer.parseInt(this.idTextField.getText()));
		workActivity.setActivity(this.workActivityTextField.getText());
		workActivity.setDescrp(this.descriptionTextField.getText());
		workActivity.setInactive(this.inactiveCheckBox.isSelected());

		new WorkActivityEntityController().updateWorkActivity(workActivity);
		workActivityViewController.populateWorkActivityTable(new WorkActivityEntityController().viewWorkActivity());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}		

	private WorkActivityViewController workActivityViewController;

	public void setWorkActivityViewController(WorkActivityViewController workActivityViewController) {
		this.workActivityViewController = workActivityViewController;
	}

	private WorkActivity workActivity; // WorkActivity Entity variable

	public void setWorkActivity(WorkActivity workActivity) {
		this.workActivity = workActivity;

		idTextField.setText(Integer.toString(workActivity.getId()));
		workActivityTextField.setText(workActivity.getActivity());
		descriptionTextField.setText(workActivity.getDescrp());

		if (workActivity.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (workActivity.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update WorkActivity Details

			WorkActivity workActivity = new WorkActivity();
			workActivity.setId(Integer.parseInt(this.idTextField.getText()));
			workActivity.setActivity(this.workActivityTextField.getText());
			workActivity.setDescrp(this.descriptionTextField.getText());
			workActivity.setInactive(this.inactiveCheckBox.isSelected());

			new WorkActivityEntityController().updateWorkActivity(workActivity);
			workActivityViewController.populateWorkActivityTable(new WorkActivityEntityController().viewWorkActivity());
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
