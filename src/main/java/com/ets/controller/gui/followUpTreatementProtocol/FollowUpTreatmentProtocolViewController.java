package com.ets.controller.gui.followUpTreatementProtocol;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectFollowupTreatmentProtocolController Class
 *Description: SelectFollowupTreatmentProtocol.fxml Controller class
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

public class FollowUpTreatmentProtocolViewController implements Initializable {
	@FXML
	private Button close;

	@FXML
	private Button add;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLFormPath formPath = new FXMLFormPath();

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
				String formName = formPath.context.getMessage("AddFolloupTreatmentProtocals", null, Locale.US);

				String formTitle = formPath.context.getMessage("Title.AddFolloupTreatmentProtocals", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}