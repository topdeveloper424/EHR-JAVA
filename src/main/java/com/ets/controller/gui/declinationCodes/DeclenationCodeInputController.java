package com.ets.controller.gui.declinationCodes;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.declinationCode.DeclinationCodeEntityController;
import com.ets.model.DeclinationCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclenationCodeInputController Class
 *Description: Enter.fxml Controller class
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

public class DeclenationCodeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField decriptionTextField;

	private DeclinationCodeViewController declinationCodeViewController;

	public void setDeclinationCodeViewController(DeclinationCodeViewController declinationCodeViewController) {
		this.declinationCodeViewController = declinationCodeViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {
			try {
				DeclinationCode declinationCode = new DeclinationCode();
				declinationCode.setCode(codeTextField.getText());
				declinationCode.setDescrp(decriptionTextField.getText());
				declinationCode.setInactive(inactiveCheckBox.isSelected());

				new DeclinationCodeEntityController().save(declinationCode);
				declinationCodeViewController.refreshDeclinationCode();

				try {

					new FXFormCommonUtilities().closeForm(okButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

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
