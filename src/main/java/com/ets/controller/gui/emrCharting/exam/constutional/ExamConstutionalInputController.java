package com.ets.controller.gui.emrCharting.exam.constutional;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.constitutional.appearance.ExamSmartConstInputController;
import com.ets.controller.gui.emrCharting.exam.constitutional.comprehensive.ConstComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.constitutional.vital.ConstVitalInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.axilla.LymphAxillaInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.comprehensive.LymphComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.groin.LymphGroinInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.neck.LymphNeckController;
import com.ets.controller.gui.emrCharting.exam.heLe.other.LymphOtherInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamConstutionalInputController Class
 *Description: EditDistrict GUI Controller class
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
public class ExamConstutionalInputController implements Initializable{
	
		@FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox appearenceCheckBox;

	    @FXML
	    private CheckBox vitalSignCheckBox;

	    @FXML
	    private CheckBox flushedCheckBox;

	    @FXML
	    private CheckBox washedOutCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	   
	    private Button button;
	    
	    private CheckBox checkBox;
	    
	    public  static Integer formCount=0;
	    private Integer secondFormCount=0;
	    

	    private GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
				Button button, CheckBox checkBox) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
			this.checkBox = checkBox;
		}
	    
	    public String str="\n\nPatient appears";
	    void formCountIncrement(){
	    	++secondFormCount;
	    }
		    
		 
	    
	    public void setConstUI(){
	    	
	    	if(allNormalCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("");
				str = str1.toString();
				allNormalCheckBox.setSelected(false);
				setConstUI();
	    		
	    	}else if(examCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamConstitutionalComprehensive", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamConstitutionalComprehensive", null, Locale.US);

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

				ConstComprehensiveInputController constComprehensiveInputController = (ConstComprehensiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				constComprehensiveInputController.setExamConstutionalInputController(this);

				examCheckBox.setSelected(false);
	    		
	    	}
	    	else if(appearenceCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamConstitutionalAppearence", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamConstitutionalAppearence", null, Locale.US);

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

				 ExamSmartConstInputController examSmartConstInputController  = (ExamSmartConstInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 examSmartConstInputController.setExamConstutionalInputController(this);

				 appearenceCheckBox.setSelected(false);
	    		
	    	}
	    	
	    	else if(vitalSignCheckBox.isSelected()){
	    		
	    		formCountIncrement();
				String formName = formPath.context.getMessage("ExamConstitutionalitalSign", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamConstitutionalitalSign", null, Locale.US);

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

				 ConstVitalInputController vitalInputController = (ConstVitalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 vitalInputController.setExamConstutionalInputController(this);

				 vitalSignCheckBox.setSelected(false);
	    		
	    	}else if(flushedCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("");
				str = str1.toString();
				flushedCheckBox.setSelected(false);
				setConstUI();
	    		
	    	}else if(washedOutCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("");
				str = str1.toString();
				washedOutCheckBox.setSelected(false);
				setConstUI();
	    		
	    	}
	    	
	    	if (secondFormCount == formCount) {

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
			
			setConstUI();
		
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
