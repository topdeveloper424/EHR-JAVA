package com.ets.controller.gui.emrCharting.exam.psych.insight;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InsightInputController Class
 *Description: psychInsight_Judgment.fxml GUI Controller class
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class InsightInputController implements Initializable{
	
	 	@FXML
	    private CheckBox insightNormalCkeckBox;

	    @FXML
	    private CheckBox judgmentNormalCheck;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton insightGoodRadio;

	    @FXML
	    private ToggleGroup Insight;

	    @FXML
	    private RadioButton insightFairRadio;

	    @FXML
	    private RadioButton insightPoorRadio;

	    @FXML
	    private RadioButton judgmentFairRadio;

	    @FXML
	    private ToggleGroup Judgment;

	    @FXML
	    private RadioButton judgmentGoodRadio;

	    @FXML
	    private RadioButton judgmentPoorRadio;
	    
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
			
			if (insightNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Patient's insight and judgment appear good.");
				examPsychInputController.str = str1.toString();

			}else{
				if (insightGoodRadio.isSelected() || insightFairRadio.isSelected() || insightPoorRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append(" Patient's insight is ");
					examPsychInputController.str = str1.toString();

				}
				if (insightFairRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("fair");
					examPsychInputController.str = str1.toString();

				}
				if (insightPoorRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("poor");
					examPsychInputController.str = str1.toString();

				}
				if (insightGoodRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("good");
					examPsychInputController.str = str1.toString();

				}
			
			}
			
			
			
			if (judgmentGoodRadio.isSelected() || judgmentFairRadio.isSelected() || judgmentPoorRadio.isSelected() ) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(" judgment is ");
				examPsychInputController.str = str1.toString();

			}if (judgmentGoodRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("good");
				examPsychInputController.str = str1.toString();

			}if (judgmentFairRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("fair");
				examPsychInputController.str = str1.toString();

			}if (judgmentPoorRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("poor");
				examPsychInputController.str = str1.toString();

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
