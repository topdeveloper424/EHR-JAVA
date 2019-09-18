package com.ets.controller.gui.emrCharting.result.labTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class InfluenzaTestInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton anegativeRadio;

	    @FXML
	    private ToggleGroup a;

	    @FXML
	    private RadioButton apossitiveRadio;

	    @FXML
	    private RadioButton bnegativeRadio;

	    @FXML
	    private ToggleGroup b;

	    @FXML
	    private RadioButton bpossitiveRadio;
	    
	    private ResultInputController resultInputController;

		public void setResultInputController(ResultInputController resultInputController) {
			this.resultInputController = resultInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\nA Rapid Influenza Test was performed on patient.  Results as follows: ");
			resultInputController.str = procedureStr.toString();

			

			if (anegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRapid Influenza A Test Results: Negative. ");
				resultInputController.str = str1.toString();

			}if (apossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRapid Influenza A Test Results: Possitive. ");
				resultInputController.str = str1.toString();
				
			}
			
					
			if (bnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRapid Influenza B Test Results: Negative. ");
				resultInputController.str = str1.toString();

			}if (bpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRapid Influenza B Test Results: positive. ");
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