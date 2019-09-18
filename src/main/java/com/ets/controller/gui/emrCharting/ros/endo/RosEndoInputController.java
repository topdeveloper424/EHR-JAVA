package com.ets.controller.gui.emrCharting.ros.endo;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosEndoInputController Class
 *Description: EndocrineSystem.fxm GUI Controller class
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


public class RosEndoInputController implements Initializable {
	
	@FXML
    private RadioButton deniesRadio;

    @FXML
    private RadioButton hairRadio;

    @FXML
    private ToggleGroup blurred;

    @FXML
    private RadioButton skinRadio;

    @FXML
    private ToggleGroup cataracts;

    @FXML
    private RadioButton thrustRadio;

    @FXML
    private ToggleGroup dimness;

    @FXML
    private RadioButton excessiveRadio;

    @FXML
    private ToggleGroup excessive;

    @FXML
    private RadioButton fatigueRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton coldRadio;

    @FXML
    private ToggleGroup flashing;

    @FXML
    private RadioButton heatRadio;

    @FXML
    private ToggleGroup glaucoma;

    @FXML
    private RadioButton neckRadio;

    @FXML
    private ToggleGroup itching;

    @FXML
    private RadioButton weeknessRadio;

    @FXML
    private ToggleGroup redness;

    @FXML
    private RadioButton hairPlusRadio;

    @FXML
    private RadioButton hairMinusRadio;

    @FXML
    private RadioButton hairQuesRadio;

    @FXML
    private RadioButton fatigueQuesRadio;

    @FXML
    private RadioButton fatigueMinusRadio;

    @FXML
    private RadioButton fatiguePlusRadio;

    @FXML
    private RadioButton heatPlusRadio;

    @FXML
    private RadioButton heatMinusRadio;

    @FXML
    private RadioButton heatQuesRadio;

    @FXML
    private RadioButton weeknessPlusRadio;

    @FXML
    private RadioButton weeknessMinusRadio;

    @FXML
    private RadioButton weeknessQuesRadio;

    @FXML
    private RadioButton skinPlusRadio;

    @FXML
    private RadioButton skinMinusRadio;

    @FXML
    private RadioButton skinQuesRadio;

    @FXML
    private RadioButton excessivePlusRadio;

    @FXML
    private RadioButton excessiveMinusRadio;

    @FXML
    private RadioButton excessiveQuesRadio;

    @FXML
    private RadioButton coldPlusRadio;

    @FXML
    private RadioButton coldMinusRadio;

    @FXML
    private RadioButton coldQuesRadio;

    @FXML
    private RadioButton neckPlusRadio;

    @FXML
    private RadioButton neckMinusRadio;

    @FXML
    private RadioButton neckQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\nENDOCRINE SYSTEM: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies cold or heat intolerance, fatigue, neck swelling, polydipsia or polyuria.");
				}
				if (hairRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Changes in hair");
				}
				if (hairPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Changes in hair");
				}
				if (hairMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Changes in hair");
				}
				if (hairQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Changes in hair");
				}
				if (skinRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims hanges in skin");
				} 
				if (skinPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies changes in skin");
				}
				if (skinMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about changes in skin");
				}
				if (skinQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("changes in skin");
				}
				if (thrustRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("excessive thirst");
				}
				if (excessiveRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("excessive urination");
				}
				if (excessivePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims excessive urination");
				}
				if (excessiveMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies excessive urination");
				}
				if (excessiveQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about excessive urination");
				}
				if (fatigueRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("fatigue");
				}
				if (fatiguePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims fatigue");
				}
				if (fatigueMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies fatigue");
				}
				if (fatigueQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about fatigue");
				}
				if (coldRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("intolerance to cold");
				}
				if (coldPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims intolerance to cold");
				}
				if (coldMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies intolerance to cold");
				}
				if (coldQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about intolerance to cold");
				}
				if (heatRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("intolerance to heat");
				}
				if (heatPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims intolerance to heat");
				}
				if (heatMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies intolerance to heat");
				}
				if (heatQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about intolerance to heat");
				}
				if (neckRadio.isSelected()) {
					
					genericEMRChartingController.setRosTextArea("neck swellingo r goiter");
				}
				if (neckPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims neck swelling or goiter");
				}
				if (neckMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies neck swelling or goiter");
				}
				if (neckQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about neck swelling or goiter");
				}
				if (weeknessRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("weakness");
				}
				if (weeknessPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims weakness");
				}
				if (weeknessMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies weakness");
				}
				if (weeknessQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about weakness");
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
