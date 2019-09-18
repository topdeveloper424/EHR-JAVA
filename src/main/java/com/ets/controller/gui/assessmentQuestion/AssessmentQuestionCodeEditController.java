package com.ets.controller.gui.assessmentQuestion;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.assesmentQuestion.AssesmentQuestionEntityController;
import com.ets.model.AssesmentQuestion;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Original Author:Sumanta Deyashi on Behalf of ETS for Client
 * Company File Creation Date: 27-07-2016 
 * Initial Version: 0.01 
 * Module Name:
 * Parameter Definition: Type object of AssessmentQuestionCodeEditController Class
 * Description: Edit.fxml Controller class 
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

public class AssessmentQuestionCodeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField textTextField;

	@FXML
	private TextField idTextField;

	private AssesmentQuestion assesmentQuestion;

	public void setAssesmentQuestion(AssesmentQuestion assesmentQuestion) {
		this.assesmentQuestion = assesmentQuestion;

		idTextField.setText(Integer.toString(assesmentQuestion.getId()));
		codeTextField.setText(assesmentQuestion.getCode());
		textTextField.setText(assesmentQuestion.getText());

		if (assesmentQuestion.getInactive() == true) {

			inactiveCheckBox.setSelected(true);

		} else {

			inactiveCheckBox.setSelected(false);

		}
	}

	private AssessmentQuestionCodeViewController assessmentQuestionCodeViewController;

	public void setAssessmentQuestionCodeViewController(
			AssessmentQuestionCodeViewController assessmentQuestionCodeViewController) {
		this.assessmentQuestionCodeViewController = assessmentQuestionCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			try {

				AssesmentQuestion assesmentQuestion = new AssesmentQuestion();

				assesmentQuestion.setId(Integer.parseInt(idTextField.getText()));
				assesmentQuestion.setCode(codeTextField.getText());
				assesmentQuestion.setText(textTextField.getText());
				assesmentQuestion.setInactive(inactiveCheckBox.isSelected());

				new AssesmentQuestionEntityController().update(assesmentQuestion);
				assessmentQuestionCodeViewController.refreshAssesmentQuestion();
				try {

					new FXFormCommonUtilities().closeForm(updateButton);
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
