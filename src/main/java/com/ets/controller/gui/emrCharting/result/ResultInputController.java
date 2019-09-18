package com.ets.controller.gui.emrCharting.result;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 18-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ResultDiagonosisInputController Class
 *Description: result.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.result.labTest.AccucheckInstantBloodInputController;
import com.ets.controller.gui.emrCharting.result.labTest.CMPPiccoloInputController;
import com.ets.controller.gui.emrCharting.result.labTest.ExecutivePhysicalLaboratoryInputController;
import com.ets.controller.gui.emrCharting.result.labTest.HemoccultInputController;
import com.ets.controller.gui.emrCharting.result.labTest.HgbA1CResultInputController;
import com.ets.controller.gui.emrCharting.result.labTest.HgbResultInputController;
import com.ets.controller.gui.emrCharting.result.labTest.InfluenzaTestInputController;
import com.ets.controller.gui.emrCharting.result.labTest.InstantCholestechInputController;
import com.ets.controller.gui.emrCharting.result.labTest.RapidStrepInputController;
import com.ets.controller.gui.emrCharting.result.labTest.UrinalysisInputController;
import com.ets.controller.gui.emrCharting.result.labTest.UrinePregnancyInputController;
import com.ets.controller.gui.emrCharting.result.labTest.WbcResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.AudioHearingInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.AudiometryResultsInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.EMGAndNVCInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.ElectrocardiogramResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.ErgonomicAssessmentInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.JAMARGripTestInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.NewPTProcedureInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.OrthostaticBPPulseIntrepretationInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.OrthostaticBPPulseResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PFTPrePostInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PFTResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PTEvaluationInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PTExercisesInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PTObjectiveInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PTParametersExercisesInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PTParametersInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PeakFlowResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.PulseOximetryResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.StressTestResultInputController;
import com.ets.controller.gui.emrCharting.result.otherTest.VisualAcuityResultsInputController;
import com.ets.controller.gui.emrCharting.result.radiology.MriReportInputController;
import com.ets.controller.gui.emrCharting.result.radiology.XRayResultFinalOutsideInputController;
import com.ets.controller.gui.emrCharting.result.radiology.XRayResultPreliminaryInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ResultInputController implements Initializable{
		
	 @FXML
     private CheckBox XrayPreliminaryCheck;
	 
	  @FXML
	    private CheckBox AccuCheck;

	    @FXML
	    private CheckBox cmpCheck;

	    @FXML
	    private CheckBox executiveCheck;

	    @FXML
	    private CheckBox hemoccultCheck;

	    @FXML
	    private CheckBox hgbResult;

	    @FXML
	    private CheckBox HgbA1CResultCheck;

	    @FXML
	    private CheckBox urinePregnancyCheck;

	    @FXML
	    private CheckBox WbcCheck;

	    @FXML
	    private CheckBox CoughCheck;

	    @FXML
	    private CheckBox RapidStrepCheck;

	    @FXML
	    private CheckBox DepressionCheck;

	    @FXML
	    private CheckBox urinalysisCheck;

	    @FXML
	    private CheckBox EMGNvc;

	    @FXML
	    private CheckBox peakFlow;

	    @FXML
	    private CheckBox ErgonomicAssessment;

	    @FXML
	    private CheckBox OrthostaticP;

	    @FXML
	    private CheckBox OrthostaticMA;

	    @FXML
	    private CheckBox JAMAR;

	    @FXML
	    private CheckBox AudioHearing;

	    @FXML
	    private CheckBox AudiometryResult;

	    @FXML
	    private CheckBox EaracheCheck;

	    @FXML
	    private CheckBox MriReportResult;

	    @FXML
	    private CheckBox xRayFinalOutsideCheck;

	    @FXML
	    private CheckBox XRayPremliminaryCheck;

	    @FXML
	    private CheckBox MRIReportCheck;

	    @FXML
	    private CheckBox PFTPrePost;

	    @FXML
	    private CheckBox PTExercises;

	    @FXML
	    private CheckBox PFTResult;

	    @FXML
	    private CheckBox PTEvaluation;

	    @FXML
	    private CheckBox PTParameter;

	    @FXML
	    private CheckBox PTParameterExercises;

	    @FXML
	    private CheckBox PTObjectiveBilling;

	    @FXML
	    private CheckBox NewPTProcedure;

	    @FXML
	    private CheckBox PulseOximetryResult;

	    @FXML
	    private CheckBox StressTestResult;

	    @FXML
	    private CheckBox VisualAcuityResult;

	    @FXML
	    private CheckBox OtherFreeTestResult;

	    @FXML
	    private CheckBox Electrocardiogram;

	    @FXML
	    private CheckBox instantCheck;

	    @FXML
	    private CheckBox influenzaCheck;

	    @FXML
	    private Button skipButton;

	    @FXML
	    private Button DoneButton;
	
	 FXMLFormPath formPath = new FXMLFormPath();
	   
     private Button button;
	
	 private GenericEMRChartingController genericEMRChartingController;
	

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}
	
	public static Integer formCount = 0;
	private Integer secondFormCount = 0;

	public static String str="\n\n";

	void formCountIncrement() {
		++secondFormCount;
	}

	  
	    
	    public void setResUI(){
	    	if (AccuCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultAccucheckInstantBlood", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultAccucheckInstantBlood", null, Locale.US);
				formPath.closeApplicationContext();

				AccucheckInstantBloodInputController accucheckInstantBloodInputController = (AccucheckInstantBloodInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				accucheckInstantBloodInputController.setResultInputController(this);
				AccuCheck.setSelected(false);

			}else if (cmpCheck.isSelected()) {


				formCountIncrement();
				String formName = formPath.context.getMessage("ResultCMPPiccolo", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultCMPPiccolo", null, Locale.US);
				formPath.closeApplicationContext();

				CMPPiccoloInputController cmpPiccoloInputController  = (CMPPiccoloInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				cmpPiccoloInputController.setResultInputController(this);
				cmpCheck.setSelected(false);

			}else if (executiveCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultExecutivePhysicalLaboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultExecutivePhysicalLaboratory", null, Locale.US);
				formPath.closeApplicationContext();

				ExecutivePhysicalLaboratoryInputController executivePhysicalLaboratoryInputController = (ExecutivePhysicalLaboratoryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				executivePhysicalLaboratoryInputController.setResultInputController(this);
				executiveCheck.setSelected(false);

			} else if (hemoccultCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultHemoccult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultHemoccult", null, Locale.US);
				formPath.closeApplicationContext();

				HemoccultInputController hemoccultInputController = (HemoccultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hemoccultInputController.setResultInputController(this);
				hemoccultCheck.setSelected(false);

			}

			else if (hgbResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultHgbResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultHgbResult", null, Locale.US);
				formPath.closeApplicationContext();

				HgbResultInputController hgbResultInputController = (HgbResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hgbResultInputController.setResultInputController(this);
				hgbResult.setSelected(false);

			}else if (HgbA1CResultCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultHgbA1CResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultHgbA1CResult", null, Locale.US);
				formPath.closeApplicationContext();

				HgbA1CResultInputController hgbA1CResultInputController = (HgbA1CResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hgbA1CResultInputController.setResultInputController(this);
				HgbA1CResultCheck.setSelected(false);
			} else if (influenzaCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultInfluenzaTest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultInfluenzaTest", null, Locale.US);
				formPath.closeApplicationContext();

				InfluenzaTestInputController influenzaTestInputController = (InfluenzaTestInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				influenzaTestInputController.setResultInputController(this);
				influenzaCheck.setSelected(false);

			} else if (instantCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultInstantCholestech", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultInstantCholestech", null, Locale.US);
				formPath.closeApplicationContext();

				InstantCholestechInputController instantCholestechInputController = (InstantCholestechInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				instantCholestechInputController.setResultInputController(this);
				instantCheck.setSelected(false);

			}else if (RapidStrepCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultRapidStrep", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultRapidStrep", null, Locale.US);
				formPath.closeApplicationContext();

				RapidStrepInputController rapidStrepInputController = (RapidStrepInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				rapidStrepInputController.setResultInputController(this);
				RapidStrepCheck.setSelected(false);

			} else if (urinalysisCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultUrinalysis", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultUrinalysis", null, Locale.US);
				formPath.closeApplicationContext();

				UrinalysisInputController urinalysisInputController = (UrinalysisInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				urinalysisInputController.setResultInputController(this);
				urinalysisCheck.setSelected(false);

			} else if (urinePregnancyCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultUrinePregnancy", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultUrinePregnancy", null, Locale.US);
				formPath.closeApplicationContext();

				UrinePregnancyInputController urinePregnancyInputController = (UrinePregnancyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				urinePregnancyInputController.setResultInputController(this);
				urinePregnancyCheck.setSelected(false);

			} else if (WbcCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultWbcResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultWbcResult", null, Locale.US);
				formPath.closeApplicationContext();

				WbcResultInputController wbcResultInputController = (WbcResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				wbcResultInputController.setResultInputController(this);
				WbcCheck.setSelected(false);

			} else if (MRIReportCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultMriReport", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultMriReport", null, Locale.US);
				formPath.closeApplicationContext();

				MriReportInputController mriReportInputController = (MriReportInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				mriReportInputController.setResultInputController(this);
				MRIReportCheck.setSelected(false);

			}
			
			else if (XRayPremliminaryCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultXRayResultPreliminary", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultXRayResultPreliminary", null, Locale.US);
				formPath.closeApplicationContext();

				XRayResultPreliminaryInputController xRayResultPreliminaryInputController = (XRayResultPreliminaryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				xRayResultPreliminaryInputController.setResultInputController(this);
				XRayPremliminaryCheck.setSelected(false);

			}
			

			else if (xRayFinalOutsideCheck.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultXRayResultFinalOutside", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultXRayResultFinalOutside", null, Locale.US);
				formPath.closeApplicationContext();

				XRayResultFinalOutsideInputController xRayResultFinalOutsideInputController = (XRayResultFinalOutsideInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				xRayResultFinalOutsideInputController.setResultInputController(this);
				xRayFinalOutsideCheck.setSelected(false);

			}
			/*else if (MriReportResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultMriReport", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultMriReport", null, Locale.US);
				formPath.closeApplicationContext();

				ForeignBodyEyeInputController foreignBodyEyeInputController = (ForeignBodyEyeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				foreignBodyEyeInputController.setMedicalProcedureInputController(this);
				MriReportResult.setSelected(false);

			}*/
			else if (AudiometryResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultAudiometryResults", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultAudiometryResults", null, Locale.US);
				formPath.closeApplicationContext();

				AudiometryResultsInputController audiometryResultsInputController = (AudiometryResultsInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				audiometryResultsInputController.setResultInputController(this);
				AudiometryResult.setSelected(false);

			}else if (AudioHearing.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultAudioHearing", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultAudioHearing", null, Locale.US);
				formPath.closeApplicationContext();

				AudioHearingInputController audioHearingInputController = (AudioHearingInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				audioHearingInputController.setResultInputController(this);
				AudioHearing.setSelected(false);

			}else if (Electrocardiogram.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultElectrocardiogramResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultElectrocardiogramResult", null, Locale.US);
				formPath.closeApplicationContext();

				ElectrocardiogramResultInputController electrocardiogramResultInputController = (ElectrocardiogramResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				electrocardiogramResultInputController.setResultInputController(this);
				Electrocardiogram.setSelected(false);

			}else if (EMGNvc.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultEMGAndNVC", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultEMGAndNVC", null, Locale.US);
				formPath.closeApplicationContext();

				EMGAndNVCInputController emgAndNVCInputController = (EMGAndNVCInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				emgAndNVCInputController.setResultInputController(this);
				EMGNvc.setSelected(false);

			}else if (ErgonomicAssessment.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultErgonomicAssessment", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultErgonomicAssessment", null, Locale.US);
				formPath.closeApplicationContext();

				ErgonomicAssessmentInputController ergonomicAssessmentInputController = (ErgonomicAssessmentInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ergonomicAssessmentInputController.setResultInputController(this);
				ErgonomicAssessment.setSelected(false);

			}else if (JAMAR.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultJAMARGripTest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultJAMARGripTest", null, Locale.US);
				formPath.closeApplicationContext();

				JAMARGripTestInputController jamarGripTestInputController = (JAMARGripTestInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				jamarGripTestInputController.setResultInputController(this);
				JAMAR.setSelected(false);

			}else if (OrthostaticMA.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultOrthostaticBPPulseResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultOrthostaticBPPulseResult", null, Locale.US);
				formPath.closeApplicationContext();

				OrthostaticBPPulseResultInputController orthostaticBPPulseResultInputController = (OrthostaticBPPulseResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				orthostaticBPPulseResultInputController.setResultInputController(this);
				OrthostaticMA.setSelected(false);

			}else if (OrthostaticP.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultOrthostaticBPPulseIntrepretation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultOrthostaticBPPulseIntrepretation", null, Locale.US);
				formPath.closeApplicationContext();

				OrthostaticBPPulseIntrepretationInputController orthostaticBPPulseIntrepretationInputController = (OrthostaticBPPulseIntrepretationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				orthostaticBPPulseIntrepretationInputController.setResultInputController(this);
				OrthostaticP.setSelected(false);

			}else if (peakFlow.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPeakFlowResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPeakFlowResult", null, Locale.US);
				formPath.closeApplicationContext();

				PeakFlowResultInputController peakFlowResultInputController = (PeakFlowResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				peakFlowResultInputController.setResultInputController(this);
				peakFlow.setSelected(false);

			}else if (PFTResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPFTResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPFTResult", null, Locale.US);
				formPath.closeApplicationContext();

				PFTResultInputController pftResultInputController = (PFTResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pftResultInputController.setResultInputController(this);
				PFTResult.setSelected(false);

			}else if (PFTPrePost.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPFTPrePost", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPFTPrePost", null, Locale.US);
				formPath.closeApplicationContext();

				PFTPrePostInputController pftPrePostInputController = (PFTPrePostInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pftPrePostInputController.setResultInputController(this);
				PFTPrePost.setSelected(false);

			}else if (PTEvaluation.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPTEvaluation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPTEvaluation", null, Locale.US);
				formPath.closeApplicationContext();

				PTEvaluationInputController ptEvaluationInputController = (PTEvaluationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ptEvaluationInputController.setResultInputController(this);
				PTEvaluation.setSelected(false);

			}else if (PTExercises.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPTExercises", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPTExercises", null, Locale.US);
				formPath.closeApplicationContext();

				PTExercisesInputController ptExercisesInputController = (PTExercisesInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ptExercisesInputController.setResultInputController(this);
				PTExercises.setSelected(false);

			}else if (PTParameter.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPTParameters", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPTParameters", null, Locale.US);
				formPath.closeApplicationContext();

				PTParametersInputController ptParametersInputController = (PTParametersInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ptParametersInputController.setResultInputController(this);
				PTParameter.setSelected(false);

			}else if (PTParameterExercises.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPTParametersExercises", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPTParametersExercises", null, Locale.US);
				formPath.closeApplicationContext();

				PTParametersExercisesInputController ptParametersExercisesInputController = (PTParametersExercisesInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ptParametersExercisesInputController.setResultInputController(this);
				PTParameterExercises.setSelected(false);

			}else if (PTObjectiveBilling.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPTObjective", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPTObjective", null, Locale.US);
				formPath.closeApplicationContext();

				PTObjectiveInputController ptObjectiveInputController = (PTObjectiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ptObjectiveInputController.setResultInputController(this);
				PTObjectiveBilling.setSelected(false);

			}else if (NewPTProcedure.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultNewPTProcedure", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultNewPTProcedure", null, Locale.US);
				formPath.closeApplicationContext();

				NewPTProcedureInputController  newPTProcedureInputController = (NewPTProcedureInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				newPTProcedureInputController.setResultInputController(this);
				NewPTProcedure.setSelected(false);

			}else if (PulseOximetryResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultPulseOximetryResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultPulseOximetryResult", null, Locale.US);
				formPath.closeApplicationContext();

				PulseOximetryResultInputController pulseOximetryResultInputController = (PulseOximetryResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pulseOximetryResultInputController.setResultInputController(this);
				PulseOximetryResult.setSelected(false);

			}else if (StressTestResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultStressTestResult", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultStressTestResult", null, Locale.US);
				formPath.closeApplicationContext();

				StressTestResultInputController stressTestResultInputController = (StressTestResultInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				stressTestResultInputController.setResultInputController(this);
				StressTestResult.setSelected(false);

			}else if (VisualAcuityResult.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ResultVisualAcuityResults", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ResultVisualAcuityResults", null, Locale.US);
				formPath.closeApplicationContext();

				VisualAcuityResultsInputController visualAcuityResultsInputController = (VisualAcuityResultsInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visualAcuityResultsInputController.setResultInputController(this);
				VisualAcuityResult.setSelected(false);

			}
			
			
			else if (secondFormCount == formCount) {

				genericEMRChartingController.paint(button);
				
				
				formCount = 0;
				genericEMRChartingController.setResultTextArea(str);
				genericEMRChartingController.saveAllTextArea();

			}

	    		
	    	
	    }
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
		DoneButton.setOnAction((event)->
		{
			
			setResUI();
			new FXFormCommonUtilities().closeForm(DoneButton);
		
		});
		skipButton.setOnAction((event)->
		{
			
			new FXFormCommonUtilities().closeForm(skipButton);
		
		});
						
				
	}
	
	
	
	

}
