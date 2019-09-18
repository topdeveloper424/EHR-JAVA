package com.ets.controller.gui.illnessCode;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IllnessCodeGUIController Class
 *Description: EnterIllnessCode.fxml Controller class
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
import com.ets.controller.entity.illnessCode.IllnessCodeEntityController;
import com.ets.model.IllnessCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class IllnessCodeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

	@FXML
	private CheckBox oshaCheckBox;

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert Illness Code
		IllnessCode illnessCode = new IllnessCode();
		illnessCode.setCode(this.codeTextField.getText());
		illnessCode.setDescrp(this.descriptionTextField.getText());
		illnessCode.setWc10Code(this.wcioTextField.getText());
		illnessCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
		illnessCode.setInactive(this.inactiveCheckBox.isSelected());

		new IllnessCodeEntityController().saveIllnessCode(illnessCode);
		illnessCodeViewController.populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Centralised Form cancel
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private IllnessCodeViewController illnessCodeViewController;

	public void setIllnessCodeViewController(IllnessCodeViewController illnessCodeViewController) {
		this.illnessCodeViewController = illnessCodeViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Insert Illness Code

			IllnessCode illnessCode = new IllnessCode();
			illnessCode.setCode(this.codeTextField.getText());
			illnessCode.setDescrp(this.descriptionTextField.getText());
			illnessCode.setWc10Code(this.wcioTextField.getText());
			illnessCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			illnessCode.setInactive(this.inactiveCheckBox.isSelected());

			new IllnessCodeEntityController().saveIllnessCode(illnessCode);
			illnessCodeViewController.populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {

			// Centralised Form cancel

			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
