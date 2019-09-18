package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 8-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeVisualAcuityUncorrectInputController Class
 *Description: EyeVisualAcuityUncorrect GUI Controller class
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
public class EyeVisualAcuityUncorrectInputController implements Initializable {
	
	 	@FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField osText;

	    @FXML
	    private TextField odText;

	    @FXML
	    private TextField ouText;

	    @FXML
	    private CheckBox SnellenCheck;

	    @FXML
	    private CheckBox titmusCheck;

	    @FXML
	    private CheckBox otherCheck;
	    
	    private ExamEyeInputController examEyeInputController;

	    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
			this.examEyeInputController = examEyeInputController;
		}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			
		
				
			if (osText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("\nVisual Acuity - OS 20/ "+osText.getText()+" uncorrected");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			if (odText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("\nVisual Acuity - OD 20/ "+odText.getText()+" uncorrected");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			if (ouText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("\nVisual Acuity - OU 20/ "+ouText.getText()+" uncorrected");
				examEyeInputController.str = str1.toString();
				
			}
					
					
					
					
			
					if (SnellenCheck.isSelected() || titmusCheck.isSelected() || otherCheck.isSelected()) {
						
						StringBuilder str11 = new StringBuilder(examEyeInputController.str);
						str11.append("Visual acuity tested with ");
						examEyeInputController.str = str11.toString();
						
						if (SnellenCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("Snellen, ");
							examEyeInputController.str = str1.toString();
							
						}if (titmusCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("TITMUS, ");
							examEyeInputController.str = str1.toString();
							   				
						}if (otherCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEyeInputController.str);
							str1.append("other method, ");
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
