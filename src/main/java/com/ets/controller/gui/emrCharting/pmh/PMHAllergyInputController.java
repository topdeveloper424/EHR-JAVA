package com.ets.controller.gui.emrCharting.pmh;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PMHAllergyInputController Class
 *Description: Allergy.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.exam.neuro.cordinationBalance.NeuroCordinationBalanceInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNerves.NeuroCranialNervesInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesAlternate.NeuroCranialNervesAlternaInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesEval.CranialNervesEvalInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.fundKnowledge.NeuroFundKnowledgeInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.higherFunction.NeuroHigherFunctionInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.knowledgeAttention.NeuroKnowledgeAttentionInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.langSpeech.NeuroLanguageSpeechInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.reflexes.NeuroReflexesInpurController;
import com.ets.controller.gui.emrCharting.exam.neuro.sensReflexCoord.ReflexesSensCoordInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.sensation.NeuroSensationInputController;
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
import com.ets.controller.gui.emrCharting.result.labTest.AccucheckInstantBloodInputController;
import com.ets.controller.gui.emrCharting.result.labTest.CMPPiccoloInputController;
import com.ets.controller.gui.emrCharting.result.labTest.ExecutivePhysicalLaboratoryInputController;
import com.ets.controller.gui.medicationClass.MedicationClassInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHAllergyInputController implements Initializable {

	@FXML
	private CheckBox NKDACheck;

	@FXML
	private CheckBox NKACheck;

	@FXML
	private CheckBox DrugAllergiesChek;

	@FXML
	private CheckBox AspirinCheck;

	@FXML
	private CheckBox BarbituratesCheck;

	@FXML
	private CheckBox CodeineCheck;

	@FXML
	private CheckBox NarcoticCheck;

	@FXML
	private CheckBox PenicillinsCheck;

	@FXML
	private CheckBox SelectAnyMedicationCategoryCheck;

	@FXML
	private CheckBox SulfaCheck;

	@FXML
	private CheckBox GluteninCheck;

	@FXML
	private CheckBox QuinoloneCheck;

	@FXML
	private CheckBox TetracyclinesCheck;

	@FXML
	private CheckBox SelectAnyMedicationCheck;

	@FXML
	private CheckBox ShellfishCheck;

	@FXML
	private CheckBox PeanutCheck;

	@FXML
	private CheckBox EggCheck;

	@FXML
	private CheckBox SelectAnyFoodorSubstanceCheck;

	@FXML
	private CheckBox MMRCheck;

	@FXML
	private CheckBox VaricellaCheck;

	@FXML
	private CheckBox ImmunizationCheck;

	@FXML
	private CheckBox LatexCheck;

	@FXML
	private CheckBox SelectOtherAllergyCheck;

	@FXML
	private Button SkipButton;

	@FXML
	private Button freeTextButton;

	@FXML
	private Button DoneButton;

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

	public static String str = "\n\n";
	public static String strForFreeText = "";

	void formCountIncrement() {
		++secondFormCount;
	}

	public void setAllergyUI() {

		if (NKDACheck.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient claims to have no known drug allergies or adverse reactions");
			str = str1.toString();
			NKDACheck.setSelected(false);
			setAllergyUI();
		}

		else if (NKACheck.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient claims to have no known allergies.");
			str = str1.toString();
			NKACheck.setSelected(false);

			setAllergyUI();

		} else if (AspirinCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyAspirin", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyAspirin", null, Locale.US);

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

			AspirinInputController aspirinInputController = (AspirinInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			aspirinInputController.setpMHAllergyInputController(this);

			AspirinCheck.setSelected(false);

		} else if (BarbituratesCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyBarbiturates", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyBarbiturates", null, Locale.US);

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

			BarbituratesInputController barbituratesInputController = (BarbituratesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			barbituratesInputController.setpMHAllergyInputController(this);

			BarbituratesCheck.setSelected(false);

		} else if (CodeineCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyCodeine", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyCodeine", null, Locale.US);

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

			CodeineInputController codeineInputController = (CodeineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			codeineInputController.setpMHAllergyInputController(this);

			CodeineCheck.setSelected(false);

		} else if (NarcoticCheck.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyNarcoticAllergies", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyNarcoticAllergies", null, Locale.US);

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

			NarcoticAllergiesInputController narcoticAllergiesInputController = (NarcoticAllergiesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			narcoticAllergiesInputController.setpMHAllergyInputController(this);

			NarcoticCheck.setSelected(false);

		} else if (PenicillinsCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyPenicillines", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyPenicillines", null, Locale.US);

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

			PenicillinesInputController penicillinesInputController = (PenicillinesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			penicillinesInputController.setpMHAllergyInputController(this);

			PenicillinsCheck.setSelected(false);

		} else if (QuinoloneCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyQuinoloneAntibiotics", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyQuinoloneAntibiotics", null, Locale.US);

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

			QuinoloneAntibioticsInputController quinoloneAntibioticsInputController = (QuinoloneAntibioticsInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			quinoloneAntibioticsInputController.setpMHAllergyInputController(this);

			QuinoloneCheck.setSelected(false);

		} else if (SulfaCheck.isSelected()) {
			formCountIncrement();
			/*if (SulfaCheck.get() != null) {
				if (SulfaCheck.get().equals("true")) {
					.setSelected(true);

				}*/

			//SulfaCheck.set
			String formName = formPath.context.getMessage("PMHAllergySulfaDrugs", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergySulfaDrugs", null, Locale.US);

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

			SulfaDrugsInputController neuroFundKnowledgeInputController = (SulfaDrugsInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroFundKnowledgeInputController.setpMHAllergyInputController(this);

			SulfaCheck.setSelected(false);

		} else if (TetracyclinesCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyTetraCyclines", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyTetraCyclines", null, Locale.US);

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

			TetraCyclinesInputController tetraCyclinesInputController = (TetraCyclinesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			tetraCyclinesInputController.setpMHAllergyInputController(this);

			TetracyclinesCheck.setSelected(false);

		} else if (SelectAnyMedicationCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyMedication", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyMedication", null, Locale.US);

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

			SelectMedicationInputController medicationInputController = (SelectMedicationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			medicationInputController.setpMHAllergyInputController(this);

			SelectAnyMedicationCheck.setSelected(false);

		} else if (SelectAnyMedicationCategoryCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyMedicationCategory", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyMedicationCategory", null, Locale.US);

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

			MedicationCategoryInputController medicationCategoryInputController = (MedicationCategoryInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			medicationCategoryInputController.setpMHAllergyInputController(this);

			SelectAnyMedicationCategoryCheck.setSelected(false);

		} else if (EggCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyEgg", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyEgg", null, Locale.US);

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

			EggInputController eggInputController = (EggInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			eggInputController.setpMHAllergyInputController(this);

			EggCheck.setSelected(false);

		} else if (GluteninCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyglutenin", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyglutenin", null, Locale.US);

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

			GluteninInputController gluteninInputController = (GluteninInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			gluteninInputController.setpMHAllergyInputController(this);

			GluteninCheck.setSelected(false);

		} else if (PeanutCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyPeanut", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyPeanut", null, Locale.US);

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

			PeanutInputController peanutInputController = (PeanutInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			peanutInputController.setpMHAllergyInputController(this);

			PeanutCheck.setSelected(false);

		} else if (ShellfishCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyShellfish", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyShellfish", null, Locale.US);

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

			ShellfishInputController shellfishInputController = (ShellfishInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shellfishInputController.setpMHAllergyInputController(this);

			ShellfishCheck.setSelected(false);

		} else if (SelectAnyFoodorSubstanceCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyFoodOrSubstance", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyFoodOrSubstance", null, Locale.US);

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

			FoodOrSubstanceInputController foodOrSubstanceInputController = (FoodOrSubstanceInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			foodOrSubstanceInputController.setpMHAllergyInputController(this);

			SelectAnyFoodorSubstanceCheck.setSelected(false);

		} else if (MMRCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyMMRVaccine", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyMMRVaccine", null, Locale.US);

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

			MMRVaccineInputController mmrVaccineInputController = (MMRVaccineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			mmrVaccineInputController.setpMHAllergyInputController(this);

			MMRCheck.setSelected(false);

		} else if (VaricellaCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyVaricellaVaccine", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyVaricellaVaccine", null, Locale.US);

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

			VaricellaVaccineInputController varicellaVaccineInputController = (VaricellaVaccineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			varicellaVaccineInputController.setpMHAllergyInputController(this);

			VaricellaCheck.setSelected(false);

		} else if (ImmunizationCheck.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyImmunization", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyImmunization", null, Locale.US);

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

			ImmunizationInputController immunizationInputController = (ImmunizationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			immunizationInputController.setpMHAllergyInputController(this);

			ImmunizationCheck.setSelected(false);

		} else if (LatexCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAllergyLatexAllergy", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAllergyLatexAllergy", null, Locale.US);

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

			LatexAllergyInputController latexAllergyInputController = (LatexAllergyInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			latexAllergyInputController.setpMHAllergyInputController(this);

			LatexCheck.setSelected(false);

		} else if (secondFormCount == formCount) {
			genericEMRChartingController.paint(button);
			formCount = 0;
			genericEMRChartingController.setPmhTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(DoneButton);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		DoneButton.setOnAction((event) -> {

			setAllergyUI();

		});

		freeTextButton.setOnAction((event) -> {
			
			

			if (NKDACheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("NKDA,");
				strForFreeText = str1.toString();
				NKDACheck.setSelected(false);

			}

			 if (NKACheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("NKA,");
				strForFreeText = str1.toString();
				NKACheck.setSelected(false);
			}

			 if (AspirinCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Aspirin,");
				strForFreeText = str1.toString();
				AspirinCheck.setSelected(false);
			}

			 if (BarbituratesCheck.isSelected()) {
				 
				     StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Barbiturates,");
					strForFreeText = str1.toString();
					BarbituratesCheck.setSelected(false);
			}

			 if (CodeineCheck.isSelected()) {
				 
				  StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Codeine,");
					strForFreeText = str1.toString();
					CodeineCheck.setSelected(false);
			}

			 if (NarcoticCheck.isSelected()) {
				 
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Narcotic,");
					strForFreeText = str1.toString();
					NarcoticCheck.setSelected(false);
			}  if (PenicillinsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Penicillins,");
				strForFreeText = str1.toString();
				PenicillinsCheck.setSelected(false);

			}

			 if (QuinoloneCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Quinolone,");
					strForFreeText = str1.toString();
					QuinoloneCheck.setSelected(false);


			}  if (SulfaCheck.isSelected()) {
				
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Sulfa,");
					strForFreeText = str1.toString();
					SulfaCheck.setSelected(false);

			}  if (TetracyclinesCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Tetracyclines,");
					strForFreeText = str1.toString();
					TetracyclinesCheck.setSelected(false);

			}  if (SelectAnyMedicationCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("SelectAnyMedication,");
					strForFreeText = str1.toString();
					SelectAnyMedicationCheck.setSelected(false);

			}  if (SelectAnyMedicationCategoryCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("SelectAnyMedicationCategory,");
					strForFreeText = str1.toString();
					SelectAnyMedicationCategoryCheck.setSelected(false);

			}  if (EggCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Egg,");
					strForFreeText = str1.toString();
					EggCheck.setSelected(false);

			}

			 if (GluteninCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Glutenin,");
					strForFreeText = str1.toString();
					GluteninCheck.setSelected(false);

			}  if (PeanutCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Peanut,");
					strForFreeText = str1.toString();
					PeanutCheck.setSelected(false);

			}  if (ShellfishCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Shellfish,");
					strForFreeText = str1.toString();
					ShellfishCheck.setSelected(false);

			}  if (SelectAnyFoodorSubstanceCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("SelectAnyFoodorSubstance");
					strForFreeText = str1.toString();
					SelectAnyFoodorSubstanceCheck.setSelected(false);

			}  if (MMRCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("MMR,");
					strForFreeText = str1.toString();
					MMRCheck.setSelected(false);

			}  if (VaricellaCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Varicella,");
					strForFreeText = str1.toString();
					VaricellaCheck.setSelected(false);

			}  if (ImmunizationCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Immunization,");
					strForFreeText = str1.toString();
					ImmunizationCheck.setSelected(false);

			}  if (LatexCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Latex,");
					strForFreeText = str1.toString();
					LatexCheck.setSelected(false);
			}

			
			String formName = formPath.context.getMessage("PMHAllergyFreeText", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PMHAllergyFreeText", null, Locale.US);
			
			
			AllergyFreeTextController allergyFreeTextController = 
			(AllergyFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			formPath.closeApplicationContext();
			allergyFreeTextController.setpMHAllergyInputController(this);
						
			new FXFormCommonUtilities().closeForm(freeTextButton);
			
		});

		SkipButton.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(SkipButton);

		});

	}

}
