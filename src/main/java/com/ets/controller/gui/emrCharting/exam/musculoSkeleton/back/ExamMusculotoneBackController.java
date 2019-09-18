package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneBackController Class
 *Description: MusculoBack.fxml Controller class
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

public class ExamMusculotoneBackController implements Initializable{
	
	@FXML
    private CheckBox BackallNormalComprehensive;

    @FXML
    private CheckBox BackexamComprehensive;

    @FXML
    private CheckBox BackRomSpineThoracic;

    @FXML
    private CheckBox BackRomSpineLumbo;

    @FXML
    private CheckBox backStraight;

    @FXML
    private CheckBox backSpecialTest;

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
	
	
	public void setBackUI() {

		if (BackallNormalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("Back shows no deformity or tenderness. Range of motion is normal and without pain. Heel and toe walk normal. "
					+ "Reflexes are symmetric and SLR negative bilaterally.");
			str = str1.toString();
			BackallNormalComprehensive.setSelected(false);
			setBackUI();
		}else if (BackexamComprehensive.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonBackComprehensive", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBackComprehensive", null, Locale.US);
			formPath.closeApplicationContext();

			BackComprehensiveInputController backComprehensiveInputController = (BackComprehensiveInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			backComprehensiveInputController.setExamMusculotoneBackController(this);
			BackexamComprehensive.setSelected(false);

		}

		else if (BackRomSpineThoracic.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonBackRibThoracic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBackRibThoracic", null, Locale.US);
			formPath.closeApplicationContext();

			BackRibThoracicInputController backRibThoracicInputController = (BackRibThoracicInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			backRibThoracicInputController.setExamMusculotoneBackController(this);
			BackRomSpineThoracic.setSelected(false);

		}else if (BackRomSpineLumbo.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonBackRibLumbo", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBackRibLumbo", null, Locale.US);
			formPath.closeApplicationContext();

			BackRibRomLumboInputController backRibRomLumboInputController = (BackRibRomLumboInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			backRibRomLumboInputController.setExamMusculotoneBackController(this);
			BackRomSpineLumbo.setSelected(false);

		} else if (backSpecialTest.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonBackSpecialTest", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBackSpecialTest", null, Locale.US);
			formPath.closeApplicationContext();

			BackSpecialTestInputController backSpecialTestInputController = (BackSpecialTestInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			backSpecialTestInputController.setExamMusculotoneBackController(this);
			backSpecialTest.setSelected(false);

		} else if (backStraight.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("ExamMusculoSkeletonBackStraightLeg", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBackStraightLeg", null, Locale.US);
			formPath.closeApplicationContext();

			BackStraightInputController backStraightInputController = (BackStraightInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			backStraightInputController.setExamMusculotoneBackController(this);
			backStraight.setSelected(false);

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
			
			setBackUI();
		
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
