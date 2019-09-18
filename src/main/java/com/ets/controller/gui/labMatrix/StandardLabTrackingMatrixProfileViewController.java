package com.ets.controller.gui.labMatrix;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StandardLabTrackingMatrixProfileController Class
 *Description: StandardLabTrackingMatrixProfile.fxml Controller class
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

public class StandardLabTrackingMatrixProfileViewController implements Initializable {
	@FXML
	private Button close;

	@FXML
	private Button add;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		close.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		add.setOnAction((event) -> {
			try {
				// Load and Display - Select_medical_activity.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				// String formTitle = "Select Medical Activity" ;
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
	}
}