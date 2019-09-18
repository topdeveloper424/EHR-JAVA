package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.head;

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
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneHeadInputController Class
 *Description: ExamMusculotoneHead GUI Controller class
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
public class ExamMusculotoneHeadInputController implements Initializable{
	
	@FXML
    private CheckBox allNormalComprehensive;

    @FXML
    private CheckBox examComprehensive;

    @FXML
    private CheckBox RomSpine;

    @FXML
    private CheckBox FaceFacialStrength;

    @FXML
    private CheckBox FacePalpation;

    @FXML
    private CheckBox FaceInspection;

    @FXML
    private CheckBox FaceSalivary;

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
	
	
	public void setHeadUI() {

		if (allNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Head is normocephalic, atraumatic, and without deformity, tenderness, masses, ecchymosis or lacerations. "
					+ "Face shows normal tone and strength, and salivary glands and sinuses normal.");
			str = str1.toString();
			allNormalComprehensive.setSelected(false);
			setHeadUI();
		} else if (examComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadExamComp", null, Locale.US);
			formPath.closeApplicationContext();

			HeadComprehensiveInputController headComprehensiveInputController = (HeadComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headComprehensiveInputController.setExamMusculotoneHeadInputController(this);
			examComprehensive.setSelected(false);

		}

		else if (RomSpine.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadRomSpine", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadRomSpine", null, Locale.US);
			formPath.closeApplicationContext();

			HeadRomSpineInputController headRomSpineInputController = (HeadRomSpineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headRomSpineInputController.setExamMusculotoneHeadInputController(this);
			RomSpine.setSelected(false);

		} else if (FaceFacialStrength.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadFaceFacialStrenght", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadFaceFacialStrenght", null, Locale.US);
			formPath.closeApplicationContext();

			HeadFaceFacialStrengthInputController headFaceFacialStrengthInputController = (HeadFaceFacialStrengthInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headFaceFacialStrengthInputController.setExamMusculotoneHeadInputController(this);
			FaceFacialStrength.setSelected(false);

		} else if (FaceInspection.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadFaceInspection", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadFaceInspection", null, Locale.US);
			formPath.closeApplicationContext();

			HeadFaceInspectionInputController headFaceInspectionInputController = (HeadFaceInspectionInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headFaceInspectionInputController.setExamMusculotoneHeadInputController(this);
			FaceInspection.setSelected(false);

		} else if (FacePalpation.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadFacePalpation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadFacePalpation", null, Locale.US);
			formPath.closeApplicationContext();

			HeadFacePalpationInputController headFacePalpationInputController = (HeadFacePalpationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headFacePalpationInputController.setExamMusculotoneHeadInputController(this);
			FacePalpation.setSelected(false);

		} else if (FaceSalivary.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonHeadFaceSalivaryGlands", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHeadFaceSalivaryGlands", null, Locale.US);
			formPath.closeApplicationContext();

			HeadFaceSalivaryGlandsInputController headFaceSalivaryGlandsInputController = (HeadFaceSalivaryGlandsInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			headFaceSalivaryGlandsInputController.setExamMusculotoneHeadInputController(this);
			FaceSalivary.setSelected(false);

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
			
			setHeadUI();
		
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
