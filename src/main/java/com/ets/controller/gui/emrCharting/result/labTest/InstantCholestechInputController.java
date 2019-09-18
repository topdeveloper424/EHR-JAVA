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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class InstantCholestechInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea freeFormTextTextarea;

    @FXML
    private TextField glucoseText;

    @FXML
    private TextField cholesterolText;

    @FXML
    private TextField TriglyceridesText;

    @FXML
    private TextField ldlText;

    @FXML
    private TextField hdlText;

    @FXML
    private TextField hdlRatioText;
    
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

			

			
			if (glucoseText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nCholestech glucose result " +glucoseText.getText() +" (normal is less than 99).");
				resultInputController.str = str1.toString();

			}
			
			if (cholesterolText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nCholestech total cholesterol is " +cholesterolText.getText() +" (normal is less than 150). ");
				resultInputController.str = str1.toString();

			}
			
			if (TriglyceridesText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTriglycerides " +TriglyceridesText.getText() +". ");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (ldlText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("LDL " +ldlText.getText() +". ");
				resultInputController.str = str1.toString();

			}
			
			
			if (hdlText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("HDL " +hdlText.getText() +". ");
				resultInputController.str = str1.toString();

			}
			
			if (hdlRatioText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTotal Cholesterol/HDL Ratio " +hdlRatioText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (freeFormTextTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +freeFormTextTextarea.getText() +".");
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