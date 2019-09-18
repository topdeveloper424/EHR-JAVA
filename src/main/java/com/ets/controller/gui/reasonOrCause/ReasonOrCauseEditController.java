package com.ets.controller.gui.reasonOrCause;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditReasonOrCauseGUIController Class
 *Description: ReasonOrCause GUI Controller class
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

import com.ets.controller.entity.reasonOrCause.ReasonOrCauseEntityController;
import com.ets.model.ReasonOrCause;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ReasonOrCauseEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField reasonCauseTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

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

		ReasonOrCause reasonOrCause = new ReasonOrCause();
		reasonOrCause.setId(Integer.parseInt(this.idTextField.getText()));
		reasonOrCause.setReasonCause(this.reasonCauseTextField.getText());
		reasonOrCause.setDescrp(this.descriptionTextField.getText());
		reasonOrCause.setWc10Code(this.wcioTextField.getText());
		reasonOrCause.setInactive(this.inactiveCheckBox.isSelected());

		new ReasonOrCauseEntityController().updateReasonOrCause(reasonOrCause);
		reaonOrCausesViewController.populateReasonOrCauseTable(new ReasonOrCauseEntityController().viewReasonOrCause());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ReasonOrCauseViewController reaonOrCausesViewController;

	public void setReaonOrCausesViewController(ReasonOrCauseViewController reaonOrCausesViewController) {
		this.reaonOrCausesViewController = reaonOrCausesViewController;
	}

	public ReasonOrCause reasonOrCause; // ReasonOrCause Entity variable

	public void setReasonOrCause(ReasonOrCause reasonOrCause) {
		this.reasonOrCause = reasonOrCause;

		idTextField.setText(Integer.toString(reasonOrCause.getId()));
		reasonCauseTextField.setText(reasonOrCause.getReasonCause());
		descriptionTextField.setText(reasonOrCause.getDescrp());
		wcioTextField.setText(reasonOrCause.getWc10Code());

		if (reasonOrCause.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (reasonOrCause.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update ObjectOrSubstance Details

			ReasonOrCause reasonOrCause = new ReasonOrCause();
			reasonOrCause.setId(Integer.parseInt(this.idTextField.getText()));
			reasonOrCause.setReasonCause(this.reasonCauseTextField.getText());
			reasonOrCause.setDescrp(this.descriptionTextField.getText());
			reasonOrCause.setWc10Code(this.wcioTextField.getText());
			reasonOrCause.setInactive(this.inactiveCheckBox.isSelected());

			new ReasonOrCauseEntityController().updateReasonOrCause(reasonOrCause);
			reaonOrCausesViewController
					.populateReasonOrCauseTable(new ReasonOrCauseEntityController().viewReasonOrCause());
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
