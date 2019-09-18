package com.ets.controller.gui.stateJobCategory;

/* *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditStateJobCategoryGUIController Class
 *Description: StateJobCategory GUI Controller class
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
import javafx.scene.input.KeyEvent;

public class StateJobCategoryEditController implements Initializable {
	
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

    }

    @FXML
    void enterKeyPressedForUpdateButton(KeyEvent event) {

    }
	
	
	

	private StateJobCategoryViewController stateJobCategoryViewController;

	public void setStateJobCategoryViewController(StateJobCategoryViewController stateJobCategoryViewController) {
		this.stateJobCategoryViewController = stateJobCategoryViewController;
	}

	private StateJobCategory stateJobCategory; // StateJobCategory Entity
												// variable

	public void setStateJobCategory(StateJobCategory stateJobCategory) {
		this.stateJobCategory = stateJobCategory;

		idTextField.setText(Integer.toString(stateJobCategory.getId()));
		codeTextField.setText(stateJobCategory.getCode());
		descriptionTextField.setText(stateJobCategory.getDescrp());
		
		if (stateJobCategory.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (stateJobCategory.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update StateJobCategory Details

			StateJobCategory stateJobCategory = new StateJobCategory();

			stateJobCategory.setId(Integer.parseInt(this.idTextField.getText()));
			stateJobCategory.setCode(this.codeTextField.getText());
			stateJobCategory.setDescrp(this.descriptionTextField.getText());
			stateJobCategory.setInactive(this.inactiveCheckBox.isSelected());

			new StateJobCategoryEntityController().updateStateJobCategory(stateJobCategory);
			stateJobCategoryViewController
					.populateStateJobCategoryTable(new StateJobCategoryEntityController().viewStateJobCategory());
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
