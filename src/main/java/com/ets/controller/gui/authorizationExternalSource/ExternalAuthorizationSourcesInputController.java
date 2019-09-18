package com.ets.controller.gui.authorizationExternalSource;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterExternalAuthorizationSourcesnewController Class
 *Description: EnterExternalAuthorizationSources(new).fxml Controller class
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

import javafx.fxml.Initializable;

public class ExternalAuthorizationSourcesInputController implements Initializable {

	@FXML
	private Button cancel;
	@FXML
	private Button ok;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		cancel.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(cancel);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
