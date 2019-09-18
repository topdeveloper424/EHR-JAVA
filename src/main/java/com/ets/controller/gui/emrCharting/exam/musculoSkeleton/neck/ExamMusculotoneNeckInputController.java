package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneNeckInputController Class
 *Description: MusculoNeck.fxml Controller class
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
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesAortaInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesCarotidsInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesExamCompInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesExtremitiesInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesPedalInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvFemoralPulsesInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartAuscultationInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartExamCompMultiSysInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartExamCompSingleSysInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartPulpationInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ExamMusculotoneNeckInputController implements Initializable {
	
	@FXML
    private CheckBox NeckallNormalComprehensive;

    @FXML
    private CheckBox neckexamComprehensive;

    @FXML
    private CheckBox neckRomSpine;

    @FXML
    private CheckBox neckMsDTR;

    @FXML
    private CheckBox neckdistraction;

    @FXML
    private CheckBox neckCompression;

    @FXML
    private CheckBox neckRepeatedMovement;

    @FXML
    private CheckBox neckVertbral;

    @FXML
    private CheckBox neckStrainAllNormal;

    @FXML
    private CheckBox neckStrainImproving;

    @FXML
    private CheckBox neckSignificant;

    @FXML
    private CheckBox cervicalMildSpasm;

    @FXML
    private CheckBox cervicalMildTenderness;

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

	public String str="\n\n ";

	void formCountIncrement() {
		++secondFormCount;
	}
	
	
	public void setNeckUI() {

		if (NeckallNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of the neck shows no skin abnormalities or tenderness. Neck is supple with full range of motion.");
			str = str1.toString();
			NeckallNormalComprehensive.setSelected(false);
			setNeckUI();
		}else if (neckexamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckExamComprehensive", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckExamComprehensive", null, Locale.US);
			formPath.closeApplicationContext();

			NeckExamComprehensiveInputController neckExamComprehensiveInputController = (NeckExamComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckExamComprehensiveInputController.setExamMusculotoneNeckInputController(this);
			neckexamComprehensive.setSelected(false);

		}

		else if (neckRomSpine.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckRomSpine", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckRomSpine", null, Locale.US);
			formPath.closeApplicationContext();

			NeckRomSpineInputController neckRomSpineInputController = (NeckRomSpineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckRomSpineInputController.setExamMusculotoneNeckInputController(this);
			neckRomSpine.setSelected(false);

		}else if (neckMsDTR.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckDtr", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckDtr", null, Locale.US);
			formPath.closeApplicationContext();

			NeckDtrInputController neckDtrInputController = (NeckDtrInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckDtrInputController.setExamMusculotoneNeckInputController(this);
			neckMsDTR.setSelected(false);

		} else if (neckCompression.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckExamCompression", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckExamCompression", null, Locale.US);
			formPath.closeApplicationContext();

			NeckCompressionInputController neckCompressionInputController = (NeckCompressionInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckCompressionInputController.setExamMusculotoneNeckInputController(this);
			neckCompression.setSelected(false);

		} else if (neckdistraction.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckDistruction", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckDistruction", null, Locale.US);
			formPath.closeApplicationContext();

			NeckDistractionInputController neckDistractionInputController = (NeckDistractionInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckDistractionInputController.setExamMusculotoneNeckInputController(this);
			neckdistraction.setSelected(false);

		} else if (neckRepeatedMovement.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckRepeatedMovement", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckRepeatedMovement", null, Locale.US);
			formPath.closeApplicationContext();

			NeckRepeatedMovementInputController neckRepeatedMovementInputController = (NeckRepeatedMovementInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckRepeatedMovementInputController.setExamMusculotoneNeckInputController(this);
			neckRepeatedMovement.setSelected(false);

		} else if (neckVertbral.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckVertibralArtery", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckVertibralArtery", null, Locale.US);
			formPath.closeApplicationContext();

			NeckVertibralArteryInputController neckVertibralArteryInputController = (NeckVertibralArteryInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckVertibralArteryInputController.setExamMusculotoneNeckInputController(this);
			neckVertbral.setSelected(false);

		} else if (neckStrainAllNormal.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nMusculoskeletal examination of the neck shows neck to be supple with no spasm of the"
					+ " paraspinals and trapezius. No irregularities or crepitus. Range of motion is full. Shoulder shrug normal.");
			str = str1.toString();
			neckStrainAllNormal.setSelected(false);
			setNeckUI();

		}else if (neckStrainImproving.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nMusculoskeletal examination of the neck showed less spasm of the paraspinals and trapezius. Range of motion"
					+ " is better if done slowly, and only slightly tender at the extremes. Shoulder shrug normal.");
			str = str1.toString();
			neckStrainImproving.setSelected(false);
			setNeckUI();

		} else if (neckSignificant.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nMusculoskeletal examination of the neck reveals significant spasm of the paraspinals and trapezius,"
					+ " but no irregularities or crepitus. Range of motion is limited due to guarding, and the patient seems to "
					+ "move the upper torso as a single unit.");
			str = str1.toString();
			neckSignificant.setSelected(false);
			setNeckUI();

		} else if (cervicalMildSpasm.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonNeckCervicalMildSpasm", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeckCervicalMildSpasm", null, Locale.US);
			formPath.closeApplicationContext();

			NeckCervicalMildSpasmInputController neckCervicalMildSpasmInputController = (NeckCervicalMildSpasmInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckCervicalMildSpasmInputController.setExamMusculotoneNeckInputController(this);
			cervicalMildSpasm.setSelected(false);

		} else if (cervicalMildTenderness.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nThe spine has a normal lordosis, Forward flexion and extension, as well as bilateral bending are normal."
					+ " There is mild tenderness palpating over the cervical spine and paravertebral muscles. No muscle spasm is noted.");
			str = str1.toString();
			cervicalMildTenderness.setSelected(false);
			setNeckUI();

		}  else if (secondFormCount == formCount) {

			genericEMRChartingController.paint(button);
			genericEMRChartingController.hideCheckBox(checkBox);
			new FXFormCommonUtilities().closeForm(doneBtn);
			formCount = 0;
			genericEMRChartingController.setExamOrganTextArea(str);
			genericEMRChartingController.saveAllTextArea();

		}

	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event)->
		{
			
			setNeckUI();
		
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
