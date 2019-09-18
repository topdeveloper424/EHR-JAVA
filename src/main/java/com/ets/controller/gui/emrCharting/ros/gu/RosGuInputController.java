package com.ets.controller.gui.emrCharting.ros.gu;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosGuInputController Class
 *Description: Gu.fxm GUI Controller class
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

public class RosGuInputController implements Initializable {
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton bloodRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton startingUrinationadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton stoppingurinationRadio;

	    @FXML
	    private ToggleGroup stoppingUrination;

	    @FXML
	    private RadioButton extremeUrgeRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton frequentRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton volutaryRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton kidneyRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton painOrBurningRadio;

	    @FXML
	    private ToggleGroup itching;

	    @FXML
	    private RadioButton intercourseRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton bloodPlusRadio;

	    @FXML
	    private RadioButton bloodMinusRadio;

	    @FXML
	    private RadioButton bloodQuesRadio;

	    @FXML
	    private RadioButton frequentQuesRadio;

	    @FXML
	    private RadioButton frequentMinusRadio;

	    @FXML
	    private RadioButton frequentPlusRadio;

	    @FXML
	    private RadioButton kidneyPlusRadio;

	    @FXML
	    private RadioButton kidneyMinusRadio;

	    @FXML
	    private RadioButton kidneyQuesRadio;

	    @FXML
	    private RadioButton intercoursePlusRadio;

	    @FXML
	    private RadioButton intercourseMinusRadio;

	    @FXML
	    private RadioButton intercourseQuesRadio;

	    @FXML
	    private RadioButton startingUrinationPlusRadio;

	    @FXML
	    private RadioButton startingUrinationMinusRadio;

	    @FXML
	    private RadioButton startingUrinationQuesRadio;

	    @FXML
	    private RadioButton stoppingurinationQuesRadio;

	    @FXML
	    private RadioButton stoppingurinationMinusRadio;

	    @FXML
	    private RadioButton stoppingurinationPlusRadio;

	    @FXML
	    private RadioButton volutaryPlusRadio;

	    @FXML
	    private RadioButton volutaryMinusRadio;

	    @FXML
	    private RadioButton volutaryQuesRadio;

	    @FXML
	    private RadioButton painOrBurningPlusRadio;

	    @FXML
	    private RadioButton painOrBurningMinusRadio;

	    @FXML
	    private RadioButton painOrBurningQuesRadio;

	    @FXML
	    private RadioButton pelvicRadio;

	    @FXML
	    private ToggleGroup tinnitus;

	    @FXML
	    private RadioButton premenstrualRadio;

	    @FXML
	    private ToggleGroup vertigo;

	    @FXML
	    private RadioButton pelvicPlusRadio;

	    @FXML
	    private RadioButton premenstrualPlusRadio;

	    @FXML
	    private RadioButton pelvicMinusRadio;

	    @FXML
	    private RadioButton premenstrualMinusRadio;

	    @FXML
	    private RadioButton pelvicQuesRadio;

	    @FXML
	    private RadioButton premenstrualQuesRadio;

	    @FXML
	    private RadioButton serverMenstrualRadio;

	    @FXML
	    private ToggleGroup serve;

	    @FXML
	    private RadioButton varginalDischangeRadio;

	    @FXML
	    private ToggleGroup dischange;

	    @FXML
	    private RadioButton varginalItchingRadio;

	    @FXML
	    private RadioButton femaleManstrualCycleRadio;

	    @FXML
	    private RadioButton femaleSexualRadio;

	    @FXML
	    private RadioButton serverMenstrualPlusRadio;

	    @FXML
	    private RadioButton varginalDischangePlusRadio;

	    @FXML
	    private RadioButton varginalItchingPlusRadio;

	    @FXML
	    private RadioButton serverMenstrualMinusRadio;

	    @FXML
	    private RadioButton varginalDischangeMinusRadio;

	    @FXML
	    private RadioButton varginalItchingMinusRadio;

	    @FXML
	    private RadioButton serverMenstrualQuesRadio;

	    @FXML
	    private RadioButton varginalDischangeQuesRadio;

	    @FXML
	    private RadioButton varginalItchingQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\nGENITOURINARY: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies blood in urine, difficulties urinating, frequency of urination, incontinence, or history of kidney stones. Denies dysmenorrheal, premenstrual symptoms, pelvic pain, dyspareunia, vaginal discharge or vaginal itching.");
				}
				if (bloodRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Blood in urine");
				}
				if (bloodPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Blood in urine");
				}
				if (bloodMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Blood in urine");
				}
				if (bloodQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Blood in urine");
				}
				if (startingUrinationadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty starting urination");
				}
				if (startingUrinationPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty starting urination");
				}
				if (startingUrinationMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty starting urination");
				}
				if (startingUrinationQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty starting urination");
				}
				if (stoppingurinationRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty stopping urination");
				}
				if (stoppingurinationPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty stopping urination");
				}
				if (stoppingurinationMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty stopping urination");
				}
				if (stoppingurinationQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("difficulty stopping urination");
				}
				if (extremeUrgeRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("extreme urge to urinate");
				}
				if (frequentRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Frequent urination, day or night");
				}
				if (frequentPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Frequent urination, day or night");
				}
				if (frequentMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Frequent urination, day or night");
				}
				if (frequentQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea(" Frequent urination, day or night");
				}
				if (volutaryRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("involuntary loss of urine");
				}
				if (volutaryPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("involuntary loss of urine");
				}
				if (volutaryMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("involuntary loss of urine");
				}
				if (volutaryQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("involuntary loss of urine");
				}
				if (kidneyRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of kidney stones");
				}
				if (kidneyPlusRadio.isSelected()) {
					
					genericEMRChartingController.setRosTextArea("history of kidney stones");
				}
				if (kidneyMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of kidney stones");
				}
				if (kidneyQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of kidney stones");
				}
				if (painOrBurningRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pain or burning in urination");
				}
				if (painOrBurningPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pain or burning in urination");
				}
				if (painOrBurningMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pain or burning in urination");
				}
				if (painOrBurningQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pain or burning in urination");
				}
				if (intercourseRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("painful intercourse");
				}
				if (intercoursePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("painful intercourse");
				}
				if (intercourseMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("painful intercourse");
				}
				if (intercourseQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("painful intercourse");
				}
				if (pelvicRadio.isSelected()) {
					
					genericEMRChartingController.setRosTextArea("pelvic pain");
				}
				if (pelvicPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pelvic pain");
				}
				if (pelvicMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pelvic pain");
				}
				if (pelvicQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("pelvic pain");
				}
				if (premenstrualRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("premenstrual symptoms");
				}
				if (premenstrualPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("premenstrual symptoms");
				}
				if (premenstrualMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("premenstrual symptoms");
				}
				if (premenstrualQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("severe menstrual pains");
				}
				if (serverMenstrualRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("severe menstrual pains");
				}
				if (serverMenstrualPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("severe menstrual pains");
				}
				if (serverMenstrualMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("severe menstrual pains");
				}
				if (serverMenstrualQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal discharge");
				}
				if (varginalDischangeRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal discharge");
				}
				if (varginalDischangePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal discharge");
				}
				if (varginalDischangeMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal discharge");
				}
				if (varginalDischangeQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal discharge");
				}
				if (varginalItchingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal itching.");
				}
				if (varginalItchingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal itching.");
				}
				if (varginalItchingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal itching.");
				}
				if (varginalItchingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vaginal itching.");
					
				}if (femaleManstrualCycleRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("");
							
				}if (femaleSexualRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("");
				}
				genericEMRChartingController.saveAllTextArea();
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
