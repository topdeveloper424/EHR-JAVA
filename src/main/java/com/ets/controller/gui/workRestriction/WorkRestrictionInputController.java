package com.ets.controller.gui.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.workRestriction.WorkRestrictionEntityController;
import com.ets.model.WorkRestriction;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionInputController Class
 *Description: Enter.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

public class WorkRestrictionInputController implements Initializable {

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

	private WorkRestrictionViewController workRestrictionViewController;

	public void setWorkRestrictionViewController(WorkRestrictionViewController workRestrictionViewController) {
		this.workRestrictionViewController = workRestrictionViewController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {

			try {

				WorkRestriction workRestriction = new WorkRestriction();
				workRestriction.setCode(codeTextField.getText());
				workRestriction.setDescrp(descriptionTextField.getText());
				workRestriction.setInactive(inactiveCheckBox.isSelected());

				new WorkRestrictionEntityController().save(workRestriction);
				workRestrictionViewController.refreshWorkRestriction();

				try {

					new FXFormCommonUtilities().closeForm(okButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
