package com.ets.controller.gui.emrCharting.exam.eye;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditDistrictGUIController Class
 *Description: eyeIntraocularPressure GUI Controller class
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

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class EyeIntrocularPressureInputController implements Initializable{
	
	 	@FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox tonometryNormalCkeckBox;

	    @FXML
	    private CheckBox leftEyePressureNormalCkeckBox;

	    @FXML
	    private CheckBox rightEyePressureNormalCkeckBox;

	    @FXML
	    private TextField leftEyeMeasurementText;

	    @FXML
	    private TextField rightEyeMeasurementText;

	    @FXML
	    private RadioButton touchTonometryRadio;

	    @FXML
	    private ToggleGroup tonometry;

	    @FXML
	    private RadioButton indentionTonometryRadio;

	    @FXML
	    private RadioButton applinationTonometryRadio;

	    @FXML
	    private RadioButton puffTonometryRadio;

	    @FXML
	    private RadioButton notTestedTonometryRadio;

	    @FXML
	    private RadioButton leftEyePressureNormalRadio;

	    @FXML
	    private RadioButton leftEyePressureLowRadio;

	    @FXML
	    private RadioButton leftEyePressureHighRadio;

	    @FXML
	    private RadioButton leftEyePressureNotTestedRadio;

	    @FXML
	    private RadioButton rightEyePressureNormalRadio;

	    @FXML
	    private RadioButton rightEyePressureLowRadio;

	    @FXML
	    private RadioButton rightEyePressureHighRadio;

	    @FXML
	    private RadioButton rightEyePressureNotTestedRadio;
	    
	    private ExamEyeInputController examEyeInputController;

	    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
			this.examEyeInputController = examEyeInputController;
		}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\n: ");
			examEyeInputController.str = examComp.toString();
			
						
			
			if (tonometryNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Intraocular pressures measured normal in both eyes.");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				
					
					
					if (touchTonometryRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Intraocular pressures were tested with touch tonometry.");
						examEyeInputController.str = str1.toString();
						
					}if (indentionTonometryRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Intraocular pressures were tested w/indentation tonometry.");
						examEyeInputController.str = str1.toString();
						
					}if (applinationTonometryRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Intraocular pressures were tested w/applination tonometry.");
						examEyeInputController.str = str1.toString();
						
					}if (puffTonometryRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Intraocular pressures were tested with puff tonometry.");
						examEyeInputController.str = str1.toString();
						
					}if (notTestedTonometryRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Intraocular pressures were not tested");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();
					
					
				}
				
			
			
			
			
			
			if(leftEyePressureNormalCkeckBox.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Left eye normal pressure.");
				examEyeInputController.str = str12.toString();
				
			}else{
				
			
					if (leftEyePressureNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Testing revealed: left eye normal pressure .");
						examEyeInputController.str = str1.toString();
						
					}if (leftEyePressureHighRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Testing revealed: left eye high pressure. ");
						examEyeInputController.str = str1.toString();
						
					}if (leftEyePressureLowRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Testing revealed: left eye low pressure. ");
						examEyeInputController.str = str1.toString();
						
					}if (leftEyePressureNotTestedRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Testing revealed: left eye not tested.");
						examEyeInputController.str = str1.toString();
						
					}
					
					
					
					
				}
		
			
			
			
			
			
			if (leftEyeMeasurementText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append(leftEyeMeasurementText.getText());
				examEyeInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			if(rightEyePressureNormalCkeckBox.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Right eye normal pressure.");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				
				
					
					if (rightEyePressureNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Right eye normal pressure.");
						examEyeInputController.str = str1.toString();
						
					}if (rightEyePressureHighRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Right eye high pressure.");
						examEyeInputController.str = str1.toString();
						
					}if (rightEyePressureLowRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Right eye low pressure.");
						examEyeInputController.str = str1.toString();
						
					}if (rightEyePressureNotTestedRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Right eye not tested.");
						examEyeInputController.str = str1.toString();
						
					}
									
					
					
					
				}
				
		
			
			
			
			if (rightEyeMeasurementText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append(rightEyeMeasurementText.getText());
				examEyeInputController.str = str1.toString();
				
			}
			
			
			
			++examEyeInputController.formCount;	
			examEyeInputController.setEyeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEyeInputController.formCount;	
				examEyeInputController.setEyeUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
