package com.ets.controller.gui.emrCharting.ros.skin;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinInputController Class
 *Description: skin.fxm GUI Controller class
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

public class SkinInputController implements Initializable{
	
	 	@FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton abnormalGrowthhairRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton bleedingRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton changeinColorRadio;

	    @FXML
	    private ToggleGroup stoppingUrination;

	    @FXML
	    private RadioButton easyBruisingRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton itchingRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton historyOfSkinCancerRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton historyOfSeverSunBurnRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton nailBrittlenessRadio;

	    @FXML
	    private ToggleGroup itching;

	    @FXML
	    private RadioButton nailPittingRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton abnormalGrowthPlusRadio;

	    @FXML
	    private RadioButton abnormalGrowthMinusRadio;

	    @FXML
	    private RadioButton abnormalGrowthQuesRadio;

	    @FXML
	    private RadioButton itchingQuesRadio;

	    @FXML
	    private RadioButton itchingMinusRadio;

	    @FXML
	    private RadioButton itchingPlusRadio;

	    @FXML
	    private RadioButton historyOfSeverSunBurnPlusRadio;

	    @FXML
	    private RadioButton historyOfSeverSunBurnMinusRadio;

	    @FXML
	    private RadioButton historyOfSeverSunBurnQuesRadio;

	    @FXML
	    private RadioButton nailPittingPlusRadio;

	    @FXML
	    private RadioButton nailPittingMinusRadio;

	    @FXML
	    private RadioButton nailPittingQuesRadio;

	    @FXML
	    private RadioButton bleedingRadioPlusRadio;

	    @FXML
	    private RadioButton bleedingRadioMinusRadio;

	    @FXML
	    private RadioButton bleedingRadioQuesRadio;

	    @FXML
	    private RadioButton changeinColorQuesRadio;

	    @FXML
	    private RadioButton changeinColorMinusRadio;

	    @FXML
	    private RadioButton changeinColorPlusRadio;

	    @FXML
	    private RadioButton historyOfSkinCancerPlusRadio;

	    @FXML
	    private RadioButton historyOfSkinCancerMinusRadio;

	    @FXML
	    private RadioButton historyOfSkinCancerQuesRadio;

	    @FXML
	    private RadioButton nailBrittlenessPlusRadio;

	    @FXML
	    private RadioButton nailBrittlenessMinusRadio;

	    @FXML
	    private RadioButton nailBrittlenessQuesRadio;

	    @FXML
	    private RadioButton rashRadio;

	    @FXML
	    private ToggleGroup tinnitus;

	    @FXML
	    private RadioButton saclingRadio;

	    @FXML
	    private ToggleGroup vertigo;

	    @FXML
	    private RadioButton rashPlusRadio;

	    @FXML
	    private RadioButton scalingPlusRadio;

	    @FXML
	    private RadioButton rashMinusRadio;

	    @FXML
	    private RadioButton scalingMinusRadio;

	    @FXML
	    private RadioButton rashQuesRadio;

	    @FXML
	    private RadioButton scalingQuesRadio;

	    @FXML
	    private RadioButton nailCurvatureRadio;

	    @FXML
	    private RadioButton nailCurvaturePlusRadio;

	    @FXML
	    private RadioButton nailCurvatureMinusRadio;

	    @FXML
	    private RadioButton nailCurvatureQuesRadio;

	    @FXML
	    private RadioButton easyBruisingRQuesRadio1;

	    @FXML
	    private ToggleGroup eye1;

	    @FXML
	    private RadioButton easyBruisingMinusRadio1;

	    @FXML
	    private ToggleGroup eye2;

	    @FXML
	    private RadioButton easyBruisingPlusRadio1;

	    @FXML
	    private ToggleGroup eye3;

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
				genericEMRChartingController.setRosTextArea("\nSKIN: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies abnormal hair growth, bleeding, change in color or size of moles, easy bruising, itching, hair loss, rash, or history of skin cancer or severe sunburn.");

				}
				if (abnormalGrowthhairRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Abnormal growth of hair");

				}
				if (abnormalGrowthPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims Abnormal growth of hair");

				}
				if (abnormalGrowthMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Abnormal growth of hair");

				}
				if (abnormalGrowthQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Abnormal growth of hair");

				}
				if (bleedingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("bleeding");

				}
				if (bleedingRadioPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims bleeding");

				}
				if (bleedingRadioMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies bleeding");

				}
				if (bleedingRadioQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about bleeding");

				}
				if (changeinColorRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("change in color or size of moles");

				}
				if (changeinColorPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims change in color or size of moles");

				}
				if (changeinColorMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies change in color or size of moles");

				}
				if (changeinColorQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about change in color or size of moles");

				}
				if (easyBruisingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("easy bruising");

				}
				if (easyBruisingPlusRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims easy bruising");

				}
				if (easyBruisingMinusRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies easy bruising");

				}
				if (easyBruisingRQuesRadio1.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about easy bruising");

				}
				if (itchingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("itching");

				}
				if (itchingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims itching");

				}
				if (itchingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies itching");

				}
				if (itchingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about itching");

				}
				if (historyOfSkinCancerRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of skin cancer");

				}
				if (historyOfSkinCancerPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of skin cancer");

				}
				if (historyOfSkinCancerMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of skin cancer");

				}
				if (historyOfSkinCancerQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about history of skin cancer");

				}
				if (historyOfSeverSunBurnRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of severe sunburn");

				}
				if (historyOfSeverSunBurnPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of severe sunburn");

				}
				if (historyOfSeverSunBurnMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of severe sunburn");

				}
				if (historyOfSeverSunBurnQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about history of severe sunburn");

				}
				if (nailBrittlenessRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("nail brittleness");

				}
				if (nailBrittlenessPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims nail brittleness");

				}
				if (nailBrittlenessMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nail brittleness");

				}
				if (nailBrittlenessQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about nail brittleness");

				}
				if (nailCurvatureRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("nail curvature changes");

				}
				if (nailCurvaturePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims nail curvature changes");

				}
				if (nailCurvatureMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nail curvature changes");

				}
				if (nailCurvatureQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about nail curvature changes");

				}
				if (nailPittingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("nail pitting or ridging");

				}
				if (nailPittingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims nail pitting or ridging");

				}
				if (nailPittingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nail pitting or ridging");

				}
				if (nailPittingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about nail pitting or ridging");

				}
				if (rashRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("rash");

				}
				if (rashPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims rash");

				}
				if (rashMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies rash");

				}
				if (rashQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about rash");

				}
				if (saclingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("scaling");

				}
				if (scalingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims scaling");

				}
				if (scalingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies scaling");

				}
				if (scalingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about scaling");

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
