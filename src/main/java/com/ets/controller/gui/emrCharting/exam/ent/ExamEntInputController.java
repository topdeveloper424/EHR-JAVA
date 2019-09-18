package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamEntInputController Class
 *Description: entNasalMucosa.fxml Controller class
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
import com.ets.controller.gui.emrCharting.exam.gi.comprehensive.GiComprehensiveIputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamEntInputController implements Initializable{
	
	
	@FXML
    private CheckBox allNormalComprehensiveCheckBox;

    @FXML
    private CheckBox examComprehensiveCheckBox;

    @FXML
    private CheckBox lipGumsCheck;

    @FXML
    private CheckBox oropharynxCheck;

    @FXML
    private CheckBox abscessCheck;

    @FXML
    private CheckBox otitisExternalCheck;

    @FXML
    private CheckBox otitisMediaCheck;

    @FXML
    private CheckBox noseExternalCheck;

    @FXML
    private CheckBox otoscopicCheck;

    @FXML
    private CheckBox hearingCheck;

    @FXML
    private CheckBox pharyngitisCheck;

    @FXML
    private CheckBox utiCheckBox11;

    @FXML
    private CheckBox sinuitisCheck;

    @FXML
    private CheckBox sinuesCheck;

    @FXML
    private CheckBox nasalExamExam;

    @FXML
    private CheckBox examComprehensiveNMTCheckBox;

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
		
		 public void setEntUI(){
		    	
		    	if(allNormalComprehensiveCheckBox.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EARS : Patient ears were examined for pain, tenderness, or swelling of external ear, cartilage and pinna. "
							+ " Gross hearing was determined at conversational level. External ear canal was examined for presence or absence of"
							+ " cerumen impaction, redness, discharge, debris or signs of otitis externa. Tympanic membrane examined for light reflex,"
							+ " and abnormal signs or TM redness, bulging or fluid behind TM, or perforation. No significant abnormal findings noted."
							+ "THROAT/TEETH/MOUTH/SINUS: Patient examined for gross facial swelling, tenderness of frontal or maxillary sinuses. "
							+ " Examined for stridor or drooling and ability to handle secretions.  Lips and gingiva examined for hydration or lesions."
							+ "  Dentition noted in exam. The presence or absence of tonsils was examined for swelling, redness, or presence of pus."
							+ "  Posterior pharynx examined for redness, pebbling, swelling or discharge. No significant abnormal findings noted.");
					str = str1.toString();
					allNormalComprehensiveCheckBox.setSelected(false);
					setEntUI();
		    		
		    	}else if(examComprehensiveCheckBox.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntCompMultiSys", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntCompMultiSys", null, Locale.US);
					
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
					
					EntComprehensiveMultiSystemInputController entComprehensiveMultiSystemInputController=
				   (EntComprehensiveMultiSystemInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entComprehensiveMultiSystemInputController.setExamEntInputController(this);
					
					examComprehensiveCheckBox.setSelected(false);
				   
		    	}else if(examComprehensiveNMTCheckBox.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntCompNMT", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntCompNMT", null, Locale.US);
					
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
					
					 EntComprehensiveNMTInputController EntComprehensiveNMTInputController =
				   (EntComprehensiveNMTInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					 EntComprehensiveNMTInputController.setExamEntInputController(this);
					
					examComprehensiveNMTCheckBox.setSelected(false);
				   
		    	}else if(noseExternalCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntEarNoseExternal", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntEarNoseExternal", null, Locale.US);
					
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
					
					EntEarNoseExternalInputController entEarNoseExternalInputController =
				   (EntEarNoseExternalInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entEarNoseExternalInputController.setExamEntInputController(this);
					
					noseExternalCheck.setSelected(false);
				   
		    	}else if(otoscopicCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntOtoscopic", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntOtoscopic", null, Locale.US);
					
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
					
					EntOtoscopicInputController entOtoscopicInputController =
				   (EntOtoscopicInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entOtoscopicInputController.setExamEntInputController(this);
					
					otoscopicCheck.setSelected(false);
				   
		    	}else if(hearingCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntHearing", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntHearing", null, Locale.US);
					
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
					
					EntHearingInputController entHearingInputController =
				   (EntHearingInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entHearingInputController.setExamEntInputController(this);
					
					hearingCheck.setSelected(false);
				   
		    	}else if(nasalExamExam.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntNasalMucosa", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntNasalMucosa", null, Locale.US);
					
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
					
					EntNasalMucosaInputController nasalMucosaInputController =
				   (EntNasalMucosaInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					nasalMucosaInputController.setExamEntInputController(this);
					
					nasalExamExam.setSelected(false);
				   
		    	}else if(lipGumsCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntLipGum", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntLipGum", null, Locale.US);
					
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
					
					EntLipGumInputController entLipGumInputController=
				   (EntLipGumInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entLipGumInputController.setExamEntInputController(this);
					
					lipGumsCheck.setSelected(false);
				   
		    	}else if(oropharynxCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntOropharynx", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntOropharynx", null, Locale.US);
					
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
					
					EntOropharynxInputController entOropharynxInputController=
				   (EntOropharynxInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entOropharynxInputController.setExamEntInputController(this);
					
					oropharynxCheck.setSelected(false);
				   
		    	}else if(sinuesCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEntSinuses", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEntSinuses", null, Locale.US);
					
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
					
					EntSinusesInputController entSinusesInputController =
				   (EntSinusesInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					entSinusesInputController.setExamEntInputController(this);
					
					sinuesCheck.setSelected(false);
				   
		    	}else if(abscessCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("ENT: External ears and nose appear normal. Ear canals normal; tympanic membranes normal. "
							+ "Nasal mucosa, septum and turbinates normal. Lips and gums are normal; "
							+ "dentition is in poor repair, with caries and abscess noted. Oropharynx shows "
							+ "mucous membranes moist; palate, uvula, tongue, tonsils, salivary glands and "
							+ "posterior pharynx are normal. No sinus tenderness present.");
					str = str1.toString();
					abscessCheck.setSelected(false);
					setEntUI();
					
					
				   
		    	}else if(otitisExternalCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("ENT: External ears and nose appear normal, but affected side is tender to "
							+ "manipulation. Affected ear canal swollen, red and tender; tympanic membranes "
							+ "dull. Nasal mucosa, septum and turbinates normal. Lips and gums are normal; "
							+ "dentition is in good repair. Oropharynx shows mucous membranes moist; palate,"
							+ " uvula, tongue, tonsils, salivary glands and posterior pharynx are normal. "
							+ "No sinus tenderness present.");
					str = str1.toString();
					otitisExternalCheck.setSelected(false);
					setEntUI();
					
					
				   
		    	}else if(otitisMediaCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("ENT: External ears and nose appear normal. Ear canals normal. Affected ear "
							+ "tympanic membrane erythematous; unaffected membrane normal. Nasal mucosa, "
							+ "septum and turbinates normal. Lips and gums are normal; dentition is in good "
							+ "repair. Oropharynx shows mucous membranes moist; palate, uvula, tongue, "
							+ "tonsils, salivary glands and posterior pharynx are normal. No sinus tenderness"
							+ " present.");
					str = str1.toString();
					otitisMediaCheck.setSelected(false);
					setEntUI();
					
					
				   
		    	}else if(pharyngitisCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("ENT: External ears and nose appear normal. Ear canals normal; tympanic "
							+ "membranes normal. Nasal mucosa, septum and turbinates normal. Lips and gums "
							+ "are normal. Oropharynx shows mucous membranes moist; palate, tongue, salivary "
							+ "glands are normal. Posterior pharynx red with exudate. No sinus tenderness "
							+ "present. Some minimally tender neck nodes present.");
					str = str1.toString();
					pharyngitisCheck.setSelected(false);
					setEntUI();
					
					
				   
		    	}else if(sinuitisCheck.isSelected()){
		    		
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("ENT: External ears and nose appear normal. Ear canals normal; "
							+ " membranes dull. Nasal mucosa, septum and turbinates normal. Lips and gums "
							+ "are normal; dentition is in good repair. Oropharynx shows mucous membranes "
							+ "moist; palate, uvula, tongue, tonsils, salivary glands and posterior pharynx "
							+ "are normal. Sinuses are tender to percussion.");
					str = str1.toString();
					sinuitisCheck.setSelected(false);
					setEntUI();
					
				   
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
			
			setEntUI();
		
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
