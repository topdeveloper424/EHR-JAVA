package com.ets.controller.gui.stateWorkArea;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaGUIController Class
 *Description: EnterWorkAreaCode.fxml Controller class
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





import com.ets.controller.entity.stateWorkArea.StateWorkAreaEntityController;
import com.ets.model.StateWorkArea;
import com.ets.utils.FXFormCommonUtilities;





import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class StateWorkAreaInputController implements Initializable {

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

	private StateWorkAreaViewController stateWorkAreaViewController;

	public void setStateWorkAreaViewController(StateWorkAreaViewController stateWorkAreaViewController) {
		this.stateWorkAreaViewController = stateWorkAreaViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert StateWorkArea Details

			StateWorkArea workArea = new StateWorkArea();

			workArea.setCode(this.codeTextField.getText());
			workArea.setDescrp(this.descriptionTextField.getText());
			workArea.setInactive(this.inactiveCheckBox.isSelected());

			new StateWorkAreaEntityController().saveStateWorkArea(workArea);
			stateWorkAreaViewController
					.populateStateWorkAreaTable(new StateWorkAreaEntityController().viewStateWorkArea());
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
