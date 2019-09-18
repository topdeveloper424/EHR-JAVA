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

public class ErgonomicAssessmentInputController implements Initializable {
	
	
	 @FXML
	    private CheckBox normalChexk;

	    @FXML
	    private Button okbtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextArea summaryTextArea;
	
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		okbtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			if (normalChexk.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("Ergonomic assessment report is available for review. No changes were recommended.");
				resultInputController.str = str.toString();
				
		

			}else{
				
				if (summaryTextArea.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Ergonomic assessment report is available for review. Summary of recommendations: "+summaryTextArea.getText() +".");
					resultInputController.str = str1.toString();

				}
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
