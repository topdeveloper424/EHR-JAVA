package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicalProcedureFreeTextController implements Initializable {

	@FXML
	private TextField summaryText;

	@FXML
	private TextArea additinalText;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	FXMLFormPath formPath = new FXMLFormPath();
	private MedicalProcedureInputController medicalProcedureInputController;

	public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// test();

		summaryText.setText(medicalProcedureInputController.strForFreeText);

		doneBtn.setOnAction((event) -> {

			if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				medicalProcedureInputController.genericEMRChartingController
						.setProcedureTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
				medicalProcedureInputController.genericEMRChartingController.saveAllTextArea();
				medicalProcedureInputController.strForFreeText = "";

			}

			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}

