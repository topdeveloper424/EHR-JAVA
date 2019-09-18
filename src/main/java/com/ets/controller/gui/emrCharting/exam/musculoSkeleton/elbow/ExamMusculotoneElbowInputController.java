package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.elbow;

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
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneElbowInputController Class
 *Description: ElbowExamComprehensive GUI Controller class
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
public class ExamMusculotoneElbowInputController implements Initializable{
	
	@FXML
    private CheckBox ElbowallNormalComprehensive;

    @FXML
    private CheckBox ElbowNormalLeft;

    @FXML
    private CheckBox ElbowExamComprehensive;

    @FXML
    private CheckBox ElbowRomLeft;

    @FXML
    private CheckBox ElbowSpecialTestsLeft;

    @FXML
    private CheckBox ElbowROMRight;

    @FXML
    private CheckBox ElbowSpecialTestsRight;

    @FXML
    private CheckBox elbowLateralEpicondyle;

    @FXML
    private CheckBox ElbowMedialEpicondyle;

    @FXML
    private CheckBox ElbowNursemaids;

    @FXML
    private CheckBox ElbowOlecranon;

    @FXML
    private CheckBox ElbowNormalRight;

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
	
	
	public void setElbowUI() {

		if (ElbowallNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of both elbows shows no deformity, ecchymosis or erythema, full range of motion and no tenderness to maneuvers. Motor strength normal.");
			str = str1.toString();
			ElbowallNormalComprehensive.setSelected(false);
			setElbowUI();
		}else if (ElbowNormalLeft.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nLeft elbow shows no deformity, ecchymosis or erythema, full range of motion and no tenderness to maneuvers. Motor strength normal.");
			str = str1.toString();
			ElbowNormalLeft.setSelected(false);
			setElbowUI();

		}else if (ElbowNormalRight.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nRight elbow shows no deformity, ecchymosis or erythema, full range of motion and no tenderness to maneuvers. Motor strength normal.");
			str = str1.toString();
			ElbowNormalRight.setSelected(false);
			setElbowUI();

		} else if (ElbowExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonElbowExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbowExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			ElbowExamComprehensiveInputController elbowExamComprehensiveInputController = (ElbowExamComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elbowExamComprehensiveInputController.setExamMusculotoneElbowInputController(this);
			ElbowExamComprehensive.setSelected(false);

		}

		else if (ElbowRomLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonElbowRomLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbowRomLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ElboeRomLeftInputController elboeRomLeftInputController = (ElboeRomLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elboeRomLeftInputController.setExamMusculotoneElbowInputController(this);
			ElbowRomLeft.setSelected(false);

		}else if (ElbowROMRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonElbowRomRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbowRomRight", null, Locale.US);
			formPath.closeApplicationContext();

			ElboeRomRightInputController elboeRomRightInputController = (ElboeRomRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elboeRomRightInputController.setExamMusculotoneElbowInputController(this);
			ElbowROMRight.setSelected(false);

		} else if (ElbowSpecialTestsLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonElbowSpecialTestLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbowSpecialTestLeft", null, Locale.US);
			formPath.closeApplicationContext();

			ElbowSpecialTestLeftInputController elbowSpecialTestLeftInputController = (ElbowSpecialTestLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elbowSpecialTestLeftInputController.setExamMusculotoneElbowInputController(this);
			ElbowSpecialTestsLeft.setSelected(false);

		} else if (ElbowSpecialTestsRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonElbowSpecialTestRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbowSpecialTestRight", null, Locale.US);
			formPath.closeApplicationContext();

			ElbowSpecialTestRightInputController elbowSpecialTestRightInputController = (ElbowSpecialTestRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elbowSpecialTestRightInputController.setExamMusculotoneElbowInputController(this);
			ElbowSpecialTestsRight.setSelected(false);

		}else if (elbowLateralEpicondyle.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of both elbows shows no deformity, ecchymosis or erythema, full range of motion and no tenderness to maneuvers. Motor strength normal. However palpation of the lateral epicondyle reproduces the patient's pain exactly.");
			str = str1.toString();
			elbowLateralEpicondyle.setSelected(false);
			setElbowUI();

		}else if (ElbowMedialEpicondyle.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of both elbows shows no deformity, ecchymosis or erythema, full range of motion and no tenderness to maneuvers. Motor strength normal. However palpation of the medial epicondyle reproduces the patient's pain exactly.");
			str = str1.toString();
			ElbowMedialEpicondyle.setSelected(false);
			setElbowUI();

		}else if (ElbowNursemaids.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of affected elbow shows no deformity, ecchymosis or erythema, full range of motion  attempted and a ' pop ' was felt and afterward there was no tenderness to maneuvers. Motor strength normal. Patient was later able to demonstrate full active range of motion on their own.");
			str = str1.toString();
			ElbowNursemaids.setSelected(false);
			setElbowUI();

		}else if (ElbowOlecranon.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Examination of affected elbow shows a non tender fluctuant golf ball sized swelling deformity of the olecranon without ecchymosis or erythema. There is a  full range of motion and no tenderness to maneuvers. Motor strength normal.");
			str = str1.toString();
			ElbowOlecranon.setSelected(false);
			setElbowUI();

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
			
			setElbowUI();
		
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
