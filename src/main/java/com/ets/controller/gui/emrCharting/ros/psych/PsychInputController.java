package com.ets.controller.gui.emrCharting.ros.psych;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PsychInputController Class
 *Description: psych.fxm GUI Controller class
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

public class PsychInputController implements Initializable {
	
	 	@FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton anxietyRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton depressionRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton rememberingThingRadio;

	    @FXML
	    private RadioButton thinkingRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton hallucinationsRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton insomniaRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton irritabilityRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton panicRadio;

	    @FXML
	    private ToggleGroup panic;

	    @FXML
	    private RadioButton priorRadio;

	    @FXML
	    private ToggleGroup redness;

	    @FXML
	    private RadioButton attemptsRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton anxietyPlusRadio;

	    @FXML
	    private RadioButton anxietyMinusRadio;

	    @FXML
	    private RadioButton anxietyQuesRadio;

	    @FXML
	    private RadioButton hallucinationsQuesRadio;

	    @FXML
	    private RadioButton hallucinationsMinusRadio;

	    @FXML
	    private RadioButton hallucinationsPlusRadio;

	    @FXML
	    private RadioButton irritabilityPlusRadio;

	    @FXML
	    private RadioButton irritabilityMinusRadio;

	    @FXML
	    private RadioButton irritabilityQuesRadio;

	    @FXML
	    private RadioButton priorPlusRadio;

	    @FXML
	    private RadioButton priorMinusRadio;

	    @FXML
	    private RadioButton priorQuesRadio;

	    @FXML
	    private RadioButton attemptsPlusRadio;

	    @FXML
	    private RadioButton attemptsMinusRadio;

	    @FXML
	    private RadioButton attemptsQuesRadio;

	    @FXML
	    private RadioButton depressionPlusRadio;

	    @FXML
	    private RadioButton depressionMinusRadio;

	    @FXML
	    private RadioButton depressionQuesRadio;

	    @FXML
	    private RadioButton rememberingThingQuesRadio;

	    @FXML
	    private ToggleGroup dimness;

	    @FXML
	    private RadioButton rememberingThingMinusRadio;

	    @FXML
	    private RadioButton rememberingThingPlusRadio;

	    @FXML
	    private RadioButton thinkingPlusRadio;

	    @FXML
	    private RadioButton thinkingMinusRadio;

	    @FXML
	    private RadioButton thinkingQuesRadio;

	    @FXML
	    private RadioButton insomniaPlusRadio;

	    @FXML
	    private RadioButton insomniaMinusRadio;

	    @FXML
	    private RadioButton insomniaQuesRadio;

	    @FXML
	    private RadioButton thougtsRadio;

	    @FXML
	    private ToggleGroup thougts;

	    @FXML
	    private RadioButton violenceRadio;

	    @FXML
	    private ToggleGroup violence;

	    @FXML
	    private RadioButton panicPlusRadio;

	    @FXML
	    private RadioButton panicMinusRadio;

	    @FXML
	    private RadioButton panicQuesRadio;

	    @FXML
	    private RadioButton thougtsPlusRadio;

	    @FXML
	    private RadioButton violencePlusRadio;

	    @FXML
	    private RadioButton thougtsMinusRadio;

	    @FXML
	    private RadioButton violenceMinusRadio;

	    @FXML
	    private RadioButton thougtsQuesRadio;

	    @FXML
	    private RadioButton violenceQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\nPSYCHIATRIC: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies anxiety, depression, difficulty remembering things or thinking, hallucinations, insomnia, irritability, panic, suicidal thought or history of psych hospitalizations or suicide attempts.");
					
				}if (anxietyRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Anxiety");
					
				}if (anxietyPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Anxiety");
					
				}if (anxietyMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Anxiety");
					
				}if (anxietyQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Anxiety");
					
				}if (depressionRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("depression");
					
				}if (depressionPlusRadio.isSelected()) {
					 
					genericEMRChartingController.setRosTextArea("Claims depression");
					
				}if (depressionMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies depression");
					
				}if (depressionQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about depression");
					
				}if (rememberingThingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty remembering things");
					
				}if (rememberingThingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims difficulty remembering things");
					
				}if (rememberingThingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies difficulty remembering things");
					
				}if (rememberingThingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about difficulty remembering things");
					
				}if (thinkingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty thinking");
					
				}if (thinkingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims difficulty thinking");
					
				}if (thinkingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies difficulty thinking");
					
				}if (thinkingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about difficulty thinking");
					
				}if (hallucinationsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("hallucinations");
					
				}if (hallucinationsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims hallucinations");
							
				}if (hallucinationsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies hallucinations");
					
				}if (hallucinationsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about hallucinations");
					
				}if (insomniaRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("insomnia");
					
				}if (insomniaPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims insomnia");
					
				}if (insomniaMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies insomnia");
					
				}if (insomniaQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about insomnia");
					
				}if (irritabilityRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("irritability");
					
				}if (irritabilityPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims irritability");
					
				}if (irritabilityMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies irritability");
					
				}if (irritabilityQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about irritability");
					
				}if (panicRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("panic symptoms");
					
				}if (panicPlusRadio.isSelected()) {
					
					genericEMRChartingController.setRosTextArea("Claims panic symptoms");
					
				}if (panicMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies panic symptoms");
					
				}if (panicQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about panic symptoms");
					
				}if (priorRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("prior psych hospitalizations");
					
				}if (priorPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims prior psych hospitalizations");
					
				}if (priorMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies prior psych hospitalizations");
					
				}if (priorQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about prior psych hospitalizations");
					
				}if (attemptsRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("suicide attempts");
					
				}if (attemptsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims suicide attempts");
					
				}if (attemptsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies suicide attempts");
					
				}if (attemptsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about suicide attempts");
					
				}if (thougtsRadio.isSelected()) {
				
					genericEMRChartingController.setRosTextArea("suicidal thoughts");
					
				}if (thougtsPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims suicidal thoughts");
					
				}if (thougtsMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies suicidal thoughts");
					
				}if (thougtsQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about suicidal thoughts");
					
				}if (violenceRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("violence toward others.");
					
				}if (violencePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims violence toward others.");
					
				}if (violenceMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies violence toward others.");
					
				}if (violenceQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about violence toward others.");
					
				}
				
				button.setTextFill(Color.GREEN);
				new FXFormCommonUtilities().closeForm( doneBtn);
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
