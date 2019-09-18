package com.ets.controller.gui.emrCharting.ros.skel;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosSkelInputController Class
 *Description: skel.fxm GUI Controller class
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

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RosSkelInputController implements Initializable {

	@FXML
	private RadioButton deniesRadio;

	@FXML
	private RadioButton arthritisRadio;

	@FXML
	private ToggleGroup appetite;

	@FXML
	private RadioButton backPainRadio;

	@FXML
	private RadioButton historyofFractureRadio;

	@FXML
	private RadioButton joinPainRadio;

	@FXML
	private ToggleGroup Fatigue;

	@FXML
	private RadioButton jointStiffnessRadio;

	@FXML
	private RadioButton weaknessRadio;

	@FXML
	private RadioButton muchinflammationRadio;

	@FXML
	private ToggleGroup Weakness;

	@FXML
	private RadioButton musclePainRadio;

	@FXML
	private ToggleGroup loss;

	@FXML
	private RadioButton nightCrampsRadio;

	@FXML
	private ToggleGroup gain;

	@FXML
	private RadioButton arthritisPlusRadio;

	@FXML
	private RadioButton arthritisMinusRadio;

	@FXML
	private RadioButton arthritisQuesRadio;

	@FXML
	private RadioButton joinPainQuesRadio;

	@FXML
	private RadioButton joinPainMinusRadio;

	@FXML
	private RadioButton joinPainPlusRadio;

	@FXML
	private RadioButton musclePainPlusRadio;

	@FXML
	private RadioButton musclePainMinusRadio;

	@FXML
	private RadioButton musclePainQuesRadio;

	@FXML
	private RadioButton nightCrampsPlusRadio;

	@FXML
	private RadioButton nightCrampsMinusRadio;

	@FXML
	private RadioButton nightCrampsQuesRadio;

	@FXML
	private RadioButton weaknessPlusRadio;

	@FXML
	private RadioButton weaknessMinusRadio;

	@FXML
	private RadioButton weaknessQuesRadio;

	@FXML
	private RadioButton historyofSprainsRadio;

	@FXML
	private RadioButton jointswellingRadio;

	@FXML
	private ToggleGroup Fever1;

	@FXML
	private RadioButton wastingRadio;

	@FXML
	private RadioButton backPainRadioQuesRadio;

	@FXML
	private ToggleGroup appetite1;

	@FXML
	private RadioButton historyofFractureQuesRadio11;

	@FXML
	private ToggleGroup appetite11;

	@FXML
	private RadioButton historyofSprainsQuesRadio;

	@FXML
	private ToggleGroup appetite111;

	@FXML
	private RadioButton backPainRadioMinusRadio;

	@FXML
	private ToggleGroup appetite2;

	@FXML
	private RadioButton historyofFractureMinusRadio11;

	@FXML
	private ToggleGroup appetite21;

	@FXML
	private RadioButton historyofSprainsMinusRadio;

	@FXML
	private ToggleGroup appetite211;

	@FXML
	private RadioButton backPainRadioPlus;

	@FXML
	private ToggleGroup appetite3;

	@FXML
	private RadioButton historyofFracturePlusRadio11;

	@FXML
	private ToggleGroup appetite31;

	@FXML
	private RadioButton historyofSprainsPlusRadio;

	@FXML
	private ToggleGroup appetite311;

	@FXML
	private RadioButton jointStiffnessQuesRadio1;

	@FXML
	private ToggleGroup Fatigue1;

	@FXML
	private RadioButton jointStiffnessMinusRadio;

	@FXML
	private ToggleGroup Fatigue2;

	@FXML
	private RadioButton jointStiffnessPlusRadio1;

	@FXML
	private ToggleGroup Fatigue3;

	@FXML
	private RadioButton muchinflammationQuesRadio;

	@FXML
	private ToggleGroup Fever2;

	@FXML
	private RadioButton muchinflammationMinusRadio;

	@FXML
	private ToggleGroup Fever3;

	@FXML
	private RadioButton muchinflammationPlusRadio;

	@FXML
	private ToggleGroup Fever4;

	@FXML
	private RadioButton wastingQuesRadio;

	@FXML
	private ToggleGroup gain1;

	@FXML
	private RadioButton jointswellingQuesRadio;

	@FXML
	private ToggleGroup gain11;

	@FXML
	private RadioButton wastingMinusRadio;

	@FXML
	private ToggleGroup gain2;

	@FXML
	private RadioButton jointswellingMinusRadio;

	@FXML
	private ToggleGroup gain21;

	@FXML
	private RadioButton wastingPlusRadio;

	@FXML
	private ToggleGroup gain3;

	@FXML
	private RadioButton jointswellingplusRadio;

	@FXML
	private ToggleGroup gain31;

	@FXML
	private Button skipBtn;

	@FXML
	private Button doneBtn;
	private Button button;
	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {
			try {
				genericEMRChartingController.setRosTextArea("\n\nMUSCULOSKELETAL");

				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(
							" Denies arthritis, back pain, joint pain, stiffness or swelling, muscle pain, night cramps, weakness or wasting.");

				}

				if (arthritisRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Athritis.,");

				}
				if (arthritisPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Claims arthritis.,");

				}
				if (arthritisMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Denies arthritis.,");

				}
				if (arthritisQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about arthritis.,");

				}
				if (backPainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Back pain.,");

				}

				if (backPainRadioPlus.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Back pain.,");

				}
				if (backPainRadioMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Back pain.,");

				}

				if (backPainRadioQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about back pain,");

				}

				if (historyofFractureRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" History of fractures.");

				}

				if (historyofFracturePlusRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims fracture.,");

				}
				if (historyofFractureMinusRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies fracture,");

				}

				if (historyofFractureQuesRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about fracture,");

				}

				if (historyofSprainsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" History of sprains.,");

				}

				if (historyofSprainsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims sprain,");

				}
				if (historyofSprainsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies sprain,");

				}

				if (historyofSprainsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about sprain,");

				}

				if (joinPainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Joint pain.");

				}

				if (joinPainPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Joint pain.,");

				}
				if (joinPainMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Joint pain,");

				}

				if (joinPainQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Joint pain,");

				}

				if (jointStiffnessRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Joint stiffness.");

				}

				if (joinPainPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims stiffness,");

				}
				if (joinPainMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies stiffness,");

				}

				if (joinPainQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about stiffness,");

				}

				if (jointswellingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Joint swelling.");

				}

				if (jointswellingplusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Joint swelling,");

				}
				if (jointswellingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Joint swelling,");

				}

				if (jointswellingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Joint swelling,");

				}

				if (muchinflammationRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Muscle inflammation (myositis).");

				}

				if (muchinflammationPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims  Muscle inflammation (myositis),");

				}
				if (muchinflammationMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies  Muscle inflammation (myositis),");

				}

				if (muchinflammationQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about  Muscle inflammation (myositis),");

				}

				if (musclePainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Muscle pain.");

				}

				if (musclePainPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims  Muscle pain,");

				}
				if (musclePainMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies  Muscle pain,");

				}

				if (musclePainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about  Muscle pain,");

				}

				if (nightCrampsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Night cramps.");

				}

				if (nightCrampsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Claims  Night cramps,");

				}
				if (nightCrampsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Denies Night cramps,");

				}

				if (nightCrampsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about Night cramps,");

				}

				if (weaknessRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Weakness.,");

				}

				if (weaknessPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Claims  Weakness.,");

				}
				if (weaknessMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Denies Weakness,");

				}

				if (weaknessQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about Weakness,");

				}

				if (wastingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" wasting.,");

				}

				if (wastingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Claims  wasting.,");

				}
				if (wastingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Denies wasting,");

				}

				if (wastingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about wasting,");

				}
				genericEMRChartingController.saveAllTextArea();
				button.setTextFill(Color.GREEN);
				new FXFormCommonUtilities().closeForm(doneBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		skipBtn.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
