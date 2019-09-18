package com.ets.controller.gui.emrCharting.instruction.returnFollowup;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EmergencyRoomInputController implements Initializable{

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField patientSentText;
	
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

			
				if (patientSentText.getText().length() > 0) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" Patient sent to "+patientSentText.getText()+ "  hospital for immediate emergency care.");
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
