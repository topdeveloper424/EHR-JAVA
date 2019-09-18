package com.ets.controller.gui.emrCharting.pmh.socialHistory;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PMHSmokingInputController Class
 *Description: smokingStatus.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.pmh.PMHAllergyInputController;
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

public class PMHSmokingInputController implements Initializable {

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
	private RadioButton NeverSmokeRadio;

	@FXML
	private RadioButton someDaysRadio;

	@FXML
	private RadioButton smokerStatusRadio;

	@FXML
	private RadioButton formerSmokerRadio;

	@FXML
	private TextField packText;

	@FXML
	private TextField ageText;

	@FXML
	private DatePicker stopdate;

	@FXML
	private RadioButton heavySmokerRadio1;

	@FXML
	private ToggleGroup alcohol1;

	@FXML
	private RadioButton lightDrinkerRadio11;

	@FXML
	private ToggleGroup alcohol11;

	@FXML
	private RadioButton otherTobacco;

	@FXML
	private ToggleGroup alcohol111;

	@FXML
	private RadioButton otherTobaccoRadio;

	@FXML
	private ToggleGroup alcohol1111;

	@FXML
	private TextField numberofYearText;

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
	private RadioButton precepNaRadio;

	@FXML
	private CheckBox offeredCheck;

	@FXML
	private CheckBox acceptedCheck;

	@FXML
	private DatePicker cessationProgDate;

	@FXML
	private TextArea additionaLtEXTaREA;

	private Button button;

	private PMHSocialHistoryInputController pmhSocialHistoryInputController;

	public void setPmhSocialHistoryInputController(PMHSocialHistoryInputController pmhSocialHistoryInputController) {
		this.pmhSocialHistoryInputController = pmhSocialHistoryInputController;

	}
    @FXML
    void onCurrentDayClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onCurrentSomeClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onFormerClicked(MouseEvent event) {
    	setFormarRadio();
    }

    @FXML
    void onHeavyTobaccoClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onLightTobaccoClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onNeverClicked(MouseEvent event) {
    	setRadioInactive();
    }

    @FXML
    void onOtherNonTobaccoClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onOtherTobaccoClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void onstatusUnknownClick(MouseEvent event) {
    	setRadioActive();
    }

    @FXML
    void unknownStatusClick(MouseEvent event) {
    	setRadioInactive();
    }


	FXMLFormPath formPath = new FXMLFormPath();

	 public void setRadioInactive(){
	     
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
	    
	     ageText.setDisable(true);
	     stopdate.setDisable(true);
	     offeredCheck.setDisable(true);
	     acceptedCheck.setDisable(true);
	     precepNaRadio.setDisable(true);
	     offeredCheck.setDisable(true);
	     acceptedCheck.setDisable(true);
			packText.setDisable(true);
			ageText.setDisable(true);
			numberofYearText.setDisable(true);
			stopdate.setDisable(true);
			cessationProgDate.setDisable(true);
	    }
	    
	    public void setRadioActive(){
	     
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
	     precepNaRadio.setDisable(false);
	     ageText.setDisable(false);
	     stopdate.setDisable(false);
	     offeredCheck.setDisable(false);
	     acceptedCheck.setDisable(false);
	     offeredCheck.setDisable(false);
	     acceptedCheck.setDisable(false);

			packText.setDisable(false);
			ageText.setDisable(false);
			numberofYearText.setDisable(false);
			stopdate.setDisable(false);
			cessationProgDate.setDisable(false);
	    
	    }
	    
	    public void setFormarRadio(){
	     
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
	     cessationProgDate.setDisable(true);
	     offeredCheck.setDisable(true);
	     acceptedCheck.setDisable(true);

			packText.setDisable(false);
			ageText.setDisable(false);
			numberofYearText.setDisable(false);
			stopdate.setDisable(false);
	    	    
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		DoneButton.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pmhSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\nSOCIAL HISTORY: ");
			pmhSocialHistoryInputController.str = pmhSocialHitoryStr.toString();

			if (UnknownStatusRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient smoking status is unknown.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			if (NeverSmokeRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("  Patient reports never to have smoked.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}

			if (everyDayRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient is currently a smoker.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (someDaysRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient is currently a smoker.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (smokerStatusRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient is currently a smoker.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (formerSmokerRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient has smoked in the past.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (heavySmokerRadio1.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient is currently a smoker..");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (lightDrinkerRadio11.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient is currently a smoker..");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (otherTobacco.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient is currently a smoker..");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (otherTobaccoRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient reports never to have used tobacco.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (neverToAttemptedRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient claims never to have attempted to quit.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (pastToQuitRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient claims to have tried in the past to quit.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (timesToQuitRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient claims to have tried many times to quit.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (successfulQuitRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient claims to have successfully quit.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (naRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (claimRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient claims to have a problem.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (deniesRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient denies to having a problem.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (considerRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient considers there possibly is a problem.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (addictionRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient has been diagnosed with an addiction.");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (precepNaRadio.isSelected()) {

				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pmhSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" ");
				pmhSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			if (packText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("for " + packText.getText() + " packs per day.");
				pmhSocialHistoryInputController.str = str11.toString();

			}
			if (ageText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("since age " + ageText.getText() + ".");
				pmhSocialHistoryInputController.str = str11.toString();

			}
			if (numberofYearText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("for " + numberofYearText.getText() + " years.");
				pmhSocialHistoryInputController.str = str11.toString();

			}
			if (stopdate.getValue() != null) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("Stopped on  " + stopdate.getValue() + " .");
				pmhSocialHistoryInputController.str = str11.toString();

			}
			
			 
			
			if (cessationProgDate.getValue() != null && offeredCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(pmhSocialHistoryInputController.str);
				str11.append("Smoking cessation program was offered to the patient on " + cessationProgDate.getValue() + " .");
				pmhSocialHistoryInputController.str = str11.toString();

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
