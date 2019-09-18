package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PFTResultInputController implements Initializable {
	
	 @FXML
	    private CheckBox normalChexk;

	    @FXML
	    private Button okbtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextArea freeTextArea;

	    @FXML
	    private CheckBox obstructionChexk;

	    @FXML
	    private CheckBox restrictionChexk;

	    @FXML
	    private CheckBox decreasedChexk;

	
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

			
			
			if (normalChexk.isSelected() || obstructionChexk.isSelected()
						|| restrictionChexk.isSelected() || decreasedChexk.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("A Pulmonary Function Test (PFT) was performed in the office and showed: ");
				resultInputController.str = str.toString();
				
				if (normalChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Normal, ");
					resultInputController.str = str1.toString();

				}if (obstructionChexk.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Obstruction, ");
					resultInputController.str = str1.toString();
					
				}if (restrictionChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Restriction, ");
					resultInputController.str = str1.toString();

				}if (decreasedChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Decreased Lung Volumes, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			if (freeTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nResults are attached (scanned). " +freeTextArea.getText() +".");
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
