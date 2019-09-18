package com.ets.controller.gui.caseClosedReason;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 25-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditCaseClosedReasonStatusGUIController Class
 *Description: EditCaseClosedReasonOrStatus.fxml  Controller class
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






import com.ets.controller.entity.caseClosedReason.CaseClosedReasonStatusEntityController;
import com.ets.model.CaseClosedReason;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CaseClosedReasonOrStatusEditController implements Initializable {
	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField reasonTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private CheckBox reportCheckBox;

	@FXML
	private TextField idTextField;

	private CaseClosedReason caseClosedReason; // CaseClosedReason Entity
												// variable

	private CaseClosedReasonOrStatusViewController caseClosedReasonOrStatusViewController;

	public void setCaseClosedReasonOrStatusViewController(
			CaseClosedReasonOrStatusViewController caseClosedReasonOrStatusViewController) {
		this.caseClosedReasonOrStatusViewController = caseClosedReasonOrStatusViewController;
	}

	public void setCaseClosedReason(CaseClosedReason caseClosedReason) {
		this.caseClosedReason = caseClosedReason;

		idTextField.setText(Integer.toString(caseClosedReason.getId()));
		reasonTextField.setText(caseClosedReason.getReason());
		descriptionTextField.setText(caseClosedReason.getDescrp());
		
		if (caseClosedReason.getExcludeFromReport() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (caseClosedReason.getExcludeFromReport() == true) {
			inactiveCheckBox.setSelected(false);
		}

		if (caseClosedReason.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (caseClosedReason.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Update CaseClosedReason Details

		updateButton.setOnAction((event) -> {

			CaseClosedReason caseClosedReason = new CaseClosedReason();

			caseClosedReason.setId(Integer.parseInt(this.idTextField.getText()));
			caseClosedReason.setReason(this.reasonTextField.getText());
			caseClosedReason.setDescrp(this.descriptionTextField.getText());
			caseClosedReason.setExcludeFromReport(this.reportCheckBox.isSelected());
			caseClosedReason.setInactive(this.inactiveCheckBox.isSelected());

			new CaseClosedReasonStatusEntityController().modifyCaseClosedReason(caseClosedReason);
			caseClosedReasonOrStatusViewController
					.populateCaseClosedReasonTable(new CaseClosedReasonStatusEntityController().viewCaseClosedReason());

			try {
				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		// Cancel centralized Form
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}
}
