package com.ets.controller.gui.medicalGroup;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewMedicalGroupController Class
 *Description: SelectMedicalGroups.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MedicalGroupViewController implements Initializable {

	@FXML
	private Button addBtn;

	@FXML
	private Button closeBtn;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		addBtn.setOnAction((event) -> {
			try {
				// Load Medical Group Details Entry form .

				String formName = formPath.context.getMessage("AddMedicalGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicalGroup", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
