package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class NewPTProcedureInputController implements Initializable {
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox FunvtionalAssesmentPerformCheck;

    @FXML
    private CheckBox FunctionaCapacityEvaluatiorCheck;

    @FXML
    private CheckBox biofeedbackCheck;

    @FXML
    private CheckBox myofacialCheck;

    @FXML
    private CheckBox neuromuscularCheck;

    @FXML
    private CheckBox sprayCheck;

    @FXML
    private CheckBox IceMassageCheck;

    @FXML
    private CheckBox IontophoresisCheck;

    @FXML
    private CheckBox jointMobilizarCheck;

    @FXML
    private CheckBox tapingCheck;

    @FXML
    private CheckBox IsokineticsCheck;

    @FXML
    private CheckBox OrthoticTrainCheck;

    @FXML
    private CheckBox ExtremityTestingCheck;

    @FXML
    private CheckBox adlInjuryCheck;

    @FXML
    private CheckBox edemaControlCheck;

    @FXML
    private CheckBox PhonophoresisCheck;

    @FXML
    private CheckBox GaitTrainingCheck;

    @FXML
    private CheckBox DebridmentCheck;

    @FXML
    private CheckBox shoulderIncludeCheck;

    @FXML
    private CheckBox kneeIncludeCheck;

    @FXML
    private CheckBox WoundCareCheck;

    @FXML
    private CheckBox ultrasoundCheck;

    @FXML
    private CheckBox TractionManualCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox AdditionalCheck;

    @FXML
    private CheckBox KineticActivityCheck;

    @FXML
    private CheckBox TherapeuticExercisesCheck;

    @FXML
    private CheckBox estimManualCheck;

    @FXML
    private CheckBox ContrastbatTherapyCheck;

    @FXML
    private CheckBox WorkHardeningCheck;

    @FXML
    private CheckBox HandballExercisesCheck;

    @FXML
    private CheckBox WoundDebridmentCheck;

    @FXML
    private CheckBox cervicalIncludeCheck;

    @FXML
    private CheckBox WhirlpoolFluidotherapyCheck;

    @FXML
    private CheckBox IceTherapyCheck;

    @FXML
    private CheckBox wristIncludeCheck;

    @FXML
    private CheckBox lumberIncludeCheck;

    @FXML
    private CheckBox InfraredCheck;

    @FXML
    private CheckBox VasopneumaticDeviceCheck;

    @FXML
    private CheckBox MechanicalTractionCheck;

    @FXML
    private CheckBox FlexballExerxisesCheck;

    @FXML
    private CheckBox HotMoistPackCheck;

    @FXML
    private CheckBox ElectricStimUnattendedCheck;

    @FXML
    private RadioButton ComprehensiveRadio;

    @FXML
    private ToggleGroup pat;

    @FXML
    private RadioButton ExtendedRadio;

    @FXML
    private RadioButton IntermediateRadio;

    @FXML
    private RadioButton DischargeRadio;

    @FXML
    private TextArea detailTextarea;

    @FXML
    private CheckBox DiathermyCheck;

    @FXML
    private CheckBox ColdPackCheck;

    @FXML
    private CheckBox ParaffinBathCheck;

    @FXML
    private CheckBox laserCheck;

    @FXML
    private CheckBox extendedCheck;

    @FXML
    private CheckBox MMTReportHandCheck;

    @FXML
    private CheckBox ComprehensiveCheck;

    @FXML
    private CheckBox RomReportHandCheck;

    @FXML
    private CheckBox IntermediateCheck;

    @FXML
    private CheckBox MuscleReportExtremeCheck;

    @FXML
    private CheckBox ROMReportExtremeCheck;
	
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			
			if (ComprehensiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EVALUATION:  Physical Therapy performed a Comprehensive evaluation per medical provider orders.");
				resultInputController.str = str1.toString();
				
			}if (ExtendedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EVALUATION:  Physical Therapy performed a Extended evaluation per medical provider orders.");
				resultInputController.str = str1.toString();

			}if (IntermediateRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EVALUATION:  Physical Therapy performed a Intermediate evaluation per medical provider orders.");
				resultInputController.str = str1.toString();

			}if (DischargeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EVALUATION:  Physical Therapy performed a Discharge Summary evaluation per medical provider orders.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			if (detailTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +detailTextarea.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (FunvtionalAssesmentPerformCheck.isSelected() || FunctionaCapacityEvaluatiorCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("\nFUNCTIONAL: ");
				resultInputController.str = str.toString();
				
				if (FunvtionalAssesmentPerformCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Functional assessment performed, ");
					resultInputController.str = str1.toString();
					
				}if (FunctionaCapacityEvaluatiorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Functional capacity evaluation, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			if (biofeedbackCheck.isSelected() || neuromuscularCheck.isSelected()
					|| jointMobilizarCheck.isSelected() || myofacialCheck.isSelected()
					|| sprayCheck.isSelected() || tapingCheck.isSelected()
					|| TherapeuticExercisesCheck.isSelected() || IceMassageCheck.isSelected()
					|| ultrasoundCheck.isSelected() || KineticActivityCheck.isSelected()
					|| IontophoresisCheck.isSelected() || TractionManualCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("PROCEDURES:  The following physical therapy procedures were given: ");
				resultInputController.str = str.toString();
				
				if (biofeedbackCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Biofeedback (see notes below), ");
					resultInputController.str = str1.toString();
					
				}if (neuromuscularCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Neuromuscular Reeducation, ");
					resultInputController.str = str1.toString();
					
				}if (jointMobilizarCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Joint Mobilization, ");
					resultInputController.str = str1.toString();

				}if (myofacialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Myofascial Release/STM, ");
					resultInputController.str = str1.toString();
					
				}if (sprayCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Spray and Stretch, ");
					resultInputController.str = str1.toString();

				}if (tapingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Taping, ");
					resultInputController.str = str1.toString();

				}if (TherapeuticExercisesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Therapeutic Exercises, ");
					resultInputController.str = str1.toString();
					
				}if (IceMassageCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Ice Massage, ");
					resultInputController.str = str1.toString();

				}if (ultrasoundCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Ultrasound, ");
					resultInputController.str = str1.toString();
					
				}if (KineticActivityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Kinetic Activity, ");
					resultInputController.str = str1.toString();
					
				}if (IontophoresisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Iontophoresis,  ");
					resultInputController.str = str1.toString();

				}if (TractionManualCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Traction Manual, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			

			
			
			if (AdditionalCheck.isSelected()
					|| adlInjuryCheck.isSelected() || estimManualCheck.isSelected()
					|| IsokineticsCheck.isSelected() || edemaControlCheck.isSelected()
					|| OrthoticTrainCheck.isSelected() || PhonophoresisCheck.isSelected()
					|| ExtremityTestingCheck.isSelected() || GaitTrainingCheck.isSelected()) {

				
				
				if (AdditionalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Additional 15 Min, ");
					resultInputController.str = str1.toString();
					
				}if (adlInjuryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ADL - Injury Prevention, ");
					resultInputController.str = str1.toString();

				}if (estimManualCheck.isSelected()) {


					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("E-Stim Manual, ");
					resultInputController.str = str1.toString();

				}if (edemaControlCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Edema Control, ");
					resultInputController.str = str1.toString();
					
				}if (OrthoticTrainCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Orthotic Train, ");
					resultInputController.str = str1.toString();

				}if (PhonophoresisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Phonophoresis, ");
					resultInputController.str = str1.toString();

				}if (ExtremityTestingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Extremity Testing, ");
					resultInputController.str = str1.toString();
					
				}if (GaitTrainingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Gait Training, ");
					resultInputController.str = str1.toString();

				}if (IsokineticsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Isokinetics >30min, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (WoundDebridmentCheck.isSelected() || ContrastbatTherapyCheck.isSelected()) {

				
				if (WoundDebridmentCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Wound  debridement, ");
					resultInputController.str = str1.toString();
					
				}if (ContrastbatTherapyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("contrast bath therapy, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				
				
			}
			
			
			
			
			
			if (WorkHardeningCheck.isSelected() || HandballExercisesCheck.isSelected()
					|| FlexballExerxisesCheck.isSelected()) {

				
				
				if (WorkHardeningCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Work hardening / simulation, ");
					resultInputController.str = str1.toString();
					
				}if (HandballExercisesCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Handball Exercises, ");
					resultInputController.str = str1.toString();

				}if (FlexballExerxisesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Flexball Exercises, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			if (WoundCareCheck.isSelected() || DebridmentCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("ADDITIONAL:  Addition 15 minutes for ");
				resultInputController.str = str.toString();
				
				if (WoundCareCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("wound care , ");
					resultInputController.str = str1.toString();
					
				}if (DebridmentCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("debridement, ");
					resultInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (shoulderIncludeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("BIOFEEDBACK:  Biofeedback was performed on the Shoulder to monitor scapular stabilization "
						+ "and activation of the rotators during specific exercises.");
				resultInputController.str = str1.toString();

			}
			
			
			if (kneeIncludeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("BIOFEEDBACK:  Biofeedback was performed on the Knee to monitor VMO to VL recruitment and active"
						+ " increased contraction of the VMO and inhibition of the VL during specific therapeutic exercise.");
				resultInputController.str = str1.toString();

			}
			
			
			if (lumberIncludeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" BIOFEEDBACK:  Biofeedback performed on lower abdominal muscles and gluteus medius during lumbar "
						+ "stabilization progression to improve activation of core musculature.");
				resultInputController.str = str1.toString();
				
			}
			
			
			if (cervicalIncludeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("BIOFEEDBACK:  Biofeedback performed on upper and lower trapezius for postural retraining.");
				resultInputController.str = str1.toString();

			}
			
			
			if (wristIncludeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("BIOFEEDBACK: was performed on the wrist to re-educate wrist extensor muscle groups and "
						+ "increase upper extremity function.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (ElectricStimUnattendedCheck.isSelected() || VasopneumaticDeviceCheck.isSelected()
					|| HotMoistPackCheck.isSelected() || InfraredCheck.isSelected()
					|| WhirlpoolFluidotherapyCheck.isSelected() || IceTherapyCheck.isSelected()
					|| ParaffinBathCheck.isSelected() || DiathermyCheck.isSelected()
					|| ColdPackCheck.isSelected() || MechanicalTractionCheck.isSelected()
					|| laserCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("\nMODALITIES:  Patient had the following modalities performed: ");
				resultInputController.str = str.toString();
				
				if (ElectricStimUnattendedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Electric Stim Unattended, ");
					resultInputController.str = str1.toString();
					
				}if (VasopneumaticDeviceCheck.isSelected()) {
					

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Vasopneumatic Device, ");
					resultInputController.str = str1.toString();

				}if (HotMoistPackCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hot/moist pack, ");
					resultInputController.str = str1.toString();

				}if (InfraredCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Infrared, ");
					resultInputController.str = str1.toString();
					
				}if (WhirlpoolFluidotherapyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Whirlpool/Fluidotherapy, ");
					resultInputController.str = str1.toString();

				}if (IceTherapyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ice therapy ");
					resultInputController.str = str1.toString();

				}if (ParaffinBathCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Paraffin Bath, ");
					resultInputController.str = str1.toString();
					
				}if (DiathermyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Diathermy, ");
					resultInputController.str = str1.toString();
					
				}if (ColdPackCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("cold pack ");
					resultInputController.str = str1.toString();

				}if (MechanicalTractionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Mechanical Traction, ");
					resultInputController.str = str1.toString();
					
				}if (laserCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Laser, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			

			
			
			if (ComprehensiveCheck.isSelected()
					|| RomReportHandCheck.isSelected() || extendedCheck.isSelected()
					|| MMTReportHandCheck.isSelected() || IntermediateCheck.isSelected()
					|| MuscleReportExtremeCheck.isSelected() || ROMReportExtremeCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("\nRE-EVALUATION:  ");
				resultInputController.str = str.toString();
				
				if (ComprehensiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("An Comprehensive, ");
					resultInputController.str = str1.toString();
					
				}if (RomReportHandCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ROM w Report - Hand, ");
					resultInputController.str = str1.toString();
					
				}if (extendedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Extended, ");
					resultInputController.str = str1.toString();

				}if (MMTReportHandCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("MMT w Report - Hand, ");
					resultInputController.str = str1.toString();
					
				}if (IntermediateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Intermediate, ");
					resultInputController.str = str1.toString();

				}if (MuscleReportExtremeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Muscle w Report - Extrem - Trunk, ");
					resultInputController.str = str1.toString();

				}if (ROMReportExtremeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ROM w Report - Extrem - Trunk, ");
					resultInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("re-evaluation of patient was performed on this date.");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
