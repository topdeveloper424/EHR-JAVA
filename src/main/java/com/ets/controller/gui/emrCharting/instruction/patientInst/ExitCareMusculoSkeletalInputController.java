package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ExitCareMusculoSkeletalInputController implements Initializable {

    @FXML
    private RadioButton GeneralColdUse;

    @FXML
    private ToggleGroup level;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton GeneralCastCare;

    @FXML
    private RadioButton GeneralHeatUseMoist;

    @FXML
    private RadioButton GeneralRICE;

    @FXML
    private RadioButton GeneralWoundCare;

    @FXML
    private RadioButton GeneralHeat;

    @FXML
    private CheckBox exitcareHead;

    @FXML
    private CheckBox exitcareNeckInjury;

    @FXML
    private CheckBox exitcareBackpain;

    @FXML
    private CheckBox exitcareFacial;

    @FXML
    private CheckBox exitcarePinched;

    @FXML
    private CheckBox exitcareBackExercise;

    @FXML
    private CheckBox upperArm;

    @FXML
    private CheckBox upperCrutch;

    @FXML
    private CheckBox upperShoulder;

    @FXML
    private CheckBox upperCarpal;

    @FXML
    private CheckBox upperElbow;

    @FXML
    private CheckBox upperWrist;

    @FXML
    private CheckBox localAnkle;

    @FXML
    private CheckBox localKnee;

    @FXML
    private CheckBox localCrutch;
	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;


	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionPatientInstInputCotroller.str);
			acupunctureReferalStr.append("\n\nExitcare patient instructions given:  ");
			instructionPatientInstInputCotroller.str = acupunctureReferalStr.toString();

			
				if (GeneralCastCare.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("General Cast Care");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (GeneralColdUse.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("General Cold Use ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (GeneralHeat.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("General Heat ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (GeneralHeatUseMoist.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("General Heat Use (Moist) ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (GeneralRICE.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" General RICE ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (GeneralWoundCare.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("General Wound Care ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				
				//*********
				
				if (exitcareBackExercise.isSelected()) {
                     
					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Back Pain, ");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				if (exitcareBackpain.isSelected()) {
				
					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Back  Exercises, ");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				
				if (exitcareFacial.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Facial Lacerations,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (exitcareHead.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Head Injury, ");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (exitcareNeckInjury.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Neck Injury-Home Care,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (exitcarePinched.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Pinched Nerve in Neck, ");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				//*********
				
				if (upperArm.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Arm Fracture,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				
				if (upperCarpal.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Carpal Tunnel Syndrome,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (upperCrutch.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Crutch Use,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (upperElbow.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Elbow Injury,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (upperShoulder.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Shoulder Pain,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}if (upperWrist.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Wrist Pain (Strain - Sprain). ");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				
				//*********
				
				if (localAnkle.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Ankle Strain,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				if (localCrutch.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Crutch Use,");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				if (localKnee.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Knee Strain.");
					instructionPatientInstInputCotroller.str = str11.toString();
				
				}
				
				++instructionPatientInstInputCotroller.formCount;
				instructionPatientInstInputCotroller.setPatInstUI();
				new FXFormCommonUtilities().closeForm(doneBtn);

			});

			skipBtn.setOnAction((event) -> {
				try {

					++instructionPatientInstInputCotroller.formCount;
					instructionPatientInstInputCotroller.setPatInstUI();
					new FXFormCommonUtilities().closeForm(skipBtn);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

		}

	}
