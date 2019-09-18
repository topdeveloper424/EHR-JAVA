package com.ets.controller.gui.emrCharting.exam.heLe;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphInputController Class
 *Description: hele.fxml Controller class
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
import com.ets.controller.gui.emrCharting.exam.heLe.axilla.LymphAxillaInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.comprehensive.LymphComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.groin.LymphGroinInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.neck.LymphNeckController;
import com.ets.controller.gui.emrCharting.exam.heLe.other.LymphOtherInputController;
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

public class LymphInputController implements Initializable {
	
	  @FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox axillaCheckBox;

	    @FXML
	    private CheckBox groinCheckBox;

	    @FXML
	    private CheckBox neckCheckBox;

	    @FXML
	    private CheckBox otherCheckBox;

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
	    
	    public void setLymphUI(){
	    	
	    	if(allNormalCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("");
				str = str1.toString();
				allNormalCheckBox.setSelected(false);
				setLymphUI();
	    		
	    	}else if(examCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamLymphComprehensivMultiSystem", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamLymphComprehensivMultiSystem", null, Locale.US);

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

				LymphComprehensiveInputController examComprehensiveInputController = (LymphComprehensiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examComprehensiveInputController.setLymphInputController(this);

				examCheckBox.setSelected(false);
	    		
	    	}
	    	else if(axillaCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamLymphAxilla", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamLymphAxilla", null, Locale.US);

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

				 LymphAxillaInputController lymphAxillaInputController = (LymphAxillaInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 lymphAxillaInputController.setLymphInputController(this);

				 axillaCheckBox.setSelected(false);
	    		
	    	}
	    	
	    	else if(groinCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamLymphGroin", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamLymphGroin", null, Locale.US);

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

				 LymphGroinInputController lymphGroinInputController = (LymphGroinInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 lymphGroinInputController.setLymphInputController(this);

				 groinCheckBox.setSelected(false);
	    		
	    	}else if(neckCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamLymphNeck", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamLymphNeck", null, Locale.US);

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

				 LymphNeckController neckController = (LymphNeckController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 neckController.setLymphInputController(this);

				 neckCheckBox.setSelected(false);
	    		
	    	}else if(otherCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamLymphOther", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamLymphOther", null, Locale.US);

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

				 LymphOtherInputController otherInputController = (LymphOtherInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 otherInputController.setLymphInputController(this);

				 otherCheckBox.setSelected(false);
	    		
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
			
			setLymphUI();
			
		
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
