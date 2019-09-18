package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PFTPrePostInputController implements Initializable {
	
	
	@FXML
    private Button okbtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea freeTextArea;

    @FXML
    private TextField peakText;

    @FXML
    private TextField fvc1PreText;

    @FXML
    private TextField fvc1PostText;

    @FXML
    private TextField fev1PreText;

    @FXML
    private TextField fev1PostText;

	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		okbtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			if (peakText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("This is the Peak flow before the nebulizer "+peakText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (fvc1PreText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" FVC1  Pre-Nebulizer result "+fvc1PreText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (fvc1PostText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("FVC1 Post-Nebulizer Treatment result  "+fvc1PostText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (fev1PreText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("FEV1 Pre-Nebulizer result "+fev1PreText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (fev1PostText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" FEV1 Post-Nebulizer Treatment result "+fev1PostText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (freeTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(freeTextArea.getText() +".");
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
