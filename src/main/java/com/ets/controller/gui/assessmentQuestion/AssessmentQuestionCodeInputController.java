package com.ets.controller.gui.assessmentQuestion;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.assesmentQuestion.AssesmentQuestionEntityController;
import com.ets.model.AssesmentQuestion;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

/**
 * Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client
 * Company File Creation Date: 06-02-2016 
 * Initial Version: 0.01 
 * Module Name:
 * Parameter Definition: Type object of AssessmentQuestionCodeInputController Class
 * Description: Enter.fxml Controller class 
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 */

public class AssessmentQuestionCodeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField textTextField;

	private AssessmentQuestionCodeViewController assessmentQuestionCodeViewController;

	public void setAssessmentQuestionCodeViewController(
			AssessmentQuestionCodeViewController assessmentQuestionCodeViewController) {
		this.assessmentQuestionCodeViewController = assessmentQuestionCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {
			try {

				AssesmentQuestion assesmentQuestion = new AssesmentQuestion();
				assesmentQuestion.setCode(codeTextField.getText());
				assesmentQuestion.setText(textTextField.getText());
				assesmentQuestion.setInactive(inactiveCheckBox.isSelected());

				new AssesmentQuestionEntityController().save(assesmentQuestion);
				assessmentQuestionCodeViewController.refreshAssesmentQuestion();
				try {

					new FXFormCommonUtilities().closeForm(okButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
