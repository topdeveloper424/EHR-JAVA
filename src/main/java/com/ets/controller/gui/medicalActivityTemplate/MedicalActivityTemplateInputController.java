package com.ets.controller.gui.medicalActivityTemplate;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SetupMedicalActivityController Class
 *Description: SetupMedicalActivity.fxml Controller class
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

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

public class MedicalActivityTemplateInputController implements Initializable {

	@FXML
	private TextField medicalActivityTextField;

	@FXML
	private Button medicalActivityButton;

	@FXML
	private TextField descrioptionTextField;

	@FXML
	private RadioButton universalRadioButton;

	@FXML
	private RadioButton companyRadioButton;

	@FXML
	private RadioButton costRecrdingLevelTotalRadioButton;

	@FXML
	private RadioButton costRecrdingLevelDetailRadioButton;

	@FXML
	private RadioButton costRecrdingLevelBothRadioButton;

	@FXML
	private RadioButton billingChargeLevelTotalRadioButton;

	@FXML
	private RadioButton billingChargeLevelDetailRadioButton;

	@FXML
	private RadioButton billingChargeLevelBothlRadioButton;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button medicalActivityTemplateActionsButton;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		medicalActivityButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalTemplate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalTemplate", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
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
