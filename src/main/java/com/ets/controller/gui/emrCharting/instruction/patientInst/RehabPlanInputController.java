package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class RehabPlanInputController  implements Initializable {

    @FXML
    private AnchorPane planText;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private Label planTextArea;

    @FXML
    private TextArea plan;
	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;


	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionPatientInstInputCotroller.str);
			acupunctureReferalStr.append("\n\n ");
			instructionPatientInstInputCotroller.str = acupunctureReferalStr.toString();

			
				if (plan.getText().length() > 0) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Plan -  "+plan.getText()+ " .");
					instructionPatientInstInputCotroller.str = str11.toString();

				}

				

				++instructionPatientInstInputCotroller.formCount;
				instructionPatientInstInputCotroller.setPatInstUI();
				new FXFormCommonUtilities().closeForm(doneBtn);

			});

			skipBtn.setOnAction((event) -> {
				try {

					++instructionPatientInstInputCotroller.formCount;
					instructionPatientInstInputCotroller.setPatInstUI();
					new FXFormCommonUtilities().closeForm(skipBtn);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

		}

	}
