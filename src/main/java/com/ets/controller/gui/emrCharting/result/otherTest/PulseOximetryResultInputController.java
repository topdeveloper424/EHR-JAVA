package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
public class PulseOximetryResultInputController implements Initializable {
	
	 @FXML
	    private Button okbtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton roomRadio;

	    @FXML
	    private ToggleGroup car;

	    @FXML
	    private RadioButton suppleRadio;

	    @FXML
	    private TextField pulseText;

	    @FXML
	    private TextField oxygenText;

	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		okbtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\nPulse Oximetry results were as followed: ");
			resultInputController.str = procedureStr.toString();

			
			
			if (pulseText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Pulse:"+pulseText.getText() +" bpm .");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (oxygenText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Oxygen Saturation: "+oxygenText.getText() +"%.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (roomRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Oxygen saturation was checked on Room-Air");
				resultInputController.str = str1.toString();

			}if (suppleRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Oxygen saturation was checked on Supplemental O2");
				resultInputController.str = str1.toString();

			}

			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(okbtn);
			

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
