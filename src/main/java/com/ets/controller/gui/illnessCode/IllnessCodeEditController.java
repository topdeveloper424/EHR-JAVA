package com.ets.controller.gui.illnessCode;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditIllnessCodeGUIController Class
 *Description: IllnessCode GUI Controller class
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

public class IllnessCodeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;

	@FXML
	private CheckBox oshaCheckBox;

	@FXML
	private TextField idTextField;

	@FXML
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update IllnessCode Details
		IllnessCode illnessCode = new IllnessCode();
		illnessCode.setId(Integer.parseInt(this.idTextField.getText()));
		illnessCode.setCode(this.codeTextField.getText());
		illnessCode.setDescrp(this.descriptionTextField.getText());
		illnessCode.setWc10Code(this.wcioTextField.getText());
		illnessCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
		illnessCode.setInactive(this.inactiveCheckBox.isSelected());

		new IllnessCodeEntityController().modifyIllnessCode(illnessCode);
		illnessCodeViewController.populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
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

	private IllnessCode illnessCode; // IllnessCode Entity variable

	public void setIllnessCode(IllnessCode illnessCode) {
		this.illnessCode = illnessCode;

		idTextField.setText(Integer.toString(illnessCode.getId()));
		codeTextField.setText(illnessCode.getCode());
		descriptionTextField.setText(illnessCode.getDescrp());
		wcioTextField.setText(illnessCode.getWc10Code());

		if (illnessCode.getAlwaysOshaRecordable() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (illnessCode.getAlwaysOshaRecordable() == true) {
			inactiveCheckBox.setSelected(false);
		}

		if (illnessCode.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (illnessCode.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update IllnessCode Details

			IllnessCode illnessCode = new IllnessCode();

			illnessCode.setId(Integer.parseInt(this.idTextField.getText()));
			illnessCode.setCode(this.codeTextField.getText());
			illnessCode.setDescrp(this.descriptionTextField.getText());
			illnessCode.setWc10Code(this.wcioTextField.getText());
			illnessCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			illnessCode.setInactive(this.inactiveCheckBox.isSelected());

			new IllnessCodeEntityController().modifyIllnessCode(illnessCode);
			illnessCodeViewController.populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

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
