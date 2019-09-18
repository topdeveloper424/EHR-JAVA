package com.ets.controller.gui.emrCharting.pmh.familyHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FamilyHistoryFreeTextController implements Initializable {

	@FXML
	private TextField summaryText;

	@FXML
	private TextArea additinalText;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	private PMHFamilyHistoryInputController pMHFamilyHistoryInputController;

	public void setpMHFamilyHistoryInputController(PMHFamilyHistoryInputController pMHFamilyHistoryInputController) {
		this.pMHFamilyHistoryInputController = pMHFamilyHistoryInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		summaryText.setText(pMHFamilyHistoryInputController.strForFreeText);

		doneBtn.setOnAction((event) -> {

			if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				pMHFamilyHistoryInputController.genericEMRChartingController
						.setPmhTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
				pMHFamilyHistoryInputController.genericEMRChartingController.saveAllTextArea();
				pMHFamilyHistoryInputController.strForFreeText = "";

			}

			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}
