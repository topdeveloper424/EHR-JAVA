package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OrthostaticBPPulseResultInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField supineBloodText;

    @FXML
    private TextField supinePulseText;

    @FXML
    private TextField sittingBloodText;

    @FXML
    private TextField sittingPulseText;

    @FXML
    private TextField standingBpText;

    @FXML
    private TextField standingPulseText;

	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\nOrthostatic BP/Pulse Results:  ");
			resultInputController.str = procedureStr.toString();

			
			
			if (supineBloodText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Supine BP :"+supineBloodText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (supinePulseText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Supine Pulse :"+supinePulseText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (sittingBloodText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Sitting BP: "+sittingBloodText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (sittingPulseText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Sitting Pulse: "+sittingPulseText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (standingBpText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Standing BP:"+standingBpText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (standingPulseText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Standing Pulse:"+standingPulseText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			

			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}

