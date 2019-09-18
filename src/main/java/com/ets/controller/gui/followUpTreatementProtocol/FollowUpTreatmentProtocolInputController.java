package com.ets.controller.gui.followUpTreatementProtocol;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterFollowupTreatmentProtocolnewController Class
 *Description: EnterFollowupTreatmentProtocolnew.fxml Controller class
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
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FollowUpTreatmentProtocolInputController implements Initializable {

	@FXML
	private Button ok;

	@FXML
	private Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		close.setOnAction((event) -> {
			try {
				// Load and Display - Save_record5.fxml Form
				String formName = "/com/ets/demo/view/profileAndProtocol/Save_record5.fxml";
				String formTitle = "Save Record";
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
	}

}
