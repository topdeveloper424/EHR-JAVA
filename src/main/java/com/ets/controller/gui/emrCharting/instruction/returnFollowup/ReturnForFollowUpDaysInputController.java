package com.ets.controller.gui.emrCharting.instruction.returnFollowup;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ReturnForFollowUpDaysInputController implements Initializable{



    @FXML
    private RadioButton year;

    @FXML
    private ToggleGroup level;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton day;

    @FXML
    private RadioButton days;

    @FXML
    private RadioButton month;

    @FXML
    private RadioButton weeks;

    @FXML
    private RadioButton week;

    @FXML
    private RadioButton months;

    @FXML
    private TextField howManyText;

    @FXML
    private RadioButton years;

    @FXML
    private CheckBox includeCheck;

	private InstructionReturnFollowUpInputController instructionReturnFollowUpInputController;

	public void setInstructionReturnFollowUpInputController(
			InstructionReturnFollowUpInputController instructionReturnFollowUpInputController) {
		this.instructionReturnFollowUpInputController = instructionReturnFollowUpInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionReturnFollowUpInputController.str);
			acupunctureReferalStr.append("\n\n ");
			instructionReturnFollowUpInputController.str = acupunctureReferalStr.toString();

			
				if (howManyText.getText().length() > 0) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("I recommended follow-up in "+howManyText.getText());
					instructionReturnFollowUpInputController.str = str11.toString();

				}

				if (day.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" day.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				if (days.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" days.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				if (week.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" week.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				if (weeks.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" weeks.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				if (month.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" month.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				if (months.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" months.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (year.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" year.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (years.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" years.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}
				++instructionReturnFollowUpInputController.formCount;
				instructionReturnFollowUpInputController.setWorkStatusUI();
				new FXFormCommonUtilities().closeForm(doneBtn);

			});

		skipBtn.setOnAction((event) -> {
				try {

					++instructionReturnFollowUpInputController.formCount;
					instructionReturnFollowUpInputController.setWorkStatusUI();
					new FXFormCommonUtilities().closeForm(skipBtn);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

		}

	}
