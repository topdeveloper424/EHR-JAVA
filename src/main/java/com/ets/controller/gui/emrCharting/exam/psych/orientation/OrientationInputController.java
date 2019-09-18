package com.ets.controller.gui.emrCharting.exam.psych.orientation;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 30-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of OrientationInputController Class
 *Description: psychOrientationMood.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.psych.ExamPsychInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrientationInputController implements Initializable{
	
		@FXML
	    private CheckBox personPlaceTimeCheck;

	    @FXML
	    private CheckBox personlCheck;

	    @FXML
	    private CheckBox placeCheck;

	    @FXML
	    private CheckBox abnormalPersonPlaceTimeCheck;

	    @FXML
	    private CheckBox abnormalPersonCheck;

	    @FXML
	    private CheckBox abnormalTimeCheck;

	    @FXML
	    private CheckBox allNormalCheck;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox timeCheck;

	    @FXML
	    private CheckBox abnormalPlaceCheck;
	    
	    private ExamPsychInputController examPsychInputController;

		public void setExamPsychInputController(ExamPsychInputController examPsychInputController) {
			this.examPsychInputController = examPsychInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(examPsychInputController.str);
			skelComp.append("\n\nPSYCH: ");
			examPsychInputController.str = skelComp.toString();
			
			if (allNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Well oriented to person, place and time. ");
				examPsychInputController.str = str1.toString();

			} else {
				if (personPlaceTimeCheck.isSelected() || personlCheck.isSelected() || placeCheck.isSelected()
						|| timeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Patient is oriented to");
					examPsychInputController.str = str1.toString();

				}

				if (personPlaceTimeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("place and time, ");
					examPsychInputController.str = str1.toString();

				}
				if (personlCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("person, ");
					examPsychInputController.str = str1.toString();

				}
				if (placeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("place, ");
					examPsychInputController.str = str1.toString();

				}
				if (timeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("time, ");
					examPsychInputController.str = str1.toString();

				}
			}
			
			
			if(abnormalPersonPlaceTimeCheck.isSelected() || abnormalPersonCheck.isSelected()
					|| abnormalPlaceCheck.isSelected() || abnormalTimeCheck.isSelected() ){
				
				StringBuilder str11 = new StringBuilder(examPsychInputController.str);
				str11.append(" Patient is not oriented to");
				examPsychInputController.str = str11.toString();
				
				if (abnormalPersonPlaceTimeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("place and time, ");
					examPsychInputController.str = str1.toString();

				}if (abnormalPersonCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("person, ");
					examPsychInputController.str = str1.toString();

				}if (abnormalPlaceCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("place, ");
					examPsychInputController.str = str1.toString();

				}if (abnormalTimeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("time, ");
					examPsychInputController.str = str1.toString();

				}
				
				
				
			}
			
			
			StringBuilder str1 = new StringBuilder(examPsychInputController.str);
			str1.append(".");
			examPsychInputController.str = str1.toString();
			// genericEMRChartingController.saveAllTextArea();
			++examPsychInputController.formCount;
			examPsychInputController.setPsychUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examPsychInputController.formCount;
				examPsychInputController.setPsychUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
