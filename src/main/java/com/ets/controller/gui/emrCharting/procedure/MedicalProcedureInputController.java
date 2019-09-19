package com.ets.controller.gui.emrCharting.procedure;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalProcedureInputController Class
 *Description: MedicalProcdure.fxm GUI Controller class
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
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmDigitInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmExamComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmRomDigitInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmRomThumbLeftInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmRomThumbRightInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmRomWristLeftInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmRomWristRightInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmSpecialTestLeftInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ForearmSpecialTestRightInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.AllergyFreeTextController;
import com.ets.controller.gui.emrCharting.procedure.laceration.ArmInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.EarInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.ElbowInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.EyeLidInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.FaceInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.FeetInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.FingerInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.ForearmInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.HandInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.LegInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.NeckInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.NoseInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.SclapInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.ToeInputController;
import com.ets.controller.gui.emrCharting.procedure.laceration.TrunkInputController;
import com.ets.controller.gui.emrCharting.procedure.removal.ForeignBodyEyeInputController;
import com.ets.controller.gui.emrCharting.procedure.removal.ForeignBodyUcInputController;
import com.ets.controller.gui.emrCharting.procedure.removal.SutureRemovalUCInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class MedicalProcedureInputController implements Initializable {

	@FXML
	private CheckBox armCheckBox;

	@FXML
	private CheckBox earCheckBox;

	@FXML
	private CheckBox elbowCheckBox;

	@FXML
	private CheckBox feetCheckBox;

	@FXML
	private CheckBox forearmCheckBox;

	@FXML
	private CheckBox handCheckBox;

	@FXML
	private CheckBox legCheckBox;

	@FXML
	private CheckBox trunkCheckBox;

	@FXML
	private CheckBox noseCheckBox;

	@FXML
	private CheckBox bodyEyeCheckBox;

	@FXML
	private CheckBox neckCheckBox;

	@FXML
	private CheckBox sclapCheckBox;

	@FXML
	private CheckBox toeCheckBox;

	@FXML
	private CheckBox eyelidCheckBox;

	@FXML
	private CheckBox faceCheckBox;

	@FXML
	private CheckBox fingerCheckBox;

	@FXML
	private CheckBox bodyUCCheckBox;

	@FXML
	private CheckBox sutureCheckBox;

	@FXML
	private CheckBox dislocationCheckBox;

	@FXML
	private CheckBox additionalCheckBox;

	@FXML
	private CheckBox patientObservationCheckBox;

	@FXML
	private CheckBox respiratoryProcedureCheckBox;

	@FXML
	private CheckBox oxygenCheckBox;

	@FXML
	private CheckBox nasalCheckBox;

	@FXML
	private CheckBox drainageCheckBox;

	@FXML
	private CheckBox injectionNoteCheckBox;

	@FXML
	private CheckBox wickPlacementCheckBox;

	@FXML
	private CheckBox waxRemovalCheckBox;

	@FXML
	private CheckBox anoscopyCheckBox;

	@FXML
	private CheckBox aspirationCheckBox;

	@FXML
	private CheckBox woundCleaningCheckBox;

	@FXML
	private CheckBox iducCheckBox;

	@FXML
	private CheckBox nonsurgicalCheckBox;

	@FXML
	private CheckBox generalCheckBox;

	@FXML
	private CheckBox generalConditionalCheckBox;

	@FXML
	private CheckBox urgentCareCheckBox;

	@FXML
	private CheckBox coordinationCheckBox;

	@FXML
	private Button skipBtn;

	@FXML
	private Button freeTextBtn;

	@FXML
	private Button doneBtn;

	public GenericEMRChartingController genericEMRChartingController;
	private Button button;

	FXMLFormPath formPath = new FXMLFormPath();

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;

	}

	public static Integer formCount = 0;
	private Integer secondFormCount = 0;

	public String str = "\n\n";
	public static String strForFreeText = "";

	void formCountIncrement() {
		++secondFormCount;
	}

	public void setMedUI() {

		if (armCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalArm", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalArm", null, Locale.US);
			formPath.closeApplicationContext();

			ArmInputController armInputController = (ArmInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			armInputController.setMedicalProcedureInputController(this);
			armCheckBox.setSelected(false);

		} else if (earCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalEar", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalEar", null, Locale.US);
			formPath.closeApplicationContext();

			EarInputController earInputController = (EarInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			earInputController.setMedicalProcedureInputController(this);
			earCheckBox.setSelected(false);

		} else if (elbowCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalElbow", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalElbow", null, Locale.US);
			formPath.closeApplicationContext();

			ElbowInputController elbowInputController = (ElbowInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			elbowInputController.setMedicalProcedureInputController(this);
			elbowCheckBox.setSelected(false);

		} else if (eyelidCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalEyeLid", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalEyeLid", null, Locale.US);
			formPath.closeApplicationContext();

			EyeLidInputController eyeLidInputController = (EyeLidInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			eyeLidInputController.setMedicalProcedureInputController(this);
			eyelidCheckBox.setSelected(false);

		}

		else if (faceCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalFace", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalFace", null, Locale.US);
			formPath.closeApplicationContext();

			FaceInputController faceInputController = (FaceInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			faceInputController.setMedicalProcedureInputController(this);
			faceCheckBox.setSelected(false);

		} else if (feetCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalFeet", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalFeet", null, Locale.US);
			formPath.closeApplicationContext();

			FeetInputController feetInputController = (FeetInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			feetInputController.setMedicalProcedureInputController(this);
			feetCheckBox.setSelected(false);
		} else if (fingerCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalFinger", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalFinger", null, Locale.US);
			formPath.closeApplicationContext();

			FingerInputController fingerInputController = (FingerInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			fingerInputController.setMedicalProcedureInputController(this);
			fingerCheckBox.setSelected(false);

		} else if (forearmCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalForearm", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalForearm", null, Locale.US);
			formPath.closeApplicationContext();

			ForearmInputController forearmInputController = (ForearmInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			forearmInputController.setMedicalProcedureInputController(this);
			forearmCheckBox.setSelected(false);

		} else if (handCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalHand", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalHand", null, Locale.US);
			formPath.closeApplicationContext();

			HandInputController handInputController = (HandInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			handInputController.setMedicalProcedureInputController(this);
			handCheckBox.setSelected(false);

		} else if (legCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalLeg", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalLeg", null, Locale.US);
			formPath.closeApplicationContext();

			LegInputController legInputController = (LegInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			legInputController.setMedicalProcedureInputController(this);
			legCheckBox.setSelected(false);

		} else if (neckCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalNeck", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalNeck", null, Locale.US);
			formPath.closeApplicationContext();

			NeckInputController neckInputController = (NeckInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neckInputController.setMedicalProcedureInputController(this);
			neckCheckBox.setSelected(false);

		} else if (noseCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalNose", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalNose", null, Locale.US);
			formPath.closeApplicationContext();

			NoseInputController noseInputController = (NoseInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			noseInputController.setMedicalProcedureInputController(this);
			noseCheckBox.setSelected(false);

		} else if (sclapCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalSclap", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalSclap", null, Locale.US);
			formPath.closeApplicationContext();

			SclapInputController sclapInputController = (SclapInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			sclapInputController.setMedicalProcedureInputController(this);
			sclapCheckBox.setSelected(false);

		}

		else if (toeCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalToe", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalToe", null, Locale.US);
			formPath.closeApplicationContext();

			ToeInputController toeInputController = (ToeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			toeInputController.setMedicalProcedureInputController(this);
			toeCheckBox.setSelected(false);

		}

		else if (trunkCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalTrunk", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalTrunk", null, Locale.US);
			formPath.closeApplicationContext();

			TrunkInputController trunkInputController = (TrunkInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			trunkInputController.setMedicalProcedureInputController(this);
			trunkCheckBox.setSelected(false);

		} else if (bodyEyeCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalForeignBodyEye", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalForeignBodyEye", null, Locale.US);
			formPath.closeApplicationContext();

			ForeignBodyEyeInputController foreignBodyEyeInputController = (ForeignBodyEyeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			foreignBodyEyeInputController.setMedicalProcedureInputController(this);
			bodyEyeCheckBox.setSelected(false);

		} else if (bodyUCCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalForeignBodyUc", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalForeignBodyUc", null, Locale.US);
			formPath.closeApplicationContext();

			ForeignBodyUcInputController foreignBodyUcInputController = (ForeignBodyUcInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			foreignBodyUcInputController.setMedicalProcedureInputController(this);
			bodyUCCheckBox.setSelected(false);

		} else if (sutureCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalSutureRemovalUC", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalSutureRemovalUC", null, Locale.US);
			formPath.closeApplicationContext();

			SutureRemovalUCInputController sutureRemovalUCInputController = (SutureRemovalUCInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			sutureRemovalUCInputController.setMedicalProcedureInputController(this);
			sutureCheckBox.setSelected(false);

		} else if (iducCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalIdUC", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalIdUC", null, Locale.US);
			formPath.closeApplicationContext();

			IdUCInputController idUCInputController = (IdUCInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			idUCInputController.setMedicalProcedureInputController(this);
			iducCheckBox.setSelected(false);

		} else if (nonsurgicalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalWoundDebridmentNonsurgical", null,
					Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalWoundDebridmentNonsurgical", null,
					Locale.US);
			formPath.closeApplicationContext();

			WoundDebridmentNonsurgical woundDebridmentNonsurgical = (WoundDebridmentNonsurgical) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			woundDebridmentNonsurgical.setMedicalProcedureInputController(this);
			nonsurgicalCheckBox.setSelected(false);

		} else if (woundCleaningCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalWoundClearingUC", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalWoundClearingUC", null, Locale.US);
			formPath.closeApplicationContext();

			WoundClearingUCInputController woClearingUCInputController = (WoundClearingUCInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			woClearingUCInputController.setMedicalProcedureInputController(this);
			woundCleaningCheckBox.setSelected(false);

		} else if (aspirationCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalAspirationProcedure", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalAspirationProcedure", null,
					Locale.US);
			formPath.closeApplicationContext();

			AspirationProcedureInputController aspirationProcedureInputController = (AspirationProcedureInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			aspirationProcedureInputController.setMedicalProcedureInputController(this);
			aspirationCheckBox.setSelected(false);

		} else if (anoscopyCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalDiagnosticAnoscopy", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalDiagnosticAnoscopy", null, Locale.US);
			formPath.closeApplicationContext();

			DiagnosticAnoscopyInputController diagnosticAnoscopyInputController = (DiagnosticAnoscopyInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			diagnosticAnoscopyInputController.setMedicalProcedureInputController(this);
			anoscopyCheckBox.setSelected(false);

		} else if (waxRemovalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalEarIrrigation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalEarIrrigation", null, Locale.US);
			formPath.closeApplicationContext();

			EarIrrigationInputController earIrrigationInputController = (EarIrrigationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			earIrrigationInputController.setMedicalProcedureInputController(this);
			waxRemovalCheckBox.setSelected(false);

		} else if (wickPlacementCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalEarWrickPlacement", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalEarWrickPlacement", null, Locale.US);
			formPath.closeApplicationContext();

			EarWrickPlacementInputController earWrickPlacementInputController = (EarWrickPlacementInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			earWrickPlacementInputController.setMedicalProcedureInputController(this);
			wickPlacementCheckBox.setSelected(false);

		} else if (drainageCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalEffusionTapDrainage", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalEffusionTapDrainage", null,
					Locale.US);
			formPath.closeApplicationContext();

			EffusionTapDrainageInputController effusionTapDrainageInputController = (EffusionTapDrainageInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			effusionTapDrainageInputController.setMedicalProcedureInputController(this);
			drainageCheckBox.setSelected(false);

		} else if (injectionNoteCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalInjectionNoteMaRn", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalInjectionNoteMaRn", null, Locale.US);
			formPath.closeApplicationContext();

			InjectionNoteMaRnInputController injectionNoteMaRnInputController = (InjectionNoteMaRnInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			injectionNoteMaRnInputController.setMedicalProcedureInputController(this);
			injectionNoteCheckBox.setSelected(false);

		} else if (nasalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalNasalTemponade", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalNasalTemponade", null, Locale.US);
			formPath.closeApplicationContext();

			NasalTemponadeInputController nasalTemponadeInputController = (NasalTemponadeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			nasalTemponadeInputController.setMedicalProcedureInputController(this);
			nasalCheckBox.setSelected(false);

		} else if (oxygenCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalOxygen", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalOxygen", null, Locale.US);
			formPath.closeApplicationContext();

			OxygenInputController oxygenInputController = (OxygenInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			oxygenInputController.setMedicalProcedureInputController(this);
			oxygenCheckBox.setSelected(false);

		} else if (respiratoryProcedureCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalRespiratoryProcedureSupplies", null,
					Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalRespiratoryProcedureSupplies", null,
					Locale.US);
			formPath.closeApplicationContext();

			RespiratoryProcedureSuppliesInputController respiratoryProcedureSuppliesInputController = (RespiratoryProcedureSuppliesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			respiratoryProcedureSuppliesInputController.setMedicalProcedureInputController(this);
			respiratoryProcedureCheckBox.setSelected(false);

		} else if (patientObservationCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalPatientObservation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalPatientObservation", null, Locale.US);
			formPath.closeApplicationContext();

			PatientObservationInputController patientObservationInputController = (PatientObservationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			patientObservationInputController.setMedicalProcedureInputController(this);
			patientObservationCheckBox.setSelected(false);

		} else if (additionalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalPrologedServicesAdditional", null,
					Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalPrologedServicesAdditional", null,
					Locale.US);
			formPath.closeApplicationContext();

			PrologedServicesAdditionalInputController prologedServicesAdditionalInputController = (PrologedServicesAdditionalInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			prologedServicesAdditionalInputController.setMedicalProcedureInputController(this);
			additionalCheckBox.setSelected(false);

		} else if (dislocationCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalReductionOfDislocation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalReductionOfDislocation", null,
					Locale.US);
			formPath.closeApplicationContext();

			ReductionOfDislocationInputController reductionOfDislocationInputController = (ReductionOfDislocationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			reductionOfDislocationInputController.setMedicalProcedureInputController(this);
			dislocationCheckBox.setSelected(false);

		} else if (generalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalSuppliesGeneral", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalSuppliesGeneral", null, Locale.US);
			formPath.closeApplicationContext();

			SuppliesGeneralInputController suppliesGeneralInputController = (SuppliesGeneralInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			suppliesGeneralInputController.setMedicalProcedureInputController(this);
			generalCheckBox.setSelected(false);

		} else if (generalConditionalCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalSuppliesGeneralContinue", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalSuppliesGeneralContinue", null,
					Locale.US);
			formPath.closeApplicationContext();

			SuppliesGeneralContinueInputController suppliesGeneralContinueInputController = (SuppliesGeneralContinueInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			suppliesGeneralContinueInputController.setMedicalProcedureInputController(this);
			generalConditionalCheckBox.setSelected(false);

		} else if (urgentCareCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalUrgentCareCourse", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalUrgentCareCourse", null, Locale.US);
			formPath.closeApplicationContext();

			UrgentCareCourseInputController urgentCareCourseInputController = (UrgentCareCourseInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			urgentCareCourseInputController.setMedicalProcedureInputController(this);
			urgentCareCheckBox.setSelected(false);

		} else if (coordinationCheckBox.isSelected()) {

			formCountIncrement();
			String formName = formPath.context.getMessage("PROCEDUREMedicalCoordinationofCare", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalCoordinationofCare", null, Locale.US);
			formPath.closeApplicationContext();

			CoordinationofCareInputController coordinationofCareInputController = (CoordinationofCareInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			coordinationofCareInputController.setMedicalProcedureInputController(this);
			coordinationCheckBox.setSelected(false);

		}

		else if (secondFormCount == formCount) {
			genericEMRChartingController.paint(button);
			formCount = 0;
			genericEMRChartingController.setProcedureTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(doneBtn);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			setMedUI();

		});

		freeTextBtn.setOnAction((event) -> {
			
			if(armCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Arm,");
				strForFreeText = str1.toString();
				armCheckBox.setSelected(false);
			}

			if(earCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Ear,");
				strForFreeText = str1.toString();
				earCheckBox.setSelected(false);
			}

			if(elbowCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Elbow,");
				strForFreeText = str1.toString();
				elbowCheckBox.setSelected(false);
			}

			if(feetCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Feet,");
				strForFreeText = str1.toString();
				feetCheckBox.setSelected(false);
			}

			if(forearmCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Forearm,");
				strForFreeText = str1.toString();
				forearmCheckBox.setSelected(false);
			}

			if(handCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Hand,");
				strForFreeText = str1.toString();
				handCheckBox.setSelected(false);
			}

			if(legCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Leg,");
				strForFreeText = str1.toString();
				legCheckBox.setSelected(false);
			}

			if(trunkCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Trunk,");
				strForFreeText = str1.toString();
				trunkCheckBox.setSelected(false);
			}

			if(noseCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Nose,");
				strForFreeText = str1.toString();
				noseCheckBox.setSelected(false);
			}

			if(bodyEyeCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("BodyEye,");
				strForFreeText = str1.toString();
				bodyEyeCheckBox.setSelected(false);
			}

			if(neckCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Neck,");
				strForFreeText = str1.toString();
				neckCheckBox.setSelected(false);
			}

			if(sclapCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Sclap,");
				strForFreeText = str1.toString();
				sclapCheckBox.setSelected(false);
			}

			if(toeCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Toe,");
				strForFreeText = str1.toString();
				toeCheckBox.setSelected(false);
			}

			if(eyelidCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Eyelid,");
				strForFreeText = str1.toString();
				eyelidCheckBox.setSelected(false);
			}
			
			if(faceCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Face,");
				strForFreeText = str1.toString();
				faceCheckBox.setSelected(false);
			}

			if(fingerCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Finger,");
				strForFreeText = str1.toString();
				fingerCheckBox.setSelected(false);
			}

			if(bodyUCCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("BodyUC,");
				strForFreeText = str1.toString();
				bodyUCCheckBox.setSelected(false);
			}

			if(sutureCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Suture,");
				strForFreeText = str1.toString();
				sutureCheckBox.setSelected(false);
			}

			if(dislocationCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Disolation,");
				strForFreeText = str1.toString();
				dislocationCheckBox.setSelected(false);
			}

			if(additionalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Additional,");
				strForFreeText = str1.toString();
				additionalCheckBox.setSelected(false);
			}

			if(patientObservationCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("PatientObservation,");
				strForFreeText = str1.toString();
				patientObservationCheckBox.setSelected(false);
			}
			
			if(respiratoryProcedureCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("RepositoryProcedure,");
				strForFreeText = str1.toString();
				respiratoryProcedureCheckBox.setSelected(false);
			}
			
			if(oxygenCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Oxygen,");
				strForFreeText = str1.toString();
				oxygenCheckBox.setSelected(false);
			}
			
			if(nasalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Nasal,");
				strForFreeText = str1.toString();
				nasalCheckBox.setSelected(false);
			}

			if(drainageCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Drainage,");
				strForFreeText = str1.toString();
				drainageCheckBox.setSelected(false);
			}

			if(injectionNoteCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("InjectionNote,");
				strForFreeText = str1.toString();
				injectionNoteCheckBox.setSelected(false);
			}

			if(wickPlacementCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("WickPlacement,");
				strForFreeText = str1.toString();
				wickPlacementCheckBox.setSelected(false);
			}

			if(waxRemovalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("WaxRemoval,");
				strForFreeText = str1.toString();
				waxRemovalCheckBox.setSelected(false);
			}

			if(anoscopyCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Anoscopy,");
				strForFreeText = str1.toString();
				anoscopyCheckBox.setSelected(false);
			}

			if(aspirationCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Aspiration,");
				strForFreeText = str1.toString();
				aspirationCheckBox.setSelected(false);
			}

			if(woundCleaningCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("WoundCleaning,");
				strForFreeText = str1.toString();
				woundCleaningCheckBox.setSelected(false);
			}

			if(iducCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Iduc,");
				strForFreeText = str1.toString();
				iducCheckBox.setSelected(false);
			}

			if(nonsurgicalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Nonsurgical,");
				strForFreeText = str1.toString();
				nonsurgicalCheckBox.setSelected(false);
			}

			if(generalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("General,");
				strForFreeText = str1.toString();
				generalCheckBox.setSelected(false);
			}

			if(generalConditionalCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("GeneralConditional,");
				strForFreeText = str1.toString();
				generalConditionalCheckBox.setSelected(false);
			}

			if(urgentCareCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("UrgentCare,");
				strForFreeText = str1.toString();
				urgentCareCheckBox.setSelected(false);
			}
			
			if(coordinationCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Coordination,");
				strForFreeText = str1.toString();
				coordinationCheckBox.setSelected(false);
			}

			 String formName = formPath.context.getMessage("PROCEDUREMedicalFreeText", null,
			 Locale.US); 
			 String formTitle = formPath.context.getMessage("Title.PROCEDUREMedicalFreeText", null, Locale.US);
			 
			 MedicalProcedureFreeTextController medicalProcedureFreeTextController =
			 (MedicalProcedureFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle); 
			 formPath.closeApplicationContext();
			 medicalProcedureFreeTextController.setMedicalProcedureInputController(this);
			 
			 new FXFormCommonUtilities().closeForm(freeTextBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}
}
