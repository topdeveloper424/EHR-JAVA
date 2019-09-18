package com.ets.controller.gui.emrCharting.instruction.returnFollowup;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ReturnForFollowUpAfterInjuryInputController  implements Initializable{
    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField followupText;

    @FXML
    private TextField fuOccHealthText;
    
    @FXML 
   private CheckBox include;
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

			
				if (include.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("Follow up as needed if not improving,");
					instructionReturnFollowUpInputController.str = str11.toString();

				}

				if (followupText.getText().length() > 0) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append("  Follow up "+followupText.getText()+".");
					instructionReturnFollowUpInputController.str = str11.toString();

				}if (fuOccHealthText.getText().length() > 0) {

					StringBuilder str11 = new StringBuilder(instructionReturnFollowUpInputController.str);
					str11.append(" Follow up with the occupational health team "+fuOccHealthText.getText()+".");
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
