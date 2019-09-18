package com.ets.controller.gui.emrCharting.pmh.socialHistory;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PMHAlcoholInputController Class
 *Description: Alcohol.fxm GUI Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class PMHAlcoholInputController implements Initializable {

	@FXML
	private Button SkipButton;

	@FXML
	private Button DoneButton;

	@FXML
	private RadioButton UnknownStatusRadio;

	@FXML
	private ToggleGroup alcohol;

	@FXML
	private RadioButton everyDayRadio;

	@FXML
	private RadioButton NeverDrankRadio;

	@FXML
	private RadioButton someDaysRadio;

	@FXML
	private RadioButton DrinkerStatusRadio;

	@FXML
	private RadioButton formerDrinkerRadio;

	@FXML
	private TextField drinkText;

	@FXML
	private TextField ageText;

	@FXML
	private DatePicker stopdate;

	@FXML
	private RadioButton neverToAttemptedRadio;

	@FXML
	private ToggleGroup additionalInfo;

	@FXML
	private RadioButton pastToQuitRadio;

	@FXML
	private RadioButton timesToQuitRadio;

	@FXML
	private RadioButton successfulQuitRadio;

	@FXML
	private RadioButton naRadio;

	@FXML
	private RadioButton claimRadio;

	@FXML
	private ToggleGroup perception;

	@FXML
	private RadioButton deniesRadio;

	@FXML
	private RadioButton considerRadio;

	@FXML
	private RadioButton addictionRadio;

	@FXML
	private RadioButton na2Radio;

	@FXML
	private CheckBox offeredCheck;

	@FXML
	private CheckBox acceptedCheck;

	@FXML
	private DatePicker cessationProgDateRadio;

	@FXML
	private TextArea additionaLtEXTaREA;

	private Button button;

	private PMHSocialHistoryInputController pmhSocialHistoryInputController;

	public void setPmhSocialHistoryInputController(PMHSocialHistoryInputController pmhSocialHistoryInputController) {
		this.pmhSocialHistoryInputController = pmhSocialHistoryInputController;

	}

	public void setRadioInactive() {

		neverToAttemptedRadio.setDisable(true);
		pastToQuitRadio.setDisable(true);
		timesToQuitRadio.setDisable(true);
		successfulQuitRadio.setDisable(true);
		naRadio.setDisable(true);
		claimRadio.setDisable(true);
		considerRadio.setDisable(true);
		deniesRadio.setDisable(true);
		addictionRadio.setDisable(true);
		naRadio.setDisable(true);
		drinkText.setDisable(true);
		ageText.setDisable(true);
		stopdate.setDisable(true);
		offeredCheck.setDisable(true);
		acceptedCheck.setDisable(true);
		cessationProgDateRadio.setDisable(true);
		drinkText.setDisable(true);
	}

	public void setRadioActive() {

		neverToAttemptedRadio.setDisable(false);
		pastToQuitRadio.setDisable(false);
		timesToQuitRadio.setDisable(false);
		successfulQuitRadio.setDisable(false);
		naRadio.setDisable(false);
		claimRadio.setDisable(false);
		considerRadio.setDisable(false);
		deniesRadio.setDisable(false);
		addictionRadio.setDisable(false);
		naRadio.setDisable(false);
		drinkText.setDisable(false);
		ageText.setDisable(false);
		stopdate.setDisable(false);
		offeredCheck.setDisable(false);
		acceptedCheck.setDisable(false);
		cessationProgDateRadio.setDisable(false);
		drinkText.setDisable(false);
	}

	public void setFormarRadio() {

		neverToAttemptedRadio.setDisable(true);
		pastToQuitRadio.setDisable(true);
		timesToQuitRadio.setDisable(true);
		successfulQuitRadio.setDisable(true);
		naRadio.setDisable(true);
		claimRadio.setDisable(true);
		considerRadio.setDisable(true);
		deniesRadio.setDisable(true);
		addictionRadio.setDisable(true);
		naRadio.setDisable(true);
		drinkText.setDisable(false);
		ageText.setDisable(false);
		stopdate.setDisable(false);
		offeredCheck.setDisable(true);
		acceptedCheck.setDisable(true);
		cessationProgDateRadio.setDisable(true);
		drinkText.setDisable(true);
	}

	@FXML
	void EveryDayMouseClicked(MouseEvent event) {

		setRadioActive();

	}

	@FXML
	void neverDrunkMouseClicked(MouseEvent event) {

		setRadioInactive();

	}

	@FXML
	void drinkerMouseClicked(MouseEvent event) {

		setRadioActive();

	}

	@FXML
	void formerMouseClicked(MouseEvent event) {

		setFormarRadio();

	}

	@FXML
	void someDaysMouseClicked(MouseEvent event) {

		setRadioActive();

	}

	@FXML
	void unknownStatusMouseClicked(MouseEvent event) {

		setRadioInactive();

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		DoneButton.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pmhSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			pmhSocialHistoryInputController.str = pmhSocialHitoryStr.toString();

			if (UnknownStatusRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient alcohol status is unknown. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (NeverDrankRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient reports never to have used alcohol. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (everyDayRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient currently uses alcohol. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (someDaysRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient currently uses alcohol. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (DrinkerStatusRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient currently uses alcohol. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (formerDrinkerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient has used alcohol in the past. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}

			if (drinkText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("estimating " + drinkText.getText() + " drinks per week. ");
				pmhSocialHistoryInputController.str = str11.toString();

			}

			if (ageText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("since age " + ageText.getText() + ". ");
				pmhSocialHistoryInputController.str = str11.toString();

			}

			if (stopdate.getValue() != null) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("Stopped on " + stopdate.getValue() + ". ");
				pmhSocialHistoryInputController.str = str11.toString();

			}

			if (neverToAttemptedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append(" Patient claims never to have attempted to quit.");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (pastToQuitRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient claims to have tried in the past to quit. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (timesToQuitRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient claims to have tried many times to quit. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (successfulQuitRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient claims to have successfully quit. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (naRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("");
				pmhSocialHistoryInputController.str = str1.toString();

			}

			if (claimRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient claims to have a problem. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (deniesRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient denies having a problem. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (considerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient considers there possibly is a problem. ");
				pmhSocialHistoryInputController.str = str1.toString();

			}
			if (addictionRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Patient has been diagnosed with an addiction.");
				pmhSocialHistoryInputController.str = str1.toString();

			}

			/*
			 * if (offeredCheck.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(pmhSocialHistoryInputController.str);
			 * str1.append(""); pmhSocialHistoryInputController.str =
			 * str1.toString();
			 * 
			 * }if (acceptedCheck.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(pmhSocialHistoryInputController.str); str1.append(
			 * "Mother died from substance abuse ");
			 * pmhSocialHistoryInputController.str = str1.toString();
			 * 
			 * }
			 */if (cessationProgDateRadio.getValue() != null && offeredCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pmhSocialHistoryInputController.str);
				str1.append("Smoking cessation program was offered to the patient on "
						+ cessationProgDateRadio.getValue() + ".");
				pmhSocialHistoryInputController.str = str1.toString();

			}

			++pmhSocialHistoryInputController.formCount;
			pmhSocialHistoryInputController.setSocialHistoryUI();
			new FXFormCommonUtilities().closeForm(DoneButton);

		});

		SkipButton.setOnAction((event) -> {
			try {
				++pmhSocialHistoryInputController.formCount;
				pmhSocialHistoryInputController.setSocialHistoryUI();
				new FXFormCommonUtilities().closeForm(SkipButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
