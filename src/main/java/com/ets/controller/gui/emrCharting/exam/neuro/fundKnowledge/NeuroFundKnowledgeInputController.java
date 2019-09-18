package com.ets.controller.gui.emrCharting.exam.neuro.fundKnowledge;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroFundKnowledgeInputController Class
 *Description:neuroExamFundKnowledge  GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */
public class NeuroFundKnowledgeInputController implements Initializable {

	@FXML
	private CheckBox normalFund;

	@FXML
	private RadioButton fundAppropriate;

	@FXML
	private RadioButton fundLessthan;

	@FXML
	private RadioButton fundGreaterThan;

	@FXML
	private RadioButton fundMarkedlyLessThan;
	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	private NeuroInputController neuroInputController;

	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGICAL");
			neuroInputController.str = skelComp.toString();

			if (normalFund.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Fund of knowledge is appropriate.");
				neuroInputController.str = str1.toString();

			} else {

				
				if (fundAppropriate.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Fund of knowledge appears appropriate to patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundGreaterThan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears greater than patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundLessthan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears less than patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundMarkedlyLessThan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears markedly less than patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}

			}
			
			
			// genericEMRChartingController.saveAllTextArea();
			++neuroInputController.formCount;
			neuroInputController.setNeuroUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++neuroInputController.formCount;
				neuroInputController.setNeuroUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}