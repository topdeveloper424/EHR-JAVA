package com.ets.controller.gui.emrCharting.ros.heLy;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HeLyInputController Class
 *Description: Hely.fxm GUI Controller class
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class HeLyInputController implements Initializable {
	
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton bleedingRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton bruisingRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton anemiaRadio;

	    @FXML
	    private ToggleGroup anemia;

	    @FXML
	    private RadioButton swollenRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton bleedingPlusRadio;

	    @FXML
	    private RadioButton bleedingMinusRadio;

	    @FXML
	    private RadioButton bleedingQuesRadio;

	    @FXML
	    private RadioButton bruisingPlusRadio;

	    @FXML
	    private RadioButton bruisingMinusRadio;

	    @FXML
	    private RadioButton bruisingQuesRadio;

	    @FXML
	    private RadioButton anemiaQuesRadio;

	    @FXML
	    private RadioButton anemiaMinusRadio;

	    @FXML
	    private RadioButton anemiaPlusRadio;

	    @FXML
	    private RadioButton swollenPlusRadio;

	    @FXML
	    private RadioButton swollenMinusRadio;

	    @FXML
	    private RadioButton swollenQuesRadio;

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
				
				genericEMRChartingController.setRosTextArea("\nHEMATOLOGIC / LYMPHATIC: ");
				
				if(deniesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies easy bleeding or bruising, history of anemia, or swollen lymph nodes.");
					
				}
				
				if(bleedingRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Easy bleeding");
					
				}if(bleedingPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims Easy bleeding");
					
				}if(bleedingMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies Easy bleeding");
					
				}if(bleedingQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about Easy bleeding");
					
				}if(bruisingRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("easy bruising");
					
				}if(bruisingPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims easy bruising");
					
				}if(bruisingMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies easy bruising");
					
				}if(bruisingQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about easy bruising");
					
				}if(anemiaRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("history of anemia");
					
				}if(anemiaPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims history of anemia");
					
				}if(anemiaMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies history of anemia");
					
				}if(anemiaQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about history of anemia");
					
				}if(swollenRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Swollen lymph nodes.");
					
				}if(swollenPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims Swollen lymph nodes.");
					
				}if(swollenMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies Swollen lymph nodes.");
					
				}if(swollenQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about Swollen lymph nodes.");
					
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
