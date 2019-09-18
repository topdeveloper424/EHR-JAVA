package com.ets.controller.gui.emrCharting.ros.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosRespInputController Class
 *Description: Resp.fxm GUI Controller class
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
import com.mysql.jdbc.BlobFromLocator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RosRespInputController implements Initializable {

    @FXML
    private RadioButton deniesRadio;

    @FXML
    private RadioButton chronicRadio;

    @FXML
    private ToggleGroup blurred;

    @FXML
    private RadioButton bloodRadio;

    @FXML
    private ToggleGroup cataracts;

    @FXML
    private RadioButton coughingUpPhlegmRadio;

    @FXML
    private RadioButton historyOfAsthmaRadio;

    @FXML
    private ToggleGroup excessive;

    @FXML
    private RadioButton historyOfpneumoniaRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton historyOfTuberculosisRadio;

    @FXML
    private ToggleGroup flashing;

    @FXML
    private RadioButton nightSweatsRadio;

    @FXML
    private ToggleGroup glaucoma;

    @FXML
    private RadioButton painUponInhalationRadio;

    @FXML
    private ToggleGroup itching;

    @FXML
    private RadioButton shortnessOfBreathRadio;

    @FXML
    private ToggleGroup redness;

    @FXML
    private RadioButton wheezingRadio;

    @FXML
    private ToggleGroup wear;

    @FXML
    private RadioButton chronicPlusRadio;

    @FXML
    private RadioButton chronicMinusRadio;

    @FXML
    private RadioButton chronicQuesRadio;

    @FXML
    private RadioButton historyOfpneumoniaQuesRadio;

    @FXML
    private RadioButton historyOfpneumoniaMinusRadio;

    @FXML
    private RadioButton historyOfpneumoniaPlusRadio;

    @FXML
    private RadioButton nightSweatsPlusRadio;

    @FXML
    private RadioButton nightSweatsMinusRadio;

    @FXML
    private RadioButton nightSweatsQuesRadio;

    @FXML
    private RadioButton shortnessOfBreathPlusRadio;

    @FXML
    private RadioButton shortnessOfBreathMinusRadio;

    @FXML
    private RadioButton shortnessOfBreathQuesRadio;

    @FXML
    private RadioButton wheezingPlusRadio;

    @FXML
    private RadioButton wheezingMinusRadio;

    @FXML
    private RadioButton wheezingQuesRadio;

    @FXML
    private RadioButton bloodPlusRadio;

    @FXML
    private RadioButton coughingupbloodMinusRadio;

    @FXML
    private RadioButton coughingupbloodQuesRadio;

    @FXML
    private RadioButton coughingUpPhlegmQuesRadio;

    @FXML
    private ToggleGroup dimness;

    @FXML
    private RadioButton coughingUpPhlegmMinusRadio;

    @FXML
    private RadioButton coughingUpPhlegmPlusRadio;

    @FXML
    private RadioButton historyOfAsthmaPlusRadio;

    @FXML
    private RadioButton historyOfAsthmaMinusRadio;

    @FXML
    private RadioButton historyOfAsthmaQuesRadio;

    @FXML
    private RadioButton historyOfTuberculosisPlusRadio;

    @FXML
    private RadioButton historyOfTuberculosisMinusRadio;

    @FXML
    private RadioButton historyOfTuberculosisQuesRadio;

    @FXML
    private RadioButton painUponInhalationPlusRadio;

    @FXML
    private RadioButton painUponInhalationMinusRadio;

    @FXML
    private RadioButton painUponInhalationQuesRadio;

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
				genericEMRChartingController.setRosTextArea("\n\nRESPIRATORY: ");
				
				if(deniesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies coughing, coughing up blood or phlegm, night sweats, shortness of breath, wheezing or history of asthma, pneumonia or tuberculosis.");
				}
				if(chronicRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Cronic cough");
					
				}if(chronicPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims Cronic cough");
					
				}if(chronicMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies Cronic cough");
					
				}
				if(chronicQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about Cronic cough");
					
				}
				if(bloodRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("coughing up blood");
					
				}if(bloodPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims coughing up blood");
					
				}if(coughingupbloodMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies coughing up blood");
					
				}if(coughingupbloodQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about coughing up blood");
					
				}if(coughingUpPhlegmRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("coughing up phlegm");
					
				}if(coughingUpPhlegmPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims coughing up phlegm");
					
				}if(coughingUpPhlegmMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies coughing up phlegm");
					
				}if(coughingUpPhlegmQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about coughing up phlegm");
					
				}if(historyOfAsthmaRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("history of asthma");
					
				}if(historyOfAsthmaPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims history of asthma");
					
				}if(historyOfAsthmaMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies history of asthma");
					
				}if(historyOfAsthmaQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about history of asthma");
					
				}if(historyOfpneumoniaRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("history of pneumonia");
					
				}if(historyOfpneumoniaPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims history of pneumonia");
					
				}if(historyOfpneumoniaMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies history of pneumonia");
					
				}if(historyOfpneumoniaQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about history of pneumonia");
					
				}if(historyOfTuberculosisRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("history of tuberculosis");
					
				}if(historyOfTuberculosisPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims history of tuberculosis");
					
				}if(historyOfTuberculosisMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies history of tuberculosis");
					
				}if(historyOfTuberculosisQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about history of tuberculosis");
					
				}if(nightSweatsRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("night sweats");
					
				}if(nightSweatsPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims night sweats");
					
				}if(nightSweatsMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies night sweats");
					
				}if(nightSweatsQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about night sweats");
					
				}if(painUponInhalationRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("pain upon inhalation");
					
				}
				  if(shortnessOfBreathRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("shortness of breath");
					
				}if(shortnessOfBreathPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims shortness of breath");
					
				}if(shortnessOfBreathMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies shortness of breath");
					
				}if(shortnessOfBreathQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about shortness of breath");
					
				}if(wheezingRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("wheezing");
					
				}if(wheezingPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Claims wheezing");
					
				}if(wheezingMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies wheezing");
					
				}if(wheezingQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Unsure about wheezing");
					
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
