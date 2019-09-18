package com.ets.controller.gui.emrCharting.hpi.quality;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPIQualityInputController Class
 *Description: Quality.fxml GUI Controller class
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

public class HPIQualityInputController implements Initializable {
	
	 @FXML
	    private CheckBox anxietyCheckBox;

	    @FXML
	    private CheckBox burningCheckBox;

	    @FXML
	    private CheckBox consultCheckBox;

	    @FXML
	    private CheckBox dullCheckBox;

	    @FXML
	    private CheckBox intermittentCheckBox;

	    @FXML
	    private CheckBox moveingArroundCheckBox;

	    @FXML
	    private CheckBox pinNeedlesCheckBox;

	    @FXML
	    private CheckBox pressingCheckBox;

	    @FXML
	    private CheckBox tinglingCheckBox;

	    @FXML
	    private CheckBox rediatingCheckBox;

	    @FXML
	    private CheckBox throbbingCheckBox;

	    @FXML
	    private CheckBox sharpCheckBox;

	    @FXML
	    private CheckBox stabbingCheckBox;

	    @FXML
	    private CheckBox stationaryCheckBox;

	    @FXML
	    private CheckBox otherQualityCheckBox;

	    @FXML
	    private CheckBox vagueCheckBox;

	    @FXML
	    private CheckBox unEasyCheckBox;

	    @FXML
	    private Button doneBtn;
	    
	    @FXML
	    private Button skipBtn;
	    
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
				genericEMRChartingController.setHpiTextArea("\nQUALITY : ");
				if(anxietyCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Aching");
				}
				if(burningCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Burning");
				}
				if(consultCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Constant");
				}
				
				if(dullCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Dull");
				}
				
				if(intermittentCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Intermittent");
				}
				
				if(pinNeedlesCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Pins And Needles");
				}
				
				if(pressingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Pressing");
				}
				
				if(tinglingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Tingling");
				}
				
				if(rediatingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Radiating");
				}
				
				if(throbbingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Throbbing");
				}
				
				if(moveingArroundCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Moving Around");
				}
				if(sharpCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Sharp");
				}
				if(stabbingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Stabbing");
				}
				if(stationaryCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Stationary");
				}
				if(otherQualityCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("OtherQuality");
				}
				if(vagueCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Vague");
				}
				if(unEasyCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Un Easy");
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
