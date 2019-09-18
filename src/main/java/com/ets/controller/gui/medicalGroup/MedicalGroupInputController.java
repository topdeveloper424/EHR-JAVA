package com.ets.controller.gui.medicalGroup;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalGroupGUIController Class
 *Description: EnterMedicalGroup.fxml Controller class
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

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MedicalGroupInputController implements Initializable {

	@FXML
	private Button closeBtn;

	@Override
	public void initialize(URL location, ResourceBundle reources) {

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
