package com.ets.controller.gui.emrCharting.pmh.workHistory;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 24-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of TimeAtWorkInputController Class
 *Description: timeAtWork.fxml GUI Controller class
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

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

public class TimeAtWorkInputController implements Initializable {

	@FXML
	private TextField howLongText;

	@FXML
	private RadioButton time1DayRadio;

	@FXML
	private ToggleGroup time1;

	@FXML
	private RadioButton time1YearRadio;

	@FXML
	private RadioButton time1MonthRadio;

	@FXML
	private RadioButton time1Weekradio;

	@FXML
	private TextField howManyText;

	@FXML
	private RadioButton time2DayRadio;

	@FXML
	private ToggleGroup time2;

	@FXML
	private RadioButton time2YearRadio;

	@FXML
	private RadioButton time2MonthRadio;

	@FXML
	private RadioButton time2WeekRadio;

	@FXML
	private RadioButton shiftNormalRadio;

	@FXML
	private ToggleGroup hift;

	@FXML
	private RadioButton shiftSecondRadio;

	@FXML
	private RadioButton shiftThirdRadio;

	@FXML
	private RadioButton isRadio;

	@FXML
	private ToggleGroup was;

	@FXML
	private RadioButton isNotRadio;

	@FXML
	private RadioButton normalFirstRadio;

	@FXML
	private ToggleGroup normal;

	@FXML
	private RadioButton normalSecondRadio;

	@FXML
	private RadioButton normalThirdRadio;

	@FXML
	private TextField timeWorkText;

	@FXML
	private RadioButton hourRadio;

	@FXML
	private ToggleGroup t4;

	@FXML
	private RadioButton minutesRadio;

	@FXML
	private RadioButton recentNormalRadio;

	@FXML
	private ToggleGroup t6;

	@FXML
	private RadioButton recentExtendedRadio;

	@FXML
	private TextField numberText;

	@FXML
	private TextField longWorkingText;

	@FXML
	private RadioButton timeLastDaysRadio;

	@FXML
	private ToggleGroup perio;

	@FXML
	private RadioButton timeLastYearRadio;

	@FXML
	private RadioButton timeLastMonthRadio;

	@FXML
	private RadioButton timeLastWeekRadio;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

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

			if (howLongText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append(" Patient has worked for this employer for " + howLongText.getText());
				pMHWorkHistoryInputController.str = str11.toString();

			}

			if (time1DayRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("days 40 hours per week. ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time1MonthRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" month 40 hours per week.");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time1Weekradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" week 40 hours per week. ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time1YearRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append(" years 40 hours per week. ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (howManyText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append(" and has worked in the current job " + howManyText.getText() + ". ");
				pMHWorkHistoryInputController.str = str11.toString();

			}

			if (time2YearRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from colon cancer ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time2DayRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from lung cancer ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time2MonthRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (time2WeekRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (shiftNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from lung cancer ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (shiftSecondRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (shiftThirdRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (isRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (isNotRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (normalFirstRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from lung cancer ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (normalSecondRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (normalThirdRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (timeWorkText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append("age " + timeWorkText.getText() + ". ");
				pMHWorkHistoryInputController.str = str11.toString();

			}

			if (hourRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (minutesRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (recentNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (recentExtendedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}

			if (numberText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append("age " + numberText.getText() + ". ");
				pMHWorkHistoryInputController.str = str11.toString();

			}

			if (longWorkingText.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append("age " + longWorkingText.getText() + ". ");
				pMHWorkHistoryInputController.str = str11.toString();

			}

			if (timeLastDaysRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (timeLastWeekRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (timeLastMonthRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from substance abuse ");
				pMHWorkHistoryInputController.str = str1.toString();

			}
			if (timeLastYearRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHWorkHistoryInputController.str);
				str1.append("Mother died from trauma / accident ");
				pMHWorkHistoryInputController.str = str1.toString();

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
