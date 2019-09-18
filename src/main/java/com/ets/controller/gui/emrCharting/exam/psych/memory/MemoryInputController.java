package com.ets.controller.gui.emrCharting.exam.psych.memory;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MemoryInputController Class
 *Description: psychMemory.fxml GUI Controller class
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

public class MemoryInputController implements Initializable{
	
		@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox remoteAllNormalChk;

	    @FXML
	    private CheckBox recentNormalCheck;

	    @FXML
	    private RadioButton recentIntactRadio;

	    @FXML
	    private ToggleGroup recent;

	    @FXML
	    private RadioButton recentAbsentRadio;

	    @FXML
	    private RadioButton recentDecreasedRadio;

	    @FXML
	    private RadioButton recentMarkdlyRadio;

	    @FXML
	    private RadioButton remoteIntactRadio;

	    @FXML
	    private ToggleGroup remote;

	    @FXML
	    private RadioButton remoteAbsentRadio;

	    @FXML
	    private RadioButton remoteDecreasedtRadio;

	    @FXML
	    private RadioButton remoteMarkdlyRadio;
	    
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
			
			if (recentNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Memory appears normal. ");
				examPsychInputController.str = str1.toString();

			} else {

				if (recentIntactRadio.isSelected() || recentAbsentRadio.isSelected() || recentDecreasedRadio.isSelected() || recentMarkdlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Recent memory is ");
					examPsychInputController.str = str1.toString();

				}
				if (recentIntactRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("intact, ");
					examPsychInputController.str = str1.toString();

				}
				if (recentAbsentRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("absent, ");
					examPsychInputController.str = str1.toString();

				}
				if (recentDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("decreased, ");
					examPsychInputController.str = str1.toString();

				}
				if (recentMarkdlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("markedly decreased, ");
					examPsychInputController.str = str1.toString();

				}

			}
			
			if (remoteIntactRadio.isSelected() || remoteAbsentRadio.isSelected() || remoteDecreasedtRadio.isSelected()
					|| remoteMarkdlyRadio.isSelected()) {

				StringBuilder str11 = new StringBuilder(examPsychInputController.str);
				str11.append("and remote memory is ");
				examPsychInputController.str = str11.toString();

				if (remoteIntactRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("intact, ");
					examPsychInputController.str = str1.toString();

				}
				if (remoteAbsentRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("abent, ");
					examPsychInputController.str = str1.toString();

				}
				if (remoteDecreasedtRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("decreased, ");
					examPsychInputController.str = str1.toString();

				}
				if (remoteMarkdlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("markedly decreased, ");
					examPsychInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(".");
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
