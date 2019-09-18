package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.elbow;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ElbowSpecialTestRightInputController Class
 *Description: ElbowSpecialTestRight GUI Controller class
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
public class ElbowSpecialTestRightInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Label FlexionKneeText;

	    @FXML
	    private RadioButton elbowNegative;

	    @FXML
	    private ToggleGroup flexion;

	    @FXML
	    private RadioButton elbowPositive;

	    @FXML
	    private RadioButton tinelsNegative;

	    @FXML
	    private ToggleGroup sign;

	    @FXML
	    private RadioButton tinelsPositive;
    
    private ExamMusculotoneElbowInputController examMusculotoneElbowInputController;

	public void setExamMusculotoneElbowInputController(
			ExamMusculotoneElbowInputController examMusculotoneElbowInputController) {
		this.examMusculotoneElbowInputController = examMusculotoneElbowInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneElbowInputController.str);
			examComp.append("\n\nSPECIAL TESTS: \nRight elbow - the following special tests were performed:\n");
			examMusculotoneElbowInputController.str = examComp.toString();
			
			
			if (elbowNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Elbow flexion test negative.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			if (elbowPositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Elbow flexion test positive.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			if (tinelsNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Tinel's sign negative. ");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			if (tinelsPositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Tinel's sign possitive.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			

			

			++examMusculotoneElbowInputController.formCount;
			examMusculotoneElbowInputController.setElbowUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneElbowInputController.formCount;
				examMusculotoneElbowInputController.setElbowUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	
		
	}

}
