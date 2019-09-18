package com.ets.controller.gui.emrCharting.pmh.socialHistory;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SocialHistoryBriefInputController Class
 *Description: socialHistoryBrief.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SocialHistoryBriefInputController implements Initializable {

	@FXML
	private RadioButton exciseYesRadio;

	@FXML
	private ToggleGroup excise;

	@FXML
	private RadioButton exciseNoRadio;

	@FXML
	private RadioButton drugYesRadio;

	@FXML
	private ToggleGroup drug;

	@FXML
	private RadioButton drugNoRadio;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	private Button button;

	private PMHSocialHistoryInputController pmhSocialHistoryInputController;

	public void setPmhSocialHistoryInputController(PMHSocialHistoryInputController pmhSocialHistoryInputController) {
		this.pmhSocialHistoryInputController = pmhSocialHistoryInputController;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pmhSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			pmhSocialHistoryInputController.str = pmhSocialHitoryStr.toString();

			if (exciseYesRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Exercise: Patient states: yes");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (exciseNoRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Exercise: Patient states: No");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (drugYesRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Recreational Drug Use: Patient states: Yes.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (drugNoRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Recreational Drug Use: Patient states: No.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			++pmhSocialHistoryInputController.formCount;
			pmhSocialHistoryInputController.setSocialHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++pmhSocialHistoryInputController.formCount;
				pmhSocialHistoryInputController.setSocialHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
