package com.ets.controller.gui.emrCharting.exam.mskel;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.gi.stoolBlood.StoolBloodInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.DigitalAndNail.SkelDigitalNailInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.comprehensive.ExamSkelComprehensiveInpurController;
import com.ets.controller.gui.emrCharting.exam.mskel.extMotorStrengthExam.SkelExtMotorStrenghtInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.extMuscleStrength.SkelExtMuscleStrengthExam;
import com.ets.controller.gui.emrCharting.exam.mskel.gaintAndStation.SkelGaitAndNailInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.leMotorStrength.SkelLeMotorStrengthInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.leMuscleTone.MskelLEMuscleToneExamInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.ueMotorStrengthExam.SkelUeMotorStrengthExam;
import com.ets.controller.gui.emrCharting.exam.mskel.ueMuscleTone.SkelUeMuscleToneStrengthInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MSkelInputController Class
 *Description: MSkel GUI Controller class
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
public class MSkelInputController implements Initializable {
	 @FXML
	    private CheckBox allNormalComprehensiveCheckBox;

	    @FXML
	    private CheckBox examComprehensiveCheckBox;

	    @FXML
	    private CheckBox gaitCheck;

	    @FXML
	    private CheckBox ExtMuscleNormalCheck;

	    @FXML
	    private CheckBox ExtMuscleExamCheck;

	    @FXML
	    private CheckBox appendixCheckBox;

	    @FXML
	    private CheckBox LEMotorNormalCheck;

	    @FXML
	    private CheckBox LEMotorExamCheck;

	    @FXML
	    private CheckBox LEMuscleNormalCheck;

	    @FXML
	    private CheckBox DigitsCheck;

	    @FXML
	    private CheckBox herniasCheckBox;

	    @FXML
	    private CheckBox ExtMotorNormalCheck;

	    @FXML
	    private CheckBox ExtMotorExamCheck;

	    @FXML
	    private CheckBox LEMuscleExamCheck;

	    @FXML
	    private CheckBox utiCheckBox11;

	    @FXML
	    private CheckBox UEMotorStrengthNormalCheck;

	    @FXML
	    private CheckBox UEMotorStrengthExam;

	    @FXML
	    private CheckBox UEMuscleNormalCheck;

	    @FXML
	    private CheckBox UEMuscleToneExamCheck;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	   
	    private Button  button;
	    private CheckBox checkBox;
	    
	    public  static Integer formCount=0;
	    private Integer secondFormCount=0;
	    private Integer flag=0;
	    private Integer flag1=0;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	
	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button , CheckBox checkBox) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
		this.checkBox = checkBox;
	}
	
    

   /* public String str="\n\nGI/ABDOMEN: ";*/
	 public String str = " ";

    
    
    void formCountIncrement(){
    	++secondFormCount;
    }
	    
	    public void setSkelUI(){
	    		    	
	    	
	    	if(allNormalComprehensiveCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("MUSCULOSKELETAL:  Patient was noted to be walking normally, and station and coordination normal.  Inspection and palpation show digits and nails normal.   Strength and tone grossly normal UE/LE.\n\nBACK/FLANK: The patients back was inspected for scoliosis, kyphosis, or lordosis.  Hematoma and/or abrasions were noted if present. The spine was palpated for any point tenderness in both thoracic spine and lumbar 1 through 5, and sacral spine area.  Perivertebral muscles were palpated.  Any abnormal range of motion was noted.  CVA was palpated.  No abnormal findings.");
				str = str1.toString();
				allNormalComprehensiveCheckBox.setSelected(false);
	    		setSkelUI();
	    	}
	    	
	    	else if(examComprehensiveCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkelComprehensive", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamSkelComprehensive", null, Locale.US);
				formPath.closeApplicationContext();
				
				ExamSkelComprehensiveInpurController examSkelComprehensiveInpurController=
			   (ExamSkelComprehensiveInpurController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				examSkelComprehensiveInpurController.setMsSkelInputController(this);
				examComprehensiveCheckBox.setSelected(false);
				
				
	        }

	        else if(gaitCheck.isSelected()){
	        	
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamgaitStation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamgaitStation", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelGaitAndNailInputController skelGaitAndNailInputController=
			   (SkelGaitAndNailInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelGaitAndNailInputController.setMsSkelInputController(this);
				gaitCheck.setSelected(false);
				
	        }
	        else if(DigitsCheck.isSelected()){
	        	
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamDigitalNail", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamDigitalNail", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelDigitalNailInputController skelGaitAndNailInputController=
			   (SkelDigitalNailInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelGaitAndNailInputController.setMsSkelInputController(this);
				DigitsCheck.setSelected(false);
				
	        }else if(ExtMotorNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Motor strength of all four extremities tested normal. ");
				str = str1.toString();
				ExtMotorNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else  if(ExtMotorExamCheck.isSelected()){
	        	 
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamMotorStrength", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMotorStrength", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelExtMotorStrenghtInputController skelExtMotorStrenghtInputController=
			   (SkelExtMotorStrenghtInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelExtMotorStrenghtInputController.setMsSkelInputController(this);
				ExtMotorExamCheck.setSelected(false);
				
	        }else if(ExtMuscleNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Muscle tone in of all four extremities tested normal.");
				str = str1.toString();
				ExtMuscleNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else if(ExtMuscleExamCheck.isSelected()){
	        	 
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamMuscleStrength", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMuscleStrength", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelExtMuscleStrengthExam skelExtMuscleStrengthExam=
			   (SkelExtMuscleStrengthExam) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelExtMuscleStrengthExam.setMsSkelInputController(this);
				ExtMuscleExamCheck.setSelected(false);
				
	        }else if(LEMotorNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Motor strength of both lower extremities tested normal.");
				str = str1.toString();
				LEMotorNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else  if(LEMotorExamCheck.isSelected()){
	        	
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamLEMotorStrength", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamLEMotorStrength", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelLeMotorStrengthInputController skelLeMotorStrengthInputController=
			   (SkelLeMotorStrengthInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelLeMotorStrengthInputController.setMsSkelInputController(this);
				LEMotorExamCheck.setSelected(false);
				
	        }else if(LEMuscleNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Muscle tone in of both lower extremities tested normal.");
				str = str1.toString();
				LEMuscleNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else if(LEMuscleExamCheck.isSelected()){
	        	
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamLEMuscleTone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamLEMuscleTone", null, Locale.US);
				formPath.closeApplicationContext();
				
				MskelLEMuscleToneExamInputController skLeMuscleToneExamInputController=
			   (MskelLEMuscleToneExamInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skLeMuscleToneExamInputController.setMsSkelInputController(this);
				LEMuscleExamCheck.setSelected(false);
				
	        }else if(UEMotorStrengthNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Motor strength of both upper extremities tested normal.");
				str = str1.toString();
				UEMotorStrengthNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else if(UEMotorStrengthExam.isSelected()){
	        	 
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamUEMotorStrength", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamUEMotorStrength", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelUeMotorStrengthExam skelUeMotorStrengthExam=
			   (SkelUeMotorStrengthExam) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skelUeMotorStrengthExam.setMsSkelInputController(this);
				UEMotorStrengthExam.setSelected(false);
				
	        }else if(UEMuscleNormalCheck.isSelected()){
	        	
	        	StringBuilder str1 = new StringBuilder(str);
				str1.append("Muscle tone in of both upper extremities tested normal.");
				str = str1.toString();
				UEMuscleNormalCheck.setSelected(false);
				setSkelUI();
				
	        }
	        else if(UEMuscleToneExamCheck.isSelected()){
	        	  
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamUEMuscleStrengthTone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamUEMuscleStrengthTone", null, Locale.US);
				formPath.closeApplicationContext();
				
				SkelUeMuscleToneStrengthInputController msSkelUeMuscleToneStrengthInputController=
			   (SkelUeMuscleToneStrengthInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				msSkelUeMuscleToneStrengthInputController.setMsSkelInputController(this);
				UEMuscleToneExamCheck.setSelected(false);
				
	        }
	        else if(secondFormCount==formCount){
	        	 
			genericEMRChartingController.paint(button);
			genericEMRChartingController.hideCheckBox(checkBox);
    		new FXFormCommonUtilities().closeForm(doneBtn);
    		formCount=0;
    		genericEMRChartingController.setExamOrganTextArea(str);
    		genericEMRChartingController.saveAllTextArea();
	    	
    	}
    	
    	
    }
    
  

@Override
public void initialize(URL location, ResourceBundle resources) {
	
	doneBtn.setOnAction((event)->
	{
		
		setSkelUI();
        genericEMRChartingController.saveAllTextArea();
	
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
