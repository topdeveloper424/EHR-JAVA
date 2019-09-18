package com.ets.controller.gui.stateJobCategory;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateJobCategoryGUIController Class
 *Description: SelectBodyPartCodes.fxml Controller class
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






import com.ets.controller.entity.stateJobCategory.StateJobCategoryEntityController;
import com.ets.model.StateJobCategory;
import com.ets.utils.FXFormCommonUtilities;






import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class StateJobCategoryInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField decriptionTextField;

	private StateJobCategoryViewController stateJobCategoryViewController;

	public void setStateJobCategoryViewController(StateJobCategoryViewController stateJobCategoryViewController) {
		this.stateJobCategoryViewController = stateJobCategoryViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert StateJobCategory Details

			StateJobCategory jobCategory = new StateJobCategory();

			jobCategory.setCode(codeTextField.getText());
			jobCategory.setDescrp(decriptionTextField.getText());
			jobCategory.setInactive(this.inactiveCheckBox.isSelected());

			new StateJobCategoryEntityController().saveSatejobCategory(jobCategory);
			stateJobCategoryViewController
					.populateStateJobCategoryTable(new StateJobCategoryEntityController().viewStateJobCategory());
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
