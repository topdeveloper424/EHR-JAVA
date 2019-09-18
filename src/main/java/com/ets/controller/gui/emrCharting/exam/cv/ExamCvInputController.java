package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.resp.RespAssesmentEffortInputController;
import com.ets.controller.gui.emrCharting.exam.resp.RespChestPalpationInputController;
import com.ets.controller.gui.emrCharting.exam.resp.RespChestPercussionInputController;
import com.ets.controller.gui.emrCharting.exam.resp.RespExamCompMultiSysInputController;
import com.ets.controller.gui.emrCharting.exam.resp.RespLungAuscultationInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamCvInputController Class
 *Description: HeartExamComprehensiveSingleSystem GUI Controller class
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
public class ExamCvInputController implements Initializable {

	@FXML
	private CheckBox allNormalCheckBox;

	@FXML
	private CheckBox heartAllNormalMultiSyst;

	@FXML
	private CheckBox HeartExamComprehensiveMultisyst;

	@FXML
	private CheckBox heartAusculation;

	@FXML
	private CheckBox arteriesExamComprehensive;

	@FXML
	private CheckBox heartPalpation;

	@FXML
	private CheckBox arteriesAorta;

	@FXML
	private CheckBox arteriesCarotids;

	@FXML
	private CheckBox arteriesExtremities;

	@FXML
	private CheckBox arteriesFemoral;

	@FXML
	private CheckBox arteriesPedalPulses;

	@FXML
	private CheckBox arteriesChestWallPain;

	@FXML
	private CheckBox arteriesAllComprehensive;

	@FXML
	private CheckBox HeartExamComprehensiveSingleSyst;

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

	public String str = "\n\nCARDIOVASCULAR: ";

	void formCountIncrement() {
		++secondFormCount;
	}

	public void setCvUI() {

		if (allNormalCheckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append(
					"The patient's heart examined for regular rate and rhythm and presence of murmurs. Note taken of any tachycardia,"
							+ " bradycardia or any irregular rhythm.  No abnormal findings.  Carotid arteries, aorta, femoral pusles, pedal pulses "
							+ "are normal, and no edema or varicosities are noted.  Jugular venous distension not noted.");
			str = str1.toString();
			allNormalCheckBox.setSelected(false);
			setCvUI();
		} else if (heartAllNormalMultiSyst.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append(
					"\n\nCV reveals regular rhythm without murmur, and no S3 or rub.  Apical impulse is normal. Carotid arteries, aorta, "
							+ "femoral pulses, pedal pulses are normal, and no edema or varicosities are noted.  Jugular venous distension not noted.");
			str = str1.toString();
			heartAllNormalMultiSyst.setSelected(false);
			setCvUI();
		}

		else if (HeartExamComprehensiveMultisyst.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVHeartExamCompMultiSys", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVHeartExamCompMultiSys", null, Locale.US);
			formPath.closeApplicationContext();

			CvHeartExamCompMultiSysInputController heartExamCompMultiSysInputController = (CvHeartExamCompMultiSysInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			heartExamCompMultiSysInputController.setExamCvInputController(this);
			HeartExamComprehensiveMultisyst.setSelected(false);

		}

		else if (HeartExamComprehensiveSingleSyst.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVHeartExamCompSingleSys", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVHeartExamCompSingleSys", null, Locale.US);
			formPath.closeApplicationContext();

			CvHeartExamCompSingleSysInputController heartExamCompSingleSysInputController = (CvHeartExamCompSingleSysInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			heartExamCompSingleSysInputController.setExamCvInputController(this);
			HeartExamComprehensiveSingleSyst.setSelected(false);

		} else if (arteriesAllComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append(
					"Carotid arteries, aorta, femoral pulses, pedal pulses are normal, and no edema or varicosities are noted.  "
							+ "Jugular venous distension not noted.");
			str = str1.toString();
			arteriesAllComprehensive.setSelected(false);
			setCvUI();

		} else if (arteriesExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVArteriesExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVArteriesExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			CvArteriesExamCompInputController arteriesExamCompInputController = (CvArteriesExamCompInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			arteriesExamCompInputController.setExamCvInputController(this);
			arteriesExamComprehensive.setSelected(false);

		} else if (heartAusculation.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVHeartAuscultation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVHeartAuscultation", null, Locale.US);
			formPath.closeApplicationContext();

			CvHeartAuscultationInputController heartAuscultationInputController = (CvHeartAuscultationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			heartAuscultationInputController.setExamCvInputController(this);
			heartAusculation.setSelected(false);

		} else if (heartPalpation.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVHeartPalpation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVHeartPalpation", null, Locale.US);
			formPath.closeApplicationContext();

			CvHeartPulpationInputController heartPulpationInputController = (CvHeartPulpationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			heartPulpationInputController.setExamCvInputController(this);
			heartPalpation.setSelected(false);

		} else if (arteriesAorta.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVArteriesAorta", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVArteriesAorta", null, Locale.US);
			formPath.closeApplicationContext();

			CvArteriesAortaInputController arteriesAortaInputController = (CvArteriesAortaInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			arteriesAortaInputController.setExamCvInputController(this);
			arteriesAorta.setSelected(false);

		} else if (arteriesCarotids.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVArteriesCarotids", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVArteriesCarotids", null, Locale.US);
			formPath.closeApplicationContext();

			CvArteriesCarotidsInputController carotidsInputController = (CvArteriesCarotidsInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			carotidsInputController.setExamCvInputController(this);
			arteriesCarotids.setSelected(false);

		} else if (arteriesExtremities.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVArteriesExtremities", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVArteriesExtremities", null, Locale.US);
			formPath.closeApplicationContext();

			CvArteriesExtremitiesInputController arteriesExtremitiesInputController = (CvArteriesExtremitiesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			arteriesExtremitiesInputController.setExamCvInputController(this);
			arteriesExtremities.setSelected(false);

		} else if (arteriesFemoral.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVFemoralPulses", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVFemoralPulses", null, Locale.US);
			formPath.closeApplicationContext();

			CvFemoralPulsesInputController femoralPulsesInputController = (CvFemoralPulsesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			femoralPulsesInputController.setExamCvInputController(this);
			arteriesFemoral.setSelected(false);

		} else if (arteriesPedalPulses.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("CVArteriesPedal", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.CVArteriesPedal", null, Locale.US);
			formPath.closeApplicationContext();

			CvArteriesPedalInputController arteriesPedalInputController = (CvArteriesPedalInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			arteriesPedalInputController.setExamCvInputController(this);
			arteriesPedalPulses.setSelected(false);

		} else if (arteriesChestWallPain.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append(
					"CARDIOVASCULAR: CV reveals regular rhythm without murmur, and no S3 or rub.  Apical impulse is normal. "
							+ "Carotid arteries, aorta, femoral pulses, pedal pulses are normal, and no edema or varicosities are noted. "
							+ "Palpation of chest wall or deep inspiration reproduces pain. Jugular venous distension not noted.");
			str = str1.toString();
			arteriesChestWallPain.setSelected(false);
			setCvUI();

		} else if (secondFormCount == formCount) {

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
			
			setCvUI();
		
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
