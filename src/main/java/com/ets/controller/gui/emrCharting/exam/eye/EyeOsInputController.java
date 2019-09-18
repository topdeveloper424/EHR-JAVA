package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 8-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeOsInputController Class
 *Description: EyeOs GUI Controller class
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
public class EyeOsInputController implements Initializable {
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox pterygiumCheck;

    @FXML
    private CheckBox foreignCheck;

    @FXML
    private CheckBox dischargeCheck;

    @FXML
    private CheckBox subconjunctivalCheck;

    @FXML
    private CheckBox inflammationCheck;

    @FXML
    private CheckBox pinguiculaCheck;

    @FXML
    private RadioButton intactRadio;

    @FXML
    private ToggleGroup eomi;

    @FXML
    private RadioButton notIntactRadio;

    @FXML
    private RadioButton perrlaNormalRadio;

    @FXML
    private ToggleGroup perrla;

    @FXML
    private RadioButton perrlaAbnormalRadio;

    @FXML
    private RadioButton bulbarNormalRadio;

    @FXML
    private ToggleGroup bulbar;

    @FXML
    private RadioButton palpebralNormalRadio;

    @FXML
    private ToggleGroup palpebral;

    @FXML
    private RadioButton lidsNormalRadio;

    @FXML
    private ToggleGroup lids;

    @FXML
    private RadioButton glandsNormalRadio;

    @FXML
    private ToggleGroup glands;

    @FXML
    private RadioButton lymphNormalRadio;

    @FXML
    private ToggleGroup lymph;

    @FXML
    private RadioButton examNormalRadio;

    @FXML
    private ToggleGroup exam;

    @FXML
    private RadioButton bulbarAbnormalRadio;

    @FXML
    private RadioButton palpebralAbnormalRadio;

    @FXML
    private RadioButton lidsAbnormalRadio;

    @FXML
    private RadioButton glandsAbnormalRadio;

    @FXML
    private RadioButton lymphAbnormalRadio;

    @FXML
    private RadioButton examAbnormalRadio;
    
    private ExamEyeInputController examEyeInputController;

    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
		this.examEyeInputController = examEyeInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\nOS: ");
			examEyeInputController.str = examComp.toString();
		
				
				
					
					if (intactRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("extraocular movements are intact");
						examEyeInputController.str = str1.toString();
						
					}if (notIntactRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("extraocular movements are not intact");
						examEyeInputController.str = str1.toString();
						
					}
				
		
			
					
					
					if (perrlaNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal PERRLA.");
						examEyeInputController.str = str1.toString();
						
					}if (perrlaAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("abnormal PERRLA.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					   					
					
					if (bulbarNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Bulbar Conjunctivae normal.");
						examEyeInputController.str = str1.toString();
						
					}if (bulbarAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Bulbar Conjunctivae abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					
					
					if (palpebralNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Palpebral Conjunctivae normal.");
						examEyeInputController.str = str1.toString();
						
					}if (palpebralAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Palpebral Conjunctivae abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					
					
					
					if (lidsNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Lid appears normal.");
						examEyeInputController.str = str1.toString();
						
					}if (lidsAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Lid appears abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					    					
					
					if (glandsNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Lacrimal glands and ducts appear normal.");
						examEyeInputController.str = str1.toString();
						
					}if (glandsAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Lacrimal glands and ducts appear abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					
					
					
					
					if (lymphNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Periocular lymph nodes appear normal.");
						examEyeInputController.str = str1.toString();
						
					}if (lymphAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Periocular lymph nodes appear abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					
					
					
					
					if (examNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Funduscopic exam is normal.");
						examEyeInputController.str = str1.toString();
						
					}if (examAbnormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Funduscopic exam is abnormal.");
						examEyeInputController.str = str1.toString();
						
					}	
					
					
					
					
					
					if (dischargeCheck.isSelected() || foreignCheck.isSelected() || pterygiumCheck.isSelected()
							|| inflammationCheck.isSelected() || subconjunctivalCheck.isSelected() || pinguiculaCheck.isSelected()) {
						
						StringBuilder str11 = new StringBuilder(examEyeInputController.str);
						str11.append("Abnormalities include ");
						examEyeInputController.str = str11.toString();
						
						if (dischargeCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("discharge, ");
							examEyeInputController.str = str1.toString();
							
						}if (foreignCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("foreign body, ");
							examEyeInputController.str = str1.toString();
							   				
						}if (pterygiumCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("pterygium, ");
							examEyeInputController.str = str1.toString();
							
						}if (inflammationCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("inflammation, ");
							examEyeInputController.str = str1.toString();
							
						}if (subconjunctivalCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("subconjunctival hemorrhage, ");
							examEyeInputController.str = str1.toString();
							
						}if (pinguiculaCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("pinguicula, ");
							examEyeInputController.str = str1.toString();
							
						}
						
						StringBuilder str12 = new StringBuilder(examEyeInputController.str);
						str12.append(".");
						examEyeInputController.str = str12.toString();
						
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
