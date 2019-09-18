package com.ets.controller.gui.emrCharting.exam.neuro.cordinationBalance;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroCordinationBalanceInputController Class
 *Description: neuroExamCordinationBalance GUI Controller class
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
public class NeuroCordinationBalanceInputController implements Initializable {


    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox rombergNormal;

    @FXML
    private CheckBox tandemNormal;

    @FXML
    private RadioButton rombergNegativeRadio;

    @FXML
    private ToggleGroup romberg;

    @FXML
    private RadioButton rombergPositiveRadio;

    @FXML
    private RadioButton rombergGrosslyPositiveRadio;

    @FXML
    private RadioButton tandemNormalRadio;

    @FXML
    private ToggleGroup tandem;

    @FXML
    private RadioButton tandemDecreasedRadio;

    @FXML
    private RadioButton tandemGrosslyDecreasedRadio;

    @FXML
    private CheckBox fingerRightNormal;

    @FXML
    private RadioButton fingerLefttNormalRadio;

    @FXML
    private ToggleGroup left;

    @FXML
    private RadioButton fingerLeftDecreasedRadio;

    @FXML
    private RadioButton fingerLeftpasRadio;

    @FXML
    private RadioButton FingerRightNormal;

    @FXML
    private ToggleGroup right;

    @FXML
    private RadioButton FingerRightDecreasedRadio;

    @FXML
    private RadioButton FingerRightPastRadio;

    @FXML
    private CheckBox heelNormal;

    @FXML
    private RadioButton heelBilateralNormalRadio;

    @FXML
    private ToggleGroup heel;

    @FXML
    private RadioButton heelDecreasedLeftRadio;

    @FXML
    private RadioButton heelDecreasedBilaterallyRadio;

    @FXML
    private RadioButton heelDecreasedRightRadio;
    @FXML
    private RadioButton heelNormalRightRadio;
    @FXML
    private RadioButton heelNormalLeftRadio;

    @FXML
    private CheckBox dysdiadoNormal;

    @FXML
    private RadioButton dysdiadoNotNoted;

    @FXML
    private ToggleGroup dydo;

    @FXML
    private RadioButton dysdiadoNoted;

	private NeuroInputController neuroInputController;
	
	
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGICAL");
			neuroInputController.str = skelComp.toString();

			if (rombergNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Romberg negative.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (rombergGrosslyPositiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg grossly positive.");
					neuroInputController.str = str1.toString();

				}	if (rombergNegativeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg  negative.");
					neuroInputController.str = str1.toString();

				}	if (rombergPositiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg positive,");
					neuroInputController.str = str1.toString();

				}	
				
				
			}
			
			
			if (tandemNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Tandem gait normal.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (tandemDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg  decreased.");
					neuroInputController.str = str1.toString();

				}	if (tandemGrosslyDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Tandem gait grossly decreased.");
					neuroInputController.str = str1.toString();

				}	if (tandemNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Tandem gait normal.");
					neuroInputController.str = str1.toString();

				}	
				
				
			}
			
			if (fingerRightNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Finger to nose: left normal,right normal .");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (fingerLeftDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left decrease.");
					neuroInputController.str = str1.toString();

				}	if (fingerLeftpasRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left paspointing.");
					neuroInputController.str = str1.toString();

				}	if (fingerLefttNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left normal.");
					neuroInputController.str = str1.toString();

				}	
				if (FingerRightDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right decreased.");
					neuroInputController.str = str1.toString();
				}
				if (FingerRightPastRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right paspointing.");
					neuroInputController.str = str1.toString();
				}
				if (FingerRightNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right normal.");
					neuroInputController.str = str1.toString();
				}
				
			}
			
			
			
			
			if(heelNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Coordination and balance: Heel / knee / shin normal bilaterally.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (heelBilateralNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin normal bilaterally.");
					neuroInputController.str = str1.toString();

				}	if (heelDecreasedBilaterallyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin decreased bilaterally");
					neuroInputController.str = str1.toString();

				}	if (heelDecreasedLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin: decreased left.");
					neuroInputController.str = str1.toString();

				}	
				if (heelDecreasedRightRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: decreased right.");
					neuroInputController.str = str1.toString();
				}
				if (heelNormalLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: normal left.");
					neuroInputController.str = str1.toString();
				}
				if (heelNormalRightRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: normal right.");
					neuroInputController.str = str1.toString();
				}
				
			}
			if (dysdiadoNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Dysdiadochokinesis not noted.");
				neuroInputController.str = str1.toString();
			}else{
				
				if (dysdiadoNotNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis not noted.");
					neuroInputController.str = str1.toString();
				}	
				if (dysdiadoNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis noted.");
					neuroInputController.str = str1.toString();
				}	
				
				
			}
			
			StringBuilder str1 = new StringBuilder(neuroInputController.str);
			str1.append(".");
			neuroInputController.str = str1.toString();
			//genericEMRChartingController.saveAllTextArea();
		++neuroInputController.formCount;	
		neuroInputController.setNeuroUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++neuroInputController.formCount;	
				neuroInputController.setNeuroUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
