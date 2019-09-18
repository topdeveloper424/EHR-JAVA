package com.ets.controller.gui.authorizationTemplate;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client
 * Company File Creation Date: 09-02-2016 Initial Version: 0.01 Module Name:
 * Parameter Definition: Type object of
 * EnterAuthorizationRulesTemplateController Class Description:
 * EnterAuthorizationRulesTemplate.fxml Controller class Copyright 2016 @Eclipse
 * TechnoConsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 */

public class AuthorizationRulesTemplateInputController implements Initializable {

	@FXML
	private Button add;

	@FXML
	private Button cancel;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		add.setOnAction((event) -> {
			try {

				try {

					String formName = formPath.context.getMessage("AddAuthorizationTemplateGroup", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddAuthorizationTemplateGroup", null,
							Locale.US);
					formPath.closeApplicationContext();

					new FXFormCommonUtilities().displayForm(formName, formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancel.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(cancel);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
