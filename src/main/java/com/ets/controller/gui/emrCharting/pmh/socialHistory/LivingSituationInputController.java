package com.ets.controller.gui.emrCharting.pmh.socialHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LivingSituationInputController Class
 *Description: LivingSituation.fxml GUI Controller class
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
public class LivingSituationInputController implements Initializable {

	@FXML
	private RadioButton patientAlone;

	@FXML
	private ToggleGroup level;

	@FXML
	private RadioButton PatientWithParent;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private RadioButton patientwithPartner;

	@FXML
	private RadioButton patientWithspoueChildren;

	@FXML
	private RadioButton patientWithSpouse;

	@FXML
	private RadioButton patientAsSingleParent;

	@FXML
	private RadioButton patientWithRoomate;

	@FXML
	private RadioButton CurrentApartment;

	@FXML
	private ToggleGroup current;

	@FXML
	private RadioButton currentPurchased;

	@FXML
	private RadioButton currentShelter;

	@FXML
	private RadioButton currentCondominium;

	@FXML
	private RadioButton currentRentedHouse;

	@FXML
	private RadioButton currentHomelessEniironment;

	private PMHSocialHistoryInputController pMHSocialHistoryInputController;

	public void setpMHSocialHistoryInputController(PMHSocialHistoryInputController pMHSocialHistoryInputController) {
		this.pMHSocialHistoryInputController = pMHSocialHistoryInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\nSOCIAL HISTORY: ");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr.toString();

			if (patientAlone.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives alone ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (patientwithPartner.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with partner ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (patientWithSpouse.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with spouse ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (patientAsSingleParent.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives as a single parent ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (PatientWithParent.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with  parent ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (patientWithRoomate.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with roomate ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			if (patientWithspoueChildren.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with spouse and children ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (patientWithspoueChildren.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient lives with spouse and children ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			if (CurrentApartment.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" in a apartment.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (currentPurchased.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" in a purchased house.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (currentShelter.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" in a shelter.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (currentCondominium.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" in a condominium.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (currentRentedHouse.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" in a rented house.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			if (currentHomelessEniironment.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("  in a homeless environment.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			++pMHSocialHistoryInputController.formCount;
			pMHSocialHistoryInputController.setSocialHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++pMHSocialHistoryInputController.formCount;
				pMHSocialHistoryInputController.setSocialHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
