package com.ets.controller.gui.emrCharting.ros.neuro;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroInputController Class
 *Description: neuro.fxm GUI Controller class
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

public class NeuroInputController implements Initializable{
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton blackoutsRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton distortedRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton dizzinessRadio;

	    @FXML
	    private RadioButton doubleRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton headachesRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton balanceRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton coordinationRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton senssationRadio;

	    @FXML
	    private ToggleGroup panic;

	    @FXML
	    private RadioButton motorRadio;

	    @FXML
	    private ToggleGroup redness;

	    @FXML
	    private RadioButton paralysisRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton blackoutsPlusRadio;

	    @FXML
	    private RadioButton blackoutsMinusRadio;

	    @FXML
	    private RadioButton blackoutsQuesRadio;

	    @FXML
	    private RadioButton headachesQuesRadio;

	    @FXML
	    private RadioButton headachesMinusRadio;

	    @FXML
	    private RadioButton headachesPlusRadio;

	    @FXML
	    private RadioButton coordinationPlusRadio;

	    @FXML
	    private RadioButton coordinationMinusRadio;

	    @FXML
	    private RadioButton coordinationQuesRadio;

	    @FXML
	    private RadioButton motorPlusRadio;

	    @FXML
	    private RadioButton motorMinusRadio;

	    @FXML
	    private RadioButton motorQuesRadio;

	    @FXML
	    private RadioButton paralysisPlusRadio;

	    @FXML
	    private RadioButton paralysisMinusRadio;

	    @FXML
	    private RadioButton paralysisQuesRadio;

	    @FXML
	    private RadioButton distortedPlusRadio;

	    @FXML
	    private RadioButton distortedMinusRadio;

	    @FXML
	    private RadioButton distortedQuesRadio;

	    @FXML
	    private RadioButton dizzinessQuesRadio;

	    @FXML
	    private ToggleGroup dimness;

	    @FXML
	    private RadioButton dizzinessMinusRadio;

	    @FXML
	    private RadioButton dizzinessPlusRadio;

	    @FXML
	    private RadioButton doublePlusRadio;

	    @FXML
	    private RadioButton doubleMinusRadio;

	    @FXML
	    private RadioButton doubleQuesRadio;

	    @FXML
	    private RadioButton balancePlusRadio;

	    @FXML
	    private RadioButton balanceMinusRadio;

	    @FXML
	    private RadioButton balanceQuesRadio;

	    @FXML
	    private RadioButton tinglingRadio;

	    @FXML
	    private ToggleGroup thougts;

	    @FXML
	    private RadioButton locationeRadio;

	    @FXML
	    private ToggleGroup violence;

	    @FXML
	    private RadioButton senssationPlusRadio;

	    @FXML
	    private RadioButton senssationMinusRadio;

	    @FXML
	    private RadioButton senssationQuesRadio;

	    @FXML
	    private RadioButton tinglingPlusRadio;

	    @FXML
	    private RadioButton faintingPlusRadio;

	    @FXML
	    private ToggleGroup fainting;

	    @FXML
	    private RadioButton tinglingMinusRadio;

	    @FXML
	    private RadioButton faintingMinusRadio;

	    @FXML
	    private RadioButton tinglingQuesRadio;

	    @FXML
	    private RadioButton faintingQuesRadio;

	    @FXML
	    private RadioButton faintingRadio;

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
				
				genericEMRChartingController.setRosTextArea("\nNEUROLOGICAL: ");
				
				if(deniesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies blackouts, dysarthria, dizziness, double vision, fainting, headaches, loss of balance, coordination or sensation, motor weakness, paralysis, tingling, prickling, numbness or tremors.");
					
				}if(blackoutsRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Blackouts");
					
				}if(blackoutsPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Blackouts");
					
				}if(blackoutsMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Blackouts");
					
				}if(blackoutsQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Blackouts");
					
				}if(distortedRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("distorted speech (dysarthria)");
					
				}if(distortedPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("distorted speech (dysarthria)");
					
				}if(distortedMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("distorted speech (dysarthria)");
					
				}if(distortedQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("distorted speech (dysarthria)");
					
				}if(dizzinessRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("dizziness or vertigo");
					
				}if(dizzinessPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("dizziness or vertigo");
					
				}if(dizzinessMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("dizziness or vertigo");
					
				}if(dizzinessQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("dizziness or vertigo");
					
				}if(doubleRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("double vision");
					
				}if(doublePlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("double vision");
					
				}if(doubleMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("double vision");
					
				}if(doubleQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("double vision");
					
				}if(faintingRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("fainting");
					
				}if(faintingPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("fainting");
					
				}if(faintingMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("fainting");
					
				}if(faintingQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("fainting");
					
				}if(headachesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("headaches");
					
				}if(headachesPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("headaches");
					
				}if(headachesMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("headaches");
					
				}if(headachesQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("headaches");
					
				}if(balanceRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of balance");
					
				}if(balancePlusRadio.isSelected()){
						
					genericEMRChartingController.setRosTextArea("loss of balance");
					
				}if(balanceMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of balance");
					
				}if(balanceQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of balance");
					
				}if(coordinationRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of coordination");
					
				}if(coordinationPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of coordination");
					
				}if(coordinationMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of coordination");
					
				}if(coordinationQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of coordination");
					
				}if(senssationRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of sensation");
					
				}if(senssationPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of sensation");
					
				}if(senssationMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of sensation");
					
				}if(senssationQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("loss of sensation");
					
				}if(motorRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("motor weakness");
					
				}if(motorPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("motor weakness");
					
				}if(motorMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("motor weakness");
					
				}if(motorQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("motor weakness");
					
				}if(paralysisRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("paralysis");
					
				}if(paralysisPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("paralysis");
					
				}if(paralysisMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("paralysis");
					
				}if(paralysisQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("paralysis");
					
				}if(tinglingRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("tingling, prickling or numbness.");
					
				}if(tinglingPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("tingling, prickling or numbness.");
					
				}if(tinglingMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("tingling, prickling or numbness.");
					
				}if(tinglingQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Ttingling, prickling or numbness.");
					
				}if(locationeRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("");
					
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
