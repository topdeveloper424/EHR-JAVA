package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.head;

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
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HeadRomSpineInputController Class
 *Description: headRomSpine GUI Controller class
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
public class HeadRomSpineInputController implements Initializable{
	
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
	    
	    private ExamMusculotoneHeadInputController examMusculotoneHeadInputController;

	    public void setExamMusculotoneHeadInputController(
				ExamMusculotoneHeadInputController examMusculotoneHeadInputController) {
			this.examMusculotoneHeadInputController = examMusculotoneHeadInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHeadInputController.str);
			examComp.append("\n\nHEAD: ");
			examMusculotoneHeadInputController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {
				
				

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Flexion " +flexionText.getText()+ " degrees (NL- 60 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				

		
			}
			
			
			
			
			
			if (extensionText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Extension " +extensionText.getText()+ " degrees (NL- 50 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				

		
			}
			
			
			
			if (rightRatationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Right Rotation " +rightRatationText.getText()+ " degrees (NL- 80 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				
				
			}
			
			
			
			if (leftRatationText.getText().length() > 0) {


				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Left Rotation " +leftRatationText.getText()+ " degrees (NL- 80 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				
				
			}
			
			
			
			
			
			if (rightLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Right Lateral Flexion " +rightLateralText.getText()+ " degrees (NL- 40 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				
			}
			
			
			
			if (LeftLateralText.getText().length() > 0) {


				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("\nC-Spine: Left Lateral Flexion " +LeftLateralText.getText()+ " degrees (NL- 40 degrees)");
				examMusculotoneHeadInputController.str = str1.toString();
				
			}
			
			
			
			
			

			++examMusculotoneHeadInputController.formCount;
			examMusculotoneHeadInputController.setHeadUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneHeadInputController.formCount;
				examMusculotoneHeadInputController.setHeadUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
