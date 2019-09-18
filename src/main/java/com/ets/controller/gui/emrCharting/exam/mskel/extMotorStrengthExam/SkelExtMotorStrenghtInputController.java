package com.ets.controller.gui.emrCharting.exam.mskel.extMotorStrengthExam;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelExtMotorStrenghtInputController Class
 *Description: EditDistrict GUI Controller class
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
public class SkelExtMotorStrenghtInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox LeftUEMuscleNormal;

	@FXML
	private CheckBox leftUpperPartExtremity;
	@FXML
	private CheckBox RightLowerPartFoot;
	@FXML
	private CheckBox leftUpperPartShoulder;

	@FXML
	private CheckBox leftUpperPartBiceps;

	@FXML
	private CheckBox leftUpperPartTriceps;

	@FXML
	private CheckBox leftUpperPartForearm;

	@FXML
	private CheckBox leftUpperPartWrist;

	@FXML
	private CheckBox RightUpperAllActions;

	@FXML
	private CheckBox RightUpperExtension;

	@FXML
	private CheckBox RightUpperFlexion;

	@FXML
	private CheckBox RightUpperadduction;

	@FXML
	private CheckBox RightUpperPranotion;

	@FXML
	private CheckBox RightUpperSupination;

	@FXML
	private CheckBox RightUpperPartExtremity;

	@FXML
	private CheckBox RightUpperPartShoulder;

	@FXML
	private CheckBox RightUpperPartBiceps;

	@FXML
	private CheckBox AccomodationRightUnResponsiveCheck;

	@FXML
	private CheckBox RightUpperPartForearm;

	@FXML
	private CheckBox leftUpperAllActions;

	@FXML
	private CheckBox leftUpperadduction;

	@FXML
	private CheckBox leftUpperExtension;

	@FXML
	private CheckBox leftUpperPranotion;

	@FXML
	private CheckBox leftUpperFlexion;

	@FXML
	private CheckBox leftUpperSupination;

	@FXML
	private CheckBox RightUENormal;

	@FXML
	private CheckBox RightUpperPartWrist;

	@FXML
	private CheckBox RightUpperPartHand;

	@FXML
	private RadioButton LeftUEMuscleSlightlyRadio;

	@FXML
	private RadioButton LeftUEMuscleModerateadio;

	@FXML
	private RadioButton LeftUEMuscleMarkedlyRadio;

	@FXML
	private RadioButton LeftUEMuscleAbsentRadio;

	@FXML
	private CheckBox leftUpperPartHand;

	@FXML
	private CheckBox leftUpperPartGrip;
	@FXML
	private CheckBox RightUpperPartGrip;
	@FXML
	private CheckBox RightUpperParttriceps;

	@FXML
	private RadioButton RightUESlightlyDecreasedRadio;

	@FXML
	private RadioButton RightUEModeratelyDecreasedRadio;

	@FXML
	private RadioButton RightUEAbsentRadio;

	@FXML
	private RadioButton RightUEMarkedlyDecreasedRadio;

	@FXML
	private CheckBox lidsChalazionCheck11;

	@FXML
	private CheckBox LeftLEMuscleNormal;

	@FXML
	private RadioButton LeftLESlightlyDecreasedRadio;

	@FXML
	private RadioButton LeftLEModeratelyDecreasedRadio;

	@FXML
	private RadioButton LeftLEMarkedlyDecreasedRadio;

	@FXML
	private RadioButton LeftLEAbsentRadio;

	@FXML
	private CheckBox LeftLowerAllActions;

	@FXML
	private CheckBox LeftLoweradduction;

	@FXML
	private CheckBox LeftLowerExtension;

	@FXML
	private CheckBox LeftLowerPranotion;

	@FXML
	private CheckBox leftLowerFlexion;

	@FXML
	private CheckBox leftLowerSupination;

	@FXML
	private CheckBox LeftLowerPartExtremity;

	@FXML
	private CheckBox LeftForearmPartExtremity;

	@FXML
	private CheckBox LeftShoulderPartExtremity;

	@FXML
	private CheckBox LeftWristPartExtremity;

	@FXML
	private CheckBox LeftBicepsPartExtremity;

	@FXML
	private CheckBox LeftHandPartExtremity;

	@FXML
	private CheckBox LeftTricepsPartExtremity;

	@FXML
	private CheckBox LeftGripPartExtremity;

	@FXML
	private CheckBox RightLENormal;

	@FXML
	private RadioButton RightLESlightlyDecreasedRadio;

	@FXML
	private RadioButton RightLEModeratelyDecreasedRadio;

	@FXML
	private RadioButton RightLEMarkedlyDecreasedRadio;

	@FXML
	private RadioButton RightLEAbsentRadio;

	@FXML
	private CheckBox RightLowerAllActions;

	@FXML
	private CheckBox RighLoweradduction;

	@FXML
	private CheckBox RightLowerExtension;

	@FXML
	private CheckBox RightLowerPranotion;

	@FXML
	private CheckBox RightLowerFlexion;

	@FXML
	private CheckBox RightLowerSupination;

	@FXML
	private CheckBox RightLowerPartExtremity;

	@FXML
	private CheckBox lidsNormalBilaterallyCheck21;

	@FXML
	private CheckBox RightLowerPartHip;

	@FXML
	private CheckBox RightLowerPartToes;

	@FXML
	private CheckBox RightLowerPartKnee;

	@FXML
	private CheckBox RightLowerPartAnkle;

	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {
			StringBuilder examBasic = new StringBuilder(msSkelInputController.str);
			examBasic.append("\n\nMotor strength testing of the ");
			msSkelInputController.str = examBasic.toString();

			if (leftUpperPartExtremity.isSelected() || leftUpperPartForearm.isSelected()
					|| leftUpperPartShoulder.isSelected() || leftUpperPartWrist.isSelected()
					|| leftUpperPartHand.isSelected() || leftUpperPartGrip.isSelected()
					|| leftUpperPartTriceps.isSelected() || LeftUEMuscleNormal.isSelected()
					|| LeftUEMuscleSlightlyRadio.isSelected() || LeftUEMuscleModerateadio.isSelected()
					|| LeftUEMuscleMarkedlyRadio.isSelected() || LeftUEMuscleAbsentRadio.isSelected()
					||leftUpperAllActions.isSelected() || leftUpperadduction.isSelected() || leftUpperExtension.isSelected()
					|| leftUpperPranotion.isSelected() || leftUpperFlexion.isSelected()
					|| leftUpperSupination.isSelected()
					) {
				
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("  left upper extremity: ");
				msSkelInputController.str = str1.toString();

			}

			if (LeftUEMuscleNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("normal.");
				msSkelInputController.str = str1.toString();

			}
			else{
				
			
			if (LeftUEMuscleSlightlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" slightly decreased. ");
				msSkelInputController.str = str1.toString();

			}

			if (LeftUEMuscleModerateadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" moderately decreased.");
				msSkelInputController.str = str1.toString();

			}

			if (LeftUEMuscleMarkedlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" Markedly decreased.");
				msSkelInputController.str = str1.toString();

			}

			if (LeftUEMuscleAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" absent.");
				msSkelInputController.str = str1.toString();

			}
		}
			if (leftUpperAllActions.isSelected() || leftUpperadduction.isSelected() || leftUpperExtension.isSelected()
					|| leftUpperPranotion.isSelected() || leftUpperFlexion.isSelected()
					|| leftUpperSupination.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("for");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperAllActions.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" all actions,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperadduction.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" adduction,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperExtension.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" extension,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPranotion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" pronation,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperFlexion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" flexion,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperSupination.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" supination,");
				msSkelInputController.str = str1.toString();

			}

			if (leftUpperPartExtremity.isSelected() || leftUpperPartForearm.isSelected()
					|| leftUpperPartShoulder.isSelected() || leftUpperPartWrist.isSelected()
					|| leftUpperPartHand.isSelected() || leftUpperPartGrip.isSelected()
					|| leftUpperPartTriceps.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("  of the ");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" extremity,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartForearm.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" forearm,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartShoulder.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" shoulder,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartWrist.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" wrist,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartHand.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" hand,");
				msSkelInputController.str = str1.toString();

			}
			if (leftUpperPartTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" triceps,");
				msSkelInputController.str = str1.toString();

			}

			if (leftUpperPartGrip.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" grip,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperAllActions.isSelected() || RightUpperadduction.isSelected()
					|| RightUpperExtension.isSelected() || RightUpperPranotion.isSelected()
					|| RightUpperSupination.isSelected() || RightUpperFlexion.isSelected() || RightUENormal.isSelected()
					|| RightUESlightlyDecreasedRadio.isSelected() || RightUEModeratelyDecreasedRadio.isSelected()
					|| RightUEMarkedlyDecreasedRadio.isSelected() || RightUEAbsentRadio.isSelected()
					|| RightUpperPartExtremity.isSelected() || RightUpperPartForearm.isSelected()
					|| RightUpperPartShoulder.isSelected() || RightUpperPartWrist.isSelected()
					|| RightUpperPartHand.isSelected() || RightUpperPartGrip.isSelected()
					|| RightUpperParttriceps.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" .Right upper extremity: ");
				msSkelInputController.str = str1.toString();

			}

			if (RightUENormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("  normal");
				msSkelInputController.str = str1.toString();

			}
			else{
				
			if (RightUESlightlyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" slightly decreased.");
				msSkelInputController.str = str1.toString();

			}
			if (RightUEModeratelyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" moderately decreased.");
				msSkelInputController.str = str1.toString();

			}
			if (RightUEMarkedlyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" markedly decreased.");
				msSkelInputController.str = str1.toString();

			}
			if (RightUEAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" absent.");
				msSkelInputController.str = str1.toString();

			}
			
		}
			if (RightUpperAllActions.isSelected() || RightUpperadduction.isSelected()
					|| RightUpperExtension.isSelected() || RightUpperPranotion.isSelected()
					|| RightUpperSupination.isSelected() || RightUpperFlexion.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" for ");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperAllActions.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" all actions,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperadduction.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" adduction, ");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperExtension.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" extension,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPranotion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" pranotion,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperSupination.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" supination,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperFlexion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" flexion,");
				msSkelInputController.str = str1.toString();

			}

			if (RightUpperPartExtremity.isSelected() || RightUpperPartForearm.isSelected()
					|| RightUpperPartShoulder.isSelected() || RightUpperPartWrist.isSelected()
					|| RightUpperPartHand.isSelected() || RightUpperPartGrip.isSelected()
					|| RightUpperParttriceps.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("  of the ");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" extremity,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartShoulder.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" shoulder,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartForearm.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" forearm,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartHand.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" hand,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartGrip.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" grip,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperPartWrist.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" wrist,");
				msSkelInputController.str = str1.toString();

			}
			if (RightUpperParttriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" triceps,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftLowerAllActions.isSelected() || LeftLoweradduction.isSelected() || LeftLowerExtension.isSelected()
					|| LeftLowerPranotion.isSelected() || leftLowerSupination.isSelected()
					|| leftLowerFlexion.isSelected() || LeftLEMuscleNormal.isSelected()
					|| LeftLESlightlyDecreasedRadio.isSelected() || LeftLEModeratelyDecreasedRadio.isSelected()
					|| LeftLEMarkedlyDecreasedRadio.isSelected() || LeftLEAbsentRadio.isSelected()
					|| LeftLowerPartExtremity.isSelected() || LeftForearmPartExtremity.isSelected()
					|| LeftShoulderPartExtremity.isSelected() || LeftWristPartExtremity.isSelected()
					|| LeftBicepsPartExtremity.isSelected() || LeftHandPartExtremity.isSelected()
					|| LeftTricepsPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(".Left lower extremity: ");
				msSkelInputController.str = str1.toString();

			}

			if (LeftLEMuscleNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" normal ");
				msSkelInputController.str = str1.toString();

			}
			else{
		
			if (LeftLESlightlyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" slightly decreased ");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLEModeratelyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" moderately decreased ");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLEMarkedlyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" markedly decreased ");
				msSkelInputController.str = str1.toString();

			}

			if (LeftLEAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" absent");
				msSkelInputController.str = str1.toString();

			}

			}
			if (LeftLowerAllActions.isSelected() || LeftLoweradduction.isSelected() || LeftLowerExtension.isSelected()
					|| LeftLowerPranotion.isSelected() || leftLowerSupination.isSelected()
					|| leftLowerFlexion.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" for ");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLowerAllActions.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("actions, ");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLoweradduction.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("adduction,");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLowerExtension.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("extension,");
				msSkelInputController.str = str1.toString();

			}
			if (LeftLowerPranotion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("pranotion,");
				msSkelInputController.str = str1.toString();

			}
			if (leftLowerSupination.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("supination,");
				msSkelInputController.str = str1.toString();

			}
			if (leftLowerFlexion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("flexion,");
				msSkelInputController.str = str1.toString();

			}

			/*
			 * if (RightUpperPartExtremity.isSelected() ||
			 * RightUpperPartForearm.isSelected() ||
			 * RightUpperPartShoulder.isSelected() ||
			 * RightUpperPartWrist.isSelected() ||
			 * RightUpperPartHand.isSelected() ||
			 * RightUpperPartGrip.isSelected() ||
			 * RightUpperParttriceps.isSelected()) { StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append(" ");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartExtremity.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartShoulder.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartForearm.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartHand.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartGrip.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperPartWrist.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * } if (RightUpperParttriceps.isSelected()) {
			 * 
			 * StringBuilder str1 = new
			 * StringBuilder(msSkelInputController.str); str1.append("");
			 * msSkelInputController.str = str1.toString();
			 * 
			 * }
			 */

			if (LeftLowerPartExtremity.isSelected() || LeftForearmPartExtremity.isSelected()
					|| LeftShoulderPartExtremity.isSelected() || LeftWristPartExtremity.isSelected()
					|| LeftBicepsPartExtremity.isSelected() || LeftHandPartExtremity.isSelected()
					|| LeftTricepsPartExtremity.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("of the ");
				msSkelInputController.str = str1.toString();

			}

			if (LeftLowerPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("extremity,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftForearmPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("forearm,");
				msSkelInputController.str = str1.toString();

			}
			if (LeftShoulderPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("shoulder,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftWristPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("wrist,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftBicepsPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("biceps,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftHandPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("hand,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftTricepsPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("triceps,");
				msSkelInputController.str = str1.toString();

			}

			if (LeftGripPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("grip,");
				msSkelInputController.str = str1.toString();

			}

			if (RightLowerAllActions.isSelected() || RightLowerExtension.isSelected() || RightLowerFlexion.isSelected()
					|| RighLoweradduction.isSelected() || RightLowerPranotion.isSelected()
					|| RightLowerSupination.isSelected() || RightLENormal.isSelected()
					|| RightLESlightlyDecreasedRadio.isSelected() || RightLEModeratelyDecreasedRadio.isSelected()
					|| RightLEMarkedlyDecreasedRadio.isSelected() || RightLEAbsentRadio.isSelected()
					|| RightLowerPartExtremity.isSelected() || RightLowerPartHip.isSelected()
					|| RightLowerPartKnee.isSelected() || RightLowerPartFoot.isSelected()
					|| RightLowerPartToes.isSelected() || RightLowerPartAnkle.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(". Right lower extremity: ");
				msSkelInputController.str = str1.toString();

			}

			if (RightLENormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" normal.");
				msSkelInputController.str = str1.toString();

			}

			else
				{
				if (RightLESlightlyDecreasedRadio.isSelected()) {
				

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" slightly decreased.");
				msSkelInputController.str = str1.toString();

			}

			if (RightLEModeratelyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" moderately decreased.");
				msSkelInputController.str = str1.toString();

			}

			if (RightLEMarkedlyDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("markedly decreased.");
				msSkelInputController.str = str1.toString();

			}

			if (RightLEAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("absent.");
				msSkelInputController.str = str1.toString();

			}
				}			if (RightLowerAllActions.isSelected() || RightLowerExtension.isSelected() || RightLowerFlexion.isSelected()
					|| RighLoweradduction.isSelected() || RightLowerPranotion.isSelected()
					|| RightLowerSupination.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("  for ");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerAllActions.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("all actions,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerExtension.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("extension,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerFlexion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("flexion,");
				msSkelInputController.str = str1.toString();

			}
			if (RighLoweradduction.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("adduction");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPranotion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("pranotion");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerSupination.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("supination");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPartExtremity.isSelected() || RightLowerPartHip.isSelected()
					|| RightLowerPartKnee.isSelected() || RightLowerPartFoot.isSelected()
					|| RightLowerPartToes.isSelected() || RightLowerPartAnkle.isSelected()) {
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" of the ");
				msSkelInputController.str = str1.toString();

			}

			if (RightLowerPartExtremity.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("extremity,");
				msSkelInputController.str = str1.toString();

			}

			if (RightLowerPartHip.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("hip,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPartKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("knee,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPartFoot.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("foot,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPartToes.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("toes,");
				msSkelInputController.str = str1.toString();

			}
			if (RightLowerPartAnkle.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("ankle,");
				msSkelInputController.str = str1.toString();

			}
			StringBuilder str1 = new StringBuilder(msSkelInputController.str);
			str1.append(".");
			msSkelInputController.str = str1.toString();

			++msSkelInputController.formCount;
			msSkelInputController.setSkelUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++msSkelInputController.formCount;
				msSkelInputController.setSkelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}
}