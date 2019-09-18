package com.ets.controller.gui.emrCharting.result.labTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HgbA1CResultInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea freeFormTextarea;

    @FXML
    private TextField hgReultText;

    @FXML
    private RadioButton normalRadio;

    @FXML
    private ToggleGroup hg;

    @FXML
    private RadioButton abnormalRadio;

    @FXML
    private DatePicker dateField;
	    
	    private ResultInputController resultInputController;

		public void setResultInputController(ResultInputController resultInputController) {
			this.resultInputController = resultInputController;
		}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			

			if (normalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("HGB A1c Results: Normal");
				resultInputController.str = str1.toString();

			}if (abnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("HGB A1c Results: Abnormal");
				resultInputController.str = str1.toString();
				
			}
		
			
			if (dateField.getValue() != null) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" on" +dateField.getValue() +".");
				resultInputController.str = str1.toString();

			}
			
			if (hgReultText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nHgbA1c: " +hgReultText.getText() +"%");
				resultInputController.str = str1.toString();

			}
			
			
			if (freeFormTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +freeFormTextarea.getText() +".");
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