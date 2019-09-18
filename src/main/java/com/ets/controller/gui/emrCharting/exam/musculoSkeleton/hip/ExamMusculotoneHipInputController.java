package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.hip;


/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneHipInputController Class
 *Description: MusculoHip.fxml Controller class
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

public class ExamMusculotoneHipInputController implements Initializable{
	
	@FXML
    private CheckBox hipAllNormal;

    @FXML
    private CheckBox hipNormalLeft;

    @FXML
    private CheckBox hipNormalRight;

    @FXML
    private CheckBox hipExamComprehensive;

    @FXML
    private CheckBox HipRomRight;

    @FXML
    private CheckBox hipROMLeft;

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
	
	
	public void setHipUI() {

		if (hipAllNormal.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\nHips show no abnormalities bilaterally on inspection or palpation. Leg length and station normal. "
					+ "Range of motion normal. No evidence of atrophy in buttocks or thigh.");
			str = str1.toString();
			hipAllNormal.setSelected(false);
			setHipUI();
		}else if (hipNormalLeft.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nLeft hip shows no abnormalities on inspection or palpation. Leg length and station normal. "
					+ "Range of motion normal. No evidence of atrophy in buttocks or thigh.");
			str = str1.toString();
			hipNormalLeft.setSelected(false);
			setHipUI();

		}else if (hipNormalRight.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nRight hip shows no abnormalities on inspection or palpation. Leg length and station normal. "
					+ "Range of motion normal. No evidence of atrophy in buttocks or thigh.");
			str = str1.toString();
			hipNormalRight.setSelected(false);
			setHipUI();

		} else if (hipExamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHipExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHipExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			HipComprehensiveInputController hipComprehensiveInputController = (HipComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			hipComprehensiveInputController.setExamMusculotoneHipInputController(this);
			hipExamComprehensive.setSelected(false);

		}else if (hipROMLeft.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHipRomLeft", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHipRomLeft", null, Locale.US);
			formPath.closeApplicationContext();

			HipRomLeftInputController hipRomLeftInputController = (HipRomLeftInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			hipRomLeftInputController.setExamMusculotoneHipInputController(this);
			hipROMLeft.setSelected(false);

		} else if (HipRomRight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHipRomRight", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHipRomRight", null, Locale.US);
			formPath.closeApplicationContext();

			HipRomRightInputController hipRomRightInputController = (HipRomRightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			hipRomRightInputController.setExamMusculotoneHipInputController(this);
			HipRomRight.setSelected(false);

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
			
			setHipUI();
		
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
