package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ProtectiveMeasuresInputController implements Initializable {
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox wearSplintCheck;

	    @FXML
	    private CheckBox wearProductiveCheck;

	    @FXML
	    private CheckBox avoidDrivingCheck;

	    @FXML
	    private CheckBox keepBandagesCheck;

	    @FXML
	    private CheckBox avoidDrivingAfterMedicationCheck;

	    @FXML
	    private CheckBox avoidUnprotectedCheck;
	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;


	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionPatientInstInputCotroller.str);
			acupunctureReferalStr.append("\n\n ");
			instructionPatientInstInputCotroller.str = acupunctureReferalStr.toString();

			if (avoidDrivingAfterMedicationCheck.isSelected()||wearSplintCheck.isSelected()
					||wearProductiveCheck.isSelected()||avoidDrivingCheck.isSelected()
					||keepBandagesCheck.isSelected()||avoidUnprotectedCheck.isSelected()
					
					) {

				StringBuilder str13 = new StringBuilder(instructionPatientInstInputCotroller.str);
				str13.append("Patient instructed to observe the following protective measure(s): ");
				instructionPatientInstInputCotroller.str = str13.toString();

			

				if (wearSplintCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("wear splint or brace, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (wearProductiveCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("wear protective lenses, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (avoidDrivingCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("avoid driving, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (keepBandagesCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" keep bandages dry & clean, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (avoidUnprotectedCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("avoid unprotected heights, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}

				if (avoidDrivingAfterMedicationCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" avoid driving after medication ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
			
				StringBuilder str12 = new StringBuilder(instructionPatientInstInputCotroller.str);
				str12.append(".");
				instructionPatientInstInputCotroller.str = str12.toString();

			
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
