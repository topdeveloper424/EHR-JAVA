package com.ets.controller.gui.medicalActivityTemplate;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SetupMedicalAcitivityTemplateController Class
 *Description: SetupMedicalAcitivityTemplate.fxml Controller class
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

import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MedicalAcitivityTemplateViewController implements Initializable {

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button printButton;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("AddMedicalTemplate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicalTemplate", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}