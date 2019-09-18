package com.ets.controller.gui.emrCharting.exam.eye;

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
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditDistrictGUIController Class
 *Description: EyeInputController GUI Controller class
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
public class ExamEyeInputController implements Initializable {
	
	
	 @FXML
	    private CheckBox allNormalComprehensiveCheckBox;

	    @FXML
	    private CheckBox examComprehensiveCheckBox;

	    @FXML
	    private CheckBox acutyCheck;

	    @FXML
	    private CheckBox odCheck;

	    @FXML
	    private CheckBox osCheck;

	    @FXML
	    private CheckBox lrisesCheck;

	    @FXML
	    private CheckBox ocularMotilityCheck;

	    @FXML
	    private CheckBox correctedCheck;

	    @FXML
	    private CheckBox slitLampCheck;

	    @FXML
	    private CheckBox herniasCheckBox;

	    @FXML
	    private CheckBox introcularPreureCheck;

	    @FXML
	    private CheckBox ophthalmoscopicCheck;

	    @FXML
	    private CheckBox uncorrectedCheck;

	    @FXML
	    private CheckBox utiCheckBox11;

	    @FXML
	    private CheckBox visualFieldCheck;

	    @FXML
	    private CheckBox foreignBodyExam;

	    @FXML
	    private CheckBox conjunctivitiesCheck;

	    @FXML
	    private CheckBox bilateralCheck;

	    @FXML
	    private CheckBox pupilsCheck;

	    @FXML
	    private CheckBox lidsCheck;

	    @FXML
	    private CheckBox injuryConjExam;

	    @FXML
	    private CheckBox injuryNormalExam;

	    @FXML
	    private CheckBox styeExam;

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
		
		 public void setEyeUI(){
		    	
		    	if(allNormalComprehensiveCheckBox.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Patient examined for extraocular movements, symmetry of pupils, "
							+ "and reactivity to light.  Sclera and conjunctivae examined for hemorrhage, "
							+ "injection or inflammation, or presence of F/B.  Gross vision/VF were examined"
							+ " bilaterally. No Abnormal findings.");
					str = str1.toString();
					allNormalComprehensiveCheckBox.setSelected(false);
					setEyeUI();
		    		
		    	}else if(examComprehensiveCheckBox.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeComprehenive", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeComprehenive", null, Locale.US);
					
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
					
					EyeComprehensiveMultiSystemInputController eyeComprehensiveMultiSystemInputController =
				   (EyeComprehensiveMultiSystemInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeComprehensiveMultiSystemInputController.setExamEyeInputController(this);
					
					examComprehensiveCheckBox.setSelected(false);
				   
		    	}else if(acutyCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamAcuityPupils", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamAcuityPupils", null, Locale.US);
					
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
					
					EyeCompAcuityPupilsInputController eyeCompAcuityPupilsInputController =
				   (EyeCompAcuityPupilsInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeCompAcuityPupilsInputController.setExamEyeInputController(this);
					
					acutyCheck.setSelected(false);
				   
		    	}else if(slitLampCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeSlitLampTeting", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeSlitLampTeting", null, Locale.US);
					
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
					
					EyeSlitLampTestingInputController eyeSlitLampTestingInputController =
				   (EyeSlitLampTestingInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeSlitLampTestingInputController.setExamEyeInputController(this);
					
					slitLampCheck.setSelected(false);
				   
		    	}else if(introcularPreureCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeIntraocularPressure", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeIntraocularPressure", null, Locale.US);
					
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
					
					EyeIntrocularPressureInputController eyeIntrocularPressureInputController=
				   (EyeIntrocularPressureInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeIntrocularPressureInputController.setExamEyeInputController(this);
					
					introcularPreureCheck.setSelected(false);
				   
		    	}else if(ophthalmoscopicCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeOphthalmoscopic", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeOphthalmoscopic", null, Locale.US);
					
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
					
					EyeOphthalmoscopicInputController eyeOphthalmoscopicInputController=
				   (EyeOphthalmoscopicInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeOphthalmoscopicInputController.setExamEyeInputController(this);
					
					ophthalmoscopicCheck.setSelected(false);
				   
		    	}else if(odCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeOD", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeOD", null, Locale.US);
					
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
					
					EyeOdInputController eyeOdInputController=
				   (EyeOdInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeOdInputController.setExamEyeInputController(this);
					
					odCheck.setSelected(false);
				   
		    	}else if(pupilsCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Conjunctivae are normal bilaterally.  Sclerae are normal. "
							+ " Pupils are midpoint, and normally reactive to light and accommodation.  "
							+ "Lids normal.");
					str = str1.toString();
					pupilsCheck.setSelected(false);
					setEyeUI();
					
					
				   
		    	}else if(lidsCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeConjunctieLids", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeConjunctieLids", null, Locale.US);
					
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
					
					EyeConjunctiveLidsInputController eyeConjunctiveLidsInputController =
				   (EyeConjunctiveLidsInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeConjunctiveLidsInputController.setExamEyeInputController(this);
					
					lidsCheck.setSelected(false);
				   
		    	}else if(lrisesCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeLrisesAndPupils", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeLrisesAndPupils", null, Locale.US);
					
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
					
					EyeLrisesPupilsInputController eyeLrisesPupilsInputController =
				   (EyeLrisesPupilsInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeLrisesPupilsInputController.setExamEyeInputController(this);
					
					lrisesCheck.setSelected(false);
				   
		    	}else if(ocularMotilityCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeOcularMotility", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeOcularMotility", null, Locale.US);
					
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
					
					EyeOcularMotilityInputController eyeOcularMotilityInputController =
				   (EyeOcularMotilityInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeOcularMotilityInputController.setExamEyeInputController(this);
					
					ocularMotilityCheck.setSelected(false);
				   
		    	}else if(correctedCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeVisualAcuityCorrexted", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeVisualAcuityCorrexted", null, Locale.US);
					
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
					
					EyeVisualAcuityCorrectInputController eyeVisualAcuityCorrectInputController =
				   (EyeVisualAcuityCorrectInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeVisualAcuityCorrectInputController.setExamEyeInputController(this);
					
					correctedCheck.setSelected(false);
				   
		    	}else if(uncorrectedCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeVisualAcuityUnCorrexted", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeVisualAcuityUnCorrexted", null, Locale.US);
					
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
					
					EyeVisualAcuityUncorrectInputController eyeVisualAcuityUncorrectInputController =
				   (EyeVisualAcuityUncorrectInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeVisualAcuityUncorrectInputController.setExamEyeInputController(this);
					
					uncorrectedCheck.setSelected(false);
				   
		    	}else if(visualFieldCheck.isSelected()){
		    		
		    		formCountIncrement();
		    		String formName = formPath.context.getMessage("ExamEyeVisualField", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ExamEyeVisualField", null, Locale.US);
					
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
					
					EyeViualFieldInputController eyeViualFieldInputController =
				   (EyeViualFieldInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					eyeViualFieldInputController.setExamEyeInputController(this);
					
					visualFieldCheck.setSelected(false);
				   
		    	}else if(conjunctivitiesCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Conjunctivae are normal on unaffected eye but injected on affected eye. "
							+ "Sclerae also injected on affected eye. Some mucus noted.  Some crusting noted on lashes."
							+ " Pupils are midpoint, and normally reactive to light and accommodation.  Lids are normal. "
							+ "Funduscopic exam reveals normal discs and vessels, "
							+ "no cataracts and no hemorrhages or exudates.");
					str = str1.toString();
					conjunctivitiesCheck.setSelected(false);
					setEyeUI();
					
					
				   
		    	}else if(bilateralCheck.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Conjunctivae are injected on both left and right eyes. Sclerae also "
							+ "injected. Some mucus noted.  Some crusting noted on lashes. Pupils are "
							+ "midpoint, and normally reactive to light and accommodation.  "
							+ "Lids are normal. Funduscopic exam reveals normal discs and vessels,"
							+ " no cataracts and no hemorrhages or exudates.");
					str = str1.toString();
					bilateralCheck.setSelected(false);
					setEyeUI();
					
					
				   
		    	}else if(foreignBodyExam.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Conjunctivae are slightly hyperemic.  Sclerae are injected.  "
							+ "Pupils are midpoint, and normally reactive to light and accommodation.  "
							+ "Lids were everted and foreign body was removed. Funduscopic exam reveals "
							+ "normal discs and vessels, no cataracts and no hemorrhages or exudates.");
					str = str1.toString();
					foreignBodyExam.setSelected(false);
					setEyeUI();
					
					
				   
		    	}else if(injuryConjExam.isSelected()){
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Inspection of the injured eye shows mild bulbar and palpebral "
							+ "conjunctivitis. The cornea is clear, using fluorescein stain. PERRL. "
							+ "Lids show no injury.");
					str = str1.toString();
					injuryConjExam.setSelected(false);
					setEyeUI();
					
					
				   
		    	}else if(injuryNormalExam.isSelected()){
		    		
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: The affected eye appears normal.  There is no bulbar or palpebral "
							+ "conjunctivitis.  The cornea is clear.  No corneal or contract title foreign "
							+ "bodies are noted.  PERRL.  EDM's full.");
					str = str1.toString();
					injuryNormalExam.setSelected(false);
					setEyeUI();
					
				   
		    	}else if(styeExam.isSelected()){
		    		
		    		
		    		StringBuilder str1 = new StringBuilder(str);
					str1.append("EYES: Stye noted. Conjunctivae are otherwise normal bilaterally.  "
							+ "Sclerae are normal.  Pupils are midpoint, and normally reactive to light "
							+ "and accommodation.  Lids are normal. Funduscopic exam reveals normal discs "
							+ "and vessels, no cataracts and no hemorrhages or exudates.");
					str = str1.toString();
					styeExam.setSelected(false);
					setEyeUI();
					
				   
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
			
			setEyeUI();
		
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
