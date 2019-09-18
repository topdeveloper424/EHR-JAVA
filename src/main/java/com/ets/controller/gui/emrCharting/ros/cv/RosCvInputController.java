package com.ets.controller.gui.emrCharting.ros.cv;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosCvInputController Class
 *Description: Cv.fxm GUI Controller class
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

public class RosCvInputController implements Initializable {
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton chestPainRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton ekgRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton stressTestRadio;

	    @FXML
	    private RadioButton heartMurmurRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton hipertensionRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton rheeumaticFeverRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton valveDiessesRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton heartBeatRadio;

	    @FXML
	    private ToggleGroup itching;

	    @FXML
	    private RadioButton raceingRadio;

	    @FXML
	    private ToggleGroup redness;

	    @FXML
	    private RadioButton layingFlatRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton chestPainPlusRadio;

	    @FXML
	    private RadioButton chestPainMinusRadio;

	    @FXML
	    private RadioButton chestPainQuesRadio;

	    @FXML
	    private RadioButton hipertensionQuesRadio;

	    @FXML
	    private RadioButton hipertensionMinusRadio;

	    @FXML
	    private RadioButton hipertensionPlusRadio;

	    @FXML
	    private RadioButton valveDiessesPlusRadio;

	    @FXML
	    private RadioButton valveDiessesMinusRadio;

	    @FXML
	    private RadioButton valveDiessesQuesRadio;

	    @FXML
	    private RadioButton raceingPlusRadio;

	    @FXML
	    private RadioButton raceingMinusRadio;

	    @FXML
	    private RadioButton raceingQuesRadio;

	    @FXML
	    private RadioButton layingFlatPlusRadio;

	    @FXML
	    private RadioButton layingFlatMinusRadio;

	    @FXML
	    private RadioButton layingFlatQuesRadio;

	    @FXML
	    private RadioButton ekgPlusRadio;

	    @FXML
	    private RadioButton ekgMinusRadio;

	    @FXML
	    private RadioButton ekgQuesRadio;

	    @FXML
	    private RadioButton stressTestQuesRadio;

	    @FXML
	    private ToggleGroup dimness;

	    @FXML
	    private RadioButton stressTestMinusRadio;

	    @FXML
	    private RadioButton stressTestPlusRadio;

	    @FXML
	    private RadioButton heartMurmurPlusRadio;

	    @FXML
	    private RadioButton heartMurmurMinusRadio;

	    @FXML
	    private RadioButton heartMurmurQuesRadio;

	    @FXML
	    private RadioButton rheeumaticFeverPlusRadio;

	    @FXML
	    private RadioButton rheeumaticFeverMinusRadio;

	    @FXML
	    private RadioButton rheeumaticFeverQuesRadio;

	    @FXML
	    private RadioButton heartBeatPlusRadio;

	    @FXML
	    private RadioButton heartBeatMinusRadio;

	    @FXML
	    private RadioButton heartBeatQuesRadio;

	    @FXML
	    private RadioButton excertionRadio;

	    @FXML
	    private ToggleGroup tinnitus;

	    @FXML
	    private RadioButton swellingRadio;

	    @FXML
	    private ToggleGroup vertigo;

	    @FXML
	    private RadioButton excertionPlusRadio;

	    @FXML
	    private RadioButton swellingPlusRadio;

	    @FXML
	    private RadioButton excertionMinusRadio;

	    @FXML
	    private RadioButton swellingMinusRadio;

	    @FXML
	    private RadioButton excertionQuesRadio;

	    @FXML
	    private RadioButton swellingQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\n\nCARDIOVASCULAR: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies chest pain or pressure, edema, excessive sweating, heart racing, palpitations, shortness of breath or history of heart murmur, hypertension, rheumatic fever or valve disease.");
				}

				if (chestPainRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Chest pain or tightness");
				}
				if (chestPainPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims chest pain or tightness");
				}
				if (chestPainMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies chest pain or tightness");
				}

				if (chestPainQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about chest pain or tightness");
				}
				
				if (ekgRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of abnormal EKG");
				}

				if (ekgPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of abnormal EKG");
				}

				if (ekgMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of abnormal EKG");
				}

				if (ekgQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of abnormal EKG");
				}
				if (stressTestRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of abnormal stress test");
				}
				if (stressTestPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of abnormal stress test");
				}
				if (stressTestMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of abnormal stress test");
				}
				if (stressTestQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of abnormal stress test");
				}
				if (heartMurmurRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of heart murmur");
				}
				if (heartMurmurPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of heart murmur");
				}
				 
				if (heartMurmurMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of heart murmur");
				}
				if (heartMurmurQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of heart murmur");
				}
				if (hipertensionRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of hypertension");
				}
				if (hipertensionPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of hypertension");
				}
				if (hipertensionMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of hypertension");
				}
				if (hipertensionQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of hypertension");
				}
				if (rheeumaticFeverRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of rheumatic fever");
				}
				if (rheeumaticFeverPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of rheumatic fever");
				}
				if (rheeumaticFeverMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of rheumatic fever");
				}
				if (rheeumaticFeverQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of rheumatic fever");
				}
				
				if (valveDiessesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("history of valve disease");
				}
				if (valveDiessesPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims history of valve disease");
				}
				if (valveDiessesMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies history of valve disease");
				}
				if (valveDiessesQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about history of valve disease");
				}
				if (heartBeatRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("irregular heart beat (palpitations)");
				}
				if (heartBeatPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims irregular heart beat (palpitations)");
				}
				if (heartBeatMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies irregular heart beat (palpitations)");
				}
				if (heartBeatQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about irregular heart beat (palpitations)");
				}
				if (raceingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("racing heart");
				}
				if (raceingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims racing heart");
				}
				if (raceingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies racing heart");
				}
				if (raceingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about racing heart");
				}
				if (layingFlatRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("shortness of breath lying flat");
				}
				if (layingFlatPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims shortness of breath lying flat");
				}
				
				if (layingFlatMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies shortness of breath lying flat");
				}
				if (layingFlatQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about shortness of breath lying flat");
				}
				if (excertionRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("shortness of breath on exertion");
				}
				if (excertionPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims shortness of breath on exertion");
				}
				if (excertionMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies shortness of breath on exertion");
				}
				if (excertionQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about shortness of breath on exertion");
				}
				if (swellingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("swelling in extremities (edema)");
				}
				if (swellingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("claims swelling in extremities (edema)");
				}
				if (swellingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies swelling in extremities (edema)");
				}
				if (swellingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("unsure about swelling in extremities (edema)");
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
