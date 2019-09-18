package com.ets.controller.gui.emrCharting.ros.contitutional;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosConstitutionalInputController Class
 *Description: constitutional.fxm GUI Controller class
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

public class RosConstitutionalInputController implements Initializable {
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton changesRadio;

	    @FXML
	    private ToggleGroup appetite;

	    @FXML
	    private RadioButton chillsRadio;

	    @FXML
	    private RadioButton dayTimeRadio;

	    @FXML
	    private RadioButton fatiguRadio;

	    @FXML
	    private ToggleGroup Fatigue;

	    @FXML
	    private RadioButton difficultyRadio;

	    @FXML
	    private RadioButton feverRadio;

	    @FXML
	    private ToggleGroup Fever;

	    @FXML
	    private RadioButton nightRadio;

	    @FXML
	    private RadioButton weeknessRadio;

	    @FXML
	    private ToggleGroup Weakness;

	    @FXML
	    private RadioButton lossRadio;

	    @FXML
	    private ToggleGroup loss;

	    @FXML
	    private RadioButton gainRadio;

	    @FXML
	    private ToggleGroup gain;

	    @FXML
	    private RadioButton changesPlusRadio;

	    @FXML
	    private RadioButton changesMinusRadio;

	    @FXML
	    private RadioButton changesQuesRadio;

	    @FXML
	    private RadioButton fatiguQuesRadio;

	    @FXML
	    private RadioButton fatiguMinusRadio;

	    @FXML
	    private RadioButton fatiguPlusRadio;

	    @FXML
	    private RadioButton feverPlusRadio;

	    @FXML
	    private RadioButton feverMinusRadio;

	    @FXML
	    private RadioButton feverQuesRadio;

	    @FXML
	    private RadioButton weeknessPlusRadio;

	    @FXML
	    private RadioButton weeknessMinusRadio;

	    @FXML
	    private RadioButton weeknessQuesRadio;

	    @FXML
	    private RadioButton lossPlusRadio;

	    @FXML
	    private RadioButton lossMinusRadio;

	    @FXML
	    private RadioButton lossQuesRadio;

	    @FXML
	    private RadioButton gainPlusRadio;

	    @FXML
	    private RadioButton gainMinusRadio;

	    @FXML
	    private RadioButton gainQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\n\nCONSTITUTIONAL: ");
					
				if(deniesRadio.isSelected()){
						genericEMRChartingController.setRosTextArea("Denies change in appetite, fatigue, fever, weakness, weight gain or weight loss.");
					}
				if(changesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("Change in appetite");
				}
				if(changesPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("Claims change in appetite");
				}
				if(changesMinusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("Denies change in appetite");
				}
				if(changesQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("Unsure about change in appetite");
				}
				
				if(chillsRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("chills");
				}
				if(dayTimeRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("daytime");
				}
				if(fatiguRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("fatigue");
				}
				if(fatiguPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("claims fatigue,");
				}
				if(fatiguMinusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("denies fatigue");
				}
				if(fatiguQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("unsure about fatigue");
				}
				
				if(difficultyRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("difficulty sleeping");
				}
				if(feverRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("fever");
				}
				
				if(feverPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("claims fever");
				}
				if(feverMinusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("denies fever");
				}
				if(feverQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("unsure about fever");
				}
				
				if(nightRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("night sweats");
				}
				if(weeknessRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("weakness");
				}
				if(weeknessPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("claims weakness");
				}
				if(weeknessMinusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("denies weakness");
				}
				if(weeknessQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("unsure about weakness");
				}
				if(lossRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("weight loss");
				}
				if(lossPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("claims weight loss");
				}
				if(lossPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("enies weight loss");
				}
				if(lossQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("unsure about weight loss");
				}
				if(gainRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("weight gain");
				}
				if(gainPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("claims weight gain");
				}
				if(gainPlusRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("denies weight gain");
				}
				if(gainQuesRadio.isSelected()){
					genericEMRChartingController.setRosTextArea("unsure about weight gain");
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
