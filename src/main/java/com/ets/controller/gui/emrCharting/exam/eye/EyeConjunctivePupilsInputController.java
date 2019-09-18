package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of eyeConjunvtivaeAndLids Class
 *Description: EditDistrict GUI Controller class
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
public class EyeConjunctivePupilsInputController implements Initializable{
	
		@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox visualFieldNormalCheck;

	    @FXML
	    private CheckBox visualFieldNotTestedlCheck;

	    @FXML
	    private CheckBox visualFieldLeftDecreasedCheck;

	    @FXML
	    private CheckBox visualFieldNormalBilaterallyCheck;

	    @FXML
	    private CheckBox visualFieldRightNormalCheck;

	    @FXML
	    private CheckBox visualFieldDecreasedBilaterallyCheck;

	    @FXML
	    private CheckBox visualFieldRightDecreasedCheck;

	    @FXML
	    private CheckBox visualFieldLeftNormalCheck;
	    
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
			
						
			
			if (visualFieldNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				if (visualFieldNotTestedlCheck.isSelected() || visualFieldDecreasedBilaterallyCheck.isSelected() || visualFieldLeftDecreasedCheck.isSelected() 
						|| visualFieldLeftNormalCheck.isSelected() || visualFieldNormalBilaterallyCheck.isSelected() || visualFieldRightDecreasedCheck.isSelected()
						|| visualFieldRightNormalCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("");
					examEyeInputController.str = str11.toString();
					
					
					if (visualFieldNotTestedlCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldDecreasedBilaterallyCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldLeftDecreasedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldLeftNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldNormalBilaterallyCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldRightDecreasedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (visualFieldRightDecreasedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
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
