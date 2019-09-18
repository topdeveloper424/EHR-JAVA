package com.ets.controller.gui.declinationCodes;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.declinationCode.DeclinationCodeEntityController;
import com.ets.model.DeclinationCode;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeEditController Class
 *Description: Edit.fxml Controller class
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

public class DeclinationCodeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField decriptionTextField;

	@FXML
	private TextField idTextField;

	private DeclinationCode declinationCode;

	public void setDeclinationCode(DeclinationCode declinationCode) {
		this.declinationCode = declinationCode;

		idTextField.setText(Integer.toString(declinationCode.getId()));
		codeTextField.setText(declinationCode.getCode());
		decriptionTextField.setText(declinationCode.getDescrp());

		if (declinationCode.getInactive() == true) {

			inactiveCheckBox.setSelected(true);

		} else {

			inactiveCheckBox.setSelected(false);
		}
	}

	private DeclinationCodeViewController declinationCodeViewController;

	public void setDeclinationCodeViewController(DeclinationCodeViewController declinationCodeViewController) {
		this.declinationCodeViewController = declinationCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			try {

				DeclinationCode declinationCode = new DeclinationCode();
				declinationCode.setId(Integer.parseInt(idTextField.getText()));
				declinationCode.setCode(codeTextField.getText());
				declinationCode.setDescrp(decriptionTextField.getText());
				declinationCode.setInactive(inactiveCheckBox.isSelected());

				new DeclinationCodeEntityController().update(declinationCode);
				declinationCodeViewController.refreshDeclinationCode();
				try {

					new FXFormCommonUtilities().closeForm(updateButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

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
