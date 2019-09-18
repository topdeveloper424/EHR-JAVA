package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckCervicalMildSpasmInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckCompressionInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckDistractionInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckDtrInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckExamComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckRepeatedMovementInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckRomSpineInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckVertibralArteryInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneShoulderInputController Class
 *Description: MusculoShoulder GUI Controller class
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
public class ExamMusculotoneShoulderInputController implements Initializable {
	
	@FXML
    private CheckBox shoulderAllNormal;

    @FXML
    private CheckBox shoulderNormalLeft;

    @FXML
    private CheckBox ShoulderNormalRight;

    @FXML
    private CheckBox ShoulderExamComprehensive;

    @FXML
    private CheckBox ShoulderRomRight;

    @FXML
    private CheckBox ShoulderROMLeft;

    @FXML
    private CheckBox ShoulderSpecialLeft;

    @FXML
    private CheckBox ShoulderSpecialRight;

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
	
	public void setShoulderUI() {

		if (shoulderAllNormal.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nShoulders normal bilaterally upon inspection, with full range of motion, no tenderness and no crepitation.");
			str = str1.toString();
			shoulderAllNormal.setSelected(false);
			setShoulderUI();
		}else if (shoulderNormalLeft.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nExamination showed left shoulder normal, with full range of motion, no tenderness and no crepitation.");
			str = str1.toString();
			shoulderNormalLeft.setSelected(false);
			setShoulderUI();

		}else if (ShoulderNormalRight.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nExamination showed right shoulder normal, with full range of motion, no tenderness and no crepitation.");
			str = str1.toString();
			ShoulderNormalRight.setSelected(false);
			setShoulderUI();

		} else if (ShoulderExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulderComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulderComp", null, Locale.US);
			formPath.closeApplicationContext();

			ShoulderComprehensiveInputController shoulderComprehensiveInputController = (ShoulderComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shoulderComprehensiveInputController.setExamMusculotoneShoulderInputController(this);
			ShoulderExamComprehensive.setSelected(false);

		}

		else if (ShoulderROMLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulderRomLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulderRomLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ShoulderRomLeftInputController shoulderRomLeftInputController = (ShoulderRomLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shoulderRomLeftInputController.setExamMusculotoneShoulderInputController(this);
			ShoulderROMLeft.setSelected(false);

		}else if (ShoulderRomRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulderRomRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulderRomRight", null, Locale.US);
			formPath.closeApplicationContext();

			ShoulderRomRightnputController shoulderRomRightnputController = (ShoulderRomRightnputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shoulderRomRightnputController.setExamMusculotoneShoulderInputController(this);
			ShoulderRomRight.setSelected(false);

		} else if (ShoulderSpecialLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulderSpecialTestLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulderSpecialTestLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ShoulderSpecialTestLeftInputController shoulderSpecialTestLeftInputController = (ShoulderSpecialTestLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shoulderSpecialTestLeftInputController.setExamMusculotoneShoulderInputController(this);
			ShoulderSpecialLeft.setSelected(false);

		} else if (ShoulderSpecialRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulderSpecialTestRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulderSpecialTestRight", null, Locale.US);
			formPath.closeApplicationContext();

			ShoulderSpecialTestRightInputController shoulderSpecialTestRightInputController = (ShoulderSpecialTestRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			shoulderSpecialTestRightInputController.setExamMusculotoneShoulderInputController(this);
			ShoulderSpecialRight.setSelected(false);

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
			
			setShoulderUI();
		
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
