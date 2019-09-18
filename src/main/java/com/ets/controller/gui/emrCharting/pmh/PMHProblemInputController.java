package com.ets.controller.gui.emrCharting.pmh;


/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 14-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PMHProblemInputController Class
 *Description: Problem.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.pmh.allergy.AllergyFreeTextController;
import com.ets.controller.gui.emrCharting.pmh.allergy.AspirinInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.BarbituratesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.CodeineInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.EggInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.FoodOrSubstanceInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.GluteninInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.ImmunizationInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.LatexAllergyInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.MMRVaccineInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.MedicationCategoryInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SelectMedicationInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.NarcoticAllergiesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PeanutInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PenicillinesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.QuinoloneAntibioticsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.ShellfishInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SulfaDrugsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.TetraCyclinesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.VaricellaVaccineInputController;
import com.ets.controller.gui.emrCharting.pmh.problem.ProblemFreeTextController;
import com.ets.controller.gui.emrCharting.problem.AddInputController;
import com.ets.controller.gui.emrCharting.problem.AlcoholismOrDependenceInputController;
import com.ets.controller.gui.emrCharting.problem.AnxietyInputController;
import com.ets.controller.gui.emrCharting.problem.AsthmaInputController;
import com.ets.controller.gui.emrCharting.problem.COPDInputController;
import com.ets.controller.gui.emrCharting.problem.CardiovascularInputController;
import com.ets.controller.gui.emrCharting.problem.DepressiveDisorderInputController;
import com.ets.controller.gui.emrCharting.problem.DiabetesInputController;
import com.ets.controller.gui.emrCharting.problem.EczemaInputController;
import com.ets.controller.gui.emrCharting.problem.EpilepsyInputController;
import com.ets.controller.gui.emrCharting.problem.GastrointestinalInputController;
import com.ets.controller.gui.emrCharting.problem.HepatitisInputController;
import com.ets.controller.gui.emrCharting.problem.HighCholestoterolInputController;
import com.ets.controller.gui.emrCharting.problem.HypertensionInputController;
import com.ets.controller.gui.emrCharting.problem.HyperthyroidismInputController;
import com.ets.controller.gui.emrCharting.problem.OtherConditionInputController;
import com.ets.controller.gui.emrCharting.problem.PneumoniaInputController;
import com.ets.controller.gui.emrCharting.problem.StrokeInputController;
import com.ets.controller.gui.emrCharting.problem.SubstanceAbuseInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHProblemInputController implements Initializable{
	
	  @FXML
	    private CheckBox NoKnownProblemsCheck;

	    @FXML
	    private CheckBox addCheck;

	    @FXML
	    private CheckBox AlcoholismCheck;

	    @FXML
	    private CheckBox AnxietyCheck;

	    @FXML
	    private CheckBox AsthmaCheck;

	    @FXML
	    private CheckBox CancerHistoryCheck;

	    @FXML
	    private CheckBox cardivascularCheck;

	    @FXML
	    private CheckBox StrokeCheck;

	    @FXML
	    private CheckBox depressiveCheck;

	    @FXML
	    private CheckBox substanceCheck;

	    @FXML
	    private CheckBox copdCheck;

	    @FXML
	    private CheckBox diabetesCheck;

	    @FXML
	    private CheckBox eczemaCheck;

	    @FXML
	    private CheckBox epilepsyCheck;

	    @FXML
	    private CheckBox hepatitisCheck;

	    @FXML
	    private CheckBox highCholestorolCheck;

	    @FXML
	    private CheckBox hypertensionCheck;

	    @FXML
	    private CheckBox HyperthyroidismCheck;

	    @FXML
	    private CheckBox GastrointestinalCheck;

	    @FXML
	    private CheckBox PneumoniaCheck;

	    @FXML
	    private CheckBox otherConditionCheck;

	    @FXML
	    private Button SkipButton;

	    @FXML
	    private Button DoneButton;
	    
	    @FXML
	    private Button  freeTextButton;
	    
	    private Button button;
	    
	    public GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
				Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}
		
		FXMLFormPath formPath = new FXMLFormPath();
		
		public static Integer formCount = 0;
		
		private Integer secondFormCount = 0;

		public static String str="\n\n";
		
		public static String strForFreeText = "";

		void formCountIncrement() {
			++secondFormCount;
		}
	    
	    public void setProblemUI(){
	    	
	    	 if (NoKnownProblemsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("");
				str = str1.toString();
				NoKnownProblemsCheck.setSelected(false);
				
				setProblemUI();

			} else if (addCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemAdd", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemAdd", null, Locale.US);

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

				AddInputController addInputController = (AddInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				addInputController.setpMHProblemInputController(this);

				addCheck.setSelected(false);

			} 
			 else if (AlcoholismCheck.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("PMHProblemAlcoholismOrDependence", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.PMHProblemAlcoholismOrDependence", null, Locale.US);

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

					AlcoholismOrDependenceInputController alcoholismOrDependenceInputController = (AlcoholismOrDependenceInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					alcoholismOrDependenceInputController.setpMHProblemInputController(this);

					AlcoholismCheck.setSelected(false);

				} 
			else if (AnxietyCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemAnxiety", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemAnxiety", null, Locale.US);

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

				AnxietyInputController anxietyInputController = (AnxietyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				anxietyInputController.setpMHProblemInputController(this);

				AnxietyCheck.setSelected(false);

			} else if (AsthmaCheck.isSelected()) {
				
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemAsthma", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemAsthma", null, Locale.US);

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

				AsthmaInputController asthmaInputController = (AsthmaInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				asthmaInputController.setpMHProblemInputController(this);

				AsthmaCheck.setSelected(false);

			} else if (cardivascularCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemCardiovascular", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemCardiovascular", null, Locale.US);

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

				CardiovascularInputController cardiovascularInputController = (CardiovascularInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				cardiovascularInputController.setpMHProblemInputController(this);

				cardivascularCheck.setSelected(false);

			} else if (copdCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemCopd", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemCopd", null, Locale.US);

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

				COPDInputController copdInputController = (COPDInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				copdInputController.setpMHProblemInputController(this);

				copdCheck.setSelected(false);

			} else if (depressiveCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemDepressiveDisorder", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemDepressiveDisorder", null, Locale.US);

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

				DepressiveDisorderInputController depressiveDisorderInputController = (DepressiveDisorderInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				depressiveDisorderInputController.setpMHProblemInputController(this);

				depressiveCheck.setSelected(false);

			}
			else if (diabetesCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemDiabetes", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemDiabetes", null, Locale.US);

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

				DiabetesInputController diabetesInputController = (DiabetesInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				diabetesInputController.setpMHProblemInputController(this);

				diabetesCheck.setSelected(false);

			}else if (eczemaCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemEczema", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemEczema", null, Locale.US);

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

				EczemaInputController eczemaInputController = (EczemaInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				eczemaInputController.setpMHProblemInputController(this);

				eczemaCheck.setSelected(false);

			}else if (epilepsyCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemEpilepsy", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemEpilepsy", null, Locale.US);

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

				EpilepsyInputController epilepsyInputController = (EpilepsyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				epilepsyInputController.setpMHProblemInputController(this);

				epilepsyCheck.setSelected(false);

			}else if (hepatitisCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemHepatitis", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemHepatitis", null, Locale.US);

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

				HepatitisInputController hepatitisInputController = (HepatitisInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hepatitisInputController.setpMHProblemInputController(this);

				hepatitisCheck.setSelected(false);

			}else if (highCholestorolCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemHighCholestoterol", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemHighCholestoterol", null, Locale.US);

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

				HighCholestoterolInputController highCholestoterolInputController = (HighCholestoterolInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				highCholestoterolInputController.setpMHProblemInputController(this);

				highCholestorolCheck.setSelected(false);

			}else if (hypertensionCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemHypertension", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemHypertension", null, Locale.US);

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

				HypertensionInputController hypertensionInputController = (HypertensionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hypertensionInputController.setpMHProblemInputController(this);

				hypertensionCheck.setSelected(false);

			}else if (HyperthyroidismCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemHyperthyroidism", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemHyperthyroidism", null, Locale.US);

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

				HyperthyroidismInputController hyperthyroidismInputController = (HyperthyroidismInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hyperthyroidismInputController.setpMHProblemInputController(this);

				HyperthyroidismCheck.setSelected(false);

			}else if (GastrointestinalCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemGastrointestinal", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemGastrointestinal", null, Locale.US);

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

				GastrointestinalInputController gastrointestinalInputController = (GastrointestinalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				gastrointestinalInputController.setpMHProblemInputController(this);

				GastrointestinalCheck.setSelected(false);

			}else if (PneumoniaCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemPneumonia", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemPneumonia", null, Locale.US);

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

				PneumoniaInputController pneumoniaInputController = (PneumoniaInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pneumoniaInputController.setpMHProblemInputController(this);

				PneumoniaCheck.setSelected(false);

			}else if (StrokeCheck.isSelected()) {
				
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemStroke", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemStroke", null, Locale.US);

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

				StrokeInputController strokeInputController = (StrokeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				strokeInputController.setpMHProblemInputController(this);

				StrokeCheck.setSelected(false);

			}else if (substanceCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemSubstanceAbuse", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemSubstanceAbuse", null, Locale.US);

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

				SubstanceAbuseInputController substanceAbuseInputController = (SubstanceAbuseInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				substanceAbuseInputController.setpMHProblemInputController(this);

				substanceCheck.setSelected(false);

			}else if (otherConditionCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHProblemOtherCondition", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHProblemOtherCondition", null, Locale.US);

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

				OtherConditionInputController otherConditionInputController = (OtherConditionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				otherConditionInputController.setpMHProblemInputController(this);

				otherConditionCheck.setSelected(false);

			}else if (secondFormCount == formCount) {

				genericEMRChartingController.paint(button);
				
				formCount = 0;
				genericEMRChartingController.setPmhTextArea(str);
				genericEMRChartingController.saveAllTextArea();
				new FXFormCommonUtilities().closeForm(DoneButton);

			}
	    	
	    	 
	    	 
	    	 
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		DoneButton.setOnAction((event)->
		{
			
			setProblemUI();
			
		
		});
		
		SkipButton.setOnAction((event)->
		{
			
			new FXFormCommonUtilities().closeForm(SkipButton);
		
		});
		
         freeTextButton.setOnAction((event) -> {
			
			

			if (NoKnownProblemsCheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("No Known Problems,");
				strForFreeText = str1.toString();
				NoKnownProblemsCheck.setSelected(false);

			}

			 if (addCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("add,");
				strForFreeText = str1.toString();
				addCheck.setSelected(false);
			}

			 if (AlcoholismCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Alcoholism,");
				strForFreeText = str1.toString();
				AlcoholismCheck.setSelected(false);
			}

			 if (AnxietyCheck.isSelected()) {
				 
				     StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Anxiety,");
					strForFreeText = str1.toString();
					AnxietyCheck.setSelected(false);
			}

			 if (AsthmaCheck.isSelected()) {
				 
				  StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Asthma,");
					strForFreeText = str1.toString();
					AsthmaCheck.setSelected(false);
			}

			 if (CancerHistoryCheck.isSelected()) {
				 
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Cancer History,");
					strForFreeText = str1.toString();
					CancerHistoryCheck.setSelected(false);
			}  
			 if (cardivascularCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("cardivascular,");
				strForFreeText = str1.toString();
				cardivascularCheck.setSelected(false);

			}

			 if (copdCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("copd,");
					strForFreeText = str1.toString();
					copdCheck.setSelected(false);


			}  if (depressiveCheck.isSelected()) {
				
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("depressive,");
					strForFreeText = str1.toString();
					depressiveCheck.setSelected(false);

			}  if (diabetesCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("diabetes,");
					strForFreeText = str1.toString();
					diabetesCheck.setSelected(false);

			}  if (eczemaCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("eczema,");
					strForFreeText = str1.toString();
					eczemaCheck.setSelected(false);

			}  if (epilepsyCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("epilepsy,");
					strForFreeText = str1.toString();
					epilepsyCheck.setSelected(false);

			}  

			 if (hepatitisCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("hepatitis,");
					strForFreeText = str1.toString();
					hepatitisCheck.setSelected(false);

			}  if (highCholestorolCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("high Cholestorol,");
					strForFreeText = str1.toString();
					highCholestorolCheck.setSelected(false);

			}  if (hypertensionCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("hypertension,");
					strForFreeText = str1.toString();
					hypertensionCheck.setSelected(false);

			}  if (HyperthyroidismCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Hyperthyroidism");
					strForFreeText = str1.toString();
					HyperthyroidismCheck.setSelected(false);

			}  if (GastrointestinalCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Gastrointestinal,");
					strForFreeText = str1.toString();
					GastrointestinalCheck.setSelected(false);

			}  if (PneumoniaCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Pneumonia,");
					strForFreeText = str1.toString();
					PneumoniaCheck.setSelected(false);

			}  if (StrokeCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Stroke,");
					strForFreeText = str1.toString();
					StrokeCheck.setSelected(false);

			}  if (substanceCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("substance,");
					strForFreeText = str1.toString();
					substanceCheck.setSelected(false);
			}
			 if (otherConditionCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("other condition,");
					strForFreeText = str1.toString();
					otherConditionCheck.setSelected(false);
			}
			
			String formName = formPath.context.getMessage("PMHProblemFreeText", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PMHProblemFreeText", null, Locale.US);
			
			
			ProblemFreeTextController problemFreeTextController = 
			(ProblemFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			formPath.closeApplicationContext();
			problemFreeTextController.setpMHProblemInputController(this);
						
			new FXFormCommonUtilities().closeForm(freeTextButton);
			
		});

	}

}
