package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.hip;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HipRomRightInputController Class
 *Description: HipROMRight.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HipRomRightInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionFlexeText;

    @FXML
    private TextField FlexionKneeText;

    @FXML
    private TextField LeftExtensionText;

    @FXML
    private TextField abductionText;

    @FXML
    private TextField adductionText;

    @FXML
    private TextField internalText;

    @FXML
    private TextField externalText;
    
    private ExamMusculotoneHipInputController examMusculotoneHipInputController;


	public void setExamMusculotoneHipInputController(ExamMusculotoneHipInputController examMusculotoneHipInputController) {
		this.examMusculotoneHipInputController = examMusculotoneHipInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHipInputController.str);
			examComp.append("\n\nRANGE OF MOTION:");
			examMusculotoneHipInputController.str = examComp.toString();
			
			if (flexionFlexeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("\nRight Hip: Flexion W/Knee Flexed"+flexionFlexeText.getText()+"degrees (NL-120 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			
			
			if (FlexionKneeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append(" \nRight Hip: Flexion W/Knee Extended "+FlexionKneeText.getText()+"degrees (NL-90 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			if (LeftExtensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("\n Right Hip: Extension"+LeftExtensionText.getText()+"degrees (NL-30 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			if (abductionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("\nRight Hip: Abduction "+abductionText.getText()+" degrees (NL-45 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			
			
			if (adductionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("\n Right Hip: Adduction"+adductionText.getText()+"degrees (NL-30 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			if (internalText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("\nRight Hip: Internal Rotation"+internalText.getText()+"degrees (NL-40 degrees)");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			if (externalText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append(" \nRight Hip: External Rotation "+externalText.getText()+" degrees (NL-45 degrees).");
				examMusculotoneHipInputController.str = str1.toString();

			}
			
			
			
			

			++examMusculotoneHipInputController.formCount;
			examMusculotoneHipInputController.setHipUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneHipInputController.formCount;
				examMusculotoneHipInputController.setHipUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
