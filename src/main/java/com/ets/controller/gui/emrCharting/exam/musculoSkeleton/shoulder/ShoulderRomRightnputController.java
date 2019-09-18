package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ShoulderRomRightnputController Class
 *Description: shoulderROMRight GUI Controller class
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

public class ShoulderRomRightnputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionText;

    @FXML
    private TextField extensionText;

    @FXML
    private TextField rightRatationText;

    @FXML
    private TextField leftRatationText;

    @FXML
    private TextField rightLateralText;

    @FXML
    private TextField LeftLateralText;
    
    private ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController;

    public void setExamMusculotoneShoulderInputController(
			ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController) {
		this.examMusculotoneShoulderInputController = examMusculotoneShoulderInputController;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneShoulderInputController.str);
			examComp.append("\n\nRANGE OF MOTION:  ");
			examMusculotoneShoulderInputController.str = examComp.toString();
			
			
			
	
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: Flexion "+flexionText.getText()+"degrees (NL-80 degrees)");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (extensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: Extension"+rightLateralText.getText()+"degrees (NL-50 degrees)");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			if (rightRatationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: Abduction "+LeftLateralText.getText()+" degrees (NL-180 degrees)");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			if (leftRatationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: Adduction"+flexionText.getText()+"degrees (NL-50 degrees)");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (rightLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: Internal Rotation"+rightLateralText.getText()+"degrees (NL-90 degrees)");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			if (LeftLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRight Shoulder: External Rotation "+LeftLateralText.getText()+" degrees (NL-90 degrees).");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			

			++examMusculotoneShoulderInputController.formCount;
			examMusculotoneShoulderInputController.setShoulderUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneShoulderInputController.formCount;
				examMusculotoneShoulderInputController.setShoulderUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
