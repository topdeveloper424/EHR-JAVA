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

public class PTExercisesInputController implements Initializable {
	
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox ankleSLSCkeckBox;

	    @FXML
	    private CheckBox ankleRoundBoardCheck;

	    @FXML
	    private CheckBox anklePressCheck;

	    @FXML
	    private CheckBox anklePumpsCheck;

	    @FXML
	    private CheckBox ankleCircleCheck;

	    @FXML
	    private CheckBox backPelvicCheck;

	    @FXML
	    private CheckBox backMarchingCheck;

	    @FXML
	    private CheckBox backMultifidusCheck;

	    @FXML
	    private CheckBox backPiriformisCheck;

	    @FXML
	    private CheckBox backDeadBugCheck;

	    @FXML
	    private CheckBox backHipFlexorCheck;

	    @FXML
	    private CheckBox kneeQuadSetCheck;

	    @FXML
	    private CheckBox kneeHellCheck;

	    @FXML
	    private CheckBox kneeSLRCheck;

	    @FXML
	    private CheckBox kneeAddAbdCheck;

	    @FXML
	    private CheckBox kneeHamstringCheck;

	    @FXML
	    private CheckBox kneeITBCheck;

	    @FXML
	    private CheckBox kneeCalfCheck;

	    @FXML
	    private CheckBox kneeSLSCheck;

	    @FXML
	    private CheckBox kneebalanceCheck;

	    @FXML
	    private CheckBox upperExtremitiesPuttyCheck;

	    @FXML
	    private CheckBox upperExtremitiesWristRangeCheck;

	    @FXML
	    private CheckBox upperExtremitiesWristFlexorCheck;

	    @FXML
	    private CheckBox upperExtremitiesWristExtensorCheck;

	    @FXML
	    private CheckBox upperExtremitiesElbowRangeCheck;

	    @FXML
	    private CheckBox upperExtremitieshandrangeCheck;

	    @FXML
	    private CheckBox upperExtremitiesGripperCheckBox;

	    @FXML
	    private CheckBox upperExtremitiesWristStrengthCheckBox;

	    @FXML
	    private CheckBox shoulderlatPullCheckBox;

	    @FXML
	    private CheckBox shoulderRollsCheck;

	    @FXML
	    private CheckBox shoulderPulleysCheckBox;

	    @FXML
	    private CheckBox shoulderWandExecrcisesCheck;

	    @FXML
	    private CheckBox shoulderLevatorCheck;

	    @FXML
	    private CheckBox shoulderDepressedCheck;

	    @FXML
	    private CheckBox shoulderWallSlidesCheck;

	    @FXML
	    private CheckBox shoulderWallLadderLeft;

	    @FXML
	    private CheckBox shoulderScapularCheck;

	    @FXML
	    private CheckBox shoulderUpperTrapCheck;

	    @FXML
	    private CheckBox ankleCalfStretchCheck;

	    @FXML
	    private CheckBox ankleHellRaisesCheck;

	    @FXML
	    private CheckBox ankleBikeCheck;

	    @FXML
	    private CheckBox backSKCCheck;

	    @FXML
	    private CheckBox ankleTreadmillCheck;

	    @FXML
	    private CheckBox backLTRCheck;

	    @FXML
	    private CheckBox ankleGaitCheck;

	    @FXML
	    private CheckBox backHamstringCheck;

	    @FXML
	    private CheckBox kneeBikeCheck;

	    @FXML
	    private CheckBox kneeLegPressCheck;

	    @FXML
	    private CheckBox upperExtremitiesFingerrangeCheck;

	    @FXML
	    private CheckBox upperExtremitiesOppositionCheck;

	    @FXML
	    private CheckBox shoulderPectStretchCheck;

	    @FXML
	    private CheckBox shoulderUBECheck;

	    @FXML
	    private CheckBox kneeGaitCheck;

	    @FXML
	    private CheckBox ankleLegPressCheck;

	    @FXML
	    private CheckBox ankleBalanceCheck;

	    @FXML
	    private CheckBox backCatCamelCheck;

	    @FXML
	    private CheckBox backSwissBallCheck;

	    @FXML
	    private CheckBox backPoturalCheck;

	    @FXML
	    private CheckBox neckUperTrapCheck;

	    @FXML
	    private CheckBox neckLevatorCheck;

	    @FXML
	    private CheckBox neckChinCheck;

	    @FXML
	    private CheckBox neckShoulderCheck;

	    @FXML
	    private CheckBox neckLTRCheck;

	
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

			
			
			
			if (ankleRoundBoardCheck.isSelected() || ankleCalfStretchCheck.isSelected()
					|| ankleBikeCheck.isSelected() || anklePumpsCheck.isSelected()
					|| ankleHellRaisesCheck.isSelected() || ankleTreadmillCheck.isSelected()
					|| ankleCircleCheck.isSelected() || ankleSLSCkeckBox.isSelected()
					|| ankleGaitCheck.isSelected() || anklePressCheck.isSelected()
					|| ankleLegPressCheck.isSelected() || ankleBalanceCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("ANKLE EXERCISES: Patient exercises include: ");
				resultInputController.str = str.toString();
				
				if (ankleRoundBoardCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" Round board exercises,");
					resultInputController.str = str1.toString();
					
				}if (ankleCalfStretchCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Calf stretch,");
					resultInputController.str = str1.toString();

				}if (ankleBikeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Bike,");
					resultInputController.str = str1.toString();

				}if (anklePumpsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" Ankle pumps,");
					resultInputController.str = str1.toString();
					
				}if (ankleHellRaisesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" Heel raises,");
					resultInputController.str = str1.toString();

				}if (ankleTreadmillCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Treadmill,");
					resultInputController.str = str1.toString();

				}if (ankleCircleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Ankle circles, ");
					resultInputController.str = str1.toString();
					
				}if (ankleSLSCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("SLS,");
					resultInputController.str = str1.toString();

				}if (ankleGaitCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" Gait ,");
					resultInputController.str = str1.toString();

				}if (anklePressCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("");
					resultInputController.str = str1.toString();
					
				}if (ankleLegPressCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Leg press,");
					resultInputController.str = str1.toString();

				}if (ankleBalanceCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" Balance and proprioception exercises.");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			if (backCatCamelCheck.isSelected() || backDeadBugCheck.isSelected()
					|| backHamstringCheck.isSelected() || backHipFlexorCheck.isSelected()
					|| backLTRCheck.isSelected() || backMarchingCheck.isSelected()
					|| backMultifidusCheck.isSelected() || backPelvicCheck.isSelected()
					|| backPiriformisCheck.isSelected() || backPoturalCheck.isSelected()
					|| backSKCCheck.isSelected() || backSwissBallCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("BACK EXERCISES: Patient exercises include: ");
				resultInputController.str = str.toString();
				
				if (backCatCamelCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" cat / camel stretch,");
					resultInputController.str = str1.toString();
					
				}if (backDeadBugCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("dead bug,");
					resultInputController.str = str1.toString();

				}if (backHamstringCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hamstring stretch,");
					resultInputController.str = str1.toString();

				}if (backHipFlexorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hip flexor stretch,");
					resultInputController.str = str1.toString();
					
				}if (backLTRCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" LTR,");
					resultInputController.str = str1.toString();

				}if (backMarchingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" marching, ");
					resultInputController.str = str1.toString();

				}if (backMultifidusCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("multifidus exercises,");
					resultInputController.str = str1.toString();
					
				}if (backPelvicCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" pelvic tilt,");
					resultInputController.str = str1.toString();

				}if (backPiriformisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("piriformis stretch,");
					resultInputController.str = str1.toString();

				}if (backPoturalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("postural exercises and body mechanics,");
					resultInputController.str = str1.toString();
					
				}if (backSKCCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("SKC,");
					resultInputController.str = str1.toString();

				}if (backSwissBallCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("swiss ball exercises");
					resultInputController.str = str1.toString();

				}
				


				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			if (kneeAddAbdCheck.isSelected() || kneebalanceCheck.isSelected()
					|| kneeBikeCheck.isSelected() || kneeGaitCheck.isSelected()
					|| kneeHamstringCheck.isSelected() || kneeHellCheck.isSelected()
					|| kneeITBCheck.isSelected() || kneeLegPressCheck.isSelected()
					|| kneeQuadSetCheck.isSelected() || kneeSLRCheck.isSelected()
					|| kneeSLSCheck.isSelected() || kneeCalfCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("KNEE EXERCISES:  Patient exercises include: ");
				resultInputController.str = str.toString();
				
				if (kneeCalfCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("calf stretch,");
					resultInputController.str = str1.toString();
					
				}if (kneeAddAbdCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" add / abd exercises,");
					resultInputController.str = str1.toString();

				}if (kneebalanceCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("balance and proprioception exercises,");
					resultInputController.str = str1.toString();

				}if (kneeBikeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("bike,");
					resultInputController.str = str1.toString();
					
				}if (kneeGaitCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("gait,");
					resultInputController.str = str1.toString();

				}if (kneeHamstringCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" hamstring stretch,");
					resultInputController.str = str1.toString();

				}if (kneeHellCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" heel slides,");
					resultInputController.str = str1.toString();
					
				}if (kneeITBCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" ITB stretch,");
					resultInputController.str = str1.toString();

				}if (kneeLegPressCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" leg press,");
					resultInputController.str = str1.toString();

				}if (kneeQuadSetCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" quad sets,");
					resultInputController.str = str1.toString();
					
				}if (kneeSLRCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" SLR,");
					resultInputController.str = str1.toString();

				}if (kneeSLSCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("SLS ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			if (upperExtremitiesElbowRangeCheck.isSelected() || upperExtremitiesFingerrangeCheck.isSelected()
					|| upperExtremitiesGripperCheckBox.isSelected() || upperExtremitieshandrangeCheck.isSelected()
					|| upperExtremitiesOppositionCheck.isSelected() || upperExtremitiesPuttyCheck.isSelected()
					|| upperExtremitiesWristExtensorCheck.isSelected() || upperExtremitiesWristFlexorCheck.isSelected()
					
					|| upperExtremitiesWristRangeCheck.isSelected() || upperExtremitiesWristStrengthCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("UPPER EXTREMITIES:  Patient exercises include ");
				resultInputController.str = str.toString();
				
				if (upperExtremitiesElbowRangeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("elbow range of motion exercises,");
					resultInputController.str = str1.toString();
					
				}if (upperExtremitiesFingerrangeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" finger range of motion exercises,");
					resultInputController.str = str1.toString();

				}if (upperExtremitiesGripperCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" gripper , ");
					resultInputController.str = str1.toString();

				}if (upperExtremitieshandrangeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hand range of motion exercises, ");
					resultInputController.str = str1.toString();
					
				}if (upperExtremitiesOppositionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("opposition, ");
					resultInputController.str = str1.toString();

				}if (upperExtremitiesPuttyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" putty exercises, ");
					resultInputController.str = str1.toString();

				}if (upperExtremitiesWristExtensorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" wrist extension stretch, ");
					resultInputController.str = str1.toString();
					
				}if (upperExtremitiesWristFlexorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" wrist flexion stretch, ");
					resultInputController.str = str1.toString();

				}if (upperExtremitiesWristRangeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("wrist range of motion exercises, ");
					resultInputController.str = str1.toString();

				}if (upperExtremitiesWristStrengthCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" wrist strengthening exercises ");
					resultInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			if (neckChinCheck.isSelected()
					|| neckLevatorCheck.isSelected() || neckLTRCheck.isSelected()
					|| neckShoulderCheck.isSelected() || neckUperTrapCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("NECK EXERCISES:  Patient exercises include: ");
				resultInputController.str = str.toString();
				
				if (neckChinCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("chin tuck,");
					resultInputController.str = str1.toString();
					
				}if (neckLevatorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" levator stretch,");
					resultInputController.str = str1.toString();

				}if (neckLTRCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("LTR with neck rotation ,");
					resultInputController.str = str1.toString();

				}if (neckShoulderCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("shoulder roll ,");
					resultInputController.str = str1.toString();
					
				}if (neckUperTrapCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("upper trap stretch,");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			
			if (shoulderDepressedCheck.isSelected() || shoulderlatPullCheckBox.isSelected()
					|| shoulderLevatorCheck.isSelected() || shoulderPectStretchCheck.isSelected()
					|| shoulderPulleysCheckBox.isSelected() || shoulderRollsCheck.isSelected()
					|| shoulderScapularCheck.isSelected() || shoulderUBECheck.isSelected()
					|| shoulderUpperTrapCheck.isSelected() || shoulderWallLadderLeft.isSelected()
					|| shoulderWallSlidesCheck.isSelected() || shoulderWandExecrcisesCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("SHOULDER EXERCISES:  Patient exercises include:  ");
				resultInputController.str = str.toString();
				
				if (shoulderDepressedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("shoulder depression,");
					resultInputController.str = str1.toString();
					
				}if (shoulderlatPullCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" lat pull downs,");
					resultInputController.str = str1.toString();

				}if (shoulderLevatorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("levator stretch, ");
					resultInputController.str = str1.toString();

				}if (shoulderPectStretchCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("pect stretch, ");
					resultInputController.str = str1.toString();
					
				}if (shoulderPulleysCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("pulleys,");
					resultInputController.str = str1.toString();

				}if (shoulderRollsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" shoulder rolls,");
					resultInputController.str = str1.toString();

				}if (shoulderScapularCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" scapular stabilization exercises, ");
					resultInputController.str = str1.toString();
					
				}if (shoulderUBECheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("UBE,");
					resultInputController.str = str1.toString();

				}if (shoulderUpperTrapCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" upper trap stretch,");
					resultInputController.str = str1.toString();

				}if (shoulderWallLadderLeft.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" wall ladder, ");
					resultInputController.str = str1.toString();
					
				}if (shoulderWallSlidesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" wall slides,");
					resultInputController.str = str1.toString();

				}if (shoulderWandExecrcisesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("wand exercise, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
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
