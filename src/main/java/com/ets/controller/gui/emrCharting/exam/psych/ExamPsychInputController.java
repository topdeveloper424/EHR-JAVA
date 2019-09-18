package com.ets.controller.gui.emrCharting.exam.psych;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamPsychInputController Class
 *Description: psych.fxml GUI Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.neuro.comprehensiveMultiSystem.NeuroComprehensiveMultiSystem;
import com.ets.controller.gui.emrCharting.exam.psych.attentation.AttentationLanguageInputController;
import com.ets.controller.gui.emrCharting.exam.psych.examComprehensive.ExamComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.psych.insight.InsightInputController;
import com.ets.controller.gui.emrCharting.exam.psych.memory.MemoryInputController;
import com.ets.controller.gui.emrCharting.exam.psych.moodAffect.MoodEffectInputController;
import com.ets.controller.gui.emrCharting.exam.psych.orientation.OrientationInputController;
import com.ets.controller.gui.emrCharting.exam.psych.orientationMood.OrientationMoodInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamPsychInputController implements Initializable{
	
	 	@FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox orientationMoodAffectCheckBox;

	    @FXML
	    private CheckBox insightCheckBox;

	    @FXML
	    private CheckBox orientationCheckBox;

	    @FXML
	    private CheckBox memoryCheckBox;

	    @FXML
	    private CheckBox attentationCheckBox;

	    @FXML
	    private CheckBox moodAffectCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	    
	    private Button button;
	    
	    private CheckBox checkBox;

		FXMLFormPath formPath = new FXMLFormPath();

		private GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
				Button button, CheckBox checkBox) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
			this.checkBox = checkBox;
		}

		public static Integer formCount = 0;
		private Integer secondFormCount = 0;

		public String str="\n\n";

		void formCountIncrement() {
			++secondFormCount;
		}
	    
	    public void setPsychUI(){
	    	
	    	if(allNormalCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("PSYCH:  Patient's insight and judgment appear good, and mood, affect and speech normal.  The patient's orientation to person, place and time were evaluated.  No abnormal findings.");
				str = str1.toString();
				allNormalCheckBox.setSelected(false);
				setPsychUI();
	    		
	    	}else if(examCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychComprehensivMultiSystem", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychComprehensivMultiSystem", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				ExamComprehensiveInputController examComprehensiveInputController = (ExamComprehensiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examComprehensiveInputController.setExamPsychInputController(this);

				examCheckBox.setSelected(false);
	    		
	    	}
	    	else if(orientationMoodAffectCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychOrientationMood", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychOrientationMood", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 OrientationMoodInputController orientationMoodInputController = (OrientationMoodInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 orientationMoodInputController.setExamPsychInputController(this);

				orientationMoodAffectCheckBox.setSelected(false);
	    		
	    	}
	    	
	    	else if(insightCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychInsight_Judgment", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychInsight_Judgment", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 InsightInputController insightInputController = (InsightInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 insightInputController.setExamPsychInputController(this);

				 insightCheckBox.setSelected(false);
	    		
	    	}else if(orientationCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychOrientation", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychOrientation", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 OrientationInputController orientationInputController = (OrientationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 orientationInputController.setExamPsychInputController(this);

				 orientationCheckBox.setSelected(false);
	    		
	    	}else if(memoryCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychMemory", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychMemory", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 MemoryInputController memoryInputController = (MemoryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 memoryInputController.setExamPsychInputController(this);

				 memoryCheckBox.setSelected(false);
	    		
	    	}else if(attentationCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychAttentation_Language", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychAttentation_Language", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 AttentationLanguageInputController attentationLanguageInputController = (AttentationLanguageInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 attentationLanguageInputController.setExamPsychInputController(this);

				 attentationCheckBox.setSelected(false);
	    		
	    	}else if(moodAffectCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamPsychMood_Affect", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamPsychMood_Affect", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				 MoodEffectInputController moodEffectInputController = (MoodEffectInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 moodEffectInputController.setExamPsychInputController(this);

				 moodAffectCheckBox.setSelected(false);
	    		
	    	}
	    	
	    	else if (secondFormCount == formCount) {

				genericEMRChartingController.paint(button);
				genericEMRChartingController.hideCheckBox(checkBox);
				new FXFormCommonUtilities().closeForm(doneBtn);
				formCount = 0;
				genericEMRChartingController.setExamOrganTextArea(str);
				genericEMRChartingController.saveAllTextArea();

			}
	    	
	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			setPsychUI();
			
		
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
