package com.ets.controller.gui.emrCharting.pmh.workHistory;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CurrentEmploymentInputController Class
 *Description: currentEmp.fxml GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHWorkHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CurrentEmploymentInputController implements Initializable {

	@FXML
	private RadioButton fullTimeRadio;

	@FXML
	private ToggleGroup level;

	@FXML
	private RadioButton partTimeRadio;

	@FXML
	private RadioButton electriccalWorkerRadio;

	@FXML
	private ToggleGroup general;

	@FXML
	private RadioButton dataProcessingRadio;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private RadioButton sessionallyRadio;

	@FXML
	private RadioButton temporallyRadio;

	@FXML
	private RadioButton selfEmplyedRadio;

	@FXML
	private RadioButton driverRadio;

	@FXML
	private RadioButton managerRadio;

	@FXML
	private RadioButton officeWorkerRadio;

	@FXML
	private RadioButton salesProfessionalRadio;

	@FXML
	private RadioButton agriculturalRadio;

	@FXML
	private RadioButton businessOwnerRadio;

	@FXML
	private RadioButton executiveRadio;

	@FXML
	private RadioButton manualRadio;

	@FXML
	private RadioButton professionalRadio;

	@FXML
	private RadioButton technicianRadio;

	@FXML
	private RadioButton mederatelyRadio;

	@FXML
	private ToggleGroup physical;

	@FXML
	private RadioButton physicialSedenlaryRadio;

	@FXML
	private RadioButton phisicialDemandRadio;

	@FXML
	private TextField jobYearRadio;

	private PMHWorkHistoryInputController pMHWorkHistoryInputController;

	public void setpMHWorkHistoryInputController(PMHWorkHistoryInputController pMHWorkHistoryInputController) {
		this.pMHWorkHistoryInputController = pMHWorkHistoryInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder pmhAllergyStr = new StringBuilder(pMHWorkHistoryInputController.str);
			pmhAllergyStr.append("\n\n ");
			pMHWorkHistoryInputController.str = pmhAllergyStr.toString();

			if (fullTimeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Patient currently works full time ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (partTimeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Patient currently works part time ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (sessionallyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Patient currently works sessionally ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (selfEmplyedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Patient currently works self employed ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (temporallyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Patient currently works temporally ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (agriculturalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) agricultural worker ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (businessOwnerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) business owner ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (electriccalWorkerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) electrical worker ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (dataProcessingRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) data processing professional ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (driverRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) driver ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (executiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) executive ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (managerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) manager ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (manualRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) manual labourer ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (officeWorkerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) office worker ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (professionalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) professional ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (salesProfessionalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) sales professional ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (technicianRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" as a(n) technician ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (mederatelyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("a physically mederately demanding");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (phisicialDemandRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("a physically demanding position.");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (physicialSedenlaryRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("a physically sedentary position.");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (jobYearRadio.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append("for the past " + jobYearRadio.getText() + " years.");
				pMHWorkHistoryInputController.str = str11.toString();

			}

			++pMHWorkHistoryInputController.formCount;
			pMHWorkHistoryInputController.setWorkHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++pMHWorkHistoryInputController.formCount;
				pMHWorkHistoryInputController.setWorkHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
