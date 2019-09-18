package com.ets.controller.gui.emrCharting.pmh.medication;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicationFreeTextInputController implements Initializable{

	@FXML
	private TextField summaryText;

	@FXML
	private TextArea additinalText;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;
	private Button button;
	
	
	
	
	
	
	private PMHMedicationInputController pmhMedicationInputController;
	
	
	
	public GenericEMRChartingController genericEMRChartingController;
	
	
	
	
	public void setPmhMedicationInputController(PMHMedicationInputController pmhMedicationInputController) {
		this.pmhMedicationInputController = pmhMedicationInputController;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		summaryText.setText(pmhMedicationInputController.strForFreeText);

		doneBtn.setOnAction((event) -> {
			
				if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				pmhMedicationInputController.genericEMRChartingController
						.setPmhTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
				pmhMedicationInputController.genericEMRChartingController.saveAllTextArea();
				pmhMedicationInputController.strForFreeText = " ";
				pmhMedicationInputController.genericEMRChartingController.paint(doneBtn);

			}
				//genericEMRChartingController.paint(doneBtn);
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}
