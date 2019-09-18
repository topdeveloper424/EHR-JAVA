package com.ets.controller.gui.emrCharting.pmh.allergy;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHAllergyInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AllergyFreeTextController implements Initializable {

	@FXML
	private TextField summaryText;

	@FXML
	private TextArea additinalText;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	FXMLFormPath formPath = new FXMLFormPath();
	private PMHAllergyInputController pMHAllergyInputController;

	public void setpMHAllergyInputController(PMHAllergyInputController pMHAllergyInputController) {
		this.pMHAllergyInputController = pMHAllergyInputController;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// test();

		summaryText.setText(pMHAllergyInputController.strForFreeText);

		doneBtn.setOnAction((event) -> {

			if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				pMHAllergyInputController.genericEMRChartingController
						.setPmhTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
				pMHAllergyInputController.genericEMRChartingController.saveAllTextArea();
				pMHAllergyInputController.strForFreeText = "";

			}

			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}
