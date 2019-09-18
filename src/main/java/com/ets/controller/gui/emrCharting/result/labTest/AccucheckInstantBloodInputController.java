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

public class AccucheckInstantBloodInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea descriptionTextarea;

    @FXML
    private TextField mealTimeText;

    @FXML
    private TextField glucoseTimeText;

    @FXML
    private TextField glucoseMeasurementText;

    @FXML
    private DatePicker mealDate;
    
    private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder resultStr = new StringBuilder(resultInputController.str);
			resultStr.append("\n\nAccucheck/Instant Blood Glucose was performed on patient. ");
			resultInputController.str = resultStr.toString();

			
			if (mealDate.getValue() != null) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nDate of patient's last meal was: " +mealDate.getValue() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (mealTimeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTime of patient's last meal was: " +mealTimeText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (descriptionTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nThe patient's last meal consisted of " +descriptionTextarea.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (glucoseTimeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTime Accucheck/Instant Blood Glucose Tested: " +glucoseTimeText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (glucoseMeasurementText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nGlucose result measured " +glucoseMeasurementText.getText() +" mg/dL.");
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