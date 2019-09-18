package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 8-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeViualFieldInputController Class
 *Description: EyeViualField GUI Controller class
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
public class EyeViualFieldInputController implements Initializable {
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox viuaNotTeastedCheck;

    @FXML
    private CheckBox viualNormalBilaterallyCheck;

    @FXML
    private CheckBox viualDecreaedBilaterallyCheck;

    @FXML
    private CheckBox viualLeftNormalCheck;

    @FXML
    private CheckBox viualLeftContrictedCheck;

    @FXML
    private CheckBox viualRightNormalCheck;

    @FXML
    private CheckBox viualNormalCheck;

    @FXML
    private CheckBox viualLeftDecreasedCheck;

    @FXML
    private CheckBox viualRightDecreasedCheck;
    
    
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
			
			
		if(viualNormalCheck.isSelected()){
			
			StringBuilder str1 = new StringBuilder(examEyeInputController.str);
			str1.append("Visual fields tested normal bilaterally.");
			examEyeInputController.str = str1.toString();
			
		}else{
			
			if(viuaNotTeastedCheck.isSelected() || viualDecreaedBilaterallyCheck.isSelected() || viualLeftContrictedCheck.isSelected() 
					|| viualLeftDecreasedCheck.isSelected() || viualRightDecreasedCheck.isSelected() || viualNormalBilaterallyCheck.isSelected() 
					|| viualLeftNormalCheck.isSelected() || viualRightNormalCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("Visual fields were ");
				examEyeInputController.str = str11.toString();
				
				
				
				if (viuaNotTeastedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("not tested, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualDecreaedBilaterallyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("decreased bilaterally, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualLeftDecreasedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left decreased, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualRightDecreasedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right decreased, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualNormalBilaterallyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("normal bilaterally, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualLeftNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (viualRightNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(".");
				examEyeInputController.str = str12.toString();
				
				
			}
			
			
			
			
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
