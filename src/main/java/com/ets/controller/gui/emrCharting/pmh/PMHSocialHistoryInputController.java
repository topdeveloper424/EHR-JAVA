package com.ets.controller.gui.emrCharting.pmh;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PMHSocialHistoryInputController Class
 *Description: SocialHistory.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.pmh.allergy.GluteninInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.MedicationCategoryInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SelectMedicationInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.NarcoticAllergiesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PeanutInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PenicillinesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.QuinoloneAntibioticsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.ShellfishInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SulfaDrugsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.TetraCyclinesInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.DrugUseClaimedInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.ExcriseInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.LeisureTimeHobbiesInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.PMHAlcoholInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.PMHSmokingInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.SocialHistoryBriefInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.SocialHistoryFreeTextController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.LeisureTimeUseInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.LivingSituationInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PMHSocialHistoryInputController implements Initializable {

	@FXML
	private CheckBox NoSocialHistoryCheck;

	@FXML
	private CheckBox AlcoholUseCheck;

	@FXML
	private CheckBox SmokingCheck;

	@FXML
	private CheckBox SocialHistoryCheck;

	@FXML
	private CheckBox DrugUseClaimedCheck;

	@FXML
	private CheckBox DrugUseDeniedCheck;

	@FXML
	private CheckBox SeatBeltRoutinelyCheck;

	@FXML
	private CheckBox LeisureTimeHobbiesCheck;

	@FXML
	private CheckBox SeatBeltCheck;

	@FXML
	private CheckBox ExerciseCheck;

	@FXML
	private CheckBox LeisureTimeUseCheck;

	@FXML
	private CheckBox LivingSituationCheck;

	@FXML
	private Button SkipButton;

	@FXML
	private Button DoneButton;

	private Button button;
	
	@FXML
	private Button freeTextButton;

	public GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	public static String str = "\n\nSOCIAL HISTORY";
	
	public static String strForFreeText = "";
	public static Integer formCount = 0;

	private Integer secondFormCount = 0;

	void formCountIncrement() {
		++secondFormCount;
	}

	public void setSocialHistoryUI() {

		if (NoSocialHistoryCheck.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("SOCIAL HISTORY:  No negative social history.");
			str = str1.toString();
			NoSocialHistoryCheck.setSelected(false);
			setSocialHistoryUI();

		} else if (AlcoholUseCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHAlcohol", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHAlcohol", null, Locale.US);

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

			PMHAlcoholInputController pmhAlcoholInputController = (PMHAlcoholInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			pmhAlcoholInputController.setPmhSocialHistoryInputController(this);

			AlcoholUseCheck.setSelected(false);

		} else if (SmokingCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHSmoker", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHSmoker", null, Locale.US);

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

			PMHSmokingInputController pmhSmokingInputController = (PMHSmokingInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			pmhSmokingInputController.setPmhSocialHistoryInputController(this);

			SmokingCheck.setSelected(false);

		} else if (SocialHistoryCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHSocialHistoryBrief", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHSocialHistoryBrief", null, Locale.US);

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

			SocialHistoryBriefInputController socialHistoryBriefInputController = (SocialHistoryBriefInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			socialHistoryBriefInputController.setPmhSocialHistoryInputController(this);

			SocialHistoryCheck.setSelected(false);

		} else if (DrugUseClaimedCheck.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PMHDrugUseClaimed", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHDrugUseClaimed", null, Locale.US);

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

			DrugUseClaimedInputController drugUseClaimedInputController = (DrugUseClaimedInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			drugUseClaimedInputController.setpMHSocialHistoryInputController(this);

			DrugUseClaimedCheck.setSelected(false);

		} else if (DrugUseDeniedCheck.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append(" Patient claims no drug use. ");
			str = str1.toString();

			DrugUseDeniedCheck.setSelected(false);
			setSocialHistoryUI();

		} else if (ExerciseCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHExcrise", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHExcrise", null, Locale.US);

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

			ExcriseInputController quinoloneAntibioticsInputController = (ExcriseInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			quinoloneAntibioticsInputController.setpMHSocialHistoryInputController(this);

			ExerciseCheck.setSelected(false);

		} else if (LeisureTimeHobbiesCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHLeisureTimeHobbies", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHLeisureTimeHobbies", null, Locale.US);

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

			LeisureTimeHobbiesInputController leisureTimeHobbiesInputController = (LeisureTimeHobbiesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			leisureTimeHobbiesInputController.setpMHSocialHistoryInputController(this);

			LeisureTimeHobbiesCheck.setSelected(false);

		} else if (LeisureTimeUseCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHLeisureTimeUse", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHLeisureTimeUse", null, Locale.US);

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

			LeisureTimeUseInputController leisureTimeUseInputController = (LeisureTimeUseInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			leisureTimeUseInputController.setpMHSocialHistoryInputController(this);

			LeisureTimeUseCheck.setSelected(false);

		} else if (LivingSituationCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHLivingSituation", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHLivingSituation", null, Locale.US);

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

			LivingSituationInputController livingSituationInputController = (LivingSituationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			livingSituationInputController.setpMHSocialHistoryInputController(this);

			LivingSituationCheck.setSelected(false);

		} else if (SeatBeltRoutinelyCheck.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient routinely wears a seatbelt.");
			str = str1.toString();
			SeatBeltRoutinelyCheck.setSelected(false);

			setSocialHistoryUI();

		} else if (SeatBeltCheck.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient does not routinely wear a seatbelt.");
			str = str1.toString();
			SeatBeltCheck.setSelected(false);

			setSocialHistoryUI();

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

		// setSocialHistory();

		DoneButton.setOnAction((event) -> {
			setSocialHistoryUI();
			new FXFormCommonUtilities().closeForm(DoneButton);
			/*
			 * if(AlcoholUseCheck.isSelected()){ try{ String
			 * fmName=formPath.context.getMessage("PMHAlcohol", null,
			 * Locale.US); String
			 * fmTitle=formPath.context.getMessage("PMHAlcohol", null,
			 * Locale.US); formPath.closeApplicationContext(); new
			 * FXFormCommonUtilities().displayForm(fmName, fmTitle);
			 * AlcoholUseCheck.setSelected(false);
			 * 
			 * }catch(Exception e){
			 * 
			 * e.printStackTrace(); } }
			 * genericEMRChartingController.setPmhTextArea(
			 * PMHSocialHistoryInputController.str);
			 */

			// genericEMRChartingController.setHpiTextArea(PMHSocialHistoryInputController.str);
			// new FXFormCommonUtilities().closeForm(DoneButton);

		});
		
              freeTextButton.setOnAction((event) -> {
			
			

			if (NoSocialHistoryCheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("No Social History,");
				strForFreeText = str1.toString();
				NoSocialHistoryCheck.setSelected(false);

			}

			 if (AlcoholUseCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Alcohol Use");
				strForFreeText = str1.toString();
				AlcoholUseCheck.setSelected(false);
			}

			 if (SmokingCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Smoking,");
				strForFreeText = str1.toString();
				SmokingCheck.setSelected(false);
			}

			 if (SocialHistoryCheck.isSelected()) {
				 
				     StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Social History,");
					strForFreeText = str1.toString();
					SocialHistoryCheck.setSelected(false);
			}

			 if (DrugUseClaimedCheck.isSelected()) {
				 
				  StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Drug Use Claimed,");
					strForFreeText = str1.toString();
					DrugUseClaimedCheck.setSelected(false);
			}

			 if (DrugUseDeniedCheck.isSelected()) {
				 
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Drug Use Denied,");
					strForFreeText = str1.toString();
					DrugUseDeniedCheck.setSelected(false);
			} 
			 if (ExerciseCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Exercise,");
				strForFreeText = str1.toString();
				ExerciseCheck.setSelected(false);

			}

			 if (LeisureTimeHobbiesCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Leisure Time Hobbies,");
					strForFreeText = str1.toString();
					LeisureTimeHobbiesCheck.setSelected(false);


			}  if (LeisureTimeUseCheck.isSelected()) {
				
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Leisure Time Use,");
					strForFreeText = str1.toString();
					LeisureTimeUseCheck.setSelected(false);

			}  if (LivingSituationCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Living Situation,");
					strForFreeText = str1.toString();
					LivingSituationCheck.setSelected(false);

			}  if (SeatBeltRoutinelyCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Seat Belt Routinely,");
					strForFreeText = str1.toString();
					SeatBeltRoutinelyCheck.setSelected(false);

			}  if (SeatBeltCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Seat Belt,");
					strForFreeText = str1.toString();
					SeatBeltCheck.setSelected(false);

			}  

			
			String formName = formPath.context.getMessage("PMHSocialHistoryFreeText", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PMHSocialHistoryFreeText", null, Locale.US);
			
			
			SocialHistoryFreeTextController socialHistoryFreeTextController = 
			(SocialHistoryFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			formPath.closeApplicationContext();
			socialHistoryFreeTextController.setpMHSocialHistoryInputController(this);
						
			new FXFormCommonUtilities().closeForm(freeTextButton);
			
		});
		SkipButton.setOnAction((event) -> {
			
			new FXFormCommonUtilities().closeForm(SkipButton);

		});

	}

}
