package com.ets.controller.gui.emrCharting.instruction.returnFollowup;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PcpUrgentCareInputController  implements Initializable{
	   @FXML
	    private RadioButton week3;

	    @FXML
	    private ToggleGroup level;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton day1;

	    @FXML
	    private RadioButton day2;

	    @FXML
	    private RadioButton week1;

	    @FXML
	    private RadioButton day4;

	    @FXML
	    private RadioButton day3;

	    @FXML
	    private RadioButton week2;

	    @FXML
	    private ToggleGroup level1;
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

			
				if (day1.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 1 day .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}

				if (day2.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 2 days .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (day3.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 3 days .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (day4.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 4 days .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (week1.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 1 week .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (week2.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 2 week .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (week3.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Patient advised to follow up with their Primary Care Physician (PCP) within 3 week .  If symptoms worsen before PCP visit return to the clinic immediately.  If symptoms are severe,  go to the nearest emergency room.");
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
