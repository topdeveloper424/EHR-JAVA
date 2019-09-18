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

public class ExecutivePhysicalLaboratoryInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField totalText;

	    @FXML
	    private TextField numericalText;

	    @FXML
	    private RadioButton normalRadio;

	    @FXML
	    private ToggleGroup nor;

	    @FXML
	    private RadioButton abnormalRadio;

	    @FXML
	    private RadioButton choNormalRadio;

	    @FXML
	    private ToggleGroup cho;

	    @FXML
	    private RadioButton choOutrangeRadio;
	    
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

			
			if (totalText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTotal Cholesterol Results: " +totalText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (normalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("HDL Cholesterol 'Good Cholesterol' Results: Normal. \nHDL Cholesterol 'Good Cholesterol' Recommendations: less than 40mg % for men, 50mg for women.");
				resultInputController.str = str1.toString();
				
				
				
			}if (abnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("HDL Cholesterol 'Good Cholesterol' Results: Normal. \nHDL Cholesterol 'Good Cholesterol' Recommendations: less than 40mg % for men, 50mg for women.");
				resultInputController.str = str1.toString();
				
			}
			
			
			if (numericalText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Cholesterol Results: " +numericalText.getText());
				resultInputController.str = str1.toString();

			}
			
			
			if (choNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Normal " +"\nCholesterol Recommendations: Less than 200 mg/dl.  "
						+ "Cholesterol and LDL (below) increase risk of heart disease.  "
						+ "Eat oatmeal or oat bran for breakfast, fish instead of meat 2 or three times a week."
						+ " Reduce weight. Increase exercise.");
				resultInputController.str = str1.toString();

			}if (choOutrangeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" Out of range " +"\nCholesterol Recommendations: Less than 200 mg/dl. "
						+ " Cholesterol and LDL (below) increase risk of heart disease. "
						+ " Eat oatmeal or oat bran for breakfast, fish instead of meat 2 or three times a week."
						+ " Reduce weight. Increase exercise.");
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