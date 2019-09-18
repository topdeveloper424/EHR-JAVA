package com.ets.controller.gui.emrCharting.hpi.duration;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPiLocationInputController Class
 *Description: Duration.fxml GUI Controller class
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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

public class HPIDurationInputController implements Initializable{
	
	@FXML
    private CheckBox patientUnCertainCheckBox;

    @FXML
    private CheckBox sinceInjuryCheckBox;

    @FXML
    private CheckBox oneHourCheckBox;

    @FXML
    private CheckBox twoHourCheckBox;

    @FXML
    private CheckBox threeHourCheckBox;

    @FXML
    private CheckBox severalHourCheckBox;

    @FXML
    private CheckBox oneDayCheckBox;

    @FXML
    private CheckBox twoDayCheckBox;

    @FXML
    private CheckBox SinceParticularYearCheckBox;

    @FXML
    private CheckBox severalDayCheckBox;

    @FXML
    private CheckBox otherDuarationCheckBox;

    @FXML
    private CheckBox threeDayCheckBox;

    @FXML
    private CheckBox sinceParticularAgeCheckBox;

    @FXML
    private CheckBox sinceParticularDateCheckBox;

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
				genericEMRChartingController.setHpiTextArea("\nDURATION : ");
				if(patientUnCertainCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient is uncertain when the problem began");
				}
				if(sinceInjuryCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Since Injury");
				}
				if(oneHourCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("one hour");
				}
				if(twoHourCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("two hours");
				}
				if(threeHourCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("three hours");
				}
				if(severalHourCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("several hours");
				}
				if(oneDayCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("one day");
				}
				if(twoDayCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("two days");
				}
				if(threeDayCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("three days");
				}
				if(severalDayCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("several days");
				}
				/*if(sinceParticularAgeCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Burning Check Box");
				}
				if(sinceParticularDateCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Burning Check Box");
				}
				if(SinceParticularYearCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Burning Check Box");
				}
				if(otherDuarationCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Burning Check Box");
				}*/
				
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
