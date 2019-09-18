package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.ankle;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 14-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneAnkleInputController Class
 *Description: ankle.fxml Controller class
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

public class ExamMusculotoneAnkleInputController implements Initializable{
	
	@FXML
    private CheckBox AnkleallNormalComprehensive;

    @FXML
    private CheckBox AnkleNormalLeft;

    @FXML
    private CheckBox AnkleExamComprehensive;

    @FXML
    private CheckBox AnkleROMLeft;

    @FXML
    private CheckBox AnkleSpecialTestLeft;

    @FXML
    private CheckBox AnkleROMRight;

    @FXML
    private CheckBox AnkleSpecialTestRight;

    @FXML
    private CheckBox AnkleNormalRight;

    @FXML
    private CheckBox anklePlantar;

    @FXML
    private CheckBox AnkleIngrown;

    @FXML
    private CheckBox ankleSprain;

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
	
	
	public void setAnkleUI() {

		if (AnkleallNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Ankles and feet normal bilaterally. Normal pulses and capillary refill, no edema, ecchymosis, warmth or tenderness noted. Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			AnkleallNormalComprehensive.setSelected(false);
			setAnkleUI();
		}else if (AnkleNormalLeft.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Left ankle and foot normal. Normal pulses and capillary refill, no edema, ecchymosis, warmth or tenderness noted. Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			AnkleNormalLeft.setSelected(false);
			setAnkleUI();

		}else if (AnkleNormalRight.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Right ankle and foot normal. Normal pulses and capillary refill, no edema, ecchymosis, warmth or tenderness noted. Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			AnkleNormalRight.setSelected(false);
			setAnkleUI();

		} else if (AnkleExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkleExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkleExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			AnkleFootExamCompInputController ankleFootExamCompInputController = (AnkleFootExamCompInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			ankleFootExamCompInputController.setExamMusculotoneAnkleInputController(this);
			AnkleExamComprehensive.setSelected(false);

		}

		else if (AnkleROMLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkleRomLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkleRomLeft", null, Locale.US);
			formPath.closeApplicationContext();

			AnkleRomLeftInputController ankleRomLeftInputController = (AnkleRomLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			ankleRomLeftInputController.setExamMusculotoneAnkleInputController(this);
			AnkleROMLeft.setSelected(false);

		}else if (AnkleROMRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkleRomRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkleRomRight", null, Locale.US);
			formPath.closeApplicationContext();

			AnkleRomRightnputController ankleRomRightnputController = (AnkleRomRightnputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			ankleRomRightnputController.setExamMusculotoneAnkleInputController(this);
			AnkleROMRight.setSelected(false);

		} else if (AnkleSpecialTestLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkleTestLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkleTestLeft", null, Locale.US);
			formPath.closeApplicationContext();

			AnkleFootSpecialTestLeftInputController ankleFootSpecialTestLeftInputController = (AnkleFootSpecialTestLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			ankleFootSpecialTestLeftInputController.setExamMusculotoneAnkleInputController(this);
			AnkleSpecialTestLeft.setSelected(false);

		} else if (AnkleSpecialTestRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkleTestRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkleTestRight", null, Locale.US);
			formPath.closeApplicationContext();

			AnkleFootSpecialTestRightInputController ankleFootSpecialTestRightInputController = (AnkleFootSpecialTestRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			ankleFootSpecialTestRightInputController.setExamMusculotoneAnkleInputController(this);
			AnkleSpecialTestRight.setSelected(false);

		}else if (AnkleIngrown.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Medial aspect of great toe is red swollen, tender and warm with drainage. Ankles and feet otherwise are normal bilaterally. Normal pulses and capillary refill,  Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			AnkleIngrown.setSelected(false);
			setAnkleUI();
		}else if (anklePlantar.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Plantar aspect of foot is tender with reproduction of pain with palpation of the plantar fascia. Ankles and feet normal bilaterally. Normal pulses and capillary refill, no edema, ecchymosis, warmth or tenderness noted. Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			anklePlantar.setSelected(false);
			setAnkleUI();

		}else if (ankleSprain.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Ankles and feet tender to weight bearing. Normal pulses and capillary refill. Some tenderness in area of edema and ecchymosis. Mortise joints intact. Negative drawer signs.");
			str = str1.toString();
			ankleSprain.setSelected(false);
			setAnkleUI();

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
			
			setAnkleUI();
		
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
