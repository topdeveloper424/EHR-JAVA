package com.ets.controller.gui.caseClosedReason;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonOrStatusGUIController Class
 *Description: EnterCaseClosedReasonOrStatus.fxml Controller class
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

public class CaseClosedReasonOrStatusInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField reasonTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private CheckBox reportCheckBox;

	private CaseClosedReasonOrStatusViewController caseClosedReasonOrStatusViewController;

	public void setCaseClosedReasonOrStatusViewController(
			CaseClosedReasonOrStatusViewController caseClosedReasonOrStatusViewController) {
		this.caseClosedReasonOrStatusViewController = caseClosedReasonOrStatusViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert Data into Table

			CaseClosedReason caseClosedReason = new CaseClosedReason();
			caseClosedReason.setReason(this.reasonTextField.getText());
			caseClosedReason.setDescrp(this.descriptionTextField.getText());
			caseClosedReason.setExcludeFromReport(this.reportCheckBox.isSelected());
			caseClosedReason.setInactive(this.inactiveCheckBox.isSelected());

			new CaseClosedReasonStatusEntityController().saveCaseClosedReason(caseClosedReason);
			caseClosedReasonOrStatusViewController
					.populateCaseClosedReasonTable(new CaseClosedReasonStatusEntityController().viewCaseClosedReason());
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
