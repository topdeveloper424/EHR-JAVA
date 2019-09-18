package com.ets.controller.gui.emrCharting.exam.psych.moodAffect;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MoodEffectInputController Class
 *Description: psychMood_Affect.fxml GUI Controller class
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

public class MoodEffectInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox moodAllNormalChk;

    @FXML
    private RadioButton moodNormalRadio;

    @FXML
    private ToggleGroup mood;

    @FXML
    private RadioButton moodDepresedRadio;

    @FXML
    private RadioButton moodEuphoricRadio;

    @FXML
    private RadioButton speechNormalRadio;

    @FXML
    private ToggleGroup speech;

    @FXML
    private RadioButton speechExpressiveRadio;

    @FXML
    private RadioButton speechMuteRadio;

    @FXML
    private RadioButton speechHaltingRadio;

    @FXML
    private RadioButton affectNormalRadio;

    @FXML
    private ToggleGroup affect;

    @FXML
    private RadioButton affectFlatRadio;

    @FXML
    private RadioButton affectHypomanicRadio;

    @FXML
    private RadioButton affectManicRadio;

    @FXML
    private CheckBox affectAllNormalChk;

    @FXML
    private CheckBox speechAllNormalChk;
    
    
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
			
			if (moodAllNormalChk.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Patient's mood is normal.");
				examPsychInputController.str = str1.toString();

			} else {

				
				if (moodNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Patient's mood is normal, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodDepresedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Patient's mood is depressed, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodEuphoricRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Patient's mood is euphoric,");
					examPsychInputController.str = str1.toString();

				}
				
				
				if(affectAllNormalChk.isSelected()){
					
					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("affect is normal,");
					examPsychInputController.str = str1.toString();
					
				}else{
					
					if (affectFlatRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("affect is flat ,");
						examPsychInputController.str = str1.toString();

					}
					if (affectHypomanicRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("affect is hypomanic ,");
						examPsychInputController.str = str1.toString();

					}
					if (affectManicRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("affect is manic ,");
						examPsychInputController.str = str1.toString();

					}
					if (affectNormalRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("affect is normal ,");
						examPsychInputController.str = str1.toString();

					}
					
					
				}
				
				
				if(speechAllNormalChk.isSelected()){
					
					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("speech is normal.");
					examPsychInputController.str = str1.toString();
					
				}else{
					
					if (speechExpressiveRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("speech is expressive.");
						examPsychInputController.str = str1.toString();

					}if (speechHaltingRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("speech is halting.");
						examPsychInputController.str = str1.toString();

					}
					if (speechMuteRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("speech is mute.");
						examPsychInputController.str = str1.toString();

					}
					if (speechNormalRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("speech is normal.");
						examPsychInputController.str = str1.toString();

					}
					
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
