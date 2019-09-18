package com.ets.controller.gui.emrCharting.exam.gi;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamGIinputController Class
 *Description: gi.fxml Controller class
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
import com.ets.controller.gui.emrCharting.exam.gi.abdomenBasicExam.GiAbdomenbasicExamInputController;
import com.ets.controller.gui.emrCharting.exam.gi.comprehensive.GiComprehensiveIputController;
import com.ets.controller.gui.emrCharting.exam.gi.hernia.GiHerniaInputController;
import com.ets.controller.gui.emrCharting.exam.gi.rectal.RectalInputController;
import com.ets.controller.gui.emrCharting.exam.gi.stoolBlood.StoolBloodInputController;
import com.ets.controller.gui.emrCharting.exam.gi.utiFemale.FemaleUtiInputController;
import com.ets.controller.gui.emrCharting.exam.skin.examComprehensive.ExamComprehensiveMultiInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamGIinputController implements Initializable {
	  @FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox basicNormalCheckBox;

	    @FXML
	    private CheckBox acutePainCheckBox;

	    @FXML
	    private CheckBox appendixCheckBox;

	    @FXML
	    private CheckBox constipationCheckBox;

	    @FXML
	    private CheckBox enteritisCheckBox;

	    @FXML
	    private CheckBox utiCheckBox;

	    @FXML
	    private CheckBox examBasicCheckBox;

	    @FXML
	    private CheckBox herniasCheckBox;

	    @FXML
	    private CheckBox rectalCheckBox;

	    @FXML
	    private CheckBox stoolBloodCheckBox;

	    @FXML
	    private CheckBox utiFemaleCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;

	   
	    private Button  button;
	    
	    private CheckBox checkBox;
	    
	    public  static Integer formCount=0;
	    private Integer secondFormCount=0;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button , CheckBox checkBox) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
		this.checkBox = checkBox;
	}
	
    

   /* public String str="\n\nGI/ABDOMEN: ";*/
	 public String str = "\n ";

    
    
    void formCountIncrement(){
    	++secondFormCount;
    }
	    
	    public void setGIUI(){
	    	
	    	if(allNormalCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("The patient's abdomen was inspected for signs of distention, surgical scars, or ascites.  Bowel sounds were evaluated.  The patient's abdomen was then palpated in each of four quadrants, including palpation for RLQ tenderness, any rebound or tenderness in any part.  No abnormal findings.");
				str = str1.toString();
				allNormalCheckBox.setSelected(false);
				setGIUI();
	    		
	    	}else if(examCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamGiComprehensive", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamGiComprehensive", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				formPath.closeApplicationContext();
				
				GiComprehensiveIputController giComprehensiveIputController=
			   (GiComprehensiveIputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				giComprehensiveIputController.setExamGIinputController(this);
				
				examCheckBox.setSelected(false);
			   
	    	}else if(basicNormalCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GI & ABDOMEN: Examination of abdomen reveals normal appearance and normal bowel sounds, without masses.  No tenderness, organomegaly.");
				str = str1.toString();
				basicNormalCheckBox.setSelected(false);
				setGIUI();
	    		
	    	}else if(examBasicCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamAbdomenBasicExam", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamAbdomenBasicExam", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				formPath.closeApplicationContext();
				
				GiAbdomenbasicExamInputController giAbdomenbasicExamInputController=
			   (GiAbdomenbasicExamInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				giAbdomenbasicExamInputController.setExamGIinputController(this);
				examBasicCheckBox.setSelected(false);
				
				
			   
	    	}else if(herniasCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("EXAMHernia", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EXAMHernia", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				
				formPath.closeApplicationContext();
				
				GiHerniaInputController herniaInputController =
			   (GiHerniaInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				herniaInputController.setExamGIinputController(this);
				herniasCheckBox.setSelected(false);
				
	    		
	    	} else if(rectalCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("EXAMRectal", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EXAMRectal", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				
				formPath.closeApplicationContext();
				
				RectalInputController rectalInputController=
			   (RectalInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				rectalInputController.setExamGIinputController(this);
				rectalCheckBox.setSelected(false);
				
	    		
	    	} else if(stoolBloodCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("EXAMStool", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EXAMStool", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				formPath.closeApplicationContext();
				
				StoolBloodInputController stoolBloodInputController=
			   (StoolBloodInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				stoolBloodInputController.setExamGIinputController(this);
				stoolBloodCheckBox.setSelected(false);
				
	    	} else if(utiFemaleCheckBox.isSelected()){
	    		
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("EXAMUtiFemale", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EXAMUtiFemale", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				
				formPath.closeApplicationContext();
				
				FemaleUtiInputController femaleUtiInputController=
			   (FemaleUtiInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				femaleUtiInputController.setExamGIinputController(this);
				utiFemaleCheckBox.setSelected(false);
				
	    	}else if(acutePainCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("\n\nGI/ABDOMEN: Examination of abdomen reveals generalized guarding, with rebound tenderness. Bowel sounds are diminished. There are no masses or organomegaly. No hernias noted. ");
				str = str1.toString();
				acutePainCheckBox.setSelected(false);
				setGIUI();
	    		
	    	}else if(appendixCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("\n\nExamination of abdomen reveals guarding of the right lower quadrant, with rebound tenderness. Bowel sounds are diminished. There are no masses or organomegaly. No hernias noted. ");
				str = str1.toString();
				appendixCheckBox.setSelected(false);
				setGIUI();
	    		
	    	}else if(constipationCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("\n\nGI/ABDOMEN: Examination of abdomen reveals normal appearance and diminished bowel sounds, without masses but feels  'full' , not tender, no organomegaly or hernias. ");
				str = str1.toString();
				constipationCheckBox.setSelected(false);
				setGIUI();
				
	    		
	    	}else if(enteritisCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("\n\nGI/ABDOMEN: Examination of abdomen reveals normal appearance and normal bowel sounds, without masses.  No tenderness, organomegaly or hernias.");
				str = str1.toString();
				enteritisCheckBox.setSelected(false);
				setGIUI();
				
	    		
	    	}else if(utiCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GI/ABDOMEN: Examination of abdomen reveals normal appearance and normal bowel sounds, without masses.  No organomegaly or hernias. Minimal suprapubic tenderness, some costovertebral angle tenderness to percussion.");
				str = str1.toString();
				utiCheckBox.setSelected(false);
				setGIUI();
				
	    		
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
		// TODO Auto-generated method stub
		doneBtn.setOnAction((event)->
		{
			
			setGIUI();
		
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
