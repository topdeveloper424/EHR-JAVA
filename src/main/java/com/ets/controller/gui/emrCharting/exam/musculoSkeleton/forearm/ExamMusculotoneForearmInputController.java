package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneForearmInputController Class
 *Description: forearm.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ExamMusculotoneForearmInputController implements Initializable{
	
	@FXML
    private CheckBox allNormalCheckBox;

    @FXML
    private CheckBox normalLeftCheckBox;

    @FXML
    private CheckBox romWristLeftCheckBox;

    @FXML
    private CheckBox romDigitCheckBox;

    @FXML
    private CheckBox specialTestLeftNewCheckBox;

    @FXML
    private CheckBox specialTestRightCheckBox;

    @FXML
    private CheckBox navicularCheckBox;

    @FXML
    private CheckBox normalRightCheckBox;

    @FXML
    private CheckBox examCheckBox;

    @FXML
    private CheckBox examFullCheckBox;

    @FXML
    private CheckBox romThumbLeftCheckBox;

    @FXML
    private CheckBox romWristRightCheckBox;

    @FXML
    private CheckBox romThumbRightCheckBox;

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
	
	
	public void setForearmUI() {

		if (allNormalCheckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Wrists and hands are bilaterally normal. No scars, swelling, deformity, ecchymosis or tenderness. Range of motion full. Strength is normal and sensation intact.  Pulses are normal radial and ulnar.");
			str = str1.toString();
			allNormalCheckBox.setSelected(false);
			setForearmUI();
		}else if (normalLeftCheckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nExam of the left hand and wrist reveals no scars, swelling, deformity or ecchymosis. Range of motion is full. There is no tenderness, and strength is normal and sensation intact.  Pulses are normal radial and ulnar.");
			str = str1.toString();
			normalLeftCheckBox.setSelected(false);
			setForearmUI();

		}else if (normalRightCheckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nExam of the right hand and wrist reveals no scars, swelling, deformity or ecchymosis. Range of motion is full. There is no tenderness, and strength is normal and sensation intact.  Pulses are normal radial and ulnar.");
			str = str1.toString();
			normalRightCheckBox.setSelected(false);
			setForearmUI();

		} else if (examCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmExamComprehensiveInputController forearmExamComprehensiveInputController = (ForearmExamComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmExamComprehensiveInputController.setExamMusculotoneForearmInputController(this);
			examCheckBox.setSelected(false);

		}

		else if (examFullCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmDigit", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmDigit", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmDigitInputController forearmDigitInputController = (ForearmDigitInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmDigitInputController.setExamMusculotoneForearmInputController(this);
			examFullCheckBox.setSelected(false);

		}else if (romWristLeftCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmRomWristleft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmRomWristleft", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmRomWristLeftInputController forearmRomWristLeftInputController = (ForearmRomWristLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmRomWristLeftInputController.setExamMusculotoneForearmInputController(this);
			romWristLeftCheckBox.setSelected(false);

		} else if (romWristRightCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmRomWristRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmRomWristRight", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmRomWristRightInputController forearmRomWristRightInputController = (ForearmRomWristRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmRomWristRightInputController.setExamMusculotoneForearmInputController(this);
			romWristRightCheckBox.setSelected(false);

		} else if (romThumbLeftCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmRomThumbLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmRomThumbLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmRomThumbLeftInputController forearmRomThumbLeftInputController = (ForearmRomThumbLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmRomThumbLeftInputController.setExamMusculotoneForearmInputController(this);
			romThumbLeftCheckBox.setSelected(false);

		}else if (romThumbRightCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmRomThumbRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmRomThumbRight", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmRomThumbRightInputController forearmRomThumbRightInputController = (ForearmRomThumbRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmRomThumbRightInputController.setExamMusculotoneForearmInputController(this);
			romThumbRightCheckBox.setSelected(false);

		} else if (romDigitCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmRomDigit", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmRomDigit", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmRomDigitInputController forearmRomDigitInputController = (ForearmRomDigitInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmRomDigitInputController.setExamMusculotoneForearmInputController(this);
			romDigitCheckBox.setSelected(false);

		} else if (specialTestLeftNewCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmSpecialTestLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmSpecialTestLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmSpecialTestLeftInputController forearmSpecialTestLeftInputController = (ForearmSpecialTestLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmSpecialTestLeftInputController.setExamMusculotoneForearmInputController(this);
			specialTestLeftNewCheckBox.setSelected(false);

		} else if (specialTestRightCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonForearmSpecialTestRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearmSpecialTestRight", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmSpecialTestRightInputController forearmSpecialTestRightInputController = (ForearmSpecialTestRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmSpecialTestRightInputController.setExamMusculotoneForearmInputController(this);
			specialTestRightCheckBox.setSelected(false);

		} else if (navicularCheckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nOn the unaffected side the wrists and hands are normal. No scars, swelling, deformity, ecchymosis or tenderness. Range of motion full. Strength is normal and sensation intact.  Pulses are normal radial and ulnar. On the affected side there is swelling, tenderness over the anatomical snuffbox and limited range of motion secondary to guarding. Neurovascularly intact.");
			str = str1.toString();
			navicularCheckBox.setSelected(false);
			setForearmUI();

		}else if (secondFormCount == formCount) {

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
			
			setForearmUI();
		
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
