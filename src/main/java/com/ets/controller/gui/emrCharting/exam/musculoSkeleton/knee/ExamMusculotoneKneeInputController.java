package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.knee;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 13-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckExamComprehensiveInputController Class
 *Description: neck.fxml Controller class
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
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ShoulderComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ShoulderRomLeftInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ShoulderRomRightnputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ShoulderSpecialTestLeftInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ShoulderSpecialTestRightInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamMusculotoneKneeInputController implements Initializable{
	
	@FXML
    private CheckBox KneeallNormalComprehensive;

    @FXML
    private CheckBox KneeNormalLeft;

    @FXML
    private CheckBox KneeExamComprehensive;

    @FXML
    private CheckBox KneeROMLeft;

    @FXML
    private CheckBox kneeSpecialTestLeft;

    @FXML
    private CheckBox KneeROMRight;

    @FXML
    private CheckBox kneeSpecialTestRight;

    @FXML
    private CheckBox KneeNormalRight;

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
	
	public void setKneeUI() {

		if (KneeallNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Knees normal bilaterally. No abrasions, contusions, lacerations, surgical scars or masses. Attitude  normal. No evidence of ecchymosis, swelling, erythema, warmth or effusion. Patellas mobile and without tenderness. No joint line tenderness, and no crepitation or muscle atrophy noted. Range of motion and motor strength normal.");
			str = str1.toString();
			KneeallNormalComprehensive.setSelected(false);
			setKneeUI();
		}else if (KneeNormalLeft.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Inspection of the left knee revealed no abrasions, contusions, lacerations, surgical scars or masses. Knee attitude is normal. No evidence of ecchymosis, swelling, erythema, warmth or effusion. Patella mobile and without tenderness. No joint line tenderness, and no crepitation or muscle atrophy noted. Range of motion and motor strength normal.");
			str = str1.toString();
			KneeNormalLeft.setSelected(false);
			setKneeUI();

		}else if (KneeNormalRight.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Inspection of the right knee revealed no abrasions, contusions, lacerations, surgical scars or masses. Knee attitude is normal. No evidence of ecchymosis, swelling, erythema, warmth or effusion. Patella mobile and without tenderness. No joint line tenderness, and no crepitation or muscle atrophy noted. Range of motion and motor strength normal.");
			str = str1.toString();
			KneeNormalRight.setSelected(false);
			setKneeUI();

		} else if (KneeExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonKneeExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKneeExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			KneeExamComprehensiveInputController kneeExamComprehensiveInputController = (KneeExamComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			kneeExamComprehensiveInputController.setExamMusculotoneKneeInputController(this);
			KneeExamComprehensive.setSelected(false);

		}

		else if (KneeROMLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonKneeRomLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKneeRomLeft", null, Locale.US);
			formPath.closeApplicationContext();

			KneeRomLeftInputController kneeRomLeftInputController = (KneeRomLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			kneeRomLeftInputController.setExamMusculotoneKneeInputController(this);
			KneeROMLeft.setSelected(false);

		}else if (KneeROMRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonKneeRomRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKneeRomRight", null, Locale.US);
			formPath.closeApplicationContext();

			KneeRomRightInputController kneeRomRightInputController = (KneeRomRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			kneeRomRightInputController.setExamMusculotoneKneeInputController(this);
			KneeROMRight.setSelected(false);

		} else if (kneeSpecialTestLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonKneeSpecialTestLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKneeSpecialTestLeft", null, Locale.US);
			formPath.closeApplicationContext();

			KneeSpecialTestLeftInputController kneeSpecialTestLeftInputController = (KneeSpecialTestLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			kneeSpecialTestLeftInputController.setExamMusculotoneKneeInputController(this);
			kneeSpecialTestLeft.setSelected(false);

		} else if (kneeSpecialTestRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonKneeSpecialTestRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKneeSpecialTestRight", null, Locale.US);
			formPath.closeApplicationContext();

			KneeSpecialTestRightInputController kneeSpecialTestRightInputController = (KneeSpecialTestRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			kneeSpecialTestRightInputController.setExamMusculotoneKneeInputController(this);
			kneeSpecialTestRight.setSelected(false);

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
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event)->
		{
			
			setKneeUI();
		
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
