package com.ets.controller.gui.emrCharting.exam.neck;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckRangeMotionInputController Class
 *Description: neckRangeMotion.fxml GUI Controller class
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
import javafx.scene.control.TextField;

public class NeckRangeMotionInputController implements Initializable{
	
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
    
    
    private ExamNeckInputController examNeckInputController;

    public void setExamNeckInputController(ExamNeckInputController examNeckInputController) {
		this.examNeckInputController = examNeckInputController;
	}
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examNeckInputController.str);
			examComp.append("\n\n: ");
			examNeckInputController.str = examComp.toString();

			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(flexionText.getText());
				examNeckInputController.str = str1.toString();

			}
			
					
			
			
			
			
			if (extensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(extensionText.getText());
				examNeckInputController.str = str1.toString();

			}
			
			
			
			
		
			
			if (rightRatationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(rightRatationText.getText());
				examNeckInputController.str = str1.toString();

			}
			
			
			
			
			if (leftRatationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(leftRatationText.getText());
				examNeckInputController.str = str1.toString();

			}
			
					
			
			
			
			
			if (rightLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(rightLateralText.getText());
				examNeckInputController.str = str1.toString();

			}
			
			
			
			
		
			
			if (LeftLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(LeftLateralText.getText());
				examNeckInputController.str = str1.toString();

			}
			
			
			

			++examNeckInputController.formCount;
			examNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examNeckInputController.formCount;
				examNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
