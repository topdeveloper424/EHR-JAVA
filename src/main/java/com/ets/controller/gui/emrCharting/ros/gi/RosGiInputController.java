package com.ets.controller.gui.emrCharting.ros.gi;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosGiInputController Class
 *Description: Gi.fxm GUI Controller class
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

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RosGiInputController implements Initializable {
	

    @FXML
    private RadioButton deniesRadio;

    @FXML
    private RadioButton abdominaPainRadio;

    @FXML
    private ToggleGroup blurred;

    @FXML
    private RadioButton bloodInStoolsRadio;

    @FXML
    private ToggleGroup cataracts;

    @FXML
    private RadioButton blackStoolsRadio;

    @FXML
    private RadioButton changeInFrequencyRadio;

    @FXML
    private ToggleGroup excessive;

    @FXML
    private RadioButton changeInStoolSizeRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton constipationRadio;

    @FXML
    private ToggleGroup flashing;

    @FXML
    private RadioButton diarrheaRadio;

    @FXML
    private ToggleGroup glaucoma;

    @FXML
    private RadioButton difficultySwallowingRadio;

    @FXML
    private ToggleGroup itching;

    @FXML
    private RadioButton foodIntoleranceRadio;

    @FXML
    private ToggleGroup redness;

    @FXML
    private RadioButton heartBurnRadio;

    @FXML
    private ToggleGroup wear;

    @FXML
    private RadioButton abdominaPainPlusRadio;

    @FXML
    private RadioButton abdominaPainMinusRadio;

    @FXML
    private RadioButton abdominaPainQuesRadio;

    @FXML
    private RadioButton changeInStoolSizeQuesRadio;

    @FXML
    private RadioButton changeInStoolSizeMinusRadio;

    @FXML
    private RadioButton changeInStoolSizePlusRadio;

    @FXML
    private RadioButton diarrheaPlusRadio;

    @FXML
    private RadioButton diarrheaMinusRadio;

    @FXML
    private RadioButton diarrheaQuesRadio;

    @FXML
    private RadioButton foodIntolerancePlusRadio;

    @FXML
    private RadioButton foodIntoleranceMinusRadio;

    @FXML
    private RadioButton foodIntoleranceQuesRadio;

    @FXML
    private RadioButton heartBurnPlusRadio;

    @FXML
    private RadioButton heartBurnMinusRadio;

    @FXML
    private RadioButton heartBurnQuesRadio;

    @FXML
    private RadioButton bloodInStoolsPlusRadio;

    @FXML
    private RadioButton bloodInStoolsMinusRadio;

    @FXML
    private RadioButton bloodInStoolsQuesRadio;

    @FXML
    private RadioButton blackStoolsQuesRadio;

    @FXML
    private ToggleGroup dimness;

    @FXML
    private RadioButton blackStoolsMinusRadio;

    @FXML
    private RadioButton blackStoolsPlusRadio;

    @FXML
    private RadioButton changeInFrequencyPlusRadio;

    @FXML
    private RadioButton changeInFrequencyMinusRadio;

    @FXML
    private RadioButton changeInFrequencyQuesRadio;

    @FXML
    private RadioButton constipationPlusRadio;

    @FXML
    private RadioButton constipationMinusRadio;

    @FXML
    private RadioButton constipationQuesRadio;

    @FXML
    private RadioButton difficultySwallowingPlusRadio;

    @FXML
    private RadioButton difficultySwallowingMinusRadio;

    @FXML
    private RadioButton difficultySwallowingQuesRadio;

    @FXML
    private RadioButton nauseaQuesRadio1;

    @FXML
    private ToggleGroup wear1;

    @FXML
    private RadioButton nauseaMinusRadio1;

    @FXML
    private ToggleGroup wear2;

    @FXML
    private RadioButton nauseaPlusRadio1;

    @FXML
    private ToggleGroup wear3;

    @FXML
    private RadioButton nauseaRadio1;

    @FXML
    private ToggleGroup wear4;

    @FXML
    private RadioButton vomitingQuesRadio11;

    @FXML
    private ToggleGroup wear11;

    @FXML
    private RadioButton vomitingMinusRadio11;

    @FXML
    private ToggleGroup wear21;

    @FXML
    private RadioButton vomitingPlusRadio11;

    @FXML
    private ToggleGroup wear31;

    @FXML
    private RadioButton vomitingRadio11;

    @FXML
    private ToggleGroup wear41;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;

	
    private Button button;
	
    private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {
			try {
				genericEMRChartingController.setRosTextArea("\nGASTROINTESTINAL: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies abdominal pain, blood in stools or black stools, change in bowel frequency or stool size, constipation, diarrhea, difficulty swallowing, food intolerance, heartburn, nausea, vomiting or need for antacids.");

				}

				if (abdominaPainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Abdominal pain");

				}

				if (abdominaPainPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Abdominal pain");

				}

				if (abdominaPainMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Abdominal pain");

				}

				if (abdominaPainQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Abdominal pain");

				}
				
				if (bloodInStoolsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("blood in stools");

				}

				if (bloodInStoolsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims blood in stools");

				}

				if (blackStoolsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies blood in stools");

				}

				if (bloodInStoolsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about blood in stools");

				}

				if (blackStoolsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("black stools");

				}

				if (blackStoolsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims black stools");

				}
				if (blackStoolsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies black stools");

				}
				if (blackStoolsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about black stools");

				}
				if (changeInFrequencyRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("change in bowel frequency");
					
				}
				if (changeInFrequencyPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims change in bowel frequency");

				}
				if (changeInFrequencyMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies change in bowel frequency");

				}
				if (changeInFrequencyQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about change in bowel frequency");

				}
				if (changeInStoolSizeRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("change in stool size");

				}
				if (changeInStoolSizePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims change in stool size");

				}
				if (changeInStoolSizeMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies change in stool size");

				}
				if (changeInStoolSizeQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about change in stool size");

				}
				if (constipationRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("constipation");

				}
				if (constipationPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims constipation");

				}
				if (constipationMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies constipation");

				}
				if (constipationQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about constipation");

				}
				if (diarrheaRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("diarrhea");

				}
				if (diarrheaPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims diarrhea");

				}
				if (diarrheaMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies diarrhea");

				}
				if (diarrheaQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about diarrhea");

				}
				if (difficultySwallowingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty swallowing");

				}
				if (difficultySwallowingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims difficulty swallowing");

				}
				if (difficultySwallowingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies difficulty swallowing");

				}
				if (difficultySwallowingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about difficulty swallowing");

				}
				if (foodIntoleranceRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("food intolerance");

				}
				if (foodIntolerancePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims food intolerance");

				}
				if (foodIntoleranceMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies food intolerance");

				}
				if (foodIntoleranceQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about food intolerance");

				}
				if (heartBurnRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("heartburn");

				}
				if (heartBurnPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims heartburn");

				}
				if (heartBurnMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies heartburn");

				}
				if (heartBurnQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about heartburn");

				}
				if (nauseaRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("nausea");

				}
				if (nauseaPlusRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims nausea");

				}
				if (nauseaMinusRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nausea");

				}
				if (nauseaQuesRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about nausea");

				}
				if (vomitingRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("vomiting");

				}
				if (vomitingPlusRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims vomiting");

				}
				if (vomitingMinusRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies vomiting");

				}
				if (vomitingQuesRadio11.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Unsure about vomiting");

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
				
				new FXFormCommonUtilities().closeForm( skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
