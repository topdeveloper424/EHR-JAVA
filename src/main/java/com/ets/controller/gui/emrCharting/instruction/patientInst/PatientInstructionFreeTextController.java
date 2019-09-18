package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientInstructionFreeTextController implements Initializable {

    @FXML
    private TextField summaryText;

    @FXML
    private TextArea additinalText;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;

	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		summaryText.setText(instructionPatientInstInputCotroller.strForFreeText);

		doneBtn.setOnAction((event) -> {

			if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				instructionPatientInstInputCotroller.genericEMRChartingController.setInstructionTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
						
				instructionPatientInstInputCotroller.genericEMRChartingController.saveAllTextArea();
				instructionPatientInstInputCotroller.strForFreeText = " ";

			}

			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}
