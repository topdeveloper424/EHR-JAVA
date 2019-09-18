package com.ets.controller.gui.emrCharting.exam.psych.examComprehensive;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamComprehensiveInputController Class
 *Description: phychExamCompMultiSystem.fxml GUI Controller class
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
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class ExamComprehensiveInputController implements Initializable{
	
	 @FXML
	    private CheckBox insightNormalCkeckBox;

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
	    private CheckBox moodAllNormalChk;

	    @FXML
	    private CheckBox recentNormalCheck;

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

	    @FXML
	    private CheckBox timeCheck;

	    @FXML
	    private CheckBox abnormalPlaceCheck;

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

	    @FXML
	    private RadioButton moodNormalRadio;

	    @FXML
	    private ToggleGroup mood;

	    @FXML
	    private RadioButton moodAnxiousRadio;

	    @FXML
	    private RadioButton moodGuardedRadio;

	    @FXML
	    private RadioButton moodDepresedRadio;

	    @FXML
	    private RadioButton moodManicRadio;

	    @FXML
	    private RadioButton moodEuphoricRadio;

	    @FXML
	    private RadioButton moodHypomanicRadio;

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
	    private CheckBox associationIntactChk;

	    @FXML
	    private CheckBox associationLooseChk;

	    @FXML
	    private CheckBox associationTangentialtChk;

	    @FXML
	    private CheckBox associationCircumtantialChk;

	    @FXML
	    private TextArea additionalTextArea;

	    @FXML
	    private CheckBox findingInsightChk;

	    @FXML
	    private CheckBox findingMoodChk;

	    @FXML
	    private CheckBox findingAffectChk;

	    @FXML
	    private CheckBox findingWellChk;
	    
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
			
			
			
			
			
			
			
			
			if (moodAllNormalChk.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Mood, affect and speech normal.");
				examPsychInputController.str = str1.toString();

			} else {
				if (moodAnxiousRadio.isSelected() || moodDepresedRadio.isSelected() || moodEuphoricRadio.isSelected()

						|| moodGuardedRadio.isSelected() || moodHypomanicRadio.isSelected()
						|| moodManicRadio.isSelected() || moodNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Patient's mood is ");
					examPsychInputController.str = str1.toString();

				}

				if (moodAnxiousRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("anxious, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodDepresedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("depressed");
					examPsychInputController.str = str1.toString();

				}
				if (moodEuphoricRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("uphoric, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodGuardedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("guarded, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodHypomanicRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("hyomanic, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodManicRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("manic, ");
					examPsychInputController.str = str1.toString();

				}
				if (moodNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("norma, ");
					examPsychInputController.str = str1.toString();

				}

			}
			
			
			
			
			if (speechExpressiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("speech is expressive. ");
				examPsychInputController.str = str1.toString();

			}if (speechHaltingRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("speech is halting. ");
				examPsychInputController.str = str1.toString();

			}if (speechMuteRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("speech is mute. ");
				examPsychInputController.str = str1.toString();

			}if (speechNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("speech is normal. ");
				examPsychInputController.str = str1.toString();

			}
			
			
			
			if(associationIntactChk.isSelected() || associationLooseChk.isSelected() || associationTangentialtChk.isSelected() || associationCircumtantialChk.isSelected()){
				
				StringBuilder str11 = new StringBuilder(examPsychInputController.str);
				str11.append("Patient's associations are ");
				examPsychInputController.str = str11.toString();
				
				if (associationIntactChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("normal and intact, ");
					examPsychInputController.str = str1.toString();

				}if (associationLooseChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("loose, ");
					examPsychInputController.str = str1.toString();
					
				}if (associationTangentialtChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("tangential, ");
					examPsychInputController.str = str1.toString();

				}
				if (associationCircumtantialChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("circumstantial, ");
					examPsychInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(".");
				examPsychInputController.str = str1.toString();
				
				
				
			}
			
					
			
			
			
			
			
			if (additionalTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(additionalTextArea.getText());
				examPsychInputController.str = str1.toString();

			}
						
			
			
			
			if (findingAffectChk.isSelected() || findingInsightChk.isSelected() || findingMoodChk.isSelected() || findingWellChk.isSelected()) {

				StringBuilder str11 = new StringBuilder(examPsychInputController.str);
				str11.append("Examination of the patient's psychiatric state is normal for the following: ");
				examPsychInputController.str = str11.toString();
				
				if (findingAffectChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("affect and speech, ");
					examPsychInputController.str = str1.toString();

				}
				 
				if (findingInsightChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("insight and judgment, ");
					examPsychInputController.str = str1.toString();

				}if (findingMoodChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("mood, ");
					examPsychInputController.str = str1.toString();

				}if (findingWellChk.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("well oriented, ");
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
