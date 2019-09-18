package com.ets.controller.gui.emrCharting.pmh.problem;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHProblemInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProblemFreeTextController implements Initializable {
	@FXML
	private TextField summaryText;

	@FXML
	private TextArea additinalText;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;
	FXMLFormPath formPath = new FXMLFormPath();

	private PMHProblemInputController pMHProblemInputController;

	public void setpMHProblemInputController(PMHProblemInputController pMHProblemInputController) {
		this.pMHProblemInputController = pMHProblemInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		summaryText.setText(pMHProblemInputController.strForFreeText);

		doneBtn.setOnAction((event) -> {

			if (additinalText.getText().length() > 0 || summaryText.getText().length() > 0) {

				pMHProblemInputController.genericEMRChartingController
						.setPmhTextArea("\n" + summaryText.getText() + "\n" + additinalText.getText());
				pMHProblemInputController.genericEMRChartingController.saveAllTextArea();
				pMHProblemInputController.strForFreeText = "";

			}

			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

	}

}
