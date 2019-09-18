package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExitCareWeightInputController  implements Initializable {

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox exitcareWeightLossDiet;

    @FXML
    private CheckBox exitcareDietDiabetic;

    @FXML
    private CheckBox exitcareWeightLoss;

    @FXML
    private CheckBox exitcareDietCholesterol;
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

			
			if (exitcareDietCholesterol.isSelected()||exitcareDietDiabetic.isSelected()
					||exitcareWeightLoss.isSelected()||exitcareWeightLossDiet.isSelected()
					) {

				StringBuilder str22 = new StringBuilder(instructionPatientInstInputCotroller.str);
				str22.append("Exitcare patient instructions given: ");
				instructionPatientInstInputCotroller.str = str22.toString();

			


				if (exitcareDietCholesterol.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Diet - Cholesterol,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}


				if (exitcareDietDiabetic.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Diet - Diabetic,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareWeightLoss.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Weight Loss,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareWeightLossDiet.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Weight Loss Diet,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
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
