package com.ets.controller.gui.emrCharting.ros.eye;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosEyeInputController Class
 *Description: Eyes.fxm GUI Controller class
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

public class RosEyeInputController implements Initializable {
	
	@FXML
    private RadioButton deniesRadio;

    @FXML
    private RadioButton blurredRadio;

    @FXML
    private ToggleGroup blurred;

    @FXML
    private RadioButton cateractsRadio;

    @FXML
    private ToggleGroup cataracts;

    @FXML
    private RadioButton dimnessRadio;

    @FXML
    private RadioButton excessiveRadio;

    @FXML
    private ToggleGroup excessive;

    @FXML
    private RadioButton eysRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton flashingRadio;

    @FXML
    private ToggleGroup flashing;

    @FXML
    private RadioButton glaucomaRadio;

    @FXML
    private ToggleGroup glaucoma;

    @FXML
    private RadioButton itchingRadio;

    @FXML
    private ToggleGroup itching;

    @FXML
    private RadioButton rednessRadio;

    @FXML
    private ToggleGroup redness;

    @FXML
    private RadioButton wearsRadio;

    @FXML
    private ToggleGroup wear;

    @FXML
    private RadioButton blurredPlusRadio;

    @FXML
    private RadioButton blurredMinusRadio;

    @FXML
    private RadioButton blurredQuesRadio;

    @FXML
    private RadioButton eyeQuesRadio;

    @FXML
    private RadioButton eyeMinusRadio;

    @FXML
    private RadioButton eyePlusRadio;

    @FXML
    private RadioButton glaucomaPlusRadio;

    @FXML
    private RadioButton glaucomaMinusRadio;

    @FXML
    private RadioButton glaucomaQuesRadio;

    @FXML
    private RadioButton rednessPlusRadio;

    @FXML
    private RadioButton rednessMinusRadio;

    @FXML
    private RadioButton rednessQuesRadio;

    @FXML
    private RadioButton wearsPlusRadio;

    @FXML
    private RadioButton wearsMinusRadio;

    @FXML
    private RadioButton wearsQuesRadio;

    @FXML
    private RadioButton cateractsPlusRadio;

    @FXML
    private RadioButton cateractsMinusRadio;

    @FXML
    private RadioButton cateractsQuesRadio;

    @FXML
    private RadioButton dimnessQuesRadio;

    @FXML
    private ToggleGroup dimness;

    @FXML
    private RadioButton dimnessMinusRadio;

    @FXML
    private RadioButton dimnessPlusRadio;

    @FXML
    private RadioButton excessivePlusRadio;

    @FXML
    private RadioButton excessiveMinusRadio;

    @FXML
    private RadioButton excessiveQuesRadio;

    @FXML
    private RadioButton flashingPlusRadio;

    @FXML
    private RadioButton flashingMinusRadio;

    @FXML
    private RadioButton flashingQuesRadio;

    @FXML
    private RadioButton itchingPlusRadio;

    @FXML
    private RadioButton itchingMinusRadio;

    @FXML
    private RadioButton itchingQuesRadio;

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
				genericEMRChartingController.setResultTextArea("EYES: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies blurred vision, cataracts, dimness, excessive tearing, flashing lights, itching, pain, redness or history of cataracts or glaucoma.");

				}
				if (blurredRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Blurred vision");

				}
				if (blurredPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  Blurred vision");

				}
				if (blurredMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies Blurred vision");

				}
				if (blurredQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about Blurred vision");

				}
				
				if (cateractsRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("cataracts");

				}
				if (cateractsPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea(" claims  cataracts");

				}
				if (cateractsMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies cataracts");

				}
				if (cateractsQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about cataracts");

				}
				if (dimnessRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("dimness");

				}
				if (dimnessPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  dimness");

				}
				if (dimnessMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies dimness");

				}
				if (dimnessQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about dimness");
					
				}
				if (excessiveRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("excessive tearing");

				}
				if (excessivePlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  excessive tearing");

				}
				if (excessiveMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies excessive tearing");

				}
				if (excessiveQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about excessive tearing");

				}
				if (eyeQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("eye pain");

				}

				if (eyePlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  eye pain");

				}
				if (eyeMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies eye pain");

				}
				if (eyeQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about eye pain");

				}
				if (flashingRadio.isSelected()) {
					
					genericEMRChartingController.setResultTextArea("flashing lights");

				}
				if (flashingPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  flashing lights");

				}
				if (flashingMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies flashing lights");

				}
				if (flashingQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about flashing lights");

				}
				if (glaucomaRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("glaucoma");

				}
				if (glaucomaPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims  glaucoma");

				}

				if (glaucomaMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies glaucoma");

				}
				if (glaucomaQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about glaucoma");

				}
				
				if (itchingRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("itching");

				}
				if (itchingPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims itching");

				}
				if (itchingMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies itching");

				}
				if (itchingQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about itching");

				}
				if (rednessRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("redness");

				}
				if (rednessPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims redness");

				}
				if (rednessMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies redness");

				}
				if (rednessQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about redness");

				}

				if (wearsRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Wear glasses or contacts.");

				}
				if (wearsPlusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("claims Wear glasses or contacts.");

				}
				if (wearsMinusRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Denies Wear glasses or contacts.");

				}
				if (wearsQuesRadio.isSelected()) {

					genericEMRChartingController.setResultTextArea("Unsure about Wear glasses or contacts.");

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
